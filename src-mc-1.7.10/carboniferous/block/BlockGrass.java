package carboniferous.block;

import java.util.Random;

import carboniferous.ModBlocks;
import carboniferous.api.Properties;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * @author ProPercivalalb
 **/
public class BlockGrass extends Block {
  
	@SideOnly(Side.CLIENT)
    public static IIcon iconGrassTop;
    @SideOnly(Side.CLIENT)
    private IIcon iconSnowSide;

    public BlockGrass() {
        super(Material.grass);
        this.setTickRandomly(true);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return side == 1 ? this.iconGrassTop : (side == 0 ? ModBlocks.dirt.getBlockTextureFromSide(side) : this.blockIcon);
    }

    @Override
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {
        if (!par1World.isRemote) {
            if (par1World.getBlockLightValue(par2, par3 + 1, par4) < 4 && par1World.getBlockLightOpacity(par2, par3 + 1, par4) > 2) {
                par1World.setBlock(par2, par3, par4, ModBlocks.dirt);
            }
            else if (par1World.getBlockLightValue(par2, par3 + 1, par4) >= 9)
            {
                for (int l = 0; l < 4; ++l)
                {
                    int i1 = par2 + par5Random.nextInt(3) - 1;
                    int j1 = par3 + par5Random.nextInt(5) - 3;
                    int k1 = par4 + par5Random.nextInt(3) - 1;
                    Block l1 = par1World.getBlock(i1, j1 + 1, k1);

                    if (par1World.getBlock(i1, j1, k1) == ModBlocks.dirt && par1World.getBlockMetadata(i1, j1, k1) == 0 && par1World.getBlockLightValue(i1, j1 + 1, k1) >= 4 && par1World.getBlockLightOpacity(i1, j1 + 1, k1) <= 2)
                    {
                        par1World.setBlock(i1, j1, k1, ModBlocks.grass);
                    }
                }
            }
        }
    }

    @Override
    public Item getItemDropped(int par1, Random par2Random, int par3) {
        return ModBlocks.dirt.getItemDropped(par1, par2Random, par3);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(IBlockAccess blockAccess, int x, int y, int z, int side) {
        if (side == 1)
            return this.iconGrassTop;
        else if (side == 0)
            return ModBlocks.dirt.getIcon(side, side);
        else {
            Material material = blockAccess.getBlock(x, y + 1, z).getMaterial();
            return material != Material.snow && material != Material.craftedSnow ? this.blockIcon : this.iconSnowSide;
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(Properties.TEX_PACkAGE + "grassside");
        this.iconGrassTop = iconRegister.registerIcon(Properties.TEX_PACkAGE + "grasstop");
        this.iconSnowSide = iconRegister.registerIcon(Properties.TEX_PACkAGE + "grasssnowside");
    }
    
    @Override
    public boolean canSustainPlant(IBlockAccess world, int x, int y, int z, ForgeDirection direction, IPlantable plant) {
        Block plantID = plant.getPlant(world, x, y + 1, z);
        EnumPlantType plantType = plant.getPlantType(world, x, y + 1, z);

        switch (plantType)
        {
            case Plains: return true;
            case Beach:
                boolean hasWater = (world.getBlock(x - 1, y, z    ).getMaterial() == Material.water ||
                                    world.getBlock(x + 1, y, z    ).getMaterial() == Material.water ||
                                    world.getBlock(x,     y, z - 1).getMaterial() == Material.water ||
                                    world.getBlock(x,     y, z + 1).getMaterial() == Material.water);
                return hasWater;
            default: return false;
        }
    }

    @Override
    public void onPlantGrow(World world, int x, int y, int z, int sourceX, int sourceY, int sourceZ) {
        world.setBlock(x, y, z, ModBlocks.dirt, 0, 2);
    }
    
    @Override
    protected boolean canSilkHarvest() {
        return true;
    }
}
