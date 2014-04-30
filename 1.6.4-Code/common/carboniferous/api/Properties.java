package carboniferous.api;

import java.lang.reflect.Field;
import java.util.logging.Logger;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.network.IPacketHandler;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.Configuration;

/**
 * @author ProPercivalalb
 **/
public class Properties {

	/** The configuration file where all variables can be accessed**/
	public static Configuration config;
	
	/** The CarboniferousMod packet handler (Client & Server) **/
	public static IPacketHandler packetHandler;
	
	/** The Creative Tab **/
	public static CreativeTabs tabCarboniferous;
	
	//Texture Path
	public static final String PACKAGE = "carboniferous";
	public static final String TEX_PACkAGE = "carboniferous:";
	public static final String TEX_LOGO = "textures/logo.png";
	public static final String TEX_BLOCK = "textures/item/";
	public static final String TEX_BLOCK_GRINDER = TEX_BLOCK + "grinder.png";
	public static final String TEX_BLOCK_COMPRESSOR = TEX_BLOCK + "compressor.png";
	public static final String TEX_MOBS = "textures/mobs/";
	public static final String TEX_MOBS_BRACHIOPOD = TEX_MOBS + "brachiopod.png";
	public static final String TEX_MOBS_AMMONITE = TEX_MOBS + "ammonite.png";
	public static final String TEX_MOBS_DENDRERPETON = TEX_MOBS + "dendrerpeton.png";
	public static final String TEX_MOBS_MESOTHELAE = TEX_MOBS + "mesothelae.png";
	public static final String TEX_MOBS_DRAGONFLY = TEX_MOBS + "dragonfly.png";
	public static final String TEX_MOBS_ORTHACANTHUS = TEX_MOBS + "orthacanthus.png";
	public static final String TEX_MOBS_GIANT_MEGANEURA = TEX_MOBS + "giantMeganeura.png";
	public static final String TEX_MOBS_CRASSIGYRINUS = TEX_MOBS + "crassigyrinus.png";
	public static final String TEX_MOBS_CRAB = TEX_MOBS + "crab.png";
	public static final String TEX_MOBS_DIMETRODON = TEX_MOBS + "dimetrodon.png";
	public static final String TEX_GUI = "textures/gui/";
	public static final String TEX_GUI_GRINDER = TEX_GUI + "grind.png";
	public static final String TEX_GUI_GRINDER_COG = TEX_GUI + "grindCog.png";
	public static final String TEX_GUI_COMPRESSOR = TEX_GUI + "compressor.png";
	public static final String TEX_ARMOR = TEX_PACkAGE + "textures/armor/";
	public static final String TEX_ARMOR_FLIPPERS = TEX_ARMOR + "flippers.png";
	public static final String TEX_ARMOR_AMPHIBIAN_SKIN_1 = TEX_ARMOR + "amphibian_1.png";
	public static final String TEX_ARMOR_AMPHIBIAN_SKIN_2 = TEX_ARMOR + "amphibian_2.png";
	public static final String TEX_ARMOR_QUIVER = TEX_ARMOR + "quiver.png";
	public static final String TEX_ITEM_LARGE = "textures/items/large/";
	
	//Sound Paths
	public static final String SOUND_PATH_BRACHIOPOD_SLAM = "brachiopod/slam.ogg";
	public static final String SOUND_PATH_DIMETRODON_LIVING_1 = "dimetrodon/living1.ogg";
	public static final String SOUND_PATH_DIMETRODON_LIVING_2 = "dimetrodon/living2.ogg";
	public static final String SOUND_PATH_DIMETRODON_HURT = "dimetrodon/hurt.ogg";
	public static final String SOUND_PATH_DIMETRODON_DEATH = "dimetrodon/death.ogg";
	
	public static final String SOUND_PATH_GRIND_1 = "machine/grind1.ogg";
	public static final String SOUND_PATH_GRIND_2 = "machine/grind2.ogg";
	//Sounds
	public static final String SOUND_DIMETRODON_LIVING = TEX_PACkAGE + "dimetrodon.living";
	public static final String SOUND_DIMETRODON_HURT = TEX_PACkAGE + "dimetrodon.hurt";
	public static final String SOUND_DIMETRODON_DEATH = TEX_PACkAGE + "dimetrodon.death";
	public static final String SOUND_BRACHIOPOD_SLAM = TEX_PACkAGE + "brachiopod.slam";
	public static final String SOUND_GRIND = TEX_PACkAGE + "machine.grind";
	
	//Packets
	public static final String PACKET_TELEPORT = "CM|TELEPORT";
	public static final String PACKET_TILE_UPDATE = "CM|TILEUPDATE";
	public static final String PACKET_WALL_SHELL = "CM|WALLSHELL";
	public static final String PACKET_GRIND_SOUND = "CM|GRINDSOUND";
	
	//Render ID
	public static int RENDER_WATER_PLANT;
	public static int RENDER_ANT_HILL;
	public static int RENDER_GRINDER;
	
	//GUI ID
	public static final int GUI_ID_GRINDER = 1;
	public static final int GUI_ID_QUIVER = 2;
	public static final int GUI_ID_COMPRESSER = 3;
	
	//Block/Item ID's
	public static int ID_GRASS = 220;//Terrain
	public static int ID_DIRT = 221;//Terrain
	public static int ID_MULTIBLOCK_1 = 222;//Terrain
	public static int ID_MULTIBLOCK_2 = 2778;
	public static int ID_TIME_BOX = 2779;
	public static int ID_PORTAL = 2780;
	public static int ID_GRINDER = 2781;
	public static int ID_LOGS_1 = 2782;
	public static int ID_LEAVES_1 = 2783;
	public static int ID_SAPLINGS_1 = 2784;
	public static int ID_PLANKS_1 = 2785;
	public static int ID_WOOD_DOUBLE_SLAB = 2786;
	public static int ID_WOOD_SINGLE_SLAB = 2787;
	public static int ID_WALLSHELLS = 2788;
	public static int ID_STAIRS_LEPIDONDENDRON = 2789;
	public static int ID_STAIRS_CALAMITES = 2790;
	public static int ID_STAIRS_CORDAITES = 2791;
	public static int ID_STAIRS_SIGILLARIA = 2792;
	public static int ID_STAIRS_GRANITE_BRICK = 2793;
	public static int ID_STAIRS_LIMESTONE_BRICK = 2794;
	public static int ID_WATER_PLANT = 2795;
	public static int ID_ANT_HILL = 2796;
	public static int ID_SAND = 2797;
	public static int ID_CLEAR_GLASS = 2798;
	public static int ID_WALL_ROCK = 2799;
	public static int ID_CORAL = 2800;
	public static int ID_PILLARS = 2801;
	public static int ID_VINE = 2802;
	public static int ID_DOOR_LEPIDONDENDRON = 2803;
	public static int ID_DOOR_CALAMITES = 2804;
	public static int ID_DOOR_CORDAITES = 2805;
	public static int ID_DOOR_SIGILLARIA = 2806;
	public static int ID_DOOR_AMPHIBIAN = 2807;
	public static int ID_FERN = 2808;
	public static int ID_COMPRESSOR = 2809;
	public static int ID_TILLED_DIRT = 2810;
	public static int ID_MULTIBLOCK_3 = 2811;
	
	public static int ID_FLIPPERS = 26240;
	public static int ID_MULTI_ITEMS = 26242;
	public static int ID_AMPHIBIAN_SKIN_HELMET = 26243;
	public static int ID_AMPHIBIAN_SKIN_CHEST = 26244;
	public static int ID_AMPHIBIAN_SKIN_LEGGING = 26245;
	public static int ID_AMPHIBIAN_SKIN_BOOT = 26246;
	public static int ID_HUNTERS_BOW = 26247;
	public static int ID_GRINDING_STONES = 26248;
	public static int ID_ANT = 26249;
	public static int ID_ANT_COOKED = 26250;
	public static int ID_QUIVER = 26251;
	public static int ID_NET = 26258;
	public static int ID_RAW_DRAGONFLY = 26259;
	public static int ID_COOKED_DRAGONFLY = 26260;
	public static int ID_RAW_AMPHIBIAN = 26261;
	public static int ID_COOKED_AMPHIBIAN = 26262;
	
	//Biome ID
	public static int BIOME_ID_CALAMITESSWAMP = 170;
	public static int BIOME_ID_HIGHLANDS = 171;
	public static int BIOME_ID_ISLAND = 172;
	public static int BIOME_ID_RAINFOREST = 173;
	public static int BIOME_ID_RIVER = 174;
	public static int BIOME_ID_OCEAN = 175;
	public static int BIOME_ID_COALSWAMP = 176;
	public static int BIOME_ID_BOG = 177;
	
	//ID'S
	public static int dimensionID = 76;
	
	//NBT Data
    public static final String NBT_OWNER_KEY = "teOwner";
    public static final String NBT_CUSTOM_NAME = "CustomName";
    public static final String NBT_ROTATION = "rotation";
    public static final String NBT_STATE = "state";
	
	public static String[] getPackets() {
		String[] packets = new String[0];
		try {
			Field[] fields = Properties.class.getFields();
			int count = 0;
			for(Field field : fields) {
				if(field.getName().startsWith("PACKET_")) {
					count += 1;
				}
			}
			int newCount = 0;
			packets = new String[count];
			for(Field field : fields) {
				if(field.getName().startsWith("PACKET_")) {
					packets[newCount] = (String)field.get((Object)null);
					newCount += 1;
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return packets;
	}
	
	static {
		
	}
}