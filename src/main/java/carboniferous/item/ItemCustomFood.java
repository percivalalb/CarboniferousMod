package carboniferous.item;

import java.util.List;

import carboniferous.ModItems;
import carboniferous.api.CarboniferousApi;
import carboniferous.api.Properties;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

/**
 * @author ProPercivalalb
 **/
public class ItemCustomFood extends ItemFood {

	public static IIcon iconDragonflyRaw;
	public static IIcon iconDragonflyCooked;
	public static IIcon iconMeatAmphibianRaw;
	public static IIcon iconMeatAmphibianCooked;
	
	public ItemCustomFood(int par2, float par3, boolean par4) {
		super(par2, par3, par4);
		this.setCreativeTab(null);
	}
	
	@SideOnly(Side.CLIENT)
 	@Override
 	public void registerIcons(IIconRegister par1IconRegister) {
 		this.iconDragonflyRaw = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "dragonflyRaw");
 		this.iconDragonflyCooked = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "dragonflyCooked");
 		this.iconMeatAmphibianRaw = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "meatAmphibianRaw");
 		this.iconMeatAmphibianCooked = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "meatAmphibianCooked");
 	}
 	
 	public IIcon getIconFromDamage(int par1) {
 		if(this == ModItems.rawDragonfly) {
 			return this.iconDragonflyRaw;
 		}
 		else if(this == ModItems.cookedDragonfly) {
 	 		return this.iconDragonflyCooked;
 		}
 		else if(this == ModItems.rawAmphibian) {
 	 		return this.iconMeatAmphibianRaw;
 		}
 		else if(this == ModItems.cookedAmphibian) {
 	 		return this.iconMeatAmphibianCooked;
 		}
 		return null;
 	}
 	
    @Override
    public int getMaxItemUseDuration(ItemStack par1ItemStack) {
        return 32;
    }

    @Override
    public EnumAction getItemUseAction(ItemStack par1ItemStack) {
        return EnumAction.eat;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
        return super.onItemRightClick(par1ItemStack, par2World, par3EntityPlayer);
    }
}
