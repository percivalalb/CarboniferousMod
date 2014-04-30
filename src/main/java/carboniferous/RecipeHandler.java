package carboniferous;

import java.util.ArrayList;
import java.util.List;

import carboniferous.api.CarboniferousApi;
import carboniferous.core.helper.CraftingHelper;
import carboniferous.recipe.GrinderManager;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class RecipeHandler {

	public static void inti() {
	    OreDictionary.registerOre( "plankWood",   new ItemStack(ModBlocks.planks_1, 1, OreDictionary.WILDCARD_VALUE));
	    OreDictionary.registerOre( "slabWood", 	  new ItemStack(ModBlocks.woodSingleSlab, 1, OreDictionary.WILDCARD_VALUE));
	    OreDictionary.registerOre( "logWood", 	  new ItemStack(ModBlocks.logs_1, 1, OreDictionary.WILDCARD_VALUE));
	    OreDictionary.registerOre( "treeLeaves",  new ItemStack(ModBlocks.leaves_1, 1, OreDictionary.WILDCARD_VALUE));
	    OreDictionary.registerOre( "treeSapling", new ItemStack(ModBlocks.saplings_1, 1, OreDictionary.WILDCARD_VALUE));
	    OreDictionary.registerOre( "oreGold", 	  new ItemStack(ModBlocks.multiBlock1, 1, 7));
	    OreDictionary.registerOre( "oreGold", 	  new ItemStack(ModBlocks.multiBlock1, 1, 8));
	    OreDictionary.registerOre( "oreDiamond",  new ItemStack(ModBlocks.multiBlock1, 1, 10));
	    OreDictionary.registerOre( "stairWood",   ModBlocks.stairsLepidodendron);
	    OreDictionary.registerOre( "stairWood",   ModBlocks.stairsCalamites);
	    OreDictionary.registerOre( "stairWood",   ModBlocks.stairsCordaites);
	    OreDictionary.registerOre( "stairWood",   ModBlocks.stairsSigillaria);
	    
	    for(int var1 = 0; var1 < 4; ++var1) {
	    	CraftingHelper.addShapelessRecipe(new ItemStack(ModBlocks.planks_1, 4, var1), new Object[] {new ItemStack(ModBlocks.logs_1, 4, var1)});
	    	CraftingHelper.addShapedRecipe(new ItemStack(ModBlocks.woodSingleSlab, 6, var1), new Object[] {"BBB", 'B', new ItemStack(ModBlocks.planks_1, 1, var1)});
	    	FurnaceRecipes.smelting().func_151394_a(new ItemStack(ModBlocks.logs_1, 1, var1), new ItemStack(Items.coal, 1, 1), 0.15F);
	    }
	    FurnaceRecipes.smelting().func_151394_a(new ItemStack(ModBlocks.multiBlock1, 1, 1), new ItemStack(ModBlocks.multiBlock1, 1, 0), 0.1F);
	    FurnaceRecipes.smelting().func_151394_a(new ItemStack(ModItems.multiItems, 1, 2), new ItemStack(Items.iron_ingot, 1, 0), 0.35F);
	    FurnaceRecipes.smelting().func_151394_a(new ItemStack(ModItems.rawDragonfly, 1, 0), new ItemStack(ModItems.cookedDragonfly, 1, 0), 0.35F);
	    FurnaceRecipes.smelting().func_151394_a(new ItemStack(ModItems.rawAmphibian, 1, 0), new ItemStack(ModItems.cookedAmphibian, 1, 0), 0.35F);
	    FurnaceRecipes.smelting().func_151394_a(new ItemStack(ModItems.rawAnt, 1, 0), new ItemStack(ModItems.cookedAnt), 0.25F);
	    FurnaceRecipes.smelting().func_151394_a(new ItemStack(ModBlocks.sand, 1, 0), new ItemStack(ModBlocks.clearGlass), 0.1F);
	    
	    
	    CraftingHelper.addShapedRecipe(new ItemStack(ModBlocks.multiBlock1, 4, 2), new Object[] {"BB", "BB", 'B', new ItemStack(ModBlocks.multiBlock1, 1, 0)}); //Granite Brick
	    CraftingHelper.addShapedRecipe(new ItemStack(ModBlocks.multiBlock1, 4, 4), new Object[] {"BB", "BB", 'B', new ItemStack(ModBlocks.multiBlock1, 1, 3)}); //Limestone Brick
	    CraftingHelper.addShapedRecipe(new ItemStack(ModBlocks.multiBlock2, 4, 12), new Object[] {"BB", "BB", 'B', new ItemStack(ModBlocks.multiBlock2, 1, 11)}); //Basalt Brick
	    CraftingHelper.addShapedRecipe(new ItemStack(ModBlocks.multiBlock2, 2, 10), new Object[] {"B", "B", 'B', new ItemStack(ModBlocks.multiBlock1, 1, 4)}); //Decatative Limestone
	    CraftingHelper.addShapedRecipe(new ItemStack(ModBlocks.dirt, 4, 1), new Object[] {"BB", "BB", 'B', new ItemStack(ModBlocks.dirt, 1, 0)}); //Dirt Brick
	    CraftingHelper.addShapedRecipe(new ItemStack(ModBlocks.multiBlock2, 4, 8), new Object[] {"BB", "BB", 'B', new ItemStack(ModBlocks.multiBlock1, 1, 14)}); //Dirt Brick
	    CraftingHelper.addShapedRecipe(new ItemStack(ModBlocks.grinder, 1, 0), new Object[] {"BTB", "GSG", "GGG", 'S', Items.stick, 'B', new ItemStack(ModBlocks.multiBlock1, 4, 2), 'G', new ItemStack(ModBlocks.multiBlock1, 1, 0), 'T', new ItemStack(ModItems.multiItems, 1, 9)}); //Grinder
	    CraftingHelper.addShapedRecipe(new ItemStack(ModItems.net, 1, 0), new Object[] {" TT", " ST", "S  ", 'S', Items.stick, 'T', Items.string}); //Net
	    CraftingHelper.addShapedRecipe(new ItemStack(ModItems.multiItems, 1, 5), new Object[] {" RD", " IR", "I  ", 'R', Items.redstone, 'I', Items.iron_ingot, 'D', Items.diamond}); //Timerod
	    CraftingHelper.addShapedRecipe(new ItemStack(ModBlocks.timeBox, 1), new Object[] {"ILI", "RDR", "ILI", 'R', Items.redstone, 'I', Items.iron_ingot, 'D', Items.diamond, 'L', Blocks.lapis_block}); //Timebox
	    GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.multiItems, 1, 9), new Object[] {" G ", "GLG", " G ", 'G', new ItemStack(ModBlocks.multiBlock1, 1, 1), 'L', "logWood"})); //Granite Gear
	    CraftingHelper.addShapelessRecipe(new ItemStack(ModItems.multiItems, 9, 3), new Object[] {new ItemStack(ModBlocks.multiBlock1, 1, 14)}); //Block of Pyrite to Pyrite Cystals
	    CraftingHelper.addShapelessRecipe(new ItemStack(ModItems.multiItems, 9, 3), new Object[] {new ItemStack(ModBlocks.multiBlock2, 1, 8)}); //Pyrite Brick to Pyrite Cystals
	    CraftingHelper.addShapedRecipe(new ItemStack(ModBlocks.multiBlock1, 1, 14), new Object[] {"PPP", "PPP", "PPP", 'P', new ItemStack(ModItems.multiItems, 1, 3)}); //Block of Pyrite
	    CraftingHelper.addShapelessRecipe(new ItemStack(ModItems.multiItems, 9, 4), new Object[] {new ItemStack(ModBlocks.multiBlock2, 1, 9)}); //Block of Hematite to Hematite
	    CraftingHelper.addShapedRecipe(new ItemStack(ModBlocks.multiBlock2, 1, 9), new Object[] {"PPP", "PPP", "PPP", 'P', new ItemStack(ModItems.multiItems, 1, 4)}); //Block of Hematite
	    CraftingHelper.addShapedRecipe(new ItemStack(ModBlocks.stairsLepidodendron, 4), new Object[] {"#  ", "## ", "###", '#', new ItemStack(ModBlocks.planks_1, 1, 0)});
	    CraftingHelper.addShapedRecipe(new ItemStack(ModBlocks.stairsCalamites, 4), new Object[] {"#  ", "## ", "###", '#', new ItemStack(ModBlocks.planks_1, 1, 1)});
	    CraftingHelper.addShapedRecipe(new ItemStack(ModBlocks.stairsCordaites, 4), new Object[] {"#  ", "## ", "###", '#', new ItemStack(ModBlocks.planks_1, 1, 2)});
	    CraftingHelper.addShapedRecipe(new ItemStack(ModBlocks.stairsSigillaria, 4), new Object[] {"#  ", "## ", "###", '#', new ItemStack(ModBlocks.planks_1, 1, 3)});
	    CraftingHelper.addShapedRecipe(new ItemStack(ModBlocks.stairsGraniteBrick, 4), new Object[] {"#  ", "## ", "###", '#', new ItemStack(ModBlocks.multiBlock1, 1, 2)});
	    CraftingHelper.addShapedRecipe(new ItemStack(ModBlocks.stairsLimestoneBrick, 4), new Object[] {"#  ", "## ", "###", '#', new ItemStack(ModBlocks.multiBlock1, 1, 4)});
	    CraftingHelper.addShapedRecipe(new ItemStack(ModBlocks.multiBlock2, 4, 3), new Object[] {"BB", "BB", 'B', new ItemStack(ModBlocks.multiBlock1, 1, 2)}); //Granite Tiles
	    CraftingHelper.addShapedRecipe(new ItemStack(ModBlocks.multiBlock2, 4, 4), new Object[] {"BB", "BB", 'B', new ItemStack(ModBlocks.multiBlock1, 1, 4)}); //Limestone Tiles
	    CraftingHelper.addShapedRecipe(new ItemStack(ModBlocks.multiBlock2, 4, 2), new Object[] {" B ", "B B", " B ", 'B', new ItemStack(ModBlocks.multiBlock1, 1, 0)}); //Chiselled Granite
	    CraftingHelper.addShapedRecipe(new ItemStack(ModBlocks.multiBlock2, 4, 7), new Object[] {" B ", "B B", " B ", 'B', new ItemStack(ModBlocks.multiBlock1, 1, 3)}); //Chiselled Limestone
	    CraftingHelper.addShapedRecipe(new ItemStack(ModBlocks.multiBlock2, 4, 14), new Object[] {" B ", "B B", " B ", 'B', new ItemStack(ModBlocks.multiBlock2, 1, 12)}); //Chiselled Basalt
	    CraftingHelper.addShapedRecipe(new ItemStack(ModBlocks.multiBlock2, 4, 0), new Object[] {"GBG", "BRB", "GBG", 'B', new ItemStack(ModBlocks.multiBlock1, 1, 2), 'G', Items.glowstone_dust, 'R', Items.redstone}); //Granite Sunstone
	    CraftingHelper.addShapedRecipe(new ItemStack(Items.arrow, 5), new Object[] {"X", "#", "Y", 'Y', new ItemStack(ModItems.multiItems, 2, 12), 'X', Items.flint, '#', Items.stick}); //Arrows
	    CraftingHelper.addShapedRecipe(new ItemStack(Items.arrow, 5), new Object[] {"X", "#", "Y", 'Y', Items.feather, 'X', new ItemStack(ModItems.multiItems, 1, 11), '#', Items.stick}); //Arrows
	    CraftingHelper.addShapedRecipe(new ItemStack(Items.arrow, 6), new Object[] {"X", "#", "Y", 'Y', new ItemStack(ModItems.multiItems, 2, 12), 'X', new ItemStack(ModItems.multiItems, 1, 11), '#', Items.stick}); //Arrows
	    CraftingHelper.addShapedRecipe(new ItemStack(ModBlocks.multiBlock2, 4, 5), new Object[] {"GL", "LG", 'G', new ItemStack(ModBlocks.multiBlock1, 4, 2), 'L', new ItemStack(ModBlocks.multiBlock1, 4, 4)}); //Checkered Tiles
	    CraftingHelper.addShapedRecipe(new ItemStack(ModBlocks.multiBlock2, 4, 5), new Object[] {"LG", "GL", 'G', new ItemStack(ModBlocks.multiBlock1, 4, 2), 'L', new ItemStack(ModBlocks.multiBlock1, 4, 4)}); //Checkered Tiles
	    CraftingHelper.addShapedRecipe(new ItemStack(ModBlocks.pillars, 1, 0), new Object[] {"B", "B", 'B', new ItemStack(ModBlocks.multiBlock1, 1, 0)}); //Granite Pillar
	    CraftingHelper.addShapedRecipe(new ItemStack(ModBlocks.pillars, 1, 1), new Object[] {"B", "B", 'B', new ItemStack(ModBlocks.multiBlock1, 1, 3)}); //Limestone Pillar
	    CraftingHelper.addShapedRecipe(new ItemStack(ModBlocks.pillars, 1, 2), new Object[] {"B", "B", 'B', new ItemStack(ModBlocks.multiBlock2, 1, 12)}); //Basalt Pillar
	    CraftingHelper.addShapedRecipe(new ItemStack(ModItems.grindingStones, 1, 0), new Object[] {" B ", "BPB", " B ", 'B', new ItemStack(ModBlocks.multiBlock1, 1, 0), 'P', new ItemStack(ModItems.multiItems, 1, 8)}); //Granite Grinding Ball
	    CraftingHelper.addShapedRecipe(new ItemStack(ModItems.grindingStones, 1, 1), new Object[] {" B ", "BSB", " B ", 'B', new ItemStack(Items.iron_ingot), 'S', new ItemStack(ModItems.grindingStones, 1, 0)}); //Iron Grinding Ball
	    
	    CraftingHelper.addShapedRecipe(new ItemStack(ModItems.amphibianSkinBoot, 1), new Object[] {"# #", "# #", '#', new ItemStack(ModItems.multiItems, 1, 10)});//Boots
	    CraftingHelper.addShapedRecipe(new ItemStack(ModItems.amphibianSkinLegging, 1), new Object[] {"###", "# #", "# #", '#', new ItemStack(ModItems.multiItems, 1, 10)});//Leggings
	    CraftingHelper.addShapedRecipe(new ItemStack(ModItems.amphibianSkinChest, 1), new Object[] {"# #", "###", "###", '#', new ItemStack(ModItems.multiItems, 1, 10)});//Chest
	    CraftingHelper.addShapedRecipe(new ItemStack(ModItems.amphibianSkinHelmet, 1), new Object[] {"###", "# #", '#', new ItemStack(ModItems.multiItems, 1, 10)});//Helmet
	    CraftingHelper.addShapedRecipe(new ItemStack(ModItems.flippers, 1), new Object[] {"I I", " B ", "A A", 'I', Items.iron_ingot, 'B', ModItems.amphibianSkinBoot, 'A', new ItemStack(ModItems.multiItems, 1, 10)}); //Flippers
	    
	    CraftingHelper.addShapedRecipe(new ItemStack(Blocks.furnace, 1), new Object[] {"GGG", "G G", "GGG", 'G', new ItemStack(ModBlocks.multiBlock1, 1, 1)}); //Furnace from Granite cobble
	    CraftingHelper.addShapedRecipe(new ItemStack(Blocks.dispenser, 1), new Object[] {"###", "#X#", "#R#", '#', new ItemStack(ModBlocks.multiBlock1, 1, 1), 'X', Items.bow, 'R', Items.redstone});
	    CraftingHelper.addShapelessRecipe(new ItemStack(ModItems.multiItems, 2, 12), new Object[] {ModItems.rawDragonfly}); //Dragonfly wings
	    
	    CraftingHelper.addShapedRecipe(new ItemStack(Items.stone_pickaxe), new Object[] {"CCC", " S ", " S ", 'C', new ItemStack(ModBlocks.multiBlock1, 1, 1), 'S', Items.stick});
	    CraftingHelper.addShapedRecipe(new ItemStack(Items.stone_axe), new Object[] {"CC", "CS", " S", 'C', new ItemStack(ModBlocks.multiBlock1, 1, 1), 'S', Items.stick});
	    CraftingHelper.addShapedRecipe(new ItemStack(Items.stone_shovel), new Object[] {"C", "S", "S", 'C', new ItemStack(ModBlocks.multiBlock1, 1, 1), 'S', Items.stick});
	    CraftingHelper.addShapedRecipe(new ItemStack(Items.stone_hoe), new Object[] {"CC", " S", " S", 'C', new ItemStack(ModBlocks.multiBlock1, 1, 1), 'S', Items.stick});
	    CraftingHelper.addShapedRecipe(new ItemStack(Items.stone_sword), new Object[] {"C", "C", "S", 'C', new ItemStack(ModBlocks.multiBlock1, 1, 1), 'S', Items.stick});
	    
	    CraftingHelper.addShapedRecipe(new ItemStack(ModBlocks.wallsRock, 6, 0), new Object[] {"BBB", "BBB", 'B', new ItemStack(ModBlocks.multiBlock1, 1, 0)}); //Walls - Granite
	    CraftingHelper.addShapedRecipe(new ItemStack(ModBlocks.wallsRock, 6, 1), new Object[] {"BBB", "BBB", 'B', new ItemStack(ModBlocks.multiBlock1, 1, 1)}); //Walls - Granite Cobblestone
	    CraftingHelper.addShapedRecipe(new ItemStack(ModBlocks.wallsRock, 6, 2), new Object[] {"BBB", "BBB", 'B', new ItemStack(ModBlocks.multiBlock1, 1, 2)}); //Walls - Granite Bricks
	    CraftingHelper.addShapedRecipe(new ItemStack(ModBlocks.wallsRock, 6, 3), new Object[] {"BBB", "BBB", 'B', new ItemStack(ModBlocks.multiBlock1, 1, 3)}); //Walls - Limestone
	    CraftingHelper.addShapedRecipe(new ItemStack(ModBlocks.wallsRock, 6, 4), new Object[] {"BBB", "BBB", 'B', new ItemStack(ModBlocks.multiBlock1, 1, 4)}); //Walls - Limestone Brcik
	    CraftingHelper.addShapedRecipe(new ItemStack(ModBlocks.wallsRock, 6, 5), new Object[] {"BBB", "BBB", 'B', new ItemStack(ModBlocks.dirt, 1, 0)}); //Walls - 
	    
	    int[] doors = new int[] {0, 14, 15, 16};
	    int var1 = 0;;
	    for(int item : doors) {
	    	CraftingHelper.addShapedRecipe(new ItemStack(ModItems.multiItems, 1, item), new Object[] {"BBS", "BBS", "BBS", 'B', new ItemStack(ModBlocks.planks_1, 1, var1), 'S', Items.stick}); //Doors
	    	CraftingHelper.addShapedRecipe(new ItemStack(ModItems.multiItems, 1, item), new Object[] {"SBB", "SBB", "SBB", 'B', new ItemStack(ModBlocks.planks_1, 1, var1), 'S', Items.stick}); //Doors
	    	++var1;
	    }
	    
	    GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.multiItems, 1, 17), new Object[] {"WW", "BB", "BB", 'B', new ItemStack(ModItems.multiItems, 1, 10), 'W', "plankWood"}));
	    
		
		CarboniferousApi.addGrinderRecipe(new ItemStack(ModItems.multiItems, 1, 4), new ItemStack(ModItems.multiItems, 1, 3), new ItemStack(ModItems.multiItems, 1, 2));
		CarboniferousApi.addGrinderRecipe(Blocks.stone, null, new ItemStack(Blocks.cobblestone, 1));
		CarboniferousApi.addGrinderRecipe(Blocks.stonebrick, null, new ItemStack(Blocks.stonebrick, 1, 2));
		CarboniferousApi.addGrinderRecipe(ModBlocks.multiBlock1, null, new ItemStack(ModBlocks.multiBlock1, 1, 1));
		CarboniferousApi.addGrinderRecipe(new ItemStack(ModBlocks.multiBlock1, 1, 2), null, new ItemStack(ModBlocks.multiBlock1, 1, 0));
		CarboniferousApi.addGrinderRecipe(new ItemStack(ModBlocks.multiBlock1, 1, 4), null, new ItemStack(ModBlocks.multiBlock1, 1, 3));
		CarboniferousApi.addGrinderRecipe(Blocks.stonebrick, null, new ItemStack(Blocks.stone));
		CarboniferousApi.addGrinderRecipe(new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE), null, new ItemStack(ModItems.multiItems, 1, 13));
		CarboniferousApi.addGrinderRecipe(ModBlocks.sand, null, new ItemStack(Blocks.sand));
		CarboniferousApi.addGrinderRecipe(new ItemStack(ModBlocks.coral, 1, 0), null, new ItemStack(Items.dye, 4, 14));
		CarboniferousApi.addGrinderRecipe(new ItemStack(ModBlocks.coral, 1, 1), null, new ItemStack(Items.dye, 4, 11));
		CarboniferousApi.addGrinderRecipe(new ItemStack(ModBlocks.coral, 1, 2), null, new ItemStack(Items.dye, 4, 1));
		CarboniferousApi.addGrinderRecipe(new ItemStack(ModBlocks.coral, 1, 3), null, new ItemStack(Items.dye, 4, 7));
		CarboniferousApi.addGrinderRecipe(new ItemStack(ModBlocks.coral, 1, 4), null, new ItemStack(Items.glowstone_dust, 4));
		CarboniferousApi.addGrinderRecipe(new ItemStack(ModBlocks.multiBlock3, 1, 3), null, new ItemStack(Items.diamond, 1));
		
		CarboniferousApi.addGrinderComponent(new ItemStack(ModItems.grindingStones, 1, 0), 3200, 1);
		CarboniferousApi.addGrinderComponent(new ItemStack(ModItems.grindingStones, 1, 1), 9600, 1);
	}
	
}
