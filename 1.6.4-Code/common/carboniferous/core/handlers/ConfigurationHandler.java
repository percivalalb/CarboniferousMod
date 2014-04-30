package carboniferous.core.handlers;

import net.minecraftforge.common.Configuration;
import carboniferous.api.Properties;

/**
 * @author ProPercivalalb
 */
public class ConfigurationHandler {

	public static void loadConfig(Configuration var1) {
		var1.load();
		Properties.config = var1;
		//Blocks (Terrain)
		Properties.ID_GRASS = Integer.valueOf(var1.getTerrainBlock("terrainBlock", "grass", 220, "This value must be below 256 or it will cause problems.").getString());
		Properties.ID_DIRT = Integer.valueOf(var1.getTerrainBlock("terrainBlock", "dirt", 221, "This value must be below 256 or it will cause problems.").getString());
		Properties.ID_MULTIBLOCK_1 = Integer.valueOf(var1.getTerrainBlock("terrainBlock", "granite", 222, "This value must be below 256 or it will cause problems.").getString());
		
		//Blocks
		Properties.ID_MULTIBLOCK_2 = Integer.valueOf(var1.getBlock("decorationBlocks", 2778).getString());
		Properties.ID_TIME_BOX = Integer.valueOf(var1.getBlock("timeBox", 2779).getString());
		Properties.ID_PORTAL = Integer.valueOf(var1.getBlock("portal", 2780).getString());
		Properties.ID_GRINDER = Integer.valueOf(var1.getBlock("grinder", 2781).getString());
		Properties.ID_LOGS_1 = Integer.valueOf(var1.getBlock("logs_1", 2782).getString());
		Properties.ID_LEAVES_1 = Integer.valueOf(var1.getBlock("leaves_1", 2783).getString());
		Properties.ID_SAPLINGS_1 = Integer.valueOf(var1.getBlock("saplings_1", 2784).getString());
		Properties.ID_PLANKS_1 = Integer.valueOf(var1.getBlock("planks_1", 2785).getString());
		Properties.ID_WOOD_DOUBLE_SLAB = Integer.valueOf(var1.getBlock("woodDoubleSlab", 2786).getString());
		Properties.ID_WOOD_SINGLE_SLAB = Integer.valueOf(var1.getBlock("woodSingleSlab", 2787).getString());
		Properties.ID_WALLSHELLS = Integer.valueOf(var1.getBlock("wallItems", 2788).getString());
		Properties.ID_STAIRS_LEPIDONDENDRON = Integer.valueOf(var1.getBlock("stairsLepidondendron", 2789).getString());
		Properties.ID_STAIRS_CALAMITES = Integer.valueOf(var1.getBlock("stairsCalamites", 2790).getString());
		Properties.ID_STAIRS_CORDAITES = Integer.valueOf(var1.getBlock("stairsCordaites", 2791).getString());
		Properties.ID_STAIRS_SIGILLARIA = Integer.valueOf(var1.getBlock("stairsSigillaria", 2792).getString());
		Properties.ID_STAIRS_GRANITE_BRICK = Integer.valueOf(var1.getBlock("stairsGrainiteBrick", 2793).getString());
		Properties.ID_STAIRS_LIMESTONE_BRICK = Integer.valueOf(var1.getBlock("statirsLimestoneBrick", 2794).getString());
		Properties.ID_WATER_PLANT = Integer.valueOf(var1.getBlock("waterPlant", 2795).getString());
		Properties.ID_ANT_HILL = Integer.valueOf(var1.getBlock("antHill", 2796).getString());
		Properties.ID_SAND = Integer.valueOf(var1.getBlock("carboniferousSand", 2797).getString());
		Properties.ID_CLEAR_GLASS = Integer.valueOf(var1.getBlock("clearGlass", 2798).getString());
		Properties.ID_WALL_ROCK = Integer.valueOf(var1.getBlock("rockWalls", 2799).getString());
		Properties.ID_CORAL = Integer.valueOf(var1.getBlock("coral", 2800).getString());
		Properties.ID_PILLARS = Integer.valueOf(var1.getBlock("pillars", 2801).getString());
		Properties.ID_VINE = Integer.valueOf(var1.getBlock("vines", 2802).getString());
		Properties.ID_DOOR_LEPIDONDENDRON = Integer.valueOf(var1.getBlock("doorLepidondenron", 2803).getString());
		Properties.ID_DOOR_CALAMITES = Integer.valueOf(var1.getBlock("doorCalamites", 2804).getString());
		Properties.ID_DOOR_CORDAITES = Integer.valueOf(var1.getBlock("doorCordaites", 2805).getString());
		Properties.ID_DOOR_SIGILLARIA = Integer.valueOf(var1.getBlock("doorSigillaria", 2806).getString());
		Properties.ID_DOOR_AMPHIBIAN = Integer.valueOf(var1.getBlock("doorAmphibian", 2807).getString());
		Properties.ID_FERN = Integer.valueOf(var1.getBlock("tallGrass", 2808).getString());
		Properties.ID_COMPRESSOR = Integer.valueOf(var1.getBlock("compressor", 2809).getString());
		Properties.ID_TILLED_DIRT = Integer.valueOf(var1.getBlock("tilledDirt", 2810).getString());
		
		//Items
		Properties.ID_FLIPPERS = Integer.valueOf(var1.getItem("flippers", 26240).getString());
		Properties.ID_MULTI_ITEMS = Integer.valueOf(var1.getItem("multiItems", 26242).getString());
		Properties.ID_AMPHIBIAN_SKIN_HELMET = Integer.valueOf(var1.getItem("amphibianSkinHelment", 26243).getString());
		Properties.ID_AMPHIBIAN_SKIN_CHEST = Integer.valueOf(var1.getItem("amphibianSkinChestplate", 26244).getString());
		Properties.ID_AMPHIBIAN_SKIN_LEGGING = Integer.valueOf(var1.getItem("amphibianSkinLeggings", 26245).getString());
		Properties.ID_AMPHIBIAN_SKIN_BOOT = Integer.valueOf(var1.getItem("amphibianSkinBoots", 26246).getString());
		Properties.ID_HUNTERS_BOW = Integer.valueOf(var1.getItem("huntersBow", 26247).getString());
		Properties.ID_GRINDING_STONES = Integer.valueOf(var1.getItem("grindingStones", 26248).getString());
		Properties.ID_ANT = Integer.valueOf(var1.getItem("rawAnt", 26249).getString());
		Properties.ID_ANT_COOKED = Integer.valueOf(var1.getItem("cookedAnt", 26250).getString());
		Properties.ID_QUIVER = Integer.valueOf(var1.getItem("quiver", 26251).getString());
		Properties.ID_NET = Integer.valueOf(var1.getItem("net", 26258).getString());
		Properties.ID_RAW_DRAGONFLY = Integer.valueOf(var1.getItem("rawDragonfly", 26259).getString());
		Properties.ID_COOKED_DRAGONFLY = Integer.valueOf(var1.getItem("cookedDragonfly", 26260).getString());
		Properties.ID_RAW_AMPHIBIAN = Integer.valueOf(var1.getItem("rawAmphibianMeat", 26261).getString());
		Properties.ID_COOKED_AMPHIBIAN = Integer.valueOf(var1.getItem("cookedAmphibianMeat", 26262).getString());
		
		//Biomes
		Properties.BIOME_ID_CALAMITESSWAMP = Integer.valueOf(var1.get("biomeID", "calamitesSwamp", 170).getString());
		Properties.BIOME_ID_HIGHLANDS = Integer.valueOf(var1.get("biomeID", "highlands", 171).getString());
		Properties.BIOME_ID_ISLAND = Integer.valueOf(var1.get("biomeID", "island", 172).getString());
		Properties.BIOME_ID_RAINFOREST = Integer.valueOf(var1.get("biomeID", "rainforest", 173).getString());
		Properties.BIOME_ID_RIVER = Integer.valueOf(var1.get("biomeID", "carboniferousRiver", 174).getString());
		Properties.BIOME_ID_OCEAN = Integer.valueOf(var1.get("biomeID", "carboniferousOcean", 175).getString());
		Properties.BIOME_ID_COALSWAMP = Integer.valueOf(var1.get("biomeID", "coalSwamp", 176).getString());
		//Properties.BIOME_ID_BOG = Integer.valueOf(var1.get("biomeID", "bog", 177).getString());
		
		//Dimension ID
		Properties.dimensionID = Integer.valueOf(var1.get("dimensionID", "carboniferousDimensionID", 76).getString());
		var1.save();
	 }
}
