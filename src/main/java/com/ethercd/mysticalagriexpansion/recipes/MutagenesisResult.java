package com.ethercd.mysticalagriexpansion.recipes;

import net.minecraft.item.ItemStack;

public class MutagenesisResult {
    private ItemStack item;
    private int id;

    public MutagenesisResult(ItemStack item, int id) {
        this.item = item;
        this.id = id;
    }

    public boolean isCompare(MutagenesisResult input) {
        return this.id == input.id;
    }

    public ItemStack getItem() {
        return item;
    }

    public int getId() {
        return id;
    }
}
