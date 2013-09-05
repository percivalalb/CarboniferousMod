package carboniferous.core.addons;

import net.minecraftforge.event.EventBus;

import com.google.common.base.Optional;

/**
 * @author ProPercivalalb
 **/
public class Api {

	private static final EventBus		eventBus	= new EventBus();
	public static Optional<EventBus>	pluginBus	= Optional.of(new EventBus());

	public static EventBus getCarboniferousEventBus()  {
		return eventBus;
	}

	public static void registerPlugin(Object plugin) {
		if (pluginBus.isPresent()) {
			pluginBus.get().register(plugin);
		}
	}

}
