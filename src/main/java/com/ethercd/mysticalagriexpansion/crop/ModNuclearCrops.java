package com.ethercd.mysticalagriexpansion.crop;

import com.blakebr0.cucumber.helper.RecipeHelper;
import com.blakebr0.mysticalagriculture.blocks.crop.BlockMysticalCrop;
import com.ethercd.mysticalagriexpansion.block.BlockCrop;
import com.ethercd.mysticalagriexpansion.item.ItemCrafting;
import com.ethercd.mysticalagriexpansion.item.ItemSeed;
import com.ethercd.mysticalagriexpansion.item.ModItem;
import com.ethercd.mysticalagriexpansion.lib.ModChecker;
import com.ethercd.mysticalagriexpansion.lib.ModMetaPart;
import com.ethercd.mysticalagriexpansion.lib.ModParts;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class ModNuclearCrops {
    public static NuclearCrop cropFossilPlutonium;
    public static NuclearCrop cropFossilAmericium;
    public static NuclearCrop cropFossilNeptunium;
    public static NuclearCrop cropFossilCurium;
    public static NuclearCrop cropFossilCalifornium;
    public static NuclearCrop cropFossilMendelevium;
    public static NuclearCrop cropFossilBerkelium;
    public static NuclearCrop cropFossilEinsteinium;
    public static NuclearCrop cropPlutonium;
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
        cropFossilPlutonium = new NuclearCrop("fossil_plutonium", 4, 3, 3, ModChecker.INDUSTRIAL_UPGRADE, ModMetaPart.IU_NUCLEAR);
        cropFossilAmericium = new NuclearCrop("fossil_americium", 4, 0, 0, ModChecker.INDUSTRIAL_UPGRADE, ModMetaPart.IU_RADIATION);
        cropFossilNeptunium = new NuclearCrop("fossil_neptunium", 4, 1, 1, ModChecker.INDUSTRIAL_UPGRADE, ModMetaPart.IU_RADIATION);
        cropFossilCurium = new NuclearCrop("fossil_curium", 5, 2, 2, ModChecker.INDUSTRIAL_UPGRADE, ModMetaPart.IU_RADIATION);
        cropFossilCalifornium = new NuclearCrop("fossil_californium", 5, 3, 3, ModChecker.INDUSTRIAL_UPGRADE, ModMetaPart.IU_RADIATION);
        cropFossilMendelevium = new NuclearCrop("fossil_mendelevium", 5, 4, 4, ModChecker.INDUSTRIAL_UPGRADE, ModMetaPart.IU_RADIATION);
        cropFossilBerkelium = new NuclearCrop("fossil_berkelium", 4, 5, 5, ModChecker.INDUSTRIAL_UPGRADE, ModMetaPart.IU_RADIATION);
        cropFossilEinsteinium = new NuclearCrop("fossil_einsteinium", 5, 6, 6, ModChecker.INDUSTRIAL_UPGRADE, ModMetaPart.IU_RADIATION);
        cropPlutonium = new NuclearCrop("plutonium", 4, 3, 7, ModChecker.INDUSTRIAL_CRAFT_2, ModMetaPart.IC2_NUCLEAR);
        if (!ModChecker.NUCLEAR_CRAFT) {
            cropUranium235 = new NuclearCrop("uranium_235", 3, 1, 5, ModChecker.INDUSTRIAL_CRAFT_2, ModMetaPart.IC2_NUCLEAR);
        } else {
            cropUranium235 = new NuclearCrop("uranium_235", 3, 4, 6, ModChecker.NUCLEAR_CRAFT, ModMetaPart.NC_URANIUM);
        }
        cropUranium233 = new NuclearCrop("uranium_233", 4, 0, 2, ModChecker.NUCLEAR_CRAFT, ModMetaPart.NC_URANIUM);
        cropThorium230 = new NuclearCrop("thorium_230", 4, 0, 2, ModChecker.NUCLEAR_CRAFT, ModMetaPart.NC_THROIUM);
        cropThorium232 = new NuclearCrop("thorium_232", 2, 4, 6, ModChecker.NUCLEAR_CRAFT, ModMetaPart.NC_THROIUM);
        cropPlutonium238 = new NuclearCrop("plutonium_238", 5, 0, 2, ModChecker.NUCLEAR_CRAFT, ModMetaPart.NC_PLUTONIUM);
        cropPlutonium239 = new NuclearCrop("plutonium_239", 4, 4, 6, ModChecker.NUCLEAR_CRAFT, ModMetaPart.NC_PLUTONIUM);
        cropPlutonium241 = new NuclearCrop("plutonium_241", 5, 8, 10, ModChecker.NUCLEAR_CRAFT, ModMetaPart.NC_PLUTONIUM);
        cropPlutonium242 = new NuclearCrop("plutonium_242", 3, 12, 14, ModChecker.NUCLEAR_CRAFT, ModMetaPart.NC_PLUTONIUM);
        cropNeptunium236 = new NuclearCrop("neptunium_236", 4, 0, 2, ModChecker.NUCLEAR_CRAFT, ModMetaPart.NC_NEPTUNIUM);
        cropNeptunium237 = new NuclearCrop("neptunium_237", 3, 4, 6, ModChecker.NUCLEAR_CRAFT, ModMetaPart.NC_NEPTUNIUM);
        cropAmericium241 = new NuclearCrop("americium_241", 4, 0, 2, ModChecker.NUCLEAR_CRAFT, ModMetaPart.NC_AMERICIUM);
        cropAmericium242 = new NuclearCrop("americium_242", 5, 4, 6, ModChecker.NUCLEAR_CRAFT, ModMetaPart.NC_AMERICIUM);
        cropAmericium243 = new NuclearCrop("americium_243", 4, 8, 10, ModChecker.NUCLEAR_CRAFT, ModMetaPart.NC_AMERICIUM);
        cropCurium243 = new NuclearCrop("curium_243", 5, 0, 2, ModChecker.NUCLEAR_CRAFT, ModMetaPart.NC_CURIUM);
        cropCurium245 = new NuclearCrop("curium_245", 4, 4, 6, ModChecker.NUCLEAR_CRAFT, ModMetaPart.NC_CURIUM);
        cropCurium246 = new NuclearCrop("curium_246", 4, 8, 10, ModChecker.NUCLEAR_CRAFT, ModMetaPart.NC_CURIUM);
        cropCurium247 = new NuclearCrop("curium_247", 3, 12, 14, ModChecker.NUCLEAR_CRAFT, ModMetaPart.NC_CURIUM);
        cropBerkelium247 = new NuclearCrop("berkelium_247", 4, 0, 2, ModChecker.NUCLEAR_CRAFT, ModMetaPart.NC_BERKELIUM);
        cropBerkelium248 = new NuclearCrop("berkelium_248", 4, 4, 6, ModChecker.NUCLEAR_CRAFT, ModMetaPart.NC_BERKELIUM);
        cropCalifornium249 = new NuclearCrop("californium_249", 4, 0, 2, ModChecker.NUCLEAR_CRAFT, ModMetaPart.NC_CALIFORNIUM);
        cropCalifornium250 = new NuclearCrop("californium_250", 5, 4, 6, ModChecker.NUCLEAR_CRAFT, ModMetaPart.NC_CALIFORNIUM);
        cropCalifornium251 = new NuclearCrop("californium_251", 4, 8, 10, ModChecker.NUCLEAR_CRAFT, ModMetaPart.NC_CALIFORNIUM);
        cropCalifornium252 = new NuclearCrop("californium_252", 5, 12, 14, ModChecker.NUCLEAR_CRAFT, ModMetaPart.NC_CALIFORNIUM);
    }

    public static void initRecipes() {
        for (NuclearCrop nc : NUCLEAR_CROPS_LIST) {
            nc.initRecipes();
        }
    }
}