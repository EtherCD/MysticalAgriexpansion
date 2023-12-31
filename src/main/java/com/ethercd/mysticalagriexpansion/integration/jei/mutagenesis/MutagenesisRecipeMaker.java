package com.ethercd.mysticalagriexpansion.integration.jei.mutagenesis;

import com.ethercd.mysticalagriexpansion.recipes.MutagenesisRecipesManager;
import com.ethercd.mysticalagriexpansion.recipes.MutagenesisResult;
import com.google.common.collect.Lists;
import com.google.common.collect.Table;
import net.minecraft.item.ItemStack;

import java.util.List;
import java.util.Map;

public class MutagenesisRecipeMaker {
    public static List<MutagenesisRecipe> getRecipes() {
        Table<ItemStack, ItemStack, MutagenesisResult> recipes = MutagenesisRecipesManager.getRecipesList();
        List<MutagenesisRecipe> jeiRecipes = Lists.newArrayList();

        for (Map.Entry<ItemStack, Map<ItemStack, MutagenesisResult>> entry : recipes.columnMap().entrySet()) {
            for (Map.Entry<ItemStack, MutagenesisResult> ent : entry.getValue().entrySet()) {
                ItemStack input1 = entry.getKey();
                ItemStack input2 = ent.getKey();
                MutagenesisResult output = ent.getValue();
                List<ItemStack> inputs = Lists.newArrayList(input1, input2);
                MutagenesisRecipe recipe = new MutagenesisRecipe(inputs, output);
                jeiRecipes.add(recipe);
            }
        }

        return jeiRecipes;
    }
}
