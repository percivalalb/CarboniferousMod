package carboniferous.core.teleporters;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.Random;

import carboniferous.api.Properties;
import carboniferous.world.TeleporterCarboniferous;
import carboniferous.network.PacketHandler;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet11PlayerPosition;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.server.MinecraftServer;
import net.minecraft.src.ModLoader;
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
	
	public void sendPacket(Packet packet) {
		player.playerNetServerHandler.sendPacketToPlayer(packet);
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
               
                player.playerNetServerHandler.sendPacketToPlayer(this.getDataPacket(player));
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
    
    public Packet250CustomPayload getDataPacket(EntityPlayerMP player) {		
		try {
	        ByteArrayOutputStream bytes = new ByteArrayOutputStream(13);
	        DataOutputStream data = new DataOutputStream(bytes);
	        data.writeInt(0);
			Packet250CustomPayload packet = new Packet250CustomPayload();
			packet.channel = Properties.PACKET_TELEPORT;
			packet.length = bytes.size();
			packet.data = bytes.toByteArray();
			packet.length = bytes.size();
			return packet;
		} 
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}