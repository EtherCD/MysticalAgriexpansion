package com.ethercd.mysticalagriexpansion.item;

import com.ethercd.mysticalagriexpansion.MACreativeTabs;
import net.minecraft.item.Item;

@SuppressWarnings({"unused"})
public class ModItem extends Item {
    private final String name;

    public ModItem(String name) {
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(MACreativeTabs.CREATIVE_TAB);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
