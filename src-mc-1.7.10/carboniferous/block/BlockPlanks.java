package carboniferous.block;

import carboniferous.api.Properties;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

/**
 * @author ProPercivalalb
 **/
public class BlockPlanks extends Block {
    
    public static final String[] woodTextureTypes = new String[] {"plankLepidodendron", "plankCalamites", "plankCordaites", "plankSigillaria"};
    @SideOnly(Side.CLIENT)
    private IIcon[] iconArray;

    public BlockPlanks() {
        super(Material.wood);
        this.setCreativeTab(null);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int side, int meta) {
        if (meta < 0 || meta >= this.iconArray.length) {
            meta = 0;
        }

        return this.iconArray[meta];
    }

    @Override
    public int damageDropped(int par1) {
        return par1;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister par1IconRegister) {
        this.iconArray = new IIcon[woodTextureTypes.length];

        for (int i = 0; i < this.iconArray.length; ++i) {
            this.iconArray[i] = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + woodTextureTypes[i]);
        }
    }
}
