package com.ethercd.mysticalagriexpansion;

import com.blakebr0.cucumber.registry.ModRegistry;
import com.ethercd.mysticalagriexpansion.item.ItemCrafting;
import com.ethercd.mysticalagriexpansion.proxy.CommonProxy;
import com.ethercd.mysticalagriexpansion.utils.ModInstanceItem;
import com.ethercd.mysticalagriexpansion.utils.ModInstanceItemContainer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.util.logging.Logger;

@net.minecraftforge.fml.common.Mod(modid = Mod.MOD_ID, name = Mod.NAME, version = Mod.VERSION)
public class Mod
{
    public static final String MOD_ID = "mysticalagriexpansion";
    public static final String NAME = "Mystical Agriexpansion";
    public static final String VERSION = "0.2.6";
    public static final ModRegistry REGISTRY = ModRegistry.create(MOD_ID);
    @net.minecraftforge.fml.common.Mod.Instance(MOD_ID)
    public static Mod instance;
    @SidedProxy(clientSide = "com.ethercd.mysticalagriexpansion.proxy.ClientProxy", serverSide = "com.ethercd.mysticalagriexpansion.proxy.CoreProxy")
    public static CommonProxy proxy;

    private static Logger logger;

    @net.minecraftforge.fml.common.Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @net.minecraftforge.fml.common.Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
        logger.log("MysticalAgriexpansion was loadding");
    }

    @net.minecraftforge.fml.common.Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

    public static CreativeTabs CREATIVE_TAB = new CreativeTabs(MOD_ID) {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(ItemCrafting.EXEMPLARY_GEAR.getItem(), 1, 0);
        }
    };
    public static CreativeTabs CREATIVE_TAB_NUCLEAR = new CreativeTabs(MOD_ID + "_nuclear") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(ItemCrafting.NUCLEAR_SEEDS.getItem(), 1, 0);
        }
    };
    public static CreativeTabs CREATIVE_TAB_ALLOY = new CreativeTabs(MOD_ID + "_alloy") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(ItemCrafting.ALLOY_SEEDS.getItem(), 1, 0);
        }
    };
    public static CreativeTabs CREATIVE_TAB_ELECTRONIC = new CreativeTabs(MOD_ID + "_electronic") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(ItemCrafting.ELECTRONIC_SEEDS.getItem(), 1, 0);
        }
    };
}
