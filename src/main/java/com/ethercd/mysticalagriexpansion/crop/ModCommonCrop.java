package com.ethercd.mysticalagriexpansion.crop;

import com.blakebr0.mysticalagriculture.blocks.crop.BlockMysticalCrop;
import com.ethercd.mysticalagriexpansion.block.BlockCrop;
import com.ethercd.mysticalagriexpansion.item.ItemSeed;
import com.ethercd.mysticalagriexpansion.item.ModItem;
import net.minecraft.util.IStringSerializable;


public enum ModCommonCrop implements IStringSerializable {
    PROSPERITY("prosperity", 5, true),
    MECHANICAL("mechanical", 4, true)
    ;

    private final String name;
    private final boolean enabled;
    private final BlockCrop plant;
    private final int tier;
    private final ModItem crop;
    private final ItemSeed seed;

    ModCommonCrop(String name, int tier, boolean enabled) {
        this.name = name;
        this.enabled = enabled;
        this.plant = new BlockCrop(getName() + "_crop");
        this.tier = tier;
        this.crop = new ModItem(getName() + "_essence");
        this.seed = new ItemSeed(getName() + "_seeds", getPlant(), this.getTier());
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

    public ModItem getCrop() {
        return this.crop;
    }

    public ItemSeed getSeed() {
        return this.seed;
    }
}
