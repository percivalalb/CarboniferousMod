package carboniferous.block;

import java.util.Random;

import carboniferous.api.CarboniferousModAPI;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.IGrowable;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCarboniferousSapling extends BlockBush implements IGrowable {
	
	public static final PropertyEnum<EnumWood> TYPE = PropertyEnum.<EnumWood>create("type", EnumWood.class);
	public static final PropertyInteger STAGE = PropertyInteger.create("stage", 0, 1);
    protected static final AxisAlignedBB SAPLING_AABB = new AxisAlignedBB(0.09999999403953552D, 0.0D, 0.09999999403953552D, 0.8999999761581421D, 0.800000011920929D, 0.8999999761581421D);
	
	public BlockCarboniferousSapling() {
        this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, EnumWood.LEPIDODENDRON).withProperty(STAGE, Integer.valueOf(0)));
		this.setCreativeTab(CarboniferousModAPI.CREATIVE_TAB);
    }
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return SAPLING_AABB;
    }

	@Override
    public String getLocalizedName() {
        return I18n.translateToLocal(this.getUnlocalizedName() + "." + BlockPlanks.EnumType.OAK.getUnlocalizedName() + ".name");
    }
	
	@Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        if (!worldIn.isRemote) {
            super.updateTick(worldIn, pos, state, rand);

            if (worldIn.getLightFromNeighbors(pos.up()) >= 9 && rand.nextInt(7) == 0)
                this.grow(worldIn, rand, pos, state);
        }
    }
	
	public void generateTree(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		
	}

	@Override
    public int damageDropped(IBlockState state) {
        return state.getValue(TYPE).getMetadata();
    }
	
	@Override
	public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {
        return true;
    }

	@Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
        return (double)worldIn.rand.nextFloat() < 0.45D;
    }

	@Override
    public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		if (((Integer)state.getValue(STAGE)).intValue() == 0)
			worldIn.setBlockState(pos, state.cycleProperty(STAGE), 4);
		else
			this.generateTree(worldIn, pos, state, rand);
    }

	@Override
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
        for(EnumWood blockplanks$enumtype : EnumWood.values())
            items.add(new ItemStack(this, 1, blockplanks$enumtype.getMetadata()));
    }
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(TYPE, EnumWood.byMetadata(meta & 7)).withProperty(STAGE, Integer.valueOf((meta & 8) >> 3));
    }

	@Override
    public int getMetaFromState(IBlockState state) {
        int i = 0;
        i = i | state.getValue(TYPE).getMetadata();
        i = i | state.getValue(STAGE) << 3;
        return i;
    }

	@Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[] {TYPE, STAGE});
    }
}
