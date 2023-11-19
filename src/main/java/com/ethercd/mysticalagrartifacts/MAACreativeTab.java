package com.ethercd.mysticalagrartifacts;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class MAACreativeTab extends CreativeTabs {
        public MAACreativeTab() {
            super(MysticalAgrArtifacts.MOD_ID);
        }

        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(Items.COAL);
        }
}
