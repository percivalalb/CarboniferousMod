package carboniferous.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import carboniferous.core.teleporters.TeleportClient;
import carboniferous.network.AbstractMessage.AbstractClientMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;

/**
 * @author ProPercivalalb
 **/
public class PacketTeleport extends AbstractClientMessage {
	
	@Override
	protected void read(PacketBuffer buffer) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void write(PacketBuffer buffer) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void process(EntityPlayer player, Side side) {
		TeleportClient.timeInPortal = 0;
		TeleportClient.prevTimeInPortal = 0;
		TeleportClient.inPortal = false;
		TeleportClient.timeUntilPortal = 20;
		
	}

}
