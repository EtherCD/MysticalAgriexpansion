package com.ethercd.mysticalagriartifacts.crafting;

import com.ethercd.mysticalagriartifacts.crops.CommonCropsRecipes;

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
