package carboniferous.core.addons.extrabiomesxl;

import java.util.Collection;
import java.util.logging.Level;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;

import carboniferous.api.Properties;
import carboniferous.core.helper.LogHelper;
import carboniferous.core.addons.PluginEvent;

import com.google.common.base.Optional;
import com.google.common.collect.Lists;

import cpw.mods.fml.common.Loader;

/**
 * @author ProPercivalalb
 **/
public class ExtraBiomesXLPlugin {

    private static final String MOD_ID   = "ExtrabiomesXL";
    private static final String MOD_NAME = "ExtraBiomes XL";
    private Optional<ExtraBiomesXLApi> api = Optional.absent();

    @ForgeSubscribe
    public void init(PluginEvent.Init event) {
        if (!api.isPresent()) {
        	return;
        }

        if(api.get().eventLogTurner.isPresent()) {
        	MinecraftForge.EVENT_BUS.register(new ExtraBiomesXLEvent());
        }
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
            api = Optional.of(new ExtraBiomesXLApi());
        } 
        catch (Exception ex)  {
            LogHelper.log(Level.WARNING, "Failed to load " + MOD_NAME + " Addon" );
            api = Optional.absent();
        }
    }
}
