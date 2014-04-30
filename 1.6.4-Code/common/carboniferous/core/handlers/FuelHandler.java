package carboniferous.core.handlers;

import carboniferous.CarboniferousMod;
import carboniferous.ModBlocks;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

/**
 * @author ProPercivalalb
 **/
public class FuelHandler implements IFuelHandler {

	@Override
	public int getBurnTime(ItemStack fuel) {
		int id = fuel.itemID;
		int meta = fuel.getItemDamage();
		if(id == ModBlocks.saplings_1.blockID) {
			return 100;
		}
		return 0;
	}

}
