package carboniferous.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import carboniferous.CarboniferousMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatBase;
import net.minecraft.stats.StatList;
import net.minecraft.util.Facing;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemMobSpawner extends Item {
	
	public static HashMap<Integer, EntityEggInfo> entityEggs = new LinkedHashMap<Integer, EntityEggInfo>();
    @SideOnly(Side.CLIENT)
    private IIcon theIcon;

    public static class EntityEggInfo {
          
    	public final Class<Entity> entityClass;
    	private String id;
    	public final int primaryColor;
    	public final int secondaryColor;

    	public EntityEggInfo(Class<Entity> entityClass, String id, int primaryColor, int secondaryColor) {
    		this.entityClass = entityClass;
    		this.id = id;
    		this.primaryColor = primaryColor;
    		this.secondaryColor = secondaryColor;
    	}
          
    	public Entity createEntityByID(World world) {
    		Entity entity = null;

    		try {
    			if(this.entityClass != null)
    				entity = (Entity)this.entityClass.getConstructor(new Class[] {World.class}).newInstance(new Object[] {world});
    		}
    		catch (Exception e) {
    			e.printStackTrace();
    		}

    		return entity;
    	}
		}
	
    public ItemMobSpawner() {
        this.setHasSubtypes(true);
        this.setTextureName("spawn_egg");
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack) {
        String s = ("" + StatCollector.translateToLocal(this.getUnlocalizedName() + ".name")).trim();
        String s1 = entityEggs.containsKey(stack.getItemDamage()) ? entityEggs.get(stack.getItemDamage()).id : null;

        if (s1 != null)
        {
            s = s + " " + StatCollector.translateToLocal("entity." + s1 + ".name");
        }

        return s;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getColorFromItemStack(ItemStack stack, int renderPass)  {
        EntityEggInfo entityegginfo = (EntityEggInfo)entityEggs.get(stack.getItemDamage());
        return entityegginfo != null ? (renderPass == 0 ? entityegginfo.primaryColor : entityegginfo.secondaryColor) : 16777215;
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World worl, int x, int y, int z, int face, float xHit, float yHit, float zHit) {
        if (worl.isRemote)
            return true;
        else {
            Block block = worl.getBlock(x, y, z);
            x += Facing.offsetsXForSide[face];
            y += Facing.offsetsYForSide[face];
            z += Facing.offsetsZForSide[face];

            if (face == 1 && block.getRenderType() == 11)
                y += 0.5D;


            Entity entity = spawnCreature(worl, stack.getItemDamage(), (double)x + 0.5D, (double)y, (double)z + 0.5D);

            if (entity != null) {
                if (entity instanceof EntityLivingBase && stack.hasDisplayName())
                    ((EntityLiving)entity).setCustomNameTag(stack.getDisplayName());

                if (!player.capabilities.isCreativeMode)
                    --stack.stackSize;

            }

            return true;
        }
    }
    
    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        if (world.isRemote)
            return stack;
        else {
            MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(world, player, true);

            if (movingobjectposition == null)
                return stack;
            else {
                if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
                    int x = movingobjectposition.blockX;
                    int y = movingobjectposition.blockY;
                    int z = movingobjectposition.blockZ;

                    if(!world.canMineBlock(player, x, y, z))
                        return stack;

                    if(!player.canPlayerEdit(x, y, z, movingobjectposition.sideHit, stack))
                        return stack;

                    if(world.getBlock(x, y, z) instanceof BlockLiquid) {
                        Entity entity = spawnCreature(world, stack.getItemDamage(), (double)x, (double)y, (double)z);

                        if(entity != null) {
                            if(entity instanceof EntityLivingBase && stack.hasDisplayName())
                                ((EntityLiving)entity).setCustomNameTag(stack.getDisplayName());

                            if(!player.capabilities.isCreativeMode)
                                --stack.stackSize;
                        }
                    }
                }

                return stack;
            }
        }
    }
    
    public static Entity spawnCreature(World world, int id, double x, double y, double z) {
        if (!entityEggs.containsKey(id))
            return null;
        else {
            Entity entity = null;

            for (int j = 0; j < 1; ++j) {
                entity = entityEggs.get(id).createEntityByID(world);

                if (entity != null && entity instanceof EntityLivingBase) {
                    EntityLiving entityliving = (EntityLiving)entity;
                    entity.setLocationAndAngles(x, y, z, MathHelper.wrapAngleTo180_float(world.rand.nextFloat() * 360.0F), 0.0F);
                    entityliving.rotationYawHead = entityliving.rotationYaw;
                    entityliving.renderYawOffset = entityliving.rotationYaw;
                    entityliving.onSpawnWithEgg((IEntityLivingData)null);
                    world.spawnEntityInWorld(entity);
                    entityliving.playLivingSound();
                }
            }

            return entity;
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean requiresMultipleRenderPasses() {
        return true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamageForRenderPass(int meta, int renderPass) {
        return renderPass > 0 ? this.theIcon : super.getIconFromDamageForRenderPass(meta, renderPass);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        super.registerIcons(iconRegister);
        this.theIcon = iconRegister.registerIcon(this.getIconString() + "_overlay");
    }
}