package com.ethercd.mysticalagriexpansion;

import com.blakebr0.cucumber.registry.ModRegistry;
import com.ethercd.mysticalagriexpansion.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@net.minecraftforge.fml.common.Mod(modid = Mod.MOD_ID, name = Mod.NAME, version = Mod.VERSION)
public class Mod
{
    public static final String MOD_ID = "mysticalagriexpansion";
    public static final String NAME = "Mystical Agriexpansion";
    public static final String VERSION = "0.2.4";
    public static final ModRegistry REGISTRY = ModRegistry.create(MOD_ID);
    public static final CreativeTabs CREATIVE_TAB = new CreativeTab();
    @net.minecraftforge.fml.common.Mod.Instance(MOD_ID)
    public static Mod instance;
    @SidedProxy(clientSide = "com.ethercd.mysticalagricultureexpansion.proxy.ClientProxy", serverSide = "com.ethercd.mysticalagricultureexpansion.proxy.CoreProxy")
    public static CommonProxy proxy;

    private static Logger logger;

    @net.minecraftforge.fml.common.Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @net.minecraftforge.fml.common.Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @net.minecraftforge.fml.common.Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}
