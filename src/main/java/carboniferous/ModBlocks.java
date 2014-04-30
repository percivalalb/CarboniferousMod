package carboniferous;

import cpw.mods.fml.common.registry.GameRegistry;
import carboniferous.api.CarboniferousApi;
import carboniferous.api.Properties;
import carboniferous.block.*;
import carboniferous.item.*;
import carboniferous.tileentity.*;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
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
	public static BlockPlanksSlab woodDoubleSlab;
    public static BlockPlanksSlab woodSingleSlab;
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
		grass = new BlockGrass().setHardness(0.6F).setStepSound(Block.soundTypeGrass).setBlockName("carbon.grass");
		dirt = new BlockDirt().setHardness(0.5F).setStepSound(Block.soundTypeGravel).setBlockName("carbon.dirt");
		multiBlock1 = new BlockMultipleBlocks().setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypeStone).setBlockName("carbon.multiBlock1");
		multiBlock2 = new BlockMultipleBlocks2().setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypeStone).setBlockName("carbon.multiBlock2");
		multiBlock3 = new BlockMultipleBlocks3().setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypeStone).setBlockName("carbon.multiBlock3");
		timeBox = new BlockTimeBox().setHardness(2.0F).setResistance(5F).setBlockName("carbon.timeBox");
		portal = new BlockPortal("ph_portal").setHardness(-1.0F).setStepSound(Block.soundTypeGlass).setLightLevel(0.75F).setBlockName("carbon.portal");
		grinder = new BlockGrinder().setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setBlockName("carbon.grinder");
		logs_1 = new BlockLog(new String[] {"logLepidodendron", "logCalamites", "logCordaites", "logSigillaria"}, new String[] {"log_oak_top", "log_oak_top", "log_oak_top", "log_oak_top"}).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setBlockName("carbon.wood");
		leaves_1 = new BlockLeaves(new String[][] {{"leaves_Lepidodendron", "leaves_Calamites", "leaves_Cordaites", "leaves_Sigillaria"}, {"leaves_Lepidodendron_o", "leaves_Calamites_o", "leaves_Cordaites_o", "leaves_Sigillaria_o"}}).setHardness(0.2F).setLightOpacity(1).setStepSound(Block.soundTypeGrass).setBlockName("carbon.leaves.1");
		saplings_1 = new BlockSapling().setHardness(0.0F).setStepSound(Block.soundTypeGrass).setBlockName("carbon.sapling");
		planks_1 = new BlockPlanks().setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setBlockName("carbon.planks");
		woodDoubleSlab = (BlockPlanksSlab)(new BlockPlanksSlab(true)).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setBlockName("carbon.woodSlab");
	    woodSingleSlab = (BlockPlanksSlab)(new BlockPlanksSlab(false)).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setBlockName("carbon.woodSlab");
		wallShell = new BlockWallShell().setBlockName("carbon.wallShell");
		stairsLepidodendron = new BlockCarboniferousStairs(planks_1, 0).setBlockName("carbon.stairsLepidodendron");
		stairsCalamites = new BlockCarboniferousStairs(planks_1, 1).setBlockName("carbon.stairsCalamites");
		stairsCordaites = new BlockCarboniferousStairs(planks_1, 2).setBlockName("carbon.stairsCordaites");
		stairsSigillaria = new BlockCarboniferousStairs(planks_1, 3).setBlockName("carbon.stairsSigillaria");
		stairsGraniteBrick = new BlockCarboniferousStairs(multiBlock1, 2).setBlockName("carbon.stairsGraniteBrick");
		stairsLimestoneBrick = new BlockCarboniferousStairs(multiBlock1, 4).setBlockName("carbon.stairsLimestoneBrick");
		waterPlant = new BlockWaterPlant().setBlockName("carbon.waterPlant");
		antHill = new BlockAntHill().setBlockName("carbon.antHill").setHardness(1.0F);
		sand = new BlockCarboniferousSand().setHardness(0.5F).setStepSound(Block.soundTypeSand).setBlockName("carbon.sand");
		clearGlass = new BlockCustomGlass().setResistance(1.5F).setHardness(0.6F).setStepSound(Block.soundTypeGlass).setBlockName("carbon.clearGlass");
		wallsRock = new BlockWall(multiBlock1).setBlockName("carbon.wallsRock");
		pillars = new BlockPillar(new String[] {"graniteColumn_side", "limestonePillar_side", "basaltPillar_side"}, new String[] {"graniteColumn_top", "limestonePillar_top", "basaltPillar_top"}).setBlockName("carbon.pillars").setStepSound(Block.soundTypeStone).setHardness(0.8F);
		fern = new BlockCustomTallGrass().setHardness(0.0F).setStepSound(Block.soundTypeGrass).setBlockName("carbon.tallgrass");
		vines = new BlockVine().setHardness(0.3F).setStepSound(Block.soundTypeGrass).setBlockName("carbon.vine");
		doorLepidodendron = new BlockCustomDoor(0).setBlockName("carbon.doorLepidodendron").setHardness(3.0F).setStepSound(Block.soundTypeWood);
		doorCalamites = new BlockCustomDoor(1).setBlockName("carbon.doorCalamites").setHardness(3.0F).setStepSound(Block.soundTypeWood);
		doorCordaites = new BlockCustomDoor(2).setBlockName("carbon.doorCordaites").setHardness(3.0F).setStepSound(Block.soundTypeWood);
		doorSigillaria = new BlockCustomDoor(3).setBlockName("carbon.doorSigillaria").setHardness(3.0F).setStepSound(Block.soundTypeWood);
		doorAmphibian = new BlockCustomDoor(4).setBlockName("carbon.doorAmphibian").setHardness(3.0F).setStepSound(Block.soundTypeWood);
		coral = new BlockCoral().setHardness(0.0F).setBlockName("carbon.coral");
		compressor = new BlockCompressor().setBlockName("carbon.compressor");
		tilledEarth = new BlockTilledDirt().setHardness(0.6F).setStepSound(Block.soundTypeGravel).setBlockName("carbon.tilledDirt");
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
		GameRegistry.registerBlock(doorAmphibian, "carbon.doorAmphibian");
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
		grass.setHarvestLevel("shovel", 0); //Grass
		dirt.setHarvestLevel("shovel", 0); //Dirt
		tilledEarth.setHarvestLevel("shovel", 0); //Tilled Earth
		sand.setHarvestLevel("shovel", 0) ;//Sand
		multiBlock1.setHarvestLevel("pickaxe", 0, 0); //Granite
		multiBlock1.setHarvestLevel("pickaxe", 0, 1); //Cobble Granite
		multiBlock1.setHarvestLevel("pickaxe", 0, 2); //Brick Granite
		multiBlock1.setHarvestLevel("pickaxe", 0, 3); //Limestone
		multiBlock1.setHarvestLevel("pickaxe", 0, 4); //Limestone Brick
		multiBlock1.setHarvestLevel("pickaxe", 0, 5); //Sediment
		multiBlock1.setHarvestLevel("pickaxe", 0, 6); //Sediment Fossil
		multiBlock1.setHarvestLevel("pickaxe", 2, 7); //Sediment Gold
		multiBlock1.setHarvestLevel("pickaxe", 1, 8); //Sediment Hematite
		multiBlock1.setHarvestLevel("pickaxe", 1, 9); //Sediment Pyrite
		multiBlock1.setHarvestLevel("pickaxe", 2, 10); //Granite Diamond
		multiBlock1.setHarvestLevel("pickaxe", 2, 11); //Granite Gold
		multiBlock1.setHarvestLevel("pickaxe", 1, 12); //Granite Hematite
		multiBlock1.setHarvestLevel("pickaxe", 1, 13); //Granite Pyrite
		multiBlock1.setHarvestLevel("pickaxe", 0, 14); //Pyrite Block
		multiBlock2.setHarvestLevel("pickaxe", 0);
		multiBlock3.setHarvestLevel("pickaxe", 1, 0); //Meteorite Block
		multiBlock3.setHarvestLevel("pickaxe", 1, 1); //Meteorite Light Ore
		multiBlock3.setHarvestLevel("pickaxe", 1, 2); //Meteorite Red Ore
		multiBlock3.setHarvestLevel("pickaxe", 2, 3); //Basalt Encrusted Diamond
		wallsRock.setHarvestLevel("pickaxe", 0);
		pillars.setHarvestLevel("pickaxe", 0);
	}
	
	public static void intiBurnProperties() {
		Blocks.fire.setFireInfo(logs_1, 5, 5);
	    Blocks.fire.setFireInfo(logs_1, 5, 5);
		Blocks.fire.setFireInfo(planks_1, 5, 20);
		Blocks.fire.setFireInfo(leaves_1, 30, 60);
		Blocks.fire.setFireInfo(woodDoubleSlab, 5, 20);
		Blocks.fire.setFireInfo(woodSingleSlab, 5, 20);
	}
	
	public static void intiSedimentOres() {
		for(int var1=6; var1<=9; ++var1) {
			CarboniferousApi.addSedimentOre(multiBlock1, var1);
		}
	}

}
