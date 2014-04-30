package carboniferous.core.teleporters;

import java.util.Random;

import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.src.*;

/**
 * @author ProPercivalalb
 **/
public class TeleportClient {
	
	public static float prevTimeInPortal;
	public static float timeInPortal;
	public static boolean inPortal = false;
	public static Random random = new Random();
	public static Minecraft mc = FMLClientHandler.instance().getClient();
	public static int timeUntilPortal = 20;
	
	public static void onTick(EntityPlayer player) {
        prevTimeInPortal = timeInPortal;

        if (inPortal) {
            if (mc.currentScreen != null) {
                mc.displayGuiScreen((GuiScreen)null);
            }
            timeInPortal += 0.0125F;
            if (timeInPortal >= 1.0F) {
                timeInPortal = 1.0F;
            }
            inPortal = false;
        }
        else {
            if (timeInPortal > 0.0F) {
                timeInPortal -= 0.05F;
            }

            if (timeInPortal < 0.0F) {
                timeInPortal = 0.0F;
            }
        }
        if (timeUntilPortal > 0) {
            --timeUntilPortal;
        }
	}
	
    public static void setInPortal() {
        if (timeUntilPortal > 0) {
            timeUntilPortal = 10;
        }
        else {
        	inPortal = true;
        }
    }
}