package carboniferous.recipe;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

public class GrinderManager {
   
    /** A list of all the recipes added */
    private static List recipes = new ArrayList();

    private GrinderManager() {
    
    }

    public static void addGrinderRecipe(ItemStack par1ItemStack, Object... par2ArrayOfObj) {
    	recipes.add(new GrinderRecipe(par1ItemStack, par2ArrayOfObj));
    }
    
    public static boolean isGrindableItem(ItemStack stack) {
    	for (int j = 0; j < recipes.size(); ++j) {
            IGrinderRecipe irecipe = (IGrinderRecipe)recipes.get(j);
            if(irecipe.getRecipeInput() != null) {
            	for(Object obj : irecipe.getRecipeInput()) {
            		if(checkObject(obj, stack)) {
            			return true;
            		}
            	}
            }
        }
    	return false;
    }

    public static ItemStack findMatchingRecipe(ItemStack leftStack, ItemStack rightStack, World par2World){
    	for (int j = 0; j < recipes.size(); ++j) {
            IGrinderRecipe irecipe = (IGrinderRecipe)recipes.get(j);

            if (irecipe.matches(leftStack, rightStack, par2World)) {
                return irecipe.getCraftingResult(leftStack, rightStack);
            }
        }
        return null;
    }
    
    public static boolean checkObject(Object target, ItemStack stack) {
		if (target instanceof ItemStack) {
            if (!checkItemEquals((ItemStack)target, stack)) {
                return false;
            }
        }
        else if (target instanceof ArrayList) {
        	boolean matched = false;

            for (ItemStack item : (ArrayList<ItemStack>)target) {
            	matched = matched || checkItemEquals(item, stack);
            }

            if (!matched) {
            	return false;
            }
        }
		return true;
	}
    
    private static boolean checkItemEquals(ItemStack target, ItemStack input) {
        if (input == null && target == null || input == null && target != null || input != null && target == null) {
            return false;
        }
        return isSameItem(target, input) && isSameDamage(target, input) && isSameNBT(target, input);
    }
    
    //Private functions to check for certain aspects of the Item
    private static boolean isSameItem(ItemStack target, ItemStack input) {
    	return target.getItem() == input.getItem();
    }
    private static boolean isSameDamage(ItemStack target, ItemStack input) {
    	return target.getItemDamage() == OreDictionary.WILDCARD_VALUE || target.getItemDamage() == input.getItemDamage();
    }
    private static boolean isSameNBT(ItemStack target, ItemStack input) {
    	if(!target.hasTagCompound()) return true; //Checks whether cached recipe doesn't have #NBTTagCompound, (returns true).
    	if(!input.hasTagCompound()) return false; //If cached recipe has #NBTTagCompound and and input donsn't #NBTTagCompound, (returns false).
    	return target.getTagCompound().equals(input.getTagCompound());
    }

    public static List getRecipeList() {
        return recipes;
    }
}
