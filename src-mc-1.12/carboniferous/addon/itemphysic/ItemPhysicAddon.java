package carboniferous.addon.itemphysic;

import carboniferous.ModBlocks;
import carboniferous.ModItems;
import carboniferous.addon.AddonEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * @author ProPercivalalb
 */
public class ItemPhysicAddon {

	private static ItemPhysicAPI API = new ItemPhysicAPI(ItemPhysicLib.MOD_ID);
	
	@SubscribeEvent
	public void onPre(AddonEvent.Pre event) {
		if(!Loader.isModLoaded(ItemPhysicLib.MOD_ID))
			return;
	}
	
	@SubscribeEvent
	public void onInit(AddonEvent.Init event) {
		if(!Loader.isModLoaded(ItemPhysicLib.MOD_ID))
			return;
	}

	@SubscribeEvent
	public void onPost(AddonEvent.Post event) throws Exception {
		if(!Loader.isModLoaded(ItemPhysicLib.MOD_ID))
			return;
		
		API.addSortingBlocks(ItemPhysicLib.BURNING_ITEMS_FIELD);
		API.addSortingItems(ItemPhysicLib.BURNING_ITEMS_FIELD);
		
		
		API.addSortingItems(ItemPhysicLib.SWIMMING_ITEMS_FIELD);
	}

}
