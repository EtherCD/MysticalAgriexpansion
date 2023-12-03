package com.ethercd.mysticalagriexpansion.lib;

import com.blakebr0.mysticalagriculture.lib.Parts;
import net.minecraft.item.Item;

@SuppressWarnings({"unused", "CallToPrintStackTrace"})
public enum ModMetaPart {
    IC2_NUCLEAR("ic2:nuclear", ModChecker.INDUSTRIAL_CRAFT_2),
    NC_URANIUM("nuclearcraft:uranium", ModChecker.NUCLEAR_CRAFT),
    NC_THROIUM("nuclearcraft:thorium", ModChecker.NUCLEAR_CRAFT),
    NC_PLUTONIUM("nuclearcraft:plutonium", ModChecker.NUCLEAR_CRAFT),
    NC_NEPTUNIUM("nuclearcraft:neptunium", ModChecker.NUCLEAR_CRAFT),
    NC_AMERICIUM("nuclearcraft:americium", ModChecker.NUCLEAR_CRAFT),
    NC_CURIUM("nuclearcraft:curium", ModChecker.NUCLEAR_CRAFT),
    NC_BERKELIUM("nuclearcraft:berkelium", ModChecker.NUCLEAR_CRAFT),
    NC_CALIFORNIUM("nuclearcraft:californium", ModChecker.NUCLEAR_CRAFT),
    NC_ALLOY("nuclearcraft:alloy", ModChecker.NUCLEAR_CRAFT),
    IU_NUCLEAR("industrialupgrade:nuclearresource", ModChecker.INDUSTRIAL_UPGRADE),
    IU_RADIATION("industrialupgrade:radiationresources", ModChecker.INDUSTRIAL_UPGRADE),
    IU_ALLOY("industrialupgrade:alloyingot", ModChecker.INDUSTRIAL_UPGRADE),
    IU_INGOTS("industrialupgrade:itemingots", ModChecker.INDUSTRIAL_UPGRADE),
    IU_THORIUM("industrialupgrade:toryi", ModChecker.INDUSTRIAL_UPGRADE),
    IU_PROTON("industrialupgrade:proton", ModChecker.INDUSTRIAL_UPGRADE)
    ;

    private final String name;
    private final boolean active;
    private boolean loaded;
    private Item item;

    ModMetaPart(String name, boolean active) {
        this.name = name;
        this.active = active;
        this.loaded = false;
    }

    public Item getItem() {
        return this.item;
    }

    public boolean isLoaded() {
        return this.loaded;
    }

    public static void init() {
        for (ModMetaPart part : ModMetaPart.values()) {
            part.load();
        }
    }

    public void load() {
        if (this.active) {
            try {
                this.item = Parts.getItem(name);
                this.loaded = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
