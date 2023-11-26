package com.ethercd.mysticalagriexpansion.item;

import com.ethercd.mysticalagriexpansion.Mod;
import com.ethercd.mysticalagriexpansion.util.IHasModel;
import net.minecraft.item.Item;

public class ModItem extends Item  implements IHasModel {
    private String name;

    public ModItem(String name) {
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(Mod.CREATIVE_TAB);
        this.name = name;
        ModItems.ITEM_MODEL_REGISTER.add(this);
    }

    public String getName() {
        return this.name;
    }
}
