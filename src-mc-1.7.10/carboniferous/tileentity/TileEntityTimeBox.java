package carboniferous.tileentity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class TileEntityTimeBox extends TileEntity {

	public TileEntityTimeBox() {
		
	}
	
	@Override
	public void updateEntity() {
		if(MinecraftServer.getServer().getTickCounter() % 200 == 0) {
			
		}
	}
	
	@SideOnly(Side.CLIENT)
    public AxisAlignedBB getRenderBoundingBox() {
        AxisAlignedBB bb = INFINITE_EXTENT_AABB;
        return bb;
    }
}
