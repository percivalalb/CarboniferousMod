package carboniferous.item;

import carboniferous.ModItems;
import carboniferous.api.Properties;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemFood;
import net.minecraft.util.Icon;

public class ItemAnt extends ItemFood {

	public ItemAnt(int par1, int par2, float par3) {
		super(par1, par2, par3, false);
		this.setCreativeTab(null);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		if(this.itemID == ModItems.cookedAnt.itemID) {
			this.itemIcon = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "cookedAnt");
		}
		else {
			this.itemIcon = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "ant");
		}
	}

	@Override
	public IIcon getIconFromDamage(int meta) {
		return this.itemIcon;
	}
}
