package carboniferous.world.structure;

import carboniferous.ModBlocks;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.StructureStart;

public class MapGenSpiderLair extends MapGenStructure {

	private double spawnChance = 0.315D;
	
	@Override
	protected boolean canSpawnStructureAtCoords(int i, int j) {
		boolean randDouble = this.rand.nextDouble() < this.spawnChance;
		boolean randMaxAbs = this.rand.nextInt(80) < Math.max(Math.abs(i), Math.abs(j));
		return randDouble && randMaxAbs;
	}

	@Override
	protected StructureStart getStructureStart(int i, int j) {
		return new StructureSpiderLairStart(this.worldObj, this.rand, i, j);
	}

}
