package carboniferous.core.handlers;

import net.minecraftforge.common.config.Configuration;
import carboniferous.api.Properties;

/**
 * @author ProPercivalalb
 */
public class ConfigurationHandler {

	public static void loadConfig(Configuration config) {
		config.load();
		
		//Biomes
		Properties.BIOME_ID_CALAMITESSWAMP = config.get("biomeID", "calamitesSwamp", 170).getInt(170);
		Properties.BIOME_ID_HIGHLANDS = config.get("biomeID", "highlands", 171).getInt(171);
		Properties.BIOME_ID_ISLAND = config.get("biomeID", "island", 172).getInt(172);
		Properties.BIOME_ID_RAINFOREST = config.get("biomeID", "rainforest", 173).getInt(173);
		Properties.BIOME_ID_RIVER = config.get("biomeID", "carboniferousRiver", 174).getInt(174);
		Properties.BIOME_ID_OCEAN = config.get("biomeID", "carboniferousOcean", 175).getInt(175);
		Properties.BIOME_ID_COALSWAMP = config.get("biomeID", "coalSwamp", 176).getInt(176);
		//Properties.BIOME_ID_BOG = var1.get("biomeID", "bog", 177).getInt(170);
		
		//Dimension ID
		Properties.dimensionID = config.get("dimensionID", "carboniferousDimensionID", 76).getInt(76);
		config.save();
	 }
}
