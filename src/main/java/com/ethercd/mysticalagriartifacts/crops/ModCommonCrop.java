package com.ethercd.mysticalagriartifacts.crops;

import com.blakebr0.mysticalagriculture.blocks.crop.BlockMysticalCrop;
import com.ethercd.mysticalagriartifacts.blocks.BlockCommonCrop;
import com.ethercd.mysticalagriartifacts.items.ItemBase;
import com.ethercd.mysticalagriartifacts.items.ItemCommonSeed;
import net.minecraft.util.IStringSerializable;


public enum ModCommonCrop implements IStringSerializable {
    PROSPERITY("prosperity", 5, true)
    ;

    private final String name;
    private final boolean enabled;
    private final BlockCommonCrop plant;
    private final int tier;
    private final ItemBase crop;
    private final ItemCommonSeed seed;

    ModCommonCrop(String name, int tier, boolean enabled) {
        this.name = name;
        this.enabled = enabled;
        this.plant = new BlockCommonCrop(getName() + "_crop");
        this.tier = tier;
        this.crop = new ItemBase(getName() + "_essence");
        this.seed = new ItemCommonSeed(getName() + "_seeds", getPlant(), this.getTier());
        if (this.enabled) {
            this.plant.setCrop(crop);
            this.plant.setSeed(seed);
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    public int getTier() {
        return this.tier;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public BlockMysticalCrop getPlant() {
        return this.plant;
    }

    public ItemBase getCrop() {
        return this.crop;
    }

    public ItemCommonSeed getSeed() {
        return this.seed;
    }
}
