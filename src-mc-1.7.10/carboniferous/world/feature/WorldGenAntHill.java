package carboniferous.world.feature;

import java.util.Random;

import carboniferous.ModBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class WorldGenAntHill extends WorldGeneratorCarboniferous {

	public WorldGenAntHill(boolean par1) {
		super(par1);
	}
	
	@Override
	public boolean generate(World world, Random random, int x, int y, int z) {
		if(getBlockIfChunkExists(world, x, y, z) == Blocks.air && getBlockIfChunkExists(world, x, y - 1, z) == ModBlocks.grass) {
			this.func_150515_a(world, x, y, z, ModBlocks.antHill);
			this.func_150515_a(world, x, y - 1, z, ModBlocks.dirt);
			return true;
		}
		
		return false;
	}

}
