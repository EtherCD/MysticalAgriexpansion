package com.ethercd.mysticalagriexpansion.crop;

import com.blakebr0.cucumber.helper.RecipeHelper;
import com.blakebr0.mysticalagriculture.blocks.crop.BlockMysticalCrop;
import com.ethercd.mysticalagriexpansion.block.BlockCrop;
import com.ethercd.mysticalagriexpansion.item.ItemCrafting;
import com.ethercd.mysticalagriexpansion.item.ItemSeed;
import com.ethercd.mysticalagriexpansion.item.ModItem;
import com.ethercd.mysticalagriexpansion.lib.ModMetaPart;
import com.ethercd.mysticalagriexpansion.lib.ModParts;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class NuclearCrop {
    private final String name;
    private final boolean enabled;
    private final BlockCrop plant;
    private final int tier;
    private final ModItem crop;
    private final ItemSeed seed;

    private final int ingotMeta;
    private final int nuggetMeta;
    private final ModMetaPart metaItem;

    NuclearCrop(String name, int tier, int ingotMeta, int nuggetMeta, boolean enabled, ModMetaPart metaItem) {
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
        this.ingotMeta = ingotMeta;
        this.nuggetMeta = nuggetMeta;
        this.metaItem = metaItem;
        ModNuclearCrops.NUCLEAR_CROPS_LIST.add(this);
    }

    public ItemSeed getSeed() {
        return this.seed;
    }

    public ModItem getCrop() {
        return this.crop;
    }

    public String getName() {
        return this.name;
    }

    public int getTier() {
        return this.tier;
    }

    public BlockMysticalCrop getPlant() {
        return this.plant;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void initRecipes() {
        if (this.enabled && this.metaItem.isLoaded()) {
            Item metaItem = this.metaItem.getItem();

            ItemStack materialIn = new ItemStack(metaItem, 1, this.ingotMeta);
            ItemStack materialOut = new ItemStack(metaItem, 1, this.nuggetMeta);

            RecipeHelper.addShapedRecipe(materialOut,
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
                    materialIn,
                    'E',
                    tierInferiumEssence,
                    'C',
                    tierCraftingSeeds);
        }
    }
}