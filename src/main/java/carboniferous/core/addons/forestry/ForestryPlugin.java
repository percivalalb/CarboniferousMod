package carboniferous.core.addons.forestry;

import java.util.Collection;
import java.util.logging.Level;

import com.google.common.base.Optional;

import carboniferous.api.Properties;
import carboniferous.core.helper.LogHelper;
import carboniferous.core.addons.PluginEvent;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ForestryPlugin {

    private static final String MOD_ID   = "Forestry";
    private static final String MOD_NAME = "Forestry";
    private Optional<ForestryApi> api = Optional.absent();

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
        LogHelper.log(Level.INFO, "Loaded " + MOD_NAME + " Addon");
        try {
            api = Optional.of(new ForestryApi());
        } 
        catch (Exception ex)  {
            LogHelper.log(Level.WARNING, "Failed to load " + MOD_NAME + " Addon" );
            api = Optional.absent();
        }
    }

}
