package carboniferous.core.addons.extrabiomesxl;

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
