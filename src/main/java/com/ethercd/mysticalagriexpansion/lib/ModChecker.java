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
    public static final boolean INDUSTRIAL_UPGRADE = Loader.isModLoaded("industrialupgrade");
    public static final boolean INSANIUM;

    public static final boolean BERYLLIUM;
    public static final boolean ZIRCONIUM;
    public static final boolean MICHALOV;
    public static final boolean VANADIUM;
    public static final boolean CARAVKY;
    public static final boolean CHROMIUM;
    public static final boolean SPINEL;
    public static final boolean GERMANIUM;

    static {
        INSANIUM = (!OreDictionary.getOres("essenceInsanium", false).isEmpty() &&
                !OreDictionary.getOres("ingotInsanium", false).isEmpty() &&
                !OreDictionary.getOres("nuggetInsanium", false).isEmpty()) || MYSTICAL_AGRADDITIONS;
        BERYLLIUM = (!OreDictionary.getOres("beryllium", false).isEmpty()) || NUCLEAR_CRAFT;
        ZIRCONIUM = (!OreDictionary.getOres("zirconium", false).isEmpty()) || NUCLEAR_CRAFT;
        MICHALOV = (!OreDictionary.getOres("michalov", false).isEmpty()) || INDUSTRIAL_UPGRADE;
        VANADIUM = (!OreDictionary.getOres("vanadium", false).isEmpty()) || INDUSTRIAL_UPGRADE;
        CARAVKY = (!OreDictionary.getOres("caravky", false).isEmpty()) || INDUSTRIAL_UPGRADE;
        CHROMIUM = (!OreDictionary.getOres("chromium", false).isEmpty()) || INDUSTRIAL_UPGRADE;
        SPINEL = (!OreDictionary.getOres("spinel", false).isEmpty()) || INDUSTRIAL_UPGRADE;
        GERMANIUM = (!OreDictionary.getOres("germanium", false).isEmpty()) || INDUSTRIAL_UPGRADE;
    }
}
