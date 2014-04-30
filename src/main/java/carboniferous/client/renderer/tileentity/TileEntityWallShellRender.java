package carboniferous.client.renderer.tileentity;

import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import carboniferous.lib.ResourceReference;
import carboniferous.tileentity.TileEntityWallShell;

public class TileEntityWallShellRender extends TileEntitySpecialRenderer {

	public void renderTileEntityAt(TileEntity var1, double var2, double var4, double var6, float var8) {
		TileEntityWallShell shell = (TileEntityWallShell)var1;
		if(!shell.hasShell()) return;
		//TODO if(Item.getItemById([shell.getShellID()) == null) return;
		GL11.glPushMatrix();
		GL11.glTranslatef((float)var2, (float)var4, (float)var6);

		GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
		int meta = shell.getBlockMetadata();

		switch(meta) {
		case 0:
			GL11.glTranslatef(1.0F, 0.0F, -0.25F);
			GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
			break;
		case 1:
			GL11.glTranslatef(0.75F, 0.0F, -1.0F);
			GL11.glRotatef(0.0F, 0.0F, 1.0F, 0.0F);
			break;
		case 2:
			GL11.glTranslatef(0.0F, 0.0F, -0.75F);
			GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
			break;
		case 3:
			GL11.glTranslatef(0.25F, 0.0F, 0.0F);
			GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
			break;
		}
		GL11.glColor3f(1.0F, 1.0F, 1.0F);
		this.bindTexture(TextureMap.locationItemsTexture);
		this.renderItem(shell.getShellItem().getIconFromDamage(shell.getShellMetadata()));
		GL11.glPopMatrix();
	}
	
	public void renderItem(IIcon icon) {
	    GL11.glPushMatrix();
	    Tessellator tessellator = Tessellator.instance;
	    float f = icon.getMinU();
        float f1 = icon.getMaxU();
        float f2 = icon.getMinV();
        float f3 = icon.getMaxV();
	    float f4 = -0.05F;
	    float f5 = 0.20F;
	    GL11.glEnable(GL12.GL_RESCALE_NORMAL /**32826**/);
	    GL11.glTranslatef(-f4, -f5, 0.0F);
	    float scale = 0.7F; //Relative to 1.0F
	    GL11.glScalef(scale, scale, scale);
	    GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
	    GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
	    GL11.glTranslatef(-0.9375F, -0.0625F, 0.0F);
	    ItemRenderer.renderItemIn2D(tessellator, f1, f2, f, f3, icon.getIconWidth(), icon.getIconHeight(), 0.0625F);
	    GL11.glDisable(GL12.GL_RESCALE_NORMAL /**32826**/);
	    GL11.glPopMatrix();
	}
}