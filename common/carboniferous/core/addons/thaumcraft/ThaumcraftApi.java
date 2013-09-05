package carboniferous.core.addons.thaumcraft;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.EnumSet;
import java.util.List;
import java.util.logging.Level;

import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;

import carboniferous.api.Properties;
import carboniferous.core.helper.LogHelper;
import carboniferous.core.helper.ReflectionHelper;

import com.google.common.base.Optional;

/**
 * @author ProPercivalalb
 **/
public class ThaumcraftApi {
	
	//Classes
	private Optional<Class> 	mainThaumcraftClass 	= Optional.absent();
	private Optional<Class> 	objectTagClass 			= Optional.absent();
	private Optional<Class> 	enumTagClass 			= Optional.absent();
	//Methods
	private Optional<Method> 	registerBiomeInfo	    = Optional.absent();
	private Optional<Method> 	getEnumTagFromId	    = Optional.absent();
	
	public ThaumcraftApi() {
		//Main Thaumcraft API Class
        this.mainThaumcraftClass = Optional.fromNullable(ReflectionHelper.getClassForName("thaumcraft.api.ThaumcraftApi"));
		//Object Tag Class
        this.objectTagClass = Optional.fromNullable(ReflectionHelper.getClassForName("thaumcraft.api.ObjectTags"));
        //Enum Tag Class
        this.enumTagClass = Optional.fromNullable(ReflectionHelper.getClassForName("thaumcraft.api.EnumTag"));
        
        //Register Biome Info Method
        if(this.mainThaumcraftClass.isPresent() && this.objectTagClass.isPresent())
		this.registerBiomeInfo = Optional.fromNullable(ReflectionHelper.getMethod(this.mainThaumcraftClass.get(), "registerBiomeInfo", Integer.TYPE, Integer.TYPE, this.enumTagClass.get(), Boolean.TYPE, Boolean.TYPE));
        //Get Enum Tag from Id Method
        if(this.enumTagClass.isPresent())
        this.getEnumTagFromId = Optional.fromNullable(ReflectionHelper.getMethod(this.enumTagClass.get(), "get", Integer.TYPE));
	}
	protected void registerItemAspects(int id, int meta, List<Integer> aspectsID, List<Integer> aspectsAmount) {
		if(aspectsID == null || aspectsAmount == null || aspectsID.size() != aspectsAmount.size()) {
			return;
		}
		if(!objectTagClass.isPresent() || !enumTagClass.isPresent()) {
			return;
		}
		try {
			//TODO thaumcraft.api.ObjectTags tags = new thaumcraft.api.ObjectTags();
			for(int var1 = 0; var1 < aspectsID.size(); ++var1) {
				//TODO 	tags.add(thaumcraft.api.EnumTag.get(aspectsID.get(var1)), aspectsAmount.get(var1));
			}
			//TODO thaumcraft.api.ThaumcraftApi.registerObjectTag(id, meta, tags);
			String strAspects = "";
			//TODO for(int var1 = 0; var1 < tags.getAspects().length; ++var1) {
			//TODO 	strAspects += tags.getAspects()[var1].name + ", ";
			//TODO }
			LogHelper.log(Level.INFO, "(Thaumcraft Addon) Registred the aspects " + strAspects + "to the item (" + id + ", " + meta + ")");
		}
		catch(Exception e) {
			LogHelper.log(Level.WARNING, "(Thaumcraft Addon) Failed to add certain aspects to the item (" + id + ", " + meta + ")");
		}
	}
	
	protected void registerBiomeInfo(BiomeGenBase biome, int visLevel, int tagID, String tagName, boolean greatwood, boolean silverwood) {
		try {
			registerBiomeInfo.get().invoke(null, biome.biomeID, visLevel, getEnumTagFromId.get().invoke(enumTagClass, tagID), greatwood, silverwood);
			LogHelper.log(Level.INFO, "(Thaumcraft Addon) Configured the biome: " + biome.biomeName + " to have Vis-" + visLevel + ", Tag-" + (tagName == null ? tagID : tagName) + ", GreatWood-" + greatwood + ", SilverWood-" + silverwood);
		} 
		catch(Exception e) {
			LogHelper.log(Level.WARNING, "(Thaumcraft Addon) Failed to configure the biome: " + biome.biomeName + " with certain properties.");
		}
	}
}
