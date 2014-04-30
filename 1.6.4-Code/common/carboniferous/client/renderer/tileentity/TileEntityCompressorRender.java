package carboniferous.client.renderer.tileentity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Hashtable;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

import carboniferous.api.Properties;
import carboniferous.client.model.ModelCompressor;
import carboniferous.client.model.ModelGrinder;
import carboniferous.core.helper.LogHelper;
import carboniferous.lib.ResourceReference;
import carboniferous.tileentity.TileEntityCompressor;
import carboniferous.tileentity.TileEntityGrinder;

public class TileEntityCompressorRender extends TileEntitySpecialRenderer {
    
	public ModelCompressor model = new ModelCompressor();
	
    public void renderAModel(TileEntityCompressor var1, double var2, double var4, double var6, float var8) {
        int var9;

        if (var1.worldObj == null) {
            var9 = 0;
        }
        else {
            Block var10 = var1.getBlockType();
            var9 = var1.getBlockMetadata();

            if (var10 != null && var9 == 0) {
                var9 = var1.getBlockMetadata();
            }
        }
        
        Minecraft mc = Minecraft.getMinecraft();

        GL11.glPushMatrix();
        GL11.glTranslatef((float)var2 + 0.5F, (float)var4 + 1.5F, (float)var6 + 0.5F);
        short var11 = 0;

        if (var9 == 2) {
            var11 = 0;
        }

        if (var9 == 3) {
            var11 = 180;
        }

        if (var9 == 4) {
            var11 = 90;
        }
        
        if(var9 == 5) {
        	var11 = 270;
        }

        GL11.glRotatef((float)var11, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
        this.bindTexture(ResourceReference.blockCompressor);
        this.model.render();
        GL11.glPopMatrix();
    }

    public void renderTileEntityAt(TileEntity var1, double var2, double var4, double var6, float var8) {
        this.renderAModel((TileEntityCompressor)var1, var2, var4, var6, var8);
    }
}
