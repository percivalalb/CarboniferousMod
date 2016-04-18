package carboniferous.core.handlers;

import java.util.HashMap;

import carboniferous.core.teleporters.TeleportServer;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

/**
 * @author ProPercivalalb
 **/
public class ConnectionHandler {

	public HashMap<String, TeleportServer> serverPlayers = new HashMap<String, TeleportServer>();
	
	public void onTick(EntityPlayer player) {
		getPlayer(player.getCommandSenderName()).onTick();
	}
	
	public TeleportServer getPlayer(String username) {
		return serverPlayers.get(username);
	}
	
	public void addPlayer(TeleportServer player) {
		serverPlayers.put(player.getPlayer().getCommandSenderName(), player);
	}
	
	@SubscribeEvent
	public void login(PlayerLoggedInEvent event) {
		if(event.player instanceof EntityPlayerMP)
			addPlayer(new TeleportServer((EntityPlayerMP)event.player));	
	}

}
