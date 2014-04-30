package codechicken.nei.recipe;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;

import codechicken.nei.PositionedStack;
import codechicken.nei.forge.GuiContainerManager;

/**
 * Dummy Class to stop there being errors in the eclispe
 * workspace and so I can recompile the mod.
 * @author ProPercivalalb
 */
@Deprecated
public class TemplateRecipeHandler {

	public class CachedRecipe {

		public int cycleticks;
		
		public PositionedStack getOtherStack() {
			return null;
		}

		public ArrayList<PositionedStack> getIngredients() {
			// TODO Auto-generated method stub
			return null;
		}

		public ArrayList<PositionedStack> getOtherStacks() {
			// TODO Auto-generated method stub
			return null;
		}

		public PositionedStack getResult() {
			// TODO Auto-generated method stub
			return null;
		}
		
        public void setIngredientPermutation(
				ArrayList<PositionedStack> ingredients2, ItemStack ingredient) {
			// TODO Auto-generated method stub
			
		}

    	public boolean contains(ArrayList<PositionedStack> ingredients2,
				ItemStack ingredient) {
			// TODO Auto-generated method stub
			return false;
		}
	}

	public class RecipeTransferRect {
		public RecipeTransferRect(Rectangle rectangle, String recipeId,Object[] objects) {}

		public RecipeTransferRect(Rectangle rectangle, String string) {}
	}

	public List transferRects = new ArrayList();
	public List arecipes = new ArrayList();
	
	public Class getGuiClass() {return null;}
	
	public String getOverlayIdentifier() {return "";}
	
	public String getRecipeName() {return "";}
	
	public String getGuiTexture() {return "";}
	
	public void drawBackground(GuiContainerManager guimanager, int i) {}
	
	public void drawExtras(GuiContainerManager guimanager, int i) {}
	
	public void drawProgressBar(GuiContainerManager gui, int x, int y, int tx, int ty, int w, int h, int completion, int direction) {}
	
	public void onUpdate() {}

	public void loadTransferRects() {}

	public void loadCraftingRecipes(String outputId, Object... results) {}
	
	public void loadCraftingRecipes(ItemStack result) {}
	
	public void loadUsageRecipes(ItemStack ingredient) {}
	
	
}
