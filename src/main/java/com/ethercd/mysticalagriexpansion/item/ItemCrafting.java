package com.ethercd.mysticalagriexpansion.item;

import com.blakebr0.cucumber.registry.ModRegistry;
import com.ethercd.mysticalagriexpansion.lib.ModChecker;
import net.minecraftforge.oredict.OreDictionary;

public enum ItemCrafting {
    INSANIUM_THEORETICAL_WATER("insanium_theoretical_water", "", ModChecker.INSANIUM),
    INSANIUM_FERT_CORE("insanium_fert_core", "", ModChecker.INSANIUM),
    EXEMPLARY_GEAR("exemplary_gear", "gearExemplary", true),

    ELECTRONIC_SEEDS("electronic_seeds", "seedsElectronic", true),
    NUCLEAR_SEEDS("nuclear_seeds", "seedsNuclear", true),
    ALLOY_SEEDS("alloy_seeds", "seedsAlloy", true),

    TIER_1_ELECTRONIC_SEEDS("tier_1_electronic_seeds", "", true),
    TIER_1_NUCLEAR_SEEDS("tier_1_nuclear_seeds", "", true),
    TIER_1_ALLOY_SEEDS("tier_1_alloy_seeds", "", true),
    TIER_2_ELECTRONIC_SEEDS("tier_2_electronic_seeds", "", true),
    TIER_2_NUCLEAR_SEEDS("tier_2_nuclear_seeds", "", true),
    TIER_2_ALLOY_SEEDS("tier_2_alloy_seeds", "", true),
    TIER_3_ELECTRONIC_SEEDS("tier_3_electronic_seeds", "", true),
    TIER_3_NUCLEAR_SEEDS("tier_3_nuclear_seeds", "", true),
    TIER_3_ALLOY_SEEDS("tier_3_alloy_seeds", "", true),
    TIER_4_ELECTRONIC_SEEDS("tier_4_electronic_seeds", "", true),
    TIER_4_NUCLEAR_SEEDS("tier_4_nuclear_seeds", "", true),
    TIER_4_ALLOY_SEEDS("tier_4_alloy_seeds", "", true),
    TIER_5_ELECTRONIC_SEEDS("tier_5_electronic_seeds", "", true),
    TIER_5_NUCLEAR_SEEDS("tier_5_nuclear_seeds", "", true),
    TIER_5_ALLOY_SEEDS("tier_5_alloy_seeds", "", true),
    TIER_6_ELECTRONIC_SEEDS("tier_6_electronic_seeds", "", ModChecker.INSANIUM),
    TIER_6_NUCLEAR_SEEDS("tier_6_nuclear_seeds", "", ModChecker.INSANIUM),
    TIER_6_ALLOY_SEEDS("tier_6_alloy_seeds", "", ModChecker.INSANIUM),
    ;

    private ModItem item;
    private String name;
    private Boolean active;

    ItemCrafting(String name, String ore, Boolean active) {
        this.item = new ModItem(name);
        this.name = name;
        if (ore != "")
            OreDictionary.registerOre(name, item);
        this.active = active;
    }

    public void register(ModRegistry registry) {
        if (this.active)
            registry.register(this.item, this.name);
    }

    public ModItem getItem() {
        return this.item;
    }

    public static void init(ModRegistry registry) {
        for (ItemCrafting item : ItemCrafting.values()) {
            item.register(registry);
        }
    }
}
