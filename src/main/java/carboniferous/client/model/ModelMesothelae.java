package carboniferous.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

/**
 * @author ProPercivalalb
 */
public class ModelMesothelae extends ModelBase {
   
	ModelRenderer head;
    ModelRenderer body;
    ModelRenderer rearEnd;
    ModelRenderer leg8;
    ModelRenderer leg6;
    ModelRenderer leg4;
    ModelRenderer leg2;
    ModelRenderer leg7;
    ModelRenderer leg5;
    ModelRenderer leg3;
    ModelRenderer leg1;

    public ModelMesothelae() {
    	textureWidth = 64;
    	textureHeight = 32;
    	    
    	head = new ModelRenderer(this, 0, 0);
    	head.addBox(-2.5F, -2F, -4F, 5, 4, 4);
    	head.setRotationPoint(0F, 19F, -3F);
    	head.setTextureSize(64, 32);
    	setRotation(head, 0F, 0F, 0F);
    	body = new ModelRenderer(this, 0, 21);
    	body.addBox(-3F, -3F, -3F, 4, 2, 5);
    	body.setRotationPoint(1F, 21F, 0F);
    	body.setTextureSize(64, 32);
    	setRotation(body, 0F, 0F, 0F);
    	rearEnd = new ModelRenderer(this, 0, 9);
    	rearEnd.addBox(-5F, -4F, -6F, 5, 4, 7);
    	rearEnd.setRotationPoint(2.5F, 21F, 8F);
    	rearEnd.setTextureSize(64, 32);
    	setRotation(rearEnd, 0F, 0F, 0F);
    	leg8 = new ModelRenderer(this, 19, 0);
    	leg8.addBox(-1F, -1F, -1F, 7, 2, 2);
    	leg8.setRotationPoint(2.5F, 21F, -2F);
    	leg8.setTextureSize(64, 32);
    	setRotation(leg8, 0F, 0F, 0F);
    	leg6 = new ModelRenderer(this, 19, 0);
    	leg6.addBox(-1F, -1F, -1F, 7, 2, 2);
    	leg6.setRotationPoint(2.5F, 21F, -1F);
    	leg6.setTextureSize(64, 32);
    	setRotation(leg6, 0F, 0F, 0F);
    	leg4 = new ModelRenderer(this, 19, 0);
    	leg4.addBox(-1F, -1F, -1F, 7, 2, 2);
    	leg4.setRotationPoint(2.5F, 21F, 0F);
    	leg4.setTextureSize(64, 32);
    	setRotation(leg4, 0F, 0F, 0F);
    	leg2 = new ModelRenderer(this, 19, 0);
    	leg2.addBox(-1F, -1F, -1F, 7, 2, 2);
    	leg2.setRotationPoint(2.5F, 21F, 1F);
    	leg2.setTextureSize(64, 32);
    	setRotation(leg2, 0F, 0F, 0F);
    	leg7 = new ModelRenderer(this, 19, 0);
    	leg7.addBox(-6F, -1F, -1F, 7, 2, 2);
    	leg7.setRotationPoint(-2.5F, 21F, -2F);
    	leg7.setTextureSize(64, 32);
    	setRotation(leg7, 0F, 0F, 0F);
    	leg5 = new ModelRenderer(this, 19, 0);
    	leg5.addBox(-6F, -1F, -1F, 7, 2, 2);
    	leg5.setRotationPoint(-2.5F, 21F, -1F);
    	leg5.setTextureSize(64, 32);
    	setRotation(leg5, 0F, 0F, 0F);
    	leg3 = new ModelRenderer(this, 19, 0);
    	leg3.addBox(-6F, -1F, -1F, 7, 2, 2);
    	leg3.setRotationPoint(-2.5F, 21F, 0F);
    	leg3.setTextureSize(64, 32);
    	setRotation(leg3, 0F, 0F, 0F);
    	leg1 = new ModelRenderer(this, 19, 0);
    	leg1.addBox(-6F, -1F, -1F, 7, 2, 2);
    	leg1.setRotationPoint(-2.5F, 21F, 1F);
    	leg1.setTextureSize(64, 32);
    	setRotation(leg1, 0F, 0F, 0F);
    }

	private void setRotation(ModelRenderer model, float x, float y, float z) {
  		model.rotateAngleX = x;
  		model.rotateAngleY = y;
  		model.rotateAngleZ = z;
  	}
    
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        head.render(f5);
        body.render(f5);
        rearEnd.render(f5);
        leg8.render(f5);
        leg6.render(f5);
        leg4.render(f5);
        leg2.render(f5);
        leg7.render(f5);
        leg5.render(f5);
        leg3.render(f5);
        leg1.render(f5);
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        head.rotateAngleY = f3 / 57.29578F;
        head.rotateAngleX = f4 / 57.29578F;
        float f6 = 0.7853982F;
        leg1.rotateAngleZ = -f6;
        leg2.rotateAngleZ = f6;
        leg3.rotateAngleZ = -f6 * 0.74F;
        leg4.rotateAngleZ = f6 * 0.74F;
        leg5.rotateAngleZ = -f6 * 0.74F;
        leg6.rotateAngleZ = f6 * 0.74F;
        leg7.rotateAngleZ = -f6;
        leg8.rotateAngleZ = f6;
        float f7 = -0F;
        float f8 = 0.3926991F;
        leg1.rotateAngleY = f8 * 2.0F + f7;
        leg2.rotateAngleY = -f8 * 2.0F - f7;
        leg3.rotateAngleY = f8 * 1.0F + f7;
        leg4.rotateAngleY = -f8 * 1.0F - f7;
        leg5.rotateAngleY = -f8 * 1.0F + f7;
        leg6.rotateAngleY = f8 * 1.0F - f7;
        leg7.rotateAngleY = -f8 * 2.0F + f7;
        leg8.rotateAngleY = f8 * 2.0F - f7;
        float f9 = -(MathHelper.cos(f * 0.6662F * 2.0F + 0.0F) * 0.4F) * f1;
        float f10 = -(MathHelper.cos(f * 0.6662F * 2.0F + 3.141593F) * 0.4F) * f1;
        float f11 = -(MathHelper.cos(f * 0.6662F * 2.0F + 1.570796F) * 0.4F) * f1;
        float f12 = -(MathHelper.cos(f * 0.6662F * 2.0F + 4.712389F) * 0.4F) * f1;
        float f13 = Math.abs(MathHelper.sin(f * 0.6662F + 0.0F) * 0.4F) * f1;
        float f14 = Math.abs(MathHelper.sin(f * 0.6662F + 3.141593F) * 0.4F) * f1;
        float f15 = Math.abs(MathHelper.sin(f * 0.6662F + 1.570796F) * 0.4F) * f1;
        float f16 = Math.abs(MathHelper.sin(f * 0.6662F + 4.712389F) * 0.4F) * f1;
        leg1.rotateAngleY += f9;
        leg2.rotateAngleY += -f9;
        leg3.rotateAngleY += f10;
        leg4.rotateAngleY += -f10;
        leg5.rotateAngleY += f11;
        leg6.rotateAngleY += -f11;
        leg7.rotateAngleY += f12;
        leg8.rotateAngleY += -f12;
        leg1.rotateAngleZ += f13;
        leg2.rotateAngleZ += -f13;
        leg3.rotateAngleZ += f14;
        leg4.rotateAngleZ += -f14;
        leg5.rotateAngleZ += f15;
        leg6.rotateAngleZ += -f15;
        leg7.rotateAngleZ += f16;
        leg8.rotateAngleZ += -f16;
    }
}
