package carboniferous.item;

import java.util.List;

import carboniferous.ModItems;
import carboniferous.api.CarboniferousApi;
import carboniferous.api.Properties;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

/**
 * @author ProPercivalalb
 **/
public class ItemCustomFood extends ItemFood {

	public static Icon iconDragonflyRaw;
	public static Icon iconDragonflyCooked;
	public static Icon iconMeatAmphibianRaw;
	public static Icon iconMeatAmphibianCooked;
	
	public ItemCustomFood(int par1, int par2, float par3, boolean par4) {
		super(par1, par2, par3, par4);
		this.setCreativeTab(null);
	}
	
	@SideOnly(Side.CLIENT)
 	@Override
 	public void registerIcons(IconRegister par1IconRegister) {
 		this.iconDragonflyRaw = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "dragonflyRaw");
 		this.iconDragonflyCooked = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "dragonflyCooked");
 		this.iconMeatAmphibianRaw = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "meatAmphibianRaw");
 		this.iconMeatAmphibianCooked = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "meatAmphibianCooked");
 	}
 	
 	public Icon getIconFromDamage(int par1) {
 		if(itemID == ModItems.rawDragonfly.itemID) {
 			return this.iconDragonflyRaw;
 		}
 		else if(itemID == ModItems.cookedDragonfly.itemID) {
 	 		return this.iconDragonflyCooked;
 		}
 		else if(itemID == ModItems.rawAmphibian.itemID) {
 	 		return this.iconMeatAmphibianRaw;
 		}
 		else if(itemID == ModItems.cookedAmphibian.itemID) {
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
