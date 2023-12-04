package com.ethercd.mysticalagriexpansion.gui;

import com.ethercd.mysticalagriexpansion.te.mutagenesis.TileEntityMutagenesisProcessor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {
    public static final int MUTAGENESIS_PROCESSOR = 0;

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tile = world.getTileEntity(new BlockPos(x, y, z));

        if (ID == MUTAGENESIS_PROCESSOR) {
            return new GuiMutagenesisProcessor(player.inventory, (TileEntityMutagenesisProcessor) tile);
        }

        return null;
    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tile = world.getTileEntity(new BlockPos(x, y, z));

        if (ID == MUTAGENESIS_PROCESSOR) {
            return new ContainerMutagenesisProcessor(player.inventory, (TileEntityMutagenesisProcessor) tile);
        }

        return null;
    }
}
