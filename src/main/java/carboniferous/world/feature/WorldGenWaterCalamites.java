package carboniferous.world.feature;

import java.util.Random;

import carboniferous.CarboniferousMod;
import carboniferous.ModBlocks;

import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenWaterCalamites extends WorldGenAbstractTree
{
    public WorldGenWaterCalamites(boolean par1) {
        super(par1);
    }

    public boolean generate(World world, Random random, int i, int j, int k) {
        if (world.getBlock(i, j - 1, k) == ModBlocks.dirt && world.getBlock(i, j, k).getMaterial() == Material.water && world.isAirBlock(i, j + 4, k) && world.isAirBlock(i, j + 12, k)) {
            for (int l = 0; l < 1; l++)
            {
                for (int i1 = 0; i1 < 24; i1++)
                {
                    for (int j1 = 0; j1 < 1; j1++)
                    {
                        world.setBlock(i + l, j + i1, k + j1, ModBlocks.logs_1, 1, 3);
                        world.setBlock(i + l, j + i1 + 1, k + j1, ModBlocks.leaves_1, 1, 3);
                    }
                }
            }

            generateLeaves(world, random, i, j + 23, k, -1, 2);
            generateLeaves(world, random, i, j + 21, k, -1, 2);
        }
        return true;
    }

    private boolean generateLeaves(World world, Random random, int i, int j, int k, int l, int i1) {
        for (int j1 = l; j1 < i1; j1++) {
            for (int k1 = 0; k1 < 1; k1++) {
                for (int l1 = l; l1 < i1; l1++) {
                    if (world.isAirBlock(i + j1, j + k1, k + l1)) {
                        world.setBlock(i + j1, j + k1, k + l1, ModBlocks.leaves_1, 1, 3);
                    }
                }
            }

            if (world.getBlock(i, j - 14, k) == ModBlocks.logs_1 && world.getBlockMetadata(i, j - 10, k) == 1) {
                generateLeaves(world, random, i, j - 4, k, l - 1, i1 + 1);
            }
        }

        return true;
    }
}
