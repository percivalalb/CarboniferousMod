package carboniferous.world.feature;

import java.util.Random;

import carboniferous.ModBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class WorldGenCoral extends WorldGeneratorCarboniferous {

	public WorldGenCoral(boolean par1) {
		super(par1);
	}
	
	@Override
	public boolean generate(World world, Random random, int x, int y, int z) {
		//if(y > 54) return false;
		if(getBlockIfChunkExists(world, x, y, z) == Blocks.water && 
				getBlockIfChunkExists(world, x, y + 1, z) == Blocks.water && 
				ModBlocks.coral.canBlockStay(world, x, y, z)) {
			
			setBlockandMetadataIfChunkExists(world, x, y, z, ModBlocks.coral, random.nextInt(5));
			return true;
		}
		
		return false;
	}

}
