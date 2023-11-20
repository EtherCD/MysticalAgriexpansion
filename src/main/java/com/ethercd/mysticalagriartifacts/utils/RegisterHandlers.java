package com.ethercd.mysticalagriartifacts.utils;

import com.ethercd.mysticalagriartifacts.MysticalAgrArtifacts;
import com.ethercd.mysticalagriartifacts.blocks.ModBlocks;
import com.ethercd.mysticalagriartifacts.items.ModItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class RegisterHandlers {
    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event) {
        for (Item item : ModItems.ITEM_MODEL_REGISTER) {
            if (item instanceof IHasModel)
                MysticalAgrArtifacts.proxy.registerItemRenderer(item, 0, "inventory");
        }
        for (Block block : ModBlocks.BLOCKS_MODEL_REGISTER) {
            if (block instanceof IHasModel)
                MysticalAgrArtifacts.proxy.registerItemRenderer(Item.getItemFromBlock(block), 0, "inventory");
        }
    }
}
