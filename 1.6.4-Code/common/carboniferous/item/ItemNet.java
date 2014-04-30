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
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class ItemNet extends Item {

	public static IIcon iconNet;
	
	public ItemNet(int par1) {
		super(par1);
		this.setMaxDamage(60);
	}
	
 	@SideOnly(Side.CLIENT)
 	@Override
 	public void registerIcons(IconRegister par1IconRegister) {
 		this.iconNet = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "net");
 	}
 	
 	public IIcon getIconFromDamage(int par1) {
 		return this.iconNet;
 	}
 	
 	public boolean isRepairable() {
 		return true;
 	}
}
