package carboniferous.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import carboniferous.network.IPacket;
import carboniferous.tileentity.TileEntityWallShell;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * @author ProPercivalalb
 **/
public class PacketWallShell extends IPacket {

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
	public void read(DataInputStream data) throws IOException {
		this.x = data.readInt();
		this.y = data.readInt();
		this.z = data.readInt();
		this.shell = data.readUTF();
		this.meta = data.readInt();
	}

	@Override
	public void write(DataOutputStream data) throws IOException {
		data.writeInt(this.x);
		data.writeInt(this.y);
		data.writeInt(this.z);
		data.writeUTF(this.shell);
		data.writeInt(this.meta);
	}

	@Override
	public void execute(EntityPlayer player) {
		World world = player.worldObj;
		
		TileEntity tileEntity = world.getTileEntity(this.x, this.y, this.z);
		
		if(tileEntity instanceof TileEntityWallShell) {
			TileEntityWallShell wallShell = (TileEntityWallShell)tileEntity;
			wallShell.setShell(this.shell, this.meta);
		}
	}

}
