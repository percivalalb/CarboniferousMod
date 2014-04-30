package carboniferous.core.addons.thermalexpansion;

import java.lang.reflect.Method;

import net.minecraft.item.ItemStack;

import com.google.common.base.Optional;

public class ThermalExpansionApi {

    private Optional<Object> craftingHelpers            = Optional.absent();

    private Optional<Method> addSawmillLogToPlankRecipe = Optional.absent();

    ThermalExpansionApi() {
        try {
            Class cls = Class.forName("thermalexpansion.api.crafting.CraftingHelpers");
            addSawmillLogToPlankRecipe = Optional.fromNullable(cls.getMethod("addSawmillLogToPlankRecipe", ItemStack.class, ItemStack.class));
            craftingHelpers = Optional.of(cls.newInstance());
        } 
        catch (Exception e) {
            e.printStackTrace();
            craftingHelpers = Optional.absent();
            addSawmillLogToPlankRecipe = Optional.absent();
        }
    }

    public void addSawmillLogToPlankRecipe(ItemStack inputLog, ItemStack outputPlanks) {
        if (!craftingHelpers.isPresent() || !addSawmillLogToPlankRecipe.isPresent()) {
        	return;
        }
        try {
            addSawmillLogToPlankRecipe.get().invoke(craftingHelpers.get(), inputLog, outputPlanks);
        } 
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
