package com.ethercd.mysticalagriexpansion.crop;

import com.blakebr0.cucumber.helper.RecipeHelper;
import com.blakebr0.mysticalagriculture.blocks.crop.BlockMysticalCrop;
import com.ethercd.mysticalagriexpansion.block.BlockCrop;
import com.ethercd.mysticalagriexpansion.item.ItemCrafting;
import com.ethercd.mysticalagriexpansion.item.ItemSeed;
import com.ethercd.mysticalagriexpansion.item.ModItem;
import com.ethercd.mysticalagriexpansion.lib.ModChecker;
import com.ethercd.mysticalagriexpansion.lib.ModParts;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraftforge.oredict.OreDictionary;

public enum ModAlloyCrop implements IStringSerializable {
    // Nuclear Craft Alloy
//    MAGNESIUM_DIBORIDE("MagnesiumDiboride", 5),
//    MANGANESE_DIOXIDE("ManganeseDioxide", 5),
//    THERMOCONDUCTING("Thermoconducting", 5),
//    SILOCON_CARBIDE("SiliconCarbide", 5),
//    HARD_CARBON("HardCarbon", 5),
//    FERROBORON("Ferroboron", 5),
//    HSLA_STEEL("HslaSteel", 5),
//    TIN_SILVER("TinSilver", 5),
//    SHIBUICHI("Shibuichi", 5),
//    ZIRCALOY("Zircaloy", 5),
//    EXTREME("Extreme", 5),
//    TOUGH("Tough", 5),
    ;

    private final String name;
    private final boolean enabled;
    private final BlockCrop plant;
    private final int tier;
    private final ModItem crop;
    private final ItemSeed seed;

    private ItemStack materialIn;
    private ItemStack materialOut;

    ModAlloyCrop(String ore, int tier) {
        this.name = ore.substring(0, 1).toLowerCase() + ore.substring(1);
        this.enabled = (!OreDictionary.getOres("ingot" + ore, false).isEmpty());
        this.plant = new BlockCrop(getName() + "_crop");
        this.tier = tier;
        this.crop = new ModItem(getName() + "_essence");
        this.seed = new ItemSeed(getName() + "_seeds", getPlant(), this.getTier());
        if (this.enabled) {
            this.plant.setCrop(crop);
            this.plant.setSeed(seed);
            this.materialIn = OreDictionary.getOres("ingot" + ore, false).get(0);
            this.materialOut = OreDictionary.getOres("ingot" + ore, false).get(0);
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

    public void initRecipes() {
        if (this.enabled) {
            RecipeHelper.addShapedRecipe(this.materialOut,
                    "EEE",
                    "EEE",
                    "EEE",
                    'E',
                    new ItemStack(this.crop,
                            1,
                            0));

            ItemStack tierInferiumEssence;
            ItemStack tierCraftingSeeds;

            switch (this.tier) {
                default:
                case 1:
                    tierInferiumEssence = ModParts.itemTier1Essence;
                    tierCraftingSeeds = new ItemStack(ItemCrafting.TIER_1_NUCLEAR_SEEDS.getItem(), 1, 0);
                    break;
                case 2:
                    tierInferiumEssence = ModParts.itemTier2Essence;
                    tierCraftingSeeds = new ItemStack(ItemCrafting.TIER_2_NUCLEAR_SEEDS.getItem(), 1, 0);
                    break;
                case 3:
                    tierInferiumEssence = ModParts.itemTier3Essence;
                    tierCraftingSeeds = new ItemStack(ItemCrafting.TIER_3_NUCLEAR_SEEDS.getItem(), 1, 0);
                    break;
                case 4:
                    tierInferiumEssence = ModParts.itemTier4Essence;
                    tierCraftingSeeds = new ItemStack(ItemCrafting.TIER_4_NUCLEAR_SEEDS.getItem(), 1, 0);
                    break;
                case 5:
                    tierInferiumEssence = ModParts.itemTier5Essence;
                    tierCraftingSeeds = new ItemStack(ItemCrafting.TIER_5_NUCLEAR_SEEDS.getItem(), 1, 0);
                    break;
            }

            RecipeHelper.addShapedRecipe(new ItemStack(this.seed, 1, 0),
                    "PEP",
                    "ECE",
                    "PEP",
                    'P',
                    this.materialIn,
                    'E',
                    tierInferiumEssence,
                    'C',
                    tierCraftingSeeds);
        }
    }
}
