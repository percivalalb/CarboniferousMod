package carboniferous.teleporters;

import java.util.Random;

import carboniferous.api.CarboniferousModAPI;
import carboniferous.network.PacketDispatcher;
import carboniferous.network.packet.client.PacketTeleport;
import carboniferous.world.TeleporterCarboniferous;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;

/**
 * @author ProPercivalalb
 **/
public class TeleportServer extends TeleportBase {
	
	private EntityPlayerMP player;
	
	public TeleportServer(EntityPlayerMP player) {
		this.player = player;
	}
	
	public EntityPlayerMP getPlayer() {
		return this.player;
	}

	@Override
	public void onTickInPortal() {
		
		
	}

	@Override
	public void onTeleport() {
		this.timeInPortal = 1.0F;
        this.timeUntilPortal = 10;

		int dimension = CarboniferousModAPI.DIMENSION_TYPE.getId();
        if(this.player.dimension == CarboniferousModAPI.DIMENSION_TYPE.getId())
        	dimension = 0;
		
        MinecraftServer mcServer = this.player.mcServer;
        
        PacketDispatcher.sendTo(new PacketTeleport(), this.player);
        mcServer.getPlayerList().transferPlayerToDimension(this.player, dimension, new TeleporterCarboniferous(mcServer.getWorld(dimension)));
		
	}
	
}