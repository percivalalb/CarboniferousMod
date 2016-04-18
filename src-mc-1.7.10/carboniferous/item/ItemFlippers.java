package carboniferous.item;

import carboniferous.api.CarboniferousApi;
import carboniferous.api.Properties;
import carboniferous.core.proxy.ClientProxy;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

/**
 * @author ProPercivalalb
 **/
public class ItemFlippers extends ItemArmor {

	public static IIcon icon;
	
	public ItemFlippers(int par2, int par3) {
		super(CarboniferousApi.armorFlippers, par2, par3);
		this.setCreativeTab(null);
	}

	@SideOnly(Side.CLIENT)
	@Override
    public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot) {
		return ClientProxy.flippers;
    }
	
	@Override
	public boolean isValidArmor(ItemStack stack, int armorType, Entity entity) {
		return armorType == 3 ? true : false;
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
		if(!player.capabilities.isFlying) {
			if(player.isInWater()) {
				player.motionX *= 1.17D;
				player.motionZ *= 1.17D;
				if((player.isSneaking())) {
					player.motionY = 0.0D;
				}
				//else if(!player.isSneaking() && player.isJumping){
				//	player.motionY = 0.15D;
				//}
			}
			else if(!player.isInWater() && player.onGround) {
				player.motionX *= 0.55D;
				player.motionY *= 0.53D;
				player.motionZ *= 0.55D;
			}
		}
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		return Properties.TEX_ARMOR_FLIPPERS;
    }
	
 	@SideOnly(Side.CLIENT)
 	@Override
 	public void registerIcons(IIconRegister par1IconRegister) {
 		this.icon = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "flippers");
	}
 	
 	@Override
 	public IIcon getIconFromDamage(int par1) {
 	    return this.icon;
 	}
}
