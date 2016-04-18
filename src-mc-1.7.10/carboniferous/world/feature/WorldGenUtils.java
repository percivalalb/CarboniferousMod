package carboniferous.world.feature;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * @author ProPercivalalb
 */
public class WorldGenUtils {

    
    public static void setBlock(World world, int x, int y, int z, Block blockId, int meta, int flag) {
		try{
			world.setBlock(x, y, z, blockId, meta, flag);
		}
		catch(Exception e) {}
	}
    
    public static Block getBlock(World world, int x, int y, int z) {
    	try {
			return world.getBlock(x, y, z);
		} 
		catch(Exception e) {}
		return Blocks.air;
	}
    
    public static boolean isAirBlock(World world, int x, int y, int z) {
    	return getBlock(world, x, y, z) == Blocks.air;
    }
    
    public static Material getBlockMaterial(World world, int x, int y, int z) {
    	Block block = getBlock(world, x, y, z);
        return block.getMaterial();
    }
    
    public static TileEntity getTileEntity(World world, int x, int y, int z) {
		try{
			return world.getTileEntity(x, y, z);
		}
		catch(Exception e) {}
		return null;
    }
}
