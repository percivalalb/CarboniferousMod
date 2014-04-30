package carboniferous.core.handlers;

import carboniferous.CarboniferousMod;
import carboniferous.ModBlocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

/**
 * @author ProPercivalalb
 **/
public class FuelHandler implements IFuelHandler {

	@Override
	public int getBurnTime(ItemStack fuel) {
		Item item = fuel.getItem();
		int meta = fuel.getItemDamage();
		if(item == Item.getItemFromBlock(ModBlocks.saplings_1)) {
			return 100;
		}
		return 0;
	}

}
