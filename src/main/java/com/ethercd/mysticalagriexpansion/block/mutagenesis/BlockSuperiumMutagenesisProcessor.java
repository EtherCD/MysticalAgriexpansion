package com.ethercd.mysticalagriexpansion.block.mutagenesis;

import com.ethercd.mysticalagriexpansion.te.mutagenesis.TileSuperiumMutagenesisProcessor;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BlockSuperiumMutagenesisProcessor extends BlockMutagenesisProcessor {
    public BlockSuperiumMutagenesisProcessor() {
        super("superium_mutagenesis_processor", 4);
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileSuperiumMutagenesisProcessor();
    }
}
