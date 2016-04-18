package carboniferous.lib;

import carboniferous.api.Properties;
import net.minecraft.util.ResourceLocation;

/**
 * @author ProPercivalalb
 */
public class ResourceReference {

	public static final ResourceLocation guiGrinder = new ResourceLocation(Properties.PACKAGE, getGuiTexturePath("grind.png"));
	public static final ResourceLocation guiGrinderCog = new ResourceLocation(Properties.PACKAGE, getGuiTexturePath("grindCog.png"));
	public static final ResourceLocation blockCompressor = new ResourceLocation(Properties.PACKAGE, getModelTexturePath("compressor.png"));
	public static final ResourceLocation blockGrinder = new ResourceLocation(Properties.PACKAGE, getModelTexturePath("grinder.png"));
	
	public static final ResourceLocation mobAmmonite = new ResourceLocation(Properties.PACKAGE, getMobTexturePath("ammonite.png"));
	public static final ResourceLocation mobBrachiopod = new ResourceLocation(Properties.PACKAGE, getMobTexturePath("brachiopod.png"));
	public static final ResourceLocation mobCrab = new ResourceLocation(Properties.PACKAGE, getMobTexturePath("crab.png"));
	public static final ResourceLocation mobCrassigyrinus = new ResourceLocation(Properties.PACKAGE, getMobTexturePath("crassigyrinus.png"));
	public static final ResourceLocation mobDendrerpeton = new ResourceLocation(Properties.PACKAGE, getMobTexturePath("dendrerpeton.png"));
	public static final ResourceLocation mobDimetrodon = new ResourceLocation(Properties.PACKAGE, getMobTexturePath("dimetrodon.png"));
	public static final ResourceLocation mobDragonfly = new ResourceLocation(Properties.PACKAGE, getMobTexturePath("dragonfly.png"));
	public static final ResourceLocation mobGiantMeganeura = new ResourceLocation(Properties.PACKAGE, getMobTexturePath("giantMeganeura.png"));
	public static final ResourceLocation mobMesothelae = new ResourceLocation(Properties.PACKAGE, getMobTexturePath("mesothelae.png"));
	public static final ResourceLocation mobOrthacanthus = new ResourceLocation(Properties.PACKAGE, getMobTexturePath("orthacanthus.png"));
	
	
    public static String getGuiTexturePath(String textureFileName) {
	    return String.format("%s/gui/%s", new Object[] {getOverrideTexturesPath(), textureFileName});
	}
	
    public static String getMobTexturePath(String textureFileName) {
	    return String.format("%s/mobs/%s", new Object[] {getOverrideTexturesPath(), textureFileName});
	}
	
    public static String getModelTexturePath(String textureFileName) {
	    return String.format("%s/item/%s", new Object[] {getOverrideTexturesPath(), textureFileName});
	}
    
    /**
     * Gets the location of the mods textures.
     * @return The default texture local
     */
	private static String getOverrideTexturesPath() {
	    return "textures";
	}
}
