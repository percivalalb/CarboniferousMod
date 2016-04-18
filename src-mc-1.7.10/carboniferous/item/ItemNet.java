package carboniferous.item;

import carboniferous.api.Properties;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

public class ItemNet extends Item {

	public static IIcon iconNet;
	
	public ItemNet() {
		super();
		this.setMaxDamage(60);
	}
	
 	@SideOnly(Side.CLIENT)
 	@Override
 	public void registerIcons(IIconRegister par1IconRegister) {
 		this.iconNet = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "net");
 	}
 	
 	@Override
 	public IIcon getIconFromDamage(int par1) {
 		return this.iconNet;
 	}
 	
 	@Override
 	public boolean isRepairable() {
 		return true;
 	}
}
