package carboniferous.creativetab;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import carboniferous.CarboniferousMod;
import carboniferous.ModBlocks;
import carboniferous.ModItems;
import carboniferous.api.interfaces.ICarboniferousTab;


import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * @author ProPercivalalb
 **/
public class CreativeTabCarboniferous extends CreativeTabs {

	public static List<Integer> spawnersList = new ArrayList<Integer>();
	
	public CreativeTabCarboniferous() {
		super("carboniferous");
	}

	@SideOnly(Side.CLIENT)
	@Override
    public void displayAllReleventItems(List par1List) {
		addStuffToTab(par1List);
		
		Iterator<Integer> it = spawnersList.iterator();
		while(it.hasNext()) {
			par1List.add(new ItemStack(Item.monsterPlacer, 1, it.next()));
		}
		
		for (ModContainer mod : Loader.instance().getModList()) {
			if(mod instanceof ICarboniferousTab) {
				((ICarboniferousTab)mod).addCarboniferousAddons(this, par1List);
			}
        }
    }
	
	public static void addStuffToTab(List par1List) {
		par1List.add(new ItemStack(ModBlocks.grass));
		par1List.add(new ItemStack(ModBlocks.dirt));
		par1List.add(new ItemStack(ModBlocks.dirt, 1, 1));
		for(int var1 = 0; var1 <= 14; ++var1) {
        	par1List.add(new ItemStack(ModBlocks.multiBlock1, 1, var1));
        	if(var1 == 1)par1List.add(new ItemStack(ModBlocks.multiBlock2, 1, 13));
        	if(var1 == 9) par1List.add(new ItemStack(ModBlocks.multiBlock2, 1, 6));
        	if(var1 == 14) par1List.add(new ItemStack(ModBlocks.multiBlock2, 1, 8));
        	if(var1 == 14) par1List.add(new ItemStack(ModBlocks.multiBlock2, 1, 9));
        }
        par1List.add(new ItemStack(ModBlocks.stairsGraniteBrick, 1, 0));
        par1List.add(new ItemStack(ModBlocks.stairsLimestoneBrick, 1, 0));
		for(int var1 = 0; var1 <= 13; ++var1) {
        	if(var1 == 1 || var1 == 6 || var1 == 8 || var1 == 9 || var1 == 10 || var1 == 13 || var1 == 14) continue;
        	par1List.add(new ItemStack(ModBlocks.multiBlock2, 1, var1));
        	if(var1 == 3) par1List.add(new ItemStack(ModBlocks.multiBlock2, 1, 7));
        	if(var1 == 3) par1List.add(new ItemStack(ModBlocks.multiBlock2, 1, 10));
        	if(var1 == 11) par1List.add(new ItemStack(ModBlocks.multiBlock3, 1, 3));
        	if(var1 == 12) par1List.add(new ItemStack(ModBlocks.multiBlock2, 1, 14));
        }
		for(int var1 = 0; var1 <= 3; ++var1) {
			if(var1 == 3) continue;
			par1List.add(new ItemStack(ModBlocks.multiBlock3, 1, var1));
		}
		for(int var1 = 0; var1 < 3; ++var1) {
			par1List.add(new ItemStack(ModBlocks.pillars, 1, var1));
		}
		for(int var1 = 0; var1 <= 5; ++var1) {
        	par1List.add(new ItemStack(ModBlocks.wallsRock, 1, var1));
        }
		par1List.add(new ItemStack(ModBlocks.sand, 1, 0));
		par1List.add(new ItemStack(ModBlocks.clearGlass, 1, 0));
		par1List.add(new ItemStack(ModBlocks.fern, 1, 0));
		par1List.add(new ItemStack(ModBlocks.vines, 1, 0));
		for(int var1 = 0; var1 <= 4; ++var1) {
        	par1List.add(new ItemStack(ModBlocks.coral, 1, var1));
        }
		for(int var1 = 0; var1 <= 3; ++var1) {
        	par1List.add(new ItemStack(ModBlocks.logs_1, 1, var1));
        }
		for(int var1 = 0; var1 <= 3; ++var1) {
        	par1List.add(new ItemStack(ModBlocks.leaves_1, 1, var1));
        }
		for(int var1 = 0; var1 <= 3; ++var1) {
        	par1List.add(new ItemStack(ModBlocks.saplings_1, 1, var1));
        }
		for(int var1 = 0; var1 <= 3; ++var1) {
        	par1List.add(new ItemStack(ModBlocks.planks_1, 1, var1));
        }
		for(int var1 = 0; var1 <= 3; ++var1) {
        	par1List.add(new ItemStack(ModBlocks.woodSingleSlab, 1, var1));
        }
		
        par1List.add(new ItemStack(ModBlocks.stairsLepidodendron, 1, 0));
        par1List.add(new ItemStack(ModBlocks.stairsCalamites, 1, 0));
        par1List.add(new ItemStack(ModBlocks.stairsCordaites, 1, 0));
        par1List.add(new ItemStack(ModBlocks.stairsSigillaria, 1, 0));
        par1List.add(new ItemStack(ModItems.multiItems, 1, 0));
        par1List.add(new ItemStack(ModItems.multiItems, 1, 14));
        par1List.add(new ItemStack(ModItems.multiItems, 1, 15));
        par1List.add(new ItemStack(ModItems.multiItems, 1, 16));
        par1List.add(new ItemStack(ModItems.multiItems, 1, 17));
        par1List.add(new ItemStack(ModBlocks.antHill, 1, 0));
		par1List.add(new ItemStack(ModBlocks.timeBox, 1, 0));
		par1List.add(new ItemStack(ModItems.multiItems, 1, 5));
		par1List.add(new ItemStack(ModBlocks.portal, 1, 0));
		par1List.add(new ItemStack(ModBlocks.grinder, 1, 0));
		for(int var1 = 0; var1 <= 1; ++var1) {
        	par1List.add(new ItemStack(ModItems.grindingStones, 1, var1));
        }
		
		par1List.add(new ItemStack(ModItems.amphibianSkinHelmet, 1, 0));
		par1List.add(new ItemStack(ModItems.amphibianSkinChest, 1, 0));
		par1List.add(new ItemStack(ModItems.amphibianSkinLegging, 1, 0));
		par1List.add(new ItemStack(ModItems.amphibianSkinBoot, 1, 0));
		par1List.add(new ItemStack(ModItems.flippers, 1, 0));
		par1List.add(new ItemStack(ModItems.net, 1, 0));
		//par1List.add(new ItemStack(ModItems.quiver, 1, 0));
		for(int var1 = 0; var1 <= 13; ++var1) {
			if(var1 == 5 || var1 == 0) continue;
 			par1List.add(new ItemStack(ModItems.multiItems, 1, var1));
 		}
		
		par1List.add(new ItemStack(ModItems.rawDragonfly, 1, 0));
		par1List.add(new ItemStack(ModItems.cookedDragonfly, 1, 0));
		par1List.add(new ItemStack(ModItems.rawAmphibian, 1, 0));
		par1List.add(new ItemStack(ModItems.cookedAmphibian, 1, 0));
		par1List.add(new ItemStack(ModItems.rawAnt, 1, 0));
		par1List.add(new ItemStack(ModItems.cookedAnt, 1, 0));
	}
	
	@Override
	public ItemStack getIconItemStack() {
        return new ItemStack(ModItems.multiItems.itemID, 1, 6);
    }
}
