package carboniferous.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import carboniferous.network.AbstractMessage.AbstractClientMessage;
import carboniferous.tileentity.TileEntityGrinder;
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
public class PacketGrindSound extends AbstractClientMessage {

	public int x, y, z;
	
	public PacketGrindSound() {}
	public PacketGrindSound(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	protected void read(PacketBuffer buffer) throws IOException {
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}
	
	@Override
	protected void write(PacketBuffer buffer) throws IOException {
		buffer.writeInt(this.x);
		buffer.writeInt(this.y);
		buffer.writeInt(this.z);
	}
	
	@Override
	public void process(EntityPlayer player, Side side) {
		World world = player.worldObj;
		
		TileEntity tileEntity = world.getTileEntity(this.x, this.y, this.z);
		
		if(tileEntity instanceof TileEntityGrinder) {
			TileEntityGrinder grinder = (TileEntityGrinder)tileEntity;
			grinder.clientSpinTime = 0;
		}
		
	}

}
