package carboniferous.world.feature;

import java.util.Random;

import carboniferous.ModBlocks;
import carboniferous.block.EnumWood;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumFacing.Axis;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class WorldGenSigillaria extends WorldGenAbstractTree {
	
	public IBlockState blockStateLog;
	public IBlockState blockStateLeaves;
	
    public WorldGenSigillaria(boolean notify) {
        super(notify);
        this.blockStateLog = ModBlocks.LOG_0.getDefaultState().withProperty(ModBlocks.LOG_0.VARIANT, EnumWood.SIGILLARIA);
        this.blockStateLeaves = ModBlocks.LEAVES_0.getDefaultState().withProperty(ModBlocks.LEAVES_0.VARIANT, EnumWood.SIGILLARIA);
    }

    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position) {
    	IBlockState soil = worldIn.getBlockState(position.down());
    	
    	boolean isSoil = (soil.getBlock().canSustainPlant(soil, worldIn, position.down(), EnumFacing.UP, ModBlocks.SAPLING_0));
    	if(isSoil && worldIn.isAirBlock(position.up(12))) {
            for (int l = 0; l < 1; l++)
            {
                for (int j1 = 0; j1 < 22; j1++)
                {
                    for (int k1 = 0; k1 < 1; k1++)
                    {
                    	if(worldIn.isAirBlock(position.add(l, j1, k1))) {
                    		this.setBlockAndNotifyAdequately(worldIn, position.add(l, j1, k1), this.blockStateLog);
                    	}
                    }
                }
            }

            this.generateBranches(worldIn, rand, position.up(21), rand.nextInt(3));
            
            return true;
        }
        return false;
    }

    private boolean generateBranches(World worldIn, Random random, BlockPos pos, int type) {
        if(type == 0) {
            for (int i1 = 0; i1 < 1; i1++) {
                for (int j2 = 0; j2 < 5; j2++) {
                    for (int k3 = 0; k3 < 1; k3++) {
                        this.setBlockAndNotifyAdequately(worldIn, pos.add(i1, j2, k3), this.blockStateLog);
                        this.setBlockAndNotifyAdequately(worldIn, pos.add(i1, j2 + 1, k3), this.blockStateLeaves);
                    }
                }
            }

            this.generateLeaves(worldIn, random, pos.up());
        }
        
        //Positive z and x direction
        EnumFacing axis = type == 1 ? EnumFacing.SOUTH : EnumFacing.EAST; 
        EnumFacing other = type == 1 ? EnumFacing.EAST : EnumFacing.SOUTH; 
        
        if (type == 1)
        {
            this.setBlockAndNotifyAdequately(worldIn, pos.up(1).offset(axis, 1), this.blockStateLog);
            this.setBlockAndNotifyAdequately(worldIn, pos.up(2).offset(axis, 2), this.blockStateLog);
            this.setBlockAndNotifyAdequately(worldIn, pos.up(3).offset(axis, 3), this.blockStateLog);
            this.setBlockAndNotifyAdequately(worldIn, pos.up(1).offset(axis, -1), this.blockStateLog);
            this.setBlockAndNotifyAdequately(worldIn, pos.up(2).offset(axis, -2), this.blockStateLog);
            this.setBlockAndNotifyAdequately(worldIn, pos.up(3).offset(axis, -3), this.blockStateLog);
            for (int j1 = 0; j1 < 1; j1++)
            {
                for (int k2 = 3; k2 < 8; k2++)
                {
                    for (int l3 = -3; l3 < -2; l3++)
                    {
                        this.setBlockAndNotifyAdequately(worldIn, pos.up(k2).offset(axis, l3).offset(other, j1), this.blockStateLog);
                        this.setBlockAndNotifyAdequately(worldIn, pos.up(k2 + 1).offset(axis, l3).offset(other, j1), this.blockStateLeaves);
                    }
                }
            }

            for (int k1 = 0; k1 < 1; k1++)
            {
                for (int l2 = 3; l2 < 8; l2++)
                {
                    for (int i4 = 3; i4 < 4; i4++)
                    {
                        this.setBlockAndNotifyAdequately(worldIn, pos.up(l2).offset(axis, i4).offset(other, k1), this.blockStateLog);
                        this.setBlockAndNotifyAdequately(worldIn, pos.up(l2 + 1).offset(axis, i4).offset(other, k1), this.blockStateLeaves);
                    }
                }
            }

            this.generateLeaves(worldIn, random, pos.up(4).offset(axis, 3));
            this.generateLeaves(worldIn, random, pos.up(4).offset(axis, -3));
        }
        
        return true;
    }

    private boolean generateLeaves(World worldIn, Random random, BlockPos pos)
    {
        for (int l = -1; l < 2; l++)
        {
            for (int j1 = 0; j1 < 4; j1++)
            {
                for (int l1 = 0; l1 < 1; l1++)
                {
                    if (worldIn.isAirBlock(pos.add(l, j1, l1)))
                    {
                        this.setBlockAndNotifyAdequately(worldIn, pos.add(l, j1, l1), this.blockStateLeaves);
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
                    if (worldIn.isAirBlock(pos.add(i1, k1, i1)))
                    {
                        this.setBlockAndNotifyAdequately(worldIn, pos.add(i1, k1, i1), this.blockStateLeaves);
                    }
                }
            }
        }

        return true;
    }
}
