package carboniferous.item;

import java.util.List;
import java.util.logging.Level;

import carboniferous.api.CarboniferousApi;
import carboniferous.api.Properties;
import carboniferous.client.model.ModelFlippers;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class ItemAmphibianSkin extends ItemArmor {

	public static IIcon iconHelmet;
	public static IIcon iconChest;
	public static IIcon iconLegging;
	public static IIcon iconBoot;
	
	public ItemAmphibianSkin(int par2, int par3) {
		super(CarboniferousApi.armorAmphibianSkin, par2, par3);
		this.setCreativeTab(null);
	}
	
	@Override
	public boolean isValidArmor(ItemStack stack, int armorType, Entity entity) { 
	    if(this.armorType == armorType) {
	    	return true;
	    }
	    return false;
	}
	
	@Override
	public boolean hasColor(ItemStack par1ItemStack) {
		return false;
	}
	
	@SideOnly(Side.CLIENT)
	@Override
    public boolean requiresMultipleRenderPasses() {
        return false;
    }
	
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack stack) {

	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
	    if(slot == 2) {
	    	return Properties.TEX_ARMOR_AMPHIBIAN_SKIN_2;
	    }
	    else {
	    	return Properties.TEX_ARMOR_AMPHIBIAN_SKIN_1;
	    }
    }
	
 	@SideOnly(Side.CLIENT)
 	@Override
 	public void registerIcons(IIconRegister iconRegistry) {
 		this.iconHelmet = iconRegistry.registerIcon(Properties.TEX_PACkAGE + "helmetAmphibianSkin");
 		this.iconChest = iconRegistry.registerIcon(Properties.TEX_PACkAGE + "chestAmphibianSkin");
 		this.iconLegging = iconRegistry.registerIcon(Properties.TEX_PACkAGE + "leggingsAmphibianSkin");
 		this.iconBoot = iconRegistry.registerIcon(Properties.TEX_PACkAGE + "bootsAmphibianSkin");
	}
 
 	public IIcon getIconFromDamage(int meta) {
 	    switch(this.armorType) {
 	    case 0: return this.iconHelmet;
 	    case 1: return this.iconChest;
 	    case 2: return this.iconLegging;
 	    case 3: return this.iconBoot;
 	    default: return null;
 	    }
 	}
}
