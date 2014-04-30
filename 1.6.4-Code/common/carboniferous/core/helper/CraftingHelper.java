package carboniferous.core.helper;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;

/**
 * @author ProPercivalalb
 */
public class CraftingHelper {

	public static void addShapedRecipe(Object item, Object[] ingredientArray) {
		ItemStack result = ItemStackHelper.convertObjectToItemStack(item);
		GameRegistry.addRecipe(result, ingredientArray);	
	}
	
	public static void addShapelessRecipe(Object item, Object[] ingredientArray) {
		ItemStack result = ItemStackHelper.convertObjectToItemStack(item);
		GameRegistry.addShapelessRecipe(result, ingredientArray);
	}
	
	public static void addRecipe(IRecipe irecipe) {
		GameRegistry.addRecipe(irecipe);	
	}
	
	public static void addEnchantedRecipe(Object item, Enchantment enchantment, int enchantmentLevel, Object[] ingredientArray) {
	    ItemStack result = ItemStackHelper.convertObjectToItemStack(item);
	    if (enchantment != null) {
	    	ItemStackHelper.addEnchantment(result, enchantment, enchantmentLevel);
	    }

	    GameRegistry.addRecipe(result, ingredientArray);	
	}
}
