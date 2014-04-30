package carboniferous.block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import carboniferous.tileentity.TileEntityWallShell;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * @author ProPercivalalb
 **/
public class BlockWallShell extends BlockContainer {

	public BlockWallShell() {
		super(Material.clay);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityWallShell();
	}
	
	@Override
	public boolean canBlockStay(World world, int x, int y, int z) {
	    super.canBlockStay(world, x, y, z);
	    return world.getBlock(x - 1, y, z).isSideSolid(world, x - 1, y, z, ForgeDirection.EAST) || world.getBlock(x + 1, y, z).isSideSolid(world, x + 1, y, z, ForgeDirection.WEST) || world.getBlock(x, y, z - 1).isSideSolid(world, x, y, z - 1, ForgeDirection.SOUTH) || world.getBlock(x, y, z + 1).isSideSolid(world, x, y, z + 1, ForgeDirection.NORTH);
	}
	
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4) {
	    return null;
	}

	@SideOnly(Side.CLIENT)
	@Override
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World par1World, int par2, int par3, int par4) {
		this.setBlockBoundsBasedOnState(par1World, par2, par3, par4);
        return super.getSelectedBoundingBoxFromPool(par1World, par2, par3, par4);
    }

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
	    int var5 = par1IBlockAccess.getBlockMetadata(par2, par3, par4);
	    this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	    float sixteenth = 0.0625F;
	    if (var5 == 0) {
	    	this.setBlockBounds(1.0F - sixteenth, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	    }

	    if (var5 == 1) {
	    	this.setBlockBounds(0.0F, 0.0F, 1.0F - sixteenth, 1.0F, 1.0F, 1.0F);
	    }

	    if (var5 == 2) {
	    	this.setBlockBounds(0.0F, 0.0F, 0.0F, 0.0F + sixteenth, 1.0F, 1.0F);
	    }

	    if (var5 == 3) {
	    	this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F + sixteenth);
	    }
	}
	
	@Override
    public int getRenderType() {
        return -1;
    }
	
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
	 
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
	public int quantityDropped(Random par1Random) {
		return 0;
	}

	@Override
	public void breakBlock(World par1World, int par2, int par3, int par4, Block par5, int par6) {
	    TileEntityWallShell west = (TileEntityWallShell)par1World.getTileEntity(par2, par3, par4);
	    if(!west.hasShell()) { 
	    	super.breakBlock(par1World, par2, par3, par4, par5, par6);
	    	return;
	    }
	    if(!par1World.isRemote) {
		    Random rand = new Random();
		    float var15 = 0.05F;
		    float var10 = rand.nextFloat() * 0.8F + 0.1F;
		    float var11 = rand.nextFloat() * 0.8F + 0.1F;
		    float var12 = rand.nextFloat() * 0.8F + 0.1F;
		    EntityItem var14 = new EntityItem(par1World, par2 + var10, par3 + var11, par4 + var12, new ItemStack(west.getShellItem(), 1, west.getShellMetadata()));
		    var14.motionX = ((float)rand.nextGaussian() * var15);
		    var14.motionY = ((float)rand.nextGaussian() * var15 + 0.2F);
		    var14.motionZ = ((float)rand.nextGaussian() * var15);
		    par1World.spawnEntityInWorld(var14);
	    }
	    super.breakBlock(par1World, par2, par3, par4, par5, par6);
	}

	@Override
	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, Block par5) {
	    boolean var6 = false;
	    int var7 = par1World.getBlockMetadata(par2, par3, par4);
	    var6 = true;

	    if ((var7 == 0) && (par1World.getBlock(par2 + 1, par3, par4).isOpaqueCube())) {
	    	var6 = false;
	    }

	    if ((var7 == 1) && (par1World.getBlock(par2, par3, par4 + 1).isOpaqueCube())) {
	    	var6 = false;
	    }

	    if ((var7 == 2) && (par1World.getBlock(par2 - 1, par3, par4).isOpaqueCube())) {
	    	var6 = false;
	    }

	    if ((var7 == 3) && (par1World.getBlock(par2, par3, par4 - 1).isOpaqueCube())) {
	    	var6 = false;
	    }

	    if (var6) {
	    	TileEntityWallShell te = (TileEntityWallShell)par1World.getTileEntity(par2, par3, par4);
	    	if(!te.hasShell()) return;
	    	dropShell(par1World, par2, par3, par4, new ItemStack(te.getShellItem(), 1, te.getShellMetadata()));
	    	par1World.setBlockToAir(par2, par3, par4);
	    }

	    super.onNeighborBlockChange(par1World, par2, par3, par4, par5);
	}

	private void dropShell(World worldObj, int i, int j, int k, ItemStack stack) {
		if (!worldObj.isRemote) {
			float var6 = 0.7F;
			double var7 = worldObj.rand.nextFloat() * var6 + (1.0F - var6) * 0.5D;
			double var9 = worldObj.rand.nextFloat() * var6 + (1.0F - var6) * 0.5D;
			double var11 = worldObj.rand.nextFloat() * var6 + (1.0F - var6) * 0.5D;
			EntityItem var13 = new EntityItem(worldObj, i + var7, j + var9, k + var11, stack);
			var13.delayBeforeCanPickup = 10;
			worldObj.spawnEntityInWorld(var13);
	    }
	}
	
	@SideOnly(Side.CLIENT)
	@Override
    public IIcon getIcon(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) {
		return Blocks.soul_sand.getIcon(par1IBlockAccess, par2, par3, par4, par5);
    }
	
	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int par1, int par2) {
	    return Blocks.soul_sand.getIcon(par1, par2);
	}
	
	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
		TileEntityWallShell te = (TileEntityWallShell)world.getTileEntity(x, y, z);


        if (!te.hasShell())
            return null;

        Item item = te.getShellItem();

        return new ItemStack(item, 1, te.getShellMetadata());
    }
}
