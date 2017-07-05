package carboniferous.creativetab;

import carboniferous.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @author ProPercivalalb
 */
public class CreativeTabCarboniferous extends CreativeTabs {

	public CreativeTabCarboniferous() {
		super("carboniferous");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public ItemStack getTabIconItem() {
		return new ItemStack(Items.ACACIA_BOAT);
	}
}
