package carboniferous;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import carboniferous.addon.AddonManager;
import carboniferous.api.CarboniferousModAPI;
import carboniferous.configuration.ConfigurationHandler;
import carboniferous.creativetab.CreativeTabCarboniferous;
import carboniferous.lib.Reference;
import carboniferous.proxy.CommonProxy;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * @author ProPercivalalb
 */
@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION, dependencies = Reference.DEPENDENCIES, updateJSON = Reference.UPDATE_URL, guiFactory = Reference.GUI_FACTORY)
public class DoggyTalents {

	@Instance(value = Reference.MOD_ID)
	public static DoggyTalents INSTANCE;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.SERVER_PROXY)
    public static CommonProxy PROXY;
	
	public static final Logger LOGGER = LogManager.getLogger(Reference.MOD_NAME);
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ConfigurationHandler.init(new Configuration(event.getSuggestedConfigurationFile()));
		CarboniferousModAPI.CREATIVE_TAB = new CreativeTabCarboniferous();
		PROXY.preInit(event);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		PROXY.init(event);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		AddonManager.registerAddons();
		AddonManager.runRegisteredAddons(ConfigurationHandler.CONFIG);
		PROXY.postInit(event);
	}
}
