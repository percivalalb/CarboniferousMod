package carboniferous.core.helper;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;

/**
 * @author ProPercivalalb
 */
public class GuiHelper {

	//Reference to the static #Minecraft instance
	public static Minecraft mc = Minecraft.getMinecraft();
	//Reference to the static #Tessellator instance
	public static Tessellator tessellator = Tessellator.instance;
	
	public static void bindTexture(ResourceLocation resource) {
		mc.getTextureManager().bindTexture(resource);
	}
	
	public static void glColourDefault() {
		glColour(1.0F, 1.0F, 1.0F, 1.0F);
	}
	
	public static void glColour(float par1, float par2, float par3, float par4) {
		GL11.glColor4f(par1, par2, par3, par4);
	}
    
    public static void drawTexturedModalRect(int par1, int par2, int par3, int par4, int par5, int par6) {
    	drawTexturedModalRect(par1, par2, par3, par4, par5, par6, 0.0F);
    }
    
    /**
     * Same as #Gui.drawTexturedModalRect draws a rectangle at the position
     */
    public static void drawTexturedModalRect(int par1, int par2, int par3, int par4, int par5, int par6, float zLevel) {
        float f = 0.00390625F;
        float f1 = 0.00390625F;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV((double)(par1 + 0), (double)(par2 + par6), (double)zLevel, (double)((float)(par3 + 0) * f), (double)((float)(par4 + par6) * f1));
        tessellator.addVertexWithUV((double)(par1 + par5), (double)(par2 + par6), (double)zLevel, (double)((float)(par3 + par5) * f), (double)((float)(par4 + par6) * f1));
        tessellator.addVertexWithUV((double)(par1 + par5), (double)(par2 + 0), (double)zLevel, (double)((float)(par3 + par5) * f), (double)((float)(par4 + 0) * f1));
        tessellator.addVertexWithUV((double)(par1 + 0), (double)(par2 + 0), (double)zLevel, (double)((float)(par3 + 0) * f), (double)((float)(par4 + 0) * f1));
        tessellator.draw();
    }
    
    /**
	 * Draws a progress bar
     * @param gui Drawing class
     * @param x X position on screen
     * @param y Y position on screen
     * @param tx Texture X position
     * @param ty Texture Y position
     * @param w Texture width
     * @param h Texture height
     * @param completion Which ever direction the number is the amount of pixels it will go
     * @param direction 0 right, 1 down, 2 left, 3 up. If bit 3 is set the bar will shrink rather extend
     */
	public static void drawProgressBar(int x, int y, int tx, int ty, int w, int h, int completion, int direction) {
		switch(direction) {
		case 0: //Right
            drawTexturedModalRect(x, y, tx, ty, completion, h);
            break;
        case 1: //Down
            drawTexturedModalRect(x, y, tx, ty, w, completion);
            break;
        case 2: //Left
            drawTexturedModalRect(x + w - completion, y, tx+w-completion, ty, completion, h);
            break;
        case 3: //Up
            drawTexturedModalRect(x, y + h - completion, tx, ty + h - completion, w, completion);
            break;  
		}
    }
	
	/**
	 * Draws a Centred Font
	 * @param font The front render
	 * @param str The string wanted to be drawn
	 * @param x The x position on the screen
	 * @param y The y position on the screen
 	 * @param color The hex colour
	 */
    public static void drawCenteredString(FontRenderer font, String str, int x, int y, int color) {
    	font.drawString(str, x - font.getStringWidth(str) / 2, y, color);
    }
}
