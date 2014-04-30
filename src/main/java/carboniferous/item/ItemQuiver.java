package carboniferous.item;

import carboniferous.api.CarboniferousApi;
import carboniferous.api.Properties;
import carboniferous.client.model.ModelFlippers;
import carboniferous.client.model.ModelQuiver;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemQuiver extends ItemArmor {

	public ItemQuiver(int renderId) {
		super(CarboniferousApi.armorQuiver, renderId, 1);
		this.setMaxStackSize(1);
		this.setMaxDamage(128);
		this.setCreativeTab(null);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
    public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot) {
		return new ModelQuiver();
    }
	
	@Override
	public boolean isValidArmor(ItemStack stack, int armorType, Entity entity) { 
	    if (armorType == 1) {
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
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		return Properties.TEX_ARMOR_QUIVER;
    }
	
 	@SideOnly(Side.CLIENT)
 	@Override
 	public void registerIcons(IIconRegister par1IconRegister) {
 		this.itemIcon = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "quiver");
	}
}
