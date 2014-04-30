package carboniferous.api.interfaces;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;

/**
 * Implement this interface in you main mod class (The
 * one with the @Mod annotation).
 * @author ProPercivalalb
 */
public interface ICarboniferousTab {

	/**
	 * Basically the same as the method found in the Item.java add 
	 * you new ItemStacks to the par2List.
	 * @param par1CreativeTabs The Reference to the Carboniferous Creative Tab.
	 * @param par2List The list of all items in the tab, add as you please. 
	 */
	public void addCarboniferousAddons(CreativeTabs par1CreativeTabs, List par2List);
}
