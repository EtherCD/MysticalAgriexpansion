package com.ethercd.mysticalagriexpansion.recipes;

import com.blakebr0.cucumber.helper.RecipeHelper;
import com.blakebr0.mysticalagriculture.lib.CropType;
import com.ethercd.mysticalagriexpansion.crop.CropsRecipe;
import com.ethercd.mysticalagriexpansion.item.ItemCrafting;
import com.ethercd.mysticalagriexpansion.item.ModItems;
import com.ethercd.mysticalagriexpansion.lib.ModChecker;
import com.ethercd.mysticalagriexpansion.lib.ModParts;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
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

        MutagenesisProcessorManager.addRecipe(new ItemStack(CropType.Type.URANIUM.getSeed()), new ItemStack(CropType.Type.URANIUM.getSeed()), new ItemStack(ItemCrafting.NUCLEAR_SEEDS.getItem(), 1), 14);
        MutagenesisProcessorManager.addRecipe(new ItemStack(CropType.Type.URANIUM_238.getSeed()), new ItemStack(CropType.Type.URANIUM.getSeed()), new ItemStack(ItemCrafting.NUCLEAR_SEEDS.getItem(), 1), 17);
        MutagenesisProcessorManager.addRecipe(new ItemStack(CropType.Type.THORIUM.getSeed()), new ItemStack(CropType.Type.URANIUM.getSeed()), new ItemStack(ItemCrafting.NUCLEAR_SEEDS.getItem(), 1), 7);
        MutagenesisProcessorManager.addRecipe(new ItemStack(CropType.Type.THORIUM.getSeed()), new ItemStack(CropType.Type.URANIUM_238.getSeed()), new ItemStack(ItemCrafting.NUCLEAR_SEEDS.getItem(), 1), 9);

        MutagenesisProcessorManager.addRecipe(new ItemStack(CropType.Type.BRONZE.getSeed()), new ItemStack(CropType.Type.CONSTANTAN.getSeed()), new ItemStack(ItemCrafting.ALLOY_SEEDS.getItem(), 1), 12);
        MutagenesisProcessorManager.addRecipe(new ItemStack(CropType.Type.BRONZE.getSeed()), new ItemStack(CropType.Type.ELECTRUM.getSeed()), new ItemStack(ItemCrafting.ALLOY_SEEDS.getItem(), 1), 14);
        MutagenesisProcessorManager.addRecipe(new ItemStack(CropType.Type.BRONZE.getSeed()), new ItemStack(CropType.Type.INVAR.getSeed()), new ItemStack(ItemCrafting.ALLOY_SEEDS.getItem(), 1), 16);
        MutagenesisProcessorManager.addRecipe(new ItemStack(CropType.Type.STEEL.getSeed()), new ItemStack(CropType.Type.ELECTRICAL_STEEL.getSeed()), new ItemStack(ItemCrafting.ALLOY_SEEDS.getItem(), 1), 17);
        MutagenesisProcessorManager.addRecipe(new ItemStack(CropType.Type.STEEL.getSeed()), new ItemStack(CropType.Type.CONDUCTIVE_IRON.getSeed()), new ItemStack(ItemCrafting.ALLOY_SEEDS.getItem(), 1), 19);
        MutagenesisProcessorManager.addRecipe(new ItemStack(CropType.Type.STEEL.getSeed()), new ItemStack(CropType.Type.DARK_STEEL.getSeed()), new ItemStack(ItemCrafting.ALLOY_SEEDS.getItem(), 1), 16);
        MutagenesisProcessorManager.addRecipe(new ItemStack(CropType.Type.STEEL.getSeed()), new ItemStack(CropType.Type.END_STEEL.getSeed()), new ItemStack(ItemCrafting.ALLOY_SEEDS.getItem(), 1), 14);
        MutagenesisProcessorManager.addRecipe(new ItemStack(CropType.Type.ELECTRICAL_STEEL.getSeed()), new ItemStack(CropType.Type.CONDUCTIVE_IRON.getSeed()), new ItemStack(ItemCrafting.ALLOY_SEEDS.getItem(), 1), 19);
        MutagenesisProcessorManager.addRecipe(new ItemStack(CropType.Type.ELECTRICAL_STEEL.getSeed()), new ItemStack(CropType.Type.DARK_STEEL.getSeed()), new ItemStack(ItemCrafting.ALLOY_SEEDS.getItem(), 1), 15);
        MutagenesisProcessorManager.addRecipe(new ItemStack(CropType.Type.ELECTRICAL_STEEL.getSeed()), new ItemStack(CropType.Type.PULSATING_IRON.getSeed()), new ItemStack(ItemCrafting.ALLOY_SEEDS.getItem(), 1), 19);
        MutagenesisProcessorManager.addRecipe(new ItemStack(CropType.Type.DARK_STEEL.getSeed()), new ItemStack(CropType.Type.VIBRANT_ALLOY.getSeed()), new ItemStack(ItemCrafting.ALLOY_SEEDS.getItem(), 1), 16);
        MutagenesisProcessorManager.addRecipe(new ItemStack(CropType.Type.DARK_STEEL.getSeed()), new ItemStack(CropType.Type.ENERGETIC_ALLOY.getSeed()), new ItemStack(ItemCrafting.ALLOY_SEEDS.getItem(), 1), 17);
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
