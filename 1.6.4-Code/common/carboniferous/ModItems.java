package carboniferous;

import carboniferous.api.Properties;
import carboniferous.item.ItemAmphibianSkin;
import carboniferous.item.ItemAnt;
import carboniferous.item.ItemCustomFood;
import carboniferous.item.ItemFlippers;
import carboniferous.item.ItemGrindingStones;
import carboniferous.item.ItemHuntersBow;
import carboniferous.item.ItemMultipleItems;
import carboniferous.item.ItemNet;
import carboniferous.item.ItemQuiver;
import net.minecraft.block.Block;
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
		flippers = new ItemFlippers(Properties.ID_FLIPPERS, CarboniferousMod.proxy.armorRender("carbon.flippers"), 3).setUnlocalizedName("carbon.flippers");
		multiItems = new ItemMultipleItems(Properties.ID_MULTI_ITEMS).setUnlocalizedName("carbon.multipleItems");
		amphibianSkinHelmet = new ItemAmphibianSkin(Properties.ID_AMPHIBIAN_SKIN_HELMET, CarboniferousMod.proxy.armorRender("carbon.amphibianSkin"), 0).setUnlocalizedName("carbon.amphibianSkinHelmet");
		amphibianSkinChest = new ItemAmphibianSkin(Properties.ID_AMPHIBIAN_SKIN_CHEST, CarboniferousMod.proxy.armorRender("carbon.amphibianSkin"), 1).setUnlocalizedName("carbon.amphibianSkinChest");
		amphibianSkinLegging = new ItemAmphibianSkin(Properties.ID_AMPHIBIAN_SKIN_LEGGING, CarboniferousMod.proxy.armorRender("carbon.amphibianSkin"), 2).setUnlocalizedName("carbon.amphibianSkinLegging");
		amphibianSkinBoot = new ItemAmphibianSkin(Properties.ID_AMPHIBIAN_SKIN_BOOT, CarboniferousMod.proxy.armorRender("carbon.amphibianSkin"), 3).setUnlocalizedName("carbon.amphibianSkinBoot");
		huntersBow = new ItemHuntersBow(Properties.ID_HUNTERS_BOW).setUnlocalizedName("carbon.huntersBow");
		grindingStones =  new ItemGrindingStones(Properties.ID_GRINDING_STONES).setUnlocalizedName("carbon.grindingStones");
		rawAnt = new ItemAnt(Properties.ID_ANT, 1, 0.3F).setUnlocalizedName("carbon.rawAnt");
		cookedAnt = new ItemAnt(Properties.ID_ANT_COOKED, 3, 0.4F).setUnlocalizedName("carbon.cookedAnt");
		rawDragonfly = new ItemCustomFood(Properties.ID_RAW_DRAGONFLY, 3, 0.1F, false).setUnlocalizedName("carbon.rawDragonfly");
		cookedDragonfly = new ItemCustomFood(Properties.ID_COOKED_DRAGONFLY, 4, 0.2F, false).setUnlocalizedName("carbon.cookedDragonfly");
		rawAmphibian = new ItemCustomFood(Properties.ID_RAW_AMPHIBIAN, 4, 0.7F, true).setUnlocalizedName("carbon.rawAmphibian");
		cookedAmphibian = new ItemCustomFood(Properties.ID_COOKED_AMPHIBIAN, 6, 1.1F, true).setUnlocalizedName("carbon.cookedAmphibian");
		quiver = new ItemQuiver(Properties.ID_QUIVER, CarboniferousMod.proxy.armorRender("carbon.quiver")).setUnlocalizedName("carbon.quiver");	
		net = new ItemNet(Properties.ID_NET).setUnlocalizedName("carbon.net");
	}	
}
