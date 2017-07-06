package carboniferous.world.feature;

import java.util.Random;

import carboniferous.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenCordaites extends WorldGenAbstractTree
{
	private boolean isSapling = false;
	
    public WorldGenCordaites(boolean par1) {
    	super(par1);
    }
    
    public WorldGenerator setIsSapling() {
    	this.isSapling = true;
    	return this;
    }

    public boolean generate(World worldIn, Random rand, BlockPos position) {
    	Block block = this.getBlockIfChunkExists(world, i, j - 1, k);
    	boolean isSoil = (block != null && block.canSustainPlant(world, i, j - 1, k, ForgeDirection.UP, (BlockSapling)ModBlocks.saplings_1));
        if (isSoil && isAirBlockIfChunkExists(world, i, j + 10, k) && (j < 85 || isSapling))
        {
            for (int l = -4; l < 5; l++)
            {
                for (int i1 = 0; i1 < 40; i1++)
                {
                    for (int j1 = -4; j1 < 5; j1++)
                    {
                        for (int k1 = 0; k1 < 1; k1++)
                        {
                            for (int i2 = 0; i2 < 28 + random.nextInt(6); i2++)
                            {
                                for (int k2 = 0; k2 < 1; k2++)
                                {
                                   this.setBlockandMetadataIfChunkExists(world, i + k1, j + i2, k + k2, ModBlocks.logs_1, 2);
                                }
                            }
                        }

                        if (this.getBlockIfChunkExists(world, i + l, (j + i1) - 1, k + j1) == ModBlocks.logs_1 && isAirBlockIfChunkExists(world, i + l, j + i1, k + j1))
                        {
                            for (int l1 = -2; l1 < 3; l1++)
                            {
                                for (int j2 = -2; j2 < 3; j2++)
                                {
                                    for (int l2 = -2; l2 < 3; l2++)
                                    {
                                        int i3 = (int)Math.round(Math.sqrt(Math.pow(l1, 2D) + Math.pow(j2, 2D) + Math.pow(l2, 2D)));
                                        if (i3 <= 2 && isAirBlockIfChunkExists(world, i + l + l1, j + i1 + j2, k + j1 + l2))
                                        {
                                           this.setBlockandMetadataIfChunkExists(world, i + l + l1, j + i1 + j2, k + j1 + l2, ModBlocks.leaves_1, 2);
                                        }
                                    }
                                }
                            }
                        }
                        generateBranches(world, random, i + l, j + i1, k + j1, 1, 2, 3, 4, 5, 0, 0, 0, 0, 0);
                        generateBranches(world, random, i + l, j + i1, k + j1, -1, -2, -3, -4, -5, 0, 0, 0, 0, 0);
                        generateBranches(world, random, i + l, j + i1, k + j1, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5);
                        generateBranches(world, random, i + l, j + i1, k + j1, 0, 0, 0, 0, 0, -1, -2, -3, -4, -5);
                        generateBranches(world, random, i + l, j + i1, k + j1, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5);
                        generateBranches(world, random, i + l, j + i1, k + j1, -1, -2, -3, -4, -5, 1, 2, 3, 4, 5);
                        generateBranches(world, random, i + l, j + i1, k + j1, 1, 2, 3, 4, 5, -1, -2, -3, -4, -5);
                        generateBranches(world, random, i + l, j + i1, k + j1, -1, -2, -3, -4, -5, -1, -2, -3, -4, -5);
                    }
                }
            }
            return true;
        }
        return false;
    }

    private boolean generateBranches(World world, Random random, int i, int j, int k, int l, int i1,
            int j1, int k1, int l1, int i2, int j2, int k2, int l2,
            int i3)
    {
        if (isAirBlockIfChunkExists(world, i, j, k) && this.getBlockIfChunkExists(world, i - l, j - 1, k - i2) == ModBlocks.logs_1 && world.getBlockMetadata(i - l, j - 1, k - i2) == 2 && random.nextInt(10) == 0)
        {
           this.setBlockandMetadataIfChunkExists(world, i, j, k, ModBlocks.logs_1, 2);
           this.setBlockandMetadataIfChunkExists(world, i + l, j + 1, k + i2, ModBlocks.logs_1, 2);
           this.setBlockandMetadataIfChunkExists(world, i + i1, j + 2, k + j2, ModBlocks.logs_1, 2);
           this.setBlockandMetadataIfChunkExists(world, i + j1, j + 3, k + k2, ModBlocks.logs_1, 2);
           this.setBlockandMetadataIfChunkExists(world, i + k1, j + 4, k + l2, ModBlocks.logs_1, 2);
           this.setBlockandMetadataIfChunkExists(world, i + l1, j + 5, k + i3, ModBlocks.logs_1, 2);
            for (int j3 = -2; j3 < 3; j3++)
            {
                for (int k3 = -2; k3 < 3; k3++)
                {
                    for (int l3 = -2; l3 < 3; l3++)
                    {
                        int i4 = (int)Math.round(Math.sqrt(Math.pow(j3, 2D) + Math.pow(k3, 2D) + Math.pow(l3, 2D)));
                        int j4 = i + l1;
                        int k4 = j + 5;
                        int l4 = k + i3;
                        if (i4 <= 2 && isAirBlockIfChunkExists(world, j4 + j3, k4 + k3, l4 + l3))
                        {
                           this.setBlockandMetadataIfChunkExists(world, j4 + j3, k4 + k3, l4 + l3, ModBlocks.leaves_1, 2);
                        }
                    }
                }
            }
        }
        return true;
    }


	public void setBlockandMetadataIfChunkExists(World world, int x, int y, int z, Block blockId, int metadata) {
		//if (world.getChunkProvider().chunkExists(x >> 4, z >> 4)){
			try{
				world.setBlock(x, y, z, blockId, metadata, 2);
			}catch(Exception e){
				//Work around to stop crash
			}
		//}
	}
	
	public void setBlockandMetadataIfChunkExists(World world, int x, int y, int z, Block blockId, int metadata, int updateFlag) {
		//if (world.getChunkProvider().chunkExists(x >> 4, z >> 4)){
			try{
				world.setBlock(x, y, z, blockId, metadata, updateFlag);
			}catch(Exception e){
				//Work around to stop crash
			}
		//}
	}
    
    public Block getBlockIfChunkExists(World world, int x, int y, int z) {
		//if (world.getChunkProvider().chunkExists(x >> 4, z >> 4)){
			try{
				return world.getBlock(x, y, z);
			}catch(Exception e){
				//Work around to stop crash
			}
		//}
		return Blocks.air;
	}
    
    public boolean isAirBlockIfChunkExists(World world, int x, int y, int z) {
    	return this.getBlockIfChunkExists(world, x, y, z) == Blocks.air;
    }
    
    public Material getBlockMaterialIfChunkExists(World world, int x, int y, int z) {
    	Block block = this.getBlockIfChunkExists(world, x, y, z);
        return block.getMaterial();
    }
    
    public TileEntity getTileEntityIfChunkExists(World world, int x, int y, int z) {
    	if (world.getChunkProvider().chunkExists(x >> 4, z >> 4)){
			try{
				return world.getTileEntity(x, y, z);
			}catch(Exception e){
				//Work around to stop crash
			}
    	}
		return null;
    }
}

