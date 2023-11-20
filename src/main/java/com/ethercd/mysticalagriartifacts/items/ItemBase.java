package com.ethercd.mysticalagriartifacts.items;

import com.ethercd.mysticalagriartifacts.MysticalAgrArtifacts;
import com.ethercd.mysticalagriartifacts.utils.IHasModel;
import net.minecraft.item.Item;

public class ItemBase extends Item  implements IHasModel {
    private String name;

    public ItemBase(String name) {
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(MysticalAgrArtifacts.CREATIVE_TAB);
        this.name = name;
        ModItems.ITEM_MODEL_REGISTER.add(this);
    }

    public String getName() {
        return this.name;
    }
}
