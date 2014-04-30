package carboniferous.world.structure;

import java.util.List;
import java.util.Random;

import carboniferous.core.helper.LogHelper;

import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;

public class ComponentSpiderLairEntrance extends StructureComponent {

	private int posX;
	private int posY;
	private int posZ;
	//private static LOTRWorldGenDwarvenMineEntrance entranceGen = new LOTRWorldGenDwarvenMineEntrance(false);
	private int direction;
	
	protected ComponentSpiderLairEntrance(World world, int par1, Random random, int i, int k) {
		super(par1);
		LogHelper.logWarning("Component Spider Lair");
		int j = 60;
		//Private varibles
		int heightAboveGround = 1;
		int distanceUnderGround = 30;
		int width = 5;
		//End
	    this.boundingBox = new StructureBoundingBox(i - width, distanceUnderGround, k - width, i + width, j + heightAboveGround, k + width);
	    this.posX = i;
	    this.posY = (j + 1);
	    this.posZ = k;
	}

	public void buildComponent(StructureComponent component, List list, Random random) {
		StructureBoundingBox structureBoundingBox = null;
	    this.direction = random.nextInt(4);
	    switch (this.direction) {
	    case 0:
	    	structureBoundingBox = new StructureBoundingBox(this.posX - 1, this.boundingBox.minY + 1, this.posZ + 4, this.posX + 1, this.boundingBox.minY + 4, this.posZ + 15);
	    	break;
	    case 1:
	    	structureBoundingBox = new StructureBoundingBox(this.posX - 15, this.boundingBox.minY + 1, this.posZ - 1, this.posX - 4, this.boundingBox.minY + 4, this.posZ + 1);
	    	break;
	    case 2:
	    	structureBoundingBox = new StructureBoundingBox(this.posX - 1, this.boundingBox.minY + 1, this.posZ - 15, this.posX + 1, this.boundingBox.minY + 4, this.posZ - 4);
	    	break;
	    case 3:
	    	structureBoundingBox = new StructureBoundingBox(this.posX + 4, this.boundingBox.minY + 1, this.posZ - 1, this.posX + 15, this.boundingBox.minY + 4, this.posZ + 1);
	    }

	    ComponentSpiderLairCorridor corridor = new ComponentSpiderLairCorridor(0, random, structureBoundingBox, this.direction);
	    list.add(corridor);
	    corridor.buildComponent(component, list, random);
	}

	
	@Override
	public boolean addComponentParts(World world, Random random, StructureBoundingBox structureboundingbox) {
		return true;
	}
}
