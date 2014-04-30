package carboniferous.block;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import carboniferous.CarboniferousMod;
import carboniferous.ModItems;
import carboniferous.api.CarboniferousApi;
import carboniferous.api.Properties;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.common.IPlantable;

/**
 * @author ProPercivalalb
 **/
public class BlockMultipleBlocks extends Block {
  
	public static IIcon cobbleGranite;
	public static IIcon brickGranite;
	public static IIcon limestone;
	public static IIcon limestoneBrick;
	public static IIcon sediment;
	public static IIcon sedimentFish;
	public static IIcon sedimentGold;
	public static IIcon sedimentHematite;
	public static IIcon sedimentPyrite;
	public static IIcon graniteDiamond;
	public static IIcon graniteGold;
	public static IIcon graniteHematite;
	public static IIcon granitePyrite;
	public static IIcon oreStoragePyrite;
	
	public BlockMultipleBlocks() {
        super(Material.rock);
        this.setCreativeTab(null);
    }
	
	@Override
	public float getBlockHardness(World par1World, int par2, int par3, int par4) {
		int meta = par1World.getBlockMetadata(par2, par3, par4);
		if(meta == 14) {
			return 3.0F;
		}
		return super.getBlockHardness(par1World, par2, par3, par4);
    }
	
	@Override
	public float getExplosionResistance(Entity par1Entity, World world, int x, int y, int z, double explosionX, double explosionY, double explosionZ) {
		int meta = world.getBlockMetadata(x, y, z);
		if(meta == 14) {
			return 5.0F * 3.0F;
		}
		return super.getExplosionResistance(par1Entity, world, x, y, z, explosionX, explosionY, explosionZ);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
    public IIcon getIcon(int side, int metadata) {
        if(metadata == 0)
        	return this.blockIcon;
        else if(metadata == 1)
        	return this.cobbleGranite;
        else if(metadata == 2)
        	return this.brickGranite;
        else if(metadata == 3)
        	return this.limestone;
        else if(metadata == 4)
        	return this.limestoneBrick;
        else if(metadata == 5)
        	return this.sediment;
        else if(metadata == 6)
        	return this.sedimentFish;
        else if(metadata == 7)
        	return this.sedimentGold;
        else if(metadata == 8)
        	return this.sedimentHematite;
        else if(metadata == 9)
        	return this.sedimentPyrite;
        else if(metadata == 10)
        	return this.graniteDiamond;
        else if(metadata == 11)
        	return this.graniteGold;
        else if(metadata == 12)
        	return this.graniteHematite;
        else if(metadata == 13)
        	return this.granitePyrite;
        else if(metadata == 14)
        	return this.oreStoragePyrite;
        return this.blockIcon;
    }
    
	@Override
    public void registerBlockIcons(IIconRegister par1IconRegister) {
    	//Granite
        this.blockIcon = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "granite"); //0
        this.cobbleGranite = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "cobbleGranite"); //1
        this.brickGranite = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "bricksGranite"); //2
        //Limestone
        this.limestone = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "limestone"); //3
        this.limestoneBrick = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "bricksLimestone"); //4
        //Sediment
        this.sediment = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "sediment"); //5
        this.sedimentFish = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "oreFishSedi"); //6
        this.sedimentGold = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "oreGoldSediment"); //7
        this.sedimentHematite = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "oreHematiteSediment"); //8
        this.sedimentPyrite = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "orePyriteSediment"); //9
        //Granite Ore
        this.graniteDiamond = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "oreDiamondGranite"); //10
        this.graniteGold = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "oreGoldGranite"); //11
        this.graniteHematite = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "oreHematiteGranite"); //12
        this.granitePyrite = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "orePyriteGranite"); //13
        //Ore Storage
        this.oreStoragePyrite = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "oreStorage_Pyrite"); //14
    
    }
    
    @Override
    public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7) {
        super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, par7);
        int meta = par1World.getBlockMetadata(par2, par3, par4);
        
        if (meta==7||meta==8||meta==9||meta==10||meta==11||meta==12||meta==13) {
            int j1 = 0;
            if(meta == 7 || meta == 11) {
            	j1 = MathHelper.getRandomIntegerInRange(par1World.rand, 2, 5);
            }
            else if(meta == 12 || meta == 8) {
            	j1 = MathHelper.getRandomIntegerInRange(par1World.rand, 3, 8);
            }
            else if(meta == 10) {
            	j1 = MathHelper.getRandomIntegerInRange(par1World.rand, 6, 7);
            }

            else if(meta == 13 || meta == 9) {
            	j1 = MathHelper.getRandomIntegerInRange(par1World.rand, 4, 7);
            }
            
            this.dropXpOnBlockBreak(par1World, par2, par3, par4, j1);
        }
    }
    
    @Override
    public int damageDropped(int meta) {
    	if(meta == 0) {
    		return 1;
    	}
    	else if(meta == 11 || meta == 7 || meta == 10 || meta == 6) {
    		return 0;
    	}
    	else if(meta == 9 || meta == 13) {
    		return 3;
    	}
    	else if(meta == 8 || meta == 12) {
    		return 4;
    	}
    	return meta;
    }
    
    @Override
    public int quantityDropped(int meta, int fortune, Random random) {
    	if (fortune > 0 && (meta>=7||meta<=13)) {
            int j = random.nextInt(fortune + 2) - 1;

            if (j < 0) {
                j = 0;
            }

            return this.quantityDroppedAfterFortune(meta, fortune, random) * (j + 1);
        }
        else {
            return this.quantityDroppedAfterFortune(meta, fortune, random);
        }
    }
    
    public int quantityDroppedAfterFortune(int meta, int fortune, Random random) {
    	if(meta == 11 || meta == 7) {
    		return 7 + random.nextInt(4);
    	}
    	return 1;
    }

    @Override
    public Item getItemDropped(int meta, Random random, int fortune) {
    	if(meta == 10) {
    		return Items.diamond;
    	}
    	else if(meta == 11 || meta == 7) {
    		return Items.gold_nugget;
    	}
    	else if(meta == 6) {
    		return Items.bone;
    	}
    	else if(meta == 9 || meta == 13 || meta == 8 || meta == 12) {
    		return ModItems.multiItems;
    	}
    	return super.getItemDropped(meta, random, fortune);
    }
    
    @Override
    public boolean canSilkHarvest(World world, EntityPlayer player, int x, int y, int z, int metadata) {
    	return true;
    }
    
    public int getPickDamageValue(World par1World, int par2, int par3, int par4) {
        return par1World.getBlockMetadata(par2, par3, par4);
    }
    
    @Override
    public boolean isBeaconBase(IBlockAccess worldObj, int x, int y, int z, int beaconX, int beaconY, int beaconZ) {
    	int meta = worldObj.getBlockMetadata(x, y, z);
    	if(meta == 14) {
    		return true;
    	}
    	return false;
    }
}
