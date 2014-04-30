package carboniferous.api.interfaces;

import net.minecraft.item.ItemStack;

/**
 * @author ProPercivalalb
 * Should be implemented by and class that extends #Item
 */
public interface ILargeItem {

	/**
	 * 
	 * @return The png file name. Example - "largeItem". The texture should be placed in the 
	 * 		   /mods/carboniferous/textures/items/large/ to be locat
	 */
	public String getTexture(ItemStack stack);
	
	/**
	 * 
	 * @param stack The target #ItemStack
	 * @return If the item can rendered as a large item, this allows you to have control over whether it
	 * 		   the damage or NBT tag is valid.
	 */
	public boolean canBeLargeItem(ItemStack stack);
	
}
