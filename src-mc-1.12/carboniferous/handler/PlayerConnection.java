package carboniferous.handler;

import java.util.HashMap;
import java.util.UUID;

import carboniferous.teleporters.TeleportServer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;

/**
 * @author ProPercivalalb
 **/
public class PlayerConnection {

	public HashMap<UUID, TeleportServer> serverPlayers = new HashMap<UUID, TeleportServer>();
	
	public void onTick(EntityPlayer player) {
		getPlayer(player.getUniqueID()).onTick();
	}
	
	public TeleportServer getPlayer(UUID username) {
		return this.serverPlayers.get(username);
	}
	
	public void addPlayer(TeleportServer player) {
		this.serverPlayers.put(player.getPlayer().getUniqueID(), player);
	}
	
	@SubscribeEvent
	public void login(PlayerLoggedInEvent event) {
		if(event.player instanceof EntityPlayerMP)
			this.addPlayer(new TeleportServer((EntityPlayerMP)event.player));	
	}

}
