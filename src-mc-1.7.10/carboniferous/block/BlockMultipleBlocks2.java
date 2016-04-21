package carboniferous.block;

import java.util.List;
import java.util.Random;

import carboniferous.api.CarboniferousApi;
import carboniferous.api.Properties;
import carboniferous.creativetab.CreativeTabCarboniferous;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 * @author ProPercivalalb
 **/
public class BlockMultipleBlocks2 extends Block {
  
	public static IIcon graniteSunstone_on;
	public static IIcon graniteSunstone_off;
	public static IIcon chiseledGraniteBricks;
	public static IIcon graniteTiles;
	public static IIcon limestoneTiles;
	public static IIcon checkeredTiles;
	public static IIcon oreCarbon;
	public static IIcon chiseledLimestone;
	public static IIcon pyriteBricks;
	public static IIcon blockHematite;
	public static IIcon decorativeLimestone;
	public static IIcon basalt;
	public static IIcon basaltBrick;
	public static IIcon cobbedGranite;
	public static IIcon chiseledBasalt;
	
	public BlockMultipleBlocks2() {
        super(Material.rock);
        this.setCreativeTab(CarboniferousApi.carboniferousTab);
    }
	
	@Override
	public float getBlockHardness(World par1World, int par2, int par3, int par4) {
		int meta = par1World.getBlockMetadata(par2, par3, par4);
		if(meta == 8 || meta == 9) {
			return 3.0F;
		}
		else if(meta == 11 || meta == 12 || meta == 14) {
			return 4.0F;
		}
		return super.getBlockHardness(par1World, par2, par3, par4);
    }
	
	@Override
	public float getExplosionResistance(Entity par1Entity, World world, int x, int y, int z, double explosionX, double explosionY, double explosionZ) {
		int meta = world.getBlockMetadata(x, y, z);
		if(meta == 8 || meta == 9) {
			return 5.0F * 3.0F;
		}
		else if(meta == 11 || meta == 12 || meta == 14) {
			return 5.0F * 4.5F;
		}
		return super.getExplosionResistance(par1Entity, world, x, y, z, explosionX, explosionY, explosionZ);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
    public IIcon getIcon(int side, int meta) {
		switch(meta) {
		case 0: return this.graniteSunstone_off;
		case 1: return this.graniteSunstone_on;
		case 2: return this.chiseledGraniteBricks;
		case 3: return this.graniteTiles;
		case 4: return this.limestoneTiles;
		case 5: return this.checkeredTiles;
		case 6: return this.oreCarbon;
		case 7: return this.chiseledLimestone;
		case 8: return this.pyriteBricks;
		case 9: return this.blockHematite;
		case 10: return this.decorativeLimestone;
		case 11: return this.basalt;
		case 12: return this.basaltBrick;
		case 13: return this.cobbedGranite;
		case 14: return this.chiseledBasalt;
		default: return null;
		}
    }
    
    public void registerBlockIcons(IIconRegister par1IconRegister) {
        this.graniteSunstone_off = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "graniteSunstone_off"); //0
        this.graniteSunstone_on = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "graniteSunstone_on"); //1
        this.chiseledGraniteBricks = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "ChiseledGraniteBricks"); //2
        this.graniteTiles = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "GraniteTiles"); //3
        this.limestoneTiles = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "LimestoneTiles"); //4
        this.checkeredTiles = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "CheckeredTiles"); //5
        this.oreCarbon = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "oreCarbon"); //6
        this.chiseledLimestone = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "chiseledLimestone"); //7
        this.pyriteBricks = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "bricksPyrite"); //8
        this.blockHematite = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "oreStorage_Hematite"); //9
        this.decorativeLimestone = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "decoBricksLimestone"); //10
        this.basalt = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "basalt"); //11
        this.basaltBrick = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "basaltBrick"); //12
        this.cobbedGranite = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "webbedGranite"); //13
        this.chiseledBasalt = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "chiseledBasalt"); //14
    }
    
    @Override
    public int damageDropped(int meta) {
        if(meta == 1) {
        	return meta - 1;
        }
        else if(meta == 6) {
        	return 0;
        }
    	return meta;
    }
    
    private Random rand = new Random();
    @Override
    public int getExpDrop(IBlockAccess world, int meta, int fortune) {
    	if(meta == 6)
    		return MathHelper.getRandomIntegerInRange(rand, 0, 2);
        else
        	return 0;
    }
    
    @Override
    public int quantityDropped(int meta, int fortune, Random random) {
        if(fortune > 0 && (meta == 6)) {
            int j = rand.nextInt(fortune + 2) - 1;

            if (j < 0)
                j = 0;

            return this.quantityDropped(rand) * (j + 1);
        }
        else
            return this.quantityDropped(rand);
    }

    @Override
    public Item getItemDropped(int meta, Random random, int fortune) {
    	if(meta == 6)
        	return Items.coal;
    	return super.getItemDropped(meta, random, fortune);
    }
    
    @Override
    public boolean canSilkHarvest(World world, EntityPlayer player, int x, int y, int z, int meta) {
    	return meta != 1;
    }

    
    @Override
    public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z, EntityPlayer player) {
    	int meta = world.getBlockMetadata(x, y, z);
        if(meta == 1) 
        	meta -= 1;

    	return new ItemStack(this, 1, meta);
    }
    
    @Override
    public boolean isBeaconBase(IBlockAccess world, int x, int y, int z, int beaconX, int beaconY, int beaconZ) {
    	int meta = world.getBlockMetadata(x, y, z);
    	if(meta == 9) {
    		return true;
    	}
    	return false;
    }
    
    @Override
    public int getLightValue(IBlockAccess world, int x, int y, int z) {
    	int meta = world.getBlockMetadata(x, y, z);
    	if(meta == 1) {
    		return 15;
    	}
    	return 0;
    }
    
    @Override
    public void onBlockAdded(World par1World, int par2, int par3, int par4) {
    	int meta = par1World.getBlockMetadata(par2, par3, par4);
        if (!par1World.isRemote && meta <= 1) {
            if (meta % 2 == 1 && !par1World.isBlockIndirectlyGettingPowered(par2, par3, par4)) {
                par1World.scheduleBlockUpdate(par2, par3, par4, this, 4);
            }
            else if (!(meta % 2 == 1) && par1World.isBlockIndirectlyGettingPowered(par2, par3, par4)) {
                par1World.setBlock(par2, par3, par4, this, meta + 1, 2);
            }
        }
    }

    @Override
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, Block par5) {
    	int meta = par1World.getBlockMetadata(par2, par3, par4);
        if (!par1World.isRemote && meta <= 1) {
            if (meta % 2 == 1 && !par1World.isBlockIndirectlyGettingPowered(par2, par3, par4)) {
                par1World.scheduleBlockUpdate(par2, par3, par4, this, 4);
            }
            else if (!(meta % 2 == 1) && par1World.isBlockIndirectlyGettingPowered(par2, par3, par4)) {
                par1World.setBlock(par2, par3, par4, this, meta + 1, 2);
            }
        }
    }

    @Override
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {
    	int meta = par1World.getBlockMetadata(par2, par3, par4);
        if (!par1World.isRemote && meta <= 1 && meta % 2 == 1 && !par1World.isBlockIndirectlyGettingPowered(par2, par3, par4)) {
            par1World.setBlock(par2, par3, par4, this, meta - 1, 2);
        }
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List) {
    	CreativeTabCarboniferous.addStuffToTab(par3List);
    }
}
