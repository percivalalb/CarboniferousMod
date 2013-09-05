package carboniferous.core.addons.buildcraft;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Random;
import java.util.logging.Level;

import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import carboniferous.api.Properties;
import carboniferous.core.helper.LogHelper;

import com.google.common.base.Optional;

/**
 * @author ProPercivalalb
 **/
public class BuildcraftApi {

    private Optional<Method> addFacade = Optional.absent();
    private boolean modifyWorld = false;
    private static Optional<Method> generateSurfaceDeposit = Optional.absent();
    boolean useRandom = false;

    protected BuildcraftApi() {
        Class cls;
        try {
            cls = Class.forName("buildcraft.api.transport.FacadeManager");
            addFacade = Optional.fromNullable(cls.getMethod("addFacade",
                    ItemStack.class));
        } catch (Exception e) {
            addFacade = Optional.absent();
        }
        try {
            cls = Class.forName("buildcraft.BuildCraftCore");
            Field fld = cls.getField("modifyWorld");
            modifyWorld = fld.getBoolean(null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            cls = Class.forName("buildcraft.energy.OilPopulate");
            generateSurfaceDeposit = Optional.fromNullable(cls.getMethod(
                    "generateSurfaceDeposit", World.class, Integer.TYPE,
                    Integer.TYPE, Integer.TYPE, Integer.TYPE));
        } catch (Exception e) {
            try {
                cls = Class.forName("buildcraft.energy.OilPopulate");
                generateSurfaceDeposit = Optional
                        .fromNullable(cls.getMethod("generateSurfaceDeposit",
                                World.class, Random.class, Integer.TYPE,
                                Integer.TYPE, Integer.TYPE, Integer.TYPE));
                useRandom = true;
            } catch (Exception ex) {
                LogHelper
                        .log(Level.WARNING,
                                "(Buildcraft Plugin) There was a problem while getting the Oil generator.");
                generateSurfaceDeposit = Optional.absent();
            }
        }
    }

    /**
     * Adds a facade with a custom metadata
     * 
     * @param blockID
     *            the block id
     * @param metadata
     *            the block meta data
     **/
    public void addBuildcraftFacade(int blockID, int metadata) {
        try {
            addFacade.get().invoke(null, new ItemStack(blockID, 1, metadata));
            LogHelper.log(Level.INFO,
                    "(Buildcraft Plugin) Registred a facade (" + blockID + ", "
                            + metadata + ")");
        } catch (Exception e) {
            LogHelper.log(Level.WARNING,
                    "(Buildcraft Plugin) Something when wrong when registring a facade ("
                            + blockID + ", " + metadata + ")");
        }
    }

    public void generateSurfaceDeposit(World world, Random rand, int x, int y,
            int z, int radius) {
        try {
            if (useRandom) {
                generateSurfaceDeposit.get().invoke(null, world, rand, x, y, z,
                        radius);
            } else {
                generateSurfaceDeposit.get().invoke(null, world, x, y, z,
                        radius);
            }
        } catch (Exception e) {
        	LogHelper.log(Level.WARNING, "Buildcraft oil generation failed. Exception caught.");
        }
    }

    boolean modifyWorld() {
        return modifyWorld;
    }
}
