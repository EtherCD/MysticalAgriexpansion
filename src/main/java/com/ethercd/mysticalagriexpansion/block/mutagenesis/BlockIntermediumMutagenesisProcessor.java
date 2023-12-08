package com.ethercd.mysticalagriexpansion.block.mutagenesis;

import com.ethercd.mysticalagriexpansion.te.mutagenesis.TileIntermediumMutagenesisProcessor;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BlockIntermediumMutagenesisProcessor extends BlockMutagenesisProcessor {
    public BlockIntermediumMutagenesisProcessor() {
        super("intermedium_mutagenesis_processor", 3);
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileIntermediumMutagenesisProcessor();
    }
}
