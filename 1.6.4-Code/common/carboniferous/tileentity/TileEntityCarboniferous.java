package carboniferous.tileentity;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import carboniferous.api.Properties;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

/**
 * @author ProPercivalalb
 **/
public abstract class TileEntityCarboniferous extends TileEntity {

	private String owner;
    protected String customName;
    private ForgeDirection direction;
    private String state;

    public TileEntityCarboniferous() {
        owner = "";
        customName = "";
        state = "";
        direction = ForgeDirection.SOUTH;
    }
    
    /* Block Owner */
    public String getOwner() { return owner; }
    public boolean hasOwner() { return owner != null && owner.length() > 0; }
    public void setOwner(String owner) { this.owner = owner; }

    /* Tile Entity Custom name */
    public boolean isInvNameLocalized() { return customName != null && customName.length() > 0; }
    public String getInvName() { return (this.isInvNameLocalized() ? this.customName : invName()); }
    public void setInvName(String customName) { this.customName = customName; }
    public String invName() {return "";}
    
    /* Block Direction */
    public ForgeDirection getDirection() { return direction; }
    public void setDirection(ForgeDirection newDirection) { this.direction = newDirection; }
    
    /* Block State */
    public String getState() { return state; }
    public void setState(String newState) { this.state = newState; }
    

    public boolean isUseableByPlayer(EntityPlayer player) { return owner.equals(player.username); }

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {
        super.readFromNBT(nbtTagCompound);

        if (nbtTagCompound.hasKey(Properties.NBT_ROTATION)) {
            direction = ForgeDirection.getOrientation(nbtTagCompound.getByte(Properties.NBT_ROTATION));
        }

        if (nbtTagCompound.hasKey(Properties.NBT_STATE)) {
            state = nbtTagCompound.getString(Properties.NBT_STATE);
        }
        
        if (nbtTagCompound.hasKey(Properties.NBT_OWNER_KEY)) {
            owner = nbtTagCompound.getString(Properties.NBT_OWNER_KEY);
        }

        if (nbtTagCompound.hasKey(Properties.NBT_CUSTOM_NAME)) {
            customName = nbtTagCompound.getString(Properties.NBT_CUSTOM_NAME);
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound) {
        super.writeToNBT(nbtTagCompound);

        nbtTagCompound.setByte(Properties.NBT_ROTATION, (byte) direction.ordinal());
        nbtTagCompound.setString(Properties.NBT_STATE, state);
        
        if (hasOwner()) {
            nbtTagCompound.setString(Properties.NBT_OWNER_KEY, owner);
        }

        if (this.isInvNameLocalized()) {
            nbtTagCompound.setString(Properties.NBT_CUSTOM_NAME, customName);
        }
    }

    @Override
    public Packet getDescriptionPacket() {
    	try {
    		if(!shouldSendUpdates()) {
    			return null;
    		}
   		 	Packet250CustomPayload pack = new Packet250CustomPayload();
   		 	ByteArrayOutputStream bytes = new ByteArrayOutputStream();
   		 	DataOutputStream data = new DataOutputStream(bytes);
    		data.writeInt(xCoord);
    	    data.writeInt(yCoord);
    	    data.writeInt(zCoord);
    	    data.writeUTF(owner);
    	    data.writeUTF(customName);
    	    data.writeInt(direction.ordinal());
    	    data.writeUTF(state);
    	    pack.channel = Properties.PACKET_TILE_UPDATE;
    	    pack.data = bytes.toByteArray();
    	    pack.length = bytes.size();
    		return pack;
    	}
    	catch(Exception e) {
    		return null;
    	}
    }
    
    public abstract boolean shouldSendUpdates();
}
