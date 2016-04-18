package carboniferous.client.renderer;

import org.lwjgl.opengl.GL11;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

/**
 * @author ProPercivalalb
 **/
public class RenderUtils {

	private static RenderUtils instance = new RenderUtils();
	
	public static RenderUtils instance() {
		return instance;
	}
	
	//Both Render
	
	public void setRenderBounds(RenderBlocks renderer, double par1, double par3, double par5, double par7, double par9, double par11) {
        if (!renderer.lockBlockBounds) {
        	renderer.renderMinX = par1;
        	renderer.renderMaxX = par7;
        	renderer.renderMinY = par3;
        	renderer.renderMaxY = par9;
        	renderer.renderMinZ = par5;
        	renderer.renderMaxZ = par11;
        	renderer.partialRenderBounds = renderer.minecraftRB.gameSettings.ambientOcclusion >= 2 && (renderer.renderMinX > 0.0D || renderer.renderMaxX < 1.0D || renderer.renderMinY > 0.0D || renderer.renderMaxY < 1.0D || renderer.renderMinZ > 0.0D || renderer.renderMaxZ < 1.0D);
        }
    }
	
	public void renderBlock(Type type, RenderBlocks renderer, RenderData data) {
		if(type == Type.WORLD && data.x != -300000000) {
			this.renderWorldBlock(renderer, data.block, data.x, data.y, data.z);
		}
		else if(type == Type.INVENTORY && data.x == -300000000) {
			this.renderInvBlock(renderer, data.block, data.metadata);
		}
	}
	
	//Inventory Render
	
	public void renderInvBlock(RenderBlocks renderer, Block block, int metadata) {
		Tessellator tessellator = Tessellator.instance;
	    GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
	    tessellator.startDrawingQuads();
	    tessellator.setNormal(0.0F, -1.0F, 0.0F);
	    renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 0, metadata));
	    tessellator.draw();
	    tessellator.startDrawingQuads();
	    tessellator.setNormal(0.0F, 1.0F, 0.0F);
	    renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 1, metadata));
	    tessellator.draw();
	    tessellator.startDrawingQuads();
	    tessellator.setNormal(0.0F, 0.0F, -1.0F);
	    renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 2, metadata));
	    tessellator.draw();
	    tessellator.startDrawingQuads();
	    tessellator.setNormal(0.0F, 0.0F, 1.0F);
	    renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 3, metadata));
	    tessellator.draw();
	    tessellator.startDrawingQuads();
	    tessellator.setNormal(-1.0F, 0.0F, 0.0F);
	    renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 4, metadata));
	    tessellator.draw();
	    tessellator.startDrawingQuads();
	    tessellator.setNormal(1.0F, 0.0F, 0.0F);
	    renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 5, metadata));
	    tessellator.draw();
	    GL11.glTranslatef(0.5F, 0.5F, 0.5F);
	}
	
	//World Render
	
	public boolean renderWorldBlock(RenderBlocks renderer, Block par1Block, int par2, int par3, int par4) {
		return renderer.renderStandardBlock(par1Block, par2, par3, par4);
    }
	
	public boolean renderWorldCrossedSquares(RenderBlocks renderer, IBlockAccess world, Block par1Block, int x, int y, int z) {
        Tessellator tessellator = Tessellator.instance;
        tessellator.setBrightness(par1Block.getMixedBrightnessForBlock(world, x, y, z));
        float f = 1.0F;
        int l = par1Block.colorMultiplier(world, x, y, z);
        float f1 = (float)(l >> 16 & 255) / 255.0F;
        float f2 = (float)(l >> 8 & 255) / 255.0F;
        float f3 = (float)(l & 255) / 255.0F;
        if (EntityRenderer.anaglyphEnable) {
            float f4 = (f1 * 30.0F + f2 * 59.0F + f3 * 11.0F) / 100.0F;
            float f5 = (f1 * 30.0F + f2 * 70.0F) / 100.0F;
            float f6 = (f1 * 30.0F + f3 * 70.0F) / 100.0F;
            f1 = f4;
            f2 = f5;
            f3 = f6;
        }
        tessellator.setColorOpaque_F(f * f1, f * f2, f * f3);
        double d0 = (double)x;
        double d1 = (double)y;
        double d2 = (double)z;
        this.drawCrossedSquares(renderer, world, par1Block, x, y, z, d0, d1, d2, 1.0F);
        return true;
    }
	
	private void drawCrossedSquares(RenderBlocks renderer, IBlockAccess world, Block par1Block, int x, int y, int z, double par3, double par5, double par7, float par9) {
		Tessellator tessellator = Tessellator.instance;
	    IIcon icon = renderer.getBlockIcon(par1Block, world, x, y, z, 0);
	    if (renderer.hasOverrideBlockTexture()) {
	    	icon = renderer.overrideBlockTexture;
	    }
	    double d3 = (double)icon.getMinU();
	    double d4 = (double)icon.getMinV();
	    double d5 = (double)icon.getMaxU();
	    double d6 = (double)icon.getMaxV();
	    double d7 = 0.45D * (double)par9;
	    double d8 = par3 + 0.5D - d7;
	    double d9 = par3 + 0.5D + d7;
	    double d10 = par7 + 0.5D - d7;
	    double d11 = par7 + 0.5D + d7;
	    
	    tessellator.addVertexWithUV(d8, par5 + (double)par9, d10, d3, d4);
	    tessellator.addVertexWithUV(d8, par5 + 0.0D, d10, d3, d6);
	    tessellator.addVertexWithUV(d9, par5 + 0.0D, d11, d5, d6);
	    tessellator.addVertexWithUV(d9, par5 + (double)par9, d11, d5, d4);
	    tessellator.addVertexWithUV(d9, par5 + (double)par9, d11, d3, d4);
	    tessellator.addVertexWithUV(d9, par5 + 0.0D, d11, d3, d6);
	    tessellator.addVertexWithUV(d8, par5 + 0.0D, d10, d5, d6);
	    tessellator.addVertexWithUV(d8, par5 + (double)par9, d10, d5, d4);
	    tessellator.addVertexWithUV(d8, par5 + (double)par9, d11, d3, d4);
	    tessellator.addVertexWithUV(d8, par5 + 0.0D, d11, d3, d6);
	    tessellator.addVertexWithUV(d9, par5 + 0.0D, d10, d5, d6);
	    tessellator.addVertexWithUV(d9, par5 + (double)par9, d10, d5, d4);
	    tessellator.addVertexWithUV(d9, par5 + (double)par9, d10, d3, d4);
	    tessellator.addVertexWithUV(d9, par5 + 0.0D, d10, d3, d6);
	    tessellator.addVertexWithUV(d8, par5 + 0.0D, d11, d5, d6);
	    tessellator.addVertexWithUV(d8, par5 + (double)par9, d11, d5, d4);
	}
	
	public static enum Type {
		WORLD,
		INVENTORY;
	}
	
	public static class RenderData {
		
		int x, y, z = -300000000;
		int metadata = 0;
		Block block;
		
		public RenderData(IBlockAccess world, Block block, int x, int y, int z) {
			this(block, world.getBlockMetadata(x, y, z));
			this.x = x;
			this.y = y;
			this.z = z;
		}
		
		public RenderData(Block block, int metadata) {
			this.metadata = metadata;
			this.block = block;
		}
	}
}
