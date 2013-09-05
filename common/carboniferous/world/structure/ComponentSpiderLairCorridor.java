package carboniferous.world.structure;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;

public class ComponentSpiderLairCorridor extends StructureComponent {

	private int sectionCount;
	
	protected ComponentSpiderLairCorridor(int par1, Random random, StructureBoundingBox structureBoundingBox, int j) {
		super(par1);
		this.coordBaseMode = j;
	    this.boundingBox = structureBoundingBox;

	    if ((this.coordBaseMode != 2) && (this.coordBaseMode != 0))
	    {
	      	this.sectionCount = (this.boundingBox.getYSize() / 4);
	    }
	    else
	    {
	    	this.sectionCount = (this.boundingBox.getCenterY() / 4);
	    }
	}

	public void buildComponent(StructureComponent component, List list, Random random) {
		
	}
	
	@Override
	public boolean addComponentParts(World world, Random random, StructureBoundingBox structureboundingbox) {
		this.fillWithBlocks(world, structureboundingbox, 0, -2, 0, 0, 10, 0, Block.glowStone.blockID, 0, false);
		return true;
	}

}
