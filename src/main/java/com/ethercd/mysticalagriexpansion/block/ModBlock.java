package com.ethercd.mysticalagriexpansion.block;

import com.ethercd.mysticalagriexpansion.MACreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

@SuppressWarnings({ "unused" })
public class ModBlock extends Block {
    public ModBlock(String name, Material material, SoundType sound, float hardness, float resistance) {
        super(material);
        this.setCreativeTab(MACreativeTabs.CREATIVE_TAB);
        this.setSoundType(sound);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setHardness(hardness);
        this.setResistance(resistance);
    }

    public ModBlock(String name, Material material, SoundType sound, float hardness, float resistance, String tool, int level) {
        this(name, material, sound, hardness, resistance);
        this.setHarvestLevel(tool, level);
    }
}
