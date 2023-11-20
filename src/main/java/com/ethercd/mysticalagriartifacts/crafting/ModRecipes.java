package com.ethercd.mysticalagriartifacts.crafting;

import com.blakebr0.cucumber.helper.RecipeHelper;
import com.ethercd.mysticalagriartifacts.crops.CommonCropsRecipes;
import com.ethercd.mysticalagriartifacts.items.ItemCrafting;
import com.ethercd.mysticalagriartifacts.items.ModItems;
import com.ethercd.mysticalagriartifacts.lib.ModChecker;
import com.ethercd.mysticalagriartifacts.lib.ModParts;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ModRecipes {
    public static void init() {
        if (ModChecker.INSANIUM) {
            RecipeHelper.addShapedRecipe(new ItemStack(ItemCrafting.itemInsaniumTheoreticalWater, 1, 0),
                    "NTN",
                    "TTT",
                    "NTN",
                    'N',
                    ModParts.InsaniumNugget,
                    'T',
                    ModParts.TheoreticalWater);
            RecipeHelper.addShapedRecipe(new ItemStack(ItemCrafting.itemInsaniumFertCore, 1, 0),
                    "ETE",
                    "FSF",
                    "EFE",
                    'F',
                    ModParts.FertilizedEssence,
                    'E',
                    ModParts.InsaniumEssence,
                    'S',
                    ModParts.SupremiumFertCore,
                    'T',
                    Blocks.DRAGON_EGG);
            RecipeHelper.addShapedRecipe(new ItemStack(ModItems.itemInsaniumWateringCan, 1, 0),
                    "IF ",
                    "ITI",
                    " I ",
                    'I',
                    ModParts.InsaniumIngot,
                    'T',
                    ItemCrafting.itemInsaniumTheoreticalWater,
                    'F',
                    ItemCrafting.itemInsaniumFertCore);
        }

        CommonCropsRecipes.init();
    }



    public enum ShapeEssenceRecipe {
        RHOMBUS(" E ", "E E", " E "),
        FULL("EEE", "EEE", "EEE"),
        CENTER("   ", " E ", "   ")
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
