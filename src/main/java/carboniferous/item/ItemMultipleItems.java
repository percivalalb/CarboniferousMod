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
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemMultipleItems extends Item {

	public static IIcon iconIronClump;
	public static IIcon iconIronOreClumps;
	public static IIcon iconPyriteCrystal;
	public static IIcon iconHematite;
	public static IIcon iconTimerod;
	public static IIcon iconShellAmmonite;
	public static IIcon iconShellBrachiopod;
	public static IIcon iconPearl;
	public static IIcon graniteGear;
	public static IIcon amphibianSkin;
	public static IIcon sharkTooth;
	public static IIcon dragonflyWings;
	public static IIcon carbonDust;
	public static IIcon doorLepidodendron;
	public static IIcon doorCalamites;
	public static IIcon doorCordaites;
	public static IIcon doorSigillaria;
	public static IIcon doorAmphibian;
	
	public ItemMultipleItems() {
		super();
		this.setHasSubtypes(true);
	}
	
 	@SideOnly(Side.CLIENT)
 	@Override
 	public void registerIcons(IIconRegister par1IconRegister) {
 		this.iconIronClump = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "ironClump");
 		this.iconIronOreClumps = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "ironOreClumps");
 		this.iconPyriteCrystal = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "pyriteCrystal");
 		this.iconHematite = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "hematite");
 		this.iconTimerod = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "timerod");
 		this.iconShellAmmonite = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "shellAmmonite");
 		this.iconShellBrachiopod = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "shellBrachiopod");
 		this.iconPearl = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "pearl");
 		this.graniteGear = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "graniteGear");
 		this.amphibianSkin = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "amphibianSkin");
 		this.sharkTooth = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "sharkTooth");
 		this.dragonflyWings = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "dragonflyWings");
 		this.carbonDust = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "carbonDust");
 		
 		this.doorLepidodendron = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "item_doorLepido");
 		this.doorCalamites = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "item_doorCalamites");
 		this.doorCordaites = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "item_doorCordaites");
 		this.doorSigillaria = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "item_doorSigilaria");
 		this.doorAmphibian = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "item_doorAmphibian");
 	}
 	
 	public IIcon getIconFromDamage(int par1) {
 		switch(par1) {
 		case 0: return this.doorLepidodendron;
 		case 1: return this.iconIronClump;
 		case 2: return this.iconIronOreClumps;
 		case 3: return this.iconPyriteCrystal;
 		case 4: return this.iconHematite;
 		case 5: return this.iconTimerod;
 		case 6: return this.iconShellAmmonite;
 		case 7: return this.iconShellBrachiopod;
 		case 8: return this.iconPearl;
 		case 9: return this.graniteGear;
 		case 10: return this.amphibianSkin;
 		case 11: return this.sharkTooth;
 		case 12: return this.dragonflyWings;
 		case 13: return this.carbonDust;
 		case 14: return this.doorCalamites;
 		case 15: return this.doorCordaites;
 		case 16: return this.doorSigillaria;
 		case 17: return this.doorAmphibian;
 		}
 	    return null;
 	}
 	
 	@Override
    public String getUnlocalizedName(ItemStack par1ItemStack) {
        int i = par1ItemStack.getItemDamage();
        return super.getUnlocalizedName() + "." + i;
    }
 	 
 	@SideOnly(Side.CLIENT)
 	@Override
    public EnumRarity getRarity(ItemStack par1ItemStack) {
 		int i = par1ItemStack.getItemDamage();
 		if(i == 5) {
 			return EnumRarity.epic;
 		}
 		else if(i == 8) {
 			return EnumRarity.rare;
 		}
        return EnumRarity.common;
    }
 	
 	@Override
 	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float par8, float par9, float par10) {
 	    int meta = stack.getItemDamage();
 		if(meta == 6 || meta == 7 || meta == 8 || meta == 11) {
 	    	return this.handleShell(stack, player, world, x, y, z, side, par8, par9, par10);
 	    }
 	    else if(meta == 0 || meta == 15 || meta == 16 || meta == 17 || meta == 14){
 	    	if (side != 1) {
 	            return false;
 	        }
 	        else
 	        {
 	            ++y;
 	            Block block = null;
 	            switch(meta) {
 	            case 0: block = ModBlocks.doorLepidodendron;
 	            		break;
 	    		case 14: block = ModBlocks.doorCalamites;
 	            		break;
 	    		case 15: block = ModBlocks.doorCordaites;
 	            		break;
 	    		case 16: block = ModBlocks.doorSigillaria;
 	            		break;
 	    		case 17: block = ModBlocks.doorAmphibian;
 	            		break;
 	            }

 	            if (player.canPlayerEdit(x, y, z, side, stack) && player.canPlayerEdit(x, y + 1, z, side, stack)) {
 	                if (!block.canPlaceBlockAt(world, x, y, z)) {
 	                    return false;
 	                }
 	                else {
 	                    int i1 = MathHelper.floor_double((double)((player.rotationYaw + 180.0F) * 4.0F / 360.0F) - 0.5D) & 3;
 	                    placeDoorBlock(world, x, y, z, i1, block);
 	                    --stack.stackSize;
 	                    return true;
 	                }
 	            }
 	            else {
 	                return false;
 	            }
 	        }
 	    }
 		return false;
 	}
 	
    public static void placeDoorBlock(World p_150924_0_, int p_150924_1_, int p_150924_2_, int p_150924_3_, int p_150924_4_, Block p_150924_5_)
    {
        byte b0 = 0;
        byte b1 = 0;

        if (p_150924_4_ == 0)
        {
            b1 = 1;
        }

        if (p_150924_4_ == 1)
        {
            b0 = -1;
        }

        if (p_150924_4_ == 2)
        {
            b1 = -1;
        }

        if (p_150924_4_ == 3)
        {
            b0 = 1;
        }

        int i1 = (p_150924_0_.getBlock(p_150924_1_ - b0, p_150924_2_, p_150924_3_ - b1).isNormalCube() ? 1 : 0) + (p_150924_0_.getBlock(p_150924_1_ - b0, p_150924_2_ + 1, p_150924_3_ - b1).isNormalCube() ? 1 : 0);
        int j1 = (p_150924_0_.getBlock(p_150924_1_ + b0, p_150924_2_, p_150924_3_ + b1).isNormalCube() ? 1 : 0) + (p_150924_0_.getBlock(p_150924_1_ + b0, p_150924_2_ + 1, p_150924_3_ + b1).isNormalCube() ? 1 : 0);
        boolean flag = p_150924_0_.getBlock(p_150924_1_ - b0, p_150924_2_, p_150924_3_ - b1) == p_150924_5_ || p_150924_0_.getBlock(p_150924_1_ - b0, p_150924_2_ + 1, p_150924_3_ - b1) == p_150924_5_;
        boolean flag1 = p_150924_0_.getBlock(p_150924_1_ + b0, p_150924_2_, p_150924_3_ + b1) == p_150924_5_ || p_150924_0_.getBlock(p_150924_1_ + b0, p_150924_2_ + 1, p_150924_3_ + b1) == p_150924_5_;
        boolean flag2 = false;

        if (flag && !flag1)
        {
            flag2 = true;
        }
        else if (j1 > i1)
        {
            flag2 = true;
        }

        p_150924_0_.setBlock(p_150924_1_, p_150924_2_, p_150924_3_, p_150924_5_, p_150924_4_, 2);
        p_150924_0_.setBlock(p_150924_1_, p_150924_2_ + 1, p_150924_3_, p_150924_5_, 8 | (flag2 ? 1 : 0), 2);
        p_150924_0_.notifyBlocksOfNeighborChange(p_150924_1_, p_150924_2_, p_150924_3_, p_150924_5_);
        p_150924_0_.notifyBlocksOfNeighborChange(p_150924_1_, p_150924_2_ + 1, p_150924_3_, p_150924_5_);
    }
 	
 	public boolean handleShell(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l, float par8, float par9, float par10) {
 		if (l == 0) {
 			return false;
 	    }
 	    if (l == 1) {
 	    	return false;
 	    }
 	    if (l == 2){
 	    	k--;
 	    }

 	    if (l == 3) {
 	    	k++;
 	    }

 	    if (l == 4) {
 	    	i--;
 	    }

 	    if (l == 5) {
 	    	i++;
 	    }
 	    if (world.getBlock(i, j, k).getMaterial().isSolid()) {
 	      return false;
 	    }
 	    if (!entityplayer.canPlayerEdit(i, j, k, l, itemstack)) {
 	    	return false;
 	    }
 	    if (!ModBlocks.wallShell.canBlockStay(world, i, j, k)) {
 	    	return false;
 	    }
 	    switch (l) {
 	    case 2:
 	    	l = 1;
 	    	break;
 	    case 3:
 	    	l = 3;
 	    	break;
 	    case 4:
 	    	l = 0;
 	    	break;
 	    case 5:
 	    	l = 2;
 	    }

 	    world.setBlock(i, j, k, ModBlocks.wallShell, l, 3);
 	    itemstack.stackSize -= 1;
 	    TileEntityWallShell west = (TileEntityWallShell)world.getTileEntity(i, j, k);
 	    if (west != null) {
 	    	west.setShell(itemstack.getItem(), itemstack.getItemDamage());
 	    }
 	    return true;
 	}
}
