package carboniferous.block;

import static net.minecraftforge.common.ForgeDirection.UP;
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
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.IPlantable;

/**
 * @author ProPercivalalb
 **/
public class BlockDirt extends Block {
	
	public BlockDirt(int par1) {
        super(par1, Material.ground);
        this.setCreativeTab(null);
    }
    
    public void registerIcons(IconRegister par1IconRegister) {
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
    
    public boolean canSustainPlant(World world, int x, int y, int z, ForgeDirection direction, IPlantable plant) {
        if(world.getBlockMetadata(x, y, z) != 0) return false;
    	int plantID = plant.getPlantID(world, x, y + 1, z);
        EnumPlantType plantType = plant.getPlantType(world, x, y + 1, z);

        switch (plantType)
        {
            case Plains: return blockID == ModBlocks.grass.blockID || blockID == ModBlocks.dirt.blockID;
            case Beach:
                boolean isBeach = (blockID == ModBlocks.grass.blockID || blockID == ModBlocks.dirt.blockID);
                boolean hasWater = (world.getBlockMaterial(x - 1, y, z    ) == Material.water ||
                                    world.getBlockMaterial(x + 1, y, z    ) == Material.water ||
                                    world.getBlockMaterial(x,     y, z - 1) == Material.water ||
                                    world.getBlockMaterial(x,     y, z + 1) == Material.water);
                return isBeach && hasWater;
            default: return false;
        }
    }
    
    public int damageDropped(int meta) {
        return meta;
    }
}
