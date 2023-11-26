package com.ethercd.mysticalagriexpansion;

import com.ethercd.mysticalagriexpansion.crop.ModCommonCrop;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTab extends CreativeTabs {
        public CreativeTab() {
            super(Mod.MOD_ID);
        }

        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(ModCommonCrop.PROSPERITY.getCrop());
        }
}
