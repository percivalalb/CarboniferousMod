package carboniferous.proxy;

import carboniferous.Carboniferous;
import carboniferous.ModBlocks;
import carboniferous.ModEntities;
import carboniferous.api.CarboniferousModAPI;
import carboniferous.api.CarboniferousSettings;
import carboniferous.handler.PlayerConnection;
import carboniferous.handler.ServerTick;
import carboniferous.network.PacketDispatcher;
import carboniferous.world.WorldProviderCarboniferous;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IThreadListener;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

/**
 * @author ProPercivalalb
 */
public class CommonProxy implements IGuiHandler {

	public PlayerConnection SERVER_TELEPORT;
	
	public void preInit(FMLPreInitializationEvent event) {
		ModBlocks.registerTileEntities();
        ModEntities.init();
        DimensionManager.registerDimension(CarboniferousSettings.DIM_ID, CarboniferousModAPI.DIMENSION_TYPE);
    }
	
	public void init(FMLInitializationEvent event) {
		ModBlocks.setBlockProperties();
		NetworkRegistry.INSTANCE.registerGuiHandler(Carboniferous.INSTANCE, Carboniferous.PROXY);
		PacketDispatcher.registerPackets();
        this.registerEventHandlers();
    }

    public void postInit(FMLPostInitializationEvent event) {

    }
    
    protected void registerEventHandlers() {
		MinecraftForge.EVENT_BUS.register(SERVER_TELEPORT = new PlayerConnection());
		MinecraftForge.EVENT_BUS.register(new ServerTick());
    }
	
	public static final int GUI_ID_DOGGY = 1;
	public static final int GUI_ID_PACKPUPPY = 2;
	public static final int GUI_ID_FOOD_BOWL = 3;
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		return null;
	}
	

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) { 
		return null;
	}
	
	public EntityPlayer getPlayerEntity(MessageContext ctx) {
		return ctx.getServerHandler().player;
	}
	
	public EntityPlayer getPlayerEntity() {
		return null;
	}
	
	public IThreadListener getThreadFromContext(MessageContext ctx) {
		return (IThreadListener)ctx.getServerHandler().player.mcServer;
	}
	
	public void spawnCrit(World world, Entity entity) {}

}
