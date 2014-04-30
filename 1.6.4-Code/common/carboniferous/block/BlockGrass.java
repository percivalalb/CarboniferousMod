package carboniferous.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;

import carboniferous.CarboniferousMod;
import carboniferous.ModBlocks;
import carboniferous.api.CarboniferousApi;
import carboniferous.api.Properties;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.IPlantable;

/**
 * @author ProPercivalalb
 **/
public class BlockGrass extends Block {
  
	@SideOnly(Side.CLIENT)
    private IIcon iconGrassTop;
    @SideOnly(Side.CLIENT)
    private IIcon iconSnowSide;

    public BlockGrass(int par1) {
        super(par1, Material.grass);
        this.setTickRandomly(true);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int par1, int par2)
    {
        return par1 == 1 ? this.iconGrassTop : (par1 == 0 ? ModBlocks.dirt.getBlockTextureFromSide(par1) : this.blockIcon);
    }

    @Override
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {
        if (!par1World.isRemote) {
            if (par1World.getBlockLightValue(par2, par3 + 1, par4) < 4 && par1World.getBlockLightOpacity(par2, par3 + 1, par4) > 2) {
                par1World.setBlock(par2, par3, par4, ModBlocks.dirt.blockID);
            }
            else if (par1World.getBlockLightValue(par2, par3 + 1, par4) >= 9)
            {
                for (int l = 0; l < 4; ++l)
                {
                    int i1 = par2 + par5Random.nextInt(3) - 1;
                    int j1 = par3 + par5Random.nextInt(5) - 3;
                    int k1 = par4 + par5Random.nextInt(3) - 1;
                    int l1 = par1World.getBlockId(i1, j1 + 1, k1);

                    if (par1World.getBlockId(i1, j1, k1) == ModBlocks.dirt.blockID && par1World.getBlockMetadata(i1, j1, k1) == 0 && par1World.getBlockLightValue(i1, j1 + 1, k1) >= 4 && par1World.getBlockLightOpacity(i1, j1 + 1, k1) <= 2)
                    {
                        par1World.setBlock(i1, j1, k1, ModBlocks.grass.blockID);
                    }
                }
            }
        }
    }

    @Override
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return ModBlocks.dirt.idDropped(0, par2Random, par3);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getBlockTexture(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) {
        if (par5 == 1) {
            return this.iconGrassTop;
        }
        else if (par5 == 0) {
            return ModBlocks.dirt.getBlockTextureFromSide(par5);
        }
        else {
            Material material = par1IBlockAccess.getBlockMaterial(par2, par3 + 1, par4);
            return material != Material.snow && material != Material.craftedSnow ? this.blockIcon : this.iconSnowSide;
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IconRegister par1IconRegister) {
        this.blockIcon = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "grassside");
        this.iconGrassTop = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "grasstop");
        this.iconSnowSide = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "grasssnowside");
    }
    
    @Override
    public boolean canSustainPlant(World world, int x, int y, int z, ForgeDirection direction, IPlantable plant) {
        int plantID = plant.getPlantID(world, x, y + 1, z);
        EnumPlantType plantType = plant.getPlantType(world, x, y + 1, z);

        switch (plantType)
        {
            case Plains: return true;
            case Beach:
                boolean hasWater = (world.getBlockMaterial(x - 1, y, z    ) == Material.water ||
                                    world.getBlockMaterial(x + 1, y, z    ) == Material.water ||
                                    world.getBlockMaterial(x,     y, z - 1) == Material.water ||
                                    world.getBlockMaterial(x,     y, z + 1) == Material.water);
                return hasWater;
            default: return false;
        }
    }

    @Override
    public void onPlantGrow(World world, int x, int y, int z, int sourceX, int sourceY, int sourceZ) {
        world.setBlock(x, y, z, ModBlocks.dirt.blockID, 0, 2);
    }
    
    @Override
    protected boolean canSilkHarvest() {
        return true;
    }
}
