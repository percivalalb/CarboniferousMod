package carboniferous.client.renderer.entity;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderMob extends RenderLiving {
	
	private float scale = 1F;
	private ResourceLocation resource;
	
    public RenderMob(ModelBase par1ModelBase, float par2, float par3, ResourceLocation resource) {
        super(par1ModelBase, par2);
        this.scale = par3;
        this.resource = resource;
    }

    public RenderMob(ModelBase par1ModelBase, float par2, ResourceLocation resource) {
        super(par1ModelBase, par2);
        this.resource = resource;
    }

    
    public void renderMob(EntityLiving par1EntityHadrosaur, double par2, double par4, double par6, float par8, float par9) {
        super.doRenderLiving(par1EntityHadrosaur, par2, par4, par6, par8, par9);
    }

    @Override
    public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
        this.renderMob(par1EntityLiving, par2, par4, par6, par8, par9);
    }


    @Override
    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
        this.renderMob((EntityLiving)par1Entity, par2, par4, par6, par8, par9);
    }
    
    protected void scaleMob(EntityLivingBase entityammonite, float f) {
        float f1 = scale;
        GL11.glScalef(f1, f1, f1);
    }

    @Override
    protected void preRenderCallback(EntityLivingBase entityliving, float f) {
        scaleMob(entityliving, f);
    }
    
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return resource;
	}
}
