package carboniferous.world;

import java.util.Random;

import carboniferous.ModBlocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

/**
 * @author ProPercivalalb
 **/
public class TeleporterCarboniferous extends Teleporter {

	/** Server instance **/
	public WorldServer worldObj;
	public Random rand;
	
	public TeleporterCarboniferous(WorldServer par1WorldServer) {
		super(par1WorldServer);
		this.worldObj = par1WorldServer;
		this.rand = new Random(par1WorldServer.getSeed());
	}
	
	@Override
	public void placeInPortal(Entity entity, double x, double y, double z, float par8) {
		if (this.placeInExistingPortal(entity, x, y, z, par8)) {
			
	    }
	    else {
	    	this.makePortal(entity);
	    	this.placeInExistingPortal(entity, x, y, z, par8);
	    }
	}
	
	@Override
	public boolean placeInExistingPortal(Entity entity, double x, double y, double z, float par8) {
		char var1 = '\200';
        double d = -1D;
        int finalX = 0;
        int finalY = 0;
        int finalZ = 0;
        int posX = MathHelper.floor_double(entity.posX);
        int posZ = MathHelper.floor_double(entity.posZ);
        for (int j1 = posX - var1; j1 <= posX + var1; j1++) {
            double d1 = ((double)j1 + 0.5D) - entity.posX;
            for (int j2 = posZ - var1; j2 <= posZ + var1; j2++) {
                double d3 = ((double)j2 + 0.5D) - entity.posZ;
                for (int k2 = 127; k2 >= 0; k2--) {
                    if (worldObj.getBlock(j1, k2, j2) != ModBlocks.portal) {
                        continue;
                    }
                    for (; worldObj.getBlock(j1, k2 - 1, j2) == ModBlocks.portal; k2--) { }
                    double d5 = ((double)k2 + 0.5D) - entity.posY;
                    double d7 = d1 * d1 + d5 * d5 + d3 * d3;
                    if (d < 0.0D || d7 < d) {
                        d = d7;
                        finalX = j1;
                        finalY = k2;
                        finalZ = j2;
                    }
                }
            }
        }

        if (d >= 0.0D) {
            int k1 = finalX;
            int l1 = finalY;
            int i2 = finalZ;
            double newEntityPosX = (double)k1 + 0.5D;
            double newEntityPosY = (double)l1 + 0.5D;
            double newEntityPosZ = (double)i2 + 0.5D;
            if (worldObj.getBlock(k1 - 1, l1, i2) == ModBlocks.portal) {
            	newEntityPosX -= 0.5D;
            }
            if (worldObj.getBlock(k1 + 1, l1, i2) == ModBlocks.portal) {
            	newEntityPosX += 0.5D;
            }
            if (worldObj.getBlock(k1, l1, i2 - 1) == ModBlocks.portal) {
            	newEntityPosZ -= 0.5D;
            }
            if (worldObj.getBlock(k1, l1, i2 + 1) == ModBlocks.portal) {
            	newEntityPosZ += 0.5D;
            }
            if(!(entity instanceof EntityPlayer)) {
            	newEntityPosZ += 1.5D;
            }
            entity.setLocationAndAngles(newEntityPosX, newEntityPosY, newEntityPosZ, entity.rotationYaw, 0.0F);
            entity.motionX = entity.motionY = entity.motionZ = 0.0D;
            return true;
        }
        else {
            return false;
        }
	}
	
	@Override
    public boolean makePortal(Entity entity) {
	    byte byte0 = 16;
	    double d = -1D;
	    int posX = MathHelper.floor_double(entity.posX);
	    int posY = MathHelper.floor_double(entity.posY);
	    int posZ = MathHelper.floor_double(entity.posZ);
	    int l = posX;
	        int i1 = posY;
	        int j1 = posZ;
	        int k1 = 0;
	        int l1 = rand.nextInt(4);
	        for (int i2 = posX - byte0; i2 <= posX + byte0; i2++)
	        {
	            double d1 = ((double)i2 + 0.5D) - entity.posX;
	            for (int j3 = posZ - byte0; j3 <= posZ + byte0; j3++)
	            {
	                double d3 = ((double)j3 + 0.5D) - entity.posZ;
	                worldObj.getClass();
	                for (int k4 = 165; k4 >= 0; k4--)
	                {
	                    if (!worldObj.isAirBlock(i2, k4, j3))
	                    {
	                        continue;
	                    }
	                    for (; k4 > 0 && worldObj.isAirBlock(i2, k4 - 1, j3); k4--) { }
	                    label0:
	                    for (int j5 = l1; j5 < l1 + 4; j5++)
	                    {
	                        int i6 = j5 % 2;
	                        int l6 = 1 - i6;
	                        if (j5 % 4 >= 2)
	                        {
	                            i6 = -i6;
	                            l6 = -l6;
	                        }
	                        for (int k7 = 0; k7 < 3; k7++)
	                        {
	                            for (int j8 = 0; j8 < 4; j8++)
	                            {
	                                for (int i9 = -1; i9 < 4; i9++)
	                                {
	                                    int k9 = i2 + (j8 - 1) * i6 + k7 * l6;
	                                    int i10 = k4 + i9;
	                                    int k10 = (j3 + (j8 - 1) * l6) - k7 * i6;
	                                    if (i9 < 0 && !worldObj.getBlock(k9, i10, k10).getMaterial().isSolid() || i9 >= 0 && !worldObj.isAirBlock(k9, i10, k10))
	                                    {
	                                        break label0;
	                                    }
	                                }
	                            }
	                        }

	                        double d5 = ((double)k4 + 0.5D) - entity.posY;
	                        double d7 = d1 * d1 + d5 * d5 + d3 * d3;
	                        if (d < 0.0D || d7 < d)
	                        {
	                            d = d7;
	                            l = i2;
	                            i1 = k4;
	                            j1 = j3;
	                            k1 = j5 % 4;
	                        }
	                    }
	                }
	            }
	        }

	        if (d < 0.0D)
	        {
	            for (int j2 = posX - byte0; j2 <= posX + byte0; j2++)
	            {
	                double d2 = ((double)j2 + 0.5D) - entity.posX;
	                for (int k3 = posZ - byte0; k3 <= posZ + byte0; k3++)
	                {
	                    double d4 = ((double)k3 + 0.5D) - entity.posZ;
	                    worldObj.getClass();
	                    for (int l4 = 127; l4 >= 0; l4--)
	                    {
	                        if (!worldObj.isAirBlock(j2, l4, k3)) {
	                            continue;
	                        }
	                        for (; l4 > 0 && worldObj.isAirBlock(j2, l4 - 1, k3); l4--) { }
	                        label1:
	                        for (int k5 = l1; k5 < l1 + 2; k5++)
	                        {
	                            int j6 = k5 % 2;
	                            int i7 = 1 - j6;
	                            for (int l7 = 0; l7 < 4; l7++)
	                            {
	                                for (int k8 = -1; k8 < 4; k8++)
	                                {
	                                    int j9 = j2 + (l7 - 1) * j6;
	                                    int l9 = l4 + k8;
	                                    int j10 = k3 + (l7 - 1) * i7;
	                                    if (k8 < 0 && !worldObj.getBlock(j9, l9, j10).getMaterial().isSolid() || k8 >= 0 && !worldObj.isAirBlock(j9, l9, j10))
	                                    {
	                                        break label1;
	                                    }
	                                }
	                            }

	                            double d6 = ((double)l4 + 0.5D) - entity.posY;
	                            double d8 = d2 * d2 + d6 * d6 + d4 * d4;
	                            if (d < 0.0D || d8 < d)
	                            {
	                                d = d8;
	                                l = j2;
	                                i1 = l4;
	                                j1 = k3;
	                                k1 = k5 % 2;
	                            }
	                        }
	                    }
	                }
	            }
	        }
	        int k2 = k1;
	        int l2 = l;
	        int i3 = i1;
	        int l3 = j1;
	        int i4 = k2 % 2;
	        int j4 = 1 - i4;
	        if (k2 % 4 >= 2) {
	            i4 = -i4;
	            j4 = -j4;
	        }
	        if (d < 0.0D) {
	            if (i1 < 70) {
	                i1 = 70;
	            }
	            if (i1 > 118) {
	                i1 = 118;
	            }
	            i3 = i1;
	        }
	        for (int i5 = 0; i5 < 4; i5++)
	        {
	            formPortal(this.worldObj, l, i1, j1, true);
	            for (int l5 = 0; l5 < 4; l5++)
	            {
	                for (int k6 = -1; k6 < 4; k6++)
	                {
	                    int j7 = l2 + (l5 - 1) * i4;
	                    int i8 = i3 + k6;
	                    int l8 = l3 + (l5 - 1) * j4;
	                    worldObj.notifyBlocksOfNeighborChange(j7, i8, l8, worldObj.getBlock(j7, i8, l8));
	                }
	            }
	        }

	        return true;
    }
	
	public static void formPortal(World world, int x, int y, int z, boolean build) {
		for(int var1 = 0; var1 <= 2; ++var1) {
			for(int var2 = -2; var2 <= 2; ++var2) {
				for(int var3 = -2; var3 <= 2; ++var3) {
					world.setBlockToAir(x + var2, y + var1, z + var3);
				}
			}
		}
		world.setBlock(x, y - 1, z, ModBlocks.timeBox, 0, 3);
		if(build) {
			world.setBlock(x, y - 1, z, ModBlocks.timeBox, 1, 3);
			for(int var1 = 0; var1 <= 1; ++var1) {
				world.setBlock(x, y + var1, z, ModBlocks.portal);
				for(int var2 = -1; var2 <= 1; ++var2) {
					for(int var3 = -1; var3 <= 1; ++var3) {
						boolean flag = var2 != 0 && var3 != 0;
						if(flag) {
							world.setBlock(x + var2, y + var1, z + var3, Blocks.stonebrick);
						}
						
						if(var1 == 1) {
							world.setBlock(x + var2, y + 2, z + var3, Blocks.stone_slab, 5, 3);
						}
					}
				}
			}
			
			world.setBlock(x, y + 2, z, Blocks.stone_slab, 13, 3);
			
			world.setBlock(x + 2, y, z + 1, Blocks.stone_brick_stairs, 1, 3);
			world.setBlock(x + 2, y, z - 1, Blocks.stone_brick_stairs, 1, 3);
			world.setBlock(x + 2, y, z - 2, Blocks.stone_brick_stairs, 1, 3);
			world.setBlock(x + 2, y, z + 2, Blocks.stone_brick_stairs, 1, 3);
			
			world.setBlock(x - 2, y, z + 1, Blocks.stone_brick_stairs, 0, 3);
			world.setBlock(x - 2, y, z - 1, Blocks.stone_brick_stairs, 0, 3);
			world.setBlock(x - 2, y, z - 2, Blocks.stone_brick_stairs, 0, 3);
			world.setBlock(x - 2, y, z + 2, Blocks.stone_brick_stairs, 0, 3);
	
			world.setBlock(x + 1, y, z - 2, Blocks.stone_brick_stairs, 2, 3);
			world.setBlock(x - 1, y, z - 2, Blocks.stone_brick_stairs, 2, 3);
			
			world.setBlock(x + 1, y, z + 2, Blocks.stone_brick_stairs, 3, 3);
			world.setBlock(x - 1, y, z + 2, Blocks.stone_brick_stairs, 3, 3);
		}
	}
}
