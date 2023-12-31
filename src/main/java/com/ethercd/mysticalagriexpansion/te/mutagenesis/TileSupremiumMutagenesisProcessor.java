package com.ethercd.mysticalagriexpansion.te.mutagenesis;

import com.blakebr0.cucumber.util.VanillaPacketDispatcher;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;

@SuppressWarnings("NullableProblems")
public class TileSupremiumMutagenesisProcessor extends TileEntityMutagenesisProcessor{
    @Override
    public int getOperationTime() {
        return 150;
    }

    @Override
    public float getChanceMultiplier() {
        return 2f;
    }

    @Override
    public void markDirty() {
        super.markDirty();
        VanillaPacketDispatcher.dispatchTEToNearbyPlayers(this);
    }

    @Override
    public SPacketUpdateTileEntity getUpdatePacket() {
        return new SPacketUpdateTileEntity(this.getPos(), -1, this.getUpdateTag());
    }

    @Override
    public void onDataPacket(NetworkManager manager, SPacketUpdateTileEntity packet) {
        this.readFromNBT(packet.getNbtCompound());
    }

    @Override
    public final NBTTagCompound getUpdateTag() {
        return this.writeToNBT(new NBTTagCompound());
    }
}
