package com.ethercd.mysticalagriexpansion.lib;

import com.blakebr0.mysticalagriculture.items.ItemCrafting;
import com.blakebr0.mysticalagriculture.items.ModItems;
import com.blakebr0.mysticalagriculture.lib.Parts;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
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

    // Industrial Parts
    public static ItemStack itemCircuitBasic;
    public static ItemStack itemCircuitAdvanced;

    // Nuclear Craft
    public static ItemStack itemBerylliumIngot;
    public static ItemStack itemZirconiumIngot;

    public static Item itemIC2Nuclear;

    public static Item itemNCThorium;
    public static Item itemNCUranium;
    public static Item itemNCPlutonium;
    public static Item itemNCNeptunium;
    public static Item itemNCAmericium;
    public static Item itemNCCurium;
    public static Item itemNCBerkelium;
    public static Item itemNCCalifornium;


    public static void init() {
        itemFertilizedEssence = new ItemStack(ModItems.itemFertilizedEssence, 1, 0);

        if (ModChecker.NUCLEAR_CRAFT) {
            try {
                itemNCThorium = Parts.getItem("nuclearcraft:thorium");
                itemNCUranium = Parts.getItem("nuclearcraft:uranium");
                itemNCPlutonium = Parts.getItem("nuclearcraft:plutonium");
                itemNCNeptunium = Parts.getItem("nuclearcraft:neptunium");
                itemNCAmericium = Parts.getItem("nuclearcraft:americium");
                itemNCCurium = Parts.getItem("nuclearcraft:curium");
                itemNCBerkelium = Parts.getItem("nuclearcraft:berkelium");
                itemNCCalifornium = Parts.getItem("nuclearcraft:californium");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (ModChecker.INDUSTRIAL_CRAFT_2) {
            try {
                itemIC2Nuclear = Parts.getItem("ic2:nuclear");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (ModChecker.BERYLLIUM) {
            try {
                itemBerylliumIngot = OreDictionary.getOres("ingotBeryllium", false).get(0);
            } catch(Throwable e){
                e.printStackTrace();
            }
        }
        if (ModChecker.ZIRCONIUM) {
            try {
                itemZirconiumIngot = OreDictionary.getOres("ingotZirconium", false).get(0);
            } catch(Throwable e){
                e.printStackTrace();
            }
        }

        if (ModChecker.INSANIUM) {
            try {
                itemInsaniumIngot = OreDictionary.getOres("ingotInsanium", false).get(0);
            } catch(Throwable e){
                e.printStackTrace();
            }
            try {
                itemInsaniumNugget = OreDictionary.getOres("nuggetInsanium", false).get(0);
            } catch(Throwable e){
                e.printStackTrace();
            }
            try {
                itemInsaniumEssence = OreDictionary.getOres("essenceInsanium", false).get(0);
            } catch(Throwable e){
                e.printStackTrace();
            }
        }
    }
}