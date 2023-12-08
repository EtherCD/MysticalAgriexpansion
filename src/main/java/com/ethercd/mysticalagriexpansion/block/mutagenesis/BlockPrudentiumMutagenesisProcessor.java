package com.ethercd.mysticalagriexpansion.block.mutagenesis;

import com.ethercd.mysticalagriexpansion.te.mutagenesis.TilePrudentiumMutagenesisProcessor;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BlockPrudentiumMutagenesisProcessor extends BlockMutagenesisProcessor {
    public BlockPrudentiumMutagenesisProcessor() {
        super("prudentium_mutagenesis_processor", 2);
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TilePrudentiumMutagenesisProcessor();
    }
}
