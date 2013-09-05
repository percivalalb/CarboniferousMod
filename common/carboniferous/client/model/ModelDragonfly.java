package carboniferous.client.model;

import carboniferous.entity.EntityDragonfly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.network.MemoryConnection;

public class ModelDragonfly extends ModelBase {
    
	ModelRenderer tailPart;
    ModelRenderer tailPart2;
    ModelRenderer tailPart3;
    ModelRenderer tailPart4;
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer tailOuterRight;
    ModelRenderer tailOuterLeft;
    ModelRenderer leftWingLower;
    ModelRenderer leftWingUpper;
    ModelRenderer rightWingLower;
    ModelRenderer rightWingUpper;
    
    private float x = 16F;

    public ModelDragonfly() {
        tailPart = new ModelRenderer(this, 10, 0);
        tailPart.addBox(0.0F, 0.0F, 0.0F, 2, 1, 2);
        tailPart.setRotationPoint(0.4666667F, 0.0F+x, 4F);
        tailPart.rotateAngleX = 0.0F;
        tailPart.rotateAngleY = 0.0F;
        tailPart.rotateAngleZ = 0.0F;
        tailPart.mirror = false;
        tailPart2 = new ModelRenderer(this, 18, 0);
        tailPart2.addBox(0.0F, 0.0F, 0.0F, 2, 1, 2);
        tailPart2.setRotationPoint(0.5F, 0.0F+x, 6F);
        tailPart2.rotateAngleX = -0.22307F;
        tailPart2.rotateAngleY = 0.0F;
        tailPart2.rotateAngleZ = 0.0F;
        tailPart2.mirror = false;
        tailPart3 = new ModelRenderer(this, 27, 0);
        tailPart3.addBox(0.0F, 0.0F, 0.0F, 2, 1, 2);
        tailPart3.setRotationPoint(0.5F, 0.5F+x, 8F);
        tailPart3.rotateAngleX = -0.44614F;
        tailPart3.rotateAngleY = 0.0F;
        tailPart3.rotateAngleZ = 0.0F;
        tailPart3.mirror = false;
        tailPart4 = new ModelRenderer(this, 36, 0);
        tailPart4.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2);
        tailPart4.setRotationPoint(1.0F, 1.5F+x, 9.8F);
        tailPart4.rotateAngleX = -0.66922F;
        tailPart4.rotateAngleY = 0.0F;
        tailPart4.rotateAngleZ = 0.0F;
        tailPart4.mirror = false;
        head = new ModelRenderer(this, 0, 0);
        head.addBox(0.0F, 0.0F, 0.0F, 3, 2, 2);
        head.setRotationPoint(0.0F, 0.2F+x, -1F);
        head.rotateAngleX = 0.18589F;
        head.rotateAngleY = 0.0F;
        head.rotateAngleZ = 0.0F;
        head.mirror = false;
        body = new ModelRenderer(this, 0, 4);
        body.addBox(0.0F, 0.0F, 0.0F, 3, 2, 3);
        body.setRotationPoint(0.0F, 0.0F+x, 1.0F);
        body.rotateAngleX = 0.0F;
        body.rotateAngleY = 0.0F;
        body.rotateAngleZ = 0.0F;
        body.mirror = false;
        tailOuterRight = new ModelRenderer(this, 48, 0);
        tailOuterRight.addBox(0.0F, 0.0F, 0.0F, 0, 1, 2);
        tailOuterRight.setRotationPoint(0.91F, 2.533333F+x, 11F);
        tailOuterRight.rotateAngleX = -0.89229F;
        tailOuterRight.rotateAngleY = 0.0F;
        tailOuterRight.rotateAngleZ = 0.0F;
        tailOuterRight.mirror = false;
        tailOuterLeft = new ModelRenderer(this, 43, 0);
        tailOuterLeft.addBox(0.0F, 0.0F, 0.0F, 0, 1, 2);
        tailOuterLeft.setRotationPoint(2.0F, 2.5F+x, 11F);
        tailOuterLeft.rotateAngleX = -0.89229F;
        tailOuterLeft.rotateAngleY = 0.0F;
        tailOuterLeft.rotateAngleZ = 0.0F;
        tailOuterLeft.mirror = false;
        leftWingLower = new ModelRenderer(this, 0, 10);
        leftWingLower.addBox(0.0F, 0.0F, 0.0F, 5, 1, 2);
        leftWingLower.setRotationPoint(3F, 0.1F+x, 2.0F);
        leftWingLower.rotateAngleX = 0.0F;
        leftWingLower.rotateAngleY = 0.0F;
        leftWingLower.rotateAngleZ = 0.0F;
        leftWingLower.mirror = false;
        leftWingUpper = new ModelRenderer(this, 15, 10);
        leftWingUpper.addBox(0.0F, 0.0F, 0.0F, 8, 1, 2);
        leftWingUpper.setRotationPoint(2.0F, 0.1F+x, 1.0F);
        leftWingUpper.rotateAngleX = -0.14871F;
        leftWingUpper.rotateAngleY = 0.18589F;
        leftWingUpper.rotateAngleZ = -0.11154F;
        leftWingUpper.mirror = false;
        rightWingLower = new ModelRenderer(this, 0, 14);
        rightWingLower.addBox(-5F, 0.0F, 0.0F, 5, 1, 2);
        rightWingLower.setRotationPoint(0.0F, 0.0F+x, 2.0F);
        rightWingLower.rotateAngleX = 0.0F;
        rightWingLower.rotateAngleY = 0.0F;
        rightWingLower.rotateAngleZ = 0.0F;
        rightWingLower.mirror = false;
        rightWingUpper = new ModelRenderer(this, 15, 14);
        rightWingUpper.addBox(0.0F, 0.0F, 0.0F, 8, 1, 2);
        rightWingUpper.setRotationPoint(0.5F, 0.6F+x, 3F);
        rightWingUpper.rotateAngleX = 0.24335F;
        rightWingUpper.rotateAngleY = 2.91728F;
        rightWingUpper.rotateAngleZ = -0.09563F;
        rightWingUpper.mirror = false;
    }

    @Override
    public void setLivingAnimations(EntityLivingBase entityliving, float f, float f1, float f2) {
        EntityDragonfly entitydragonfly = (EntityDragonfly)entityliving;
        updateWings(entitydragonfly);
        flexTail(entitydragonfly);
    }

    private void flexTail(EntityDragonfly entitydragonfly) {
        if (entitydragonfly.isFlappingWings()) {
            entitydragonfly.tailState += 0.5F;
            if (entitydragonfly.tailState > 5F) {
                entitydragonfly.tailState = 5F;
            }
        }
        else {
            entitydragonfly.tailState -= 0.5F;
            if (entitydragonfly.tailState < 0.0F) {
                entitydragonfly.tailState = 0.0F;
            }
        }
        tailPart.rotationPointY = 0.0F + 0.0F * entitydragonfly.tailState+x;
        tailPart.rotateAngleX = 0.0F + 0.0F * entitydragonfly.tailState;
        tailPart2.rotationPointY = 0.0F + 0.01F * entitydragonfly.tailState+x;
        tailPart2.rotateAngleX = -0.22307F + 0.03F * entitydragonfly.tailState;
        tailPart3.rotationPointY = 0.5F - 0.06F * entitydragonfly.tailState+x;
        tailPart3.rotateAngleX = -0.44614F + 0.05F * entitydragonfly.tailState;
        tailPart4.rotationPointY = 1.5F - 0.2F * entitydragonfly.tailState+x;
        tailPart4.rotateAngleX = -0.66922F + 0.05F * entitydragonfly.tailState;
        tailOuterRight.rotationPointY = 2.533333F - 0.3F * entitydragonfly.tailState+x;
        tailOuterRight.rotateAngleX = -0.89229F + 0.05F * entitydragonfly.tailState;
        tailOuterLeft.rotationPointY = 2.5F - 0.3F * entitydragonfly.tailState+x;
        tailOuterLeft.rotateAngleX = -0.89229F + 0.05F * entitydragonfly.tailState;
    }

    private void updateWings(EntityDragonfly entitydragonfly) {
    	Minecraft mc = Minecraft.getMinecraft();
    	if(!((MemoryConnection)mc.thePlayer.sendQueue.getNetManager()).isGamePaused()) {
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
    		leftWingLower.rotateAngleZ = 0.0F + f;
    		leftWingUpper.rotateAngleZ = -0.11154F + f;
    		rightWingLower.rotateAngleZ = 0.0F - f;
    		rightWingUpper.rotateAngleZ = 0.14871F - f;
    	}
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        tailPart.render(f5);
        tailPart2.render(f5);
        tailPart3.render(f5);
        tailPart4.render(f5);
        head.render(f5);
        body.render(f5);
        tailOuterRight.render(f5);
        tailOuterLeft.render(f5);
        leftWingLower.render(f5);
        leftWingUpper.render(f5);
        rightWingLower.render(f5);
        rightWingUpper.render(f5);
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }
}
