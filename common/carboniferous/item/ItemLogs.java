package carboniferous.item;

import java.util.logging.Level;

import carboniferous.api.Properties;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

/**
 * @author ProPercivalalb
 **/
public class ItemLogs extends ItemBlock {
    
	private Block targetBlock;

    public ItemLogs(int par1) {
        super(par1);
        this.targetBlock = Block.blocksList[par1 + 256];
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public Icon getIconFromDamage(int par1) {
        return this.targetBlock.getIcon(2, par1);
    }

    @Override
    public int getMetadata(int par1) {
        return par1;
    }
    
    @Override
    public String getUnlocalizedName(ItemStack par1ItemStack) {
        int i = par1ItemStack.getItemDamage();
        return super.getUnlocalizedName() + "." + i;
    }
}
