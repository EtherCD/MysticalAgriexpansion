package com.ethercd.mysticalagriexpansion.proxy;


import com.ethercd.mysticalagriexpansion.block.ModBlocks;
import com.ethercd.mysticalagriexpansion.crop.ModCrops;
import com.ethercd.mysticalagriexpansion.item.ModItems;
import com.ethercd.mysticalagriexpansion.lib.ModParts;
import com.ethercd.mysticalagriexpansion.recipes.ModRecipes;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {
        ModCrops.register();
        ModItems.register();
        ModBlocks.register();
//        if (ModChecker.NUCLEAR_CRAFT)
//            ModRadSources.init();
    }

    public void init(FMLInitializationEvent event) {
        ModParts.init();
        ModRecipes.register();
    }

    public void postInit(FMLPostInitializationEvent event) {

    }
}
