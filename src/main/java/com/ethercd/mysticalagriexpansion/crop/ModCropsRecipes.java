package com.ethercd.mysticalagriexpansion.crop;

import com.blakebr0.cucumber.helper.RecipeHelper;
import com.ethercd.mysticalagriexpansion.recipe.ModRecipes;
import com.ethercd.mysticalagriexpansion.item.ItemCrafting;
import com.ethercd.mysticalagriexpansion.lib.ModParts;
import net.minecraft.item.ItemStack;

public class ModCropsRecipes {
    public static void init() {
        for (CropsRecipe recipe : CropsRecipe.values()) {
            recipe.registerRecipe();
        }
    }

    public enum CropsRecipe {
        PROSPERITY_CROP(ModCommonCrop.PROSPERITY, ModRecipes.ShapeEssenceRecipe.RHOMBUS, ModParts.itemProsperityShard, ModParts.itemProsperityShard),
        MECHANICAL_CROP(ModCommonCrop.MECHANICAL, ModRecipes.ShapeEssenceRecipe.STAR, new ItemStack(ItemCrafting.EXEMPLARY_GEAR.getItem(), 1, 0), new ItemStack(ItemCrafting.EXEMPLARY_GEAR.getItem(), 1, 0))
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
                        tierInferiumEssence = ModParts.itemTier1Essence;
                        tierCraftingSeeds = ModParts.itemTier1CraftingSeed;
                        break;
                    case 2:
                        tierInferiumEssence = ModParts.itemTier2Essence;
                        tierCraftingSeeds = ModParts.itemTier2CraftingSeed;
                        break;
                    case 3:
                        tierInferiumEssence = ModParts.itemTier3Essence;
                        tierCraftingSeeds = ModParts.itemTier3CraftingSeed;
                        break;
                    case 4:
                        tierInferiumEssence = ModParts.itemTier4Essence;
                        tierCraftingSeeds = ModParts.itemTier4CraftingSeed;
                        break;
                    case 5:
                        tierInferiumEssence = ModParts.itemTier5Essence;
                        tierCraftingSeeds = ModParts.itemTier5CraftingSeed;
                        break;
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
