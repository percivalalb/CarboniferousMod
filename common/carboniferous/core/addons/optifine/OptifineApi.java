package carboniferous.core.addons.optifine;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;

/**
 * @author ProPercivalalb
 **/
public class OptifineApi {

	protected boolean hasTreeSetting;
	
	protected OptifineApi() {
		try {
			Object field = GameSettings.class.getField(OptifinePlugin.TREE_SETTING_NAME).get(Minecraft.getMinecraft().gameSettings);
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
			Object field = GameSettings.class.getField(OptifinePlugin.TREE_SETTING_NAME).get(Minecraft.getMinecraft().gameSettings);
			if(field instanceof Integer) {
				return (Integer)field;
			}
		}	
		catch (Exception e) {} 
		return 0;
	}
}
