package com.ethercd.mysticalagrartifacts.items;

import com.ethercd.mysticalagrartifacts.MysticalAgrArtifacts;
import com.ethercd.mysticalagrartifacts.utils.IHasModel;
import net.minecraft.item.Item;

public class ItemBase extends Item  implements IHasModel {
    public ItemBase(String name) {
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(MysticalAgrArtifacts.CREATIVE_TAB);
        ModItems.ITEM_MODEL_REGISTER.add(this);
    }
}
