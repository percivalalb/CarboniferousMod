package carboniferous.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelGrinder extends ModelBase
{
  //fields
    ModelRenderer base;
    ModelRenderer top;
    ModelRenderer leg1;
    ModelRenderer leg2;
    ModelRenderer leg3;
    ModelRenderer leg4;
    ModelRenderer centreCog;
    ModelRenderer centreStick;
    ModelRenderer cog1;
    ModelRenderer cog2;
    ModelRenderer cog3;
    ModelRenderer cog4;
    ModelRenderer cog5;
  
    public ModelGrinder() {
    	textureWidth = 128;
    	textureHeight = 64;
    
    	base = new ModelRenderer(this, 0, 0);
    	base.addBox(0F, 0F, 0F, 14, 4, 14);
    	base.setRotationPoint(-7F, 20F, -7F);
    	base.setTextureSize(128, 64);
    	base.mirror = true;
    	setRotation(base, 0F, 0F, 0F);
      top = new ModelRenderer(this, 57, 0);
      top.addBox(0F, -5F, 0F, 14, 4, 14);
      top.setRotationPoint(-7F, 13F, -7F);
      top.setTextureSize(128, 64);
      top.mirror = true;
      setRotation(top, 0F, 0F, 0F);
      leg1 = new ModelRenderer(this, 13, 21);
      leg1.addBox(0F, 0F, 0F, 3, 8, 3);
      leg1.setRotationPoint(-7F, 12F, 4F);
      leg1.setTextureSize(128, 64);
      leg1.mirror = true;
      setRotation(leg1, 0F, 0F, 0F);
      leg2 = new ModelRenderer(this, 26, 21);
      leg2.addBox(0F, 0F, 0F, 3, 8, 3);
      leg2.setRotationPoint(4F, 12F, -7F);
      leg2.setTextureSize(128, 64);
      leg2.mirror = true;
      setRotation(leg2, 0F, 0F, 0F);
      leg3 = new ModelRenderer(this, 39, 21);
      leg3.addBox(0F, 0F, 0F, 3, 8, 3);
      leg3.setRotationPoint(-7F, 12F, -7F);
      leg3.setTextureSize(128, 64);
      leg3.mirror = true;
      setRotation(leg3, 0F, 0F, 0F);
      leg4 = new ModelRenderer(this, 0, 21);
      leg4.addBox(0F, 0F, 0F, 3, 8, 3);
      leg4.setRotationPoint(4F, 12F, 4F);
      leg4.setTextureSize(128, 64);
      leg4.mirror = true;
      setRotation(leg4, 0F, 0F, 0F);
      centreCog = new ModelRenderer(this, 6, 46);
      centreCog.addBox(-1.5F, -1F, -1.5F, 3, 2, 3);
      centreCog.setRotationPoint(0F, 17F, 0F);
      centreCog.setTextureSize(128, 64);
      centreCog.mirror = true;
      setRotation(centreCog, 0F, 0F, 0F);
      centreStick = new ModelRenderer(this, 0, 46);
      centreStick.addBox(-0.5F, 0F, -0.5F, 1, 9, 1);
      centreStick.setRotationPoint(0F, 12F, 0F);
      centreStick.setTextureSize(128, 64);
      centreStick.mirror = true;
      setRotation(centreStick, 0F, 0F, 0F);
      cog1 = new ModelRenderer(this, 51, 35);
      cog1.addBox(-1.5F, -1.5F, 1F, 3, 3, 5);
      cog1.setRotationPoint(0F, 17F, 0F);
      cog1.setTextureSize(128, 64);
      cog1.mirror = true;
      setRotation(cog1, 0F, 1.256637F, 0F);
      cog2 = new ModelRenderer(this, 17, 35);
      cog2.addBox(-1.5F, -1.5F, 1F, 3, 3, 5);
      cog2.setRotationPoint(0F, 17F, 0F);
      cog2.setTextureSize(128, 64);
      cog2.mirror = true;
      setRotation(cog2, 0F, -2.513274F, 0F);
      cog3 = new ModelRenderer(this, 0, 35);
      cog3.addBox(-1.5F, -1.5F, 1F, 3, 3, 5);
      cog3.setRotationPoint(0F, 17F, 0F);
      cog3.setTextureSize(128, 64);
      cog3.mirror = true;
      setRotation(cog3, 0F, -1.256637F, 0F);
      cog4 = new ModelRenderer(this, 34, 35);
      cog4.addBox(-1.5F, -1.5F, 1F, 3, 3, 5);
      cog4.setRotationPoint(0F, 16.86667F, 0F);
      cog4.setTextureSize(128, 64);
      cog4.mirror = true;
      	setRotation(cog4, 0F, 2.513274F, 0F);
      	cog5 = new ModelRenderer(this, 68, 35);
      	cog5.addBox(-1.5F, -1.5F, 1F, 3, 3, 5);
      	cog5.setRotationPoint(0F, 17F, 0F);
      	cog5.setTextureSize(128, 64);
      	cog5.mirror = true;
      	setRotation(cog5, 0F, 0F, 0F);
    }
  
    public void render() {
    	base.render(0.0625F);
    	top.render(0.0625F);
    	leg1.render(0.0625F);
    	leg2.render(0.0625F);
    	leg3.render(0.0625F);
    	leg4.render(0.0625F);
    	centreCog.render(0.0625F);
    	centreStick.render(0.0625F);
    	cog1.render(0.0625F);
    	cog2.render(0.0625F);
    	cog3.render(0.0625F);
    	cog4.render(0.0625F);
    	cog5.render(0.0625F);
    }
    
    public void rotateCog(float plus) {
    	centreCog.rotateAngleY += plus;
    	centreStick.rotateAngleY += plus;
    	cog1.rotateAngleY += plus;
    	cog2.rotateAngleY += plus;
    	cog3.rotateAngleY += plus;
    	cog4.rotateAngleY += plus;
    	cog5.rotateAngleY += plus;
    }
  
    private void setRotation(ModelRenderer model, float x, float y, float z) {
    	model.rotateAngleX = x;
    	model.rotateAngleY = y;
    	model.rotateAngleZ = z;
    }
}
