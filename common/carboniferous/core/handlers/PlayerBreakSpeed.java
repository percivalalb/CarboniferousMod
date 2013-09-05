package carboniferous.core.handlers;

import carboniferous.block.BlockLeaves;
import net.minecraft.item.ItemShears;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.PlayerEvent.BreakSpeed;

/**
 * @author ProPercivalalb
 **/
public class PlayerBreakSpeed {
	
	@ForgeSubscribe
	public void breakSpeed(BreakSpeed par1) {
		if(par1.block != null && par1.block instanceof BlockLeaves) {
			ItemStack item = par1.entityPlayer.getCurrentEquippedItem();
			if(item != null && item.getItem() instanceof ItemShears) {
				par1.newSpeed = 15.0F;
			}
		}
	}
}
