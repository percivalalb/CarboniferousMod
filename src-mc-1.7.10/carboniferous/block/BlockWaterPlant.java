package carboniferous.block;

import carboniferous.api.Properties;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockWaterPlant extends BlockFlower {

	public static IIcon plantTop;
	public static IIcon plantMiddle;
	public static IIcon plantBottom;
	
	public static IIcon plantAll;
	
	public BlockWaterPlant() {
		super(0);
		//TODO this.blockMaterial = Material.water;
		this.setCreativeTab(null);
	}

	@SideOnly(Side.CLIENT)
    @Override
	public IIcon getIcon(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) {
		boolean hasBelow = par1IBlockAccess.getBlock(par2, par3 - 1, par4) == this;
		boolean hasAbove = par1IBlockAccess.getBlock(par2, par3 + 1, par4) == this;
		if(hasBelow && hasAbove) {
			return this.plantMiddle;
		}
		else if(hasBelow && !hasAbove) {
			return this.plantTop;
		}
		else if(!hasBelow && hasAbove) {
			return this.plantBottom;
		}
		else {
			return this.plantAll;
		}
    }
	
	@SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int side, int metadata) {
       return this.plantAll;
    }
	
	@SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister par1IconRegister) {
        this.plantTop = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "WaterplantsStemTop");
        this.plantMiddle = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "WaterplantsStemMiddle");
        this.plantBottom = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "WaterplantsStemBottom");
        this.plantAll = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "WaterplantsStemWhole");
    }
	
	@Override
	public boolean canBlockStay(World par1World, int par2, int par3, int par4)
    {
        Block soil = par1World.getBlock(par2, par3 - 1, par4);
        Block id = par1World.getBlock(par2, par3 + 1, par4);
        return (id == Blocks.flowing_water || id == Blocks.water || id == this) && ((soil != null && soil == this)||(soil != null && soil.canSustainPlant(par1World, par2, par3 - 1, par4, ForgeDirection.UP, this)));
    }
	
	protected boolean canThisPlantGrowOnThisBlock(Block par1) {
	    return par1 == this || par1 == Blocks.grass || par1 == Blocks.dirt || par1 == Blocks.farmland;
	}
	
	@Override
	public boolean canSustainPlant(IBlockAccess world, int x, int y, int z, ForgeDirection direction, IPlantable plant) {
		 Block soil = world.getBlock(x, y -1 , z);
		 if(soil != null && soil == this) {
			 return true;
		 }
		 return false;
		 
    }
	
	@Override
	public int getRenderType() {
	    return Properties.RENDER_WATER_PLANT;
	}
	
	@Override
	public boolean isReplaceable(IBlockAccess world, int x, int y, int z) { 
		return false;
    }
}
