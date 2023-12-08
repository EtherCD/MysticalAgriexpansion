package com.ethercd.mysticalagriexpansion.block.mutagenesis;

import com.ethercd.mysticalagriexpansion.te.mutagenesis.TileInsaniumMutagenesisProcessor;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BlockInsaniumMutagenesisProcessor extends BlockMutagenesisProcessor {
    public BlockInsaniumMutagenesisProcessor() {
        super("insanium_mutagenesis_processor", 6);
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileInsaniumMutagenesisProcessor();
    }
}
