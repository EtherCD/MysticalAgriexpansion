package com.ethercd.mysticalagriexpansion.recipes;

import com.blakebr0.cucumber.helper.RecipeHelper;
import com.blakebr0.mysticalagriculture.lib.CropType;
import com.ethercd.mysticalagriexpansion.block.ModBlocks;
import com.ethercd.mysticalagriexpansion.crop.CommonCrop;
import com.ethercd.mysticalagriexpansion.crop.CropsRecipe;
import com.ethercd.mysticalagriexpansion.crop.ModCrops;
import com.ethercd.mysticalagriexpansion.item.ItemCrafting;
import com.ethercd.mysticalagriexpansion.item.ModItems;
import com.ethercd.mysticalagriexpansion.lib.ModChecker;
import com.ethercd.mysticalagriexpansion.lib.ModMetaPart;
import com.ethercd.mysticalagriexpansion.lib.ModParts;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

@SuppressWarnings({"unused", "super"})
public class ModRecipes {
    public static void register() {
        if (ModChecker.INSANIUM) {
            RecipeHelper.addShapedRecipe(new ItemStack(ItemCrafting.INSANIUM_THEORETICAL_WATER.getItem(), 1, 0), "NTN", "TTT", "NTN", 'N', ModParts.itemInsaniumNugget, 'T', ModParts.itemTheoreticalWater);
            RecipeHelper.addShapedRecipe(new ItemStack(ItemCrafting.INSANIUM_FERT_CORE.getItem(), 1, 0), "ETE", "FSF", "EFE", 'F', ModParts.itemFertilizedEssence, 'E', ModParts.itemInsaniumEssence, 'S', ModParts.itemSupremiumFertCore, 'T', Blocks.DRAGON_EGG);
            RecipeHelper.addShapedRecipe(new ItemStack(ModItems.itemInstaiumWateringCan, 1, 0), "IF ", "ITI", " I ", 'I', ModParts.itemInsaniumIngot, 'T', ItemCrafting.INSANIUM_FERT_CORE.getItem(), 'F', ItemCrafting.INSANIUM_THEORETICAL_WATER.getItem());
        }

        RecipeHelper.addShapedRecipe(new ItemStack(ItemCrafting.EXEMPLARY_GEAR.getItem(), 1, 0), " I ", "ISI", " I ", 'I', Items.IRON_INGOT, 'S', Items.STICK);

        CropsRecipe.register();

        initMachinesRecipes();

        RecipeHelper.addShapedRecipe(new ItemStack(ItemCrafting.TIER_1_ALLOY_SEEDS.getItem(), 1, 0), "XYX", "YPY", "XYX", 'X', ModParts.itemTier1Essence, 'Y', ModParts.itemTier1Ingot, 'P', ItemCrafting.ALLOY_SEEDS.getItem());
        RecipeHelper.addShapedRecipe(new ItemStack(ItemCrafting.TIER_2_ALLOY_SEEDS.getItem(), 1, 0), "XYX", "YPY", "XYX", 'X', ModParts.itemTier2Essence, 'Y', ModParts.itemTier2Ingot, 'P', ItemCrafting.TIER_1_ALLOY_SEEDS.getItem());
        RecipeHelper.addShapedRecipe(new ItemStack(ItemCrafting.TIER_3_ALLOY_SEEDS.getItem(), 1, 0), "XYX", "YPY", "XYX", 'X', ModParts.itemTier3Essence, 'Y', ModParts.itemTier3Ingot, 'P', ItemCrafting.TIER_2_ALLOY_SEEDS.getItem());
        RecipeHelper.addShapedRecipe(new ItemStack(ItemCrafting.TIER_4_ALLOY_SEEDS.getItem(), 1, 0), "XYX", "YPY", "XYX", 'X', ModParts.itemTier4Essence, 'Y', ModParts.itemTier4Ingot, 'P', ItemCrafting.TIER_3_ALLOY_SEEDS.getItem());
        RecipeHelper.addShapedRecipe(new ItemStack(ItemCrafting.TIER_5_ALLOY_SEEDS.getItem(), 1, 0), "XYX", "YPY", "XYX", 'X', ModParts.itemTier5Essence, 'Y', ModParts.itemTier5Ingot, 'P', ItemCrafting.TIER_4_ALLOY_SEEDS.getItem());

        RecipeHelper.addShapedRecipe(new ItemStack(ItemCrafting.TIER_1_NUCLEAR_SEEDS.getItem(), 1, 0), "XYX", "YPY", "XYX", 'X', ModParts.itemTier1Essence, 'Y', ModParts.itemTier1Ingot, 'P', ItemCrafting.NUCLEAR_SEEDS.getItem());
        RecipeHelper.addShapedRecipe(new ItemStack(ItemCrafting.TIER_2_NUCLEAR_SEEDS.getItem(), 1, 0), "XYX", "YPY", "XYX", 'X', ModParts.itemTier2Essence, 'Y', ModParts.itemTier2Ingot, 'P', ItemCrafting.TIER_1_NUCLEAR_SEEDS.getItem());
        RecipeHelper.addShapedRecipe(new ItemStack(ItemCrafting.TIER_3_NUCLEAR_SEEDS.getItem(), 1, 0), "XYX", "YPY", "XYX", 'X', ModParts.itemTier3Essence, 'Y', ModParts.itemTier3Ingot, 'P', ItemCrafting.TIER_2_NUCLEAR_SEEDS.getItem());
        RecipeHelper.addShapedRecipe(new ItemStack(ItemCrafting.TIER_4_NUCLEAR_SEEDS.getItem(), 1, 0), "XYX", "YPY", "XYX", 'X', ModParts.itemTier4Essence, 'Y', ModParts.itemTier4Ingot, 'P', ItemCrafting.TIER_3_NUCLEAR_SEEDS.getItem());
        RecipeHelper.addShapedRecipe(new ItemStack(ItemCrafting.TIER_5_NUCLEAR_SEEDS.getItem(), 1, 0), "XYX", "YPY", "XYX", 'X', ModParts.itemTier5Essence, 'Y', ModParts.itemTier5Ingot, 'P', ItemCrafting.TIER_4_NUCLEAR_SEEDS.getItem());

        RecipeHelper.addShapedRecipe(new ItemStack(ItemCrafting.TIER_1_ELECTRONIC_SEEDS.getItem(), 1, 0), "XYX", "YPY", "XYX", 'X', ModParts.itemTier1Essence, 'Y', ModParts.itemTier1Ingot, 'P', ItemCrafting.ELECTRONIC_SEEDS.getItem());
        RecipeHelper.addShapedRecipe(new ItemStack(ItemCrafting.TIER_2_ELECTRONIC_SEEDS.getItem(), 1, 0), "XYX", "YPY", "XYX", 'X', ModParts.itemTier2Essence, 'Y', ModParts.itemTier2Ingot, 'P', ItemCrafting.TIER_1_ELECTRONIC_SEEDS.getItem());
        RecipeHelper.addShapedRecipe(new ItemStack(ItemCrafting.TIER_3_ELECTRONIC_SEEDS.getItem(), 1, 0), "XYX", "YPY", "XYX", 'X', ModParts.itemTier3Essence, 'Y', ModParts.itemTier3Ingot, 'P', ItemCrafting.TIER_2_ELECTRONIC_SEEDS.getItem());
        RecipeHelper.addShapedRecipe(new ItemStack(ItemCrafting.TIER_4_ELECTRONIC_SEEDS.getItem(), 1, 0), "XYX", "YPY", "XYX", 'X', ModParts.itemTier4Essence, 'Y', ModParts.itemTier4Ingot, 'P', ItemCrafting.TIER_3_ELECTRONIC_SEEDS.getItem());
        RecipeHelper.addShapedRecipe(new ItemStack(ItemCrafting.TIER_5_ELECTRONIC_SEEDS.getItem(), 1, 0), "XYX", "YPY", "XYX", 'X', ModParts.itemTier5Essence, 'Y', ModParts.itemTier5Ingot, 'P', ItemCrafting.TIER_4_ELECTRONIC_SEEDS.getItem());

        if (ModChecker.INSANIUM) {
            RecipeHelper.addShapedRecipe(new ItemStack(ItemCrafting.TIER_6_ALLOY_SEEDS.getItem(), 1, 0), "XYX", "YPY", "XYX", 'X', ModParts.itemInsaniumEssence, 'Y', ModParts.itemInsaniumIngot, 'P', ItemCrafting.TIER_5_ALLOY_SEEDS.getItem());
            RecipeHelper.addShapedRecipe(new ItemStack(ItemCrafting.TIER_6_NUCLEAR_SEEDS.getItem(), 1, 0), "XYX", "YPY", "XYX", 'X', ModParts.itemInsaniumEssence, 'Y', ModParts.itemInsaniumIngot, 'P', ItemCrafting.TIER_5_NUCLEAR_SEEDS.getItem());
            RecipeHelper.addShapedRecipe(new ItemStack(ItemCrafting.TIER_6_ELECTRONIC_SEEDS.getItem(), 1, 0), "XYX", "YPY", "XYX", 'X', ModParts.itemInsaniumEssence, 'Y', ModParts.itemInsaniumIngot, 'P', ItemCrafting.TIER_5_ELECTRONIC_SEEDS.getItem());
        }

        RecipeHelper.addShapedRecipe(new ItemStack(ItemCrafting.MUTAGENESIS_CORE.getItem(), 1, 0), "EFE", "GWG", "EFE", 'E', CommonCrop.MECHANICAL.getCrop(), 'F', Blocks.HOPPER, 'G', ItemCrafting.EXEMPLARY_GEAR.getItem(), 'W', ModParts.itemTheoreticalWater);
        RecipeHelper.addShapedRecipe(new ItemStack(ModBlocks.blockInferniumMutagenesisProcessor, 1, 0), "BFB", "GEG", "BFB", 'B', new ItemStack(ModMetaPart.MA_STORAGE.getItem(), 1, 0), 'F', ItemCrafting.MUTAGENESIS_CORE.getItem(), 'G', ModParts.itemTier1Ingot, 'E', ModParts.blockInferiumSeedReprocessor);
    }

    private static void initMachinesRecipes() {
        MutagenesisRecipesManager.addRecipe(CropType.Type.THORIUM.getSeed(), CropType.Type.URANIUM.getSeed(), ItemCrafting.NUCLEAR_SEEDS.getItem(), 6);
        MutagenesisRecipesManager.addRecipe(CropType.Type.THORIUM.getSeed(), CropType.Type.URANIUM_238.getSeed(), ItemCrafting.NUCLEAR_SEEDS.getItem(), 12);
        MutagenesisRecipesManager.addRecipe(CropType.Type.URANIUM.getSeed(), CropType.Type.URANIUM_238.getSeed(), ItemCrafting.NUCLEAR_SEEDS.getItem(), 16);

        MutagenesisRecipesManager.addRecipe(CropType.Type.BRONZE.getSeed(), CropType.Type.INVAR.getSeed(), ItemCrafting.ALLOY_SEEDS.getItem(), 14);
        MutagenesisRecipesManager.addRecipe(CropType.Type.BRONZE.getSeed(), CropType.Type.ELECTRUM.getSeed(), ItemCrafting.ALLOY_SEEDS.getItem(), 14);
        MutagenesisRecipesManager.addRecipe(CropType.Type.BRONZE.getSeed(), CropType.Type.CONSTANTAN.getSeed(), ItemCrafting.ALLOY_SEEDS.getItem(), 14);
        MutagenesisRecipesManager.addRecipe(CropType.Type.STEEL.getSeed(), CropType.Type.CONDUCTIVE_IRON.getSeed(), ItemCrafting.ALLOY_SEEDS.getItem(), 16);
        MutagenesisRecipesManager.addRecipe(CropType.Type.STEEL.getSeed(), CropType.Type.DARK_STEEL.getSeed(), ItemCrafting.ALLOY_SEEDS.getItem(), 16);
        MutagenesisRecipesManager.addRecipe(CropType.Type.STEEL.getSeed(), CropType.Type.PULSATING_IRON.getSeed(), ItemCrafting.ALLOY_SEEDS.getItem(), 14);
        MutagenesisRecipesManager.addRecipe(CropType.Type.STEEL.getSeed(), CropType.Type.ENERGETIC_ALLOY.getSeed(), ItemCrafting.ALLOY_SEEDS.getItem(), 16);
        MutagenesisRecipesManager.addRecipe(CropType.Type.STEEL.getSeed(), CropType.Type.VIBRANT_ALLOY.getSeed(), ItemCrafting.ALLOY_SEEDS.getItem(), 14);
        MutagenesisRecipesManager.addRecipe(CropType.Type.STEEL.getSeed(), CropType.Type.END_STEEL.getSeed(), ItemCrafting.ALLOY_SEEDS.getItem(), 14);
    }


    public enum ShapeEssenceRecipe {
        RHOMBUS(" E ", "E E", " E "),
        FULL("EEE", "EEE", "EEE"),
        CENTER("   ", " E ", "   "),
        STAR(" E ", "EEE", " E ")
        ;

        private final String[] shape;

        ShapeEssenceRecipe(String top, String center, String bottom) {
            this.shape = new String[] {top,center,bottom};
        }

        public String[] getShape() {
            return this.shape;
        }
    }
}
