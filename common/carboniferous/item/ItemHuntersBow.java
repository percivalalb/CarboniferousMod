package carboniferous.item;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import carboniferous.api.CarboniferousApi;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;

public class ItemHuntersBow extends ItemBow {

	public static final String[] bowPullIconNameArray = new String[] {"bow_pull_0", "bow_pull_1", "bow_pull_2"};
	@SideOnly(Side.CLIENT)
	private Icon[] iconArray;
	
	public ItemHuntersBow(int par1) {
		super(par1);
		this.setCreativeTab(null);
		this.setMaxDamage(456);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister par1IconRegister) {
	    super.registerIcons(par1IconRegister);
	    this.iconArray = new Icon[bowPullIconNameArray.length];

	    for (int i = 0; i < this.iconArray.length; ++i) {
	            this.iconArray[i] = par1IconRegister.registerIcon(bowPullIconNameArray[i]);
	    }
	}
	
	public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer, int par4) {
       
    }
	
	public void useBow(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer, int par4) {
		 int j = this.getMaxItemUseDuration(par1ItemStack) - par4;

	        ArrowLooseEvent event = new ArrowLooseEvent(par3EntityPlayer, par1ItemStack, j);
	        MinecraftForge.EVENT_BUS.post(event);
	        if (event.isCanceled()) {
	            return;
	        }
	        j = event.charge;

	        boolean flag = par3EntityPlayer.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, par1ItemStack) > 0;

	        if (flag || par3EntityPlayer.inventory.hasItem(Item.arrow.itemID)) {
	            float f = (float)j / 20.0F;
	            f = (f * f + f * 2.0F) / 1.0F;

	            if ((double)f < 0.1D) {
	                return;
	            }

	            if (f > 1.0F) {
	                f = 1.0F;
	            }

	            EntityArrow entityarrow = new EntityArrow(par2World, par3EntityPlayer, f * 2.0F);

	            if (f == 1.0F) {
	                entityarrow.setIsCritical(true);
	            }

	            int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, par1ItemStack);

	            if (k > 0) {
	                entityarrow.setDamage(entityarrow.getDamage() + (double)k * 0.5D + 0.5D);
	            }

	            int l = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, par1ItemStack);

	            if (l > 0) {
	                entityarrow.setKnockbackStrength(l);
	            }

	            if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, par1ItemStack) > 0) {
	                entityarrow.setFire(100);
	            }

	            par1ItemStack.damageItem(1, par3EntityPlayer);
	            par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

	            if (flag) {
	                entityarrow.canBePickedUp = 2;
	            }
	            else {
	                par3EntityPlayer.inventory.consumeInventoryItem(Item.arrow.itemID);
	            }

	            if (!par2World.isRemote) {
	                par2World.spawnEntityInWorld(entityarrow);
	            }
	        }
	}
	

    public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
        return par1ItemStack;
    }

    @Override
    public int getMaxItemUseDuration(ItemStack par1ItemStack) {
        return 32;
    }

    @Override
    public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.bow;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
    	if(par3EntityPlayer.isSneaking()) {
    		ArrowNockEvent event = new ArrowNockEvent(par3EntityPlayer, par1ItemStack);
            MinecraftForge.EVENT_BUS.post(event);
            if (event.isCanceled()) {
                return event.result;
            }

            if (par3EntityPlayer.capabilities.isCreativeMode || par3EntityPlayer.inventory.hasItem(Item.arrow.itemID)) {
                par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
            }
    	}
    	else {
            
    	}

        return par1ItemStack;
    }
    
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
    	//int arrowsInBow = 
    }

	
	@Override
	public Icon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining) {
		if (usingItem != null && usingItem.getItem().itemID == this.itemID) {
            int k = usingItem.getMaxItemUseDuration() - useRemaining;
            if (k >= 6) return this.iconArray[2];
            if (k >  4) return this.iconArray[1];
            if (k >  0) return this.iconArray[0];
        }
        return this.iconArray[0];
    }
	
	@SideOnly(Side.CLIENT)
    public Icon getIconFromDamage(int par1) {
		return this.iconArray[0];
    }
	
	@SideOnly(Side.CLIENT)
 	@Override
    public EnumRarity getRarity(ItemStack par1ItemStack) {
 		int i = par1ItemStack.getItemDamage();
        return EnumRarity.rare;
    }
	
	  /**
     * Allow or forbid the specific book/item combination as an anvil enchant
     *
     * @param itemstack1 The item
     * @param itemstack2 The book
     * @return if the enchantment is allowed
     */
    public boolean isBookEnchantable(ItemStack itemstack1, ItemStack itemstack2)
    {
    	//TO-DO 
        return true;
    }
}
