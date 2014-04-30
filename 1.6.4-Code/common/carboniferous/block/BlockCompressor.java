package carboniferous.block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import carboniferous.CarboniferousMod;
import carboniferous.api.CarboniferousApi;
import carboniferous.api.Properties;
import carboniferous.tileentity.TileEntityCompressor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

/**
 * @author ProPercivalalb
 **/
public class BlockCompressor extends BlockTileEntity {

	public static IIcon iconSideGrinder;
	
	public BlockCompressor(int par1) {
		super(par1, Material.rock);
		this.setCreativeTab(null);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityCompressor();
	}

	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
        if (par1World.isRemote) {
            return true;
        }
        else {
            TileEntityCompressor tileentitygrinder = (TileEntityCompressor)par1World.getBlockTileEntity(par2, par3, par4);

            if (tileentitygrinder != null) {
                par5EntityPlayer.openGui(CarboniferousMod.instance, Properties.GUI_ID_COMPRESSER, par1World, par2, par3, par4);
            }

            return true;
        }
    }
	
	@SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int side, int metadata) {
       if(side == 1) {
    	   return this.blockIcon;
       }
       return this.iconSideGrinder;
    }
	
	@SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IconRegister par1IconRegister) {
        this.blockIcon = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "topGrinder");
        this.iconSideGrinder = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "sideGrinder");
    }

	@Override
	public int getRenderType() {
	    return Properties.RENDER_GRINDER;
	}
	
	@Override
    public boolean isOpaqueCube() {
        return false;
    }

	@Override
    public boolean renderAsNormalBlock() {
        return false;
    }
	
	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLiving par5EntityLiving, ItemStack par6ItemStack) {
		super.onBlockPlacedBy(par1World, par2, par3, par4, par5EntityLiving, par6ItemStack);
		int l = MathHelper.floor_double((double)(par5EntityLiving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

	    if (l == 0) {
	        par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2);
	    }

	    if (l == 1) {
	        par1World.setBlockMetadataWithNotify(par2, par3, par4, 5, 2);
	    }

	    if (l == 2) {
	        par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 2);
	    }

	    if (l == 3) {
	        par1World.setBlockMetadataWithNotify(par2, par3, par4, 4, 2);
	    }
	}
}
