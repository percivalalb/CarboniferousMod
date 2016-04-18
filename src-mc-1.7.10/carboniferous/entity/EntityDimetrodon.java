package carboniferous.entity;

import carboniferous.ModBlocks;
import carboniferous.api.Properties;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityDimetrodon extends EntityAnimal {
   
	public EntityDimetrodon(World world) {
    	super(world);
        this.setSize(0.999F, 0.6F);
        this.getNavigator().setAvoidsWater(true);
        float f = 0.14F;
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 0.2F));
        this.tasks.addTask(2, new EntityAIMate(this, f));
        //this.tasks.addTask(3, new EntityAITempt(this, 0.2F, Item.carrotOnAStick.itemID, false));
        //this.tasks.addTask(3, new EntityAITempt(this, 0.2F, Item.carrot.itemID, false));
        this.tasks.addTask(4, new EntityAIFollowParent(this, 0.2F));
        this.tasks.addTask(5, new EntityAIWander(this, f));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
    }

	@Override
	public boolean isAIEnabled() {
	    return true;
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(22.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.14D);
	}

	@Override
    protected String getLivingSound() {return Properties.SOUND_DIMETRODON_LIVING;}
	@Override
    protected String getHurtSound() {return Properties.SOUND_DIMETRODON_HURT;}
    @Override
    protected String getDeathSound() {return Properties.SOUND_DIMETRODON_DEATH;}

    @Override
    protected void dropFewItems(boolean par1, int par2) {
      
    }

    @Override
    public boolean interact(EntityPlayer entityplayer) {
        return false;
    }

    @Override
    public boolean getCanSpawnHere() {
        int i = MathHelper.floor_double(posX);
        int j = MathHelper.floor_double(boundingBox.minY);
        int k = MathHelper.floor_double(posZ);
        return worldObj.getBlock(i, j - 1, k) == ModBlocks.grass;
    }

    @Override
    protected boolean canDespawn() {
        return false;
    }

    public boolean canBreatheUnderwater() {
        return true;
    }

	@Override
	public EntityAgeable createChild(EntityAgeable entityageable) {
		return null;
	}
	
	@Override
    protected float getSoundVolume() {
    	return 0.5F;
    }
}
