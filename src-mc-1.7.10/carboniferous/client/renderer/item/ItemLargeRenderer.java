package carboniferous.client.renderer.item;

import carboniferous.api.interfaces.ILargeItem;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public class ItemLargeRenderer implements IItemRenderer {

	Minecraft mc = Minecraft.getMinecraft();
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		if(item.getItem() instanceof ILargeItem) {
	    	ILargeItem largeItem = (ILargeItem)item.getItem();
	    	if(largeItem.canBeLargeItem(item)) {
	    		return type == IItemRenderer.ItemRenderType.EQUIPPED;
	    	}
	    }
		return false;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return false;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		/**
		GL11.glPushMatrix(); //Start Rendering
		GL11.glTranslatef(-0.5F, -0.5F, 0.0F); //Move the Item Render
	    GL11.glScalef(2.0F, 2.0F, 1.0F); //Scale the Item Render
	    String texture = Properties.TEX_ITEM_LARGE + "#.png"; //Texture path
	    if(item.getItem() instanceof ILargeItem) {
	    	ILargeItem largeItem = (ILargeItem)item.getItem();
	    	String largeItemPath = largeItem.getTexture(item);
	    	if(largeItemPath != null) {
	    		texture.replace("#", largeItemPath);
	    	}
	    }
	    this.mc.renderEngine.bindTexture(texture); //Bind Texture
	    int textureHeight = TextureFXManager.instance().getTextureDimensions(texture).height; //Texture Height
	    int textureWidth = TextureFXManager.instance().getTextureDimensions(texture).width; //Texture Width
	    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F); //Colour the Item Render
        Tessellator tessellator = Tessellator.instance; //Tessellator instance
        ItemRenderer.renderItemIn2D(tessellator, 1.0F, 0.0F, 0.0F, 1.0F, textureWidth, textureHeight, 0.0625F);

        if (item != null && item.hasEffect()) {
            GL11.glDepthFunc(GL11.GL_EQUAL);
            GL11.glDisable(GL11.GL_LIGHTING);
            this.mc.renderEngine.bindTexture("%blur%/misc/glint.png");
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glBlendFunc(GL11.GL_SRC_COLOR, GL11.GL_ONE);
            float f7 = 0.76F;
            GL11.glColor4f(0.5F * f7, 0.25F * f7, 0.8F * f7, 1.0F);
            GL11.glMatrixMode(GL11.GL_TEXTURE);
            GL11.glPushMatrix();
            float f8 = 0.125F;
            GL11.glScalef(f8, f8, f8);
            float f9 = (float)(Minecraft.getSystemTime() % 3000L) / 3000.0F * 8.0F;
            GL11.glTranslatef(f9, 0.0F, 0.0F);
            GL11.glRotatef(-50.0F, 0.0F, 0.0F, 1.0F);
            ItemRenderer.renderItemIn2D(tessellator, 0.0F, 0.0F, 1.0F, 1.0F, 256, 256, 0.0625F);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glScalef(f8, f8, f8);
            f9 = (float)(Minecraft.getSystemTime() % 4873L) / 4873.0F * 8.0F;
            GL11.glTranslatef(-f9, 0.0F, 0.0F);
            GL11.glRotatef(10.0F, 0.0F, 0.0F, 1.0F);
            ItemRenderer.renderItemIn2D(tessellator, 0.0F, 0.0F, 1.0F, 1.0F, 256, 256, 0.0625F);
            GL11.glPopMatrix();
            GL11.glMatrixMode(GL11.GL_MODELVIEW);
            GL11.glDisable(GL11.GL_BLEND);
            GL11.glEnable(GL11.GL_LIGHTING);
            GL11.glDepthFunc(GL11.GL_LEQUAL);
        }

        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        
        //Stop rendering
        GL11.glPopMatrix();
        **/
	}

}
