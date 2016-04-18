package carboniferous.block;

import java.util.Random;

import carboniferous.api.Properties;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

/**
 * @author ProPercivalalb
 **/
public class BlockMultipleBlocks3 extends Block {
  
	public static IIcon meteoriteBlock;
	public static IIcon meteoriteLightOre;
	public static IIcon meteoriteRedOre;
	public static IIcon basaltEncrustedDiamond;
	public static IIcon graniteCoal;
	
	public BlockMultipleBlocks3() {
        super(Material.rock);
        this.setCreativeTab(null);
    }
	
	@Override
	public float getBlockHardness(World par1World, int par2, int par3, int par4) {
		int meta = par1World.getBlockMetadata(par2, par3, par4);
		return super.getBlockHardness(par1World, par2, par3, par4);
    }
	
	@Override
	public float getExplosionResistance(Entity par1Entity, World world, int x, int y, int z, double explosionX, double explosionY, double explosionZ) {
		int meta = world.getBlockMetadata(x, y, z);
		if(meta == 0 || meta == 1 || meta == 2) {
			return 1000.0F * 3.0F;
		}
		return super.getExplosionResistance(par1Entity, world, x, y, z, explosionX, explosionY, explosionZ);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
    public IIcon getIcon(int side, int meta) {
		switch(meta) {
		case 0: return this.meteoriteBlock;
		case 1: return this.meteoriteLightOre;
		case 2: return this.meteoriteRedOre;
		case 3: return this.basaltEncrustedDiamond;
		case 4: return this.graniteCoal;
		default: return null;
		}
    }
    
    public void registerBlockIcons(IIconRegister par1IconRegister) {
    	//Granite
        this.meteoriteBlock = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "meteoriteBlock"); //0
        this.meteoriteLightOre = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "meteoriteLightOre"); //1
        this.meteoriteRedOre = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "meteoriteRedOre"); //2
        this.basaltEncrustedDiamond = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "basaltEncrustedDiamond"); //3
        this.graniteCoal = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "oreCoal"); //3
    }
    
    @Override
    public int damageDropped(int meta) {
    	if(meta == 3 || meta == 4)
    		return 0;
    	
    	return meta;
    }

    @Override
    public Item getItemDropped(int meta, Random random, int fortune) {
    	if(meta == 3)
    		return Items.diamond;
    	
    	if(meta == 4)
    		return Items.coal;
    	
    	return super.getItemDropped(meta, random, fortune);
    }
    
    @Override
    public boolean canSilkHarvest(World world, EntityPlayer player, int x, int y, int z, int metadata) {
    	return true;
    }
}
