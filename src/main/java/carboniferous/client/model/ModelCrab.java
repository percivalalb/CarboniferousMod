package carboniferous.client.model;

import carboniferous.entity.EntityCrab;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

/**
 * @author ProPercivalalb
 */
public class ModelCrab extends ModelBase {
 
    ModelRenderer mainBody;
    ModelRenderer topBody;
    ModelRenderer armR;
    ModelRenderer armL;
    ModelRenderer handR;
    ModelRenderer handL;
    ModelRenderer legRBack;
    ModelRenderer legRFront;
    ModelRenderer leglBack;
    ModelRenderer legLFront;
    ModelRenderer eyeR;
    ModelRenderer eyeL;
  
    public ModelCrab() {
    	textureWidth = 64;
    	textureHeight = 32;
    
    	mainBody = new ModelRenderer(this, 0, 10);
    	mainBody.addBox(0F, 0F, 0F, 4, 2, 6);
    	mainBody.setRotationPoint(-2F, 20F, -3F);
    	mainBody.setTextureSize(64, 32);
    	setRotation(mainBody, 0F, 0F, 0F);
    	topBody = new ModelRenderer(this, 6, 4);
    	topBody.addBox(0F, 0F, 0F, 2, 1, 4);
    	topBody.setRotationPoint(-1F, 19F, -2F);
      	topBody.setTextureSize(64, 32);
      	setRotation(topBody, 0F, 0F, 0F);
      	armR = new ModelRenderer(this, 19, 0);
      	armR.addBox(0F, 0F, 0F, 2, 1, 3);
      	armR.setRotationPoint(-1F, 20F, -6F);
      	armR.setTextureSize(64, 32);
      	setRotation(armR, 0F, 0F, 0F);
      	armL = new ModelRenderer(this, 29, 0);
      	armL.addBox(0F, 0F, 0F, 2, 1, 3);
      	armL.setRotationPoint(-1F, 20F, 3F);
      	armL.setTextureSize(64, 32);
      	setRotation(armL, 0F, 0F, 0F);
      	handR = new ModelRenderer(this, 8, 0);
      	handR.addBox(0F, -1F, -2F, 2, 1, 2);
      	handR.setRotationPoint(-1F, 20F, -4.1F);
      	handR.setTextureSize(64, 32);
      	setRotation(handR, 0F, 0F, 0F);
      	handL = new ModelRenderer(this, 0, 0);
      	handL.addBox(0F, -1F, 0F, 2, 1, 2);
      	handL.setRotationPoint(-1F, 20F, 4.1F);
      	handL.setTextureSize(64, 32);
      	setRotation(handL, 0F, 0F, 0F);
      	legRBack = new ModelRenderer(this, 0, 6);
      	legRBack.addBox(0F, 0F, 0F, 1, 3, 1);
      	legRBack.setRotationPoint(-1.5F, 21F, -2F);
      	legRBack.setTextureSize(64, 32);
      	setRotation(legRBack, -0.852925F, 0F, 0F);
      	legRFront = new ModelRenderer(this, 0, 6);
      	legRFront.addBox(0F, 0F, 0F, 1, 3, 1);
      	legRFront.setRotationPoint(0.5F, 21F, -2F);
      	legRFront.setTextureSize(64, 32);
      	setRotation(legRFront, -0.852925F, 0F, 0F);
      	leglBack = new ModelRenderer(this, 0, 6);
      	leglBack.addBox(0F, 0F, -1F, 1, 3, 1);
      	leglBack.setRotationPoint(0.5F, 21F, 2F);
      	leglBack.setTextureSize(64, 32);
      	setRotation(leglBack, 0.852925F, 0F, 0F);
      	legLFront = new ModelRenderer(this, 0, 6);
      	legLFront.addBox(0F, 0F, -1F, 1, 3, 1);
      	legLFront.setRotationPoint(-1.5F, 21F, 2F);
      	legLFront.setTextureSize(64, 32);
      	setRotation(legLFront, 0.852925F, 0F, 0F);
      	eyeR = new ModelRenderer(this, 0, 18);
      	eyeR.addBox(0F, 0F, 0F, 0, 1, 1);
      	eyeR.setRotationPoint(1F, 18F, -2F);
      	eyeR.setTextureSize(64, 32);
      	setRotation(eyeR, 0F, 0F, 0F);
      	eyeL = new ModelRenderer(this, 0, 20);
      	eyeL.addBox(0F, 0F, 0F, 0, 1, 1);
      	eyeL.setRotationPoint(1F, 18F, 1F);
      	eyeL.setTextureSize(64, 32);
      	setRotation(eyeL, 0F, 0F, 0F);
    }
  
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    	super.render(entity, f, f1, f2, f3, f4, f5);
    	this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    	mainBody.render(f5);
    	topBody.render(f5);
    	armR.render(f5);
    	armL.render(f5);
    	handR.render(f5);
    	handL.render(f5);
    	legRBack.render(f5);
    	legRFront.render(f5);
    	leglBack.render(f5);
    	legLFront.render(f5);
	    eyeR.render(f5);
	    eyeL.render(f5);
    }
  
    private void setRotation(ModelRenderer model, float x, float y, float z) {
    	model.rotateAngleX = x;
    	model.rotateAngleY = y;
    	model.rotateAngleZ = z;
    }
  
  	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
  		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  		EntityCrab crab = (EntityCrab)entity;
  		
  		float open = MathHelper.cos(f * 0.3662F) * f1;
		if(open < 0.0F) {open = 0.0F;}
		this.handR.rotateAngleX = -open;
		this.handL.rotateAngleX = open;
  	}

}
