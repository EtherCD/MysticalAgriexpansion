package com.ethercd.mysticalagrartifacts.items;

import com.blakebr0.cucumber.registry.ModRegistry;
import com.ethercd.mysticalagrartifacts.MysticalAgrArtifacts;
import com.ethercd.mysticalagrartifacts.crops.ModCommonCrop;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains and initializes all items from this mod
 */
public class ModItems {
    public static final List<Item> ITEM_MODEL_REGISTER = new ArrayList<>();

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
