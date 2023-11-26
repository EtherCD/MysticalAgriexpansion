package com.ethercd.mysticalagriexpansion.item;

import com.blakebr0.cucumber.registry.ModRegistry;
import com.ethercd.mysticalagriexpansion.Mod;
import com.ethercd.mysticalagriexpansion.crop.ModCommonCrop;
import com.ethercd.mysticalagriexpansion.lib.ModChecker;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains and initializes all items from this mod
 */
public class ModItems {
    public static final List<Item> ITEM_MODEL_REGISTER = new ArrayList<>();

    public static final ModItem INSANIUM_WATERING_CAN = new ItemWateringCan("insanium", 13, 6, 0.5f);

    public static void init() {
        final ModRegistry registry = Mod.REGISTRY;

        if (ModChecker.INSANIUM) registry.register(INSANIUM_WATERING_CAN, INSANIUM_WATERING_CAN.getName());

        ItemCrafting.init(registry);

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
