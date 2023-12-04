package com.ethercd.mysticalagriexpansion.gui;

import com.ethercd.mysticalagriexpansion.te.mutagenesis.TileEntityMutagenesisProcessor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

@SuppressWarnings("ALL")
public class ContainerMutagenesisProcessor extends Container {
    private final TileEntityMutagenesisProcessor tileentity;
    private int progress, maxProgress;

    public ContainerMutagenesisProcessor(InventoryPlayer player, TileEntityMutagenesisProcessor tileentity) {
        this.tileentity = tileentity;

        this.addSlotToContainer(new Slot(tileentity, 0, 31, 41));
        this.addSlotToContainer(new Slot(tileentity, 1, 55, 41));
        this.addSlotToContainer(new Slot(tileentity, 2, 113, 30) {
            @Override
            public boolean isItemValid(ItemStack stack) {
                return false;
            }
        });
        this.addSlotToContainer(new Slot(tileentity, 3, 101, 57) {
            @Override
            public boolean isItemValid(ItemStack stack) {
                return false;
            }
        });
        this.addSlotToContainer(new Slot(tileentity, 0, 125, 57) {
            @Override
            public boolean isItemValid(ItemStack stack) {
                return false;
            }
        });

        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 9; x++) {
                this.addSlotToContainer(new Slot(player, x + y*9, 8 + x * 18,84+y*18));
            }
        }
        for (int x = 0; x < 9; x++) {
            this.addSlotToContainer(new Slot(player, x, 8 + x * 18,142));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return this.tileentity.isUsableByPlayer(playerIn);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slotNumber){
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = (Slot)this.inventorySlots.get(slotNumber);

        if(slot != null && slot.getHasStack()){
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if(slotNumber == 1){
                if(!this.mergeItemStack(itemstack1, 2, 38, false)){
                    return ItemStack.EMPTY;
                }
                slot.onSlotChange(itemstack1, itemstack);
            } else if(slotNumber != 0){
                if(slotNumber >= 3 && slotNumber < 29){
                    if(!this.mergeItemStack(itemstack1, 29, 38, false)){
                        return ItemStack.EMPTY;
                    }
                }
                else if(slotNumber >= 29 && slotNumber < 38){
                    if(!this.mergeItemStack(itemstack1, 2, 29, false)){
                        return ItemStack.EMPTY;
                    }
                }
            } else if(!this.mergeItemStack(itemstack1, 2, 38, false)){
                return ItemStack.EMPTY;
            }

            if(itemstack1.getCount() == 0){
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }

            if(itemstack1.getCount() == itemstack.getCount()){
                return ItemStack.EMPTY;
            }
            slot.onTake(player, itemstack1);
        }
        return itemstack;
    }
}
