package carboniferous.addon.optifine;

import com.google.common.base.Optional;

import carboniferous.addon.AddonEvent;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

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
    
    /**
     * 
     * @return 0 Default based on , 1 always 
     */
    public static int getTreeSetting() {
    	if(!api.isPresent()) {
    		return 0;
    	}
    	return api.get().getTreeSetting();
    }
    
    @SubscribeEvent
    public void init(AddonEvent.Init event) {
        if(!api.isPresent())
        	return;
        
    }
    
    @SubscribeEvent
    public void postInit(AddonEvent.Post event) {
        api = Optional.absent();
    }

    @SubscribeEvent
    public void preInit(AddonEvent.Pre event) {
        if (!FMLClientHandler.instance().hasOptifine())
        	return;
        
        try {
            api = Optional.of(new OptifineApi());
        } 
        catch (Exception ex)  {
            api = Optional.absent();
        }
    }

}
