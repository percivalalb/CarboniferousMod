package carboniferous.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;

import carboniferous.api.CarboniferousApi;
import carboniferous.api.Properties;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

/**
 * @author ProPercivalalb
 **/
public class BlockPlanks extends Block {
    
    public static final String[] woodTextureTypes = new String[] {"plankLepidodendron", "plankCalamites", "plankCordaites", "plankSigillaria"};
    @SideOnly(Side.CLIENT)
    private IIcon[] iconArray;

    public BlockPlanks(int par1) {
        super(par1, Material.wood);
        this.setCreativeTab(null);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int par1, int par2) {
        if (par2 < 0 || par2 >= this.iconArray.length) {
            par2 = 0;
        }

        return this.iconArray[par2];
    }

    @Override
    public int damageDropped(int par1) {
        return par1;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IconRegister par1IconRegister) {
        this.iconArray = new Icon[woodTextureTypes.length];

        for (int i = 0; i < this.iconArray.length; ++i) {
            this.iconArray[i] = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + woodTextureTypes[i]);
        }
    }
}
