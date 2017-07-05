package carboniferous.configuration;

import java.util.ArrayList;
import java.util.List;

import carboniferous.lib.Reference;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * @author ProPercivalalb, NovaViper
 */
public class ConfigurationHandler {

	public static Configuration CONFIG;
	
	public static final String CATEGORY_GENERAL = "general";
	
	public static void init(Configuration configuration) {
		CONFIG = configuration;
		loadConfig();
		MinecraftForge.EVENT_BUS.register(new ConfigurationHandler());
	}

	public static void loadConfig() {
		CONFIG.addCustomCategoryComment(CATEGORY_GENERAL, "Gerneral Carboniferous settings");
		
		if(CONFIG.hasChanged())
			CONFIG.save();
	}
	
	@SubscribeEvent
	public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event) {
		if(event.getModID().equals(Reference.MOD_ID))
			loadConfig();
	}
}