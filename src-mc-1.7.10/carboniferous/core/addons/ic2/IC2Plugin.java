package carboniferous.core.addons.ic2;

import java.util.logging.Level;

import com.google.common.base.Optional;

import carboniferous.core.addons.PluginEvent;
import carboniferous.core.helper.LogHelper;
import carboniferous.world.biome.BiomeGenBaseCarboniferous;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.world.biome.BiomeGenBase;

public class IC2Plugin {

    private static final String MOD_ID   = "IC2";
    private static final String MOD_NAME = "IndustrialCraft 2";
    private Optional<IC2Api> api = Optional.absent();

    private void addBiomeBonuses() {
    	addBiomeBonus(BiomeGenBaseCarboniferous.calamitesSwamp, 2, 3);
    	addBiomeBonus(BiomeGenBaseCarboniferous.carboniferousOcean, 1, 1);
    	addBiomeBonus(BiomeGenBaseCarboniferous.carboniferousRiver, 1, 1);
    	addBiomeBonus(BiomeGenBaseCarboniferous.coalSwamp, 1, 3);
    	addBiomeBonus(BiomeGenBaseCarboniferous.highlands, 2, 2);
    	addBiomeBonus(BiomeGenBaseCarboniferous.island, 1, 3);
    	addBiomeBonus(BiomeGenBaseCarboniferous.rainforest, 2, 2);
    	addBiomeBonus(BiomeGenBaseCarboniferous.bog, 2, 2);
    }

    @SubscribeEvent
    public void init(PluginEvent.Init event) {
        if (!api.isPresent()) {
        	return;
        }
        addBiomeBonuses();
    }
    
    private void addBiomeBonus(BiomeGenBase biome, int humidityBonus, int nutrientsBonus) {
        api.get().addBiomeBonus(biome, humidityBonus, nutrientsBonus);
    }

    @SubscribeEvent
    public void postInit(PluginEvent.Post event) {
        api = Optional.absent();
    }

    @SubscribeEvent
    public void preInit(PluginEvent.Pre event) {
        if (!Loader.isModLoaded(MOD_ID)) {
        	return;
        }
        LogHelper.log(Level.INFO, "Loaded " + MOD_NAME + " Addon");
        try {
            api = Optional.of(new IC2Api());
        } 
        catch (Exception ex)  {
            LogHelper.log(Level.WARNING, "Failed to load " + MOD_NAME + " Addon" );
            api = Optional.absent();
        }
    }

}
