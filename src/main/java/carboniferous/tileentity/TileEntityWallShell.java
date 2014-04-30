package carboniferous.tileentity;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import com.google.common.base.Strings;

import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.tileentity.TileEntity;
import carboniferous.CarboniferousMod;
import carboniferous.api.Properties;
import carboniferous.network.packet.PacketWallShell;

/**
 * @author ProPercivalalb
 **/
public class TileEntityWallShell extends TileEntity {

	private String shell = "";
	private int shellMeta = 0;
	
	@Override
    public Packet getDescriptionPacket() {
    	return new PacketWallShell(this.xCoord, this.yCoord, this.zCoord, this.shell, this.shellMeta).getPacket();
    }
	
	@Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {
        super.readFromNBT(nbtTagCompound);
        this.shell = nbtTagCompound.getString("shell");
        this.shellMeta = nbtTagCompound.getInteger("shellMeta");
    }

    @Override
    public void writeToNBT(NBTTagCompound tag) {
        super.writeToNBT(tag);
        tag.setString("shell", this.getShell());
        tag.setInteger("shellMeta", this.getShellMetadata());
    }

	public String getShell() {
		return this.shell;
	}
	
	public int getShellMetadata() {
		return this.shellMeta;
	}
	
	public Item getShellItem() {
		return (Item)Item.itemRegistry.getObject(getShell());
	}
	
	public boolean hasShell() {
		return !Strings.isNullOrEmpty(this.shell) && getShellItem() != null;
	}
	
	public void setShell(String shell, int metadata) {
		this.shell = shell;
		this.shellMeta = metadata;
	}
	
	public void setShell(Item item, int metadata) {
		this.shell = Item.itemRegistry.getNameForObject(item);
		this.shellMeta = metadata;
	}
}
