package carboniferous.core.proxy;

import carboniferous.ModBlocks;
import carboniferous.api.Properties;
import carboniferous.client.audio.SoundHandler;
import carboniferous.client.model.ModelAmmonite;
import carboniferous.client.model.ModelBrachiopod;
import carboniferous.client.model.ModelCrab;
import carboniferous.client.model.ModelCrassigyrinus;
import carboniferous.client.model.ModelDendrerpeton;
import carboniferous.client.model.ModelDimetrodon;
import carboniferous.client.model.ModelDragonfly;
import carboniferous.client.model.ModelFlippers;
import carboniferous.client.model.ModelGiantMeganeura;
import carboniferous.client.model.ModelMesothelae;
import carboniferous.client.model.ModelOrthacanthus;
import carboniferous.client.model.ModelTrilobite;
import carboniferous.client.renderer.block.BlockAntHillRenderer;
import carboniferous.client.renderer.block.BlockGrinderRenderer;
import carboniferous.client.renderer.block.BlockWaterPlantRenderer;
import carboniferous.client.renderer.entity.RenderGiantSnail;
import carboniferous.client.renderer.entity.RenderMob;
import carboniferous.client.renderer.item.ItemCompressorRenderer;
import carboniferous.client.renderer.item.ItemGiantFernRender;
import carboniferous.client.renderer.item.ItemGrinderRenderer;
import carboniferous.client.renderer.tileentity.TileEntityCompressorRender;
import carboniferous.client.renderer.tileentity.TileEntityGiantFernRender;
import carboniferous.client.renderer.tileentity.TileEntityGrinderRender;
import carboniferous.client.renderer.tileentity.TileEntityWallShellRender;
import carboniferous.core.addons.Api;
import carboniferous.core.addons.optifine.OptifinePlugin;
import carboniferous.core.handlers.ClientTickHandler;
import carboniferous.entity.EntityAmmonite;
import carboniferous.entity.EntityBrachiopod;
import carboniferous.entity.EntityCrab;
import carboniferous.entity.EntityCrassigyrinus;
import carboniferous.entity.EntityDendrerpeton;
import carboniferous.entity.EntityDimetrodon;
import carboniferous.entity.EntityDragonfly;
import carboniferous.entity.EntityGiantMeganeura;
import carboniferous.entity.EntityGiantSnail;
import carboniferous.entity.EntityMesothelae;
import carboniferous.entity.EntityOrthacanthus;
import carboniferous.entity.EntityTrilobite;
import carboniferous.lib.ResourceReference;
import carboniferous.tileentity.TileEntityCompressor;
import carboniferous.tileentity.TileEntityGiantFern;
import carboniferous.tileentity.TileEntityGrinder;
import carboniferous.tileentity.TileEntityWallShell;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

/**
 * @author ProPercivalalb
 **/
public class ClientProxy extends CommonProxy {

	@SideOnly(Side.CLIENT)
	public static ModelFlippers flippers = new ModelFlippers();
	Minecraft mc = Minecraft.getMinecraft();
	
	@Override
	public void onModPre() {
		Properties.RENDER_WATER_PLANT = RenderingRegistry.getNextAvailableRenderId();
		Properties.RENDER_ANT_HILL = RenderingRegistry.getNextAvailableRenderId();
		Properties.RENDER_GRINDER = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(new BlockWaterPlantRenderer());
		RenderingRegistry.registerBlockHandler(new BlockAntHillRenderer());
		RenderingRegistry.registerBlockHandler(new BlockGrinderRenderer());
		RenderingRegistry.registerEntityRenderingHandler(EntityDragonfly.class, new RenderMob(new ModelDragonfly(), 0.5F, ResourceReference.mobDragonfly));
		RenderingRegistry.registerEntityRenderingHandler(EntityBrachiopod.class, new RenderMob(new ModelBrachiopod(), 0.4F, ResourceReference.mobBrachiopod));
		RenderingRegistry.registerEntityRenderingHandler(EntityAmmonite.class, new RenderMob(new ModelAmmonite(), 0.4F, 2.0F, ResourceReference.mobAmmonite));
		RenderingRegistry.registerEntityRenderingHandler(EntityDendrerpeton.class, new RenderMob(new ModelDendrerpeton(), 0.5F, ResourceReference.mobDendrerpeton));
		RenderingRegistry.registerEntityRenderingHandler(EntityMesothelae.class, new RenderMob(new ModelMesothelae(), 0.5F, ResourceReference.mobMesothelae));
		RenderingRegistry.registerEntityRenderingHandler(EntityOrthacanthus.class, new RenderMob(new ModelOrthacanthus(), 0.5F, 1.5F, ResourceReference.mobOrthacanthus));
		RenderingRegistry.registerEntityRenderingHandler(EntityCrassigyrinus.class, new RenderMob(new ModelCrassigyrinus(), 0.7F, ResourceReference.mobCrassigyrinus));
		RenderingRegistry.registerEntityRenderingHandler(EntityCrab.class, new RenderMob(new ModelCrab(), 0.3F, ResourceReference.mobCrab));
		RenderingRegistry.registerEntityRenderingHandler(EntityDimetrodon.class, new RenderMob(new ModelDimetrodon(), 0.3F, 1.4F, ResourceReference.mobDimetrodon));
		RenderingRegistry.registerEntityRenderingHandler(EntityTrilobite.class, new RenderMob(new ModelTrilobite(), 0.4F, ResourceReference.mobTrilobite));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityGiantSnail.class, new RenderGiantSnail());
		//Boss-Like creatures
		RenderingRegistry.registerEntityRenderingHandler(EntityGiantMeganeura.class, new RenderMob(new ModelGiantMeganeura(), 0.7F, ResourceReference.mobGiantMeganeura));
		//Entitys
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWallShell.class, new TileEntityWallShellRender());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGrinder.class, new TileEntityGrinderRender());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCompressor.class, new TileEntityCompressorRender());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGiantFern.class, new TileEntityGiantFernRender());
		
		FMLCommonHandler.instance().bus().register(new ClientTickHandler());
	}
	
	@Override
	public void onModLoad() {
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.grinder), new ItemGrinderRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.compressor), new ItemCompressorRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.giantFern), new ItemGiantFernRender());
	}
	
	@Override
	public void onModPost() {}
	
	@Override
	public void registerTickHandlers() {
		super.registerTickHandlers();
		//TODO TickRegistry.registerTickHandler(new ClientTickHandler(), Side.CLIENT);
	}
	
	@Override
	public void registerPlugins() {
		Api.registerPlugin(new OptifinePlugin());
	}
	
	public void registerSoundHandler() {
		MinecraftForge.EVENT_BUS.register(new SoundHandler());
	}

	@Override
	public int armorRender(String str) {
		return RenderingRegistry.addNewArmourRendererPrefix(str);
	}
	
	@Override
	public EntityPlayer getClientPlayer() {
		return FMLClientHandler.instance().getClientPlayerEntity();
	}
	
	@Override
	public EntityPlayer getPlayerEntity(MessageContext ctx) {
		return (ctx.side.isClient() ? Minecraft.getMinecraft().thePlayer : super.getPlayerEntity(ctx));
	}
}
