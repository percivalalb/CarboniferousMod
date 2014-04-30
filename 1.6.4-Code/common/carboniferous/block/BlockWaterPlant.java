package carboniferous.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import carboniferous.api.CarboniferousApi;
import carboniferous.api.Properties;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.IPlantable;

public class BlockWaterPlant extends BlockFlower {

	public static IIcon plantTop;
	public static IIcon plantMiddle;
	public static IIcon plantBottom;
	
	public static IIcon plantAll;
	
	public BlockWaterPlant(int par1) {
		super(par1, Material.water);
		this.setCreativeTab(null);
	}

	@SideOnly(Side.CLIENT)
    @Override
	public IIcon getBlockTexture(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) {
		boolean hasBelow = par1IBlockAccess.getBlockId(par2, par3 - 1, par4) == this.blockID;
		boolean hasAbove = par1IBlockAccess.getBlockId(par2, par3 + 1, par4) == this.blockID;
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
    public void registerIcons(IconRegister par1IconRegister) {
        this.plantTop = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "WaterplantsStemTop");
        this.plantMiddle = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "WaterplantsStemMiddle");
        this.plantBottom = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "WaterplantsStemBottom");
        this.plantAll = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "WaterplantsStemWhole");
    }
	
	public boolean canBlockStay(World par1World, int par2, int par3, int par4)
    {
        Block soil = blocksList[par1World.getBlockId(par2, par3 - 1, par4)];
        int id = par1World.getBlockId(par2, par3 + 1, par4);
        return (id == Block.waterMoving.blockID || id == Block.waterStill.blockID || id == this.blockID) && ((soil != null && soil.blockID == this.blockID)||(soil != null && soil.canSustainPlant(par1World, par2, par3 - 1, par4, ForgeDirection.UP, this)));
    }
	
	protected boolean canThisPlantGrowOnThisBlockID(int par1) {
	    return par1 == this.blockID || par1 == Block.grass.blockID || par1 == Block.dirt.blockID || par1 == Block.tilledField.blockID;
	}
	
	public boolean canSustainPlant(World world, int x, int y, int z, ForgeDirection direction, IPlantable plant) {
		 Block soil = blocksList[world.getBlockId(x, y -1 , z)];
		 if(soil != null && soil.blockID == this.blockID) {
			 return true;
		 }
		 return false;
		 
    }
	
	public int getRenderType() {
	    return Properties.RENDER_WATER_PLANT;
	}
	
	public boolean isBlockReplaceable(World world, int x, int y, int z) { 
		return false;
    }
}
