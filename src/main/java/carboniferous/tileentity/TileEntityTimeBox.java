package carboniferous.tileentity;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

import carboniferous.api.Properties;

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
