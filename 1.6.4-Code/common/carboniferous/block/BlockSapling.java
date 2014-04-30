package carboniferous.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Random;

import carboniferous.api.CarboniferousApi;
import carboniferous.api.Properties;
import carboniferous.world.feature.WorldGenCalamites;
import carboniferous.world.feature.WorldGenCordaites;
import carboniferous.world.feature.WorldGenLepidodendron;
import carboniferous.world.feature.WorldGenSigillaria;
import carboniferous.world.feature.WorldGenSmallTrees;

import net.minecraft.block.BlockFlower;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenForest;
import net.minecraft.world.gen.feature.WorldGenHugeTrees;
import net.minecraft.world.gen.feature.WorldGenTaiga2;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;

import net.minecraftforge.event.terraingen.TerrainGen;

public class BlockSapling extends BlockFlower {
    
    private static final String[] saplingPaths = new String[] {"saplingLepidodendron", "saplingCalamites", "saplingCordaites", "saplingSigillaria"};
    @SideOnly(Side.CLIENT)
    private IIcon[] saplingIcon;
    
    private static int forestrySoilID = 0;

    public BlockSapling(int par1) {
        super(par1);
        float f = 0.4F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
        this.setCreativeTab(null);
    }

    @Override
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {
        if (!par1World.isRemote) {
            super.updateTick(par1World, par2, par3, par4, par5Random);

            if (par1World.getBlockLightValue(par2, par3 + 1, par4) >= 9 && par5Random.nextInt(7) == 0) {
                this.func_96477_c(par1World, par2, par3, par4, par5Random);
            }
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int par1, int par2) {
        par2 &= 3;
        return this.saplingIcon[par2];
    }

    public void func_96477_c(World par1World, int par2, int par3, int par4, Random par5Random) {
        int l = par1World.getBlockMetadata(par2, par3, par4);

        if ((l & 8) == 0) {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, l | 8, 4);
        }
        else {
            this.growTree(par1World, par2, par3, par4, par5Random);
        }
    }

    public void growTree(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (!TerrainGen.saplingGrowTree(par1World, par5Random, par2, par3, par4)) return;

        int l = par1World.getBlockMetadata(par2, par3, par4) & 3;
        Object object = null;
        int i1 = 0;
        int j1 = 0;
        boolean flag = false;

        if (l == 1) {
            object = new WorldGenCalamites(true);
        }
        else if (l == 2) {
            object = new WorldGenCordaites(true).setIsSapling();
        }
        else if (l == 3)
        {
           object = new WorldGenSigillaria(true);
        }
        else {
            object = new WorldGenSmallTrees(true);

            if (par5Random.nextInt(3) == 0) {
                object = new WorldGenLepidodendron(true);
            }
        }

        if (flag) {
            par1World.setBlock(par2 + i1, par3, par4 + j1, 0, 0, 4);
            par1World.setBlock(par2 + i1 + 1, par3, par4 + j1, 0, 0, 4);
            par1World.setBlock(par2 + i1, par3, par4 + j1 + 1, 0, 0, 4);
            par1World.setBlock(par2 + i1 + 1, par3, par4 + j1 + 1, 0, 0, 4);
        }
        else {
            par1World.setBlock(par2, par3, par4, 0, 0, 4);
        }

        if (!((WorldGenerator)object).generate(par1World, par5Random, par2 + i1, par3, par4 + j1)) {
            if (flag) {
                par1World.setBlock(par2 + i1, par3, par4 + j1, this.blockID, l, 4);
                par1World.setBlock(par2 + i1 + 1, par3, par4 + j1, this.blockID, l, 4);
                par1World.setBlock(par2 + i1, par3, par4 + j1 + 1, this.blockID, l, 4);
                par1World.setBlock(par2 + i1 + 1, par3, par4 + j1 + 1, this.blockID, l, 4);
            }
            else {
                par1World.setBlock(par2, par3, par4, this.blockID, l, 4);
            }
        }
    }

    public boolean isSameSapling(World par1World, int par2, int par3, int par4, int par5) {
        return par1World.getBlockId(par2, par3, par4) == this.blockID && (par1World.getBlockMetadata(par2, par3, par4) & 3) == par5;
    }

    @Override
    public int damageDropped(int par1) {
        return par1 & 3;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IconRegister par1IconRegister) {
        this.saplingIcon = new Icon[saplingPaths.length];

        for (int i = 0; i < this.saplingIcon.length; ++i) {
            this.saplingIcon[i] = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + saplingPaths[i]);
        }
    }
}
