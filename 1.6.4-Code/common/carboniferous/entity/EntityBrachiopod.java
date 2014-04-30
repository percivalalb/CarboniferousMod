package carboniferous.entity;

import java.util.Iterator;

import carboniferous.CarboniferousMod;
import carboniferous.ModItems;
import carboniferous.api.CarboniferousApi;
import carboniferous.api.Properties;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class EntityBrachiopod extends EntityWaterMob {
	
	public int openMouthDummyTimer;
	
	public EntityBrachiopod(World world) {
        super(world);
        this.setSize(0.8F, 0.9F);
        this.openMouthDummyTimer = this.rand.nextInt(200);
    }
	
	@Override
	protected void applyEntityAttributes() {
	    super.applyEntityAttributes();
	    this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(10.0D);
	    this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(0.0D);
	}

	@Override
    public boolean canBreatheUnderwater() {
        return true;
    }

	@Override
    protected String getLivingSound() {
        return null;
    }

	@Override
    protected String getHurtSound() {
        return null;
    }

	@Override
    protected String getDeathSound() {
        return null;
    }
    
	@Override
    protected void dropFewItems(boolean par1, int looting) {
    	int chance = this.rand.nextInt(30) - looting;
    	if(chance < 2) {
    		this.entityDropItem(new ItemStack(ModItems.multiItems, 1, 7), 0.0F);
    	}
    }
	
	@Override
    protected void updateEntityActionState() {} //Unused to stop the entity from moving
	
	protected void entityInit() {
		super.entityInit();
		this.dataWatcher.addObject(20, (int)0);
		this.dataWatcher.addObject(21, (int)1);
	}
	
	public int getOpenMouth() {
		return this.dataWatcher.getWatchableObjectInt(20);
	}
	
	public float getOpenMouth(float var1) {
		return ((float)getOpenMouth()) / var1;
	}
	
	@Override
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
		super.writeEntityToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setInteger("openMouth", this.getOpenMouth());
		par1NBTTagCompound.setInteger("pearl", this.hasPearl() ? 1 : 0);
    }
	
	@Override
    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
    	super.readEntityFromNBT(par1NBTTagCompound);
    	this.setOpenMouth(par1NBTTagCompound.getInteger("openMouth"));
    	this.setHasPearl(par1NBTTagCompound.getInteger("pearl") == 1 ? true : false);
    }
	
	public void setOpenMouth(int par1) {
		this.dataWatcher.updateObject(20, par1);
	}
	
	public void resetMouth(int plusOpenMouthTimer) {
		this.openMouthDummyTimer += this.rand.nextInt(250) + plusOpenMouthTimer;
		this.setOpenMouth(0);
	}
	
	public boolean hasPearl() {
		return this.dataWatcher.getWatchableObjectInt(21) == 1 ? true : false;
	}
	
	/**
	 * Sets the Data Watcher to display the pearl in SMP
	 */
	public void setHasPearl(boolean par1) {
		if(par1) {
			this.dataWatcher.updateObject(21, 1);
			return;
		}
		this.dataWatcher.updateObject(21, 0);
	}
	
	@Override
	public void onUpdate() {
		super.onUpdate();
	    if(!this.worldObj.isRemote) {
	    	if(this.openMouthDummyTimer != -1) {
	    		--this.openMouthDummyTimer;
	    	}
	    	if(this.openMouthDummyTimer == 0 && this.getOpenMouth() == 0) {
	    		this.setOpenMouth(this.getOpenMouth() - 1);
	    		this.openMouthDummyTimer = -1;
	    	}
	    	if(this.getOpenMouth() != 0) {
	    		if(!(this.getOpenMouth() <= -65)) {
	    			this.setOpenMouth(this.getOpenMouth() - 1);
	    		}
	    	}
		}
	}
	
	@Override
	public boolean interact(EntityPlayer player) {
		ItemStack item = player.getCurrentEquippedItem();
		if(item != null && item.itemID == ModItems.net.itemID && this.hasPearl()) {
			if(this.getOpenMouth() == -65 && this.worldObj.rand.nextInt(3) == 0) {
				this.playSound(Properties.SOUND_BRACHIOPOD_SLAM, 0.1F, this.getSoundPitch());
				this.setHasPearl(false);
				if(!this.worldObj.isRemote) {
					this.entityDropItem(new ItemStack(ModItems.multiItems.itemID, 1, 8), 0.0F);
				}
				if(!player.capabilities.isCreativeMode) {
					item.damageItem(1, player);
				}
				this.resetMouth(500);
			}
			else if(this.getOpenMouth() != 0){
				this.playSound(Properties.SOUND_BRACHIOPOD_SLAM, 0.1F, this.getSoundPitch());
				player.attackEntityFrom(CarboniferousApi.brachiopodDamage, 1);
				this.resetMouth(75);
			}
		}
		else {
			if(this.getOpenMouth() != 0) {
				this.playSound(Properties.SOUND_BRACHIOPOD_SLAM, 0.1F, this.getSoundPitch());
				player.attackEntityFrom(CarboniferousApi.brachiopodDamage, 2);
				this.resetMouth(80);
			}
		}
		return true;
	}
}
