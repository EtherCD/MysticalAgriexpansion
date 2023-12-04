package com.ethercd.mysticalagriexpansion.te;

import com.blakebr0.cucumber.helper.ResourceHelper;
import com.ethercd.mysticalagriexpansion.MysticalAgriexpansion;
import com.ethercd.mysticalagriexpansion.te.mutagenesis.TileEntityMutagenesisProcessor;
import com.ethercd.mysticalagriexpansion.te.mutagenesis.TileInferiumMutagenesisReprocessor;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModTileEntities {
    public static void init() {
        GameRegistry.registerTileEntity(TileInferiumMutagenesisReprocessor.class, ResourceHelper.getResource(MysticalAgriexpansion.MOD_ID, "mutagenesis_processor"));
    }
}
