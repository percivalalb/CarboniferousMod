package carboniferous.core.addons.optifine;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;

import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.MinecraftForge;

import carboniferous.CarboniferousMod;
import carboniferous.ModBlocks;
import carboniferous.api.Properties;
import carboniferous.world.biome.BiomeGenBaseCarboniferous;
import carboniferous.core.helper.LogHelper;
import carboniferous.core.addons.PluginEvent;

import com.google.common.base.Optional;
import com.google.common.collect.Lists;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

/**
 * @author ProPercivalalb
 **/
public class OptifinePlugin {

	public static final String TREE_SETTING_NAME = "ofTrees";
    private static final String MOD_NAME = "Optifine";
    private static Optional<OptifineApi> api = Optional.absent();
    
    public static boolean hasTreeSetting() {
    	if(!api.isPresent()) {
    		return false;
    	}
    	return api.get().hasTreeSetting;
    }
    
    public static int getTreeSetting() {
    	if(!api.isPresent()) {
    		return 0;
    	}
    	return api.get().getTreeSetting();
    }
    
    @SubscribeEvent
    public void init(PluginEvent.Init event) {
        if (!api.isPresent()) {
        	return;
        }
    }
    
    @SubscribeEvent
    public void postInit(PluginEvent.Post event) {
        api = Optional.absent();
    }

    @SubscribeEvent
    public void preInit(PluginEvent.Pre event) {
        if (!FMLClientHandler.instance().hasOptifine()) {
        	return;
        }
        LogHelper.log(Level.INFO, "Loaded " + MOD_NAME + " Addon");
        try {
            api = Optional.of(new OptifineApi());
        } 
        catch (Exception ex)  {
            LogHelper.log(Level.WARNING, "Failed to load " + MOD_NAME + " Addon" );
            api = Optional.absent();
        }
    }

}
