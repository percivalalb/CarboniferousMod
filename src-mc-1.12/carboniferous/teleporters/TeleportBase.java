package carboniferous.teleporters;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.client.FMLClientHandler;

/**
 * @author ProPercivalalb
 **/
public abstract class TeleportBase {
	
	public float prevTimeInPortal;
	public float timeInPortal;
	public boolean inPortal = false;
	public int timeUntilPortal = 20;
	
	public void onTick() {
		this.prevTimeInPortal = this.timeInPortal;

        if(this.inPortal) {
            
            this.onTickInPortal();
            
        	this.timeInPortal += 0.0125F;
        	this.timeInPortal = Math.min(this.timeInPortal, 1.0F);

        	if(this.timeInPortal >= 1.0F)
        		this.onTeleport();
        	
            this.inPortal = false;
        }
        else {
            if(this.timeInPortal > 0.0F)
            	this.timeInPortal -= 0.05F;

            this.timeInPortal = Math.max(this.timeInPortal, 0.0F);
        }
        if(this.timeUntilPortal > 0) 
            this.timeUntilPortal--;
	}
	
    public void setInPortal() {
        if(this.timeUntilPortal > 0)
        	this.timeUntilPortal = 10;
        else
        	this.inPortal = true;
    }
    
    public abstract void onTickInPortal();
    public abstract void onTeleport();
}