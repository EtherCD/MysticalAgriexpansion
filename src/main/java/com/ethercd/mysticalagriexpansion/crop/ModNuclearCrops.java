package com.ethercd.mysticalagriexpansion.crop;

import com.blakebr0.cucumber.helper.RecipeHelper;
import com.blakebr0.mysticalagriculture.blocks.crop.BlockMysticalCrop;
import com.ethercd.mysticalagriexpansion.block.BlockCrop;
import com.ethercd.mysticalagriexpansion.item.ItemCrafting;
import com.ethercd.mysticalagriexpansion.item.ItemSeed;
import com.ethercd.mysticalagriexpansion.item.ModItem;
import com.ethercd.mysticalagriexpansion.lib.ModChecker;
import com.ethercd.mysticalagriexpansion.lib.ModParts;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class ModNuclearCrops {
    public static NuclearCrop cropUranium235;
    public static NuclearCrop cropUranium233;
    public static NuclearCrop cropThorium230;
    public static NuclearCrop cropThorium232;
    public static NuclearCrop cropPlutonium238;
    public static NuclearCrop cropPlutonium239;
    public static NuclearCrop cropPlutonium241;
    public static NuclearCrop cropPlutonium242;
    public static NuclearCrop cropNeptunium236;
    public static NuclearCrop cropNeptunium237;
    public static NuclearCrop cropAmericium241;
    public static NuclearCrop cropAmericium242;
    public static NuclearCrop cropAmericium243;
    public static NuclearCrop cropCurium243;
    public static NuclearCrop cropCurium245;
    public static NuclearCrop cropCurium246;
    public static NuclearCrop cropCurium247;
    public static NuclearCrop cropBerkelium247;
    public static NuclearCrop cropBerkelium248;
    public static NuclearCrop cropCalifornium249;
    public static NuclearCrop cropCalifornium250;
    public static NuclearCrop cropCalifornium251;
    public static NuclearCrop cropCalifornium252;

    public static List<NuclearCrop> NUCLEAR_CROPS_LIST = new ArrayList<>();

    public static void init() {
        if (!ModChecker.NUCLEAR_CRAFT) {
            cropUranium235 = new NuclearCrop("uranium_235", 3, 1, 5, ModChecker.INDUSTRIAL_CRAFT_2, ModParts.itemIC2Nuclear);
        } else {
            cropUranium235 = new NuclearCrop("uranium_235", 3, 4, 6, ModChecker.NUCLEAR_CRAFT, ModParts.itemNCUranium);
        }
        cropUranium233 = new NuclearCrop("uranium_233", 4, 0, 2, ModChecker.NUCLEAR_CRAFT, ModParts.itemNCUranium);
        cropThorium230 = new NuclearCrop("thorium_230", 4, 0, 2, ModChecker.NUCLEAR_CRAFT, ModParts.itemNCThorium);
        cropThorium232 = new NuclearCrop("thorium_232", 2, 4, 6, ModChecker.NUCLEAR_CRAFT, ModParts.itemNCThorium);
        cropPlutonium238 = new NuclearCrop("plutonium_238", 5, 0, 2, ModChecker.NUCLEAR_CRAFT, ModParts.itemNCPlutonium);
        cropPlutonium239 = new NuclearCrop("plutonium_239", 4, 4, 6, ModChecker.NUCLEAR_CRAFT, ModParts.itemNCPlutonium);
        cropPlutonium241 = new NuclearCrop("plutonium_241", 5, 8, 10, ModChecker.NUCLEAR_CRAFT, ModParts.itemNCPlutonium);
        cropPlutonium242 = new NuclearCrop("plutonium_242", 3, 12, 14, ModChecker.NUCLEAR_CRAFT, ModParts.itemNCPlutonium);
        cropNeptunium236 = new NuclearCrop("neptunium_236", 4, 0, 2, ModChecker.NUCLEAR_CRAFT, ModParts.itemNCNeptunium);
        cropNeptunium237 = new NuclearCrop("neptunium_237", 3, 4, 6, ModChecker.NUCLEAR_CRAFT, ModParts.itemNCNeptunium);
        cropAmericium241 = new NuclearCrop("americium_241", 4, 0, 2, ModChecker.NUCLEAR_CRAFT, ModParts.itemNCAmericium);
        cropAmericium242 = new NuclearCrop("americium_242", 5, 4, 6, ModChecker.NUCLEAR_CRAFT, ModParts.itemNCAmericium);
        cropAmericium243 = new NuclearCrop("americium_243", 4, 8, 10, ModChecker.NUCLEAR_CRAFT, ModParts.itemNCAmericium);
        cropCurium243 = new NuclearCrop("curium_243", 5, 0, 2, ModChecker.NUCLEAR_CRAFT, ModParts.itemNCCurium);
        cropCurium245 = new NuclearCrop("curium_245", 4, 4, 6, ModChecker.NUCLEAR_CRAFT, ModParts.itemNCCurium);
        cropCurium246 = new NuclearCrop("curium_246", 4, 8, 10, ModChecker.NUCLEAR_CRAFT, ModParts.itemNCCurium);
        cropCurium247 = new NuclearCrop("curium_247", 3, 12, 14, ModChecker.NUCLEAR_CRAFT, ModParts.itemNCCurium);
        cropBerkelium247 = new NuclearCrop("berkelium_247", 4, 0, 2, ModChecker.NUCLEAR_CRAFT, ModParts.itemNCBerkelium);
        cropBerkelium248 = new NuclearCrop("berkelium_248", 4, 4, 6, ModChecker.NUCLEAR_CRAFT, ModParts.itemNCBerkelium);
        cropCalifornium249 = new NuclearCrop("californium_249", 4, 0, 2, ModChecker.NUCLEAR_CRAFT, ModParts.itemNCCalifornium);
        cropCalifornium250 = new NuclearCrop("californium_250", 5, 4, 6, ModChecker.NUCLEAR_CRAFT, ModParts.itemNCCalifornium);
        cropCalifornium251 = new NuclearCrop("californium_251", 4, 8, 10, ModChecker.NUCLEAR_CRAFT, ModParts.itemNCCalifornium);
        cropCalifornium252 = new NuclearCrop("californium_252", 5, 12, 14, ModChecker.NUCLEAR_CRAFT, ModParts.itemNCCalifornium);
    }

    public static void initRecipes() {
        for (NuclearCrop nc : NUCLEAR_CROPS_LIST) {
            nc.initRecipes();
        }
    }
}