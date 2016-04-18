package carboniferous.world.feature;

import java.util.Random;

import carboniferous.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenSand extends WorldGenerator
{
    /** Stores ID for WorldGenSand */
    private Block replaceBlock;

    /** The maximum radius used when generating a patch of blocks. */
    private int radius;

    public WorldGenSand(Block replaceBlock, int radius)
    {
        this.replaceBlock = replaceBlock;
        this.radius = radius;
    }

    public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5)
    {
        if (par1World.getBlock(par3, par4, par5).getMaterial() != Material.water)
        {
            return false;
        }
        else
        {
            int l = par2Random.nextInt(this.radius - 2) + 2;
            byte b0 = 2;

            for (int i1 = par3 - l; i1 <= par3 + l; ++i1)
            {
                for (int j1 = par5 - l; j1 <= par5 + l; ++j1)
                {
                    int k1 = i1 - par3;
                    int l1 = j1 - par5;

                    if (k1 * k1 + l1 * l1 <= l * l)
                    {
                        for (int i2 = par4 - b0; i2 <= par4 + b0; ++i2)
                        {
                            Block j2 = par1World.getBlock(i1, i2, j1);

                            if (j2 == ModBlocks.dirt || j2 == ModBlocks.grass)
                            {
                                par1World.setBlock(i1, i2, j1, this.replaceBlock, 0, 2);
                            }
                        }
                    }
                }
            }

            return true;
        }
    }
}
