package carboniferous.block;

import carboniferous.api.CarboniferousApi;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;

/**
 * @author ProPercivalalb
 **/
public class BlockCarboniferousStairs extends BlockStairs {

	public BlockCarboniferousStairs(int par1, Block par2Block, int par3) {
		super(par1, par2Block, par3);
		this.setCreativeTab(null);
		this.setLightOpacity(0);
	}

}
