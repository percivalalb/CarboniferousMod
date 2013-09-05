package carboniferous.world.structure;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.world.World;
import carboniferous.world.feature.WorldGeneratorCarboniferous;

public abstract class WorldMapGenCarboniferous extends WorldGeneratorCarboniferous {

	public WorldMapGenCarboniferous(boolean doNofity) {
		super(doNofity);
	}
	
	public void fillWithBlocks(World world, int minX, int minY, int minZ, int maxX, int maxY, int  maxZ, int placeBlockId) {
		this.fillWithBlocks(world, minX, minY, minZ, maxX, maxY, maxZ, placeBlockId, 0);
	}
	
	public void fillWithBlocks(World world, int minX, int minY, int minZ, int maxX, int maxY, int maxZ, int placeBlockId, int placeBlockMetadata) {
		 for (int i2 = minY; i2 <= maxY; ++i2) {
			 for (int j2 = minX; j2 <= maxX; ++j2) {
				 for (int k2 = minZ; k2 <= maxZ; ++k2) {
					 this.setBlockandMetadataIfChunkExists(world, j2, i2, k2, placeBlockId, placeBlockMetadata);
				 }
			 }
		 }
	}
	
	public void randomlyFillWithBlocks(World world, int minX, int minY, int minZ, int maxX, int maxY, int maxZ, int placeBlockId, int placeBlockMetadata, Random rand, double chance) {
		for (int i2 = minY; i2 <= maxY; ++i2) {
			 for (int j2 = minX; j2 <= maxX; ++j2) {
				 for (int k2 = minZ; k2 <= maxZ; ++k2) {
					 if(rand.nextDouble() < chance) {
						 this.setBlockandMetadataIfChunkExists(world, j2, i2, k2, placeBlockId, placeBlockMetadata);
					 }
				 }
			 }
		 }
	}
	
	public void setBlockAsSpawner(World world, int x, int y, int z, Class<? extends EntityLiving> mob) {
		this.setBlockandMetadataIfChunkExists(world, x, y, z, Block.mobSpawner.blockID, 0);
		TileEntity tile = this.getBlockTileEntityIfChunkExists(world, x, y, z);
		if(tile instanceof TileEntityMobSpawner) {
			((TileEntityMobSpawner)tile).getSpawnerLogic().setMobID((String)EntityList.classToStringMapping.get(mob));
		}
	}
	
	public void buildCube(World world, int minX, int minY, int minZ, int maxX, int maxY, int maxZ, int placeBlockId, int placeBlockMetadata) {
		//Roof
		this.fillWithBlocks(world, minX, maxY, minZ, maxX, maxY, maxZ, placeBlockId, placeBlockMetadata);
		//Floor
		this.fillWithBlocks(world, minX, minY, minZ, maxX, minY, maxZ, placeBlockId, placeBlockMetadata);
		//Walls
		this.fillWithBlocks(world, minX, minY, minZ, minX, maxY, maxZ, placeBlockId, placeBlockMetadata);
		this.fillWithBlocks(world, maxX, minY, minZ, maxX, maxY, maxZ, placeBlockId, placeBlockMetadata);
		
		this.fillWithBlocks(world, minX, minY, minZ, maxX, maxY, minZ, placeBlockId, placeBlockMetadata);
		this.fillWithBlocks(world, minX, minY, maxX, maxX, maxY, maxZ, placeBlockId, placeBlockMetadata);
		
	}
}
