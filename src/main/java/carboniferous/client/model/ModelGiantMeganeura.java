package carboniferous.client.model;

import carboniferous.entity.EntityGiantMeganeura;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;

public class ModelGiantMeganeura extends ModelBase
{
  //fields
    ModelRenderer eyeLeft;
    ModelRenderer tail;
    ModelRenderer body;
    ModelRenderer head;
    ModelRenderer eyeRight;
    ModelRenderer wing;
    ModelRenderer wing2;
    ModelRenderer wing2lower;
    ModelRenderer winglower;
    ModelRenderer Legbackleft;
    ModelRenderer Legbackright;
    ModelRenderer Legmiddleleft;
    ModelRenderer Legfrontleft;
    ModelRenderer Legfrontright;
    ModelRenderer Legmiddleright;
  
  public ModelGiantMeganeura()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      eyeLeft = new ModelRenderer(this, 0, 40);
      eyeLeft.addBox(1F, -4.5F, -16.5F, 6, 9, 8);
      eyeLeft.setRotationPoint(0F, 0F, 0F);
      eyeLeft.setTextureSize(128, 64);
      eyeLeft.mirror = true;
      setRotation(eyeLeft, 0F, 0F, 0F);
      tail = new ModelRenderer(this, 0, 0);
      tail.addBox(-4F, -4F, 8F, 8, 8, 32);
      tail.setRotationPoint(0F, 0F, 0F);
      tail.setTextureSize(128, 64);
      tail.mirror = true;
      setRotation(tail, 0F, 0F, 0F);
      body = new ModelRenderer(this, 48, 4);
      body.addBox(-6F, -6F, -8F, 12, 12, 16);
      body.setRotationPoint(0F, 0F, 0F);
      body.setTextureSize(128, 64);
      body.mirror = true;
      setRotation(body, 0F, 0F, 0F);
      head = new ModelRenderer(this, 0, 16);
      head.addBox(-4F, -4F, -16F, 8, 8, 8);
      head.setRotationPoint(0F, 0F, 0F);
      head.setTextureSize(128, 64);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      eyeRight = new ModelRenderer(this, 0, 40);
      eyeRight.mirror = true;
      eyeRight.addBox(-7F, -4.5F, -16.5F, 6, 9, 8);
      eyeRight.setRotationPoint(0F, 0F, 0F);
      eyeRight.setTextureSize(128, 64);
      setRotation(eyeRight, 0F, 0F, 0F);
      eyeRight.mirror = false;
      wing = new ModelRenderer(this, 28, 40);
      wing.mirror = true;
      wing.addBox(-32F, -1F, 0F, 32, 1, 16);
      wing.setRotationPoint(-4F, -7F, -6F);
      wing.setTextureSize(128, 64);
      setRotation(wing, 0F, 0.2617994F, 0F);
      wing2 = new ModelRenderer(this, 28, 40);
      wing.mirror = true;
      wing2.addBox(0F, -1F, 0F, 32, 1, 16);
      wing2.setRotationPoint(4F, -7F, -6F);
      wing2.setTextureSize(128, 64);
      setRotation(wing2, 0F, -0.2617994F, 0F);
      wing2lower = new ModelRenderer(this, 28, 40);
      wing2lower.mirror = false;
      wing2lower.addBox(0F, -1F, 0F, 32, 1, 16);
      wing2lower.setRotationPoint(4F, -6F, -6F);
      wing2lower.setTextureSize(128, 64);
      setRotation(wing2lower, 0F, 0F, 0F);
      winglower = new ModelRenderer(this, 28, 40);
      winglower.mirror = true;
      winglower.addBox(-32F, -1F, 0F, 32, 1, 16);
      winglower.setRotationPoint(-4F, -6F, -6F);
      winglower.setTextureSize(128, 64);
      setRotation(winglower, 0F, 0F, 0F);
      Legbackleft = new ModelRenderer(this, 0, 0);
      Legbackleft.addBox(-1F, 0F, -1F, 2, 8, 2);
      Legbackleft.setRotationPoint(7F, 4F, 1F);
      Legbackleft.setTextureSize(128, 64);
      Legbackleft.mirror = true;
      setRotation(Legbackleft, 0.0872665F, 0F, 0F);
      Legbackright = new ModelRenderer(this, 0, 0);
      Legbackright.mirror = true;
      Legbackright.addBox(-1F, 0F, -1F, 2, 8, 2);
      Legbackright.setRotationPoint(-7F, 4F, 1F);
      Legbackright.setTextureSize(128, 64);
      setRotation(Legbackright, 0.0872665F, 0F, 0F);
      Legmiddleleft = new ModelRenderer(this, 0, 0);
      Legmiddleleft.addBox(-1F, 0F, -1F, 2, 8, 2);
      Legmiddleleft.setRotationPoint(7F, 4F, -2F);
      Legmiddleleft.setTextureSize(128, 64);
      Legmiddleleft.mirror = true;
      setRotation(Legmiddleleft, 0.0349066F, 0F, 0F);
      Legfrontleft = new ModelRenderer(this, 0, 0);
      Legfrontleft.addBox(-1F, 0F, -1F, 2, 8, 2);
      Legfrontleft.setRotationPoint(7F, 4F, -5F);
      Legfrontleft.setTextureSize(128, 64);
      Legfrontleft.mirror = true;
      setRotation(Legfrontleft, 0F, 0F, 0F);
      Legfrontright = new ModelRenderer(this, 0, 0);
      Legfrontright.mirror = true;
      Legfrontright.addBox(-1F, 0F, -1F, 2, 8, 2);
      Legfrontright.setRotationPoint(-7F, 4F, -5F);
      Legfrontright.setTextureSize(128, 64);
      setRotation(Legfrontright, 0F, 0F, 0F);
      Legmiddleright = new ModelRenderer(this, 0, 0);
      Legmiddleright.mirror = true;
      Legmiddleright.addBox(-1F, 0F, -1F, 2, 8, 2);
      Legmiddleright.setRotationPoint(-7F, 4F, -2F);
      Legmiddleright.setTextureSize(128, 64);
      setRotation(Legmiddleright, 0.0349066F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    eyeLeft.render(f5);
    tail.render(f5);
    body.render(f5);
    head.render(f5);
    eyeRight.render(f5);
    wing.render(f5);
    wing2.render(f5);
    wing2lower.render(f5);
    winglower.render(f5);
    Legbackleft.render(f5);
    Legbackright.render(f5);
    Legmiddleleft.render(f5);
    Legfrontleft.render(f5);
    Legfrontright.render(f5);
    Legmiddleright.render(f5);
  }
  
  	private void setRotation(ModelRenderer model, float x, float y, float z) {
  		model.rotateAngleX = x;
  		model.rotateAngleY = y;
  		model.rotateAngleZ = z;
  	}
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
	  super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }
  
  @Override
  public void setLivingAnimations(EntityLivingBase entityliving, float f, float f1, float f2) {
      EntityGiantMeganeura entitydragonfly = (EntityGiantMeganeura)entityliving;
      updateWings(entitydragonfly);
  }

  private void updateWings(EntityGiantMeganeura entitydragonfly) {
  	Minecraft mc = Minecraft.getMinecraft();
  		if (entitydragonfly.isFlappingWings()) {
  			entitydragonfly.wingState++;
  			if (++entitydragonfly.wingState >= 10) {
  				entitydragonfly.wingState = -10;
  			}
  		}
  		else {
  			entitydragonfly.wingState = 0;
  		}
  		float f = (float)entitydragonfly.wingState * 0.1F;
  		wing2.rotateAngleZ = 0.0F + f;
  		wing2lower.rotateAngleZ = -0.11154F + f;
  		wing.rotateAngleZ = 0.0F - f;
  		winglower.rotateAngleZ = 0.14871F - f;
  	}

}
