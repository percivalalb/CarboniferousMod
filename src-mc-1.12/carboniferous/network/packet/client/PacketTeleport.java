package carboniferous.network.packet.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import carboniferous.network.AbstractMessage.AbstractClientMessage;
import carboniferous.teleporters.TeleportClient;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;

/**
 * @author ProPercivalalb
 **/
public class PacketTeleport extends AbstractClientMessage {
	
	@Override
	protected void read(PacketBuffer buffer) throws IOException {
		
	}

	@Override
	protected void write(PacketBuffer buffer) throws IOException {
		
	}

	@Override
	public void process(EntityPlayer player, Side side) {
		TeleportClient.INSTANCE.timeInPortal = 0;
		TeleportClient.INSTANCE.prevTimeInPortal = 0;
		TeleportClient.INSTANCE.inPortal = false;
		TeleportClient.INSTANCE.timeUntilPortal = 20;
	}

}
