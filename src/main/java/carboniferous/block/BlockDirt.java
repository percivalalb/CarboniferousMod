package carboniferous.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import carboniferous.CarboniferousMod;
import carboniferous.ModBlocks;
import carboniferous.api.CarboniferousApi;
import carboniferous.api.IconReference;
import carboniferous.api.Properties;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.common.IPlantable;

/**
 * @author ProPercivalalb
 **/
public class BlockDirt extends Block {
	
	public BlockDirt() {
        super(Material.ground);
        this.setCreativeTab(null);
    }
    
    public void registerBlockIcons(IIconRegister par1IconRegister) {
    	IconReference.dirt = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "dirt");
        IconReference.dirtBrick = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "dirtBrick");
    }
    
    @Override
	public float getBlockHardness(World par1World, int par2, int par3, int par4) {
		int meta = par1World.getBlockMetadata(par2, par3, par4);
		switch(meta) {
		case 1: return 0.8F;
		default: return super.getBlockHardness(par1World, par2, par3, par4);
		}
	}
	
	@SideOnly(Side.CLIENT)
	@Override
    public IIcon getIcon(int side, int meta) {
		if(meta == 1) return IconReference.dirtBrick;
		return IconReference.dirt;
	}
    
	@Override
    public boolean canSustainPlant(IBlockAccess world, int x, int y, int z, ForgeDirection direction, IPlantable plant) {
        if(world.getBlockMetadata(x, y, z) != 0) return false;
    	Block plantID = plant.getPlant(world, x, y + 1, z);
        EnumPlantType plantType = plant.getPlantType(world, x, y + 1, z);

        switch (plantType)
        {
            case Plains: return this == ModBlocks.grass || this == ModBlocks.dirt;
            case Beach:
                boolean isBeach = (this == ModBlocks.grass || this == ModBlocks.dirt);
                boolean hasWater = (world.getBlock(x - 1, y, z    ).getMaterial() == Material.water ||
                                    world.getBlock(x + 1, y, z    ).getMaterial() == Material.water ||
                                    world.getBlock(x,     y, z - 1).getMaterial() == Material.water ||
                                    world.getBlock(x,     y, z + 1).getMaterial() == Material.water);
                return isBeach && hasWater;
            default: return false;
        }
    }
    
	@Override
    public int damageDropped(int meta) {
        return meta;
    }
}
