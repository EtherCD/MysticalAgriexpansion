package com.ethercd.mysticalagriexpansion;

import com.blakebr0.cucumber.registry.ModRegistry;
import com.ethercd.mysticalagriexpansion.proxy.CommonProxy;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@SuppressWarnings({"unused"})
@net.minecraftforge.fml.common.Mod(modid = MysticalAgriexpansion.MOD_ID, name = MysticalAgriexpansion.NAME, version = MysticalAgriexpansion.VERSION)
public class MysticalAgriexpansion
{
    public static final String MOD_ID = "mysticalagriexpansion";
    public static final String NAME = "Mystical Agriexpansion";
    public static final String VERSION = "0.3.5";
    public static final ModRegistry REGISTRY = ModRegistry.create(MOD_ID);
    @net.minecraftforge.fml.common.Mod.Instance(MOD_ID)
    public static MysticalAgriexpansion instance;
    @SidedProxy(clientSide = "com.ethercd.mysticalagriexpansion.proxy.ClientProxy", serverSide = "com.ethercd.mysticalagriexpansion.proxy.CommonProxy")
    public static CommonProxy proxy;

    @net.minecraftforge.fml.common.Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    public static Logger log;

    @net.minecraftforge.fml.common.Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @net.minecraftforge.fml.common.Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}
