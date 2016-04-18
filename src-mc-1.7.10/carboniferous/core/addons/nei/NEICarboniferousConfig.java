package carboniferous.core.addons.nei;

import java.util.logging.Level;

import carboniferous.ModBlocks;
import carboniferous.ModItems;
import carboniferous.client.gui.inventory.GuiGrinder;
import carboniferous.core.helper.LogHelper;
import carboniferous.lib.Reference;
import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;

/**
 * @author ProPercivalalb
 **/
public class NEICarboniferousConfig implements IConfigureNEI {

    private static final String MOD_NAME = "NotEnoughItems";
	
	@Override
	public void loadConfig() {
		LogHelper.log(Level.INFO, "Loading " + MOD_NAME + " Plugin");
	    API.registerRecipeHandler(new GrinderRecipeHandler());
	    API.registerUsageHandler(new GrinderRecipeHandler());
	    API.registerGuiOverlay(GuiGrinder.class, "carboniferous.grinder", 5, 10);
	    //Add Metadata Items
	    API.setMaxDamageException(ModBlocks.multiBlock1, 14);
	    API.setMaxDamageException(ModBlocks.multiBlock2, 14);
	    API.setMaxDamageException(ModBlocks.pillars, 2);
	    API.setMaxDamageException(ModBlocks.coral, 4);
	    
	    API.setMaxDamageException(ModItems.grindingStones, 1);
	    API.setMaxDamageException(ModItems.multiItems, 17);
	    
	    //Hide Items
	    API.hideItem(ModBlocks.woodDoubleSlab);
	    API.hideItem(ModBlocks.wallShell);
	    API.hideItem(ModBlocks.doorLepidodendron);
	    API.hideItem(ModBlocks.doorCalamites);
	    API.hideItem(ModBlocks.doorCordaites);
	    API.hideItem(ModBlocks.doorSigillaria);
	    API.hideItem(ModBlocks.doorAmphibian);
	    
	    //TODO FurnaceRecipeHandler.efuels.add(ModBlocks.doorLepidodendron);
	    //TODO FurnaceRecipeHandler.efuels.add(ModBlocks.doorCalamites);
	    //TODO FurnaceRecipeHandler.efuels.add(ModBlocks.doorCordaites);
	    //TODO FurnaceRecipeHandler.efuels.add(ModBlocks.doorSigillaria);
	    //TODO FurnaceRecipeHandler.efuels.add(ModBlocks.doorAmphibian);
	}

	@Override
	public String getName() {
		return Reference.MOD_NAME;
	}

	@Override
	public String getVersion() {
		return Reference.MOD_VERSION;
	}
}
