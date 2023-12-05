package com.ethercd.mysticalagriexpansion.recipes;

import com.blakebr0.cucumber.helper.StackHelper;
import com.ethercd.mysticalagriexpansion.item.ItemCrafting;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.Map;
import java.util.Random;

public class MutagenesisRecipesManager {
    private static final Table<ItemStack, ItemStack, ItemStack> recipesList = HashBasedTable.create();
    private static final Map<ItemStack, Integer> chanceList = Maps.newHashMap();
    private static final Random random = new Random();

    public static void addRecipe(Item input1, Item input2, Item output, int chance) {
        ItemStack input1Stack = new ItemStack(input1, 1);
        ItemStack input2Stack = new ItemStack(input2, 1);
        ItemStack outputStack = new ItemStack(output, 1);
        if (getResult(input1Stack, input2Stack) != ItemStack.EMPTY) return;
        recipesList.put(input1Stack, input2Stack, outputStack);
        chanceList.put(outputStack, chance);
    }

    public static void addRecipe(ItemStack input1, ItemStack input2, ItemStack output, int chance) {
        if (getResult(input1, input2) != ItemStack.EMPTY) return;
        recipesList.put(input1, input2, output);
        chanceList.put(output, chance);
    }

    public static ItemStack getResult(ItemStack input1, ItemStack input2) {
        for (Map.Entry<ItemStack, Map<ItemStack, ItemStack>> entry : recipesList.columnMap().entrySet()) {
            if (StackHelper.canCombineStacks(input1, entry.getKey()))
                for (Map.Entry<ItemStack, ItemStack> ent : entry.getValue().entrySet())
                    if (StackHelper.canCombineStacks(input2, ent.getKey()))
                        return ent.getValue();
            if (StackHelper.canCombineStacks(input2, entry.getKey()))
                for (Map.Entry<ItemStack, ItemStack> ent : entry.getValue().entrySet())
                    if (StackHelper.canCombineStacks(input1, ent.getKey()))
                        return ent.getValue();
        }

        return ItemStack.EMPTY;
    }

    public static boolean getMutagenesisSuccess(ItemStack stack) {
        for (Map.Entry<ItemStack, Integer> entry : chanceList.entrySet()) {
            if (StackHelper.canCombineStacks(stack, entry.getKey()))
                return random.nextInt(100) > 100 - entry.getValue();
        }
        return false;
    }

    public static int getChance(ItemStack stack) {
        for (Map.Entry<ItemStack, Integer> entry : chanceList.entrySet()) {
            if (StackHelper.canCombineStacks(stack, entry.getKey()))
                return entry.getValue();
        }
        return 0;
    }

    public static Table<ItemStack, ItemStack, ItemStack> getRecipesList() {
        return recipesList;
    }
}
