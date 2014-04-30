package carboniferous.core.helper;

import net.minecraft.world.World;

/**
 * @author ProPercivalalb
 */
public class GeneratorHelper {

	protected static boolean putBlock(World world, int dx, int dy, int dz, int blockValue, boolean priority) {
		return putBlockAndMetadata(world, dx, dy, dz, blockValue, 0, priority);
	}

	protected static boolean putBlockAndMetadata(World world, int dx, int dy, int dz, int blockValue, int metaValue, boolean priority) {
	    if (priority) {
	    	setBlock(world, dx, dy, dz, blockValue, metaValue);
	    } 
	    else {
	    	int whatsThere = world.getBlockId(dx, dy, dz);
	    	if (whatsThere == 0) {
	    		setBlock(world, dx, dy, dz, blockValue, metaValue);
	    	}
	    	else {
	    		return false;
	    	}
	    }
	    return true;
	}

	private static void setBlock(World world, int dx, int dy, int dz, int blockValue, int metaValue) {
		try {
			world.setBlock(dx, dy, dz, blockValue, metaValue, 2);
		}
		catch(Exception e) {}
	}
	
	public static void drawCircle(World world, int sx, int sy, int sz, int rad, int blockValue, int metaValue, boolean priority) {
	    for (byte dx = 0; dx <= rad; dx = (byte)(dx + 1)) {
	    	for (byte dz = 0; dz <= rad; dz = (byte)(dz + 1)) {
	    		int dist = Math.max(dx, dz) + (Math.min(dx, dz) >> 1);
	    		if ((dx == 3) && (dz == 3)) {
	    			dist = 6;
	    		}
	    		if (dist <= rad) {
	    			putBlockAndMetadata(world, sx + dx, sy, sz + dz, blockValue, metaValue, priority);
	    			putBlockAndMetadata(world, sx + dx, sy, sz - dz, blockValue, metaValue, priority);
	    			putBlockAndMetadata(world, sx - dx, sy, sz + dz, blockValue, metaValue, priority);
	    			putBlockAndMetadata(world, sx - dx, sy, sz - dz, blockValue, metaValue, priority);
	    		}
	    	}
	    }
	}

	public static void drawDiameterCircle(World world, int sx, int sy, int sz, int diam, int block, int meta, boolean priority) {
	    byte rad = (byte)((diam - 1) / 2);

	    if (diam % 2 == 1) {
	    	drawCircle(world, sx, sy, sz, rad, (byte)block, meta, priority);
	    }
	    else {
	    	drawCircle(world, sx, sy, sz, rad, (byte)block, meta, priority);
	    	drawCircle(world, sx + 1, sy, sz, rad, (byte)block, meta, priority);
	    	drawCircle(world, sx, sy, sz + 1, rad, (byte)block, meta, priority);
	    	drawCircle(world, sx + 1, sy, sz + 1, rad, (byte)block, meta, priority);
	    }
	}
	
	public static void fill(World world, int dx, int dy, int dz, int width, int height, int depth, int blockID, int meta) {
		for (int cx = 0; cx < width; cx++) {
			for (int cy = 0; cy < height; cy++) {
				for (int cz = 0; cz < depth; cz++) {
					setBlock(world, dx + cx, dy + cy, dz + cz, blockID, meta);
				}
			}
	    }
	}
}
