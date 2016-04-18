package carboniferous.client.model;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelDendrerpeton extends ModelBase
{
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer leg1;
    ModelRenderer leg2;
    ModelRenderer leg3;
    ModelRenderer leg4;
    ModelRenderer tail1;
    ModelRenderer tail2;
    ModelRenderer tail3;
    ModelRenderer upperleg1;
    ModelRenderer upperleg2;
    ModelRenderer upperleg4;
    ModelRenderer upperleg3;
    protected float field_40331_g;
    protected float field_40332_n;

    public ModelDendrerpeton()
    {
        textureWidth = 64;
        textureHeight = 32;
        field_40331_g = 8F;
        field_40332_n = 4F;
        head = new ModelRenderer(this, 10, 20);
        head.addBox(-4F, -4F, -8F, 6, 3, 9);
        head.setRotationPoint(0.0F, 22F, -8F);
        head.setTextureSize(64, 32);
        head.mirror = true;
        setRotation(head, 0.0F, 0.0F, 0.0F);
        body = new ModelRenderer(this, 40, 10);
        body.addBox(-5F, -10F, -7F, 8, 18, 4);
        body.setRotationPoint(0.0F, 14F, 3F);
        body.setTextureSize(64, 32);
        body.mirror = true;
        setRotation(body, 2.0F, 0.0F, 0.0F);
        leg1 = new ModelRenderer(this, 0, 24);
        leg1.addBox(-2F, 0.0F, -2F, 2, 5, 2);
        leg1.setRotationPoint(-6.8F, 20.2F, 7F);
        leg1.setTextureSize(64, 32);
        leg1.mirror = true;
        setRotation(leg1, 0.0F, 0.0F, 0.0F);
        leg2 = new ModelRenderer(this, 0, 24);
        leg2.addBox(-2F, 0.0F, -2F, 2, 5, 2);
        leg2.setRotationPoint(6.4F, 19.5F, 7F);
        leg2.setTextureSize(64, 32);
        leg2.mirror = true;
        setRotation(leg2, 0.0F, 0.0F, 0.0F);
        leg3 = new ModelRenderer(this, 0, 24);
        leg3.addBox(0.0F, 0.0F, 0.0F, 2, 5, 2);
        leg3.setRotationPoint(-8.7F, 19F, -7F);
        leg3.setTextureSize(64, 32);
        leg3.mirror = true;
        setRotation(leg3, 0.0F, 0.0F, 0.0F);
        leg4 = new ModelRenderer(this, 0, 24);
        leg4.addBox(-2F, 0.0F, -2F, 2, 5, 2);
        leg4.setRotationPoint(6.4F, 19.5F, -5F);
        leg4.setTextureSize(64, 32);
        leg4.mirror = true;
        setRotation(leg4, 0.0F, 0.0F, 0.0F);
        tail1 = new ModelRenderer(this, 38, 0);
        tail1.addBox(0.0F, 0.0F, 0.0F, 6, 2, 7);
        tail1.setRotationPoint(-4F, 18F, 11F);
        tail1.setTextureSize(64, 32);
        tail1.mirror = true;
        setRotation(tail1, 0.0F, 0.0F, 0.0F);
        tail2 = new ModelRenderer(this, 0, 0);
        tail2.addBox(0.0F, 0.0F, 0.0F, 4, 1, 7);
        tail2.setRotationPoint(-3F, 19F, 17F);
        tail2.setTextureSize(64, 32);
        tail2.mirror = true;
        setRotation(tail2, 0.0F, 0.0F, 0.0F);
        tail3 = new ModelRenderer(this, 22, 0);
        tail3.addBox(0.0F, 0.0F, 0.0F, 2, 1, 4);
        tail3.setRotationPoint(-2F, 19F, 24F);
        tail3.setTextureSize(64, 32);
        tail3.mirror = true;
        setRotation(tail3, 0.0F, 0.0F, 0.0F);
        upperleg1 = new ModelRenderer(this, 0, 16);
        upperleg1.addBox(0.0F, 0.0F, 0.0F, 4, 2, 2);
        upperleg1.setRotationPoint(2.0F, 19F, -7F);
        upperleg1.setTextureSize(64, 32);
        upperleg1.mirror = true;
        setRotation(upperleg1, 0.0F, 0.0F, 0.0F);
        upperleg2 = new ModelRenderer(this, 0, 16);
        upperleg2.addBox(0.0F, 0.0F, 0.0F, 4, 2, 2);
        upperleg2.setRotationPoint(-5F, 20.5F, -7F);
        upperleg2.setTextureSize(64, 32);
        upperleg2.mirror = true;
        setRotation(upperleg2, 0.0F, 0.0F, -3F);
        upperleg4 = new ModelRenderer(this, 0, 16);
        upperleg4.addBox(0.0F, 0.0F, 0.0F, 4, 2, 2);
        upperleg4.setRotationPoint(-5F, 21F, 5F);
        upperleg4.setTextureSize(64, 32);
        upperleg4.mirror = true;
        setRotation(upperleg4, 0.0F, 0.0F, -3F);
        upperleg3 = new ModelRenderer(this, 0, 16);
        upperleg3.addBox(0.0F, 0.0F, 0.0F, 4, 2, 2);
        upperleg3.setRotationPoint(2.0F, 19F, 5F);
        upperleg3.setTextureSize(64, 32);
        upperleg3.mirror = true;
        setRotation(upperleg3, 0.0F, 0.0F, 0.0F);
    }

    private void setRotation(ModelRenderer modelrenderer, float f, float f1, float f2)
    {
        modelrenderer.rotateAngleX = f;
        modelrenderer.rotateAngleY = f1;
        modelrenderer.rotateAngleZ = f2;
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        if (this.isChild)
        {
            float f6 = 2.0F;
            GL11.glPushMatrix();
            GL11.glTranslatef(0.0F, field_40331_g * f5, field_40332_n * f5);
            head.render(f5);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glScalef(1.0F / f6, 1.0F / f6, 1.0F / f6);
            GL11.glTranslatef(0.0F, 24F * f5, 0.0F);
            body.render(f5);
            leg1.render(f5);
            leg2.render(f5);
            leg3.render(f5);
            leg4.render(f5);
            tail1.render(f5);
            tail2.render(f5);
            tail3.render(f5);
            upperleg1.render(f5);
            upperleg2.render(f5);
            upperleg4.render(f5);
            upperleg3.render(f5);
            GL11.glPopMatrix();
        }
        else
        {
            head.render(f5);
            body.render(f5);
            leg1.render(f5);
            leg2.render(f5);
            leg3.render(f5);
            leg4.render(f5);
            tail1.render(f5);
            tail2.render(f5);
            tail3.render(f5);
            upperleg1.render(f5);
            upperleg2.render(f5);
            upperleg4.render(f5);
            upperleg3.render(f5);
        }
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
        head.rotateAngleX = f4 / 57.29578F;
        head.rotateAngleY = f3 / 57.29578F;
        body.rotateAngleX = 1.570796F;
        leg1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
        leg2.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141593F) * 1.4F * f1;
        leg3.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141593F) * 1.4F * f1;
        leg4.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    }
}
