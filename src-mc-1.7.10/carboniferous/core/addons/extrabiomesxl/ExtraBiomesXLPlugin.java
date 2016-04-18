package carboniferous.core.addons.extrabiomesxl;

import java.util.logging.Level;

import com.google.common.base.Optional;

import carboniferous.core.addons.PluginEvent;
import carboniferous.core.helper.LogHelper;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.MinecraftForge;

/**
 * @author ProPercivalalb
 **/
public class ExtraBiomesXLPlugin {

    private static final String MOD_ID   = "ExtrabiomesXL";
    private static final String MOD_NAME = "ExtraBiomes XL";
    private Optional<ExtraBiomesXLApi> api = Optional.absent();

    @SubscribeEvent
    public void init(PluginEvent.Init event) {
        if (!api.isPresent()) {
        	return;
        }

        if(api.get().eventLogTurner.isPresent()) {
        	MinecraftForge.EVENT_BUS.register(new ExtraBiomesXLEvent());
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
            api = Optional.of(new ExtraBiomesXLApi());
        } 
        catch (Exception ex)  {
            LogHelper.log(Level.WARNING, "Failed to load " + MOD_NAME + " Addon" );
            api = Optional.absent();
        }
    }
}
