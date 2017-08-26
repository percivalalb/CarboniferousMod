package carboniferous.world.feature;

import java.util.Random;

import carboniferous.ModBlocks;
import carboniferous.block.BlockCarboniferousSapling;
import carboniferous.block.EnumWood;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class WorldGenCalamites extends WorldGenAbstractTree {
	
	public IBlockState blockStateLog;
	public IBlockState blockStateLeaves;
	
    public WorldGenCalamites(boolean notify) {
        super(notify);
        this.blockStateLog = ModBlocks.LOG_0.getDefaultState().withProperty(ModBlocks.LOG_0.VARIANT, EnumWood.CALAMITES);
        this.blockStateLeaves = ModBlocks.LEAVES_0.getDefaultState().withProperty(ModBlocks.LEAVES_0.VARIANT, EnumWood.CALAMITES);
    }
    
    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position) {
    	IBlockState soil = worldIn.getBlockState(position.down());
    	
    	boolean isSoil = (soil.getBlock().canSustainPlant(soil, worldIn, position.down(), EnumFacing.UP, ModBlocks.SAPLING_0));
    	if(isSoil && worldIn.isAirBlock(position.up(12))) {
            for(int l = 0; l < 1; l++) {
                for(int i1 = 0; i1 < 24; i1++) {
                    for(int j1 = 0; j1 < 1; j1++) {
                    	this.setBlockAndNotifyAdequately(worldIn, position.add(l, i1, j1), this.blockStateLog);
                    	this.setBlockAndNotifyAdequately(worldIn, position.add(l, i1 + 1, j1), this.blockStateLeaves);
                    }
                }
            }
            
            this.generateLeaves(worldIn, rand, position.up(23), -1, 2);
            this.generateLeaves(worldIn, rand, position.up(23), -1, 2);
            return true;
        }
    	
        return false;
    }

    private boolean generateLeaves(World worldIn, Random random, BlockPos pos, int relSizeNeg, int relSizePos) {
        for(int j1 = relSizeNeg; j1 < relSizePos; j1++) {
            for(int k1 = 0; k1 < 1; k1++) {
                for(int l1 = relSizeNeg; l1 < relSizePos; l1++) {
                    if(worldIn.isAirBlock(pos.add(j1, k1, l1))) {
                    	this.setBlockAndNotifyAdequately(worldIn, pos.add(j1, k1, l1), this.blockStateLeaves);
                    }
                }
            }

            if(worldIn.getBlockState(pos.down(14)).getBlock() == ModBlocks.LOG_0 && worldIn.getBlockState(pos.down(14)).getValue(ModBlocks.LOG_0.VARIANT) == EnumWood.CALAMITES)
                this.generateLeaves(worldIn, random, pos.down(4), relSizeNeg - 1, relSizePos + 1);
        }

        return true;
    }
}
