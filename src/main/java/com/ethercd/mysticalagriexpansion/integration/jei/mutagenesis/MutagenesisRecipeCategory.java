package com.ethercd.mysticalagriexpansion.integration.jei.mutagenesis;

import com.ethercd.mysticalagriexpansion.MysticalAgriexpansion;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;

import static com.ethercd.mysticalagriexpansion.integration.jei.RecipeCategories.MUTAGENESIS;

public class MutagenesisRecipeCategory extends AbstractMutagenesisRecipeCategory<MutagenesisRecipe> {
    private final IDrawable background;
    private final String name;

    public MutagenesisRecipeCategory(IGuiHelper helper) {
        super(helper);
        background = helper.createDrawable(TEXTURES, 30, 25, 114, 51);
        name = "Mutagenesis Processor";
    }

    @Override
    public IDrawable getBackground() {
        return background;
    }

    @Override
    public void drawExtras(Minecraft minecraft) {
        animatedArrow.draw(minecraft, 46, 17);
    }

    @Override
    public void setRecipe(IRecipeLayout recipeLayout, MutagenesisRecipe recipeWrapper, IIngredients ingredients) {
        IGuiItemStackGroup stacks = recipeLayout.getItemStacks();
        stacks.init(input1, true, 2, 17);
        stacks.init(input2, true, 26, 17);
        stacks.init(output1, false, 84, 6);
        stacks.init(output2, false, 72, 33);
        stacks.init(output3, false, 96, 33);
    }

    @Override
    public String getTitle() {
        return name;
    }

    @Override
    public String getModName() {
        return MysticalAgriexpansion.NAME;
    }

    @Override
    public String getUid() {
        return MUTAGENESIS;
    }
}
