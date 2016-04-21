package carboniferous.block;

import carboniferous.ModBlocks;
import carboniferous.api.Properties;
import carboniferous.tileentity.TileEntityGiantFern;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockGiantFern extends BlockContainer {
	
	public BlockGiantFern() {
		super(Material.plants);
		this.setBlockBounds(0.0625F * 4.0F, 0.0F, 0.0625F * 4.0F, 0.0625F * 12.0F, 0.0625F * 14, 0.0625F * 12.0F);
	}
	
    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
        return null;
    }

	@Override
	public int getRenderType() {
	    return -1;
	}
	
	@Override
    public boolean isOpaqueCube() {
        return false;
    }

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return BlockGrass.iconGrassTop;
	}
	
	@Override
    public boolean renderAsNormalBlock() {
        return false;
    }

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityGiantFern();
	}
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityBase, ItemStack heldStack) {
		byte meta = 0;
	    int l = MathHelper.floor_double((double)(entityBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

	    if (l == 0)
	        meta = 2;

	    if (l == 1)
	        meta = 5;

	    if (l == 2)
	        meta = 3;

	    if (l == 3)
	        meta = 4;

	    world.setBlockMetadataWithNotify(x, y, z, meta, 2);
	}
}
