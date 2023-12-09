package com.ethercd.mysticalagriexpansion.config;

import com.ethercd.mysticalagriexpansion.MysticalAgriexpansion;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ModConfig {
    public static Configuration config;
    public static ModConfig instance;

    public static boolean nuclearCropsActive;
    public static boolean alloyCropsActive;
    public static boolean electicalCropsActive;

    public static boolean integrationIU;
    public static boolean integrationNC;
    public static boolean integrationIC2;
    public static boolean integrationMAg;

    public static boolean integrationRadiantionNC;

    public static boolean growthAcceleratorActive;

    @SubscribeEvent
    public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equals(MysticalAgriexpansion.MOD_ID)) {
            ModConfig.syncConfig();
        }
    }

    public static void init(File file) {
        config = new Configuration(file);
        syncConfig();
    }

    public static void syncConfig() {
        String category;

        category = "Integrations";
        config.addCustomCategoryComment(category, "Controlling all mod integrations");
        nuclearCropsActive = config.getBoolean("nuclear_crops_active", category, true, "Integration with nuclear crops");
        alloyCropsActive = config.getBoolean("alloy_crops_active", category, true, "Integration with alloy crops");
        electicalCropsActive = config.getBoolean("electronic_crops_active", category, true, "Integration with electronic crops");

        integrationIU = config.getBoolean("integration_iu", category, true, "Integration with Industrial Upgrade");
        integrationNC = config.getBoolean("integration_nc", category, true, "Integration with Nuclear Craft");
        integrationIC2 = config.getBoolean("integration_ic2", category, true, "Integration with Industrial Craft 2");
        integrationMAg = config.getBoolean("integration_mag", category, true, "Integration with Mystical Agradditions");

        integrationRadiantionNC = config.getBoolean("integration_radiation_nc", category, true, "Integration with Nuclear Craft Radiation");

        growthAcceleratorActive = config.getBoolean("growth_accelerators", category, true, "Growth Accelerator tiers");

        if (config.hasChanged()) {
            config.save();
        }
    }

}
