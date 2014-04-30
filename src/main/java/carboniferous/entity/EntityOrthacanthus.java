package carboniferous.entity;

import java.util.List;
import java.util.Random;

import carboniferous.ModItems;
import carboniferous.api.Properties;
import carboniferous.core.helper.LogHelper;
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
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;

/**
 * @author ProPercivalalb
 **/
public class EntityOrthacanthus extends EntityWaterMob {

	private boolean diving;
	private int divingCount;
	
	public EntityOrthacanthus(World world) {
		super(world);
		this.setSize(1.25F, 0.9F);
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(36.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.34D);
	}
	
	@Override
	public boolean isAIEnabled() {
		return true;
	}
	
	@Override
    public boolean isInWater() {
        return this.worldObj.handleMaterialAcceleration(this.boundingBox.expand(0.0D, -0.6000000238418579D, 0.0D), Material.water, this);
    }
	
	@Override
	public void moveEntityWithHeading(float strafe, float forward) {
	    super.moveEntityWithHeading(strafe, forward);
		//this.moveEntity(this.motionX, this.motionY, this.motionZ);
	    this.prevLimbSwingAmount = this.limbSwingAmount;
  		double d2 = this.posX - this.prevPosX;
  		double d3 = this.posZ - this.prevPosZ;
  		float f4 = MathHelper.sqrt_double(d2 * d2 + d3 * d3) * 4.0F;
  		if (f4 > 1.0F) f4 = 1.0F;
  		this.limbSwingAmount += (f4 - this.limbSwingAmount) * 0.4F;
  		this.limbSwing += this.limbSwingAmount;
	}
	
 	@Override
  	public boolean handleWaterMovement() {
  		return this.worldObj.handleMaterialAcceleration(this.boundingBox, Material.water, this);
  	}
 	
 	@Override
  	protected void jump() {}
	
	@Override
  	protected boolean isMovementCeased() {
  		return !isInWater();
  	}
	
	@Override
  	public void onLivingUpdate() {
		this.motionY = -0.0D;
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
		super.onLivingUpdate();
	}
	
	public void floating() {
  		//LogHelper.logInfo("Floating");
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
	
	public float distanceToSurface() {
  		int i = MathHelper.floor_double(this.posX);
  		int j = MathHelper.floor_double(this.posY);
  		int k = MathHelper.floor_double(this.posZ);
  		Block block = this.worldObj.getBlock(i, j, k);
  		if ((block != Blocks.air) && (block.getMaterial() == Material.water)) {
  			for (int x = 1; x < 64; x++) {
  				block = this.worldObj.getBlock(i, j + x, k);
  				if ((block == Blocks.air) || (block.getMaterial() != Material.water)) {
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
            this.entityDropItem(new ItemStack(Items.fish, 1, 0), 0.0F);
        }
    }
	
	 @Override
     public boolean getCanSpawnHere() {
         return this.posY > 45.0D && this.posY < 63.0D && super.getCanSpawnHere() && isInsideOfMaterial(Material.water);
     }
}