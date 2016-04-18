package carboniferous.core.addons.nei;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.lwjgl.opengl.GL11;

import carboniferous.client.gui.inventory.GuiGrinder;
import carboniferous.core.helper.GuiHelper;
import carboniferous.lib.ResourceReference;
import carboniferous.recipe.CarboniferousRecipes;
import carboniferous.recipe.GrinderManager;
import carboniferous.recipe.GrinderRecipe;
import carboniferous.recipe.IGrinderRecipe;
import codechicken.nei.PositionedStack;
import codechicken.nei.forge.GuiContainerManager;
import codechicken.nei.recipe.TemplateRecipeHandler;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.ItemStack;

/**
 * @author ProPercivalalb
 **/
public class GrinderRecipeHandler extends TemplateRecipeHandler {

	private int grindTime;
	
	@Override
	public Class<? extends GuiContainer> getGuiClass() {return GuiGrinder.class;}
	@Override
	public String getOverlayIdentifier() {return "carboniferous.grinder";}
	@Override
	public String getRecipeName() {return "Grinder";}

	@Override
	public void drawBackground(GuiContainerManager guimanager, int i) {
		GuiHelper.glColourDefault();
	    GuiHelper.bindTexture(ResourceReference.guiGrinder);
	    GuiHelper.drawTexturedModalRect(0, 0, 5, 10, 166, 63);
	    int xOff = 5;
		int yOff = 10;
		
		//Progress Bar
        GuiHelper.drawProgressBar(92 - xOff, 17 - yOff, 176, 14, 17, 25, this.getGrindProgressScaled(25), 1);
        //Cog
        GuiHelper.bindTexture(ResourceReference.guiGrinderCog);
        //if (grinder.grindTime > 0) {
        //	grinder.rotation += 0.3F;
        //}
        GuiHelper.glColourDefault();
        GL11.glMatrixMode(GL11.GL_TEXTURE /*5890*/);
        GL11.glPushMatrix();
        GL11.glLoadIdentity();
        GL11.glTranslatef(0.25F, 0.2480469F, 0.0F);
        GL11.glRotatef(0.0F, 0.0F, 0.0F, 1.0F);
        GL11.glTranslatef(-0.25F, -0.2480469F, 0.0F);
        guimanager.drawTexturedModalRect(-20 - xOff, -20 - yOff, 0, 0, 128, 127);
        GL11.glPopMatrix();
        GL11.glMatrixMode(GL11.GL_MODELVIEW /*5888*/);
        
        //Slots above Cog
        GuiHelper.glColourDefault();
        GuiHelper.bindTexture(ResourceReference.guiGrinder);
        guimanager.drawTexturedModalRect(23 - xOff, 45 - yOff, 81, 166, 18, 18);//Input 1
        guimanager.drawTexturedModalRect(47 - xOff, 45 - yOff, 81, 166, 18, 18);//Input 2
        guimanager.drawTexturedModalRect(35 - xOff, 23 - yOff, 81, 166, 18, 18);//Grinder Stone
        guimanager.drawTexturedModalRect(31 - xOff, 18 - yOff, 99, 166, 26, 4);//Grinder Stone Progress Bar
        GuiHelper.drawProgressBar(27, 8, 176, 38, 24, 4, getGrindingStoneDamageScaled(24), 2);
        GuiHelper.drawProgressBar(135, 11, 176, 0, 24, 14, getBurnTimeRemainingScaled(14), 3);
	}
	
	@Override
	public void drawExtras(GuiContainerManager guimanager, int i) {
		
	}

	public int getGrindProgressScaled(int i) {
		return (this.grindTime % 25) * i / 25;
	}
	
	public int getGrindingStoneDamageScaled(int i) {
		return (this.grindTime % 12) * i / 12;
	}
	
	public int getBurnTimeRemainingScaled(int i) {
		return (this.grindTime % 14) * i / 14;
	}
	
	@Override
	public void onUpdate() {
	    super.onUpdate();
	    ++this.grindTime;
	}

	@Override
	public void loadTransferRects() {
		this.transferRects.add(new TemplateRecipeHandler.RecipeTransferRect(new Rectangle(88, 6, 17, 25), "carboniferous.grinder"));
	}

	@Override
    public void loadCraftingRecipes(String outputId, Object... results) {
        if(outputId.equals("carboniferous.grinder") && getClass() == GrinderRecipeHandler.class) {
            List<IGrinderRecipe> allrecipes = GrinderManager.getRecipeList();
            for(IGrinderRecipe irecipe : allrecipes) {
                CachedIORecipe recipe = null;
                if(irecipe instanceof GrinderRecipe) {
                    recipe = new CachedIORecipe((GrinderRecipe)irecipe);
                }

                if(recipe == null)
                    continue;
                
                arecipes.add(recipe);
            }
        }
        else {
            super.loadCraftingRecipes(outputId, results);
        }
    }
    
    @Override
    public void loadCraftingRecipes(ItemStack result) {
        List<IGrinderRecipe> allrecipes = GrinderManager.getRecipeList();
        for(IGrinderRecipe irecipe : allrecipes) {
            //if(NEIClientUtils.areStacksSameTypeCrafting(irecipe.getRecipeOutput(), result)) {
                CachedIORecipe recipe = null;
                if(irecipe instanceof GrinderRecipe) {
                    recipe = new CachedIORecipe((GrinderRecipe)irecipe);
                }
                
                if(recipe == null)
                    continue;
                
                arecipes.add(recipe);
           // }
        }
    }
    
    @Override
    public void loadUsageRecipes(ItemStack ingredient) {
        List<IGrinderRecipe> allrecipes = GrinderManager.getRecipeList();
        for(IGrinderRecipe irecipe : allrecipes)
        {
            CachedIORecipe recipe = null;
            if(irecipe instanceof GrinderRecipe) {
                recipe = new CachedIORecipe((GrinderRecipe)irecipe);
            }

            if(recipe == null)
                continue;
            
            if(recipe.contains(recipe.ingredients, ingredient)) {
                recipe.setIngredientPermutation(recipe.ingredients, ingredient);
                arecipes.add(recipe);
            }
        }
    }

	public class CachedIORecipe extends TemplateRecipeHandler.CachedRecipe {
		
		private CachedIORecipe() {
            ingredients = new ArrayList<PositionedStack>();
            grindingStones = new ArrayList<PositionedStack>();
            getGrindingStones();
        }
        

		private CachedIORecipe(ItemStack output) {
            this();
            setResult(output);
        }

        public CachedIORecipe(GrinderRecipe recipe) {
            this(recipe.getRecipeOutput());
            setIngredients(recipe.getRecipeInput());
        }
        
        private void setIngredients(Object[] items) {
            ingredients.clear();
            if(items[0] != null) {
            	PositionedStack stack1 = new PositionedStack(items[0], 19, 36);
            	ingredients.add(stack1);
            }
            if(items[1] != null) {
                PositionedStack stack2 = new PositionedStack(items[1], 43, 36);
                ingredients.add(stack2);	
            }
        }
        
        public void getGrindingStones() {
        	Iterator component = CarboniferousRecipes.getAllGrinderComponents();
            while (component.hasNext()) {
              Map.Entry entry = (Map.Entry)component.next();
              ItemStack stack = ((ItemStack)entry.getKey()).copy();
              this.grindingStones.add(new PositionedStack(stack, 31, 14));
            }
        }
        
        public void setResult(ItemStack output) {
            result = new PositionedStack(output, 88, 40);
        }    
        
        @Override
        public ArrayList<PositionedStack> getIngredients() {
            return null;//getCycledIngredients(cycleticks / 20, ingredients);
        }
        
        @Override
        public ArrayList<PositionedStack> getOtherStacks() {
            ArrayList<PositionedStack> stacks = new ArrayList<PositionedStack>();
            if(grindingStones != null) {
            	stacks.add(this.grindingStones.get(cycleticks / 48 % this.grindingStones.size()));
            }
            //PositionedStack stack = FurnaceRecipeHandler.afuels.get((cycleticks/48) % FurnaceRecipeHandler.afuels.size()).stack.copy();
            //stack.relx = 135;
        	//stack.rely = 28;
            //stacks.add(stack);
            return stacks;
        }
        
        @Override
        public PositionedStack getResult() {
            return result;
        }
        
        public ArrayList<PositionedStack> ingredients, grindingStones;
        public PositionedStack result;
	}
}
