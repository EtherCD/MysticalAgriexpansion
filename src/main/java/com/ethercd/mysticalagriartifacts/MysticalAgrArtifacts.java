package com.ethercd.mysticalagriartifacts;

import com.blakebr0.cucumber.registry.ModRegistry;
import com.ethercd.mysticalagriartifacts.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = MysticalAgrArtifacts.MOD_ID, name = MysticalAgrArtifacts.NAME, version = MysticalAgrArtifacts.VERSION, dependencies = MysticalAgrArtifacts.DEPENDENCIES)
public class MysticalAgrArtifacts
{
    public static final String MOD_ID = "mysticalagriartifacts";
    public static final String NAME = "Mystical AgriArtifacts";
    public static final String VERSION = "0.2.2";

    public static final String DEPENDENCIES = "required-after:mysticalagriculture@[1.7.5,);required-after:cucumber@[1.1.2,);";

    public static final ModRegistry REGISTRY = ModRegistry.create(MOD_ID);

    public static final CreativeTabs CREATIVE_TAB = new MAACreativeTab();

    @Mod.Instance(MOD_ID)
    public static MysticalAgrArtifacts instance;

    @SidedProxy(clientSide = "com.ethercd.mysticalagriartifacts.proxy.ClientProxy", serverSide = "com.ethercd.mysticalagriartifacts.proxy.ServerProxy")
    public static CommonProxy proxy;

    private static Logger logger;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}
