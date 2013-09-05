package carboniferous.block;

import java.util.List;
import java.util.Random;

import carboniferous.api.CarboniferousApi;
import carboniferous.api.Properties;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

/**
 * @author ProPercivalalb
 **/
public class BlockLog extends Block {

    public String[] iconPaths;
    public String[] treeTopPaths;
    @SideOnly(Side.CLIENT)
    private Icon[] iconList;
    @SideOnly(Side.CLIENT)
    private Icon[] iconTreeTop;

    public BlockLog(int par1, String[] par2, String[] par3) {
        super(par1, Material.wood);
        this.iconPaths = par2;
        this.treeTopPaths = par3;
    }

    @Override
    public int getRenderType() {
        return 31;
    }

    @Override
    public int quantityDropped(Random par1Random) {
        return 1;
    }

    @Override
    public int idDropped(int par1, Random par2Random, int par3) {
        return this.blockID;
    }

    @Override
    public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6) {
        byte b0 = 4;
        int j1 = b0 + 1;

        if (par1World.checkChunksExist(par2 - j1, par3 - j1, par4 - j1, par2 + j1, par3 + j1, par4 + j1)) {
            for (int k1 = -b0; k1 <= b0; ++k1) {
                for (int l1 = -b0; l1 <= b0; ++l1) {
                    for (int i2 = -b0; i2 <= b0; ++i2) {
                        int j2 = par1World.getBlockId(par2 + k1, par3 + l1, par4 + i2);

                        if (Block.blocksList[j2] != null) {
                            Block.blocksList[j2].beginLeavesDecay(par1World, par2 + k1, par3 + l1, par4 + i2);
                        }
                    }
                }
            }
        }
    }

    @Override
    public int onBlockPlaced(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9) {
        int j1 = par9 & 3;
        byte b0 = 0;

        switch (par5) {
            case 0:
            case 1:
                b0 = 0;
                break;
            case 2:
            case 3:
                b0 = 8;
                break;
            case 4:
            case 5:
                b0 = 4;
        }

        return j1 | b0;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public Icon getIcon(int par1, int par2) {
        int k = par2 & 12;
        int l = par2 & 3;

        if(k == 0 && (par1 == 1 || par1 == 0)) {
        	return this.iconTreeTop[l];
        }
        else if(k == 4 && (par1 == 5 || par1 == 4)) {
        	return this.iconTreeTop[l];
        }
        else if(k == 8 && (par1 == 2 || par1 == 3)) {
        	return this.iconTreeTop[l];
        }
        else {
        	return this.iconList[l];
        }
    }

    @Override
    public int damageDropped(int par1) {
        return par1 & 3;
    }

    public static int limitToValidMetadata(int par0) {
        return par0 & 3;
    }
    
    protected ItemStack createStackedBlock(int par1) {
        return new ItemStack(this.blockID, 1, limitToValidMetadata(par1));
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IconRegister par1IconRegister) {
        this.iconList = new Icon[iconPaths.length];
        this.iconTreeTop = new Icon[treeTopPaths.length];
        
        for (int i = 0; i < this.iconList.length; ++i) {
            this.iconList[i] = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + iconPaths[i]);
            this.iconTreeTop[i] = par1IconRegister.registerIcon((treeTopPaths[i].equals("log_oak_top") ? "" : Properties.TEX_PACkAGE) + treeTopPaths[i]);
        }
    }

    @Override
    public boolean canSustainLeaves(World world, int x, int y, int z) {
        return true;
    }

    @Override
    public boolean isWood(World world, int x, int y, int z) {
        return true;
    }
}
