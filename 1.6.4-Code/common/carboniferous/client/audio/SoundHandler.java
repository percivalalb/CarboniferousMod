package carboniferous.client.audio;

import java.io.File;
import java.util.logging.Level;

import carboniferous.CarboniferousMod;
import carboniferous.api.Properties;
import carboniferous.core.helper.LogHelper;

import net.minecraft.client.audio.SoundManager;
import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

/**
 * @author ProPercivalalb
 **/
public class SoundHandler {
   
	@ForgeSubscribe
    public void loadSounds(SoundLoadEvent event) {
    	 try {
    		 SoundManager manager = event.manager;
    		 //Clam
             registerSound(manager, Properties.SOUND_PATH_BRACHIOPOD_SLAM);  
             //Dimetrodon
             registerSound(manager, Properties.SOUND_PATH_DIMETRODON_LIVING_1);  
             registerSound(manager, Properties.SOUND_PATH_DIMETRODON_LIVING_2);  
             registerSound(manager, Properties.SOUND_PATH_DIMETRODON_HURT);  
             registerSound(manager, Properties.SOUND_PATH_DIMETRODON_DEATH);  
             //Grinder
             registerSound(manager, Properties.SOUND_PATH_GRIND_1);  
             registerSound(manager, Properties.SOUND_PATH_GRIND_2);    
    	 } 
         catch(Exception e){
             LogHelper.log(Level.WARNING, "Failed to register one or more sounds.");
         }
    }

    public void registerSound(SoundManager manager, String soundName) {
    	manager.soundPoolSounds.addSound(Properties.TEX_PACkAGE + soundName);
    }
}