package carboniferous.api;

import net.minecraftforge.event.Event;

/**
 * @author ProPercivalalb
 */
public class ModEvents {

	//Equivalent of {@link FMLPreInitializationEvent} but definitely fired after the Carboniferous Mod.
	public static class PreInit extends Event {}
	
	//Equivalent of {@link FMLInitializationEvent} but definitely fired after the Carboniferous Mod.
	public static class Init extends Event {}
	
	//Equivalent of {@link FMLPostInitializationEvent} but definitely fired after the Carboniferous Mod.
	public static class PostInit extends Event {}
}
