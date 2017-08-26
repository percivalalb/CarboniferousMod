package carboniferous.block;

import carboniferous.api.CarboniferousModAPI;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

public class BlockCarboniferousDirt extends Block {

    public BlockCarboniferousDirt() {
        super(Material.GROUND);
        this.setSoundType(SoundType.GROUND);
        this.setCreativeTab(CarboniferousModAPI.CREATIVE_TAB);
    }
    
    @Override
    public boolean canSustainPlant(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing direction, IPlantable plantable) {
    	IBlockState plant = plantable.getPlant(world, pos.offset(direction));
        EnumPlantType plantType = plantable.getPlantType(world, pos.offset(direction));

        switch(plantType) {
            case Plains: return true;
            case Beach:
            	boolean hasWater = (world.getBlockState(pos.east()).getMaterial() == Material.WATER ||
                world.getBlockState(pos.west()).getMaterial() == Material.WATER ||
                world.getBlockState(pos.north()).getMaterial() == Material.WATER ||
                world.getBlockState(pos.south()).getMaterial() == Material.WATER);
                return hasWater;
            default: return false;
        }
    }
}
