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
import carboniferous.client.model.ModelGrinder;
import carboniferous.core.helper.GuiHelper;
import carboniferous.core.helper.LogHelper;
import carboniferous.lib.ResourceReference;
import carboniferous.tileentity.TileEntityGrinder;

public class TileEntityGrinderRender extends TileEntitySpecialRenderer {
    
	private Map<Object, ModelGrinder> aModel = new Hashtable<Object, ModelGrinder>();
	public ModelGrinder invModel = new ModelGrinder();
	private Minecraft mc = Minecraft.getMinecraft();
	
	
    public void renderAModel(TileEntityGrinder var1, double var2, double var4, double var6, float var8) {
        int var9;

        if (var1.getWorldObj() == null) {
            var9 = 3;
        }
        else {
            Block var10 = var1.getBlockType();
            var9 = var1.getBlockMetadata();

            if (var10 != null && var9 == 0) {
                var9 = var1.getBlockMetadata();
            }
        }
        
        
        //TODO put in update tile entity method!!!!!!!
        Minecraft mc = Minecraft.getMinecraft();
    	//if(!((MemoryConnection)mc.thePlayer.sendQueue.getNetManager()).isGamePaused() && var1.worldObj != null && var1.clientSpinTime < 80) {
       // 	getModel(var1.xCoord, var1.yCoord, var1.zCoord, var1.worldObj.provider.dimensionId).rotateCog(0.06F);
    	//}

        GL11.glPushMatrix();
        GL11.glTranslatef((float)var2 + 0.5F, (float)var4 + 1.5F, (float)var6 + 0.5F);
        short var11 = 0;

        if (var9 == 2) {
            var11 = 90;
        }

        if (var9 == 0) {
            var11 = 180;
        }

        if (var9 == 1) {
            var11 = 270;
        }

        GL11.glRotatef((float)var11, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
        this.bindTexture(ResourceReference.blockGrinder);
        GL11.glPushMatrix();
        if(var1.getWorldObj() != null) {
        	ModelGrinder model = getModel(var1.xCoord, var1.yCoord, var1.zCoord, var1.getWorldObj().provider.dimensionId);
        	model.rotateCog(var1.cogSpinRoatation);
        	model.render();
        }
        else {
        	this.invModel.render();
        }
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }

    public void renderTileEntityAt(TileEntity var1, double var2, double var4, double var6, float var8)
    {
        this.renderAModel((TileEntityGrinder)var1, var2, var4, var6, var8);
    }
    
    public ModelGrinder getModel(int x, int y, int z, int dim) {
    	List list = Arrays.asList(x, y, z, dim);
    	if(!aModel.containsKey(list)) {
        	aModel.put(list, new ModelGrinder());
    	}
    	
		return aModel.get(list);
    }
}
