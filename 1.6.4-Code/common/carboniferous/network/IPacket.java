package carboniferous.network;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;

/**
 * @author ProPercivalalb
 **/
public interface IPacket {

	/** Called in the main packet handler class **/
	public void handle(INetworkManager manager, Packet250CustomPayload packet, EntityPlayer player);
}
