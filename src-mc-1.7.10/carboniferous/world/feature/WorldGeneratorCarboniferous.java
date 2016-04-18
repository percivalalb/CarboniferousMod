package carboniferous.world.feature;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public abstract class WorldGeneratorCarboniferous extends WorldGenerator {

	private boolean doNotify;
	
	public WorldGeneratorCarboniferous() {}
	
	public WorldGeneratorCarboniferous(boolean par1) {
		super(par1);
		this.doNotify = par1;
	}
	
	public void setBlockandMetadataIfChunkExists(World world, int x, int y, int z, Block blockId, int metadata) {
		//if (world.getChunkProvider().chunkExists(x >> 4, z >> 4)){
			try{
				world.setBlock(x, y, z, blockId, metadata, this.doNotify ? 3 : 2);
			}catch(Exception e){
				//Work around to stop crash
			}
		//}
	}
	
	public void setBlockandMetadataIfChunkExists(World world, int x, int y, int z, Block blockId, int metadata, int updateFlag) {
		//if (world.getChunkProvider().chunkExists(x >> 4, z >> 4)){
			try{
				world.setBlock(x, y, z, blockId, metadata, updateFlag);
			}catch(Exception e){
				//Work around to stop crash
			}
		//}
	}
    
    public Block getBlockIfChunkExists(World world, int x, int y, int z) {
		//if (world.getChunkProvider().chunkExists(x >> 4, z >> 4)){
			try{
				return world.getBlock(x, y, z);
			}catch(Exception e){
				//Work around to stop crash
			}
		//}
		return Blocks.air;
	}
    
    public boolean isAirBlockIfChunkExists(World world, int x, int y, int z) {
    	return this.getBlockIfChunkExists(world, x, y, z) == Blocks.air;
    }
    
    public Material getBlockMaterialIfChunkExists(World world, int x, int y, int z) {
    	Block block = this.getBlockIfChunkExists(world, x, y, z);
        return block.getMaterial();
    }
    
    public TileEntity getTileEntityIfChunkExists(World world, int x, int y, int z) {
    	if (world.getChunkProvider().chunkExists(x >> 4, z >> 4)){
			try{
				return world.getTileEntity(x, y, z);
			}catch(Exception e){
				//Work around to stop crash
			}
    	}
		return null;
    }
}
