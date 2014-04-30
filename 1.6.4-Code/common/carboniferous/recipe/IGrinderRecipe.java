package carboniferous.recipe;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * @author Properties
 * Inspired by .... #IRecipe
 */
public interface IGrinderRecipe {

    /**
     * Used to check if a recipe matches current crafting inventory
     */
    boolean matches(ItemStack leftStack, ItemStack rightStack, World world);

    /**
     * Returns an Item that is the result of this recipe
     */
    ItemStack getCraftingResult(ItemStack leftStack, ItemStack rightStack);

    ItemStack getRecipeOutput();
    
    Object[] getRecipeInput();
}
