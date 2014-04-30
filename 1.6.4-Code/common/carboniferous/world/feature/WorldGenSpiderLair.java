package carboniferous.world.feature;

import java.util.Random;

import carboniferous.ModBlocks;
import carboniferous.core.helper.GeneratorHelper;
import carboniferous.entity.EntityMesothelae;
import carboniferous.world.structure.WorldMapGenCarboniferous;
import net.minecraft.block.Block;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;

public class WorldGenSpiderLair extends WorldMapGenCarboniferous {

	private double spawnChance = 0.035D;
	
	public WorldGenSpiderLair(boolean doNofity) {
		super(doNofity);
	}
	
	@Override
	public boolean generate(World world, Random random, int x, int y, int z) {
		if(random.nextDouble() > this.spawnChance) return false;
		y = world.getHeightValue(x, z) - 1;
		if(y>78) return false;
		if(this.hasWaterNearBy(world, x, y, z)) return false;
		if(!this.blocksUnderAreSoild(world, x, y, z)) return false;
		if(getBlockIfChunkExists(world, x, y, z)!= ModBlocks.grass.blockID) return false;
		for (int cx = -1; cx <= 1; cx++) {
			for (int cy = -19; cy < 2; cy++) {
				for (int cz = -1; cz <= 1; cz++) {
					setBlockandMetadataIfChunkExists(world, x + cx, y + cy, z + cz, 0, 0);
					if(random.nextInt(3) == 0) {
						setBlockandMetadataIfChunkExists(world, x + cx, y + cy, z + cz, Block.web.blockID, 0);
					}
				}
			}
	    }
		setBlockandMetadataIfChunkExists(world, x  + random.nextInt(4) - 2, y + 1, z + random.nextInt(5) - 2, Block.web.blockID, 0);
		setBlockandMetadataIfChunkExists(world, x  + random.nextInt(4) - 2, y + 1, z + random.nextInt(5) - 2, Block.web.blockID, 0);
		setBlockandMetadataIfChunkExists(world, x  + random.nextInt(4) - 2, y + 1, z + random.nextInt(5) - 2, Block.web.blockID, 0);
		for (int var1 = 0; var1 <= random.nextInt(4) + 2; var1++) {
			EntityMesothelae mesothelae = new EntityMesothelae(world);
			mesothelae.setPosition(x + 3, y + 2, z);
			world.spawnEntityInWorld(mesothelae);
		}
		for (int var1 = 0; var1 <= 4; var1++) {
			GeneratorHelper.drawCircle(world, x, y - 10 - var1, z, 6, 0, 0, true);
			setBlockandMetadataIfChunkExists(world, x  + random.nextInt(8) - 4, y - 10 - var1, z + random.nextInt(8) - 4, Block.web.blockID, 0);
			setBlockandMetadataIfChunkExists(world, x  + random.nextInt(8) - 4, y - 10 - var1, z + random.nextInt(8) - 4, Block.web.blockID, 0);
			setBlockandMetadataIfChunkExists(world, x  + random.nextInt(8) - 4, y - 10 - var1, z + random.nextInt(8) - 4, Block.web.blockID, 0);
			setBlockandMetadataIfChunkExists(world, x  + random.nextInt(8) - 4, y - 10 - var1, z + random.nextInt(8) - 4, Block.web.blockID, 0);
			setBlockandMetadataIfChunkExists(world, x  + random.nextInt(8) - 4, y - 10 - var1, z + random.nextInt(8) - 4, Block.web.blockID, 0);
			setBlockandMetadataIfChunkExists(world, x  + random.nextInt(8) - 4, y - 10 - var1, z + random.nextInt(8) - 4, Block.web.blockID, 0);
			
			setBlockandMetadataIfChunkExists(world, x  + random.nextInt(10) - 5, y - 10 - var1, z + random.nextInt(10) - 5, ModBlocks.multiBlock2.blockID, 13);
			setBlockandMetadataIfChunkExists(world, x  + random.nextInt(10) - 5, y - 10 - var1, z + random.nextInt(10) - 5, ModBlocks.multiBlock2.blockID, 13);
			setBlockandMetadataIfChunkExists(world, x  + random.nextInt(10) - 5, y - 10 - var1, z + random.nextInt(10) - 5, ModBlocks.multiBlock2.blockID, 13);
			setBlockandMetadataIfChunkExists(world, x  + random.nextInt(10) - 5, y - 10 - var1, z + random.nextInt(10) - 5, ModBlocks.multiBlock2.blockID, 13);
			setBlockandMetadataIfChunkExists(world, x  + random.nextInt(10) - 5, y - 10 - var1, z + random.nextInt(10) - 5, ModBlocks.multiBlock2.blockID, 13);
		
			for (int var2 = 0; var2 <= random.nextInt(4) + 3; var2++) {
				EntityMesothelae mesothelae = new EntityMesothelae(world);
				mesothelae.setPosition(x + random.nextInt(8) - 4, y - 11, z + random.nextInt(8) - 4);
				world.spawnEntityInWorld(mesothelae);
			}
		}
		return true;
	}
	
	public boolean hasWaterNearBy(World world, int x, int y, int z) {
		for (int cx = -2; cx <= 2; cx++) {
			for (int cy = -3; cy < 2; cy++) {
				for (int cz = -2; cz <= 2; cz++) {
					int id = this.getBlockIfChunkExists(world, x + cx, y + cy, z + cz);
					if(id == Block.waterStill.blockID || id == Block.waterMoving.blockID) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public boolean blocksUnderAreSoild(World world, int x, int y, int z) {
		for (int cy = -10; cy < 0; cy++) {
			int id = this.getBlockIfChunkExists(world, x, y + cy, z);
			if(id == 0) {
				return false;
			}
		}
		return true;
	}
}
