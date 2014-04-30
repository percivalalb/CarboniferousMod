package carboniferous.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import carboniferous.core.teleporters.TeleportClient;
import carboniferous.network.IPacket;

/**
 * @author ProPercivalalb
 **/
public class PacketTeleport extends IPacket {

	@Override
	public void read(DataInputStream data) throws IOException {
		
	}

	@Override
	public void write(DataOutputStream data) throws IOException {
		
	}

	@Override
	public void execute(EntityPlayer player) {
		TeleportClient.timeInPortal = 0;
		TeleportClient.prevTimeInPortal = 0;
		TeleportClient.inPortal = false;
		TeleportClient.timeUntilPortal = 20;
	}

}
