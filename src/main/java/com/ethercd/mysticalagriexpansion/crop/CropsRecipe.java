package com.ethercd.mysticalagriexpansion.crop;

import com.blakebr0.cucumber.helper.RecipeHelper;
import com.ethercd.mysticalagriexpansion.crop.alloy.AlloyCrops;
import com.ethercd.mysticalagriexpansion.crop.nuclear.NuclearCrops;
import com.ethercd.mysticalagriexpansion.item.ItemCrafting;
import com.ethercd.mysticalagriexpansion.lib.ModParts;
import com.ethercd.mysticalagriexpansion.recipes.ModRecipes;
import net.minecraft.item.ItemStack;

@SuppressWarnings({"unused", "CallToPrintStackTrace"})
public enum CropsRecipe {
    PROSPERITY_CROP(CommonCrop.PROSPERITY, ModRecipes.ShapeEssenceRecipe.RHOMBUS, ModParts.itemProsperityShard, ModParts.itemProsperityShard),
    MECHANICAL_CROP(CommonCrop.MECHANICAL, ModRecipes.ShapeEssenceRecipe.STAR, new ItemStack(ItemCrafting.EXEMPLARY_GEAR.getItem(), 1, 0), new ItemStack(ItemCrafting.EXEMPLARY_GEAR.getItem(), 1, 0)),
    BERYLLIUM_CROP(CommonCrop.BERYLLIUM, ModRecipes.ShapeEssenceRecipe.FULL, ModParts.itemBerylliumIngot, ModParts.itemBerylliumIngot),
    ZIRCONIUM_CROP(CommonCrop.ZIRCONIUM, ModRecipes.ShapeEssenceRecipe.FULL, ModParts.itemZirconiumIngot, ModParts.itemZirconiumIngot),
    PROTON_CROP(CommonCrop.PROTON, ModRecipes.ShapeEssenceRecipe.FULL, ModParts.itemIUProton, ModParts.itemIUProton),
    THORIUM_CROP(CommonCrop.THORIUM, ModRecipes.ShapeEssenceRecipe.FULL, ModParts.itemIUThorium, ModParts.itemIUThorium),
    MICHALOV_CROP(CommonCrop.MICHALOV, ModRecipes.ShapeEssenceRecipe.FULL, ModParts.itemIUThorium, ModParts.itemIUThorium),
    ;

    private final CommonCrop crop;
    private final ModRecipes.ShapeEssenceRecipe shape;
    private final ItemStack output;
    private final ItemStack madeOf;

    CropsRecipe(CommonCrop crop,
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

    public void initRecipe() {
        if (this.crop.isEnabled() && this.output != null && this.madeOf != null) {
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

    public static void register() {
        for (CropsRecipe recipe : CropsRecipe.values()) {
            try {
                recipe.initRecipe();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            NuclearCrops.registerRecipes();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            AlloyCrops.registerRecipes();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
