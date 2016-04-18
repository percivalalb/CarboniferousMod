package carboniferous.world.feature;

import java.util.Random;

import carboniferous.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenSediment extends WorldGenerator {
   
	/** The block ID for clay. */
    private Block sedimentBlock;
    private int sedimentBlockMetadata;

    /** The number of blocks to generate. */
    private int numberOfBlocks;

    public WorldGenSediment(int par1) {
    	super(false);
        this.sedimentBlock = ModBlocks.multiBlock1;
        this.numberOfBlocks = par1;
    }

    @Override
    public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5) {
        if (par1World.getBlock(par3, par4, par5).getMaterial() != Material.water) {
            return false;
        }
        else {
            int l = par2Random.nextInt(this.numberOfBlocks - 2) + 2;
            byte b0 = 1;

            for (int i1 = par3 - l; i1 <= par3 + l; ++i1) {
                for (int j1 = par5 - l; j1 <= par5 + l; ++j1) {
                    int k1 = i1 - par3;
                    int l1 = j1 - par5;

                    if (k1 * k1 + l1 * l1 <= l * l) {
                        for (int i2 = par4 - b0; i2 <= par4 + b0; ++i2) {
                            Block j2 = par1World.getBlock(i1, i2, j1);

                            if (j2 == ModBlocks.dirt) {
                            	Block randomBlockId = this.sedimentBlock;
                            	int randomBlockMetadata = 5 + (par2Random.nextInt(8) == 0 ? par2Random.nextInt(5) : 0);
                            	if(par2Random.nextInt(19) == 0) {
                            		randomBlockId = ModBlocks.multiBlock2;
                            		randomBlockMetadata = 6;
                            	}
                                par1World.setBlock(i1, i2, j1, randomBlockId, randomBlockMetadata, 2);
                            }
                        }
                    }
                }
            }

            return true;
        }
    }
}
