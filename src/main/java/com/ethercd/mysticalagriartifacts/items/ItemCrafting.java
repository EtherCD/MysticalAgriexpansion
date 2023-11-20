package com.ethercd.mysticalagriartifacts.items;

import com.blakebr0.cucumber.registry.ModRegistry;
import com.ethercd.mysticalagriartifacts.lib.ModChecker;

public class ItemCrafting {
    public static final ItemBase itemInsaniumTheoreticalWater = new ItemBase("crafting_insanium_theoretical_water");
    public static final ItemBase itemInsaniumFertCore = new ItemBase("crafting_insanium_fert_core");

    public static void init(ModRegistry registry) {
        if (ModChecker.INSANIUM) {
            registry.register(itemInsaniumTheoreticalWater, itemInsaniumTheoreticalWater    .getName());
            registry.register(itemInsaniumFertCore, itemInsaniumFertCore.getName());
        }
    }
}
