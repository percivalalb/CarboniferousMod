package carboniferous.client.renderer.tileentity;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.lwjgl.opengl.GL11;

import carboniferous.client.model.ModelGiantFern;
import carboniferous.client.model.ModelGrinder;
import carboniferous.lib.ResourceReference;
import carboniferous.tileentity.TileEntityGiantFern;
import carboniferous.tileentity.TileEntityGrinder;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;

public class TileEntityGiantFernRender extends TileEntitySpecialRenderer {
    
	public ModelGiantFern invModel = new ModelGiantFern();

	
    public void renderAModel(TileEntityGiantFern var1, double var2, double var4, double var6, float var8) {
        int var9;

        if (var1.getWorldObj() == null) {
            var9 = EnumFacing.NORTH.ordinal();
        }
        else {
            Block var10 = var1.getBlockType();
            var9 = var1.getBlockMetadata();

            if (var10 != null && var9 == 0) {
                var9 = var1.getBlockMetadata();
            }
        }


        GL11.glPushMatrix();
        GL11.glTranslatef((float)var2 + 0.5F, (float)var4 + 3.0F, (float)var6 + 0.5F);
        short var11 = 90;


        if (var9 == EnumFacing.EAST.ordinal()) {
            var11 = 0;
        }

        if (var9 == EnumFacing.WEST.ordinal()) {
            var11 = 180;
        }

        if (var9 == EnumFacing.NORTH.ordinal()) {
            var11 = 270;
        }


        GL11.glRotatef((float)var11, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
        this.bindTexture(ResourceReference.giantFern);
        GL11.glPushMatrix();

        if(var1.getWorldObj() != null)
        	GL11.glScaled(2.0F, 2.0F, 2.0F);
        this.invModel.render();
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }

    public void renderTileEntityAt(TileEntity var1, double var2, double var4, double var6, float var8)
    {
        this.renderAModel((TileEntityGiantFern)var1, var2, var4, var6, var8);
    }
 
}
