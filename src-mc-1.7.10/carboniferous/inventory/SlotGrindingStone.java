package carboniferous.inventory;

import carboniferous.recipe.CarboniferousRecipes;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotGrindingStone extends Slot {

    public SlotGrindingStone(IInventory par2IInventory, int par3, int par4, int par5) {
        super(par2IInventory, par3, par4, par5);
    }

    @Override
    public boolean isItemValid(ItemStack stack) {
    	if(stack == null) return false;
    	int dur = CarboniferousRecipes.getComponentDurability(stack);
		if(dur != -1 || dur != 0) {
			return true;
		}
        return false;
    }
}
