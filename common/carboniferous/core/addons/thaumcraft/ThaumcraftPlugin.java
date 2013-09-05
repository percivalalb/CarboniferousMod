package carboniferous.core.addons.thaumcraft;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;

import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;

import carboniferous.CarboniferousMod;
import carboniferous.ModBlocks;
import carboniferous.api.Properties;
import carboniferous.world.biome.BiomeGenBaseCarboniferous;
import carboniferous.core.helper.LogHelper;
import carboniferous.core.addons.PluginEvent;

import com.google.common.base.Optional;
import com.google.common.collect.Lists;

import cpw.mods.fml.common.Loader;

public class ThaumcraftPlugin {

    private static final String MOD_ID   = "Thaumcraft";
    private static final String MOD_NAME = "Thaumcraft 3";
    private Optional<ThaumcraftApi> api = Optional.absent();
    
    public void registerItemAspects() {
    	 registerItemAspects(ModBlocks.logs_1.blockID, -1, Arrays.asList(32), Arrays.asList(4));
         registerItemAspects(ModBlocks.planks_1.blockID, -1, Arrays.asList(32), Arrays.asList(1));
         registerItemAspects(ModBlocks.planks_1.blockID, -1, Arrays.asList(32), Arrays.asList(4));
         registerItemAspects(ModBlocks.multiBlock1.blockID, 0, Arrays.asList(11), Arrays.asList(2));
         registerItemAspects(ModBlocks.multiBlock1.blockID, 1, Arrays.asList(11, 7), Arrays.asList(1, 1));
         registerItemAspects(ModBlocks.multiBlock1.blockID, 2, Arrays.asList(11), Arrays.asList(2));
         registerItemAspects(ModBlocks.dirt.blockID, 0, Arrays.asList(16), Arrays.asList(2));
         registerItemAspects(ModBlocks.grass.blockID, 0, Arrays.asList(32, 16), Arrays.asList(1, 2));
    }
    
    public void registerBiomeInfo() {
    	registerBiomeInfo(BiomeGenBaseCarboniferous.rainforest, 850, 32, "Lignum", false, false);
        registerBiomeInfo(BiomeGenBaseCarboniferous.calamitesSwamp, 21, 600, "Aqua", false, false);
        registerBiomeInfo(BiomeGenBaseCarboniferous.carboniferousOcean, 300, 21, "Aqua", false, false);
        registerBiomeInfo(BiomeGenBaseCarboniferous.carboniferousRiver, 250, 21, "Aqua", false, false);
        registerBiomeInfo(BiomeGenBaseCarboniferous.coalSwamp, 550, 36, "Herba", false, false);
        registerBiomeInfo(BiomeGenBaseCarboniferous.highlands, 450, 11, "Saxum", false, false);
        registerBiomeInfo(BiomeGenBaseCarboniferous.island, 350, 21, "Aqua", false, false);
        registerBiomeInfo(BiomeGenBaseCarboniferous.coalSwamp, 330, 36, "Herba", false, false);
    }
    
    @ForgeSubscribe
    public void init(PluginEvent.Init event) {
        if (!api.isPresent()) {
        	return;
        }
        
        registerItemAspects();
        registerBiomeInfo();
    }
    
    protected void registerItemAspects(int blockID, int meta, List<Integer> aspectsID, List<Integer> aspectsAmount) {
    	api.get().registerItemAspects(blockID, meta, aspectsID, aspectsAmount);
    }
    
    protected void registerBiomeInfo(BiomeGenBase biome, int visLevel, int tagID, String tagName, boolean greatwood, boolean silverwood) {
    	api.get().registerBiomeInfo(biome, visLevel, tagID, tagName, greatwood, silverwood);
    }

    @ForgeSubscribe
    public void postInit(PluginEvent.Post event) {
        api = Optional.absent();
    }

    @ForgeSubscribe
    public void preInit(PluginEvent.Pre event) {
        if (!Loader.isModLoaded(MOD_ID)) {
        	return;
        }
        LogHelper.log(Level.INFO, "Loaded " + MOD_NAME + " Addon");
        try {
            api = Optional.of(new ThaumcraftApi());
        } 
        catch (Exception ex)  {
            LogHelper.log(Level.WARNING, "Failed to load " + MOD_NAME + " Addon" );
            api = Optional.absent();
        }
    }

}
