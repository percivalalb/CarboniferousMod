package carboniferous.client.model;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.MathHelper;

/**
 * @author ProPercivalalb
 */
public class ModelQuiver extends ModelBiped {

    ModelRenderer quiverPouch;
    ModelRenderer quiverTop;
    ModelRenderer Shape1;
  
    public ModelQuiver() {
    	textureWidth = 64;
    	textureHeight = 32;
    
    	quiverPouch = new ModelRenderer(this, 0, 0);
    	quiverPouch.addBox(0F, 0F, 0F, 4, 10, 2);
    	quiverPouch.setRotationPoint(-3.5F, 2F, 2F);
    	quiverPouch.setTextureSize(64, 32);
    	quiverPouch.mirror = true;
    	setRotation(quiverPouch, 0F, 0F, -0.3346075F);
    	quiverTop = new ModelRenderer(this, 0, 12);
    	quiverTop.addBox(-1F, 0F, 0F, 6, 1, 2);
    	quiverTop.setRotationPoint(-3.5F, 2F, 2F);
    	quiverTop.setTextureSize(64, 32);
    	quiverTop.mirror = true;
    	setRotation(quiverTop, 0F, 0F, -0.3346145F);
    	Shape1 = new ModelRenderer(this, 0, 15);
    	Shape1.addBox(0F, 0F, 2F, 4, 1, 1);
    	Shape1.setRotationPoint(-3.5F, 2F, 2F);
    	Shape1.setTextureSize(64, 32);
      	Shape1.mirror = true;
      	setRotation(Shape1, 0F, 0F, -0.3346145F);
    }
  
    public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7) {
    	this.setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);
    	if(par1Entity instanceof EntityLiving) {
    		this.isChild = ((EntityLiving)par1Entity).isChild();
    	}
    	
    	if (this.isChild) {
            float f6 = 2.0F;
            GL11.glPushMatrix();
            GL11.glScalef(1.5F / f6, 1.5F / f6, 1.5F / f6);
            GL11.glTranslatef(0.0F, 16.0F * par7, 0.0F);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glScalef(1.0F / f6, 1.0F / f6, 1.0F / f6);
            GL11.glTranslatef(0.0F, 24.0F * par7, 0.0F);
        	quiverPouch.render(par7);
        	quiverTop.render(par7);
        	Shape1.render(par7);
            GL11.glPopMatrix();
        }
        else {
        	quiverPouch.render(par7);
        	quiverTop.render(par7);
        	Shape1.render(par7);
        }
  	}
  
  	private void setRotation(ModelRenderer model, float x, float y, float z) {
  		model.rotateAngleX = x;
  		model.rotateAngleY = y;
  		model.rotateAngleZ = z;
  	}
  
  	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
        float f6;
        float f7;

        if (this.onGround > -9990.0F) {
            f6 = this.onGround;
            this.quiverPouch.rotateAngleY = MathHelper.sin(MathHelper.sqrt_float(f6) * (float)Math.PI * 2.0F) * 0.2F;
            this.quiverTop.rotateAngleY = MathHelper.sin(MathHelper.sqrt_float(f6) * (float)Math.PI * 2.0F) * 0.2F;
            this.Shape1.rotateAngleY = MathHelper.sin(MathHelper.sqrt_float(f6) * (float)Math.PI * 2.0F) * 0.2F;
        }

        if (par7Entity.isSneaking()) {
            this.quiverPouch.rotateAngleX = 0.5F;
            this.quiverTop.rotateAngleX = 0.5F;
            this.Shape1.rotateAngleX = 0.5F;
        }
        else {
            this.quiverPouch.rotateAngleX = 0.0F;
            this.quiverTop.rotateAngleX = 0.0F;
            this.Shape1.rotateAngleX = 0.0F;
        }
  	}
}
