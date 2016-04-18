package carboniferous.core.addons.optifine;

import java.util.logging.Level;

import com.google.common.base.Optional;

import carboniferous.core.addons.PluginEvent;
import carboniferous.core.helper.LogHelper;
import cpw.mods.fml.client.FMLClientHandler;
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
