package carboniferous.world.feature;

import java.util.Random;

import carboniferous.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class WorldGenSmallTrees extends WorldGenAbstractTree {
  
	public WorldGenSmallTrees(boolean par1) {
        super(par1);
    }

    public boolean generate(World world, Random random, int i, int j, int k)
    {
        int l;
        boolean flag;
        label0:
        {
            l = random.nextInt(3) + 4;
            for (; world.getBlock(i, j - 1, k).getMaterial() == Material.water; j--) { }
            flag = true;
            if (j >= 1)
            {
                world.getClass();
                if (j + l + 1 <= 128)
                {
                    break label0;
                }
            }
            return false;
        }
        label1:
        {
            for (int i1 = j; i1 <= j + 1 + l; i1++)
            {
                byte byte0 = 1;
                if (i1 == j)
                {
                    byte0 = 0;
                }
                if (i1 >= (j + 1 + l) - 2)
                {
                    byte0 = 2;
                }
                for (int k2 = i - byte0; k2 <= i + byte0 && flag; k2++)
                {
                    for (int i3 = k - byte0; i3 <= k + byte0 && flag; i3++)
                    {
                        if (i1 >= 0)
                        {
                            world.getClass();
                            if (i1 < 128)
                            {
                                Block k3 = world.getBlock(k2, i1, i3);
                                if (k3 == Blocks.air || k3 == ModBlocks.leaves_1)
                                {
                                    continue;
                                }
                                if (k3 == Blocks.water || k3 == Blocks.flowing_water)
                                {
                                    if (i1 > j)
                                    {
                                        flag = false;
                                    }
                                }
                                else
                                {
                                    flag = false;
                                }
                                continue;
                            }
                        }
                        flag = false;
                    }
                }
            }

            if (!flag)
            {
                return false;
            }
            Block j1 = world.getBlock(i, j - 1, k);
            if (j1 == ModBlocks.grass || j1 == ModBlocks.dirt)
            {
                world.getClass();
                if (j < 128 - l - 1)
                {
                    break label1;
                }
            }
            return false;
        }
        world.setBlock(i, j - 1, k, ModBlocks.dirt);
        for (int k1 = (j - 3) + l; k1 <= j + l; k1++)
        {
            int i2 = k1 - (j + l);
            int l2 = 1 - i2 / 2;
            for (int j3 = i - l2; j3 <= i + l2; j3++)
            {
                int l3 = j3 - i;
                for (int i4 = k - l2; i4 <= k + l2; i4++)
                {
                    int j4 = i4 - k;
                    if ((Math.abs(l3) != l2 || Math.abs(j4) != l2 || random.nextInt(2) != 0 && i2 != 0) && !world.getBlock(j3, k1, i4).isOpaqueCube())
                    {
                        world.setBlock(j3, k1, i4, ModBlocks.leaves_1);
                    }
                }
            }
        }

        for (int l1 = 0; l1 < l; l1++)
        {
            Block j2 = world.getBlock(i, j + l1, k);
            if (j2 == Blocks.air || j2 == ModBlocks.leaves_1 || j2 == Blocks.flowing_water || j2 == Blocks.water)
            {
                world.setBlock(i, j + l1, k, ModBlocks.logs_1);
            }
        }

        return true;
    }
}
