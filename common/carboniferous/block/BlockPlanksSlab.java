package carboniferous.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Random;

import carboniferous.CarboniferousMod;
import carboniferous.ModBlocks;
import carboniferous.api.CarboniferousApi;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockPlanksSlab extends BlockHalfSlab {
    
	/** The type of tree this slab came from. */
    public static final String[] woodType = new String[] {"lepidodendron", "calamites", "cordaites", "sigillaria"};

    public BlockPlanksSlab(int par1, boolean par2) {
        super(par1, par2, Material.wood);
        this.setCreativeTab(null);
        this.setLightOpacity(0);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public Icon getIcon(int par1, int par2) {
        return ModBlocks.planks_1.getIcon(par1, par2 & 7);
    }

    @Override
    public int idDropped(int par1, Random par2Random, int par3) {
        return ModBlocks.woodSingleSlab.blockID;
    }

    @Override
    protected ItemStack createStackedBlock(int par1) {
        return new ItemStack(ModBlocks.woodSingleSlab.blockID, 2, par1 & 7);
    }

    @Override
    public String getFullSlabName(int par1) {
        if (par1 < 0 || par1 >= woodType.length)
        {
            par1 = 0;
        }

        return super.getUnlocalizedName() + "." + woodType[par1];
    }
    
    private static boolean isBlockSingleSlab(int par0) {
        return par0 == ModBlocks.woodSingleSlab.blockID;
    }

    public int idPicked(World par1World, int par2, int par3, int par4) {
        return ModBlocks.woodSingleSlab.blockID;
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IconRegister par1IconRegister) {}
}
