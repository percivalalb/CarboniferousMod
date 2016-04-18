package carboniferous.core.addons.arsmagica;

import java.util.logging.Level;

import com.google.common.base.Optional;

import carboniferous.core.addons.PluginEvent;
import carboniferous.core.helper.LogHelper;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

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
