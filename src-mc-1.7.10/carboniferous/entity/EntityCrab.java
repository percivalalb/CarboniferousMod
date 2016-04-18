package carboniferous.entity;

import java.util.List;

import carboniferous.ModBlocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityCrab extends EntityMob {
   
	private int angerLevel = 0;

    public EntityCrab(World par1World) {
        super(par1World);
        this.setSize(0.8F, 0.4F);
    }
    
    @Override
	protected void applyEntityAttributes() {
	    super.applyEntityAttributes();
	    this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(4.0D);
	    this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.2D);
	}

    @Override
    protected boolean isAIEnabled() {
        return false;
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setShort("Anger", (short)this.angerLevel);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.angerLevel = par1NBTTagCompound.getShort("Anger");
    }

    @Override
    protected Entity findPlayerToAttack() {
        return this.angerLevel == 0 ? null : super.findPlayerToAttack();
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
    }
    
    @Override
    public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
        Entity var3 = par1DamageSource.getEntity();

        if (var3 instanceof EntityPlayer) {
            List var4 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(32.0D, 32.0D, 32.0D));

            for (int var5 = 0; var5 < var4.size(); ++var5) {
                Entity var6 = (Entity)var4.get(var5);

                if (var6 instanceof EntityCrab) {
                    EntityCrab var7 = (EntityCrab)var6;
                    var7.becomeAngryAt(var3);
                }
            }

            this.becomeAngryAt(var3);
        }

        return super.attackEntityFrom(par1DamageSource, par2);
    }

    private void becomeAngryAt(Entity par1Entity) {
        this.entityToAttack = par1Entity;
        this.angerLevel = 400 + this.rand.nextInt(400);
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
    public void onUpdate() {
    	this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.entityToAttack != null ? 0.75D : 0.2D);
        super.onUpdate();
    }
    
    @Override
    protected void dropFewItems(boolean par1, int looting) {
        int var3 = this.rand.nextInt(2 + looting);
        int var4;

        for (var4 = 0; var4 < var3; ++var4) {
            this.dropItem(Items.fish, 1);
        }
    }
    
    @Override
    public boolean getCanSpawnHere() {
    	 int var1 = MathHelper.floor_double(this.posX);
         int var2 = MathHelper.floor_double(this.boundingBox.minY);
         int var3 = MathHelper.floor_double(this.posZ);
         return super.getCanSpawnHere() && worldObj.getBlock(var1, var2 - 1, var3) == ModBlocks.grass;
    }
    
    @Override
    public float getBlockPathWeight(int par1, int par2, int par3) {
        return 0.0F;
    }

    @Override
    protected boolean isValidLightLevel() {
    	return 3 <= this.rand.nextInt(8);
    }
    
    @Override
    protected boolean canDespawn() {
        return false;
    }
    
    @Override
    public EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute.ARTHROPOD;
    }
	
	@Override
    public boolean canBreatheUnderwater() {
        return true;
    }
	
	public boolean handleWaterMovement() {
		//super.handleWaterMovement();
		//if(this.isInWater()) {
		//	this.motionY = -0.1D;
		//}
		return super.handleWaterMovement();
	}
}
