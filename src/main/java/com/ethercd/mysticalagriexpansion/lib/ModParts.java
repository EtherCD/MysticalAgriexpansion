package com.ethercd.mysticalagriexpansion.lib;

import com.blakebr0.mysticalagriculture.items.ItemCrafting;
import com.blakebr0.mysticalagriculture.items.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;


/**
 * This class contains all resources from other mods
 */
public class ModParts {
    // Mystical Agriculture
    public static ItemStack itemProsperityShard = ItemCrafting.itemProsperityShard;
    public static ItemStack itemTier1Essence = ItemCrafting.itemInferiumEssence;
    public static ItemStack itemTier2Essence = ItemCrafting.itemPrudentiumEssence;
    public static ItemStack itemTier3Essence = ItemCrafting.itemIntermediumEssence;
    public static ItemStack itemTier4Essence = ItemCrafting.itemSuperiumEssence;
    public static ItemStack itemTier5Essence = ItemCrafting.itemSupremiumEssence;
    public static ItemStack itemTier1CraftingSeed = ItemCrafting.itemTier1CraftingSeed;
    public static ItemStack itemTier2CraftingSeed = ItemCrafting.itemTier2CraftingSeed;
    public static ItemStack itemTier3CraftingSeed = ItemCrafting.itemTier3CraftingSeed;
    public static ItemStack itemTier4CraftingSeed = ItemCrafting.itemTier4CraftingSeed;
    public static ItemStack itemTier5CraftingSeed = ItemCrafting.itemTier5CraftingSeed;
    public static ItemStack itemSupremiumFertCore = ItemCrafting.itemSupremiumFertCore;
    public static ItemStack itemTheoreticalWater = ItemCrafting.itemTheoreticalWater;
    public static ItemStack itemFertilizedEssence;

    // Mystical Agradditions
    public static ItemStack itemInsaniumIngot;
    public static ItemStack itemInsaniumNugget;
    public static ItemStack itemInsaniumEssence;


    public static void init() {
        itemFertilizedEssence = new ItemStack(ModItems.itemFertilizedEssence, 1, 0);

        if (ModChecker.INSANIUM) {
            try {
                itemInsaniumIngot = OreDictionary.getOres("ingotInsanium").get(0);
            } catch(Throwable e){
                e.printStackTrace();
            }
            try {
                itemInsaniumNugget = OreDictionary.getOres("nuggetInsanium").get(0);
            } catch(Throwable e){
                e.printStackTrace();
            }
            try {
                itemInsaniumEssence = OreDictionary.getOres("essenceInsanium").get(0);
            } catch(Throwable e){
                e.printStackTrace();
            }
        }
    }
}
