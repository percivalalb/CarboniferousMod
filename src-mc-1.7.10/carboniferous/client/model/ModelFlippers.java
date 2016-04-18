package carboniferous.client.model;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

/**
 * @author ProPercivalalb
 */
public class ModelFlippers extends ModelBiped {

    ModelRenderer LFlipper;
    ModelRenderer RFlipper;
	
	public ModelFlippers()
    {
        this(0.0F);
    }

    public ModelFlippers(float par1)
    {
        this(par1, 0.0F, 64, 32);
    }
	
	public ModelFlippers(float par1, float par2, int par3, int par4)
    {
		super(par1, par2, par3, par4);
        
        LFlipper = new ModelRenderer(this, 0, 0);
	    LFlipper.addBox(-2.0F, 10F, -8.0F, 5, 2, 11);
	    LFlipper.setRotationPoint(1.9F, 12.0F + par2, 0.0F);
	    LFlipper.setTextureSize(64, 32);
	    LFlipper.mirror = true;
	    setRotation(LFlipper, 0F, 0F, 0F);
	    RFlipper = new ModelRenderer(this, 32, 0);
	    RFlipper.addBox(-3.0F, 10F, -8.0F, 5, 2, 11);
	    RFlipper.setRotationPoint(-1.9F, 12.0F + par2, 0.0F);
	    RFlipper.setTextureSize(64, 32);
	    RFlipper.mirror = true;
	    setRotation(RFlipper, 0F, 0F, 0F);
    }
	
	private void setRotation(ModelRenderer model, float x, float y, float z) {
	    model.rotateAngleX = x;
	    model.rotateAngleY = y;
	    model.rotateAngleZ = z;
	}
	
	@Override
	public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
	{
		this.setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);
		
	    if (this.isChild) {
	        float f6 = 2.0F;
	        GL11.glPushMatrix();
	        GL11.glScalef(1.5F / f6, 1.5F / f6, 1.5F / f6);
	        GL11.glTranslatef(0.0F, 16.0F * par7, 0.0F);
	        GL11.glPopMatrix();
	        GL11.glPushMatrix();
	        GL11.glScalef(1.0F / f6, 1.0F / f6, 1.0F / f6);
	        GL11.glTranslatef(0.0F, 24.0F * par7, 0.0F);
	        this.RFlipper.render(par7);
	        this.LFlipper.render(par7);
	        GL11.glPopMatrix();
	    }
	    else {
	        this.RFlipper.render(par7);
	        this.LFlipper.render(par7);
	    }
	 }

	 @Override
	 public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
	     this.RFlipper.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
	     this.LFlipper.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
	     this.RFlipper.rotateAngleY = 0.0F;
	     this.LFlipper.rotateAngleY = 0.0F;

	     if (this.isRiding) {
	         this.RFlipper.rotateAngleX = -((float)Math.PI * 2F / 5F);
	         this.LFlipper.rotateAngleX = -((float)Math.PI * 2F / 5F);
	         this.RFlipper.rotateAngleY = ((float)Math.PI / 10F);
	         this.LFlipper.rotateAngleY = -((float)Math.PI / 10F);
	     }
	        
	     if (this.isSneak) {
	         this.RFlipper.rotationPointZ = 6.0F;
	         this.LFlipper.rotationPointZ = 6.0F;
	         this.RFlipper.rotationPointY = 9.0F;
	         this.LFlipper.rotationPointY = 9.0F;
	     }
	     else {
	         this.RFlipper.rotationPointZ = 0.1F;
	         this.LFlipper.rotationPointZ = 0.1F;
	         this.RFlipper.rotationPointY = 12.0F;
	         this.LFlipper.rotationPointY = 12.0F;
	     }
	 }

	 @Override
	 public void renderEars(float par1) {
	       
	 }

	 @Override
	 public void renderCloak(float par1) {
	        
	 }
	  
}
