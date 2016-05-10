package carboniferous.entity;

import carboniferous.ModItems;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityGiantSnail extends EntityLiving {

	public EntityGiantSnail(World world) {
		super(world);
	}
	
	@Override
    protected void dropFewItems(boolean par1, int looting) {
    	int chance = this.rand.nextInt(20) - looting;
    	if(chance < 2) {
    		this.entityDropItem(new ItemStack(ModItems.multiItems, 1, 18), 0.0F);
    	}
    }

}
