package com.ethercd.mysticalagriexpansion.recipes;

import net.minecraft.item.ItemStack;

import java.util.Random;

public class MutagenesisProcessorRecipe {
    private ItemStack output;
    private ItemStack input1;
    private ItemStack input2;
    private Random random;
    private int chance;

    public MutagenesisProcessorRecipe(ItemStack input1, ItemStack input2, ItemStack output, int chance) {
        this.input1 = input1;
        this.input2 = input2;
        this.output = output;
        this.random = new Random();
        this.random.nextInt(100);
        this.chance = chance;
    }

    public ItemStack getResult(ItemStack stack2) {
        int chance = this.random.nextInt(100);
        if (chance < 100 - this.chance) {
            return this.input1;
        }
        return this.output;
    }

    public boolean validInput(ItemStack input1, ItemStack input2) {
        return (this.input1.isItemEqual(input1) && this.input2.isItemEqual(input2)) || (this.input2.isItemEqual(input1) && this.input1.isItemEqual(input2));
    }
}
