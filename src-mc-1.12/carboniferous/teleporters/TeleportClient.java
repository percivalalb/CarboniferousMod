package carboniferous.teleporters;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.client.FMLClientHandler;

/**
 * @author ProPercivalalb
 **/
public class TeleportClient extends TeleportBase {

	public static final TeleportClient INSTANCE = new TeleportClient();
	
	@Override
	public void onTickInPortal() {
		Minecraft mc = Minecraft.getMinecraft();
		
		if(mc.currentScreen != null)
            mc.displayGuiScreen((GuiScreen)null);
		
	}

	@Override
	public void onTeleport() {
		
	}
}