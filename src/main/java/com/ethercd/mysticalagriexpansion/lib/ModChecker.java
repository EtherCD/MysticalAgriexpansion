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

    // Nuclear
//    public static final boolean URANIUM_235;
//    public static final boolean URANIUM_233;
//    public static final boolean PLUTONIUM;
//    public static final boolean AMERICIUM;
//    public static final boolean CURIUM;
//    public static final boolean BERKELIUM;
//    public static final boolean CALIFORNIUM;
//
//    // Stuff
//    public static final boolean BORON;
//    public static final boolean LITHIUM;

    static {
        INSANIUM = (!OreDictionary.getOres("essenceInsanium", false).isEmpty() &&
                !OreDictionary.getOres("ingotInsanium", false).isEmpty() &&
                !OreDictionary.getOres("nuggetInsanium", false).isEmpty()) || MYSTICAL_AGRADDITIONS;
    }
}
