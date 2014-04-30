package carboniferous.world.feature;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
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
	
	public void setBlockandMetadataIfChunkExists(World world, int x, int y, int z, int blockId, int metadata) {
		//if (world.getChunkProvider().chunkExists(x >> 4, z >> 4)){
			try{
				world.setBlock(x, y, z, blockId, metadata, this.doNotify ? 3 : 2);
			}catch(Exception e){
				//Work around to stop crash
			}
		//}
	}
	
	public void setBlockandMetadataIfChunkExists(World world, int x, int y, int z, int blockId, int metadata, int updateFlag) {
		//if (world.getChunkProvider().chunkExists(x >> 4, z >> 4)){
			try{
				world.setBlock(x, y, z, blockId, metadata, updateFlag);
			}catch(Exception e){
				//Work around to stop crash
			}
		//}
	}
    
    public int getBlockIfChunkExists(World world, int x, int y, int z) {
		//if (world.getChunkProvider().chunkExists(x >> 4, z >> 4)){
			try{
				return world.getBlockId(x, y, z);
			}catch(Exception e){
				//Work around to stop crash
			}
		//}
		return 0;
	}
    
    public boolean isAirBlockIfChunkExists(World world, int x, int y, int z) {
    	return this.getBlockIfChunkExists(world, x, y, z) == 0;
    }
    
    public Material getBlockMaterialIfChunkExists(World world, int x, int y, int z) {
    	int l = this.getBlockIfChunkExists(world, x, y, z);
        return l == 0 ? Material.air : Block.blocksList[l].blockMaterial;
    }
    
    public TileEntity getBlockTileEntityIfChunkExists(World world, int x, int y, int z) {
    	if (world.getChunkProvider().chunkExists(x >> 4, z >> 4)){
			try{
				return world.getBlockTileEntity(x, y, z);
			}catch(Exception e){
				//Work around to stop crash
			}
    	}
		return null;
    }
}
