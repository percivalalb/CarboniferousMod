package carboniferous.world.feature;

import java.util.Random;

import carboniferous.CarboniferousMod;
import carboniferous.ModBlocks;
import carboniferous.block.BlockSapling;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.ForgeDirection;

public class WorldGenCalamites extends WorldGeneratorCarboniferous
{
    public WorldGenCalamites(boolean par1) {
        super(par1);
    }

    @Override
    public boolean generate(World world, Random random, int i, int j, int k) {
    	int id = this.getBlockIfChunkExists(world, i, j - 1, k);
        Block soil = Block.blocksList[id];
    	boolean isSoil = (soil != null && soil.canSustainPlant(world, i, j - 1, k, ForgeDirection.UP, (BlockSapling)ModBlocks.saplings_1));
    	if (isSoil && world.isAirBlock(i, j + 12, k)) {
            for (int l = 0; l < 1; l++)
            {
                for (int i1 = 0; i1 < 24; i1++)
                {
                    for (int j1 = 0; j1 < 1; j1++)
                    {
                        world.setBlock(i + l, j + i1, k + j1, ModBlocks.logs_1.blockID, 1, 3);
                        world.setBlock(i + l, j + i1 + 1, k + j1, ModBlocks.leaves_1.blockID, 1, 3);
                    }
                }
            }

            generateLeaves(world, random, i, j + 23, k, -1, 2);
            generateLeaves(world, random, i, j + 21, k, -1, 2);
            return true;
        }
        return false;
    }

    private boolean generateLeaves(World world, Random random, int i, int j, int k, int l, int i1) {
        for (int j1 = l; j1 < i1; j1++) {
            for (int k1 = 0; k1 < 1; k1++) {
                for (int l1 = l; l1 < i1; l1++) {
                    if (world.isAirBlock(i + j1, j + k1, k + l1)) {
                        world.setBlock(i + j1, j + k1, k + l1, ModBlocks.leaves_1.blockID, 1, 3);
                    }
                }
            }

            if (world.getBlockId(i, j - 14, k) == ModBlocks.logs_1.blockID && world.getBlockMetadata(i, j - 10, k) == 1)
            {
                generateLeaves(world, random, i, j - 4, k, l - 1, i1 + 1);
            }
        }

        return true;
    }
}
