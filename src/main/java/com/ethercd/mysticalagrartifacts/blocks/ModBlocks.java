package com.ethercd.mysticalagrartifacts.blocks;

import com.blakebr0.cucumber.registry.ModRegistry;
import com.ethercd.mysticalagrartifacts.MysticalAgrArtifacts;
import com.ethercd.mysticalagrartifacts.crops.ModCommonCrop;

public class ModBlocks {
    public static void init() {
        final ModRegistry registry = MysticalAgrArtifacts.REGISTRY;

        for (ModCommonCrop type : ModCommonCrop.values()) {
            if (type.isEnabled()) {
                registry.register(type.getPlant(), type.getName() + "_crop");
            }
        }
    }
}
