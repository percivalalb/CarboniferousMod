package carboniferous.block;

import java.util.Random;

import carboniferous.api.Properties;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.BlockSand;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityFallingSand;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

/**
 * @author ProPercivalalb
 **/
public class BlockCarboniferousSand extends BlockSand {

    public BlockCarboniferousSand(int par1) {
        super(par1, Material.sand);
    }

    @Override
    protected void onStartFalling(EntityFallingSand par1EntityFallingSand) {}

    @Override
    public int tickRate(World par1World) {
        return 2;
    }

    @Override
    public void onFinishFalling(World par1World, int par2, int par3, int par4, int par5) {}
    
    @SideOnly(Side.CLIENT)
    @Override
    public Icon getIcon(int side, int metadata) {
       return this.blockIcon;
    }
	
	@SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IconRegister par1IconRegister) {
		this.blockIcon = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "sand");
	}
}
