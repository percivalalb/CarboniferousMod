package carboniferous.world.feature;

import java.util.Random;

import carboniferous.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class WorldGenVolcano extends WorldGeneratorCarboniferous {

	public double spawnChance = 0.002D;
	
	public WorldGenVolcano(boolean par1) {
		super(par1);
	}
	
	@Override
	public boolean generate(World world, Random random, int x, int y, int z) {
		if(random.nextDouble() > spawnChance) {
			return false;
		}
		if(random.nextDouble() < 0.68F) {
			if(y < 70) {
				this.genTallVolcano(world, random, x, y, z);
			}
		}
		else {
			if(y > 70) {
				this.genFlatVolcano(world, random, x, y, z);
			}
		}
		
		return true;
	}
	
	public void genFlatVolcano(World world, Random random, int x, int y, int z) {
		int l = random.nextInt(18) + 26;
        int height = 15;
        int depth = 15;

        for (int i1 = x - l; i1 <= x + l; ++i1) {
            for (int j1 = z - l; j1 <= z + l; ++j1) {
                int k1 = i1 - x;
                int l1 = j1 - z;

                if (k1 * k1 + l1 * l1 <= l * l) {
                    for (int i2 = y - depth; i2 <= y + height; ++i2) {
                    	Block block = this.getBlockIfChunkExists(world, i1, i2, j1);
                    	if(block == ModBlocks.grass) {
                    		boolean diamond = random.nextInt(2000) == 0;
                    		this.setBlockandMetadataIfChunkExists(world, i1, i2, j1, diamond ? ModBlocks.multiBlock3 : ModBlocks.multiBlock2, diamond ? 3 : 11, 2);
                    	}
                    }
                }
            }
        }
        for(int var1 = 3; var1 < y + 3; ++var1) {
        	this.setBlockandMetadataIfChunkExists(world, x, var1, z, Blocks.lava, 11, 3);
        }
        
	}
	
	public void genTallVolcano(World world, Random random, int x, int y, int z) {
		int l = random.nextInt(7) + 6;
        int height = 17 + random.nextInt(13);
        int depth = 26 + random.nextInt(12);

        for (int i1 = x - l; i1 <= x + l; ++i1) {
            for (int j1 = z - l; j1 <= z + l; ++j1) {
                int k1 = i1 - x;
                int l1 = j1 - z;

                if (k1 * k1 + l1 * l1 <= l * l) {
                    for (int i2 = y - depth; i2 <= y + height; ++i2) {
                		boolean diamond = random.nextInt(2000) == 0;
                		this.setBlockandMetadataIfChunkExists(world, i1, i2, j1, diamond ? ModBlocks.multiBlock3 : ModBlocks.multiBlock2, diamond ? 3 : 11, 2);
                    }
                }
            }
        }
        for (int i1 = x - (l + 1); i1 <= x + (l + 1); ++i1) {
            for (int j1 = z - (l + 1); j1 <= z + (l + 1); ++j1) {
                int k1 = i1 - x;
                int l1 = j1 - z;

                if (k1 * k1 + l1 * l1 <= (l + 1) * (l + 1)) {
                    for (int i2 = y - depth; i2 <= y + height - (5 + random.nextInt(3)); ++i2) {
                		boolean diamond = random.nextInt(2000) == 0;
                		this.setBlockandMetadataIfChunkExists(world, i1, i2, j1, diamond ? ModBlocks.multiBlock3 : ModBlocks.multiBlock2, diamond ? 3 : 11, 2);
                    }
                }
            }
        }
        for (int i1 = x - (l + 2); i1 <= x + (l + 2); ++i1) {
            for (int j1 = z - (l + 2); j1 <= z + (l + 2); ++j1) {
                int k1 = i1 - x;
                int l1 = j1 - z;

                if (k1 * k1 + l1 * l1 <= (l + 2) * (l + 2)) {
                    for (int i2 = y - depth; i2 <= y + height - (13 + random.nextInt(5)); ++i2) {
                		boolean diamond = random.nextInt(2000) == 0;
                		this.setBlockandMetadataIfChunkExists(world, i1, i2, j1, diamond ? ModBlocks.multiBlock3 : ModBlocks.multiBlock2, diamond ? 3 : 11, 2);
                    }
                }
            }
        }
        for (int i1 = x - (l + 4); i1 <= x + (l + 4); ++i1) {
            for (int j1 = z - (l + 4); j1 <= z + (l + 4); ++j1) {
                int k1 = i1 - x;
                int l1 = j1 - z;

                if (k1 * k1 + l1 * l1 <= (l + 4) * (l + 4)) {
                    for (int i2 = y - depth; i2 <= y + height - (19 + random.nextInt(5)); ++i2) {
                		boolean diamond = random.nextInt(2000) == 0;
                		this.setBlockandMetadataIfChunkExists(world, i1, i2, j1, diamond ? ModBlocks.multiBlock3 : ModBlocks.multiBlock2, diamond ? 3 : 11, 2);
                    }
                }
            }
        }
        for (int i1 = x - (l + 5); i1 <= x + (l + 5); ++i1) {
            for (int j1 = z - (l + 5); j1 <= z + (l + 5); ++j1) {
                int k1 = i1 - x;
                int l1 = j1 - z;

                if (k1 * k1 + l1 * l1 <= (l + 5) * (l + 5)) {
                    for (int i2 = y - depth; i2 <= y + height - (25 + random.nextInt(3)); ++i2) {
                		boolean diamond = random.nextInt(2000) == 0;
                		this.setBlockandMetadataIfChunkExists(world, i1, i2, j1, diamond ? ModBlocks.multiBlock3 : ModBlocks.multiBlock2, diamond ? 3 : 11, 2);
                    }
                }
            }
        }
        for (int i1 = x - (l + 7); i1 <= x + (l + 7); ++i1) {
            for (int j1 = z - (l + 7); j1 <= z + (l + 7); ++j1) {
                int k1 = i1 - x;
                int l1 = j1 - z;

                if (k1 * k1 + l1 * l1 <= (l + 7) * (l + 7)) {
                    for (int i2 = y - depth; i2 <= y + height - (29 + random.nextInt(3)); ++i2) {
                		boolean diamond = random.nextInt(2000) == 0;
                		this.setBlockandMetadataIfChunkExists(world, i1, i2, j1, diamond ? ModBlocks.multiBlock3 : ModBlocks.multiBlock2, diamond ? 3 : 11, 2);
                    }
                }
            }
        }
        for (int i1 = x - (l - 1); i1 <= x + (l - 1); ++i1) {
            for (int j1 = z - (l - 1); j1 <= z + (l - 1); ++j1) {
                int k1 = i1 - x;
                int l1 = j1 - z;

                if (k1 * k1 + l1 * l1 <= (l - 1) * (l - 1)) {
                    for (int i2 = y - depth; i2 <= y + height; ++i2) {
                    	this.setBlockandMetadataIfChunkExists(world, i1, i2, j1, i2 == (y + height) ? Blocks.air : Blocks.lava, 0, 3);
                    }
                }
            }
        }
	}
}
