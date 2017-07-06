package carboniferous.handler;

import carboniferous.ModBlocks;
import carboniferous.addon.optifine.OptifinePlugin;
import carboniferous.block.BlockCarboniferousLeaves;
import carboniferous.teleporters.TeleportClient;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @author ProPercivalalb
 **/
@SideOnly(value = Side.CLIENT)
public class ClientTick {

	@SubscribeEvent
	public void clientTick(ClientTickEvent event) {
		
		if(event.phase == Phase.START && event.side == Side.CLIENT) {
			
			Minecraft mc = Minecraft.getMinecraft();
			
			TeleportClient.INSTANCE.onTick();
			
				int setting = OptifinePlugin.getTreeSetting();
				boolean fancyGraphics = (setting == 0 ? mc.gameSettings.fancyGraphics : (setting == 1 ? false : setting == 2));
				((BlockCarboniferousLeaves)ModBlocks.LEAVES_0).setGraphicsLevel(fancyGraphics);
			
		}
	}
}