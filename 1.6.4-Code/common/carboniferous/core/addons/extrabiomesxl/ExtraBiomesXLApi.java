package carboniferous.core.addons.extrabiomesxl;

import java.lang.reflect.Method;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.Event;

import com.google.common.base.Optional;

/**
 * @author ProPercivalalb
 **/
public class ExtraBiomesXLApi {

	public Optional<Class>	eventLogTurner	= Optional.absent();

	protected ExtraBiomesXLApi() {
		Class cls;
		try {
			cls = Class.forName("extrabiomes.api.UseLogTurnerEvent");
			eventLogTurner = Optional.fromNullable(cls);
		} 
		catch (Exception e) {
			eventLogTurner = Optional.absent();
		}
	}
}
