package carboniferous.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;

import carboniferous.api.Properties;

import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.World;

/**
 * @author ProPercivalalb
 **/
public class BlockCustomGlass extends BlockBreakable {
	
    public BlockCustomGlass() {
        super(Properties.TEX_PACkAGE + "clearGlass", Material.glass, false);
    }

    @Override
    public int quantityDropped(Random par1Random) {
        return 0;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public int getRenderBlockPass() {
        return 0;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    protected boolean canSilkHarvest() {
        return true;
    }
    
    @Override
    public boolean canPlaceTorchOnTop(World world, int x, int y, int z) {
    	return true;
    }
}
