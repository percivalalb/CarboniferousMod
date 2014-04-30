package carboniferous.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;

import carboniferous.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 * @author ProPercivalalb
 **/
public class BlockWall extends net.minecraft.block.BlockWall {

    public BlockWall(Block par2Block) {
        super(par2Block);
        this.setCreativeTab(null);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int side, int meta) {
    	switch(meta) {
    	case 0: return ModBlocks.multiBlock1.getIcon(side, 0);
    	case 1: return ModBlocks.multiBlock1.getIcon(side, 1);
    	case 2: return ModBlocks.multiBlock1.getIcon(side, 2);
    	case 3: return ModBlocks.multiBlock1.getIcon(side, 3);
    	case 4: return ModBlocks.multiBlock1.getIcon(side, 4);
    	case 5: return ModBlocks.dirt.getIcon(side, 0);
    	default: return null;
    	}
    }

    @Override
    public int getRenderType() {
        return 32;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public boolean getBlocksMovement(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
        return false;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
        boolean flag = this.canConnectWallTo(par1IBlockAccess, par2, par3, par4 - 1);
        boolean flag1 = this.canConnectWallTo(par1IBlockAccess, par2, par3, par4 + 1);
        boolean flag2 = this.canConnectWallTo(par1IBlockAccess, par2 - 1, par3, par4);
        boolean flag3 = this.canConnectWallTo(par1IBlockAccess, par2 + 1, par3, par4);
        float f = 0.25F;
        float f1 = 0.75F;
        float f2 = 0.25F;
        float f3 = 0.75F;
        float f4 = 1.0F;

        if (flag) {
            f2 = 0.0F;
        }

        if (flag1) {
            f3 = 1.0F;
        }

        if (flag2) {
            f = 0.0F;
        }

        if (flag3) {
            f1 = 1.0F;
        }

        if (flag && flag1 && !flag2 && !flag3) {
            f4 = 0.8125F;
            f = 0.3125F;
            f1 = 0.6875F;
        }
        else if (!flag && !flag1 && flag2 && flag3) {
            f4 = 0.8125F;
            f2 = 0.3125F;
            f3 = 0.6875F;
        }

        this.setBlockBounds(f, 0.0F, f2, f1, f4, f3);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4) {
        this.setBlockBoundsBasedOnState(par1World, par2, par3, par4);
        this.maxY = 1.5D;
        return super.getCollisionBoundingBoxFromPool(par1World, par2, par3, par4);
    }

    @Override
    public boolean canConnectWallTo(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
        Block block = par1IBlockAccess.getBlock(par2, par3, par4);

        if (block != this && block != Blocks.fence_gate) {
            return block != null && block.getMaterial().isOpaque() && block.renderAsNormalBlock() ? block.getMaterial() != Material.gourd : false;
        }
        else
        {
            return true;
        }
    }

    @Override
    public int damageDropped(int par1) {
        return par1;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) {
        return par5 == 0 ? super.shouldSideBeRendered(par1IBlockAccess, par2, par3, par4, par5) : true;
    }

    @SideOnly(Side.CLIENT)

    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    public void registerBlockIcons(IIconRegister par1IconRegister) {}
}
