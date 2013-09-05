package carboniferous.core.handlers;

import java.util.Random;
import java.util.logging.Level;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import carboniferous.CarboniferousMod;
import carboniferous.ModBlocks;
import carboniferous.block.*;
import carboniferous.api.Properties;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.entity.player.BonemealEvent;

/**
 * @author ProPercivalalb
 */
public class BonemealUseHandler {

	@ForgeSubscribe
	public void action(BonemealEvent par1) {
		if(par1.ID == ModBlocks.saplings_1.blockID) {
			if (applyBonemealSapling(par1.world, par1.X, par1.Y, par1.Z)) {
                if (!par1.world.isRemote) {
                	par1.world.playAuxSFX(2005, par1.X, par1.Y, par1.Z, 0);
                }
                par1.setResult(Result.ALLOW);
            }
		}
	}
	
	public static boolean applyBonemealSapling(World par1World, int par2, int par3, int par4) {
		if (!par1World.isRemote) {
            if ((double)par1World.rand.nextFloat() < 0.45D) {
                ((BlockSapling)ModBlocks.saplings_1).func_96477_c(par1World, par2, par3, par4, par1World.rand);
            }
        }
        return true;
    }
}
