package com.ethercd.mysticalagriexpansion.crop;

import com.blakebr0.mysticalagriculture.blocks.crop.BlockMysticalCrop;
import com.ethercd.mysticalagriexpansion.block.BlockCrop;
import com.ethercd.mysticalagriexpansion.item.ItemSeed;
import com.ethercd.mysticalagriexpansion.item.ModItem;
import com.ethercd.mysticalagriexpansion.lib.ModChecker;
import net.minecraft.util.IStringSerializable;


public enum ModCommonCrop implements IStringSerializable {
    PROSPERITY("prosperity", 5, true),
    MECHANICAL("mechanical", 5, true),
    BERYLLIUM("beryllium", 4, ModChecker.BERYLLIUM),
    ZIRCONIUM("zirconium", 4, ModChecker.ZIRCONIUM),
    PROTON("proton", 5, ModChecker.INDUSTRIAL_UPGRADE),
    THORIUM("thorium", 4, ModChecker.INDUSTRIAL_UPGRADE),
    MICHALOV("michalov", 4, ModChecker.MICHALOV),
    VANADIUM("vanadium", 4, ModChecker.VANADIUM),
    CARAVKY("caravky", 5, ModChecker.CARAVKY),
    CHROMIUM("chromium", 5, ModChecker.CHROMIUM),
    SPINEL("spinel", 4, ModChecker.SPINEL),
    GERMANIUM("germanium", 4, ModChecker.GERMANIUM),
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
