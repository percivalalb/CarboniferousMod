package carboniferous;

import carboniferous.api.CarboniferousModAPI;
import carboniferous.lib.Reference;
import carboniferous.world.biome.BiomeCarboniferous;
import carboniferous.world.biome.BiomeCalamitesSwamp;
import carboniferous.world.biome.BiomeCoalSwamp;
import carboniferous.world.biome.BiomeHighlands;
import carboniferous.world.biome.BiomeIceSheet;
import carboniferous.world.biome.BiomeIsland;
import carboniferous.world.biome.BiomeOceanCarboniferous;
import carboniferous.world.biome.BiomeRainforest;
import carboniferous.world.biome.BiomeRiverCarboniferous;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@EventBusSubscriber(modid = Reference.MOD_ID)
@ObjectHolder(Reference.MOD_ID)
public class ModBiomes {

	public static final BiomeCalamitesSwamp CALAMITES_SWAMP = null;
	public static final BiomeCoalSwamp COAL_SWAMP = null;
	public static final BiomeHighlands HIGHLANDS = null;
	public static final BiomeIceSheet ICE_SHEET = null;
	public static final BiomeIsland ISLAND = null;
	public static final BiomeRainforest RAINFOREST = null;
	public static final BiomeOceanCarboniferous CARBONIFEROUS_OCEAN = null;
	public static final BiomeRiverCarboniferous CARBONIFEROUS_RIVER = null;
	
	@SubscribeEvent
	public static void onRegisterBlock(RegistryEvent.Register<Biome> event) {

		
		event.getRegistry().registerAll(new BiomeCalamitesSwamp().setRegistryName(Reference.MOD_ID, "calamites_swamp"), 
				new BiomeCoalSwamp().setRegistryName(Reference.MOD_ID, "coal_swamp"),
				new BiomeHighlands().setRegistryName(Reference.MOD_ID, "highlands"),
				new BiomeIceSheet().setRegistryName(Reference.MOD_ID, "ice_sheet"),
				new BiomeIsland().setRegistryName(Reference.MOD_ID, "island"),
				new BiomeRainforest().setRegistryName(Reference.MOD_ID, "rainforest"),
				new BiomeOceanCarboniferous().setRegistryName(Reference.MOD_ID, "carboniferous_ocean"),
				new BiomeRiverCarboniferous().setRegistryName(Reference.MOD_ID, "carboniferous_river")
				);
		
		CarboniferousModAPI.registerBiome(CALAMITES_SWAMP);
		CarboniferousModAPI.registerBiome(ISLAND);
		CarboniferousModAPI.registerBiome(COAL_SWAMP);
	}
}
