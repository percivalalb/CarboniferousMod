package carboniferous.block;

import carboniferous.api.IconReference;
import carboniferous.api.Properties;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.IPlantable;

public class BlockCoral extends BlockFlower {

	public BlockCoral(int par1) {
		super(par1, Material.water);
		this.setCreativeTab(null);
	}
	
	@SideOnly(Side.CLIENT)
    @Override
    public Icon getIcon(int side, int meta) {
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
    public void registerIcons(IconRegister par1IconRegister) {
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
	public boolean isBlockReplaceable(World world, int x, int y, int z) { 
		return false;
    }
	
	@Override
	public boolean canBlockStay(World par1World, int par2, int par3, int par4) {
        Block soil = blocksList[par1World.getBlockId(par2, par3 - 1, par4)];
        int id = par1World.getBlockId(par2, par3 + 1, par4);
        return (id == Block.waterMoving.blockID || id == Block.waterStill.blockID || id == this.blockID) && ((soil != null && soil.blockID == this.blockID)||(soil != null && soil.canSustainPlant(par1World, par2, par3 - 1, par4, ForgeDirection.UP, this)));
    }
	
	protected boolean canThisPlantGrowOnThisBlockID(int par1) {
	    return par1 == this.blockID || par1 == Block.grass.blockID || par1 == Block.dirt.blockID || par1 == Block.tilledField.blockID;
	}
	
	public boolean canSustainPlant(World world, int x, int y, int z, ForgeDirection direction, IPlantable plant) {
		 Block soil = blocksList[world.getBlockId(x, y -1 , z)];
		 if(soil != null && soil.blockID == this.blockID) {
			 return true;
		 }
		 return false;
	}
	
	 public int getLightValue(IBlockAccess world, int x, int y, int z) {
		 int meta = world.getBlockMetadata(x, y, z);
		 if(meta == 4) {
	        return 15;
		 }
		 return 0;
	 }
}
