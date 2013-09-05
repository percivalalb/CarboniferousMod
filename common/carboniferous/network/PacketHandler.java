package carboniferous.network;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

import carboniferous.api.Properties;
import carboniferous.network.packet.PacketGrindSound;
import carboniferous.network.packet.PacketTeleport;
import carboniferous.network.packet.PacketTileUpdate;
import carboniferous.network.packet.PacketWallShell;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.Player;

/**
 * @author ProPercivalalb
 **/
public class PacketHandler implements IPacketHandler {

	private Map<String, IPacket> map = new Hashtable<String, IPacket>();
	
	IPacket packet_Teleport = new PacketTeleport();
	IPacket packet_TileUpdate = new PacketTileUpdate();
	IPacket packet_WallShell = new PacketWallShell();
	IPacket packet_GrindSound = new PacketGrindSound();
	
	public PacketHandler() {
        map.put(Properties.PACKET_TELEPORT, packet_Teleport);
        map.put(Properties.PACKET_TILE_UPDATE, packet_TileUpdate);
        map.put(Properties.PACKET_WALL_SHELL, packet_WallShell);
        map.put(Properties.PACKET_GRIND_SOUND, packet_GrindSound);
	}
	
	@Override
	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) {
		if(map.containsKey(packet.channel)) { 
			map.get(packet.channel).handle(manager, packet, (EntityPlayer)player);
		}
	}
	
	public static void registerPackets() {
		Properties.packetHandler = new PacketHandler();
		for(String packetName : Properties.getPackets()) {
			NetworkRegistry.instance().registerChannel(Properties.packetHandler, packetName);
		}
	}
}
