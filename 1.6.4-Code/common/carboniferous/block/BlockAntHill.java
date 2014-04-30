package carboniferous.block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import carboniferous.ModBlocks;
import carboniferous.ModItems;
import carboniferous.api.Properties;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

/**
 * @author ProPercivalalb
 **/
public class BlockAntHill extends Block {

	public BlockAntHill(int par1) {
		super(par1, Material.ground);
	}

	@Override
    public int damageDropped(int meta) {
		return 0;
	}
	
	@Override
    public int quantityDropped(int meta, int fortune, Random random) {
		if(fortune > 5) {
			fortune = 5;
		}
		return (fortune + 1) * (random.nextInt(5) + 1);
	}
	
	@Override
    public int idDropped(int meta, Random random, int fortune) {
		return ModItems.rawAnt.itemID;
	}
	
	@Override
	public int getRenderType() {
	    return Properties.RENDER_ANT_HILL;
	}
	
	@Override
	public boolean isOpaqueCube() {
        return false;
    }

	@Override
    public boolean renderAsNormalBlock() {
        return false;
    }
	
	@SideOnly(Side.CLIENT)
    @Override
	public IIcon getBlockTexture(IBlockAccess par1IBlockAccess, int x, int y, int z, int side) {
		return ModBlocks.dirt.getBlockTextureFromSide(0);
	}
	
	@SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int side, int metadata) {
		return ModBlocks.dirt.getBlockTextureFromSide(0);
	}
	
	public boolean isBlockSolidOnSide(World world, int x, int y, int z, ForgeDirection side) {
		if(side == ForgeDirection.DOWN) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) {
	    return par5 == 0 ? (par1IBlockAccess.isBlockOpaqueCube(par2, par3, par4) ? false : true) : true;
	}
	
	@SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IconRegister par1IconRegister) {}
}
