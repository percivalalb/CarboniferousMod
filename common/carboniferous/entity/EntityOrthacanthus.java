package carboniferous.entity;

import java.util.List;
import java.util.Random;

import carboniferous.ModItems;
import carboniferous.api.Properties;
import carboniferous.core.helper.SideHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;

public class EntityOrthacanthus extends EntityWaterMob 
{
	private int outOfWaterTime;
	private boolean diving;
	private int divingCount;

	public EntityOrthacanthus(World world) {
		super(world);
		this.outOfWaterTime = 0;
		this.setSize(1.25F, 0.9F);
	}
	
	public float updateRotation(float f, float f1, float f2) {
		float f3 = f1;
		for (f3 = f1 - f; f3 < -180.0F; f3 += 360.0F);
		while (f3 >= 180.0F) f3 -= 360.0F;

		if (f3 > f2) {
			f3 = f2;
		}
		if (f3 < -f2) {
			f3 = -f2;
		}
		return f + f3;
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(36.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(0.14D);
	}
	
	@Override
	protected boolean canDespawn() {
		return true;
	}

	@Override
	protected void playStepSound(int par1, int par2, int par3, int par4) {}

	@Override
  	protected void fall(float f) {}

  	@Override
  	public boolean handleWaterMovement() {
  		return this.worldObj.handleMaterialAcceleration(this.boundingBox, Material.water, this);
  	}

  	@Override
  	public void moveEntityWithHeading(float f, float f1) {
  		super.moveEntityWithHeading(f, f1);
  		this.prevLimbSwingAmount = this.limbSwingAmount;
  		double d2 = this.posX - this.prevPosX;
  		double d3 = this.posZ - this.prevPosZ;
  		float f4 = MathHelper.sqrt_double(d2 * d2 + d3 * d3) * 4.0F;
  		if (f4 > 1.0F) f4 = 1.0F;
  		this.limbSwingAmount += (f4 - this.limbSwingAmount) * 0.4F;
  		this.limbSwing += this.limbSwingAmount;
  	}

  	@Override
  	public boolean isInWater() {
  		return isInsideOfMaterial(Material.water);
  	}

  	@Override
  	public boolean canBreatheUnderwater() {
  		return true;
  	}
  	
  	@Override
  	protected void jump() {}

  	public void floating() {
  		float distanceY = this.distanceToSurface();
  		if (this.entityToAttack != null && !this.entityToAttack.isInWater()) {
  			this.entityToAttack = null;
  		}
  		
  		if (this.entityToAttack != null && this.entityToAttack.posY < this.posY - 0.5D && getDistanceToEntity(this.entityToAttack) < 10.0F) {
  			if (this.motionY < -0.1D) {
  				this.motionY = -0.1D;
  			}
  			return;
  		}

  		if (distanceY < 1.0F || this.diving) {
  			if (this.motionY < -0.05D) {
  				this.motionY = -0.05D;
  			}

  		}
  		else {
  			if (this.motionY < 0.0D) {
  				this.motionY = 0.0D;
  			}
  			this.motionY += 0.001D;

  			if (distanceY > 1.0F) {
  				this.motionY += distanceY * 0.02D;
  				if (this.motionY > 0.2D) {
  					this.motionY = 0.2D;
  				}
  			}
  		}
  	}

  	@Override
  	protected boolean isMovementCeased() {
  		return ((!isSwimming()) && (this.riddenByEntity == null)) || (this.riddenByEntity != null);
  	}

  	@Override
  	public void onLivingUpdate() {
  		if (isSwimming()) {
  			floating();
  			this.outOfWaterTime = 0;
  		}
  		else {
  			this.outOfWaterTime += 1;
  			if (this.outOfWaterTime > 10) {
  				setPathToEntity(null);
  			}
  			if ((this.outOfWaterTime > 200) && (this.outOfWaterTime % 30 == 0)) {
  				this.motionY += 0.3D;
  				this.motionX = ((float)(Math.random() * 0.2D - 0.1D));
  				this.motionZ = ((float)(Math.random() * 0.2D - 0.1D));
  				attackEntityFrom(DamageSource.generic, 1);
  			}
  		}

  		if (!hasPath() && this.riddenByEntity == null && !isMovementCeased() && this.entityToAttack == null) {
  			updateWanderPath();
  		}

  		if (!this.diving) {
  			if (this.riddenByEntity == null && this.entityToAttack == null && hasPath() && this.rand.nextInt(700) == 0) {
  				this.diving = true;
  			}

  		}
  		else {
  			this.divingCount += 1;
  			if ((this.divingCount > 100) || (this.riddenByEntity != null)) {
  				this.diving = false;
  				this.divingCount = 0;
  			}
  		}
  		super.onLivingUpdate();
  	}

  	@Override
  	protected void despawnEntity() {
  		EntityPlayer var1 = this.worldObj.getClosestPlayerToEntity(this, -1.0D);
  		if (var1 != null) {
  			double var2 = var1.posX - this.posX;
  			double var4 = var1.posY - this.posY;
  			double var6 = var1.posZ - this.posZ;
  			double var8 = var2 * var2 + var4 * var4 + var6 * var6;

  			if (canDespawn() && var8 > 16384.0D) {
  				setDead();
  			}

  			if (this.entityAge > 2000 && this.rand.nextInt(800) == 0 && var8 > 1024.0D && canDespawn()) {
  				setDead();
  			}
  			else if (var8 < 1024.0D) {
  				this.entityAge = 0;
  			}
  		}
  	}
  
  	public boolean isSwimming() {
  		return isInsideOfMaterial(Material.water);
  	}
  	
  	public float distanceToSurface() {
  		int i = MathHelper.floor_double(this.posX);
  		int j = MathHelper.floor_double(this.posY);
  		int k = MathHelper.floor_double(this.posZ);
  		int l = this.worldObj.getBlockId(i, j, k);
  		if ((l != 0) && (Block.blocksList[l].blockMaterial == Material.water)) {
  			for (int x = 1; x < 64; x++) {
  				l = this.worldObj.getBlockId(i, j + x, k);
  				if ((l == 0) || (Block.blocksList[l].blockMaterial != Material.water)) {
  					return x;
  				}
  			}
  		}

      	return 0.0F;
    }
  	
  	@Override
    protected void dropFewItems(boolean recentlyHitByPlayer, int looting) {
        int toothCount = this.rand.nextInt(3 + looting) + 1;
        int fishCount = this.rand.nextInt(3) + (looting / 2);

        for (int k = 0; k < toothCount; ++k) {
            this.entityDropItem(new ItemStack(ModItems.multiItems, 1, 11), 0.0F);
        }
        for (int k = 0; k < fishCount; ++k) {
            this.entityDropItem(new ItemStack(Item.fishRaw, 1, 0), 0.0F);
        }
    }
  	
  	@Override
  	protected Entity findPlayerToAttack() {
  		if (this.worldObj.difficultySetting > 0) {
  			EntityPlayer entityplayer = this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0D);
  			if (entityplayer != null && entityplayer.isInWater()) {
  				return entityplayer;
  			}
  		}
  		return null;
    }
  	
  	@Override
  	protected void attackEntity(Entity entity, float f) {
  	    if ((entity.isInsideOfMaterial(Material.water)) && (f < 3.5D) && (entity.boundingBox.maxY > this.boundingBox.minY) && (entity.boundingBox.minY < this.boundingBox.maxY)) {
  	    	if (((entity instanceof EntityPlayer)) && (((EntityPlayer)entity).ridingEntity != null)) {
  	    		Entity playerMount = ((EntityPlayer)entity).ridingEntity;
  	    		if (playerMount instanceof EntityBoat) {
  	    			return;
  	    		}
  	      }
  	      this.attackTime = 20;
  	      entity.attackEntityFrom(DamageSource.causeMobDamage(this), 4);
  	    }
  	}
  	
  	 @Override
     public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
         super.writeEntityToNBT(par1NBTTagCompound);
         par1NBTTagCompound.setInteger("outOfWater", this.outOfWaterTime);
     }

     @Override
     public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
         super.readEntityFromNBT(par1NBTTagCompound);
         this.outOfWaterTime = par1NBTTagCompound.getInteger("outOfWater");
     }
     
     @Override
     public boolean getCanSpawnHere() {
         return this.posY > 45.0D && this.posY < 63.0D && super.getCanSpawnHere() && this.isSwimming();
     }
}