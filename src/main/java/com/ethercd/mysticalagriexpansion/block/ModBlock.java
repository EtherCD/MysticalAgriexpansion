package com.ethercd.mysticalagriexpansion.block;

import com.ethercd.mysticalagriexpansion.Mod;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;

public class ModBlock extends Block {
    public ModBlock(String name, Material material, SoundType sound, float hardness, float resistance, boolean active) {
        super(material);
        this.setCreativeTab(Mod.CREATIVE_TAB);
        this.setSoundType(sound);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setHardness(hardness);
        this.setResistance(resistance);
        ModBlocks.add(this, name);
    }

    public ModBlock(String name, Material material, SoundType sound, float hardness, float resistance, String tool, int level, boolean active) {
        this(name, material, sound, hardness, resistance, active);
        this.setHarvestLevel(tool, level);
    }
}
