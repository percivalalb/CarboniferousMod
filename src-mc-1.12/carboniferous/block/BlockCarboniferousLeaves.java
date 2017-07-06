package carboniferous.block;

import java.util.Random;

import com.google.common.base.Predicate;

import carboniferous.ModBlocks;
import carboniferous.addon.optifine.OptifinePlugin;
import carboniferous.api.CarboniferousModAPI;
import carboniferous.world.TeleporterCarboniferous;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockCarboniferousLeaves extends BlockLeaves {
	
    public static final PropertyEnum<EnumWood> VARIANT = PropertyEnum.<EnumWood>create("variant", EnumWood.class);
    public static final PropertyBool TRANSPARENT = PropertyBool.create("transparent");
    
    
    public BlockCarboniferousLeaves() {
    	super();
        this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, EnumWood.LEPIDODENDRON).withProperty(CHECK_DECAY, Boolean.valueOf(true)).withProperty(DECAYABLE, Boolean.valueOf(true)).withProperty(TRANSPARENT, true));
        this.setCreativeTab(CarboniferousModAPI.CREATIVE_TAB);
    }
    
    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
    	if(playerIn instanceof EntityPlayerMP) {
    		EntityPlayerMP playerMP = (EntityPlayerMP)playerIn;
    		int dimension = CarboniferousModAPI.DIMENSION_TYPE.getId();
            if (playerMP.dimension == CarboniferousModAPI.DIMENSION_TYPE.getId()) {
            	dimension = 0;
            }
    		
    		playerMP.mcServer.getPlayerList().transferPlayerToDimension(playerMP, dimension, new TeleporterCarboniferous(playerMP.mcServer.getWorld(dimension)));
    	}
        return false;
    }

    @Override
    protected int getSaplingDropChance(IBlockState state) {
        return 40;
    }

    @Override
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
        items.add(new ItemStack(this, 1, EnumWood.LEPIDODENDRON.getMetadata()));
        items.add(new ItemStack(this, 1, EnumWood.CALAMITES.getMetadata()));
        items.add(new ItemStack(this, 1, EnumWood.CORDAITES.getMetadata()));
        items.add(new ItemStack(this, 1, EnumWood.SIGILLARIA.getMetadata()));
    }
    
    @Override
    public Item getItemDropped(IBlockState state, Random random, int fortune) {
        return Item.getItemFromBlock(ModBlocks.SAPLING_0);
    }

    @Override
    protected ItemStack getSilkTouchDrop(IBlockState state) {
        return new ItemStack(Item.getItemFromBlock(this), 1, state.getValue(VARIANT).getMetadata());
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(VARIANT, EnumWood.byMetadata((meta & 3) % 4)).withProperty(DECAYABLE, Boolean.valueOf((meta & 4) == 0)).withProperty(CHECK_DECAY, Boolean.valueOf((meta & 8) > 0));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        int i = 0;
        i = i | ((EnumWood)state.getValue(VARIANT)).getMetadata();

        if (!((Boolean)state.getValue(DECAYABLE)).booleanValue())
            i |= 4;

        if (((Boolean)state.getValue(CHECK_DECAY)).booleanValue())
            i |= 8;

        return i;
    }
    
    @Override
    public boolean isOpaqueCube(IBlockState state) {
    	int setting = OptifinePlugin.getTreeSetting();
        return setting == 0 ? Blocks.LEAVES.isOpaqueCube(null) : (setting == 1 ? true : false);
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[] {VARIANT, CHECK_DECAY, DECAYABLE, TRANSPARENT});
    }

    @Override
    public int damageDropped(IBlockState state) {
        return state.getValue(VARIANT).getMetadata();
    }
    
    @Override
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
        return state.withProperty(TRANSPARENT, !this.isOpaqueCube(state));
    }

    @Override
    public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, TileEntity te, ItemStack stack) {
        if(!worldIn.isRemote && stack.getItem() == Items.SHEARS)
            player.addStat(StatList.getBlockStats(this));
        else
            super.harvestBlock(worldIn, player, pos, state, te, stack);
    }

    @Override
    public NonNullList<ItemStack> onSheared(ItemStack item, net.minecraft.world.IBlockAccess world, BlockPos pos, int fortune) {
        return NonNullList.withSize(1, new ItemStack(this, 1, world.getBlockState(pos).getValue(VARIANT).getMetadata()));
    }
    
    
    //Not required for mod leaves
    @Override
    public BlockPlanks.EnumType getWoodType(int meta) {
        return null;
    }
}