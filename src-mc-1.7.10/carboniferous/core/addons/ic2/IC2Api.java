package carboniferous.core.addons.ic2;

import com.google.common.base.Optional;

import carboniferous.core.helper.ReflectionHelper;
import net.minecraft.world.biome.BiomeGenBase;

public class IC2Api {

	private Optional<Class> cropsClass = Optional.absent();
	private Optional<Object> cropsInstance = Optional.absent();
	
	protected IC2Api() {
		cropsClass = Optional.fromNullable(ReflectionHelper.getClassForName("ic2.api.crops.Crops"));
		cropsInstance = Optional.fromNullable(ReflectionHelper.getField(cropsClass.get(), Object.class, null, "instance"));
	}

	protected void addBiomeBonus(BiomeGenBase biome, int humidityBonus, int nutrientsBonus) {
		if(!cropsClass.isPresent() || !cropsInstance.isPresent()) return;
		Class[]  classes = new Class[] {BiomeGenBase.class, Integer.TYPE, Integer.TYPE};
		Object[] param   = new Object[]{biome, humidityBonus, nutrientsBonus};
		ReflectionHelper.invokeMethod(cropsClass.get(), cropsInstance.get(), "addBiomeBonus", classes, param);
	}
}
