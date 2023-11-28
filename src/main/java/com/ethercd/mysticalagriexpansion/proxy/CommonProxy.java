package com.ethercd.mysticalagriexpansion.proxy;


import com.ethercd.mysticalagriexpansion.block.ModBlocks;
import com.ethercd.mysticalagriexpansion.crop.ModNuclearCrops;
import com.ethercd.mysticalagriexpansion.item.ModItems;
import com.ethercd.mysticalagriexpansion.recipe.ModRecipes;
import com.ethercd.mysticalagriexpansion.lib.ModParts;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {
        ModNuclearCrops.init();
        ModBlocks.init();
        ModItems.init();
    }

    public void init(FMLInitializationEvent event) {
        ModParts.init();
        ModRecipes.init();
    }

    public void postInit(FMLPostInitializationEvent event) {

    }

    public void registerItemRenderer(Item item, int meta, String id) {

    }
}
