package carboniferous.core.addons.ee3;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.logging.Level;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.oredict.OreDictionary;

import carboniferous.ModBlocks;
import carboniferous.api.Properties;
import carboniferous.world.biome.BiomeGenBaseCarboniferous;
import carboniferous.core.helper.LogHelper;
import carboniferous.core.addons.PluginEvent;
import carboniferous.core.addons.extrabiomesxl.ExtraBiomesXLApi;
import carboniferous.core.addons.extrabiomesxl.ExtraBiomesXLEvent;

import com.google.common.base.Optional;
import com.google.common.collect.Lists;

import cpw.mods.fml.common.Loader;

public class EE3Plugin {

    private static final String MOD_ID   = "EE3";
    private static final String MOD_NAME = "Equivalent Exchange 3";
    private Optional<EE3Api> api = Optional.absent();

    protected void initEquivalencyList() {
    	addWorldTransmutationRecipe(ModBlocks.dirt, new ItemStack(ModBlocks.multiBlock1, 1, 1), ModBlocks.grass);
    	addWorldTransmutationRecipe(getMetaCycle(ModBlocks.logs_1, 4));
    	addWorldTransmutationRecipe(getMetaCycle(ModBlocks.planks_1, 4));
    	addWorldTransmutationRecipe(getMetaCycle(ModBlocks.leaves_1, 4));
    	addWorldTransmutationRecipe(getMetaCycle(ModBlocks.woodSingleSlab, 4));
    	addWorldTransmutationRecipe(getMetaCycle(ModBlocks.woodDoubleSlab, 4));
    	addWorldTransmutationRecipe(getMetaCycle(ModBlocks.saplings_1, 4));
    	addWorldTransmutationRecipe(ModBlocks.stairsLepidodendron, ModBlocks.stairsCalamites, ModBlocks.stairsCordaites, ModBlocks.stairsSigillaria);
    	
    	for(int var1 = 0; var1 < 4; ++var1) {
    		addTransmutationRecipe(new ItemStack(ModBlocks.logs_1, 1, var1), new ItemStack(ModBlocks.planks_1, 1, var1), new ItemStack(ModBlocks.planks_1, 1, var1), new ItemStack(ModBlocks.planks_1, 1, var1), new ItemStack(ModBlocks.planks_1, 1, var1));
    	}
 
    }

    
    @ForgeSubscribe
    public void init(PluginEvent.Init event) {
        if (!api.isPresent()) {
        	return;
        }
        
        initEquivalencyList();
    }
    
    public Object[] getMetaCycle(Object input, int n) {
    	return api.get().getMetaCycle(input, n);
    }

    
    protected void addTransmutationRecipe(ItemStack output, Object... input) {
    	api.get().addTransmutationRecipe(output, input);
    }
    
    protected void addWorldTransmutationRecipe(Object... objList) {
    	api.get().addWorldTransmutationRecipe(objList);
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
            api = Optional.of(new EE3Api());
        } 
        catch (Exception ex)  {
            LogHelper.log(Level.WARNING, "Failed to load " + MOD_NAME + " Addon" );
            api = Optional.absent();
        }
    }

}
