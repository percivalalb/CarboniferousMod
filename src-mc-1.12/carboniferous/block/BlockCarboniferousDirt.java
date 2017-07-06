package carboniferous.block;

import carboniferous.api.CarboniferousModAPI;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockCarboniferousDirt extends Block {

    public BlockCarboniferousDirt() {
        super(Material.GROUND);
        this.setSoundType(SoundType.GROUND);
        this.setCreativeTab(CarboniferousModAPI.CREATIVE_TAB);
    }
}
