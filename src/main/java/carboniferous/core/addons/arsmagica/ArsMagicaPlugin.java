package carboniferous.core.addons.arsmagica;

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
public class ArsMagicaPlugin {

    private static final String MOD_ID   = "ArsMagica";
    private static final String MOD_NAME = "Ars Magica";
    private Optional<ArsMagicaApi> api = Optional.absent();

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
        if (!Loader.isModLoaded(MOD_ID)) {
        	return;
        }
        LogHelper.log(Level.INFO, "Loading " + MOD_NAME + " Addon");
        try {
            api = Optional.of(new ArsMagicaApi());
        } 
        catch (final Exception ex) {
            ex.printStackTrace();
            LogHelper.log(Level.WARNING, "Failed to load " + MOD_NAME + " Addon");
            api = Optional.absent();
        }
    }

}
