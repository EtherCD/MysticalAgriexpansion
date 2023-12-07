package com.ethercd.mysticalagriexpansion.block;

import com.blakebr0.cucumber.iface.IEnableable;
import com.blakebr0.cucumber.lib.Colors;
import com.blakebr0.mysticalagriculture.config.ModConfig;
import com.ethercd.mysticalagriexpansion.MACreativeTabs;
import com.ethercd.mysticalagriexpansion.item.ModItems;
import com.ethercd.mysticalagriexpansion.lib.ModChecker;
import com.ethercd.mysticalagriexpansion.lib.ModTooltips;
import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

@SuppressWarnings({"unused"})
public enum BlockGrowthAccelerator {
    TIER2(150, 2, true),
    TIER3(200, 3, true),
    TIER4(250, 4, true),
    TIER5(300, 5, true),
    TIER6(500, 6, ModChecker.INSANIUM);

    private final BlockGrowth block;
    private final boolean active;
    private final String name;

    BlockGrowthAccelerator(int accelerate, int tier, boolean active) {
        this.block = new BlockGrowth(accelerate, tier);
        this.active = active;
        this.name = "tier" + tier + "_growth_accelerator";
    }

    public static void init() {
        for (BlockGrowthAccelerator block : BlockGrowthAccelerator.values()) {
            if (block.active) {
                ModBlocks.add(block.block, block.name);
                ModItems.add(new ItemBlock(block.block).setCreativeTab(MACreativeTabs.CREATIVE_TAB), block.name);
            }
        }
    }

    @SuppressWarnings("NullableProblems")
    static class BlockGrowth extends ModBlock implements IEnableable {
        private final int delay;
        private final float accelerate;
        private final int tier;

        public BlockGrowth(int accelerate, int tier) {
            super("tier" + tier + "_growth_accelerator", Material.ROCK, SoundType.STONE, 5.0F, 8.0F);
            this.setTickRandomly(false);
            this.delay = (int) Math.ceil(ModConfig.confGrowthAcceleratorSpeed * (100.0 / accelerate) * 20.0);
            this.accelerate = accelerate;
            this.tier = tier;
        }

        @Override
        @SideOnly(Side.CLIENT)
        public void addInformation(ItemStack stack, @Nullable World player, List<String> tooltip, ITooltipFlag advanced) {
            String color;
            switch (this.tier) {
                case 2:
                    tooltip.add(ModTooltips.GROWTH_ACCELERATOR + " " + Colors.GREEN + this.accelerate + "%");
                    break;
                case 3:
                    tooltip.add(ModTooltips.GROWTH_ACCELERATOR + " " + Colors.GOLD + this.accelerate + "%");
                    break;
                case 4:
                    tooltip.add(ModTooltips.GROWTH_ACCELERATOR + " " + Colors.AQUA + this.accelerate + "%");
                    break;
                case 5:
                    tooltip.add(ModTooltips.GROWTH_ACCELERATOR + " " + Colors.RED + this.accelerate + "%");
                    break;
                case 6:
                    tooltip.add(ModTooltips.GROWTH_ACCELERATOR + " " + Colors.DARK_PURPLE + this.accelerate + "%");
                    break;
            }
        }

        @Override
        public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
            world.scheduleBlockUpdate(pos, state.getBlock(), this.delay, 1);
            super.onBlockAdded(world, pos, state);
        }

        @Override
        public void updateTick(World world, BlockPos pos, IBlockState state, Random rand) {
            if (!world.isRemote) {
                this.growCropsNearby(world, pos, state);
            }
        }

        private void growCropsNearby(World world, BlockPos pos, IBlockState state) {
            Iterable<BlockPos> blocks = BlockPos.getAllInBox(pos.add(0, 1, 0), pos.add(0, 64, 0));
            for (BlockPos aoePos : blocks) {
                IBlockState cropState = world.getBlockState(new BlockPos(aoePos));
                Block cropBlock = cropState.getBlock();
                if (cropBlock instanceof IGrowable || cropBlock instanceof IPlantable) {
                    cropBlock.updateTick(world, new BlockPos(aoePos), cropState, world.rand);
                }
            }
            world.scheduleBlockUpdate(pos, state.getBlock(), this.delay, 1);
        }

        @Override
        public boolean isEnabled() {
            return ModConfig.confGrowthAccelerator;
        }
    }
}