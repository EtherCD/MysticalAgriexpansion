package com.ethercd.mysticalagriexpansion;

import com.ethercd.mysticalagriexpansion.item.ItemCrafting;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

import static com.ethercd.mysticalagriexpansion.MysticalAgriexpansion.MOD_ID;

@SuppressWarnings({"unused", "super", "NullableProblems"})
public class MACreativeTabs {
    public static CreativeTabs CREATIVE_TAB = new CreativeTabs(MOD_ID) {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(ItemCrafting.EXEMPLARY_GEAR.getItem(), 1, 0);
        }
    };
}
