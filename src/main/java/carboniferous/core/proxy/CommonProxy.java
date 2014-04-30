package carboniferous.core.proxy;

import java.util.List;

import carboniferous.api.Properties;
import carboniferous.client.gui.inventory.GuiGrinder;
import carboniferous.inventory.ContainerGrinder;
import carboniferous.tileentity.TileEntityGrinder;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;

/**
 * @author ProPercivalalb
 **/
public class CommonProxy implements IGuiHandler {

	public void onModPre() {}
	
	public void onModLoad() {}
	
	public void onModPost() {}
	
	public void registerTickHandlers() {
		//TODO TickRegistry.registerTickHandler(new ServerTickHandler(), Side.SERVER);
	}
	
	//Client Only
	public void registerSoundHandler() {}
	
	public void registerPlugins() {}
	
	public void handleTileEntityPacket(int x, int y, int z, ForgeDirection direction, String owner, String customName, String state) {}
	public void handleWallShellPacket(int x, int y, int z, int id, int metadata) {}
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tileentity = world.getTileEntity(x, y, z);
		if(ID == Properties.GUI_ID_GRINDER) {
			if(tileentity instanceof TileEntityGrinder) {
				return new ContainerGrinder(player.inventory, (TileEntityGrinder)tileentity);
			}
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tileentity = world.getTileEntity(x, y, z);
		if(ID == Properties.GUI_ID_GRINDER) {
			if(tileentity instanceof TileEntityGrinder) {
				return new GuiGrinder(player.inventory, (TileEntityGrinder)tileentity);
			}
		}
		return null;
	}
	
	public int armorRender(String str) {return 0;}

	public EntityPlayer getClientPlayer() {
		return null;
	}
}
