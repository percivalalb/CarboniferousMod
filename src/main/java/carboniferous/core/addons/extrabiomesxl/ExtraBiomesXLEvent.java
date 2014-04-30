package carboniferous.core.addons.extrabiomesxl;

import carboniferous.CarboniferousMod;
import carboniferous.ModBlocks;
import net.minecraft.block.Block;

/**
 * @author ProPercivalalb
 **/
public class ExtraBiomesXLEvent 
{
	/**
	@ForgeSubscribe
    public void onUseLogTurnerEvent(extrabiomes.api.UseLogTurnerEvent event) {
        final int id = event.world.getBlockId(event.x, event.y, event.z);

        if (id == ModBlocks.logs_1) {
            final Block wood = Block.wood;
            event.world.playSoundEffect(event.x + 0.5F, event.y + 0.5F, event.z + 0.5F, wood.stepSound.getStepSound(), (wood.stepSound.getVolume() + 1.0F) / 2.0F, wood.stepSound.getPitch() * 1.55F);
            if (!event.world.isRemote) {
                final int metadata = event.world.getBlockMetadata(event.x, event.y, event.z);
                int orientation = metadata & 12;
                final int type = metadata & 3;

                orientation = orientation == 0 ? 4 : orientation == 4 ? 8 : 0;
                event.world.setBlock(event.x, event.y, event.z, id, type | orientation, 3);
            }
            event.setHandled();
        }
    }**/
}
