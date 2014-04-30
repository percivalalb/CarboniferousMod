package carboniferous.core.addons.nei;

import java.util.logging.Level;

import carboniferous.CarboniferousMod;
import carboniferous.ModBlocks;
import carboniferous.ModItems;
import carboniferous.api.Properties;
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
	    API.setMaxDamageException(ModBlocks.multiBlock1.blockID, 14);
	    API.setMaxDamageException(ModBlocks.multiBlock2.blockID, 14);
	    API.setMaxDamageException(ModBlocks.pillars.blockID, 2);
	    API.setMaxDamageException(ModBlocks.coral.blockID, 4);
	    
	    API.setMaxDamageException(ModItems.grindingStones.itemID, 1);
	    API.setMaxDamageException(ModItems.multiItems.itemID, 17);
	    
	    //Hide Items
	    API.hideItem(ModBlocks.woodDoubleSlab.blockID);
	    API.hideItem(ModBlocks.wallShell.blockID);
	    API.hideItem(ModBlocks.doorLepidodendron.blockID);
	    API.hideItem(ModBlocks.doorCalamites.blockID);
	    API.hideItem(ModBlocks.doorCordaites.blockID);
	    API.hideItem(ModBlocks.doorSigillaria.blockID);
	    API.hideItem(ModBlocks.doorAmphibian.blockID);
	    
	    //TODO FurnaceRecipeHandler.efuels.add(ModBlocks.doorLepidodendron.blockID);
	    //TODO FurnaceRecipeHandler.efuels.add(ModBlocks.doorCalamites.blockID);
	    //TODO FurnaceRecipeHandler.efuels.add(ModBlocks.doorCordaites.blockID);
	    //TODO FurnaceRecipeHandler.efuels.add(ModBlocks.doorSigillaria.blockID);
	    //TODO FurnaceRecipeHandler.efuels.add(ModBlocks.doorAmphibian.blockID);
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
