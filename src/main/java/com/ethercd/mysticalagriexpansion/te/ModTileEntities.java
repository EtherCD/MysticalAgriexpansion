package com.ethercd.mysticalagriexpansion.te;

import com.blakebr0.cucumber.helper.ResourceHelper;
import com.ethercd.mysticalagriexpansion.MysticalAgriexpansion;
import com.ethercd.mysticalagriexpansion.te.mutagenesis.TileInferiumMutagenesisProcessor;
import com.ethercd.mysticalagriexpansion.te.mutagenesis.TileInsaniumMutagenesisProcessor;
import com.ethercd.mysticalagriexpansion.te.mutagenesis.TileIntermediumMutagenesisProcessor;
import com.ethercd.mysticalagriexpansion.te.mutagenesis.TilePrudentiumMutagenesisProcessor;
import com.ethercd.mysticalagriexpansion.te.mutagenesis.TileSuperiumMutagenesisProcessor;
import com.ethercd.mysticalagriexpansion.te.mutagenesis.TileSupremiumMutagenesisProcessor;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModTileEntities {
    public static void init() {
        GameRegistry.registerTileEntity(TileInferiumMutagenesisProcessor.class, ResourceHelper.getResource(MysticalAgriexpansion.MOD_ID, "inferium_mutagenesis_processor"));
        GameRegistry.registerTileEntity(TilePrudentiumMutagenesisProcessor.class, ResourceHelper.getResource(MysticalAgriexpansion.MOD_ID, "prudentium_mutagenesis_processor"));
        GameRegistry.registerTileEntity(TileIntermediumMutagenesisProcessor.class, ResourceHelper.getResource(MysticalAgriexpansion.MOD_ID, "indermedium_mutagenesis_processor"));
        GameRegistry.registerTileEntity(TileSuperiumMutagenesisProcessor.class, ResourceHelper.getResource(MysticalAgriexpansion.MOD_ID, "superium_mutagenesis_processor"));
        GameRegistry.registerTileEntity(TileSupremiumMutagenesisProcessor.class, ResourceHelper.getResource(MysticalAgriexpansion.MOD_ID, "supremium_mutagenesis_processor"));
        GameRegistry.registerTileEntity(TileInsaniumMutagenesisProcessor.class, ResourceHelper.getResource(MysticalAgriexpansion.MOD_ID, "insanium_mutagenesis_processor"));
    }
}
