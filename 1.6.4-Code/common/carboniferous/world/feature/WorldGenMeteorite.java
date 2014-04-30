package carboniferous.world.feature;

import java.util.Random;

import net.minecraft.world.World;

public class WorldGenMeteorite extends WorldGeneratorCarboniferous {

	public double spawnChance = 0.002D;
	
	public WorldGenMeteorite(boolean par1) {
		super(par1);
	}
	
	@Override
	public boolean generate(World world, Random random, int x, int y, int z) {
		if(random.nextDouble() > spawnChance) {
			return false;
		}
		generateMeteorite(world, random, x, y, z);
		return true;
	}
	
	public void generateMeteorite(World world, Random random, int x, int y, int z) {
		
	}
}
