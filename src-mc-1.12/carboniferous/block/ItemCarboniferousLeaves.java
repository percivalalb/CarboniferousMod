package carboniferous.block;

import net.minecraft.block.BlockLeaves;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemCarboniferousLeaves extends ItemBlock {
	
    private final BlockCarboniferousLeaves leaves;

    public ItemCarboniferousLeaves(BlockCarboniferousLeaves block) {
        super(block);
        this.leaves = block;
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    @Override
    public int getMetadata(int damage) {
        return damage | 4;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return super.getUnlocalizedName() + "." + EnumWood.byMetadata((stack.getMetadata() & 3) % 4).getUnlocalizedName();
    }
}