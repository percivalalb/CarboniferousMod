package carboniferous.api;

import java.lang.reflect.Method;

import carboniferous.api.registry.ItemList;
import carboniferous.world.WorldProviderCarboniferous;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.DimensionType;
import net.minecraft.world.biome.Biome;

/**
 * @author ProPercivalalb
 */
public class CarboniferousModAPI {
	
	public static CreativeTabs CREATIVE_TAB;
	
	public static DimensionType DIMENSION_TYPE = DimensionType.register("carboniferous", "_carboniferous", CarboniferousSettings.DIM_ID, WorldProviderCarboniferous.class, false);

	/**
	 * Registers a biome to generate in the Carboniferous dimension.
	 * @param biome The biome you want to register.
	 */
	public static void registerBiome(Biome biome) {
		try {
			Class cls = Class.forName("carboniferous.world.genlayer.GenLayerCarboniferousBiomes");
			Method meth = cls.getMethod("registerBiome", Biome.class);
			meth.invoke(null, biome);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}

