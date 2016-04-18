package codechicken.nei.api;

import carboniferous.client.gui.inventory.GuiGrinder;
import carboniferous.core.addons.nei.GrinderRecipeHandler;

/**
 * Dummy Class to stop there being errors in the eclispe
 * workspace and so I can recompile the mod.
 * @author ProPercivalalb
 */
@Deprecated
public class API {

	public static void hideItem(Object blockID) {}

	public static void setMaxDamageException(Object blockID, int i) {}

	public static void registerGuiOverlay(Class<GuiGrinder> class1, String string, int i, int j) {}

	public static void registerUsageHandler(GrinderRecipeHandler grinderRecipeHandler) {}

	public static void registerRecipeHandler(GrinderRecipeHandler grinderRecipeHandler) {}

	public static void registerNEIGuiHandler(INEIGuiHandler neiGuiHandler) {}
}
