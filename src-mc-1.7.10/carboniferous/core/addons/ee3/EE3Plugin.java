package carboniferous.core.addons.ee3;

import java.util.logging.Level;

import com.google.common.base.Optional;

import carboniferous.ModBlocks;
import carboniferous.core.addons.PluginEvent;
import carboniferous.core.helper.LogHelper;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.item.ItemStack;

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

    
    @SubscribeEvent
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
            api = Optional.of(new EE3Api());
        } 
        catch (Exception ex)  {
            LogHelper.log(Level.WARNING, "Failed to load " + MOD_NAME + " Addon" );
            api = Optional.absent();
        }
    }

}
