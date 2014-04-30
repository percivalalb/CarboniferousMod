package carboniferous.block;

import java.util.Random;

import carboniferous.api.Properties;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.BlockSand;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

/**
 * @author ProPercivalalb
 **/
public class BlockCarboniferousSand extends BlockSand {

    public BlockCarboniferousSand() {
        super();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata) {
       return this.blockIcon;
    }
	
    @Override
	@SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(Properties.TEX_PACkAGE + "sand");
	}
}
