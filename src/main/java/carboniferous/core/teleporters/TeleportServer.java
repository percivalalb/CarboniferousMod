package carboniferous.core.teleporters;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.Random;

import carboniferous.CarboniferousMod;
import carboniferous.api.Properties;
import carboniferous.network.packet.PacketTeleport;
import carboniferous.world.TeleporterCarboniferous;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.potion.Potion;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

/**
 * @author ProPercivalalb
 **/
public class TeleportServer {
	
	private EntityPlayerMP player;
	public float prevTimeInPortal;
	public float timeInPortal;
	public boolean inPortal = false;
	public Random random = new Random();
	public int timeUntilPortal = 20;
	public byte targetDim = 0;
	
	public TeleportServer(EntityPlayerMP player) {
		this.player = player;
	}
	
	public EntityPlayerMP getPlayer() {
		return player;
	}
	
	public void onTick() {
        if (this.inPortal) {
        	
        	timeInPortal += 0.0125F;
            if (this.timeInPortal >= 1.0F) {
            	this.timeInPortal = 1.0F;
                this.timeUntilPortal = 10;
                byte dimension = (byte)Properties.dimensionID;
                if (player.dimension == Properties.dimensionID) {
                	dimension = 0;
                }
                
                CarboniferousMod.NETWORK_MANAGER.sendPacketToPlayer(new PacketTeleport(), player);
                player.mcServer.getConfigurationManager().transferPlayerToDimension(player, dimension, new TeleporterCarboniferous(player.mcServer.worldServerForDimension(dimension)));

            }
            this.inPortal = false;
        }
        else {
            if (this.timeInPortal > 0.0F) {
                this.timeInPortal -= 0.05F;
            }
            if (this.timeInPortal < 0.0F) {
                this.timeInPortal = 0.0F;
            }
        }
        if (this.timeUntilPortal > 0) {
            --this.timeUntilPortal;
        }
	}
	
    public void setInPortal() {
        if (timeUntilPortal > 0) {
            timeUntilPortal = 10;
        }
        else {
        	inPortal = true;
        }
    }
}