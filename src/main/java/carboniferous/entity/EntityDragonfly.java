package carboniferous.entity;

import carboniferous.CarboniferousMod;
import carboniferous.ModItems;
import carboniferous.api.Properties;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityFlying;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityDragonfly extends EntityFlying {

    boolean wingMovement;
    public int wingState;
    public float tailState;
    private ChunkCoordinates currentFlightTarget;
    
	public EntityDragonfly(World par1World) {
		super(par1World);
		this.wingMovement = false;
		this.setSize(1.0F, 0.5F);
	}

	@Override
	protected void applyEntityAttributes() {
	    super.applyEntityAttributes();
	    this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10.0D);
	    this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.1D);
	}

	public boolean isFlappingWings() {
	    return wingMovement;
	}
	
	@Override
	protected String getLivingSound() {
        return null;
    }

	@Override
    protected String getHurtSound() {
        return null;
    }

    protected String getDeathSound() {
        return null;
    }

    protected float getSoundVolume() {
        return 0.4F;
    }
    
    @Override
    protected boolean canTriggerWalking() {
        return false;
    }
	
    protected boolean isAIEnabled() {
        return true;
    }
    
    @Override
    public boolean interact(EntityPlayer player) {
        ItemStack stack = player.inventory.getCurrentItem();
        if (!worldObj.isRemote && stack != null && stack.getItem() == ModItems.net) {
        	this.entityDropItem(new ItemStack(ModItems.rawDragonfly, 1, 0), 0.0F);
        	if(!player.capabilities.isCreativeMode) {
				stack.damageItem(1, player);
			}
            this.setDead();
            return true;
        }
        else {
            return false;
        }
    }
    
    public void onUpdate() {
        super.onUpdate();
        if (motionY < 0.0D) {
            wingMovement = false;
        }
        else {
            wingMovement = !onGround;
        }
        this.motionY *= 0.6000000238418579D;
    }

    @Override
    protected void updateAITasks() {
        super.updateAITasks();

        if (this.currentFlightTarget != null && 
        	(!this.worldObj.isAirBlock(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ) || this.currentFlightTarget.posY < 1))
        {
            this.currentFlightTarget = null;
        }

        if (this.currentFlightTarget == null || 
        	this.rand.nextInt(100) == 0 || 
        	this.currentFlightTarget.getDistanceSquared((int)this.posX, (int)this.posY, (int)this.posZ) < 2.0F)
        {
            this.currentFlightTarget = getNewChunkCoordinates();
        }

        double d0 = (double)this.currentFlightTarget.posX + 0.5D - this.posX;
        double d1 = (double)this.currentFlightTarget.posY + 0.1D - this.posY;
        double d2 = (double)this.currentFlightTarget.posZ + 0.5D - this.posZ;
        this.motionX += (Math.signum(d0) * 0.2D - this.motionX) * 0.08000000149011612D;
        this.motionY += (Math.signum(d1) * 0.499999988079071D - this.motionY) * 0.08000000149011612D;
        this.motionZ += (Math.signum(d2) * 0.2D - this.motionZ) * 0.08000000149011612D;
        this.faceChunkCoordinates(this.currentFlightTarget, 180F, 180F);
    }
    
    public ChunkCoordinates getNewChunkCoordinates() {
    		ChunkCoordinates chunk = new ChunkCoordinates();
    		chunk.posX = MathHelper.floor_double(this.posX);
    		chunk.posY = MathHelper.floor_double(this.posY);
    		chunk.posZ = MathHelper.floor_double(this.posZ);
    		//X Direction
    		if(rand.nextInt(2) == 0) {chunk.posX += 6 + rand.nextInt(5);}
    		else {chunk.posX -= 6 - rand.nextInt(5);}
    		
    		//Y Direction
    		int random = rand.nextInt(4);
    		int distance = distanceToSurface();
    		if(random == 0 || distance < 5) {chunk.posY += 1 + rand.nextInt(2);}
    		else if(random == 1 || distance > 20) {chunk.posY -= 1 - rand.nextInt(2);}
    		
    		//Z Direction
    		if(rand.nextInt(2) == 0) {chunk.posZ += 6 + rand.nextInt(5);}
    		else {chunk.posZ -= 6 - rand.nextInt(5);}
    	    return chunk;
    }
    
    public void faceChunkCoordinates(ChunkCoordinates par1ChunkCoordinates, float par2, float par3) {
        double d0 = par1ChunkCoordinates.posX - this.posX;
        double d1 = par1ChunkCoordinates.posZ - this.posZ;
        double d2 = par1ChunkCoordinates.posY - this.posY;
        double d3 = (double)MathHelper.sqrt_double(d0 * d0 + d1 * d1);
        float f2 = (float)(Math.atan2(d1, d0) * 180.0D / Math.PI) - 90.0F;
        float f3 = (float)(-(Math.atan2(d2, d3) * 180.0D / Math.PI));
        this.rotationPitch = this.updateRotation(this.rotationPitch, f3, par3);
        this.rotationYaw = this.updateRotation(this.rotationYaw, f2, par2);
    }
    
    private float updateRotation(float par1, float par2, float par3) {
        float f3 = MathHelper.wrapAngleTo180_float(par2 - par1);
        if (f3 > par3) {f3 = par3;}
        if (f3 < -par3) {f3 = -par3;}
        return par1 + f3;
    }
    
    protected int distanceToSurface() {
        for (int distance = MathHelper.floor_double(posY); distance > 0; distance--) {
            if (worldObj.getBlock(MathHelper.floor_double(posX), distance, MathHelper.floor_double(posZ)) != Blocks.air) {
                return MathHelper.floor_double(posY) - distance;
            }
        }
        return -1;
    }
    
    @Override
    protected void dropFewItems(boolean recentlyHitByPlayer, int looting) {
        this.entityDropItem(new ItemStack(ModItems.multiItems, 1 + rand.nextInt(2), 12), 0.0F);
    }
}