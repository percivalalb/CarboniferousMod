package carboniferous.block;

import carboniferous.ModBlocks;
import carboniferous.api.IconReference;
import carboniferous.api.Properties;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockCoral extends BlockBush {

	public BlockCoral() {
		super(Material.water);
		this.setCreativeTab(null);
	}
	
	@SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int side, int meta) {
       switch(meta) {
       case 0: return IconReference.coralTabulate;
       case 1: return IconReference.coralBrain;
       case 2: return IconReference.coralRed;
       case 3: return IconReference.coralRock;
       case 4: return IconReference.coralGlowing;
       default: return null;
       }
    }
	
	@SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister par1IconRegister) {
        IconReference.coralTabulate = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "coral1");
        IconReference.coralBrain = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "coral2");
        IconReference.coralRed = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "coral3");
        IconReference.coralRock = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "coral4");
        IconReference.coralGlowing = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "coral5");
    }

	@Override
    public int damageDropped(int meta) {
		return meta;
	}
	
	@Override
	public boolean canBlockStay(World par1World, int par2, int par3, int par4) {
        Block soil = par1World.getBlock(par2, par3 - 1, par4);
        Block id = par1World.getBlock(par2, par3 + 1, par4);
        return (id == Blocks.flowing_water || id == Blocks.water) && ((soil != null && soil == this)||(soil != null && soil.canSustainPlant(par1World, par2, par3 - 1, par4, ForgeDirection.UP, this)));
    }

	
	@Override
	public boolean isReplaceable(IBlockAccess world, int x, int y, int z) { 
		return false;
    }

	@Override
	public int getLightValue(IBlockAccess world, int x, int y, int z) {
		int meta = world.getBlockMetadata(x, y, z);
		if(meta == 4)
	       return 15;
		return 0;
	}
}
