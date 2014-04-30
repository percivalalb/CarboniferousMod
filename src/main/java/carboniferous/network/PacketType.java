package carboniferous.network;

import carboniferous.network.packet.PacketGrindSound;
import carboniferous.network.packet.PacketTeleport;
import carboniferous.network.packet.PacketTileUpdate;
import carboniferous.network.packet.PacketWallShell;

/**
 * @author ProPercivalalb
 */
public enum PacketType {

	GRID_SOUND(PacketGrindSound.class),
	TELEPORT(PacketTeleport.class),
	TILE_UPDATE(PacketTileUpdate.class),
	WALL_SHELL(PacketWallShell.class);
	
	public Class<? extends IPacket> packetClass;
	
	PacketType(Class<? extends IPacket> packetClass) {
		this.packetClass = packetClass;
	}
	
	public IPacket createInstance() throws Exception {
		return this.packetClass.newInstance();
	}
	
	public static byte getIdFromClass(Class<? extends IPacket> packetClass) {
		for(PacketType type : values())
			if(type.packetClass == packetClass)
				return (byte)type.ordinal();
		return -1;
	}
}
