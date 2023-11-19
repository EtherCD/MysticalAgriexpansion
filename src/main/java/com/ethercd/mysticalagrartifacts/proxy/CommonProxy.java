package com.ethercd.mysticalagrartifacts.proxy;


import com.ethercd.mysticalagrartifacts.blocks.ModBlocks;
import com.ethercd.mysticalagrartifacts.items.ModItems;
import com.ethercd.mysticalagrartifacts.crafting.ModRecipes;
import com.ethercd.mysticalagrartifacts.lib.ModParts;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {
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
