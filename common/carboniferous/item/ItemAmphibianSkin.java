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
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class ItemAmphibianSkin extends ItemArmor {

	public static Icon iconHelmet;
	public static Icon iconChest;
	public static Icon iconLegging;
	public static Icon iconBoot;
	
	public ItemAmphibianSkin(int par1, int par2, int par3) {
		super(par1, CarboniferousApi.armorAmphibianSkin, par2, par3);
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
	public void onArmorTickUpdate(World world, EntityPlayer player, ItemStack itemStack) {
		
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer) {
	    if(slot == 2) {
	    	return Properties.TEX_ARMOR_AMPHIBIAN_SKIN_2;
	    }
	    else {
	    	return Properties.TEX_ARMOR_AMPHIBIAN_SKIN_1;
	    }
    }
	
 	@SideOnly(Side.CLIENT)
 	@Override
 	public void registerIcons(IconRegister par1IconRegister) {
 		this.iconHelmet = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "helmetAmphibianSkin");
 		this.iconChest = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "chestAmphibianSkin");
 		this.iconLegging = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "leggingsAmphibianSkin");
 		this.iconBoot = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "bootsAmphibianSkin");
	}
 
 	public Icon getIconFromDamage(int par1) {
 	    switch(this.armorType) {
 	    case 0: return this.iconHelmet;
 	    case 1: return this.iconChest;
 	    case 2: return this.iconLegging;
 	    case 3: return this.iconBoot;
 	    default: return null;
 	    }
 	}
}
