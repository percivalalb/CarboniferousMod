package carboniferous.core.handlers;

import carboniferous.ModBlocks;
import carboniferous.block.BlockLeaves;
import carboniferous.core.addons.optifine.OptifinePlugin;
import carboniferous.core.helper.VersionHelper;
import carboniferous.core.helper.VersionHelper.UpdateType;
import carboniferous.core.teleporters.TeleportClient;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.ClientTickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.RenderTickEvent;
import cpw.mods.fml.relauncher.Side;

/**
 * @author ProPercivalalb
 **/
public class ClientTickHandler {
	
	public static Minecraft mc = Minecraft.getMinecraft();
	public static boolean checkedVersion = false;

	@SubscribeEvent
	public void clientTick(ClientTickEvent event) {
		if(event.phase != Phase.END || event.side != Side.CLIENT)
			return;

		TeleportClient.onTick(mc.thePlayer);
		
		if(this.mc.currentScreen != null) {
			int setting = 0;
			if(OptifinePlugin.hasTreeSetting())
				setting = OptifinePlugin.getTreeSetting();

			boolean fancyGraphics = (setting == 0 ? this.mc.gameSettings.fancyGraphics : (setting == 1 ? false : setting == 2));
			((BlockLeaves)ModBlocks.leaves_1).setGraphicsLevel(fancyGraphics);
		}
		else {
			if(!checkedVersion && this.mc.thePlayer != null) {
          		VersionHelper.checkVersion(UpdateType.COLOURED);
          		checkedVersion = true;
          	}	 
		}
	}
}