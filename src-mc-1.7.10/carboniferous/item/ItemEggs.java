package carboniferous.item;

import carboniferous.api.Properties;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

public class ItemEggs extends Item {

	public static IIcon[] eggIcon = new IIcon[16];
	
 	@Override
	@SideOnly(Side.CLIENT)
 	public void registerIcons(IIconRegister par1IconRegister) {
 		this.eggIcon[0] = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "egg");
 		this.eggIcon[1] = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "fertiliser");
 	}
 	
 	@Override
	public IIcon getIconFromDamage(int meta) {
		return this.eggIcon[meta % eggIcon.length];
	}
}
