package com.ethercd.mysticalagriexpansion.lib;

import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Contains constants about the existence of some materials from other mods, and loaded mods
 */
public class ModChecker {
    public static final boolean INDUSTRIAL_CRAFT_2 = Loader.isModLoaded("IC2") || Loader.isModLoaded("ic2");
    public static final boolean NUCLEAR_CRAFT = Loader.isModLoaded("nuclearcraft");
    public static final boolean MYSTICAL_AGRADDITIONS = Loader.isModLoaded("mysticalagradditions");

    public static final boolean INSANIUM;

    // Mekanism | IC2
    public static final boolean CIRCUIT_BASIC;
    public static final boolean CIRCUIT_ADVANCED;

    // Nuclear Craft
    public static final boolean BERYLLIUM;
    public static final boolean ZIRCONIUM;

    static {
        INSANIUM = (!OreDictionary.getOres("essenceInsanium", false).isEmpty() &&
                !OreDictionary.getOres("ingotInsanium", false).isEmpty() &&
                !OreDictionary.getOres("nuggetInsanium", false).isEmpty()) || MYSTICAL_AGRADDITIONS;
        CIRCUIT_BASIC = (!OreDictionary.getOres("circuitBasic", false).isEmpty()) || INDUSTRIAL_CRAFT_2;
        CIRCUIT_ADVANCED = (!OreDictionary.getOres("circuitAdvanced", false).isEmpty()) || INDUSTRIAL_CRAFT_2;
        BERYLLIUM = (!OreDictionary.getOres("beryllium", false).isEmpty()) || NUCLEAR_CRAFT;
        ZIRCONIUM = (!OreDictionary.getOres("zirconium", false).isEmpty()) || NUCLEAR_CRAFT;
    }
}
