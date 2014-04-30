package carboniferous.recipe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

public class GrinderRecipe implements IGrinderRecipe {

    private ItemStack output = null;
    private Object[] input = null;
	
    public GrinderRecipe(ItemStack result, Object... recipe) {
        output = result.copy();

        if(recipe.length > 2 || recipe.length < 0) {
        	throw new RuntimeException("A Grinder Recipe has been registered wrongy.");
        }
        
        int idx = 0;
        List<Object> itemMap = new ArrayList<Object>();

        for (; idx < recipe.length; idx++) {
            Object in = recipe[idx];
            int nulls = 0;
            if(in == null) {
            	itemMap.add(null);
            	nulls++;
            }
            else if (in instanceof ItemStack) {
                itemMap.add(((ItemStack)in).copy());
            }
            else if (in instanceof Item) {
                itemMap.add(new ItemStack((Item)in));
            }
            else if (in instanceof Block) {
                itemMap.add(new ItemStack((Block)in));
            }
            else if (in instanceof String) {
                itemMap.add(OreDictionary.getOres((String)in));
            }
            else {
                throw new RuntimeException("Invalid grinder recipe was created!");
            }
            
            if(nulls > 1) {
            	throw new RuntimeException("There where too many nulls in a Grinder Recipe.");
            }
        }

        input = new Object[recipe.length];
        int x = 0;
        for (; x < itemMap.size(); x++) {
            input[x] = itemMap.get(x);
        }
    }
    
	@Override
	public boolean matches(ItemStack leftStack, ItemStack rightStack, World world) {
		return this.checkMatch(new ItemStack[] {leftStack, rightStack});
	}

	@Override
	public ItemStack getCraftingResult(ItemStack leftStack, ItemStack rightStack) {
		return output.copy(); 
	}

	@Override
    public ItemStack getRecipeOutput() { 
		return output;
	}
	
	public Object[] getRecipeInput() {
		return input;
	}

	private boolean checkMatch(ItemStack[] inputStacks) {
		if(inputStacks[0] == null && inputStacks[1] == null) return false;
		else if(inputStacks[0] != null && inputStacks[1] == null && input[0] != null && input[1] == null) { //Only left slot has item
			return checkObject(input[0], inputStacks[0]);
		}
		else if(inputStacks[0] == null && inputStacks[1] != null && input[0] == null && input[1] != null) { //Only right slot has item
			return checkObject(input[1], inputStacks[1]);
		}
		else if(inputStacks[0] == null && inputStacks[1] != null && input[0] != null && input[1] == null) { //Only left slot has item
			return checkObject(input[0], inputStacks[1]);
		}
		else if(inputStacks[0] != null && inputStacks[1] == null && input[0] == null && input[1] != null) { //Only right slot has item
			return checkObject(input[1], inputStacks[0]);
		}
		else if(inputStacks[0] != null && inputStacks[1] != null && input[0] != null && input[1] != null) { //Both slots have items
			boolean flag1 = checkObject(input[0], inputStacks[0]) && checkObject(input[1], inputStacks[1]); 
			boolean flag2 = checkObject(input[0], inputStacks[1]) && checkObject(input[1], inputStacks[0]);
			return flag1 || flag2;
		}
		return false;
    }
	
	public boolean checkObject(Object target, ItemStack stack) {
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

    private boolean checkItemEquals(ItemStack target, ItemStack input) {
        if (input == null && target == null || input == null && target != null || input != null && target == null) {
            return false;
        }
        return isSameItem(target, input) && isSameDamage(target, input) && isSameNBT(target, input);
    }
    
    //Private functions to check for certain aspects of the Item
    private boolean isSameItem(ItemStack target, ItemStack input) {
    	return target.getItem() == input.getItem();
    }
    private boolean isSameDamage(ItemStack target, ItemStack input) {
    	return target.getItemDamage() == OreDictionary.WILDCARD_VALUE || target.getItemDamage() == input.getItemDamage();
    }
    private boolean isSameNBT(ItemStack target, ItemStack input) {
    	if(!target.hasTagCompound()) return true; //Checks whether cached recipe doesn't have #NBTTagCompound, (returns true).
    	if(!input.hasTagCompound()) return false; //If cached recipe has #NBTTagCompound and and input donsn't #NBTTagCompound, (returns false).
    	return target.getTagCompound().equals(input.getTagCompound());
    }
}
