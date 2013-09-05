package carboniferous.core.handlers;

import java.util.EnumSet;
import java.util.Iterator;
import java.util.logging.Level;

import carboniferous.CarboniferousMod;
import carboniferous.api.Properties;
import carboniferous.lib.Reference;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.DimensionManager;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

/**
 * @author ProPercivalalb
 **/
public class ServerTickHandler implements ITickHandler {
	
    public EnumSet ticks() {
        return EnumSet.of(TickType.PLAYER, TickType.WORLD);
    }

    public String getLabel() {
        return Reference.MOD_ID + "(Server)";
    }
    
	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {
		// TODO Auto-generated method stub			
	}
			
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
        if (type.equals(EnumSet.of(TickType.PLAYER))) {
		     EntityPlayerMP player = (EntityPlayerMP)tickData[0];
		     CarboniferousMod.instance.serverTeleport.onTick(player);
		}
		else if (type.equals(EnumSet.of(TickType.WORLD))) {
			//this.sleep(tickData);
		}
	}
	
	public void sleep(Object... tickData) {
		World world = (World)tickData[0];
		if (world == DimensionManager.getWorld(Properties.dimensionID))
	    {
	        if ((!world.playerEntities.isEmpty()) && (((WorldServer)world).allPlayersSleeping))
	        {
	        	boolean allPlayersFullyAsleep = true;
	        	for (int i = 0; i < world.playerEntities.size(); i++)
	        	{
	        		EntityPlayer entityplayer = (EntityPlayer)world.playerEntities.get(i);
	            	if ((!entityplayer.isPlayerSleeping()) || (entityplayer.sleepTimer < 98))
	            	{
	            		allPlayersFullyAsleep = false;
	            	}
	        	}

	        	if (allPlayersFullyAsleep)
	        	{
	        		World overWorld = DimensionManager.getWorld(0);
	        		long time = world.getWorldInfo().getWorldTime() + 24000L;
	        		overWorld.getWorldInfo().setWorldTime(time - time % 24000L);
	        		overWorld.getWorldInfo().setRainTime(0);
	        		overWorld.getWorldInfo().setRaining(false);
	        		overWorld.getWorldInfo().setThunderTime(0);
	        		overWorld.getWorldInfo().setThundering(false);

	        		((WorldServer)world).allPlayersSleeping = false;
	        		Iterator it = world.playerEntities.iterator();

	        		while (it.hasNext())
	        		{
	        			EntityPlayer player = (EntityPlayer)it.next();

	        			if (player.isPlayerSleeping())
	        			{
	        				player.wakeUpPlayer(false, false, true);
	        			}
	        		}

	        		overWorld.provider.resetRainAndThunder();
	        	}
	        }
	    }
	}
}