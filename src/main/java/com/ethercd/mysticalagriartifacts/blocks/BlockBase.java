package com.ethercd.mysticalagriartifacts.blocks;

import com.ethercd.mysticalagriartifacts.MysticalAgrArtifacts;
import com.ethercd.mysticalagriartifacts.items.ModItems;
import com.ethercd.mysticalagriartifacts.utils.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHasModel {
    public BlockBase(String name, Material material, SoundType sound, float hardness, float resistance, String tool, int level) {
        super(material);
        this.setCreativeTab(MysticalAgrArtifacts.CREATIVE_TAB);
        this.setSoundType(sound);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setHardness(hardness);
        this.setResistance(resistance);
        this.setHarvestLevel(tool, level);
        ModBlocks.BLOCKS_MODEL_REGISTER.add(this);
        ModItems.ITEM_MODEL_REGISTER.add(new ItemBlock(this).setRegistryName(MysticalAgrArtifacts.MOD_ID, name));
    }

    public BlockBase(String name, Material material, SoundType sound, float hardness, float resistance) {
        super(material);
        this.setCreativeTab(MysticalAgrArtifacts.CREATIVE_TAB);
        this.setSoundType(sound);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setHardness(hardness);
        this.setResistance(resistance);
        ModBlocks.BLOCKS_MODEL_REGISTER.add(this);
        ModItems.ITEM_MODEL_REGISTER.add(new ItemBlock(this).setRegistryName(MysticalAgrArtifacts.MOD_ID, name));
    }
}
