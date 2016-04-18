package carboniferous.core.handlers;

import carboniferous.ModBlocks;
import cpw.mods.fml.common.IFuelHandler;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

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
