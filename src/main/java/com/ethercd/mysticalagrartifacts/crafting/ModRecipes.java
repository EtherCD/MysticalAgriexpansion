package com.ethercd.mysticalagrartifacts.crafting;

import com.blakebr0.cucumber.helper.RecipeHelper;
import com.blakebr0.mysticalagriculture.items.ItemCrafting;
import com.ethercd.mysticalagrartifacts.crops.CommonCropsRecipes;
import com.ethercd.mysticalagrartifacts.crops.ModCommonCrop;
import com.ethercd.mysticalagrartifacts.lib.ModParts;
import net.minecraft.item.ItemStack;

public class ModRecipes {
    public static void init() {
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
