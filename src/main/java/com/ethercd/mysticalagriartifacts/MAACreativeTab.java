package com.ethercd.mysticalagriartifacts;

import com.ethercd.mysticalagriartifacts.crops.ModCommonCrop;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class MAACreativeTab extends CreativeTabs {
        public MAACreativeTab() {
            super(MysticalAgrArtifacts.MOD_ID);
        }

        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(ModCommonCrop.PROSPERITY.getCrop());
        }
}
