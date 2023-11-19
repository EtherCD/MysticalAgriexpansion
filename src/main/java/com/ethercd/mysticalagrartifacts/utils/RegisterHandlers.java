package com.ethercd.mysticalagrartifacts.utils;

import com.ethercd.mysticalagrartifacts.MysticalAgrArtifacts;
import com.ethercd.mysticalagrartifacts.items.ModItems;
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
    }
}
