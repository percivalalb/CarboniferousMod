package carboniferous.client.model;

import carboniferous.entity.EntityBrachiopod;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBrachiopod extends ModelBase {
	
    ModelRenderer backBottom;
    ModelRenderer frontBottom;
    ModelRenderer shellBottom;
    ModelRenderer rightBottom;
    ModelRenderer leftBottom;
    ModelRenderer leftTop;
    ModelRenderer shellTop;
    ModelRenderer frontTop;
    ModelRenderer pearl;
    ModelRenderer backTop;
    ModelRenderer rightTop;
  
    public ModelBrachiopod() {
	  textureWidth = 64;
	  textureHeight = 32;
    
      backBottom = new ModelRenderer(this, 0, 27);
      backBottom.addBox(0F, 0F, 0F, 14, 4, 1);
      backBottom.setRotationPoint(-7F, 20F, 6F);
      backBottom.setTextureSize(64, 32);
      backBottom.mirror = true;
      setRotation(backBottom, 0F, 0F, 0F);
      frontBottom = new ModelRenderer(this, 0, 26);
      frontBottom.addBox(0F, 0F, 0F, 14, 5, 1);
      frontBottom.setRotationPoint(-7F, 19F, -7F);
      frontBottom.setTextureSize(64, 32);
      frontBottom.mirror = true;
      setRotation(frontBottom, 0F, 0F, 0F);
      shellBottom = new ModelRenderer(this, 0, 0);
      shellBottom.addBox(-7F, 23F, -7F, 14, 1, 14);
      shellBottom.setRotationPoint(0F, 0F, 0F);
      shellBottom.setTextureSize(64, 32);
      shellBottom.mirror = true;
      setRotation(shellBottom, 0F, 0F, 0F);
      rightBottom = new ModelRenderer(this, 32, 10);
      rightBottom.addBox(0F, 0F, 0F, 1, 4, 14);
      rightBottom.setRotationPoint(-7F, 20F, -7F);
      rightBottom.setTextureSize(64, 32);
      rightBottom.mirror = true;
      setRotation(rightBottom, 0F, 0F, 0F);
      leftBottom = new ModelRenderer(this, 32, 10);
      leftBottom.addBox(0F, 0F, 0F, 1, 4, 14);
      leftBottom.setRotationPoint(6F, 20F, -7F);
      leftBottom.setTextureSize(64, 32);
      leftBottom.mirror = true;
      setRotation(leftBottom, 0F, 0F, 0F);
      leftTop = new ModelRenderer(this, 32, 10);
      leftTop.addBox(5F, -4F, -14F, 1, 4, 14);
      leftTop.setRotationPoint(1F, 20F, 7F);
      leftTop.setTextureSize(64, 32);
      leftTop.mirror = true;
      setRotation(leftTop, 0F, 0F, 0F);
      shellTop = new ModelRenderer(this, 0, 0);
      shellTop.addBox(-8F, -4F, -14F, 14, 1, 14);
      shellTop.setRotationPoint(1F, 20F, 7F);
      shellTop.setTextureSize(64, 32);
      shellTop.mirror = true;
      setRotation(shellTop, 0F, 0F, 0F);
      frontTop = new ModelRenderer(this, 0, 26);
      frontTop.addBox(-8F, -4F, -14F, 14, 5, 1);
      frontTop.setRotationPoint(1F, 20F, 7F);
      frontTop.setTextureSize(64, 32);
      frontTop.mirror = true;
      setRotation(frontTop, 0F, 0F, 0F);
      pearl = new ModelRenderer(this, 0, 17);
      pearl.addBox(0F, 0F, -0.1F, 6, 2, 6);
      pearl.setRotationPoint(-3F, 21F, 1F);
      pearl.setTextureSize(64, 32);
      pearl.mirror = true;
      setRotation(pearl, 0F, 0F, 0F);
      backTop = new ModelRenderer(this, 0, 26);
      backTop.addBox(-8F, -4F, -1F, 14, 5, 1);
      backTop.setRotationPoint(1F, 20F, 7F);
      backTop.setTextureSize(64, 32);
      backTop.mirror = true;
      setRotation(backTop, 0F, 0F, 0F);
      rightTop = new ModelRenderer(this, 32, 10);
      rightTop.addBox(-8F, -4F, -14F, 1, 4, 14);
      rightTop.setRotationPoint(1F, 20F, 7F);
      rightTop.setTextureSize(64, 32);
      rightTop.mirror = true;
      setRotation(rightTop, 0F, 0F, 0F);
  	}
  
  	@Override
  	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
  		super.render(entity, f, f1, f2, f3, f4, f5);
    	setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    	backBottom.render(f5);
    	frontBottom.render(f5);
    	shellBottom.render(f5);
    	rightBottom.render(f5);
    	leftBottom.render(f5);
    	leftTop.render(f5);
    	shellTop.render(f5);
    	frontTop.render(f5);
    	EntityBrachiopod brachipod = (EntityBrachiopod)entity;
    	if(brachipod.hasPearl()) {
    		pearl.render(f5);
    	}
    	backTop.render(f5);
    	rightTop.render(f5);
  	}
  
  	private void setRotation(ModelRenderer model, float x, float y, float z) {
  		model.rotateAngleX = x;
  		model.rotateAngleY = y;
  		model.rotateAngleZ = z;
  	}
  
  	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
  		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  		EntityBrachiopod brachipod = (EntityBrachiopod)entity;
  		shellTop.rotateAngleX = brachipod.getOpenMouth(100F);
	    frontTop.rotateAngleX = brachipod.getOpenMouth(100F);
	    backTop.rotateAngleX = brachipod.getOpenMouth(100F);
	    rightTop.rotateAngleX = brachipod.getOpenMouth(100F);
	    leftTop.rotateAngleX = brachipod.getOpenMouth(100F);
  	}

}
