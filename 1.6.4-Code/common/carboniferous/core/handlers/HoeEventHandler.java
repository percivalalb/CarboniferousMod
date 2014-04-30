package carboniferous.core.handlers;

import carboniferous.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.UseHoeEvent;

/**
 * @author ProPercivalalb
 */
public class HoeEventHandler {

	@ForgeSubscribe
	public void hoeUse(UseHoeEvent par1) {
		if((par1.world.getBlockId(par1.x, par1.y, par1.z) == ModBlocks.dirt.blockID && par1.world.getBlockMetadata(par1.x, par1.y, par1.z) == 0) ||
				(par1.world.getBlockId(par1.x, par1.y, par1.z) == ModBlocks.grass.blockID && par1.world.getBlockMetadata(par1.x, par1.y, par1.z) == 0)) {
			Block block = ModBlocks.tilledEarth;
        	par1.world.playSoundEffect((double)((float)par1.x + 0.5F), (double)((float)par1.y + 0.5F), (double)((float)par1.z + 0.5F), block.stepSound.getStepSound(), (block.stepSound.getVolume() + 1.0F) / 2.0F, block.stepSound.getPitch() * 0.8F);

        	if (!par1.world.isRemote) {
        		par1.world.setBlock(par1.x, par1.y, par1.z, block.blockID);
        	}
        	par1.setResult(Result.ALLOW);
		}
	}
}
