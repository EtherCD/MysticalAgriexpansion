package com.ethercd.mysticalagriexpansion.recipes;

import net.minecraft.item.ItemStack;

import java.util.Random;

public class MutagenesisResult {
    private ItemStack item;
    private int chance;
    private Random random;

    public MutagenesisResult(ItemStack item, int chance) {
        this.item = item;
        this.chance = chance;
        this.random = new Random();
    }

    public boolean getSuccess(float chanceMultiplier) {
        return this.random.nextInt(100) < 100 - Math.round(this.chance * chanceMultiplier);
    }

    public int getChance() {
        return this.chance;
    }

    public ItemStack getItem() {
        return item;
    }

}
