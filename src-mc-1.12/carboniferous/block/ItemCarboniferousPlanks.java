package carboniferous.block;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemCarboniferousPlanks extends ItemBlock {

    public ItemCarboniferousPlanks(Block block) {
        super(block);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    @Override
    public int getMetadata(int damage) {
        return damage;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return super.getUnlocalizedName() + "." + EnumWood.byMetadata(stack.getMetadata()).getUnlocalizedName();
    }
}