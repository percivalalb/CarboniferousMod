package carboniferous.world.feature;

import java.util.Random;

import carboniferous.CarboniferousMod;
import carboniferous.ModBlocks;
import carboniferous.block.BlockSapling;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class WorldGenSigillaria extends WorldGeneratorCarboniferous
{
    public WorldGenSigillaria(boolean par1) {
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
                for (int j1 = 0; j1 < 22; j1++)
                {
                    for (int k1 = 0; k1 < 1; k1++)
                    {
                    	if(this.isAirBlockIfChunkExists(world, i + l, j + j1, k + k1)) {
                    		setBlockandMetadataIfChunkExists(world, i + l, j + j1, k + k1, ModBlocks.logs_1.blockID, 3);
                    	}
                    }
                }
            }

            int i1 = random.nextInt(3);
            if (i1 == 0)
            {
                generateBranches(world, random, i, j + 21, k, 0);
            }
            if (i1 == 1)
            {
                generateBranches(world, random, i, j + 21, k, 1);
            }
            if (i1 == 2)
            {
                generateBranches(world, random, i, j + 21, k, 2);
            }
            return true;
        }
        return false;
    }

    private boolean generateBranches(World world, Random random, int i, int j, int k, int l)
    {
        if (l == 0)
        {
            for (int i1 = 0; i1 < 1; i1++)
            {
                for (int j2 = 0; j2 < 5; j2++)
                {
                    for (int k3 = 0; k3 < 1; k3++)
                    {
                        setBlockandMetadataIfChunkExists(world, i + i1, j + j2, k + k3, ModBlocks.logs_1.blockID, 3);
                        setBlockandMetadataIfChunkExists(world, i + i1, j + j2 + 1, k + k3, ModBlocks.leaves_1.blockID, 3);
                    }
                }
            }

            generateLeaves(world, random, i, j + 1, k);
        }
        if (l == 1)
        {
            setBlockandMetadataIfChunkExists(world, i, j + 1, k + 1, ModBlocks.logs_1.blockID, 3);
            setBlockandMetadataIfChunkExists(world, i, j + 2, k + 2, ModBlocks.logs_1.blockID, 3);
            setBlockandMetadataIfChunkExists(world, i, j + 3, k + 3, ModBlocks.logs_1.blockID, 3);
            setBlockandMetadataIfChunkExists(world, i, j + 1, k - 1, ModBlocks.logs_1.blockID, 3);
            setBlockandMetadataIfChunkExists(world, i, j + 2, k - 2, ModBlocks.logs_1.blockID, 3);
            setBlockandMetadataIfChunkExists(world, i, j + 3, k - 3, ModBlocks.logs_1.blockID, 3);
            for (int j1 = 0; j1 < 1; j1++)
            {
                for (int k2 = 3; k2 < 8; k2++)
                {
                    for (int l3 = -3; l3 < -2; l3++)
                    {
                        setBlockandMetadataIfChunkExists(world, i + j1, j + k2, k + l3, ModBlocks.logs_1.blockID, 3);
                        setBlockandMetadataIfChunkExists(world, i + j1, j + k2 + 1, k + l3, ModBlocks.leaves_1.blockID, 3);
                    }
                }
            }

            for (int k1 = 0; k1 < 1; k1++)
            {
                for (int l2 = 3; l2 < 8; l2++)
                {
                    for (int i4 = 3; i4 < 4; i4++)
                    {
                        setBlockandMetadataIfChunkExists(world, i + k1, j + l2, k + i4, ModBlocks.logs_1.blockID, 3);
                        setBlockandMetadataIfChunkExists(world, i + k1, j + l2 + 1, k + i4, ModBlocks.leaves_1.blockID, 3);
                    }
                }
            }

            generateLeaves(world, random, i, j + 4, k + 3);
            generateLeaves(world, random, i, j + 4, k - 3);
        }
        if (l == 2)
        {
            setBlockandMetadataIfChunkExists(world, i + 1, j + 1, k, ModBlocks.logs_1.blockID, 3);
            setBlockandMetadataIfChunkExists(world, i + 2, j + 2, k, ModBlocks.logs_1.blockID, 3);
            setBlockandMetadataIfChunkExists(world, i + 3, j + 3, k, ModBlocks.logs_1.blockID, 3);
            setBlockandMetadataIfChunkExists(world, i - 1, j + 1, k, ModBlocks.logs_1.blockID, 3);
            setBlockandMetadataIfChunkExists(world, i - 2, j + 2, k, ModBlocks.logs_1.blockID, 3);
            setBlockandMetadataIfChunkExists(world, i - 3, j + 3, k, ModBlocks.logs_1.blockID, 3);
            for (int l1 = -3; l1 < -2; l1++)
            {
                for (int i3 = 3; i3 < 8; i3++)
                {
                    for (int j4 = 0; j4 < 1; j4++)
                    {
                        setBlockandMetadataIfChunkExists(world, i + l1, j + i3, k + j4, ModBlocks.logs_1.blockID, 3);
                        setBlockandMetadataIfChunkExists(world, i + l1, j + i3 + 1, k + j4, ModBlocks.leaves_1.blockID, 3);
                    }
                }
            }

            for (int i2 = 3; i2 < 4; i2++)
            {
                for (int j3 = 3; j3 < 8; j3++)
                {
                    for (int k4 = 0; k4 < 1; k4++)
                    {
                        setBlockandMetadataIfChunkExists(world, i + i2, j + j3, k + k4, ModBlocks.logs_1.blockID, 3);
                        setBlockandMetadataIfChunkExists(world, i + i2, j + j3 + 1, k + k4, ModBlocks.leaves_1.blockID, 3);
                    }
                }
            }

            generateLeaves(world, random, i + 3, j + 4, k);
            generateLeaves(world, random, i - 3, j + 4, k);
        }
        return true;
    }

    private boolean generateLeaves(World world, Random random, int i, int j, int k)
    {
        for (int l = -1; l < 2; l++)
        {
            for (int j1 = 0; j1 < 4; j1++)
            {
                for (int l1 = 0; l1 < 1; l1++)
                {
                    if (world.isAirBlock(i + l, j + j1, k + l1))
                    {
                        setBlockandMetadataIfChunkExists(world, i + l, j + j1, k + l1, ModBlocks.leaves_1.blockID, 3);
                    }
                }
            }
        }

        for (int i1 = 0; i1 < 1; i1++)
        {
            for (int k1 = 0; k1 < 4; k1++)
            {
                for (int i2 = -1; i2 < 2; i2++)
                {
                    if (world.isAirBlock(i + i1, j + k1, k + i2))
                    {
                        setBlockandMetadataIfChunkExists(world, i + i1, j + k1, k + i2, ModBlocks.leaves_1.blockID, 3);
                    }
                }
            }
        }

        return true;
    }
}
