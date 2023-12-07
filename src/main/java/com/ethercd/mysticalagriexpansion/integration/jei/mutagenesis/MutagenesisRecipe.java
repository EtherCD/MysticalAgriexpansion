package com.ethercd.mysticalagriexpansion.integration.jei.mutagenesis;

import com.ethercd.mysticalagriexpansion.integration.jei.JEICompat;
import com.ethercd.mysticalagriexpansion.recipes.MutagenesisRecipesManager;
import com.google.common.collect.Lists;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.item.ItemStack;

import java.awt.*;
import java.util.List;

@SuppressWarnings("NullableProblems")
public class MutagenesisRecipe implements IRecipeWrapper {
    private final List<ItemStack> inputs;
    private final List<ItemStack> outputs;

    public MutagenesisRecipe(List<ItemStack> inputs, ItemStack output) {
        this.inputs = inputs;
        this.outputs = Lists.newArrayList(output, inputs.get(0), inputs.get(1));
    }

    @Override
    public void getIngredients(IIngredients ingredients) {
        ingredients.setInputs(ItemStack.class, inputs);
        ingredients.setOutputs(ItemStack.class, outputs);
    }

    @Override
    public void drawInfo(Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY) {
        int chance = MutagenesisRecipesManager.getChance(outputs.get(0));

        if (chance > 0) {
            String chanceString = JEICompat.translateToLocalFormatted("gui.jei.category.mutagenesis.chance", chance);
            FontRenderer renderer = minecraft.fontRenderer;
            renderer.drawString(chanceString, 1, 1, Color.GRAY.getRGB());
        }
    }
}
