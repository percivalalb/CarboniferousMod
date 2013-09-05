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
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemMultipleItems extends Item {

	public static Icon iconIronClump;
	public static Icon iconIronOreClumps;
	public static Icon iconPyriteCrystal;
	public static Icon iconHematite;
	public static Icon iconTimerod;
	public static Icon iconShellAmmonite;
	public static Icon iconShellBrachiopod;
	public static Icon iconPearl;
	public static Icon graniteGear;
	public static Icon amphibianSkin;
	public static Icon sharkTooth;
	public static Icon dragonflyWings;
	public static Icon carbonDust;
	public static Icon doorLepidodendron;
	public static Icon doorCalamites;
	public static Icon doorCordaites;
	public static Icon doorSigillaria;
	public static Icon doorAmphibian;
	
	public ItemMultipleItems(int par1) {
		super(par1);
		this.setHasSubtypes(true);
	}
	
 	@SideOnly(Side.CLIENT)
 	@Override
 	public void registerIcons(IconRegister par1IconRegister) {
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
 	
 	public Icon getIconFromDamage(int par1) {
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
 	
 	 public static void placeDoorBlock(World par0World, int par1, int par2, int par3, int par4, Block par5Block) {
         byte b0 = 0;
         byte b1 = 0;

         if (par4 == 0)
         {
             b1 = 1;
         }

         if (par4 == 1)
         {
             b0 = -1;
         }

         if (par4 == 2)
         {
             b1 = -1;
         }

         if (par4 == 3)
         {
             b0 = 1;
         }

         int i1 = (par0World.isBlockNormalCube(par1 - b0, par2, par3 - b1) ? 1 : 0) + (par0World.isBlockNormalCube(par1 - b0, par2 + 1, par3 - b1) ? 1 : 0);
         int j1 = (par0World.isBlockNormalCube(par1 + b0, par2, par3 + b1) ? 1 : 0) + (par0World.isBlockNormalCube(par1 + b0, par2 + 1, par3 + b1) ? 1 : 0);
         boolean flag = par0World.getBlockId(par1 - b0, par2, par3 - b1) == par5Block.blockID || par0World.getBlockId(par1 - b0, par2 + 1, par3 - b1) == par5Block.blockID;
         boolean flag1 = par0World.getBlockId(par1 + b0, par2, par3 + b1) == par5Block.blockID || par0World.getBlockId(par1 + b0, par2 + 1, par3 + b1) == par5Block.blockID;
         boolean flag2 = false;

         if (flag && !flag1)
         {
             flag2 = true;
         }
         else if (j1 > i1)
         {
             flag2 = true;
         }

         par0World.setBlock(par1, par2, par3, par5Block.blockID, par4, 2);
         par0World.setBlock(par1, par2 + 1, par3, par5Block.blockID, 8 | (flag2 ? 1 : 0), 2);
         par0World.notifyBlocksOfNeighborChange(par1, par2, par3, par5Block.blockID);
         par0World.notifyBlocksOfNeighborChange(par1, par2 + 1, par3, par5Block.blockID);
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
 	    if (world.getBlockMaterial(i, j, k).isSolid()) {
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

 	    world.setBlock(i, j, k, ModBlocks.wallShell.blockID, l, 3);
 	    itemstack.stackSize -= 1;
 	    TileEntityWallShell west = (TileEntityWallShell)world.getBlockTileEntity(i, j, k);
 	    if (west != null) {
 	    	west.setShellIdAndMeta(itemstack.itemID, itemstack.getItemDamage());
 	    }
 	    return true;
 	}
}
