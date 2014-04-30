package carboniferous.block;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import carboniferous.CarboniferousMod;
import carboniferous.api.CarboniferousApi;
import carboniferous.api.Properties;
import carboniferous.core.teleporters.TeleportClient;
import carboniferous.world.TeleporterCarboniferous;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * @author ProPercivalalb
 **/
public class BlockPortal extends BlockBreakable {
	
	private IIcon portalStillIcon;
	
	public BlockPortal(String par2Str) {
		super(par2Str, Material.portal, false);
		this.setCreativeTab(null);
	}

	@Override
	public void onEntityCollidedWithBlock(World world, int i, int j, int k, Entity entity)
	{
		 Side side = FMLCommonHandler.instance().getEffectiveSide();
	     if(side == Side.SERVER) {
	    	 if (entity.ridingEntity == null && entity.riddenByEntity == null && entity instanceof EntityPlayerMP) {
	    		 EntityPlayerMP player = (EntityPlayerMP)entity;
	    		 CarboniferousMod.INSTANCE.serverTeleport.getPlayer(player.getCommandSenderName()).setInPortal();	        	 
	 	  		((EntityPlayer)entity).addPotionEffect(new PotionEffect(Potion.confusion.id, 65, 0, true));  
	    	 }
	     }
	  	 else if (side == Side.CLIENT && entity instanceof EntityPlayer) {
	  		TeleportClient.setInPortal();   	
	  	 }
	     
	     if(!(entity instanceof EntityPlayer) && side == Side.SERVER) {
	    	 byte dimension = (byte)Properties.dimensionID;
             if (entity.dimension == Properties.dimensionID) {
            	 dimension = 0;
             }
             this.travelToDimension(world, entity, dimension);
	    	 
	     }
	}

	public void travelToDimension(World worldObj, Entity entity, int par1)
    {
        if (!worldObj.isRemote && !entity.isDead)
        {
            worldObj.theProfiler.startSection("changeDimension");
            MinecraftServer minecraftserver = MinecraftServer.getServer();
            int j = entity.dimension;
            WorldServer worldserver = minecraftserver.worldServerForDimension(j);
            WorldServer worldserver1 = minecraftserver.worldServerForDimension(par1);
            entity.dimension = par1;
            entity.worldObj.removeEntity(entity);
            entity.isDead = false;
            entity.worldObj.theProfiler.startSection("reposition");
            minecraftserver.getConfigurationManager().transferEntityToWorld(entity, j, worldserver, worldserver1, new TeleporterCarboniferous(worldserver1));
            entity.worldObj.theProfiler.endStartSection("reloading");
            Entity entity1 = EntityList.createEntityByName(EntityList.getEntityString(entity), worldserver1);

            if (entity1 != null)
            {
                entity1.copyDataFrom(entity, true);
                worldserver1.spawnEntityInWorld(entity1);
            }

            entity.isDead = true;
            worldObj.theProfiler.endSection();
            worldserver.resetUpdateEntityTick();
            worldserver1.resetUpdateEntityTick();
            worldObj.theProfiler.endSection();
        }
    }
	
	public List canTeleportFromDimension() {
	      ArrayList arraylist = new ArrayList();
	      arraylist.add(Integer.valueOf(0));//player can teleport from overworld to this dimension
	      arraylist.add(Integer.valueOf(-1));//player can teleport from Nether to this dimension
	      return arraylist;
	}

	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
		return null;
	}
	
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4) {
	    return null;
	}
		
	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
		
	@SideOnly(Side.CLIENT)
	@Override
	public int getRenderBlockPass() {
	    return 1;
	}
	
	@Override
	public int quantityDropped(Random par1Random) {
	    return 0;
	}
		
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random) {
	    for (int var6 = 0; var6 < 4; ++var6) {
	        double var7 = (double)((float)par2 + par5Random.nextFloat());
	        double var9 = (double)((float)par3 + par5Random.nextFloat());
	        double var11 = (double)((float)par4 + par5Random.nextFloat());
	        double var13 = 0.0D;
	        double var15 = 0.0D;
	        double var17 = 0.0D;
	        int var19 = par5Random.nextInt(2) * 2 - 1;
	        var13 = ((double)par5Random.nextFloat() - 0.5D) * 0.5D;
	        var15 = ((double)par5Random.nextFloat() - 0.5D) * 0.5D;
	        var17 = ((double)par5Random.nextFloat() - 0.5D) * 0.5D;

	        if (par1World.getBlock(par2 - 1, par3, par4) != this && par1World.getBlock(par2 + 1, par3, par4) != this) {
	            var7 = (double)par2 + 0.5D + 0.25D * (double)var19;
	            var13 = (double)(par5Random.nextFloat() * 2.0F * (float)var19);
	        }
	        else {
	            var11 = (double)par4 + 0.5D + 0.25D * (double)var19;
	            var17 = (double)(par5Random.nextFloat() * 2.0F * (float)var19);
	        }

	        String particle = "smoke";

	        par1World.spawnParticle(particle, var7, var9, var11, var13, var15, var17);
	    }
	}
		
	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		this.blockIcon = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "portal");
		this.portalStillIcon = par1IconRegister.registerIcon(Properties.TEX_PACkAGE + "portal_still");
	}
	
	@Override
	public IIcon getIcon(int par1, int par2) {
	    return this.blockIcon;
	}
}
