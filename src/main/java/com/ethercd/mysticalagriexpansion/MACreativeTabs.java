package com.ethercd.mysticalagriexpansion;

import com.ethercd.mysticalagriexpansion.item.ItemCrafting;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

import static com.ethercd.mysticalagriexpansion.MysticalAgriexpansion.MOD_ID;

public class MACreativeTabs {
    public static CreativeTabs CREATIVE_TAB = new CreativeTabs(MOD_ID) {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(ItemCrafting.EXEMPLARY_GEAR.getItem(), 1, 0);
        }
    };
    public static CreativeTabs CREATIVE_TAB_NUCLEAR = new CreativeTabs(MOD_ID + "_nuclear") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(ItemCrafting.NUCLEAR_SEEDS.getItem(), 1, 0);
        }
    };
    public static CreativeTabs CREATIVE_TAB_ALLOY = new CreativeTabs(MOD_ID + "_alloy") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(ItemCrafting.ALLOY_SEEDS.getItem(), 1, 0);
        }
    };
    public static CreativeTabs CREATIVE_TAB_ELECTRONIC = new CreativeTabs(MOD_ID + "_electronic") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(ItemCrafting.ELECTRONIC_SEEDS.getItem(), 1, 0);
        }
    };
}
