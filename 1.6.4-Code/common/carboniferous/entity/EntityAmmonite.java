package carboniferous.entity;

import carboniferous.ModItems;
import carboniferous.api.Properties;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityAmmonite extends EntityWaterMob
{
    public float squidPitch = 0.0F;
    public float prevSquidPitch = 0.0F;
    public float squidYaw = 0.0F;
    public float prevSquidYaw = 0.0F;
    public float field_70867_h = 0.0F;
    public float field_70868_i = 0.0F;

    /** angle of the tentacles in radians */
    public float tentacleAngle = 0.0F;

    /** the last calculated angle of the tentacles in radians */
    public float prevTentacleAngle = 0.0F;
    private float randomMotionSpeed = 0.0F;
    private float field_70864_bA = 0.0F;
    private float field_70871_bB = 0.0F;
    private float randomMotionVecX = 0.0F;
    private float randomMotionVecY = 0.0F;
    private float randomMotionVecZ = 0.0F;

    public EntityAmmonite(World par1World) {
        super(par1World);
        this.setSize(0.7F, 0.7F);
        this.field_70864_bA = 1.0F / (this.rand.nextFloat() + 1.0F) * 0.2F;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(10.0D);
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
    protected float getSoundVolume() {
        return 0.4F;
    }

    @Override
    protected int getDropItemId() {
        return 0;
    }

    @Override
    protected void dropFewItems(boolean par1, int looting) {
    	int chance = this.rand.nextInt(30) - looting;
    	if(chance < 2) {
    		this.entityDropItem(new ItemStack(ModItems.multiItems, 1, 6), 0.0F);
    	}
    }

    @Override
    public boolean isInWater() {
        return this.worldObj.handleMaterialAcceleration(this.boundingBox.expand(0.0D, -0.6000000238418579D, 0.0D), Material.water, this);
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if(!this.worldObj.isRemote && distanceToSurface() < 2.0F) {
        	this.motionY = -0.04D;
        }
        this.prevSquidPitch = this.squidPitch;
        this.prevSquidYaw = this.squidYaw;
        this.field_70868_i = this.field_70867_h;
        this.prevTentacleAngle = this.tentacleAngle;
        this.field_70867_h += this.field_70864_bA;

        if (this.field_70867_h > ((float)Math.PI * 2F)) {
            this.field_70867_h -= ((float)Math.PI * 2F);

            if (this.rand.nextInt(10) == 0) {
                this.field_70864_bA = 1.0F / (this.rand.nextFloat() + 1.0F) * 0.2F;
            }
        }

        if (this.isInWater()) {
            float f;

            if (this.field_70867_h < (float)Math.PI) {
                f = this.field_70867_h / (float)Math.PI;
                this.tentacleAngle = MathHelper.sin(f * f * (float)Math.PI) * (float)Math.PI * 0.25F;

                if ((double)f > 0.75D) {
                	for (int j1 = 0; j1 < 4; ++j1) {
                        float f3 = 0.25F;
                        this.worldObj.spawnParticle("bubble", this.posX - this.motionX * (double)f3, this.posY - this.motionY * (double)f3, this.posZ - this.motionZ * (double)f3, this.motionX, this.motionY, this.motionZ);
                    }
                    this.randomMotionSpeed = 1.0F;
                    this.field_70871_bB = 1.0F;
                }
                else {
                    this.field_70871_bB *= 0.8F;
                }
            }
            else {
                this.tentacleAngle = 0.0F;
                this.randomMotionSpeed *= 0.9F;
                this.field_70871_bB *= 0.99F;
            }

            if (!this.worldObj.isRemote) {
                this.motionX = (double)(this.randomMotionVecX * this.randomMotionSpeed);
                this.motionY = (double)(this.randomMotionVecY * this.randomMotionSpeed);
                this.motionZ = (double)(this.randomMotionVecZ * this.randomMotionSpeed);
            }

            f = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
            this.renderYawOffset += (-((float)Math.atan2(this.motionX, this.motionZ)) * 180.0F / (float)Math.PI - this.renderYawOffset) * 0.1F;
            this.rotationYaw = this.renderYawOffset;
            this.squidYaw += (float)Math.PI * this.field_70871_bB * 1.5F;
            this.squidPitch += (-((float)Math.atan2((double)f, this.motionY)) * 180.0F / (float)Math.PI - this.squidPitch) * 0.1F;
        }
        else
        {
            this.tentacleAngle = MathHelper.abs(MathHelper.sin(this.field_70867_h)) * (float)Math.PI * 0.25F;

            if (!this.worldObj.isRemote) {
                this.motionX = 0.0D;
                this.motionY -= 0.08D;
                this.motionY *= 0.9800000190734863D;
                this.motionZ = 0.0D;
            }

            this.squidPitch = (float)((double)this.squidPitch + (double)(-90.0F - this.squidPitch) * 0.02D);
        }
    }

    @Override
    public void moveEntityWithHeading(float par1, float par2) {
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
    }

    @Override
    protected void updateEntityActionState() {
    	
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.posY > 45.0D && this.posY < 58.0D && super.getCanSpawnHere();
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
}
