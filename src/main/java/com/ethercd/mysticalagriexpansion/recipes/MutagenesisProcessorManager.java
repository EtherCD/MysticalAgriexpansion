package com.ethercd.mysticalagriexpansion.recipes;

import net.minecraft.item.ItemStack;

import java.util.ArrayList;

public class MutagenesisProcessorManager {
    private static ArrayList<MutagenesisProcessorRecipe> recipes = new ArrayList<>();

    public static void addRecipe(ItemStack input1, ItemStack input2, ItemStack result, int chance) {
        recipes.add(new MutagenesisProcessorRecipe(input1, input2, result, chance));
    }

    public static ItemStack processRecipe(ItemStack input1, ItemStack input2) {
        if (input1 == null || input2 == null)
            return null;

        for (MutagenesisProcessorRecipe recipe : recipes)
            if (recipe.validInput(input1, input2))
                return recipe.getResult(input2);
        return null;
    }

    public static boolean validRecipe(ItemStack input1, ItemStack input2){
        for(MutagenesisProcessorRecipe recipe : recipes){
            if(recipe.validInput(input1, input2))
                return true;
        }
        return false;
    }
}
