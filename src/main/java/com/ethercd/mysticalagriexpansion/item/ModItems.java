package com.ethercd.mysticalagriexpansion.item;

import com.blakebr0.cucumber.registry.ModRegistry;
import com.ethercd.mysticalagriexpansion.Mod;
import com.ethercd.mysticalagriexpansion.lib.ModChecker;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

import com.ethercd.mysticalagriexpansion.utils.RegisteredObject;

public class ModItems {
    public static final List<RegisteredObject<Item>> ITEMS = new ArrayList<>();

    public static final ItemWateringCan itemInstaiumWateringCan = new ItemWateringCan("insanium", 13, 6, 0.5f, ModChecker.INSANIUM);

    public static void add(Item item, String name) {
        ITEMS.add(new RegisteredObject<>(item, name));
    }

    public static void init() {
        ModRegistry registry = Mod.REGISTRY;

        for (RegisteredObject<Item> elem : ITEMS) {
            registry.register(elem.getObject(), elem.getName());
        }
    }
}
