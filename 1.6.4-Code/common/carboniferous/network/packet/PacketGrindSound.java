package carboniferous.network.packet;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

import carboniferous.api.Properties;
import carboniferous.core.teleporters.TeleportClient;
import carboniferous.network.IPacket;
import carboniferous.tileentity.TileEntityGrinder;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;

import cpw.mods.fml.client.FMLClientHandler;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.tileentity.TileEntity;

/**
 * @author ProPercivalalb
 **/
public class PacketGrindSound implements IPacket {

	@Override
	public void handle(INetworkManager manager, Packet250CustomPayload packet, EntityPlayer p) {
		try {
			ByteArrayInputStream bis = new ByteArrayInputStream(packet.data);
	        DataInputStream data = new DataInputStream(bis);
	        int x = data.readInt();
	        int y = data.readInt();
	        int z = data.readInt();
	        int soundNumber = data.readInt();
	        p.worldObj.playSound(x, y, z, Properties.SOUND_GRIND, 1.0F, p.worldObj.rand.nextFloat() * 0.1F + 0.9F, false);
	        TileEntity tileEntity = FMLClientHandler.instance().getClient().theWorld.getBlockTileEntity(x, y, z);
	        if(tileEntity instanceof TileEntityGrinder) {
	        	((TileEntityGrinder)tileEntity).clientSpinTime = 0;
	        }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
