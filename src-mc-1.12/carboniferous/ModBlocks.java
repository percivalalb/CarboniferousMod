package carboniferous;

import carboniferous.lib.Reference;
import carboniferous.client.model.ModelHelper;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @author ProPercivalalb
 */
@EventBusSubscriber(modid = Reference.MOD_ID)
public class ModBlocks {

	//public static Block DOG_BED;

	@SubscribeEvent
	public static void onRegisterBlock(RegistryEvent.Register<Block> event) {
		//DOG_BED = new BlockDogBed().setUnlocalizedName("carboniferous.dogbed").setRegistryName(Reference.MOD_ID + ":dog_bed");

		//GameRegistry.registerTileEntity(TileEntityDogBed.class, "doggytalents:dog_bed");
		
		//DOG_BED.setHarvestLevel("axe", 0);
		
		//event.getRegistry().register(ModBlocks.DOG_BED);
	}
	
	@SubscribeEvent
	public static void onRegisterItem(RegistryEvent.Register<Item> event) {
		//event.getRegistry().register(new ItemDogBed(DOG_BED).setRegistryName(DOG_BED.getRegistryName()));
	}
	
	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public static void setItemModels(ModelRegistryEvent event) {
		//ModelHelper.setModel(ModBlocks.DOG_BATH, 0, "doggytalents:dog_bath");
	}
	
	private static ItemBlock makeItemBlock(Block block) {
        return (ItemBlock)new ItemBlock(block).setRegistryName(block.getRegistryName());
    }
}
