package carboniferous.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelAmmonite extends ModelBase {
	
    ModelRenderer Shellbase;
    ModelRenderer Shellside1;
    ModelRenderer Shellside2;
    ModelRenderer Headpiece;
    ModelRenderer Tentacle1;
    ModelRenderer Tentacle2;
    ModelRenderer Tentacle3;
    ModelRenderer Tentacle4;
  
    public ModelAmmonite() {
    	textureWidth = 64;
    	textureHeight = 32;
    
    	Shellbase = new ModelRenderer(this, 0, 4);
    	Shellbase.addBox(0F, 0F, 0F, 3, 5, 5);
    	Shellbase.setRotationPoint(-1.5F, 18F, -2F);
    	Shellbase.setTextureSize(64, 32);
    	Shellbase.mirror = true;
    	setRotation(Shellbase, 0F, 0F, 0F);
    	Shellside1 = new ModelRenderer(this, 25, 0);
    	Shellside1.addBox(0F, 0F, 0F, 1, 3, 3);
    	Shellside1.setRotationPoint(-2F, 19F, -1F);
    	Shellside1.setTextureSize(64, 32);
    	Shellside1.mirror = true;
    	setRotation(Shellside1, 0F, 0F, 0F);
    	Shellside2 = new ModelRenderer(this, 25, 0);
    	Shellside2.addBox(0F, 0F, 0F, 1, 3, 3);
    	Shellside2.setRotationPoint(1F, 19F, -1F);
    	Shellside2.setTextureSize(64, 32);
    	Shellside2.mirror = true;
    	setRotation(Shellside2, 0F, 0F, 0F);
    	Headpiece = new ModelRenderer(this, 9, 0);
    	Headpiece.addBox(0F, 0F, 0F, 2, 2, 1);
    	Headpiece.setRotationPoint(-1F, 20.5F, -2.5F);
    	Headpiece.setTextureSize(64, 32);
    	Headpiece.mirror = true;
    	setRotation(Headpiece, 0F, 0F, 0F);
    	Tentacle1 = new ModelRenderer(this, 0, 0);
    	Tentacle1.addBox(0F, 0F, 0F, 1, 1, 2);
    	Tentacle1.setRotationPoint(0F, 20.5F, -4F);
    	Tentacle1.setTextureSize(64, 32);
    	Tentacle1.mirror = true;
    	setRotation(Tentacle1, 0F, 0F, 0F);
    	Tentacle2 = new ModelRenderer(this, 0, 0);
    	Tentacle2.addBox(0F, 0F, 0F, 1, 1, 2);
    	Tentacle2.setRotationPoint(0F, 21.5F, -4F);
    	Tentacle2.setTextureSize(64, 32);
    	Tentacle2.mirror = true;
    	setRotation(Tentacle2, 0F, 0F, 0F);
    	Tentacle3 = new ModelRenderer(this, 0, 0);
    	Tentacle3.addBox(0F, 0F, 0F, 1, 1, 2);
    	Tentacle3.setRotationPoint(-1F, 21.5F, -4F);
    	Tentacle3.setTextureSize(64, 32);
    	Tentacle3.mirror = true;
      	setRotation(Tentacle3, 0F, 0F, 0F);
      	Tentacle4 = new ModelRenderer(this, 0, 0);
      	Tentacle4.addBox(0F, 0F, 0F, 1, 1, 2);
      	Tentacle4.setRotationPoint(-1F, 20.5F, -4F);
      	Tentacle4.setTextureSize(64, 32);
      	Tentacle4.mirror = true;
      	setRotation(Tentacle4, 0F, 0F, 0F);
    }
  
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    	super.render(entity, f, f1, f2, f3, f4, f5);
    	this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    	Shellbase.render(f5);
    	Shellside1.render(f5);
    	Shellside2.render(f5);
    	Headpiece.render(f5);
    	Tentacle1.render(f5);
    	Tentacle2.render(f5);
    	Tentacle3.render(f5);
    	Tentacle4.render(f5);
    }
  
    private void setRotation(ModelRenderer model, float x, float y, float z) {
    	model.rotateAngleX = x;
    	model.rotateAngleY = y;
    	model.rotateAngleZ = z;
    }
  
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
    	super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }
}