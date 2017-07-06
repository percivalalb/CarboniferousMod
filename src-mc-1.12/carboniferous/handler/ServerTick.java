package carboniferous.handler;

import carboniferous.Carboniferous;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.minecraftforge.fml.relauncher.Side;

/**
 * @author ProPercivalalb
 */
public class ServerTick {

	@SubscribeEvent
	public void playerTick(PlayerTickEvent event) {
		if(event.phase == Phase.START && event.side == Side.SERVER) {
		
			Carboniferous.PROXY.SERVER_TELEPORT.onTick(event.player);
		}
	}
}
