package carboniferous.item;

import java.util.List;
import java.util.logging.Level;

import carboniferous.CarboniferousMod;
import carboniferous.ModBlocks;
import carboniferous.api.CarboniferousApi;
import carboniferous.api.Properties;
import carboniferous.client.model.ModelFlippers;
import carboniferous.tileentity.TileEntityWallShell;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

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
