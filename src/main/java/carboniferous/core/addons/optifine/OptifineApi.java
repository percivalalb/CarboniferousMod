package carboniferous.core.addons.optifine;

import java.lang.reflect.Field;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;

/**
 * @author ProPercivalalb
 **/
public class OptifineApi {

	protected boolean hasTreeSetting;
	protected Field treeField;
	
	protected OptifineApi() {
		try {
			this.treeField = GameSettings.class.getField(OptifinePlugin.TREE_SETTING_NAME);
			Object field = this.treeField.get(Minecraft.getMinecraft().gameSettings);
			if(field instanceof Integer) {
				this.hasTreeSetting = true;
			}
		}	
		catch (Exception e) {
			this.hasTreeSetting = false;
		} 
	}
	
	public int getTreeSetting() {
		try {
			return (Integer)this.treeField.get(Minecraft.getMinecraft().gameSettings);
		}	
		catch (Exception e) {} 
		return 0;
	}
}
