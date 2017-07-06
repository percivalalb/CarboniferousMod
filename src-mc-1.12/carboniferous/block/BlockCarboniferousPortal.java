package carboniferous.block;

import carboniferous.Carboniferous;
import carboniferous.teleporters.TeleportClient;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.BlockPortal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockCarboniferousPortal extends BlockBreakable {

	public BlockCarboniferousPortal() {
        super(Material.PORTAL, false);
        this.setSoundType(SoundType.GLASS);
    }
	
	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
		 Side side = FMLCommonHandler.instance().getEffectiveSide();
	     if(side == Side.SERVER) {
	    	if(!entityIn.isRiding() && !entityIn.isBeingRidden() && entityIn instanceof EntityPlayerMP) {
	    		EntityPlayerMP player = (EntityPlayerMP)entityIn;
	    		Carboniferous.PROXY.SERVER_TELEPORT.getPlayer(player.getUniqueID()).setInPortal();	        	 
	 	  		((EntityPlayer)entityIn).addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 65, 0, true, false));  
	    	}
	     }
	  	 else if (side == Side.CLIENT && entityIn instanceof EntityPlayer) {
	  		TeleportClient.INSTANCE.setInPortal();   	
	  	 }
	}
	
	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
        return NULL_AABB;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.TRANSLUCENT;
	}
	
	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess p_193383_1_, IBlockState p_193383_2_, BlockPos pos, EnumFacing facing) {
		return BlockFaceShape.UNDEFINED;
	}
}
