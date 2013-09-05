package carboniferous.entity;

import carboniferous.CarboniferousMod;
import carboniferous.ModBlocks;
import carboniferous.ModItems;
import carboniferous.api.Properties;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityDendrerpeton extends EntityAnimal {
   
	public EntityDendrerpeton(World world) {
    	super(world);
        this.setSize(1.0F, 0.6F);
    }

	@Override
	protected void applyEntityAttributes() {
	    super.applyEntityAttributes();
	    this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(16.0D);
	    this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(0.0D);
	}

    public void writeEntityToNBT(NBTTagCompound nbttagcompound) {
        super.writeEntityToNBT(nbttagcompound);
    }

    public void readEntityFromNBT(NBTTagCompound nbttagcompound) {
        super.readEntityFromNBT(nbttagcompound);
    }

    protected String getLivingSound(){
        return null;
    }

    protected String getHurtSound(){
        return null;
    }

    protected String getDeathSound(){
        return null;
    }

    protected void dropFewItems(boolean par1, int par2) {
        int j = this.rand.nextInt(3) + this.rand.nextInt(1 + par2);
        int k;

        for (k = 0; k < j; ++k) {
        	this.entityDropItem(new ItemStack(ModItems.multiItems, 1, 10), 0.0F);
        }

        j = this.rand.nextInt(3) + 1 + this.rand.nextInt(1 + par2);

        for (k = 0; k < j; ++k) {
            if (this.isBurning()) {
            	this.entityDropItem(new ItemStack(ModItems.cookedAmphibian, 1, 0), 0.0F);
            }
            else {
                this.entityDropItem(new ItemStack(ModItems.rawAmphibian, 1, 0), 0.0F);
            }
        }
    }

    public boolean interact(EntityPlayer entityplayer) {
        return false;
    }

    public boolean getCanSpawnHere() {
        int i = MathHelper.floor_double(posX);
        int j = MathHelper.floor_double(boundingBox.minY);
        int k = MathHelper.floor_double(posZ);
        return worldObj.getBlockId(i, j - 1, k) == ModBlocks.grass.blockID;
    }

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
}
