package com.ethercd.mysticalagriexpansion.block.mutagenesis;

import com.ethercd.mysticalagriexpansion.te.mutagenesis.TileSupremiumMutagenesisProcessor;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BlockSupremiumMutagenesisProcessor extends BlockMutagenesisProcessor {
    public BlockSupremiumMutagenesisProcessor() {
        super("supremium_mutagenesis_processor", 5);
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileSupremiumMutagenesisProcessor();
    }
}
