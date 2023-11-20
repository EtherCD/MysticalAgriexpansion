package com.ethercd.mysticalagriartifacts.lib;

import com.blakebr0.cucumber.crafting.ShapedOreOutputRecipe;
import com.blakebr0.mysticalagriculture.items.ItemCrafting;
import com.blakebr0.mysticalagriculture.items.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import static com.blakebr0.mysticalagriculture.lib.Parts.getItem;


/**
 * This class contains all resources from other mods
 */
public class ModParts {

    public static ItemStack ProsperityShard = ItemCrafting.itemProsperityShard;
    public static ItemStack Tier1Essence = ItemCrafting.itemInferiumEssence;
    public static ItemStack Tier2Essence = ItemCrafting.itemPrudentiumEssence;
    public static ItemStack Tier3Essence = ItemCrafting.itemIntermediumEssence;
    public static ItemStack Tier4Essence = ItemCrafting.itemSuperiumEssence;
    public static ItemStack Tier5Essence = ItemCrafting.itemSupremiumEssence;
    public static ItemStack Tier1CraftingSeeds = ItemCrafting.itemTier1CraftingSeed;
    public static ItemStack Tier2CraftingSeeds = ItemCrafting.itemTier2CraftingSeed;
    public static ItemStack Tier3CraftingSeeds = ItemCrafting.itemTier3CraftingSeed;
    public static ItemStack Tier4CraftingSeeds = ItemCrafting.itemTier4CraftingSeed;
    public static ItemStack Tier5CraftingSeeds = ItemCrafting.itemTier5CraftingSeed;
    public static ItemStack SupremiumFertCore = ItemCrafting.itemSupremiumFertCore;
    public static ItemStack TheoreticalWater = ItemCrafting.itemTheoreticalWater;
    public static ItemStack FertilizedEssence;
    public static ItemStack InfusionCrystal;

    public static ItemStack InsaniumIngot;
    public static ItemStack InsaniumNugget;
    public static ItemStack InsaniumEssence;

    public static void init() {
        FertilizedEssence = new ItemStack(ModItems.itemFertilizedEssence, 1, 0);
        InfusionCrystal = new ItemStack(ModItems.itemInfusionCrystal, 1, 0);

        if (ModChecker.INSANIUM) {
            try {
                InsaniumIngot = OreDictionary.getOres("ingotInsanium").get(0);
            } catch(Throwable e){
                e.printStackTrace();
            }
            try {
                InsaniumNugget = OreDictionary.getOres("nuggetInsanium").get(0);
            } catch(Throwable e){
                e.printStackTrace();
            }
            try {
                InsaniumEssence = OreDictionary.getOres("essenceInsanium").get(0);
            } catch(Throwable e){
                e.printStackTrace();
            }
        }
    }
}
