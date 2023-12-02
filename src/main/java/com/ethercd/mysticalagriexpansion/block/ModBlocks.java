package com.ethercd.mysticalagriexpansion.block;

import com.blakebr0.cucumber.registry.ModRegistry;
import com.ethercd.mysticalagriexpansion.MysticalAgriexpansion;
import com.ethercd.mysticalagriexpansion.utils.RegisteredObject;
import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {
    public static final List<RegisteredObject<Block>> BLOCKS = new ArrayList<>();

    public static void add(Block item, String name) {
        BLOCKS.add(new RegisteredObject<>(item, name));
    }

    public static void register() {
        ModRegistry registry = MysticalAgriexpansion.REGISTRY;

        BlockGrowthAccelerator.init();

        for (RegisteredObject<Block> elem : BLOCKS) {
            registry.register(elem.getObject(), elem.getName(), true);
        }
    }
}
