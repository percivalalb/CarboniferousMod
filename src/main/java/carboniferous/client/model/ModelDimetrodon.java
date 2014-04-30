package carboniferous.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

/**
 * @author ProPercivalalb
 */
public class ModelDimetrodon extends ModelBase {
	
    ModelRenderer spine1;
    ModelRenderer spine2;
    ModelRenderer spine3;
    ModelRenderer spine4;
    ModelRenderer spine5;
    ModelRenderer spine6;
    ModelRenderer spine7;
    ModelRenderer spine8;
    ModelRenderer torsofront;
    ModelRenderer torsoBack;
    ModelRenderer tail;
    ModelRenderer legRBack;
    ModelRenderer legLBack;
    ModelRenderer legRFront;
    ModelRenderer legLFront;
    ModelRenderer mouthLower;
    ModelRenderer mouthUpper;
  
    public ModelDimetrodon() {
    	textureWidth = 64;
    	textureHeight = 32;
    
    	spine1 = new ModelRenderer(this, 28, 25);
        spine1.addBox(0F, 0F, 0F, 2, 4, 2);
        spine1.setRotationPoint(-1F, 15F, -7F);
        spine1.setTextureSize(64, 32);
        setRotation(spine1, 0F, 0F, 0F);
        spine2 = new ModelRenderer(this, 37, 23);
        spine2.addBox(0F, 0F, 0F, 2, 6, 2);
        spine2.setRotationPoint(-1F, 13F, -5F);
        spine2.setTextureSize(64, 32);
        setRotation(spine2, 0F, 0F, 0F);
        spine3 = new ModelRenderer(this, 46, 21);
        spine3.addBox(0F, 0F, 0F, 2, 8, 2);
        spine3.setRotationPoint(-1F, 11F, -3F);
        spine3.setTextureSize(64, 32);
        setRotation(spine3, 0F, 0F, 0F);
        spine4 = new ModelRenderer(this, 55, 19);
        spine4.addBox(0F, 0F, 0F, 2, 10, 2);
        spine4.setRotationPoint(-1F, 9F, -1F);
        spine4.setTextureSize(64, 32);
        setRotation(spine4, 0F, 0F, 0F);
        spine5 = new ModelRenderer(this, 55, 19);
        spine5.addBox(0F, 0F, 0F, 2, 10, 2);
        spine5.setRotationPoint(-1F, 9F, 1F);
        spine5.setTextureSize(64, 32);
        setRotation(spine5, 0F, 0F, 0F);
        spine6 = new ModelRenderer(this, 46, 21);
        spine6.addBox(-2F, 0F, 0F, 2, 8, 2);
        spine6.setRotationPoint(1F, 11F, 2F);
        spine6.setTextureSize(64, 32);
        setRotation(spine6, 0F, 0F, 0F);
        spine7 = new ModelRenderer(this, 37, 23);
        spine7.addBox(0F, 0F, 0F, 2, 6, 2);
        spine7.setRotationPoint(-1F, 13F, 4F);
        spine7.setTextureSize(64, 32);
        setRotation(spine7, 0F, 0F, 0F);
        spine8 = new ModelRenderer(this, 28, 25);
        spine8.addBox(0F, 0F, 0F, 2, 4, 2);
        spine8.setRotationPoint(-1F, 15F, 6F);
        spine8.setTextureSize(64, 32);
        setRotation(spine8, 0F, 0F, 0F);
        torsofront = new ModelRenderer(this, 17, 0);
        torsofront.addBox(-4F, -3F, -3F, 6, 6, 4);
        torsofront.setRotationPoint(1F, 20F, -4F);
        torsofront.setTextureSize(64, 32);
        setRotation(torsofront, 1.570796F, 0F, 0F);
        torsoBack = new ModelRenderer(this, 38, 0);
        torsoBack.addBox(-4F, -2F, -3F, 6, 9, 4);
        torsoBack.setRotationPoint(1F, 20F, 1F);
        torsoBack.setTextureSize(64, 32);
        setRotation(torsoBack, 1.570796F, 0F, 0F);
        tail = new ModelRenderer(this, 0, 22);
        tail.addBox(-1F, 0F, -1F, 3, 6, 3);
        tail.setRotationPoint(-0.5F, 20F, 6F);
        tail.setTextureSize(64, 32);
        setRotation(tail, 1.533618F, 0F, 0F);
        legRBack = new ModelRenderer(this, 0, 15);
        legRBack.addBox(-1F, 0F, -1F, 2, 3, 2);
        legRBack.setRotationPoint(-3.5F, 21F, 6F);
        legRBack.setTextureSize(64, 32);
        setRotation(legRBack, 0F, 0F, 0F);
        legLBack = new ModelRenderer(this, 0, 15);
        legLBack.addBox(-1F, 0F, -1F, 2, 3, 2);
        legLBack.setRotationPoint(3.5F, 21F, 6F);
        legLBack.setTextureSize(64, 32);
        setRotation(legLBack, 0F, 0F, 0F);
        legRFront = new ModelRenderer(this, 0, 15);
        legRFront.addBox(-1F, 0F, -1F, 2, 4, 2);
        legRFront.setRotationPoint(-3.5F, 20F, -5F);
        legRFront.setTextureSize(64, 32);
        setRotation(legRFront, 0F, 0F, 0F);
        legLFront = new ModelRenderer(this, 0, 15);
        legLFront.addBox(-1F, 0F, -1F, 2, 4, 2);
        legLFront.setRotationPoint(3.5F, 20F, -5F);
        legLFront.setTextureSize(64, 32);
        setRotation(legLFront, 0F, 0F, 0F);
        mouthLower = new ModelRenderer(this, 0, 8);
        mouthLower.addBox(-2F, 0F, -4F, 4, 2, 4);
        mouthLower.setRotationPoint(0F, 20F, -7F);
        mouthLower.setTextureSize(64, 32);
        setRotation(mouthLower, 0.129678F, 0F, 0F);
        mouthUpper = new ModelRenderer(this, 0, 0);
        mouthUpper.addBox(-2F, -3F, -4.1F, 4, 3, 4);
        mouthUpper.setRotationPoint(0F, 20F, -7F);
        mouthUpper.setTextureSize(64, 32);
        setRotation(mouthUpper, 0F, 0F, 0F);
    }  
    
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    	super.render(entity, f, f1, f2, f3, f4, f5);
    	this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    	spine1.render(f5);
    	spine2.render(f5);
    	spine3.render(f5);
    	spine4.render(f5);
    	spine5.render(f5);
    	spine6.render(f5);
    	spine7.render(f5);
    	spine8.render(f5);
    	torsofront.render(f5);
    	torsoBack.render(f5);
    	tail.render(f5);
    	legRBack.render(f5);
    	legLBack.render(f5);
    	legRFront.render(f5);
    	legLFront.render(f5);
    	mouthLower.render(f5);
    	mouthUpper.render(f5);
    }
  
    private void setRotation(ModelRenderer model, float x, float y, float z) {
    	model.rotateAngleX = x;
    	model.rotateAngleY = y;
    	model.rotateAngleZ = z;
  	}
  
    public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
    	super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
        this.mouthLower.rotateAngleX = par5 / (180F / (float)Math.PI);
        this.mouthLower.rotateAngleY = par4 / (180F / (float)Math.PI);
        this.mouthUpper.rotateAngleX = par5 / (180F / (float)Math.PI) - 0.099678F;
        this.mouthUpper.rotateAngleY = par4 / (180F / (float)Math.PI);
    	
        this.legRBack.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
        this.legRFront.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
        this.legLFront.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
        this.legLBack.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
        
        this.tail.rotateAngleY = (MathHelper.cos(par1 * 0.3662F) * par2) * 0.4F;
    }
}
