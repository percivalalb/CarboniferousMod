package carboniferous;

import carboniferous.lib.Reference;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber(modid = Reference.MOD_ID)
public class CraftingRecipes {
	
	//All of the default crafting recipes now are contained in json files
	
	@SubscribeEvent
	public static void onRegister(RegistryEvent.Register<IRecipe> event) {
		
	}
}
