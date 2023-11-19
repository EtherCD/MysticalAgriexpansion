package com.ethercd.mysticalagrartifacts.crops;

import com.blakebr0.cucumber.helper.RecipeHelper;
import com.blakebr0.mysticalagriculture.items.ItemCrafting;
import com.ethercd.mysticalagrartifacts.crafting.ModRecipes;
import com.ethercd.mysticalagrartifacts.lib.ModParts;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CommonCropsRecipes {
    public static void init() {
        for (CropsRecipe recipe : CropsRecipe.values()) {
            recipe.registerRecipe();
        }
    }

    public enum CropsRecipe {
        PROSPERITY_CROP(ModCommonCrop.PROSPERITY, ModRecipes.ShapeEssenceRecipe.RHOMBUS, ModParts.ProsperityShard, ModParts.ProsperityShard)
        ;

        private ModCommonCrop crop;
        private ModRecipes.ShapeEssenceRecipe shape;
        private ItemStack output;
        private ItemStack madeOf;

        CropsRecipe(ModCommonCrop crop,
                    // Essence to something recipe
                    ModRecipes.ShapeEssenceRecipe shape, ItemStack output,
                    // Recipe to made seed
                    ItemStack madeOf
                    )
        {
            this.crop = crop;
            this.shape = shape;
            this.output = output;
            this.madeOf = madeOf;
        }

        public void registerRecipe() {
            if (this.crop.isEnabled()) {
                RecipeHelper.addShapedRecipe(this.output,
                        this.shape.getShape()[0],
                        this.shape.getShape()[1],
                        this.shape.getShape()[2],
                        'E',
                        new ItemStack(this.crop.getCrop(),
                                1,
                                0));

                ItemStack tierInferiumEssence;
                ItemStack tierCraftingSeeds;

                switch (this.crop.getTier()) {
                    default:
                    case 1:
                        tierInferiumEssence = ModParts.Tier1Essence;
                        tierCraftingSeeds = ModParts.Tier1CraftingSeeds;
                    case 2:
                        tierInferiumEssence = ModParts.Tier2Essence;
                        tierCraftingSeeds = ModParts.Tier2CraftingSeeds;
                    case 3:
                        tierInferiumEssence = ModParts.Tier3Essence;
                        tierCraftingSeeds = ModParts.Tier3CraftingSeeds;
                    case 4:
                        tierInferiumEssence = ModParts.Tier4Essence;
                        tierCraftingSeeds = ModParts.Tier4CraftingSeeds;
                    case 5:
                        tierInferiumEssence = ModParts.Tier5Essence;
                        tierCraftingSeeds = ModParts.Tier5CraftingSeeds;
                }

                RecipeHelper.addShapedRecipe(new ItemStack(this.crop.getSeed(), 1, 0),
                        "PEP",
                        "ECE",
                        "PEP",
                        'P',
                        this.madeOf,
                        'E',
                        tierInferiumEssence,
                        'C',
                        tierCraftingSeeds);
            }
        }
    }
}
