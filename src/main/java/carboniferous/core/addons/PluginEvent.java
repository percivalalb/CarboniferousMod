package carboniferous.core.addons;

import cpw.mods.fml.common.eventhandler.Event;

/**
 * These events are fired during FML @PostInit to manage plugins
 */
public class PluginEvent extends Event {

	/**
	 * Fired before any Carboniferous plugins is initialized
	 */
	public static class Pre extends PluginEvent {}

	/**
	 * Fired to initialize Carboniferous plugins
	 */
	public static class Init extends PluginEvent {}

	/**
	 * Fired after every Carboniferous plugin is initialized
	 */
	public static class Post extends PluginEvent {}

}
