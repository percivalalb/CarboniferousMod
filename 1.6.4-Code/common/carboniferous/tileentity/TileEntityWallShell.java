package carboniferous.tileentity;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraftforge.common.ForgeDirection;
import carboniferous.api.Properties;

/**
 * @author ProPercivalalb
 **/
public class TileEntityWallShell extends TileEntityCarboniferous {

	private int shellId = 0;
	private int shellMeta = 0;
	
	@Override
    public Packet getDescriptionPacket() {
    	try {
   		 	Packet250CustomPayload pack = new Packet250CustomPayload();
   		 	ByteArrayOutputStream bytes = new ByteArrayOutputStream();
   		 	DataOutputStream data = new DataOutputStream(bytes);
    		data.writeInt(xCoord);
    	    data.writeInt(yCoord);
    	    data.writeInt(zCoord);
    	    data.writeInt(shellId);
    	    data.writeInt(shellMeta);
    	    pack.channel = Properties.PACKET_WALL_SHELL;
    	    pack.data = bytes.toByteArray();
    	    pack.length = bytes.size();
    		return pack;
    	}
    	catch(Exception e) {
    		return null;
    	}
    }
	
	@Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {
        super.readFromNBT(nbtTagCompound);
        this.setShellIdAndMeta(nbtTagCompound.getInteger("shellID"), nbtTagCompound.getInteger("shellMeta"));
    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound) {
        super.writeToNBT(nbtTagCompound);
        nbtTagCompound.setInteger("shellID", this.getShellID());
        nbtTagCompound.setInteger("shellMeta", this.getShellMetadata());
    }
	
	@Override
	public boolean shouldSendUpdates() {
		return true;
	}

	public int getShellID() {
		return this.shellId;
	}
	
	public int getShellMetadata() {
		return this.shellMeta;
	}
	
	public void setShellIdAndMeta(int id, int metadata) {
		this.shellId = id;
		this.shellMeta = metadata;
	}
}
