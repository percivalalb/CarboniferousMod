package carboniferous.core.addons.thermalexpansion;

import java.util.Collection;
import java.util.logging.Level;

import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

import carboniferous.CarboniferousMod;
import carboniferous.ModBlocks;
import carboniferous.api.Properties;
import carboniferous.core.helper.LogHelper;
import carboniferous.core.addons.PluginEvent;

import com.google.common.base.Optional;
import com.google.common.collect.Lists;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * @author ProPercivalalb
 **/
public class ThermalExpansionPlugin {

    private static final String MOD_ID   = "ThermalExpansion";
    private static final String MOD_NAME = "Thermal Expansion";
    private Optional<ThermalExpansionApi> api = Optional.absent();

    @SubscribeEvent
    public void init(PluginEvent.Init event) {
        if (!api.isPresent()) {
        	return;
        }
    
        for(int var1 = 0; var1 < 4; ++var1) {
        	api.get().addSawmillLogToPlankRecipe(new ItemStack(ModBlocks.logs_1, 1, var1), new ItemStack(ModBlocks.planks_1, 6, var1));
        } 
    }

    @SubscribeEvent
    public void postInit(PluginEvent.Post event) {
        api = Optional.absent();
    }

    @SubscribeEvent
    public void preInit(PluginEvent.Pre event) {
        if (!Loader.isModLoaded(MOD_ID)) {
        	return;
        }
        LogHelper.log(Level.INFO, "Loading " + MOD_NAME + " Addon");
        try {
            api = Optional.of(new ThermalExpansionApi());
        } 
        catch (final Exception ex) {
            ex.printStackTrace();
            LogHelper.log(Level.WARNING, "Failed to load " + MOD_NAME + " Addon");
            api = Optional.absent();
        }
    }

}
