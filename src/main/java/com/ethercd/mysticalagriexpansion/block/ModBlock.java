package com.ethercd.mysticalagriexpansion.block;

import com.ethercd.mysticalagriexpansion.Mod;
import com.ethercd.mysticalagriexpansion.item.ModItems;
import com.ethercd.mysticalagriexpansion.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;

public class ModBlock extends Block implements IHasModel {
    public ModBlock(String name, Material material, SoundType sound, float hardness, float resistance, String tool, int level) {
        super(material);
        this.setCreativeTab(Mod.CREATIVE_TAB);
        this.setSoundType(sound);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setHardness(hardness);
        this.setResistance(resistance);
        this.setHarvestLevel(tool, level);
        ModBlocks.BLOCKS_MODEL_REGISTER.add(this);
        ModItems.ITEM_MODEL_REGISTER.add(new ItemBlock(this).setRegistryName(Mod.MOD_ID, name));
    }

    public ModBlock(String name, Material material, SoundType sound, float hardness, float resistance) {
        super(material);
        this.setCreativeTab(Mod.CREATIVE_TAB);
        this.setSoundType(sound);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setHardness(hardness);
        this.setResistance(resistance);
        ModBlocks.BLOCKS_MODEL_REGISTER.add(this);
        ModItems.ITEM_MODEL_REGISTER.add(new ItemBlock(this).setRegistryName(Mod.MOD_ID, name));
    }
}
