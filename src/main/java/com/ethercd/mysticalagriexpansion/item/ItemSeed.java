package com.ethercd.mysticalagriexpansion.item;

import com.blakebr0.cucumber.lib.Colors;
import com.blakebr0.mysticalagriculture.lib.Tooltips;
import com.ethercd.mysticalagriexpansion.MACreativeTabs;
import com.ethercd.mysticalagriexpansion.MysticalAgriexpansion;
import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

/**
 * Class of common seeds
 */
public class ItemSeed extends ItemSeeds {
    private final Block crop;
    private final int tier;

    public ItemSeed(String name, Block crop, int tier) {
        super(crop, Blocks.FARMLAND);
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.tier = tier;
        this.setCreativeTab(MACreativeTabs.CREATIVE_TAB);
        this.crop = crop;
    }

    public int getTier() {
        return this.tier;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag advanced) {
        switch(this.tier){
            case 1:
                tooltip.add(Tooltips.TIER + Colors.YELLOW + "1");
                break;
            case 2:
                tooltip.add(Tooltips.TIER + Colors.GREEN + "2");
                break;
            case 3:
                tooltip.add(Tooltips.TIER + Colors.GOLD + "3");
                break;
            case 4:
                tooltip.add(Tooltips.TIER + Colors.AQUA + "4");
                break;
            case 5:
                tooltip.add(Tooltips.TIER + Colors.RED + "5");
                break;
        }
    }
}
