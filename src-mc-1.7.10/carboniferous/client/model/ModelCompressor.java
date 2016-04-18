package carboniferous.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelCompressor extends ModelBase
{
  //fields
    ModelRenderer CompressorBase;
    ModelRenderer CompessorSlab;
    ModelRenderer ButtonBase1;
    ModelRenderer ButtonTop1;
    ModelRenderer ButtonBase2;
    ModelRenderer ButtonTop2;
    ModelRenderer ButtonBase3;
    ModelRenderer ButtonTop3;
    ModelRenderer CompressorTopSlab1;
    ModelRenderer CompressorTobSlab2;
    ModelRenderer OpenStuff;
  
    public ModelCompressor()
    {
    	textureWidth = 128;
    	textureHeight = 64;
    
    	CompressorBase = new ModelRenderer(this, 0, 0);
    	CompressorBase.addBox(0F, 0F, 0F, 12, 13, 12);
    	CompressorBase.setRotationPoint(-6F, 10F, -6F);
    	CompressorBase.setTextureSize(128, 64);
    	CompressorBase.mirror = true;
    	setRotation(CompressorBase, 0F, 0F, 0F);
    	CompessorSlab = new ModelRenderer(this, 0, 25);
    	CompessorSlab.addBox(0F, 0F, 0F, 16, 2, 16);
    	CompessorSlab.setRotationPoint(-8F, 22F, -8F);
    	CompessorSlab.setTextureSize(128, 64);
    	CompessorSlab.mirror = true;
    	setRotation(CompessorSlab, 0F, 0F, 0F);
      ButtonBase1 = new ModelRenderer(this, 70, 4);
      ButtonBase1.addBox(0F, 0F, 0F, 4, 4, 1);
      ButtonBase1.setRotationPoint(-2F, 14F, 6F);
      ButtonBase1.setTextureSize(128, 64);
      ButtonBase1.mirror = true;
      setRotation(ButtonBase1, 0F, 0F, 0F);
      ButtonTop1 = new ModelRenderer(this, 70, 0);
      ButtonTop1.addBox(0F, 0F, 0F, 2, 2, 1);
      ButtonTop1.setRotationPoint(-1F, 15F, 7F);
      ButtonTop1.setTextureSize(128, 64);
      ButtonTop1.mirror = true;
      setRotation(ButtonTop1, 0F, 0F, 0F);
      ButtonBase2 = new ModelRenderer(this, 70, 10);
      ButtonBase2.addBox(0F, 0F, 0F, 1, 4, 4);
      ButtonBase2.setRotationPoint(6F, 14F, -2F);
      ButtonBase2.setTextureSize(128, 64);
      ButtonBase2.mirror = true;
      setRotation(ButtonBase2, 0F, 0F, 0F);
      ButtonTop2 = new ModelRenderer(this, 70, 19);
      ButtonTop2.addBox(0F, 0F, 0F, 1, 2, 2);
      ButtonTop2.setRotationPoint(7F, 15F, -1F);
      ButtonTop2.setTextureSize(128, 64);
      ButtonTop2.mirror = true;
      setRotation(ButtonTop2, 0F, 0F, 0F);
      ButtonBase3 = new ModelRenderer(this, 70, 10);
      ButtonBase3.addBox(0F, 0F, 0F, 1, 4, 4);
      ButtonBase3.setRotationPoint(-7F, 14F, -2F);
      ButtonBase3.setTextureSize(128, 64);
      ButtonBase3.mirror = true;
      setRotation(ButtonBase3, 0F, 0F, 0F);
      ButtonTop3 = new ModelRenderer(this, 70, 19);
      ButtonTop3.addBox(0F, 0F, 0F, 1, 2, 2);
      ButtonTop3.setRotationPoint(-8F, 15F, -1F);
      ButtonTop3.setTextureSize(128, 64);
      ButtonTop3.mirror = true;
      setRotation(ButtonTop3, 0F, 0F, 0F);
      CompressorTopSlab1 = new ModelRenderer(this, 32, 43);
      CompressorTopSlab1.addBox(0F, 0F, 0F, 10, 1, 10);
      CompressorTopSlab1.setRotationPoint(-5F, 9F, -5F);
      CompressorTopSlab1.setTextureSize(128, 64);
      CompressorTopSlab1.mirror = true;
      setRotation(CompressorTopSlab1, 0F, 0F, 0F);
      CompressorTobSlab2 = new ModelRenderer(this, 0, 45);
      CompressorTobSlab2.addBox(0F, 0F, 0F, 8, 1, 8);
      CompressorTobSlab2.setRotationPoint(-4F, 8F, -4F);
      CompressorTobSlab2.setTextureSize(128, 64);
      CompressorTobSlab2.mirror = true;
      setRotation(CompressorTobSlab2, 0F, 0F, 0F);
      OpenStuff = new ModelRenderer(this, 70, 24);
      OpenStuff.addBox(0F, 0F, 0F, 9, 6, 1);
      OpenStuff.setRotationPoint(-4.5F, 13F, -7F);
      OpenStuff.setTextureSize(128, 64);
      OpenStuff.mirror = true;
      setRotation(OpenStuff, 0F, 0F, 0F);
  	}
  
  	public void render() {
	    CompressorBase.render(0.0625F);
	    CompessorSlab.render(0.0625F);
	    ButtonBase1.render(0.0625F);
	    ButtonTop1.render(0.0625F);
	    ButtonBase2.render(0.0625F);
	    ButtonTop2.render(0.0625F);
	    ButtonBase3.render(0.0625F);
	    ButtonTop3.render(0.0625F);
	    CompressorTopSlab1.render(0.0625F);
	    CompressorTobSlab2.render(0.0625F);
	    OpenStuff.render(0.0625F);
  	}
  
  	private void setRotation(ModelRenderer model, float x, float y, float z) {
  		model.rotateAngleX = x;
  		model.rotateAngleY = y;
  		model.rotateAngleZ = z;
  	}

}
