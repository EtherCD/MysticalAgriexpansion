package com.ethercd.mysticalagriexpansion.recipes;

import com.blakebr0.cucumber.helper.RecipeHelper;
import com.ethercd.mysticalagriexpansion.crop.CropsRecipe;
import com.ethercd.mysticalagriexpansion.item.ItemCrafting;
import com.ethercd.mysticalagriexpansion.item.ItemWateringCan;
import com.ethercd.mysticalagriexpansion.item.ModItems;
import com.ethercd.mysticalagriexpansion.lib.ModChecker;
import com.ethercd.mysticalagriexpansion.lib.ModParts;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ModRecipes {
    public static void init() {
        if (ModChecker.INSANIUM) {
            RecipeHelper.addShapedRecipe(new ItemStack(ItemCrafting.INSANIUM_THEORETICAL_WATER.getItem(), 1, 0), "NTN", "TTT", "NTN", 'N', ModParts.itemInsaniumNugget, 'T', ModParts.itemTheoreticalWater);
            RecipeHelper.addShapedRecipe(new ItemStack(ItemCrafting.INSANIUM_FERT_CORE.getItem(), 1, 0), "ETE", "FSF", "EFE", 'F', ModParts.itemFertilizedEssence, 'E', ModParts.itemInsaniumEssence, 'S', ModParts.itemSupremiumFertCore, 'T', Blocks.DRAGON_EGG);
            RecipeHelper.addShapedRecipe(new ItemStack(ModItems.itemInstaiumWateringCan, 1, 0), "IF ", "ITI", " I ", 'I', ModParts.itemInsaniumIngot, 'T', ItemCrafting.INSANIUM_FERT_CORE.getItem(), 'F', ItemCrafting.INSANIUM_THEORETICAL_WATER.getItem());
        }

        RecipeHelper.addShapedRecipe(new ItemStack(ItemCrafting.EXEMPLARY_GEAR.getItem(), 1, 0)," I ", "ISI", " I ", 'I', Items.IRON_INGOT, 'S', Items.STICK);

        CropsRecipe.init();
    }



    public enum ShapeEssenceRecipe {
        RHOMBUS(" E ", "E E", " E "),
        FULL("EEE", "EEE", "EEE"),
        CENTER("   ", " E ", "   "),
        STAR(" E ", "EEE", " E ")
        ;

        private String[] shape;

        ShapeEssenceRecipe(String top, String center, String bottom) {
            this.shape = new String[] {top,center,bottom};
        }

        public String[] getShape() {
            return this.shape;
        }
    }
}
