package com.ethercd.mysticalagriexpansion.crop.alloy;

import com.blakebr0.cucumber.helper.RecipeHelper;
import com.blakebr0.mysticalagriculture.crafting.ReprocessorManager;
import com.ethercd.mysticalagriexpansion.MACreativeTabs;
import com.ethercd.mysticalagriexpansion.block.BlockCrop;
import com.ethercd.mysticalagriexpansion.block.ModBlocks;
import com.ethercd.mysticalagriexpansion.item.ItemCrafting;
import com.ethercd.mysticalagriexpansion.item.ItemSeed;
import com.ethercd.mysticalagriexpansion.item.ModItem;
import com.ethercd.mysticalagriexpansion.item.ModItems;
import com.ethercd.mysticalagriexpansion.lib.ModMetaPart;
import com.ethercd.mysticalagriexpansion.lib.ModParts;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

@SuppressWarnings({"unused"})
public class AlloyCrop {
    private final String name;
    private final boolean enabled;
    private final BlockCrop plant;
    private final int tier;
    private final ModItem crop;
    private final ItemSeed seed;

    private final int ingotMeta;
    private final int nuggetMeta;
    private final ModMetaPart metaItem;

    AlloyCrop(String name, int tier, int inMeta, int outMeta, boolean enabled, ModMetaPart metaItem) {
        this.name = name;
        this.enabled = enabled;
        this.plant = new BlockCrop(getName() + "_crop");
        this.tier = tier;
        this.crop = (ModItem) new ModItem(getName() + "_essence")
                .setCreativeTab(MACreativeTabs.CREATIVE_TAB_ALLOY);
        this.seed = (ItemSeed) new ItemSeed(getName() + "_seeds", getPlant(), this.getTier())
                .setCreativeTab(MACreativeTabs.CREATIVE_TAB_ALLOY);
        if (this.enabled) {
            this.plant.setCrop(crop);
            this.plant.setSeed(seed);
            AlloyCrops.ALLOY_CROP_LIST.add(this);
        }
        this.ingotMeta = inMeta;
        this.nuggetMeta = outMeta;
        this.metaItem = metaItem;
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

    public BlockCrop getPlant() {
        return this.plant;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void init() {
        if (this.enabled) {
            ModItems.add(this.seed, this.getName() + "_seeds");
            ModItems.add(this.crop, this.getName() + "_essence");
            ModBlocks.add(this.plant, this.getName() + "_crop");
        }
    }

    public void initRecipe() {
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
                    tierCraftingSeeds = new ItemStack(ItemCrafting.TIER_1_ALLOY_SEEDS.getItem(), 1, 0);
                    break;
                case 2:
                    tierInferiumEssence = ModParts.itemTier2Essence;
                    tierCraftingSeeds = new ItemStack(ItemCrafting.TIER_2_ALLOY_SEEDS.getItem(), 1, 0);
                    break;
                case 3:
                    tierInferiumEssence = ModParts.itemTier3Essence;
                    tierCraftingSeeds = new ItemStack(ItemCrafting.TIER_3_ALLOY_SEEDS.getItem(), 1, 0);
                    break;
                case 4:
                    tierInferiumEssence = ModParts.itemTier4Essence;
                    tierCraftingSeeds = new ItemStack(ItemCrafting.TIER_4_ALLOY_SEEDS.getItem(), 1, 0);
                    break;
                case 5:
                    tierInferiumEssence = ModParts.itemTier5Essence;
                    tierCraftingSeeds = new ItemStack(ItemCrafting.TIER_5_ALLOY_SEEDS.getItem(), 1, 0);
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
            ReprocessorManager.addRecipe(new ItemStack(this.seed, 1, 0), new ItemStack(this.crop, 1, 0));
        }
    }
}