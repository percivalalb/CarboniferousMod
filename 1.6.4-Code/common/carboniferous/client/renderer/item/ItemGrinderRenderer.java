package carboniferous.client.renderer.item;

import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import carboniferous.api.Properties;
import carboniferous.client.model.ModelGrinder;
import carboniferous.core.helper.GuiHelper;
import carboniferous.lib.ResourceReference;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ItemGrinderRenderer implements IItemRenderer {

    private ModelGrinder modelGrinder;

    public ItemGrinderRenderer() {
        modelGrinder = new ModelGrinder();
    }

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        return true;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return true;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {

        switch (type) {
            case ENTITY: {
                renderGrinder(0.0F, 1.0F, 0.0F);
                break;
            }
            case EQUIPPED: {
                renderGrinder(0.5F, 1.5F, 0.5F);
                break;
            }
            case INVENTORY: {
                renderGrinder(0.0F, 1.0F, 0.0F);
                break;
            }
            default:
                break;
        }
    }

    private void renderGrinder(float x, float y, float z) {
    	GuiHelper.bindTexture(ResourceReference.blockGrinder);
        GL11.glPushMatrix(); //start
        GL11.glTranslatef(x, y, z); //size
        GL11.glRotatef(180, 1, 0, 0);
        GL11.glRotatef(-90, 0, 1, 0);
        modelGrinder.render();
        GL11.glPopMatrix(); //end
    }
}
