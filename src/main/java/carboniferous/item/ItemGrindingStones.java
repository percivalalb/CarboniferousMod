package carboniferous.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import carboniferous.api.CarboniferousApi;
import carboniferous.api.Properties;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

/**
 * @author ProPercivalalb
 **/
public class ItemGrindingStones extends Item {

	public static IIcon grindingStone;
	public static IIcon ironGrindingBall;
	
	public ItemGrindingStones() {
		super();
		this.setCreativeTab(null);
		this.setMaxStackSize(1);
		this.setHasSubtypes(true);
	}

	@SideOnly(Side.CLIENT)
 	@Override
 	public void registerIcons(IIconRegister par1IconRegister) {
 		this.grindingStone = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "GrindingStone");
 		this.ironGrindingBall = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "IronGrindingBall");
 	}
 	
 	public IIcon getIconFromDamage(int par1) {
 		switch(par1) {
 		case 0: return this.grindingStone;
 		case 1: return this.ironGrindingBall;
 		default: return null;
 		}
 	}

 	@Override
    public String getUnlocalizedName(ItemStack par1ItemStack) {
        int i = par1ItemStack.getItemDamage();
        return super.getUnlocalizedName() + "." + i;
    }
}
