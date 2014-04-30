package carboniferous.core.addons.ee3;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.world.biome.BiomeGenBase;

import com.google.common.base.Optional;

import cpw.mods.fml.relauncher.ReflectionHelper;

public class EE3Api {

	protected Optional<List<ItemStack>> transmutationStones = Optional.absent();
	private Optional<Method> addTransmutationRecipe = Optional.absent();
	private Optional<Field> transmutationRecipes = Optional.absent();
	private Optional<Method> convertObjectToItemStack = Optional.absent();
	private Optional<Method> getMetaCycle = Optional.absent();
	private ArrayList<ArrayList<ItemStack>> equivalencyList = new ArrayList<ArrayList<ItemStack>>();
	
	protected EE3Api() {
		Class cls;
		Method mth;
		Field fld;
		try {
			cls = Class.forName("com.pahimar.ee3.recipe.RecipesTransmutationStone");
			transmutationStones = Optional.fromNullable((List<ItemStack>)cls.getField("transmutationStones").get(null));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		try {
			cls = Class.forName("com.pahimar.ee3.core.helper.RecipeHelper");
			addTransmutationRecipe = Optional.fromNullable(cls.getMethod("addRecipe", ItemStack.class, ItemStack.class, Object[].class));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		try {
			cls = Class.forName("com.pahimar.ee3.core.helper.RecipeHelper");
			getMetaCycle = Optional.fromNullable(cls.getMethod("getMetaCycle", Object.class, Integer.TYPE));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		try {
			cls = Class.forName("com.pahimar.ee3.core.handlers.EquivalencyHandler");
			fld = cls.getDeclaredField("equivalencyList");
			fld.setAccessible(true);
			transmutationRecipes = Optional.fromNullable(fld);
			this.equivalencyList = (ArrayList<ArrayList<ItemStack>>)fld.get(null);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		try {
			cls = Class.forName("com.pahimar.ee3.core.helper.GeneralHelper");
			convertObjectToItemStack = Optional.fromNullable(cls.getMethod("convertObjectToItemStack", Object.class));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	protected Object[] getMetaCycle(Object input, int n) {
		try {
			if(getMetaCycle.isPresent()) {
				return (Object[])getMetaCycle.get().invoke(Object[].class, input, n);
			}
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	protected void addWorldTransmutationRecipe(Object... objList) {
		try {
			if(transmutationRecipes.isPresent()) {
				addObjects(objList);
			}
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void addTransmutationRecipe(ItemStack output, Object... input) {
		try {
			if(addTransmutationRecipe.isPresent() && transmutationStones.isPresent()) {
				for (ItemStack stone : transmutationStones.get()) {
					addTransmutationRecipe.get().invoke(null, output, stone, input);
				}
			}
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void addObjects(Object obj1, Object obj2) {
		try {
			ItemStack stack1 = (ItemStack)convertObjectToItemStack.get().invoke(ItemStack.class, obj1);
			ItemStack stack2 = (ItemStack)convertObjectToItemStack.get().invoke(ItemStack.class, obj2);
			ArrayList<ItemStack> currentList = new ArrayList<ItemStack>();
			Integer stack1Index = getIndexInList(stack1);
			Integer stack2Index = getIndexInList(stack2);
			if (stack1Index != null && stack2Index != null)
				return;
			else if (stack1Index != null && stack2Index == null) {
       			currentList = equivalencyList.get(stack1Index.intValue());
       			currentList.add(stack2);
       			equivalencyList.set(stack1Index.intValue(), currentList);
			}
	        else if (stack1Index == null && stack2Index != null) {
	            currentList = equivalencyList.get(stack2Index.intValue());
	            currentList.add(stack1);
	            equivalencyList.set(stack2Index.intValue(), currentList);
	        }
	        else if (stack1Index == null && stack2Index == null) {
	        	currentList.add(stack1);
	        	currentList.add(stack2);
	        	equivalencyList.add(currentList);
	        }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
    }

    private void addObjects(Object... objList) {
        if (objList.length < 2) return;
        for (int i = 0; i < objList.length - 1; i++) {
            addObjects(objList[i], objList[i + 1]);
        }
    }
    
    private Integer getIndexInList(Object obj) {
    	try {
    		ItemStack checkStack = (ItemStack)convertObjectToItemStack.get().invoke(ItemStack.class, obj);
        	ArrayList<ItemStack> currentList;
        	int i = 0;
        	while (i < equivalencyList.size()) {
            	currentList = equivalencyList.get(i);
            	for (ItemStack currentStack : currentList) {
                	if (ItemStack.areItemStacksEqual(checkStack, currentStack))
                    	return new Integer(i);
            	}
            	++i;
        	}
    	}
    	catch(Exception e) {
			e.printStackTrace();
		}
        return null;
    }

    private Integer getIndexInList(int id, int meta) {
        ArrayList<ItemStack> currentList;
        int i = 0;
        while (i < equivalencyList.size()) {
            currentList = equivalencyList.get(i);
            for (ItemStack currentStack : currentList) {
                if (id == currentStack.itemID && meta == currentStack.getItemDamage())
                    return new Integer(i);
            }
            ++i;
        }
        return null;
    }
}
