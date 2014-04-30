package carboniferous.recipe;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;

import carboniferous.api.Properties;
import carboniferous.core.helper.LogHelper;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

/**
 * @author ProPercivalalb
 **/
public class CarboniferousRecipes {

	public static List<List<Integer>> grindableItems = new ArrayList<List<Integer>>();

	private static List grinderComponentes = new Vector();
	
	public static void addGrinderComponent(ItemStack component, int durability, int speedIncrement) {
		grinderComponentes.add(new AbstractMap.SimpleEntry(component, Arrays.asList(durability, speedIncrement)));
	}
	
	public static Iterator getAllGrinderComponents() {
		return grinderComponentes.iterator();
	}
	
	public static int getComponentDurability(ItemStack component) {
	    assert (component != null);

	    Iterator ite = getAllGrinderComponents();
		while(ite.hasNext()) {
			Map.Entry entry = (Map.Entry)ite.next();
	    	if ((((ItemStack)entry.getKey()).isItemEqual(component))) {
	    		return ((List<Integer>)entry.getValue()).get(0);
	    	}
	    }
	    return -1;
	}
	
	public static int getComponentSpeedIncrement(ItemStack component) {
	    assert (component != null);

	    Iterator ite = getAllGrinderComponents();
		while(ite.hasNext()) {
			Map.Entry entry = (Map.Entry)ite.next();
	    	if ((((ItemStack)entry.getKey()).isItemEqual(component))) {
	    		return ((List<Integer>)entry.getValue()).get(1);
	    	}
	    }
	    return -1;
	}
}
