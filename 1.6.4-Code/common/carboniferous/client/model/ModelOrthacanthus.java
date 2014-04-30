package carboniferous.client.model;

import carboniferous.entity.EntityOrthacanthus;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;

/**
 * @author ProPercivalalb
 */
public class ModelOrthacanthus extends ModelBase {
	
    ModelRenderer BodyBase;
    ModelRenderer TailPiece1;
    ModelRenderer TailPiece2;
    ModelRenderer TailPiece3;
    ModelRenderer TailPiece4;
    ModelRenderer HeadTop;
    ModelRenderer HeadBottom;
    ModelRenderer FinPin;
    ModelRenderer SailBase;
    ModelRenderer Sail2;
    ModelRenderer TailSail;
    ModelRenderer ChestFinR;
    ModelRenderer ChestFinL;
    ModelRenderer Sail3;
    ModelRenderer Sail4;
    ModelRenderer Tailfin2;
    ModelRenderer EyeL;
    ModelRenderer HeadJaw;
    ModelRenderer EyeR;
    ModelRenderer Finpiece1;
    ModelRenderer Finpiece2;
  
    public ModelOrthacanthus() {
    	textureWidth = 128;
    	textureHeight = 64;
    
    	BodyBase = new ModelRenderer(this, 0, 0);
    	BodyBase.addBox(0F, 0F, 0F, 5, 8, 8);
    	BodyBase.setRotationPoint(-3F, 16F, -8F);
    	BodyBase.setTextureSize(128, 64);
    	setRotation(BodyBase, 0F, 0F, 0F);
    	TailPiece1 = new ModelRenderer(this, 0, 17);
    	TailPiece1.addBox(0F, 0F, 0F, 4, 7, 8);
    	TailPiece1.setRotationPoint(-2.5F, 16.5F, -2F);
    	TailPiece1.setTextureSize(128, 64);
    	setRotation(TailPiece1, 0F, 0F, 0F);
    	TailPiece2 = new ModelRenderer(this, 26, 0);
    	TailPiece2.addBox(0F, 0F, 0F, 3, 6, 8);
    	TailPiece2.setRotationPoint(-2F, 17F, 4F);
    	TailPiece2.setTextureSize(128, 64);
    	setRotation(TailPiece2, 0F, 0F, 0F);
    	TailPiece3 = new ModelRenderer(this, 24, 19);
    	TailPiece3.addBox(0F, 0F, 0F, 2, 5, 8);
    	TailPiece3.setRotationPoint(-1.5F, 17.5F, 10F);
      	TailPiece3.setTextureSize(128, 64);
      	setRotation(TailPiece3, 0F, 0F, 0F);
      	TailPiece4 = new ModelRenderer(this, 44, 23);
      	TailPiece4.addBox(0F, 0F, 0F, 1, 4, 5);
      	TailPiece4.setRotationPoint(-1F, 18F, 16F);
      	TailPiece4.setTextureSize(128, 64);
      	setRotation(TailPiece4, 0F, 0F, 0F);
      	HeadTop = new ModelRenderer(this, 1, 34);
      	HeadTop.addBox(0F, 0F, 0F, 5, 5, 5);
      	HeadTop.setRotationPoint(-3F, 16.5F, -12F);
      	HeadTop.setTextureSize(128, 64);
      	setRotation(HeadTop, 0F, 0F, 0F);
      	HeadBottom = new ModelRenderer(this, 0, 49);
      	HeadBottom.addBox(0F, 0F, -6F, 5, 2, 6);
      	HeadBottom.setRotationPoint(-3F, 21.5F, -7.5F);
      	HeadBottom.setTextureSize(128, 64);
      	setRotation(HeadBottom, 0F, 0F, 0F);
      	FinPin = new ModelRenderer(this, 58, 26);
      	FinPin.addBox(0F, 0F, 0F, 1, 5, 1);
      	FinPin.setRotationPoint(-1F, 12F, -6F);
      	FinPin.setTextureSize(128, 64);
      	setRotation(FinPin, 0F, 0F, 0F);
      	SailBase = new ModelRenderer(this, 73, 29);
      	SailBase.addBox(0F, 0F, 0F, 0, 4, 4);
      	SailBase.setRotationPoint(-0.5F, 13F, -4F);
      	SailBase.setTextureSize(128, 64);
      	setRotation(SailBase, 0F, 0F, 0F);
      	Sail2 = new ModelRenderer(this, 51, 5);
      	Sail2.addBox(0F, 0F, 0F, 0, 5, 6);
      	Sail2.setRotationPoint(-0.5F, 14F, 0F);
      	Sail2.setTextureSize(128, 64);
      	setRotation(Sail2, 0F, 0F, 0F);
      	TailSail = new ModelRenderer(this, 70, 5);
      	TailSail.addBox(0F, 0F, 0F, 0, 4, 6);
      	TailSail.setRotationPoint(-0.5F, 17F, 19F);
      	TailSail.setTextureSize(128, 64);
      	setRotation(TailSail, 0F, 0F, 0F);
      	ChestFinR = new ModelRenderer(this, 50, 43);
      	ChestFinR.addBox(-4F, 0F, 0F, 4, 1, 4);
      	ChestFinR.setRotationPoint(-2.5F, 23F, -6F);
      	ChestFinR.setTextureSize(128, 64);
      	setRotation(ChestFinR, 0F, 0F, 0F);
      	ChestFinL = new ModelRenderer(this, 50, 49);
      	ChestFinL.addBox(0F, 0F, 0F, 4, 1, 4);
      	ChestFinL.setRotationPoint(1.5F, 23F, -6F);
      	ChestFinL.setTextureSize(128, 64);
      	setRotation(ChestFinL, 0F, 0F, 0F);
      	Sail3 = new ModelRenderer(this, 51, 5);
      	Sail3.addBox(0F, 0F, 0F, 0, 5, 6);
      	Sail3.setRotationPoint(-0.5F, 14.5F, 6F);
      	Sail3.setTextureSize(128, 64);
	    setRotation(Sail3, 0F, 0F, 0F);
      	Sail4 = new ModelRenderer(this, 72, 16);
      	Sail4.addBox(0F, 0F, 0F, 0, 5, 5);
      	Sail4.setRotationPoint(-0.5F, 15F, 12F);
      	Sail4.setTextureSize(128, 64);
      	setRotation(Sail4, 0F, 0F, 0F);
      	Tailfin2 = new ModelRenderer(this, 84, 7);
      	Tailfin2.addBox(0F, 0F, 1F, 0, 2, 4);
      	Tailfin2.setRotationPoint(-0.5F, 20.46667F, 18F);
      	Tailfin2.setTextureSize(128, 64);
      	setRotation(Tailfin2, 0F, 0F, 0F);
      	EyeL = new ModelRenderer(this, 29, 58);
      	EyeL.addBox(0F, 0F, 0F, 1, 1, 1);
      	EyeL.setRotationPoint(1.2F, 18F, -12F);
      	EyeL.setTextureSize(128, 64);
      	setRotation(EyeL, 0F, 0F, 0F);
      	HeadJaw = new ModelRenderer(this, 25, 44);
      	HeadJaw.addBox(0F, 0F, 0F, 5, 4, 7);
      	HeadJaw.setRotationPoint(-3F, 17.5F, -14F);
      	HeadJaw.setTextureSize(128, 64);
      	setRotation(HeadJaw, 0F, 0F, 0F);
      	EyeR = new ModelRenderer(this, 34, 58);
      	EyeR.addBox(0F, 0F, 0F, 1, 1, 1);
      	EyeR.setRotationPoint(-3.2F, 18F, -12F);
      	EyeR.setTextureSize(128, 64);
      	setRotation(EyeR, 0F, 0F, 0F);
      	Finpiece1 = new ModelRenderer(this, 67, 45);
      	Finpiece1.addBox(-0.5F, 0F, 4F, 2, 1, 1);
      	Finpiece1.setRotationPoint(1.5F, 23F, -6F);
      	Finpiece1.setTextureSize(128, 64);
      	setRotation(Finpiece1, 0F, 0F, 0F);
      	Finpiece2 = new ModelRenderer(this, 67, 51);
      	Finpiece2.addBox(-1.5F, 0F, 4F, 2, 1, 1);
      	Finpiece2.setRotationPoint(-2.5F, 23F, -6F);
      	Finpiece2.setTextureSize(128, 64);
      	setRotation(Finpiece2, 0F, 0F, 0F);
  	}
  
  	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
  		super.render(entity, f, f1, f2, f3, f4, f5);
  		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    	BodyBase.render(f5);
    	TailPiece1.render(f5);
    	TailPiece2.render(f5);
    	TailPiece3.render(f5);
    	TailPiece4.render(f5);
    	HeadTop.render(f5);
    	HeadBottom.render(f5);
    	FinPin.render(f5);
    	SailBase.render(f5);
    	Sail2.render(f5);
    	TailSail.render(f5);
    	ChestFinR.render(f5);
    	ChestFinL.render(f5);
    	Sail3.render(f5);
    	Sail4.render(f5);
    	Tailfin2.render(f5);
    	EyeL.render(f5);
    	HeadJaw.render(f5);
    	EyeR.render(f5);
    	Finpiece1.render(f5);
    	Finpiece2.render(f5);
  	}
  
  	private void setRotation(ModelRenderer model, float x, float y, float z) {
  		model.rotateAngleX = x;
    	model.rotateAngleY = y;
    	model.rotateAngleZ = z;
  	}
  
  	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
  		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  		this.TailSail.rotateAngleY = (MathHelper.cos(f * 0.3662F) * f1);
  		this.Tailfin2.rotateAngleY = (MathHelper.cos(f * 0.3662F) * f1);
  		EntityOrthacanthus orthacanthus = (EntityOrthacanthus)entity;
  		if(this.HeadBottom.rotateAngleX > 0.0F || MathHelper.cos(f * 0.3662F) * f1 <= 0.05F) {
  			float open = MathHelper.cos(f * 0.3662F) * f1;
  			if(open < 0.0F) {open = 0.0F;}
  			this.HeadBottom.rotateAngleX = open;
  		}
  	}
}
