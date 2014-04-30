package carboniferous.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Random;

import carboniferous.CarboniferousMod;
import carboniferous.ModBlocks;
import carboniferous.api.CarboniferousApi;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockWoodSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockPlanksSlab extends BlockSlab {
    
	/** The type of tree this slab came from. */
    public static final String[] woodType = new String[] {"lepidodendron", "calamites", "cordaites", "sigillaria"};

    public BlockPlanksSlab(boolean par2) {
        super(par2, Material.wood);
        this.setCreativeTab(null);
        this.setLightOpacity(0);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int par1, int par2) {
        return ModBlocks.planks_1.getIcon(par1, par2 & 7);
    }

    @Override
    public Item getItemDropped(int par1, Random par2Random, int par3) {
        return Item.getItemFromBlock(ModBlocks.woodSingleSlab);
    }

    @Override
    protected ItemStack createStackedBlock(int par1) {
        return new ItemStack(ModBlocks.woodSingleSlab, 2, par1 & 7);
    }

    @Override
    public String func_150002_b(int par1) {
        if (par1 < 0 || par1 >= woodType.length)
        {
            par1 = 0;
        }

        return super.getUnlocalizedName() + "." + woodType[par1];
    }
    
    private static boolean isBlockSingleSlab(Block par0) {
        return par0 == ModBlocks.woodSingleSlab;
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister par1IconRegister) {}
}
