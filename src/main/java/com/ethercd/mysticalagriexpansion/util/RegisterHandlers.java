package com.ethercd.mysticalagriexpansion.util;

import com.ethercd.mysticalagriexpansion.Mod;
import com.ethercd.mysticalagriexpansion.block.ModBlocks;
import com.ethercd.mysticalagriexpansion.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@net.minecraftforge.fml.common.Mod.EventBusSubscriber
public class RegisterHandlers {
    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event) {
        for (Item item : ModItems.ITEM_MODEL_REGISTER) {
            if (item instanceof IHasModel)
                Mod.proxy.registerItemRenderer(item, 0, "inventory");
        }
        for (Block block : ModBlocks.BLOCKS_MODEL_REGISTER) {
            if (block instanceof IHasModel)
                Mod.proxy.registerItemRenderer(Item.getItemFromBlock(block), 0, "inventory");
        }
    }
}
