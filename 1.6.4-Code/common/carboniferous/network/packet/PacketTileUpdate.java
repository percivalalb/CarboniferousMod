package carboniferous.network.packet;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

import carboniferous.CarboniferousMod;
import carboniferous.core.teleporters.TeleportClient;
import carboniferous.network.IPacket;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraftforge.common.ForgeDirection;

/**
 * @author ProPercivalalb
 **/
public class PacketTileUpdate implements IPacket {

	@Override
	public void handle(INetworkManager manager, Packet250CustomPayload packet, EntityPlayer p) {
		try {
			ByteArrayInputStream bis = new ByteArrayInputStream(packet.data);
	        DataInputStream data = new DataInputStream(bis);
	        int x = data.readInt();
	        int y = data.readInt();
	        int z = data.readInt();
		    String owner = data.readUTF();
		    String customName = data.readUTF();
		    ForgeDirection direction = ForgeDirection.getOrientation(data.readInt());
		    String state = data.readUTF();
		    CarboniferousMod.proxy.handleTileEntityPacket(x, y, z, direction, owner, customName, state);
        }
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
