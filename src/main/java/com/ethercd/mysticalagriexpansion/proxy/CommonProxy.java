package com.ethercd.mysticalagriexpansion.proxy;


import com.blakebr0.cucumber.registry.ModRegistry;
import com.ethercd.mysticalagriexpansion.block.ModBlocks;
import com.ethercd.mysticalagriexpansion.integration.nuclearcraft.ModRadSources;
import com.ethercd.mysticalagriexpansion.item.ModItems;
import com.ethercd.mysticalagriexpansion.lib.ModChecker;
import com.ethercd.mysticalagriexpansion.lib.ModParts;
import com.ethercd.mysticalagriexpansion.recipes.ModRecipes;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {
        ModItems.init();
        ModBlocks.init();
//        if (ModChecker.NUCLEAR_CRAFT)
//            ModRadSources.init();
    }

    public void init(FMLInitializationEvent event) {
        ModParts.init();
//        ModRecipes.init();
    }

    public void postInit(FMLPostInitializationEvent event) {

    }
}
