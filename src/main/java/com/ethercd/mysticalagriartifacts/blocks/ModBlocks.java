package com.ethercd.mysticalagriartifacts.blocks;

import com.blakebr0.cucumber.registry.ModRegistry;
import com.ethercd.mysticalagriartifacts.MysticalAgrArtifacts;
import com.ethercd.mysticalagriartifacts.crops.ModCommonCrop;
import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {
    public static final List<Block> BLOCKS_MODEL_REGISTER = new ArrayList<>();

    public static void init() {
        final ModRegistry registry = MysticalAgrArtifacts.REGISTRY;

        BlockGrowthAccelerator.init(registry);

        for (ModCommonCrop type : ModCommonCrop.values()) {
            if (type.isEnabled()) {
                registry.register(type.getPlant(), type.getName() + "_crop");
            }
        }
    }
}
