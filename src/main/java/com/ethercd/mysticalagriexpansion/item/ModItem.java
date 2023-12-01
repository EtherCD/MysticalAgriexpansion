package com.ethercd.mysticalagriexpansion.item;

import com.ethercd.mysticalagriexpansion.Mod;
import net.minecraft.item.Item;

public class ModItem extends Item {
    private String name;

    public ModItem(String name, boolean active) {
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(Mod.CREATIVE_TAB);
        this.name = name;
        if (active)
            ModItems.add(this, name);
    }

    public String getName() {
        return this.name;
    }
}
