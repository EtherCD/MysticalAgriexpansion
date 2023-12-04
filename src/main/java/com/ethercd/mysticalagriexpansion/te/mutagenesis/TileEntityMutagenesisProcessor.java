package com.ethercd.mysticalagriexpansion.te.mutagenesis;


import com.blakebr0.cucumber.util.VanillaPacketDispatcher;
import com.blakebr0.mysticalagriculture.util.TileEntityUtil;
import com.ethercd.mysticalagriexpansion.recipes.MutagenesisProcessorManager;
import net.minecraft.client.renderer.texture.ITickable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.wrapper.SidedInvWrapper;

public abstract class TileEntityMutagenesisProcessor extends TileEntityUtil implements ISidedInventory, ITickable, ICapabilityProvider {
    private NonNullList<ItemStack> inventory = NonNullList.withSize(5, ItemStack.EMPTY);
    private int progress;
    private int packetCount;
    private boolean packet;

    @Override
    public NBTTagCompound writeCustomNBT(NBTTagCompound tag) {
        tag.setInteger("Progress", this.progress);

        ItemStackHelper.saveAllItems(tag, this.inventory);

        return tag;
    }

    @Override
    public void readCustomNBT(NBTTagCompound tag) {
        this.progress = tag.getInteger("Progress");

        ItemStackHelper.loadAllItems(tag, this.inventory);
    }

    public void update() {
        if (this.getWorld().isRemote)
            return;

        boolean mark = false;

        ItemStack input1 = this.getStackInSlot(0);
        ItemStack input2 = this.getStackInSlot(1);
        ItemStack output1 = this.getStackInSlot(2);
        ItemStack output2 = this.getStackInSlot(3);
        ItemStack output3 = this.getStackInSlot(4);

        if (!input1.isEmpty() && !input2.isEmpty()) {
            ItemStack recipeOutput = MutagenesisProcessorManager.processRecipe(input1, input2);

            if (!recipeOutput.isEmpty() && (output2.isEmpty() || output2.isItemEqual(input1)) && (output3.isEmpty() || output3.isItemEqual(input2))) {
                if (output1.isEmpty() || output1.isItemEqual(recipeOutput)) {
                    this.progress++;
                    if (this.progress >= getOperationTime()) {
                        this.decrStackSize(0, 1);
                        this.decrStackSize(1, 1);

                        if (output1.isEmpty() && !output1.isItemEqual(input1)) {
                            this.setInventorySlotContents(2, recipeOutput.copy());
                        } else if (!output1.isEmpty() && !output1.isItemEqual(input1)) {
                            output1.grow(recipeOutput.getCount());
                        }

                        if (output2.isEmpty() && output2.isItemEqual(input1)) {
                            this.setInventorySlotContents(3, input1.copy());
                        } else {
                            output2.grow(recipeOutput.getCount());
                        }
                        if (output3.isEmpty() && output3.isItemEqual(input2)) {
                            this.setInventorySlotContents(4, input2.copy());
                        } else {
                            output3.grow(recipeOutput.getCount());
                        }

                        this.progress = 0;
                    }
                    mark = true;
                }
            } else {
                if (this.progress > 0) {
                    this.progress = 0;
                    mark = true;
                }
            }
        }
        if (mark) {
            this.markDirty();
        }
    }

    @Override
    public void markDirty() {
        super.markDirty();
        VanillaPacketDispatcher.dispatchTEToNearbyPlayers(this);
    }

    @Override
    public int getSizeInventory() {
        return 5;
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        return this.inventory.get(slot);
    }
    @Override
    public ItemStack decrStackSize(int slot, int decrement) {
        return ItemStackHelper.getAndSplit(this.inventory, slot, decrement);
    }

    @Override
    public boolean isUsableByPlayer(EntityPlayer player) {
        return this.world.getTileEntity(this.getPos()) == this && player.getDistanceSq(this.getPos().add(0.5D, 0.5D, 0.5D)) <= 64.0D;
    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        if (index == 2) {
            return false;
        } else if (index != 1) {
            return true;
        }
        return false;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack) {
        ItemStack itemstack = this.inventory.get(index);
        boolean flag = !stack.isEmpty() && stack.isItemEqual(itemstack) && ItemStack.areItemStackTagsEqual(stack, itemstack);
        this.inventory.set(index, stack);

        if (stack.getCount() > this.getInventoryStackLimit()) {
            stack.setCount(this.getInventoryStackLimit());
        }
    }

    @Override
    public ItemStack removeStackFromSlot(int index) {
        return ItemStackHelper.getAndRemove(this.inventory, index);
    }

    @Override
    public void openInventory(EntityPlayer player) {

    }

    @Override
    public void closeInventory(EntityPlayer player) {

    }

    @Override
    public int getField(int id) {
        return 0;
    }

    @Override
    public void setField(int id, int value) {

    }

    @Override
    public int getFieldCount() {
        return 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean hasCustomName() {
        return false;
    }

    @Override
    public int[] getSlotsForFace(EnumFacing side) {
        return side == EnumFacing.UP ? new int[] { 0 } : side == EnumFacing.DOWN ? new int[] { 2 } : new int[] { 1 };
    }

    @Override
    public boolean canInsertItem(int index, ItemStack stack, EnumFacing facing) {
        return this.isItemValidForSlot(index, stack);
    }

    @Override
    public boolean canExtractItem(int index, ItemStack stack, EnumFacing facing) {
        return index == 2;
    }

    @Override
    public boolean isEmpty() {
        return !this.inventory.stream().anyMatch(s -> !s.isEmpty());
    }

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing side) {
        return this.getCapability(capability, side) != null;
    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return (T) new SidedInvWrapper(this, facing);
        }

        return super.getCapability(capability, facing);
    }

    public abstract int getOperationTime();

    public int getProgress() {
        return this.progress;
    }
}
