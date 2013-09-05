package carboniferous.world.feature;

import java.util.Random;

import carboniferous.ModBlocks;

import net.minecraft.world.World;

public class WorldGenAntHill extends WorldGeneratorCarboniferous {

	public WorldGenAntHill(boolean par1) {
		super(par1);
	}
	
	@Override
	public boolean generate(World world, Random random, int x, int y, int z) {
		if(getBlockIfChunkExists(world, x, y, z) == 0 && getBlockIfChunkExists(world, x, y - 1, z) == ModBlocks.grass.blockID) {
			setBlock(world, x, y, z, ModBlocks.antHill.blockID);
			setBlock(world, x, y - 1, z, ModBlocks.dirt.blockID);
			return true;
		}
		
		return false;
	}

}
