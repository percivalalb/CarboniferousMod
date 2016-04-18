package carboniferous.client.gui.inventory;

import org.lwjgl.opengl.GL11;

import carboniferous.core.helper.GuiHelper;
import carboniferous.inventory.ContainerGrinder;
import carboniferous.lib.ResourceReference;
import carboniferous.tileentity.TileEntityGrinder;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;

/**
 * @author ProPercivalalb
 **/
@SideOnly(Side.CLIENT)
public class GuiGrinder extends GuiContainer
{
    private TileEntityGrinder grinder;

    public GuiGrinder(InventoryPlayer par1InventoryPlayer, TileEntityGrinder par2TileEntityGrinder) {
        super(new ContainerGrinder(par1InventoryPlayer, par2TileEntityGrinder));
        this.grinder = par2TileEntityGrinder;
    }
    
    @Override
    protected void drawGuiContainerForegroundLayer(int par1, int par2) {
        String s = this.grinder.hasCustomInventoryName() ? this.grinder.getInventoryName() : StatCollector.translateToLocal(this.grinder.getInventoryName());
        this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2 + 20, 6, 4210752);
        this.fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
    }
    
    @Override
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
       
    	//Main Background
    	GuiHelper.glColourDefault();
        GuiHelper.bindTexture(ResourceReference.guiGrinder);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
        //Progress Bar
        GuiHelper.drawProgressBar(k + 92, l + 17, 176, 14, 17, 25, grinder.getGrindProgressScaled(25), 1);
        //Cog
        GuiHelper.bindTexture(ResourceReference.guiGrinderCog);
        if (grinder.grindTime > 0) {
        	grinder.rotation += 0.3F;
        }
        GuiHelper.glColourDefault();
        GL11.glMatrixMode(GL11.GL_TEXTURE /*5890*/);
        GL11.glPushMatrix();
        GL11.glLoadIdentity();
        GL11.glTranslatef(0.25F, 0.2480469F, 0.0F);
        GL11.glRotatef(grinder.rotation, 0.0F, 0.0F, 1.0F);
        GL11.glTranslatef(-0.25F, -0.2480469F, 0.0F);
        this.drawTexturedModalRect(k - 20, l - 20, 0, 0, 128, 127);
        GL11.glPopMatrix();
        GL11.glMatrixMode(GL11.GL_MODELVIEW /*5888*/);
        
        //Slots above Cog
        GuiHelper.glColourDefault();
        GuiHelper.bindTexture(ResourceReference.guiGrinder);
        this.drawTexturedModalRect(k + 23, l + 45, 81, 166, 18, 18);//Input 1
        this.drawTexturedModalRect(k + 47, l + 45, 81, 166, 18, 18);//Input 2
        this.drawTexturedModalRect(k + 35, l + 23, 81, 166, 18, 18);//Grinder Stone
        this.drawTexturedModalRect(k + 31, l + 18, 99, 166, 26, 4);//Grinder Stone Progress Bar
        GuiHelper.drawProgressBar(k + 32, l + 18, 176, 38, 24, 4, grinder.getGrindingStoneDamageScaled(24), 2);
        if (this.grinder.isBurning()) {
            GuiHelper.drawProgressBar(k + 140, l + 21, 176, 0, 24, 14, this.grinder.getBurnTimeRemainingScaled(14), 3);
        }
        
        //int k2 = grinder.componentInv.grindComponentScaled;
        //this.drawTexturedModalRect(k + 69+24-k2, l + 66, 176+24-k2, 18, k2, 4);

	}
}
