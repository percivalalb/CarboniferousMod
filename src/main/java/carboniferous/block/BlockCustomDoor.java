package carboniferous.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;

import carboniferous.ModItems;
import carboniferous.api.Properties;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.IconFlipped;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCustomDoor extends Block {
	
    private static final String[] doorBottomIconNames = new String[] {"doorLepido_lower", "doorLepido_upper",
    																  "doorCalamites_lower", "doorCalamites_upper",
    																  "doorCordaites_lower", "doorCordaites_upper",
    																  "doorSigilaria_lower", "doorSigilaria_upper",
    																  "amphibianDoor_lower", "amphibianDoor_upper"};
    
    /** Used for pointing at IIcon names. */
    private final int doorTypeForIcon;
    @SideOnly(Side.CLIENT)
    private IIcon[] iconArray;

    public BlockCustomDoor(int doorType) {
        super(Material.wood);
        this.doorTypeForIcon = doorType * 2;	
        this.disableStats();
        float f = 0.5F;
        float f1 = 1.0F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f1, 0.5F + f);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int par1, int par2) {
        return this.iconArray[this.doorTypeForIcon];
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) {
        if (par5 != 1 && par5 != 0) {
            int i1 = this.getFullMetadata(par1IBlockAccess, par2, par3, par4);
            int j1 = i1 & 3;
            boolean flag = (i1 & 4) != 0;
            boolean flag1 = false;
            boolean flag2 = (i1 & 8) != 0;

            if (flag)
            {
                if (j1 == 0 && par5 == 2)
                {
                    flag1 = !flag1;
                }
                else if (j1 == 1 && par5 == 5)
                {
                    flag1 = !flag1;
                }
                else if (j1 == 2 && par5 == 3)
                {
                    flag1 = !flag1;
                }
                else if (j1 == 3 && par5 == 4)
                {
                    flag1 = !flag1;
                }
            }
            else
            {
                if (j1 == 0 && par5 == 5)
                {
                    flag1 = !flag1;
                }
                else if (j1 == 1 && par5 == 3)
                {
                    flag1 = !flag1;
                }
                else if (j1 == 2 && par5 == 4)
                {
                    flag1 = !flag1;
                }
                else if (j1 == 3 && par5 == 2)
                {
                    flag1 = !flag1;
                }

                if ((i1 & 16) != 0)
                {
                    flag1 = !flag1;
                }
            }

            return this.iconArray[this.doorTypeForIcon + (flag1 ? doorBottomIconNames.length : 0) + (flag2 ? 1 : 0)];
        }
        else
        {
            return this.iconArray[this.doorTypeForIcon];
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister par1IconRegister) {
        this.iconArray = new IIcon[doorBottomIconNames.length * 2];

        for (int i = 0; i < doorBottomIconNames.length; ++i) {
            this.iconArray[i] = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + doorBottomIconNames[i]);
            this.iconArray[i + doorBottomIconNames.length] = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + doorBottomIconNames[i]);
        }
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean getBlocksMovement(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
        int l = this.getFullMetadata(par1IBlockAccess, par2, par3, par4);
        return (l & 4) != 0;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public int getRenderType() {
        return 7;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World par1World, int par2, int par3, int par4) {
        this.setBlockBoundsBasedOnState(par1World, par2, par3, par4);
        return super.getSelectedBoundingBoxFromPool(par1World, par2, par3, par4);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4) {
        this.setBlockBoundsBasedOnState(par1World, par2, par3, par4);
        return super.getCollisionBoundingBoxFromPool(par1World, par2, par3, par4);
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
        this.setDoorRotation(this.getFullMetadata(par1IBlockAccess, par2, par3, par4));
    }

    public int getDoorOrientation(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
        return this.getFullMetadata(par1IBlockAccess, par2, par3, par4) & 3;
    }

    public boolean isDoorOpen(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
        return (this.getFullMetadata(par1IBlockAccess, par2, par3, par4) & 4) != 0;
    }

    private void setDoorRotation(int par1) {
        float f = 0.1875F;
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F);
        int j = par1 & 3;
        boolean flag = (par1 & 4) != 0;
        boolean flag1 = (par1 & 16) != 0;

        if (j == 0) {
            if (flag) {
                if (!flag1) {
                    this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
                }
                else {
                    this.setBlockBounds(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
                }
            }
            else {
                this.setBlockBounds(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
            }
        }
        else if (j == 1) {
            if (flag) {
                if (!flag1) {
                    this.setBlockBounds(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
                }
                else {
                    this.setBlockBounds(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
                }
            }
            else {
                this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
            }
        }
        else if (j == 2) {
            if (flag)
            {
                if (!flag1)
                {
                    this.setBlockBounds(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
                }
                else
                {
                    this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
                }
            }
            else
            {
                this.setBlockBounds(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            }
        }
        else if (j == 3)
        {
            if (flag)
            {
                if (!flag1)
                {
                    this.setBlockBounds(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
                }
                else
                {
                    this.setBlockBounds(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
                }
            }
            else
            {
                this.setBlockBounds(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
            }
        }
    }
    
    public void func_150014_a(World p_150014_1_, int p_150014_2_, int p_150014_3_, int p_150014_4_, boolean p_150014_5_)
    {
        int l = this.getFullMetadata(p_150014_1_, p_150014_2_, p_150014_3_, p_150014_4_);
        boolean flag1 = (l & 4) != 0;

        if (flag1 != p_150014_5_)
        {
            int i1 = l & 7;
            i1 ^= 4;

            if ((l & 8) == 0)
            {
                p_150014_1_.setBlockMetadataWithNotify(p_150014_2_, p_150014_3_, p_150014_4_, i1, 2);
                p_150014_1_.markBlockRangeForRenderUpdate(p_150014_2_, p_150014_3_, p_150014_4_, p_150014_2_, p_150014_3_, p_150014_4_);
            }
            else
            {
                p_150014_1_.setBlockMetadataWithNotify(p_150014_2_, p_150014_3_ - 1, p_150014_4_, i1, 2);
                p_150014_1_.markBlockRangeForRenderUpdate(p_150014_2_, p_150014_3_ - 1, p_150014_4_, p_150014_2_, p_150014_3_, p_150014_4_);
            }

            p_150014_1_.playAuxSFXAtEntity((EntityPlayer)null, 1003, p_150014_2_, p_150014_3_, p_150014_4_, 0);
        }
    }

    @Override
    public void onBlockClicked(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer) {}

    @Override
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
        if (this.blockMaterial == Material.iron)
        {
            return false; //Allow items to interact with the door
        }
        else
        {
            int i1 = this.getFullMetadata(par1World, par2, par3, par4);
            int j1 = i1 & 7;
            j1 ^= 4;

            if ((i1 & 8) == 0)
            {
                par1World.setBlockMetadataWithNotify(par2, par3, par4, j1, 2);
                par1World.markBlockRangeForRenderUpdate(par2, par3, par4, par2, par3, par4);
            }
            else
            {
                par1World.setBlockMetadataWithNotify(par2, par3 - 1, par4, j1, 2);
                par1World.markBlockRangeForRenderUpdate(par2, par3 - 1, par4, par2, par3, par4);
            }

            par1World.playAuxSFXAtEntity(par5EntityPlayer, 1003, par2, par3, par4, 0);
            return true;
        }
    }

    public void onPoweredBlockChange(World par1World, int par2, int par3, int par4, boolean par5){
        int l = this.getFullMetadata(par1World, par2, par3, par4);
        boolean flag1 = (l & 4) != 0;

        if (flag1 != par5)
        {
            int i1 = l & 7;
            i1 ^= 4;

            if ((l & 8) == 0)
            {
                par1World.setBlockMetadataWithNotify(par2, par3, par4, i1, 2);
                par1World.markBlockRangeForRenderUpdate(par2, par3, par4, par2, par3, par4);
            }
            else
            {
                par1World.setBlockMetadataWithNotify(par2, par3 - 1, par4, i1, 2);
                par1World.markBlockRangeForRenderUpdate(par2, par3 - 1, par4, par2, par3, par4);
            }

            par1World.playAuxSFXAtEntity((EntityPlayer)null, 1003, par2, par3, par4, 0);
        }
    }

    @Override
    public void onNeighborBlockChange(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_)
    {
        int l = p_149695_1_.getBlockMetadata(p_149695_2_, p_149695_3_, p_149695_4_);

        if ((l & 8) == 0)
        {
            boolean flag = false;

            if (p_149695_1_.getBlock(p_149695_2_, p_149695_3_ + 1, p_149695_4_) != this)
            {
                p_149695_1_.setBlockToAir(p_149695_2_, p_149695_3_, p_149695_4_);
                flag = true;
            }

            if (!World.doesBlockHaveSolidTopSurface(p_149695_1_, p_149695_2_, p_149695_3_ - 1, p_149695_4_))
            {
                p_149695_1_.setBlockToAir(p_149695_2_, p_149695_3_, p_149695_4_);
                flag = true;

                if (p_149695_1_.getBlock(p_149695_2_, p_149695_3_ + 1, p_149695_4_) == this)
                {
                    p_149695_1_.setBlockToAir(p_149695_2_, p_149695_3_ + 1, p_149695_4_);
                }
            }

            if (flag)
            {
                if (!p_149695_1_.isRemote)
                {
                    this.dropBlockAsItem(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_, l, 0);
                }
            }
            else
            {
                boolean flag1 = p_149695_1_.isBlockIndirectlyGettingPowered(p_149695_2_, p_149695_3_, p_149695_4_) || p_149695_1_.isBlockIndirectlyGettingPowered(p_149695_2_, p_149695_3_ + 1, p_149695_4_);

                if ((flag1 || p_149695_5_.canProvidePower()) && p_149695_5_ != this)
                {
                    this.func_150014_a(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_, flag1);
                }
            }
        }
        else
        {
            if (p_149695_1_.getBlock(p_149695_2_, p_149695_3_ - 1, p_149695_4_) != this)
            {
                p_149695_1_.setBlockToAir(p_149695_2_, p_149695_3_, p_149695_4_);
            }

            if (p_149695_5_ != this)
            {
                this.onNeighborBlockChange(p_149695_1_, p_149695_2_, p_149695_3_ - 1, p_149695_4_, p_149695_5_);
            }
        }
    }

    @Override
    public Item getItemDropped(int par1, Random par2Random, int par3) {
       if((par1 & 8) != 0) return null;
       return ModItems.multiItems;	
    }
    
    @Override
    public int damageDropped(int meta) {
    	if((meta & 8) != 0) return 0;
    	switch(this.doorTypeForIcon) {
        case 0: return 0;
        case 2: return 14;
        case 4: return 15;
        case 6: return 16;
        case 8: return 17;
        default: return 0;
        } 	
    }

    @Override
    public MovingObjectPosition collisionRayTrace(World par1World, int par2, int par3, int par4, Vec3 par5Vec3, Vec3 par6Vec3) {
        this.setBlockBoundsBasedOnState(par1World, par2, par3, par4);
        return super.collisionRayTrace(par1World, par2, par3, par4, par5Vec3, par6Vec3);
    }

    @Override
    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4) {
        return par3 >= 255 ? false : World.doesBlockHaveSolidTopSurface(par1World, par2, par3 - 1, par4) && super.canPlaceBlockAt(par1World, par2, par3, par4) && super.canPlaceBlockAt(par1World, par2, par3 + 1, par4);
    }

    @Override
    public int getMobilityFlag() {
        return 1;
    }

    public int getFullMetadata(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
        int l = par1IBlockAccess.getBlockMetadata(par2, par3, par4);
        boolean flag = (l & 8) != 0;
        int i1;
        int j1;

        if (flag)
        {
            i1 = par1IBlockAccess.getBlockMetadata(par2, par3 - 1, par4);
            j1 = l;
        }
        else
        {
            i1 = l;
            j1 = par1IBlockAccess.getBlockMetadata(par2, par3 + 1, par4);
        }

        boolean flag1 = (j1 & 1) != 0;
        return i1 & 7 | (flag ? 8 : 0) | (flag1 ? 16 : 0);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public Item getItem(World par1World, int par2, int par3, int par4) {
    	 return ModItems.multiItems;	
    }

    @Override
    public void onBlockHarvested(World par1World, int par2, int par3, int par4, int par5, EntityPlayer par6EntityPlayer) {
        if (par6EntityPlayer.capabilities.isCreativeMode && (par5 & 8) != 0 && par1World.getBlock(par2, par3 - 1, par4) == this) {
            par1World.setBlockToAir(par2, par3 - 1, par4);
        }
    }
}
