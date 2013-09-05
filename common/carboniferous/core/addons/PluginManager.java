package carboniferous.core.addons;

import carboniferous.CarboniferousMod;

import com.google.common.base.Optional;

/**
 * @author ProPercivalalb
 **/
public class PluginManager extends Api  {
	
	public static void activatePlugins()  {
		Api.pluginBus.get().post(new PluginEvent.Pre());
		Api.pluginBus.get().post(new PluginEvent.Init());
		Api.pluginBus.get().post(new PluginEvent.Post());
		Api.pluginBus = Optional.absent();
	}
}
