package carboniferous;

import carboniferous.client.model.ModelHelper;
import carboniferous.item.ItemCarboniferous;
import carboniferous.lib.Reference;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @author ProPercivalalb
 */
@EventBusSubscriber(modid = Reference.MOD_ID)
public class ModItems {

	//public static Item THROW_BONE;
	
	@SubscribeEvent
	public static void onRegister(RegistryEvent.Register<Item> event) {
		//THROW_BONE = new ItemThrowBone().setUnlocalizedName("doggytalents.throwbone").setRegistryName(Reference.MOD_ID + ":throw_bone");
		
		//event.getRegistry().register(ModItems.THROW_BONE);
	}
	
	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public static void setItemModels(ModelRegistryEvent event) {
		//ModelHelper.setModel(ModItems.THROW_BONE, 0, "doggytalents:throw_bone");
	}
}
