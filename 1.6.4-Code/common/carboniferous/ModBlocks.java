package carboniferous;

import cpw.mods.fml.common.registry.GameRegistry;
import carboniferous.api.CarboniferousApi;
import carboniferous.api.Properties;
import carboniferous.block.*;
import carboniferous.item.*;
import carboniferous.tileentity.*;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHalfSlab;
import net.minecraftforge.common.MinecraftForge;

/**
 * @author ProPercivalalb
 */
public class ModBlocks {

	public static Block grass;
	public static Block dirt;
	public static Block multiBlock1;
	public static Block multiBlock2;
	public static Block multiBlock3;
	public static Block timeBox;
	public static Block portal;
	public static Block grinder;
	public static Block logs_1;
	public static Block leaves_1;
	public static Block saplings_1;
	public static Block planks_1;
	public static BlockHalfSlab woodDoubleSlab;
    public static BlockHalfSlab woodSingleSlab;
	public static Block wallShell;
	public static Block stairsLepidodendron;
	public static Block stairsCalamites;
	public static Block stairsCordaites;
	public static Block stairsSigillaria;
	public static Block stairsLimestoneBrick;
	public static Block stairsGraniteBrick;
	public static Block waterPlant;
	public static Block antHill;
	public static Block sand;
	public static Block clearGlass;
	public static Block wallsRock;
	public static Block pillars;
	public static Block vines;
	public static Block fern;
	public static Block doorLepidodendron;
	public static Block doorCalamites;
	public static Block doorCordaites;
	public static Block doorSigillaria;
	public static Block doorAmphibian;
	public static Block coral;
	public static Block compressor;
	public static Block tilledEarth;
	
	public static void init() {
		//Init Block Variables
		grass = new BlockGrass(Properties.ID_GRASS).setHardness(0.6F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("carbon.grass");
		dirt = new BlockDirt(Properties.ID_DIRT).setHardness(0.5F).setStepSound(Block.soundGravelFootstep).setUnlocalizedName("carbon.dirt");
		multiBlock1 = new BlockMultipleBlocks(Properties.ID_MULTIBLOCK_1).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("carbon.multiBlock1");
		multiBlock2 = new BlockMultipleBlocks2(Properties.ID_MULTIBLOCK_2).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("carbon.multiBlock2");
		multiBlock3 = new BlockMultipleBlocks3(Properties.ID_MULTIBLOCK_3).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("carbon.multiBlock3");
		timeBox = new BlockTimeBox(Properties.ID_TIME_BOX).setHardness(2.0F).setResistance(5F).setUnlocalizedName("carbon.timeBox");
		portal = new BlockPortal(Properties.ID_PORTAL, "ph_portal").setHardness(-1.0F).setStepSound(Block.soundGlassFootstep).setLightValue(0.75F).setUnlocalizedName("carbon.portal");
		grinder = new BlockGrinder(Properties.ID_GRINDER).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("carbon.grinder");
		logs_1 = new BlockLog(Properties.ID_LOGS_1, new String[] {"logLepidodendron", "logCalamites", "logCordaites", "logSigillaria"}, new String[] {"log_oak_top", "log_oak_top", "log_oak_top", "log_oak_top"}).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("carbon.wood");
		leaves_1 = new BlockLeaves(Properties.ID_LEAVES_1, new String[][] {{"leaves_Lepidodendron", "leaves_Calamites", "leaves_Cordaites", "leaves_Sigillaria"}, {"leaves_Lepidodendron_o", "leaves_Calamites_o", "leaves_Cordaites_o", "leaves_Sigillaria_o"}}).setHardness(0.2F).setLightOpacity(1).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("carbon.leaves.1");
		saplings_1 = new BlockSapling(Properties.ID_SAPLINGS_1).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("carbon.sapling");
		planks_1 = new BlockPlanks(Properties.ID_PLANKS_1).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("carbon.planks");
		woodDoubleSlab = (BlockHalfSlab)(new BlockPlanksSlab(Properties.ID_WOOD_DOUBLE_SLAB, true)).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("carbon.woodSlab");
	    woodSingleSlab = (BlockHalfSlab)(new BlockPlanksSlab(Properties.ID_WOOD_SINGLE_SLAB, false)).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("carbon.woodSlab");
		wallShell = new BlockWallShell(Properties.ID_WALLSHELLS).setUnlocalizedName("carbon.wallShell");
		stairsLepidodendron = new BlockCarboniferousStairs(Properties.ID_STAIRS_LEPIDONDENDRON, planks_1, 0).setUnlocalizedName("carbon.stairsLepidodendron");
		stairsCalamites = new BlockCarboniferousStairs(Properties.ID_STAIRS_CALAMITES, planks_1, 1).setUnlocalizedName("carbon.stairsCalamites");
		stairsCordaites = new BlockCarboniferousStairs(Properties.ID_STAIRS_CORDAITES, planks_1, 2).setUnlocalizedName("carbon.stairsCordaites");
		stairsSigillaria = new BlockCarboniferousStairs(Properties.ID_STAIRS_SIGILLARIA, planks_1, 3).setUnlocalizedName("carbon.stairsSigillaria");
		stairsGraniteBrick = new BlockCarboniferousStairs(Properties.ID_STAIRS_GRANITE_BRICK, multiBlock1, 2).setUnlocalizedName("carbon.stairsGraniteBrick");
		stairsLimestoneBrick = new BlockCarboniferousStairs(Properties.ID_STAIRS_LIMESTONE_BRICK, multiBlock1, 4).setUnlocalizedName("carbon.stairsLimestoneBrick");
		waterPlant = new BlockWaterPlant(Properties.ID_WATER_PLANT).setUnlocalizedName("carbon.waterPlant");
		antHill = new BlockAntHill(Properties.ID_ANT_HILL).setUnlocalizedName("carbon.antHill").setHardness(1.0F);
		sand = new BlockCarboniferousSand(Properties.ID_SAND).setHardness(0.5F).setStepSound(Block.soundSandFootstep).setUnlocalizedName("carbon.sand");
		clearGlass = new BlockCustomGlass(Properties.ID_CLEAR_GLASS).setResistance(1.5F).setHardness(0.6F).setStepSound(Block.soundGlassFootstep).setUnlocalizedName("carbon.clearGlass");
		wallsRock = new BlockWall(Properties.ID_WALL_ROCK, multiBlock1).setUnlocalizedName("carbon.wallsRock");
		pillars = new BlockPillar(Properties.ID_PILLARS, new String[] {"graniteColumn_side", "limestonePillar_side", "basaltPillar_side"}, new String[] {"graniteColumn_top", "limestonePillar_top", "basaltPillar_top"}).setUnlocalizedName("carbon.pillars").setStepSound(Block.soundStoneFootstep).setHardness(0.8F);
		fern = new BlockCustomTallGrass(Properties.ID_FERN).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("carbon.tallgrass");
		vines = new BlockVine(Properties.ID_VINE).setHardness(0.3F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("carbon.vine");
		doorLepidodendron = new BlockCustomDoor(Properties.ID_DOOR_LEPIDONDENDRON, 0).setUnlocalizedName("carbon.doorLepidodendron").setHardness(3.0F).setStepSound(Block.soundWoodFootstep);
		doorCalamites = new BlockCustomDoor(Properties.ID_DOOR_CALAMITES, 1).setUnlocalizedName("carbon.doorCalamites").setHardness(3.0F).setStepSound(Block.soundWoodFootstep);
		doorCordaites = new BlockCustomDoor(Properties.ID_DOOR_CORDAITES, 2).setUnlocalizedName("carbon.doorCordaites").setHardness(3.0F).setStepSound(Block.soundWoodFootstep);
		doorSigillaria = new BlockCustomDoor(Properties.ID_DOOR_SIGILLARIA, 3).setUnlocalizedName("carbon.doorSigillaria").setHardness(3.0F).setStepSound(Block.soundWoodFootstep);
		doorAmphibian = new BlockCustomDoor(Properties.ID_DOOR_AMPHIBIAN, 4).setUnlocalizedName("carbon.doorSigillaria").setHardness(3.0F).setStepSound(Block.soundWoodFootstep);
		coral = new BlockCoral(Properties.ID_CORAL).setHardness(0.0F).setUnlocalizedName("carbon.coral");
		compressor = new BlockCompressor(Properties.ID_COMPRESSOR).setUnlocalizedName("carbon.compressor");
		tilledEarth = new BlockTilledDirt(Properties.ID_TILLED_DIRT).setHardness(0.6F).setStepSound(Block.soundGravelFootstep).setUnlocalizedName("carbon.tilledDirt");
		//Register Blocks
		GameRegistry.registerBlock(timeBox, "carbon.timeBox");
		GameRegistry.registerBlock(portal, "carbon.portal");
		GameRegistry.registerBlock(grinder, "carbon.grinder");
		GameRegistry.registerBlock(grass, "carbon.grass");
		GameRegistry.registerBlock(dirt, ItemMulipleBlock.class, "carbon.dirt");
		GameRegistry.registerBlock(multiBlock1, ItemMulipleBlock.class, "carbon.multipleBlocks1");
		GameRegistry.registerBlock(multiBlock2, ItemMulipleBlock.class, "carbon.multipleBlocks2");
		GameRegistry.registerBlock(multiBlock3, ItemMulipleBlock.class, "carbon.multipleBlocks3");
		GameRegistry.registerBlock(logs_1, ItemLogs.class, "carbon.logs.1");
		GameRegistry.registerBlock(leaves_1, ItemLeaves.class, "carbon.leaves.1");
		GameRegistry.registerBlock(saplings_1, ItemSapling.class, "carbon.sapling.1");
		GameRegistry.registerBlock(planks_1, ItemPlanks.class, "carbon.plank.1");
		GameRegistry.registerBlock(woodSingleSlab, ItemPlankSlab.class, "carbon.woodSingleSlab");
		GameRegistry.registerBlock(woodDoubleSlab, ItemPlankSlab.class, "carbon.woodDoubleSlab");
		GameRegistry.registerBlock(wallShell, "carbon.wallShell");
		GameRegistry.registerBlock(stairsLepidodendron, "carbon.stairsLepidodendron");
		GameRegistry.registerBlock(stairsCalamites, "carbon.stairsCalamites");
		GameRegistry.registerBlock(stairsCordaites, "carbon.stairsCordaites");
		GameRegistry.registerBlock(stairsSigillaria, "carbon.stairsSigillaria");
		GameRegistry.registerBlock(stairsGraniteBrick, "carbon.stairsGraniteBrick");
		GameRegistry.registerBlock(stairsLimestoneBrick, "carbon.stairsLimestoneBrick");
		GameRegistry.registerBlock(waterPlant, "carbon.waterPlant");
		GameRegistry.registerBlock(antHill, "carbon.antHill");
		GameRegistry.registerBlock(sand, "carbon.sand");
		GameRegistry.registerBlock(clearGlass, "carbon.clearGlass");
		GameRegistry.registerBlock(wallsRock, ItemMulipleBlock.class, "carbon.wallsRock");
		GameRegistry.registerBlock(pillars, ItemMulipleBlock.class, "carbon.pillars");
		GameRegistry.registerBlock(vines, "carbon.vine");
		GameRegistry.registerBlock(fern, "carbon.fern");
		GameRegistry.registerBlock(doorLepidodendron, "carbon.doorLepidodendron");
		GameRegistry.registerBlock(doorCalamites, "carbon.doorCalamites");
		GameRegistry.registerBlock(doorCordaites, "carbon.doorCordaites");
		GameRegistry.registerBlock(doorSigillaria, "carbon.doorSigillaria");
		GameRegistry.registerBlock(coral, ItemMulipleBlock.class, "carbon.coral");
		GameRegistry.registerBlock(compressor, "carbon.compressor");
		GameRegistry.registerBlock(tilledEarth, "carbon.tilledEarth");
		//Register Tile Entity
		GameRegistry.registerTileEntity(TileEntityGrinder.class, "carbon.grinder");
		GameRegistry.registerTileEntity(TileEntityWallShell.class, "carbon.wallGrinder");
		GameRegistry.registerTileEntity(TileEntityTimeBox.class, "carbon.timeBox");
		GameRegistry.registerTileEntity(TileEntityCompressor.class, "carbon.compressor");
		
		intiHarvestStats(); //Sets which tools the blocks and be harvested by.
		intiBurnProperties(); //Sets which blocks can burn and the rate at which they do.
		intiSedimentOres(); //Adds the blocks to gen with sediment.
	}
	
	public static void intiHarvestStats() {
		MinecraftForge.setBlockHarvestLevel(grass, "shovel", 0); //Grass
		MinecraftForge.setBlockHarvestLevel(dirt, "shovel", 0); //Dirt
		MinecraftForge.setBlockHarvestLevel(tilledEarth, "shovel", 0); //Tilled Earth
		MinecraftForge.setBlockHarvestLevel(sand, "shovel", 0) ;//Sand
		MinecraftForge.setBlockHarvestLevel(multiBlock1, 0, "pickaxe", 0); //Granite
		MinecraftForge.setBlockHarvestLevel(multiBlock1, 1, "pickaxe", 0); //Cobble Granite
		MinecraftForge.setBlockHarvestLevel(multiBlock1, 2, "pickaxe", 0); //Brick Granite
		MinecraftForge.setBlockHarvestLevel(multiBlock1, 3, "pickaxe", 0); //Limestone
		MinecraftForge.setBlockHarvestLevel(multiBlock1, 4, "pickaxe", 0); //Limestone Brick
		MinecraftForge.setBlockHarvestLevel(multiBlock1, 5, "pickaxe", 0); //Sediment
		MinecraftForge.setBlockHarvestLevel(multiBlock1, 6, "pickaxe", 0); //Sediment Fossil
		MinecraftForge.setBlockHarvestLevel(multiBlock1, 7, "pickaxe", 2); //Sediment Gold
		MinecraftForge.setBlockHarvestLevel(multiBlock1, 8, "pickaxe", 1); //Sediment Hematite
		MinecraftForge.setBlockHarvestLevel(multiBlock1, 9, "pickaxe", 1); //Sediment Pyrite
		MinecraftForge.setBlockHarvestLevel(multiBlock1, 10, "pickaxe", 2); //Granite Diamond
		MinecraftForge.setBlockHarvestLevel(multiBlock1, 11, "pickaxe", 2); //Granite Gold
		MinecraftForge.setBlockHarvestLevel(multiBlock1, 12, "pickaxe", 1); //Granite Hematite
		MinecraftForge.setBlockHarvestLevel(multiBlock1, 13, "pickaxe", 1); //Granite Pyrite
		MinecraftForge.setBlockHarvestLevel(multiBlock1, 14, "pickaxe", 0); //Pyrite Block
		MinecraftForge.setBlockHarvestLevel(multiBlock2, "pickaxe", 0);
		MinecraftForge.setBlockHarvestLevel(multiBlock3, 0, "pickaxe", 1); //Meteorite Block
		MinecraftForge.setBlockHarvestLevel(multiBlock3, 1, "pickaxe", 1); //Meteorite Light Ore
		MinecraftForge.setBlockHarvestLevel(multiBlock3, 2, "pickaxe", 1); //Meteorite Red Ore
		MinecraftForge.setBlockHarvestLevel(multiBlock3, 3, "pickaxe", 2); //Basalt Encrusted Diamond
		MinecraftForge.setBlockHarvestLevel(wallsRock, "pickaxe", 0);
		MinecraftForge.setBlockHarvestLevel(pillars, "pickaxe", 0);
	}
	
	public static void intiBurnProperties() {
	    Block.setBurnProperties(logs_1.blockID, 5, 5);
	    Block.setBurnProperties(planks_1.blockID, 5, 20);
	    Block.setBurnProperties(leaves_1.blockID, 30, 60);
	    Block.setBurnProperties(woodDoubleSlab.blockID, 5, 20);
	    Block.setBurnProperties(woodSingleSlab.blockID, 5, 20);
	}
	
	public static void intiSedimentOres() {
		for(int var1=6; var1<=9; ++var1) {
			CarboniferousApi.addSedimentOre(multiBlock1.blockID, var1);
		}
	}

}
