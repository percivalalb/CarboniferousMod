package carboniferous.block;

import carboniferous.api.CarboniferousModAPI;
import net.minecraft.block.BlockLog;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockCarboniferousLog extends BlockLog {
	
    public static final PropertyEnum<EnumWood> VARIANT = PropertyEnum.<EnumWood>create("variant", EnumWood.class);

    public BlockCarboniferousLog() {
        this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, EnumWood.LEPIDODENDRON).withProperty(LOG_AXIS, BlockLog.EnumAxis.Y));
        this.setCreativeTab(CarboniferousModAPI.CREATIVE_TAB);
    }

    @Override
    public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
    	EnumWood blockplanks$enumtype = (EnumWood)state.getValue(VARIANT);
    	return blockplanks$enumtype.getMapColor();
    }

    @Override
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items)  {
        items.add(new ItemStack(this, 1, EnumWood.LEPIDODENDRON.getMetadata()));
        items.add(new ItemStack(this, 1, EnumWood.CALAMITES.getMetadata()));
        items.add(new ItemStack(this, 1, EnumWood.CORDAITES.getMetadata()));
        items.add(new ItemStack(this, 1, EnumWood.SIGILLARIA.getMetadata()));
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        IBlockState iblockstate = this.getDefaultState().withProperty(VARIANT, EnumWood.byMetadata((meta & 3)));

        switch (meta & 12) {
            case 0:
                iblockstate = iblockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.Y);
                break;
            case 4:
                iblockstate = iblockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.X);
                break;
            case 8:
                iblockstate = iblockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.Z);
                break;
            default:
                iblockstate = iblockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.NONE);
        }

        return iblockstate;
    }

    @Override
    public int getMetaFromState(IBlockState state){
        int i = 0;
        i = i | state.getValue(VARIANT).getMetadata();

        switch ((BlockLog.EnumAxis)state.getValue(LOG_AXIS))
        {
            case X:
                i |= 4;
                break;
            case Z:
                i |= 8;
                break;
            case NONE:
                i |= 12;
        }

        return i;
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[] {VARIANT, LOG_AXIS});
    }

    @Override
    protected ItemStack getSilkTouchDrop(IBlockState state) {
        return new ItemStack(Item.getItemFromBlock(this), 1, state.getValue(VARIANT).getMetadata());
    }

    @Override
    public int damageDropped(IBlockState state) {
        return state.getValue(VARIANT).getMetadata() ;
    }
}