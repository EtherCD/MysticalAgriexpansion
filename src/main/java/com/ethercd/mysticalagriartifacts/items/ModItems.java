package com.ethercd.mysticalagriartifacts.items;

import com.blakebr0.cucumber.registry.ModRegistry;
import com.ethercd.mysticalagriartifacts.MysticalAgrArtifacts;
import com.ethercd.mysticalagriartifacts.crops.ModCommonCrop;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains and initializes all items from this mod
 */
public class ModItems {
    public static final List<Item> ITEM_MODEL_REGISTER = new ArrayList<>();

//    public static final Item nuclearCraftingSeeds = new ItemBase("nuclear_crafting_seeds");
//    public static final Item nuclearInferiumEssence = new ItemBase("nuclear_inferium_essence");
//    public static final Item nuclearPrudentiumEssence = new ItemBase("nuclear_prudentium_essence");
//    public static final Item nuclearIntermediumEssence = new ItemBase("nuclear_intermedium_essence");
//    public static final Item nuclearSuperiumEssence = new ItemBase("nuclear_superium_essence");
//    public static final Item nuclearSupremiumEssence = new ItemBase("nuclear_supremium_essence");
//    public static final Item alloyCraftingSeeds = new ItemBase("alloy_crafting_seeds");
//    public static final Item alloyInferiumEssence = new ItemBase("alloy_inferium_essence");
//    public static final Item alloyPrudentiumEssence = new ItemBase("alloyr_prudentium_essence");
//    public static final Item alloyIntermediumEssence = new ItemBase("alloy_intermedium_essence");
//    public static final Item alloySuperiumEssence = new ItemBase("alloy_superium_essence");
//    public static final Item alloySupremiumEssence = new ItemBase("nalloy_supremium_essence");
//    public static final Item electronicCraftingSeeds = new ItemBase("electronic_crafting_seeds");
//    public static final Item electronicInferiumEssence = new ItemBase("electronic_inferium_essence");
//    public static final Item electronicPrudentiumEssence = new ItemBase("electronic_prudentium_essence");
//    public static final Item electronicIntermediumEssence = new ItemBase("electronic_intermedium_essence");
//    public static final Item electronicSuperiumEssence = new ItemBase("electronic_superium_essence");
//    public static final Item electronicSupremiumEssence = new ItemBase("electronic_supremium_essence");

    public static void init() {
        final ModRegistry registry = MysticalAgrArtifacts.REGISTRY;

        for (ModCommonCrop type : ModCommonCrop.values()) {
            if (type.isEnabled()) {
                registry.register(type.getCrop(), type.getName() + "_essence");
            }
        }
        for (ModCommonCrop type : ModCommonCrop.values()) {
            if (type.isEnabled()) {
                registry.register(type.getSeed(), type.getName() + "_seeds");
            }
        }
    }
}
