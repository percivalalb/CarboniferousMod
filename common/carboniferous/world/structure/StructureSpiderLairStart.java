package carboniferous.world.structure;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureStart;

public class StructureSpiderLairStart extends StructureStart {

	public StructureSpiderLairStart(World world, Random random, int i, int j) {
	    ComponentSpiderLairEntrance startComponent = new ComponentSpiderLairEntrance(world, 0, random, (i << 4) + 8, (j << 4) + 8);
	    this.components.add(startComponent);
	    startComponent.buildComponent(startComponent, this.components, random);
	    this.updateBoundingBox();
	    this.generateStructure(world, random, boundingBox);
	}
}
