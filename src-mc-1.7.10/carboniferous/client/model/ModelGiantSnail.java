package carboniferous.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelGiantSnail extends ModelBase {
	
    public ModelRenderer body;
    public ModelRenderer mainShell;
    public ModelRenderer leftShell;
    public ModelRenderer rightShell;
    public ModelRenderer rightEye;
    public ModelRenderer leftEye;
    public ModelRenderer tail;
  
    public ModelGiantSnail() {
    	textureWidth = 128;
    	textureHeight = 32;
    
      body = new ModelRenderer(this, 0, 0);
      body.addBox(-2F, 0F, 0F, 5, 3, 17);
      body.setRotationPoint(-0.5F, 21F, -9F);
      body.setTextureSize(128, 32);
      body.mirror = true;
      setRotation(body, 0F, 0F, 0F);
      mainShell = new ModelRenderer(this, 45, 0);
      mainShell.addBox(0F, 0F, 0F, 4, 10, 10);
      mainShell.setRotationPoint(-2F, 11F, -4F);
      mainShell.setTextureSize(128, 32);
      mainShell.mirror = true;
      setRotation(mainShell, 0F, 0F, 0F);
      leftShell = new ModelRenderer(this, 74, 0);
      leftShell.addBox(0F, 0F, 0F, 1, 6, 6);
      leftShell.setRotationPoint(2F, 13F, -2F);
      leftShell.setTextureSize(128, 32);
      leftShell.mirror = true;
      setRotation(leftShell, 0F, 0F, 0F);
      rightShell = new ModelRenderer(this, 89, 0);
      rightShell.addBox(0F, 0F, 0F, 1, 6, 6);
      rightShell.setRotationPoint(-3F, 13F, -2F);
      rightShell.setTextureSize(128, 32);
      rightShell.mirror = true;
      setRotation(rightShell, 0F, 0F, 0F);
      rightEye = new ModelRenderer(this, 0, 21);
      rightEye.addBox(0F, 0F, 0F, 1, 3, 1);
      rightEye.setRotationPoint(-1.5F, 18F, -8.5F);
      rightEye.setTextureSize(128, 32);
      rightEye.mirror = true;
      setRotation(rightEye, 0F, 0F, 0F);
      leftEye = new ModelRenderer(this, 5, 21);
      leftEye.addBox(0F, 0F, 0F, 1, 3, 1);
      leftEye.setRotationPoint(0.5F, 18F, -8.5F);
      leftEye.setTextureSize(128, 32);
      leftEye.mirror = true;
      setRotation(leftEye, 0F, 0F, 0.0174533F);
      tail = new ModelRenderer(this, 10, 21);
      tail.addBox(0F, 0F, 0F, 4, 2, 2);
      tail.setRotationPoint(-2F, 22F, 8F);
      tail.setTextureSize(128, 32);
      tail.mirror = true;
      setRotation(tail, 0F, 0F, 0F);
    }
  	
  	@Override
  	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
	    super.render(entity, f, f1, f2, f3, f4, f5);
	    this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	    body.render(f5);
	    mainShell.render(f5);
	    leftShell.render(f5);
	    rightShell.render(f5);
	    rightEye.render(f5);
	    leftEye.render(f5);
	    tail.render(f5);
  	}
  
  	private void setRotation(ModelRenderer model, float x, float y, float z) {
	    model.rotateAngleX = x;
	    model.rotateAngleY = y;
	    model.rotateAngleZ = z;
  	}
  
  	@Override
  	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
  		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  	}

}
