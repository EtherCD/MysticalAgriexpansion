package com.ethercd.mysticalagrartifacts.lib;

import com.blakebr0.mysticalagriculture.items.ItemCrafting;
import com.blakebr0.mysticalagriculture.lib.Parts;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;


/**
 * This class contains all resources from other mods
 */
public class ModParts {
    public static Item itemProsperityShard;

    public static void init() {
        itemProsperityShard = ItemCrafting.itemProsperityShard.getItem();
    }
}
