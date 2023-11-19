package com.ethercd.mysticalagrartifacts.crafting;

import com.blakebr0.cucumber.helper.RecipeHelper;
import com.ethercd.mysticalagrartifacts.crops.ModCommonCrop;
import com.ethercd.mysticalagrartifacts.lib.ModParts;
import net.minecraft.item.ItemStack;

public class ModRecipes {

    public static void init() {
        RecipeHelper.addShapedRecipe(new ItemStack(ModParts.itemProsperityShard, 2),
                " E ",
                "E E",
                " E ",
                'E',
                new ItemStack(ModCommonCrop.PROSPERITY.getCrop(),
                        1,
                        0));
    }
}
