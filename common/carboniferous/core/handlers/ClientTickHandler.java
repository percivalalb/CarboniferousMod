package carboniferous.core.handlers;

import java.util.EnumSet;
import java.util.logging.Level;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiVideoSettings;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.util.Icon;

import org.lwjgl.opengl.GL11;

import carboniferous.CarboniferousMod;
import carboniferous.ModBlocks;
import carboniferous.api.Properties;
import carboniferous.block.BlockLeaves;
import carboniferous.core.addons.optifine.OptifinePlugin;
import carboniferous.core.helper.LogHelper;
import carboniferous.core.helper.VersionHelper;
import carboniferous.core.helper.VersionHelper.Type;
import carboniferous.core.teleporters.TeleportClient;
import carboniferous.lib.Reference;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

/**
 * @author ProPercivalalb
 **/
public class ClientTickHandler implements ITickHandler {
	
	public static Minecraft mc = Minecraft.getMinecraft();
	private int jumpTick;
	private boolean prevRideableStill;
	public static float particleTicks;
	public static boolean checkedVersion = false;
	
    @Override
    public void tickStart(EnumSet<TickType> type, Object... tickData) {}

    @Override
    public void tickEnd(EnumSet<TickType> type, Object... tickData) {
        if (type.equals(EnumSet.of(TickType.RENDER))) {
            onRenderTick();
        	float ticks1 = ((Float)tickData[0]).floatValue();
        	particleTicks = ticks1;
            onRenderTickEnd(ticks1);
        }
        else if (type.equals(EnumSet.of(TickType.CLIENT))) {
            GuiScreen guiscreen = Minecraft.getMinecraft().currentScreen;
            if (guiscreen != null) {
                onTickInGUI(guiscreen);
            } 
            else {
                onTickInGame();
            }
        }
        else if (type.equals(EnumSet.of(TickType.PLAYER))) {
        	EntityPlayer player = (EntityPlayer)tickData[0];
        	teleportTick(player);
        }
        
    }

    @Override
    public EnumSet<TickType> ticks() {
        return EnumSet.of(TickType.RENDER, TickType.CLIENT, TickType.PLAYER, TickType.WORLD);
    }

    @Override
    public String getLabel() {
    	return Reference.MOD_ID + "(Client)";
    }

    public void onRenderTick() {
    	
    }

    public void onRenderTickEnd(float ticks) {
    	float time = TeleportClient.prevTimeInPortal + (TeleportClient.timeInPortal - TeleportClient.prevTimeInPortal) * ticks;
    	if (time > 0.0F && TeleportClient.mc.currentScreen == null) {
           
        }
    	else {
        	if (TeleportClient.mc.thePlayer != null) {
        		TeleportClient.mc.thePlayer.removePotionEffect(Potion.confusion.id);
    		}  
    	}
    }

    public void onTickInGUI(GuiScreen guiscreen) {
		int ofSetting = 0;
    	if(OptifinePlugin.hasTreeSetting()) {
    		ofSetting = OptifinePlugin.getTreeSetting();
    	}

    	boolean fancyGraphics = (ofSetting == 0 ? this.mc.gameSettings.fancyGraphics : 
    							(ofSetting == 1 ? false : 
    								(ofSetting == 2 ? true : false)));
    	((BlockLeaves)ModBlocks.leaves_1).setGraphicsLevel(fancyGraphics);
    }

    public void onTickInGame() {
    	onTick(mc);
    }
       
    public void onTick(Minecraft mc) {   
    	if(!checkedVersion && mc.thePlayer != null) {
    		VersionHelper.checkVersion(Type.COLOURED);
    		checkedVersion = true;
    	}
    }
    
    public void teleportTick(EntityPlayer player) {
    	TeleportClient.onTick(player);
    } 
}