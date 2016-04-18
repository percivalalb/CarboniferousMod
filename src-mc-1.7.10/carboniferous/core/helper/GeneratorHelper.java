package carboniferous.core.helper;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

/**
 * @author ProPercivalalb
 */
public class GeneratorHelper {

	protected static boolean putBlock(World world, int dx, int dy, int dz, Block block, boolean priority) {
		return putBlockAndMetadata(world, dx, dy, dz, block, 0, priority);
	}

	protected static boolean putBlockAndMetadata(World world, int dx, int dy, int dz, Block block, int metaValue, boolean priority) {
	    if (priority) {
	    	setBlock(world, dx, dy, dz, block, metaValue);
	    } 
	    else {
	    	Block whatsThere = world.getBlock(dx, dy, dz);
	    	if (whatsThere == Blocks.air) {
	    		setBlock(world, dx, dy, dz, block, metaValue);
	    	}
	    	else {
	    		return false;
	    	}
	    }
	    return true;
	}

	private static void setBlock(World world, int dx, int dy, int dz, Block block, int metaValue) {
		try {
			world.setBlock(dx, dy, dz, block, metaValue, 2);
		}
		catch(Exception e) {}
	}
	
	public static void drawCircle(World world, int sx, int sy, int sz, int rad, Block block, int metaValue, boolean priority) {
	    for (byte dx = 0; dx <= rad; dx = (byte)(dx + 1)) {
	    	for (byte dz = 0; dz <= rad; dz = (byte)(dz + 1)) {
	    		int dist = Math.max(dx, dz) + (Math.min(dx, dz) >> 1);
	    		if ((dx == 3) && (dz == 3)) {
	    			dist = 6;
	    		}
	    		if (dist <= rad) {
	    			putBlockAndMetadata(world, sx + dx, sy, sz + dz, block, metaValue, priority);
	    			putBlockAndMetadata(world, sx + dx, sy, sz - dz, block, metaValue, priority);
	    			putBlockAndMetadata(world, sx - dx, sy, sz + dz, block, metaValue, priority);
	    			putBlockAndMetadata(world, sx - dx, sy, sz - dz, block, metaValue, priority);
	    		}
	    	}
	    }
	}

	public static void drawDiameterCircle(World world, int sx, int sy, int sz, int diam, Block block, int meta, boolean priority) {
	    byte rad = (byte)((diam - 1) / 2);

	    if (diam % 2 == 1) {
	    	drawCircle(world, sx, sy, sz, rad, block, meta, priority);
	    }
	    else {
	    	drawCircle(world, sx, sy, sz, rad, block, meta, priority);
	    	drawCircle(world, sx + 1, sy, sz, rad, block, meta, priority);
	    	drawCircle(world, sx, sy, sz + 1, rad, block, meta, priority);
	    	drawCircle(world, sx + 1, sy, sz + 1, rad, block, meta, priority);
	    }
	}
	
	public static void fill(World world, int dx, int dy, int dz, int width, int height, int depth, Block block, int meta) {
		for (int cx = 0; cx < width; cx++) {
			for (int cy = 0; cy < height; cy++) {
				for (int cz = 0; cz < depth; cz++) {
					setBlock(world, dx + cx, dy + cy, dz + cz, block, meta);
				}
			}
	    }
	}
}
