package carboniferous;

import java.util.Arrays;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import carboniferous.api.CarboniferousApi;
import carboniferous.api.ModEvents;
import carboniferous.api.Properties;
import carboniferous.command.CommandHandler;
import carboniferous.world.WorldProviderCarboniferous;
import carboniferous.world.biome.BiomeGenBaseCarboniferous;
import carboniferous.core.addons.Api;
import carboniferous.core.addons.PluginManager;
import carboniferous.core.addons.arsmagica.ArsMagicaPlugin;
import carboniferous.core.addons.buildcraft.BuildcraftPlugin;
import carboniferous.core.addons.ee3.EE3Plugin;
import carboniferous.core.addons.extrabiomesxl.ExtraBiomesXLPlugin;
import carboniferous.core.addons.forestry.ForestryPlugin;
import carboniferous.core.addons.ic2.IC2Plugin;
import carboniferous.core.addons.thaumcraft.ThaumcraftPlugin;
import carboniferous.core.addons.thermalexpansion.ThermalExpansionPlugin;
import carboniferous.core.handlers.*;
import carboniferous.core.helper.LogHelper;
import carboniferous.core.helper.VersionHelper;
import carboniferous.core.helper.VersionHelper.UpdateType;
import carboniferous.core.proxy.CommonProxy;
import carboniferous.creativetab.CreativeTabCarboniferous;
import carboniferous.lib.Reference;
import carboniferous.network.NetworkManager;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;

/**
 * @author ProPercivalalb
 **/
@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION, dependencies = Reference.MOD_DEPENDENCIES)
public class CarboniferousMod {
	
	@Instance(value = Reference.MOD_ID)
	public static CarboniferousMod INSTANCE;
	
	@SidedProxy(clientSide = Reference.SP_CLIENT, serverSide = Reference.SP_SERVER)
    public static CommonProxy proxy;
	
	public static CreativeTabs tabsCarboniferous = new CreativeTabCarboniferous();
	
	public static NetworkManager NETWORK_MANAGER;
	public ConnectionHandler serverTeleport;
	
	@EventHandler
    public void serverStarting(FMLServerStartingEvent event) {
        //Initialize the custom commands
        CommandHandler.initCommands(event);
    }
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		proxy.onModPre();
		
		//Loads all the variables from the configuration file.
		ConfigurationHandler.loadConfig(new Configuration(event.getSuggestedConfigurationFile()));
		//Initializing the log helper
		LogHelper.init();
		//Version Check
		VersionHelper.checkVersion(UpdateType.BLANK);
		//Initialize the Blocks
		ModBlocks.init();
		//Initialize the Items
		ModItems.init();
		//Initialize the Entitys
		ModEntities.init();
		
		RecipeHandler.inti();
		
		FMLCommonHandler.instance().bus().register(new ServerTickHandler());
		
		proxy.registerTickHandlers();
		proxy.registerSoundHandler();
		
		//Register the Dimension
		DimensionManager.registerProviderType(Properties.dimensionID, WorldProviderCarboniferous.class, true);
		DimensionManager.registerDimension(Properties.dimensionID, Properties.dimensionID);
		
		/** Event for other modders to use **/
		MinecraftForge.EVENT_BUS.post(new ModEvents.PreInit());
	}

	@EventHandler
	public void init(FMLInitializationEvent par1) {
		proxy.onModLoad();
		
		//Register the GUI Handler
        NetworkRegistry.INSTANCE.registerGuiHandler(INSTANCE, proxy);
        //Register the Connection Handler
    	FMLCommonHandler.instance().bus().register(serverTeleport = new ConnectionHandler());
        //Register the Mod Packets
     	NETWORK_MANAGER = new NetworkManager();
        
        //Register Action Handler
		MinecraftForge.EVENT_BUS.register(new ActionHandler());
		//Register Bonemeal Handler
		MinecraftForge.EVENT_BUS.register(new BonemealUseHandler());
		//Register Player Break Speed Handler
		MinecraftForge.EVENT_BUS.register(new PlayerBreakSpeed());
		//Register World Event Handler
		MinecraftForge.EVENT_BUS.register(new WorldEventHandler());
		//Register Portal Render Handler
		MinecraftForge.EVENT_BUS.register(new PortalRenderOverlayHandler());
		//Register the Arrow Handler for the quiver
		MinecraftForge.EVENT_BUS.register(new ArrowEventHandler());
		//Register the Hoe Handler
		MinecraftForge.EVENT_BUS.register(new HoeEventHandler());
		
		GameRegistry.registerFuelHandler(new FuelHandler());
	
		/** Event for other modders to use **/
		MinecraftForge.EVENT_BUS.post(new ModEvents.Init());
	}
	
	@EventHandler
	public void modsLoaded(FMLPostInitializationEvent par1) {
		proxy.onModPost();
		
		//Addons/Plugins Register
		LogHelper.logInfo("");
		proxy.registerPlugins();
		Api.registerPlugin(new ArsMagicaPlugin());
		Api.registerPlugin(new BuildcraftPlugin());
		//Api.registerPlugin(new BibliocraftPlugin());
		Api.registerPlugin(new EE3Plugin());
		Api.registerPlugin(new ExtraBiomesXLPlugin());
		Api.registerPlugin(new ForestryPlugin());
		Api.registerPlugin(new IC2Plugin());
		Api.registerPlugin(new ThaumcraftPlugin());
		Api.registerPlugin(new ThermalExpansionPlugin());
		PluginManager.activatePlugins();
		
		//Biomes Added to the Carboniferous Dimension
		CarboniferousApi.registerBiome(BiomeGenBaseCarboniferous.calamitesSwamp);
		CarboniferousApi.registerBiome(BiomeGenBaseCarboniferous.highlands);
		CarboniferousApi.registerBiome(BiomeGenBaseCarboniferous.island);
		CarboniferousApi.registerBiome(BiomeGenBaseCarboniferous.coalSwamp);
		//CarboniferousApi.registerBiome(BiomeGenBaseCarboniferous.bog);
		
		/** Event for other modders to use **/
		MinecraftForge.EVENT_BUS.post(new ModEvents.PostInit());
	}
}