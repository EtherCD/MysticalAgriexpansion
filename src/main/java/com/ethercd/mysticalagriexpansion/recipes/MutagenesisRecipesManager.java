package com.ethercd.mysticalagriexpansion.recipes;

import com.blakebr0.cucumber.helper.StackHelper;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.Map;
import java.util.Random;

/**
 * Mutagenesis mechanism recipe manager
 */
@SuppressWarnings({"unused"})
public class MutagenesisRecipesManager {
    private static final Table<ItemStack, ItemStack, MutagenesisResult> recipesList = HashBasedTable.create();
    private static final Map<MutagenesisResult, Integer> chanceList = Maps.newHashMap();
    private static final Random random = new Random();
    private static int lastRecipeIndex = 1;

    /**
     * Adds recipe to Mutagenesis Processor.
     * @param input1 Input first seeds
     * @param input2 Input second seeds
     * @param output Output seeds
     * @param chance Chance of successful mutation
     */
    public static void addRecipe(Item input1, Item input2, Item output, int chance) {
        ItemStack input1Stack = new ItemStack(input1, 1);
        ItemStack input2Stack = new ItemStack(input2, 1);
        ItemStack outputStack = new ItemStack(output, 1);
        if (getResult(input1Stack, input2Stack).getItem() != ItemStack.EMPTY) return;
        MutagenesisResult recipeResult = new MutagenesisResult(outputStack, lastRecipeIndex);
        lastRecipeIndex++;
        recipesList.put(input1Stack, input2Stack, recipeResult);
        chanceList.put(recipeResult, chance);
    }

    /**
     * Adds recipe to Mutagenesis Processor.
     * WARNING: ItemStacks of output with meta is not working.
     * If you need add ItemStack with meta.
     * Just get item from ItemStack, and make a new ItemStack from this item.
     * @param input1 Input first seeds
     * @param input2 Input second seeds
     * @param output Output seeds
     * @param chance Chance of successful mutation
     */
    public static void addRecipe(ItemStack input1, ItemStack input2, ItemStack output, int chance) {
        if (getResult(input1, input2).getItem() != ItemStack.EMPTY) return;
        recipesList.put(input1, input2, new MutagenesisResult(output, lastRecipeIndex));
        chanceList.put(new MutagenesisResult(output, lastRecipeIndex), chance);
        lastRecipeIndex++;
    }

    /**
     * Returns result from recipe
     * @param input1 Recipe input first slot
     * @param input2 Recipe inputs second slot
     * @return Result or ItemStack.EMPTY
     */
    public static MutagenesisResult getResult(ItemStack input1, ItemStack input2) {
        input1 = input1.copy(); input1.copy();
        input2 = input2.copy(); input2.copy();

        for (Map.Entry<ItemStack, Map<ItemStack, MutagenesisResult>> entry : recipesList.columnMap().entrySet()) {
            if (input1.isItemEqual(entry.getKey()))
                for (Map.Entry<ItemStack, MutagenesisResult> ent : entry.getValue().entrySet())
                    if (input2.isItemEqual(ent.getKey()))
                        return ent.getValue();
            if (input2.isItemEqual(entry.getKey()))
                for (Map.Entry<ItemStack, MutagenesisResult> ent : entry.getValue().entrySet())
                    if (input1.isItemEqual(ent.getKey()))
                        return ent.getValue();
        }

        return new MutagenesisResult(ItemStack.EMPTY, 99);
    }

    /**
     * Getting ItemStack without meta
     * @param stack Stack
     * @return Result
     */
    public static ItemStack getStackWithoutMeta(ItemStack stack) {
        return new ItemStack(stack.getItem(), stack.getCount(), 0);
    }

    /**
     * Randomizes mutation success
     * @param result Result of recipe stack
     * @return Successful or not mutation
     */
    public static boolean getMutagenesisSuccess(MutagenesisResult result, float chanceMultiplier) {
        for (Map.Entry<MutagenesisResult, Integer> entry : chanceList.entrySet()) {
            if (entry.getKey().isCompare(result))
                return random.nextInt(100) < 100 - Math.round(entry.getValue() * chanceMultiplier);
        }
        return false;
    }

    /**
     * Only for JEI Compat
     * @param stack Recipe result stack
     * @return Int chance of mutation
     */
    public static int getChance(ItemStack stack) {
        for (Map.Entry<MutagenesisResult, Integer> entry : chanceList.entrySet()) {
            if (StackHelper.canCombineStacks(stack, entry.getKey().getItem()))
                return entry.getValue();
        }
        return 0;
    }

    /**
     * Only for JEI Compat
     * @return All recipes
     */
    public static Table<ItemStack, ItemStack, MutagenesisResult> getRecipesList() {
        return recipesList;
    }
}
