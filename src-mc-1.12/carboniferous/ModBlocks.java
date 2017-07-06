package carboniferous;

import carboniferous.lib.Reference;
import carboniferous.block.BlockCarboniferousDirt;
import carboniferous.block.BlockCarboniferousGrass;
import carboniferous.block.BlockCarboniferousLeaves;
import carboniferous.block.BlockCarboniferousLog;
import carboniferous.block.BlockCarboniferousPlanks;
import carboniferous.block.BlockCarboniferousPortal;
import carboniferous.block.BlockCarboniferousSapling;
import carboniferous.block.EnumWood;
import carboniferous.block.ItemCarboniferousLeaves;
import carboniferous.block.ItemCarboniferousLog;
import carboniferous.block.ItemCarboniferousPlanks;
import carboniferous.block.ItemCarboniferousSapling;
import carboniferous.client.model.ModelHelper;
import net.minecraft.client.renderer.block.statemap.StateMap.Builder;
import net.minecraft.init.Blocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemMultiTexture;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @author ProPercivalalb
 */
@EventBusSubscriber(modid = Reference.MOD_ID)
@ObjectHolder(Reference.MOD_ID)
public class ModBlocks {

	public static final BlockCarboniferousLog LOG_0 = null;
	public static final BlockCarboniferousPlanks PLANKS_0 = null;
	public static final BlockCarboniferousLeaves LEAVES_0 = null;
	public static final BlockCarboniferousSapling SAPLING_0 = null;
	public static final BlockCarboniferousGrass GRASS = null;
	public static final BlockCarboniferousDirt DIRT = null;
	public static final BlockCarboniferousPortal PORTAL = null;
	
	@SubscribeEvent
	public static void onRegisterBlock(RegistryEvent.Register<Block> event) {

		
		event.getRegistry().registerAll(
				new BlockCarboniferousLog().setUnlocalizedName("carboniferous.log_0").setRegistryName(Reference.MOD_ID + ":log_0"),
				new BlockCarboniferousPlanks().setUnlocalizedName("carboniferous.planks_0").setRegistryName(Reference.MOD_ID + ":planks_0"),
				new BlockCarboniferousLeaves().setUnlocalizedName("carboniferous.leaves_0").setRegistryName(Reference.MOD_ID + ":leaves_0"),
				new BlockCarboniferousSapling().setUnlocalizedName("carboniferous.sapling_0").setRegistryName(Reference.MOD_ID + ":sapling_0"),
				new BlockCarboniferousGrass().setUnlocalizedName("carboniferous.grass").setRegistryName(Reference.MOD_ID + ":grass"),
				new BlockCarboniferousDirt().setUnlocalizedName("carboniferous.dirt").setRegistryName(Reference.MOD_ID + ":dirt"),
				new BlockCarboniferousPortal().setUnlocalizedName("carboniferous.portal").setRegistryName(Reference.MOD_ID + ":portal"));
		
		//GameRegistry.registerTileEntity(TileEntityDogBed.class, "doggytalents:dog_bed");
	}
	
	public static void setBlockProperties() {
		
		LOG_0.setHarvestLevel("axe", 0);
		PLANKS_0.setHarvestLevel("axe", 0);
		GRASS.setHarvestLevel("shovel", 0);
		DIRT.setHarvestLevel("shovel", 0);
		
		Blocks.FIRE.setFireInfo(LOG_0, 5, 5);
		Blocks.FIRE.setFireInfo(PLANKS_0, 5, 20);
		Blocks.FIRE.setFireInfo(LEAVES_0, 30, 60);
	}
	
	public static void registerTileEntities() {
		//GameRegistry.registerTileEntity(TileEntityDogBed.class, "doggytalents:dog_bed");
	}
	
	@SubscribeEvent
	public static void onRegisterItem(RegistryEvent.Register<Item> event) {
		event.getRegistry().register(new ItemCarboniferousLog(LOG_0).setRegistryName(LOG_0.getRegistryName()));
		event.getRegistry().register(new ItemCarboniferousPlanks(PLANKS_0).setRegistryName(PLANKS_0.getRegistryName()));
		event.getRegistry().register(new ItemCarboniferousLeaves(LEAVES_0).setRegistryName(LEAVES_0.getRegistryName()));
		event.getRegistry().register(new ItemCarboniferousSapling(SAPLING_0).setRegistryName(SAPLING_0.getRegistryName()));
		event.getRegistry().register(makeItemBlock(GRASS));
		event.getRegistry().register(makeItemBlock(DIRT));
		event.getRegistry().register(makeItemBlock(PORTAL));
	}
	
	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public static void setItemModels(ModelRegistryEvent event) {		
        ModelLoader.setCustomStateMapper(LEAVES_0, new Builder().ignore(BlockCarboniferousLeaves.CHECK_DECAY, BlockCarboniferousLeaves.DECAYABLE).build());
        ModelLoader.setCustomStateMapper(SAPLING_0, new Builder().ignore(BlockCarboniferousSapling.STAGE).build());
    	
        
        for(EnumWood type : EnumWood.values()) {
        	ModelHelper.setModel(LOG_0, type.getMetadata(), Reference.MOD_ID + ":" + type.getName() + "_log");
        	ModelHelper.setModel(PLANKS_0, type.getMetadata(), Reference.MOD_ID + ":" + type.getName() + "_planks");
    	    ModelHelper.setModel(LEAVES_0, type.getMetadata(), Reference.MOD_ID + ":" + type.getName() + "_leaves");
    	    ModelHelper.setModel(SAPLING_0, type.getMetadata(), Reference.MOD_ID + ":" + type.getName() + "_sapling");
        }
        
        ModelHelper.setModel(GRASS, 0, Reference.MOD_ID + ":grass");
        ModelHelper.setModel(DIRT, 0, Reference.MOD_ID + ":dirt");
        ModelHelper.setModel(PORTAL, 0, Reference.MOD_ID + ":portal");
	}
	
	private static ItemBlock makeItemBlock(Block block) {
        return (ItemBlock)new ItemBlock(block).setRegistryName(block.getRegistryName());
    }
}
