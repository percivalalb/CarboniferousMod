package carboniferous.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import carboniferous.network.AbstractMessage.AbstractClientMessage;
import carboniferous.tileentity.TileEntityWallShell;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * @author ProPercivalalb
 **/
public class PacketWallShell extends AbstractClientMessage {

	public int x, y, z;
	public String shell;
	public int meta;
	
	public PacketWallShell() {}
	public PacketWallShell(int x, int y, int z, String shell, int meta) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.shell = shell;
		this.meta = meta;
	}

	@Override
	public void read(PacketBuffer buffer) throws IOException {
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
		this.shell = buffer.readStringFromBuffer(1000);
		this.meta = buffer.readInt();
	}

	@Override
	public void write(PacketBuffer buffer) throws IOException {
		buffer.writeInt(this.x);
		buffer.writeInt(this.y);
		buffer.writeInt(this.z);
		buffer.writeStringToBuffer(this.shell);
		buffer.writeInt(this.meta);
	}

	@Override
	public void process(EntityPlayer player, Side side) {
		World world = player.worldObj;
		
		TileEntity tileEntity = world.getTileEntity(this.x, this.y, this.z);
		
		if(tileEntity instanceof TileEntityWallShell) {
			TileEntityWallShell wallShell = (TileEntityWallShell)tileEntity;
			wallShell.setShell(this.shell, this.meta);
		}
	}
	
}
