package carboniferous;

import carboniferous.item.ItemAmphibianSkin;
import carboniferous.item.ItemAnt;
import carboniferous.item.ItemCustomFood;
import carboniferous.item.ItemFlippers;
import carboniferous.item.ItemGrindingStones;
import carboniferous.item.ItemHuntersBow;
import carboniferous.item.ItemMultipleItems;
import carboniferous.item.ItemNet;
import carboniferous.item.ItemQuiver;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

/**
 * @author ProPercivalalb
 */
public class ModItems {

	public static Item flippers;
	public static Item multiItems;
	public static Item amphibianSkinHelmet;
	public static Item amphibianSkinChest;
	public static Item amphibianSkinLegging;
	public static Item amphibianSkinBoot;
	public static Item huntersBow;
	public static Item grindingStones;
	public static Item rawAnt;
	public static Item cookedAnt;
	public static Item rawDragonfly;
	public static Item cookedDragonfly;
	public static Item rawAmphibian;
	public static Item cookedAmphibian;
	public static Item quiver;
	
	public static Item net;
	
	public static void init() {
		//Init Item Variables
		flippers = new ItemFlippers(CarboniferousMod.proxy.armorRender("carbon.flippers"), 3).setUnlocalizedName("carbon.flippers");
		multiItems = new ItemMultipleItems().setUnlocalizedName("carbon.multipleItems");
		amphibianSkinHelmet = new ItemAmphibianSkin(CarboniferousMod.proxy.armorRender("carbon.amphibianSkin"), 0).setUnlocalizedName("carbon.amphibianSkinHelmet");
		amphibianSkinChest = new ItemAmphibianSkin(CarboniferousMod.proxy.armorRender("carbon.amphibianSkin"), 1).setUnlocalizedName("carbon.amphibianSkinChest");
		amphibianSkinLegging = new ItemAmphibianSkin(CarboniferousMod.proxy.armorRender("carbon.amphibianSkin"), 2).setUnlocalizedName("carbon.amphibianSkinLegging");
		amphibianSkinBoot = new ItemAmphibianSkin(CarboniferousMod.proxy.armorRender("carbon.amphibianSkin"), 3).setUnlocalizedName("carbon.amphibianSkinBoot");
		huntersBow = new ItemHuntersBow().setUnlocalizedName("carbon.huntersBow");
		grindingStones =  new ItemGrindingStones().setUnlocalizedName("carbon.grindingStones");
		rawAnt = new ItemAnt(1, 0.3F).setUnlocalizedName("carbon.rawAnt");
		cookedAnt = new ItemAnt(3, 0.4F).setUnlocalizedName("carbon.cookedAnt");
		rawDragonfly = new ItemCustomFood(3, 0.1F, false).setUnlocalizedName("carbon.rawDragonfly");
		cookedDragonfly = new ItemCustomFood(4, 0.2F, false).setUnlocalizedName("carbon.cookedDragonfly");
		rawAmphibian = new ItemCustomFood(4, 0.7F, true).setUnlocalizedName("carbon.rawAmphibian");
		cookedAmphibian = new ItemCustomFood(6, 1.1F, true).setUnlocalizedName("carbon.cookedAmphibian");
		quiver = new ItemQuiver(CarboniferousMod.proxy.armorRender("carbon.quiver")).setUnlocalizedName("carbon.quiver");	
		net = new ItemNet().setUnlocalizedName("carbon.net");
		
		GameRegistry.registerItem(flippers, "flippers");
		GameRegistry.registerItem(multiItems, "multiitems");
		GameRegistry.registerItem(amphibianSkinHelmet, "amphibianskinhelmet");
		GameRegistry.registerItem(amphibianSkinChest, "amphibianskinchestplate");
		GameRegistry.registerItem(amphibianSkinLegging, "amphibianskinlegging");
		GameRegistry.registerItem(amphibianSkinBoot, "amphibianskinboot");
		GameRegistry.registerItem(huntersBow, "huntersbow");
		GameRegistry.registerItem(grindingStones, "grindingstones");
		GameRegistry.registerItem(rawAnt, "rawant");
		GameRegistry.registerItem(cookedAnt, "cookedant");
		GameRegistry.registerItem(rawDragonfly, "rawdragonfly");
		GameRegistry.registerItem(cookedDragonfly, "cookeddragonfly");
		GameRegistry.registerItem(rawAmphibian, "rawamphibian");
		GameRegistry.registerItem(cookedAmphibian, "cookedamphibian");
		GameRegistry.registerItem(quiver, "quiver");
		GameRegistry.registerItem(net, "net");
	}	
}
