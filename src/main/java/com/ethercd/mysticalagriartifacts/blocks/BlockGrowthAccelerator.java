package com.ethercd.mysticalagriartifacts.blocks;

import com.blakebr0.cucumber.iface.IEnableable;
import com.blakebr0.cucumber.registry.ModRegistry;
import com.blakebr0.mysticalagriculture.config.ModConfig;
import com.ethercd.mysticalagriartifacts.lib.Tooltips;
import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class BlockGrowthAccelerator extends BlockBase implements IEnableable {

    private final int delay;
    private final float accelerate;
    private final int tier;

    public BlockGrowthAccelerator(int accelerate, int tier) {
        super( "tier" + tier + "_growth_accelerator", Material.ROCK, SoundType.STONE, 5.0F, 8.0F);
        this.setTickRandomly(false);
        this.delay =  (int)Math.ceil(ModConfig.confGrowthAcceleratorSpeed * (100.0 / accelerate) * 20.0);
        this.accelerate = accelerate;
        this.tier = tier;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World player, List<String> tooltip, ITooltipFlag advanced) {
        String color;
        switch (this.tier) {
            default:
            case 2:
                color = "§a";
                break;
            case 3:
                color = "§6";
                break;
            case 4:
                color = "§b";
                break;
            case 5:
                color = "§c";
                break;
        }
        tooltip.add(Tooltips.GROWTH_ACCELERATOR + " " + color + this.accelerate + "%");
    }

    @Override
    public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
        world.scheduleBlockUpdate(pos, state.getBlock(), this.delay, 1);
        super.onBlockAdded(world, pos, state);
    }

    @Override
    public void updateTick(World world, BlockPos pos, IBlockState state, Random rand) {
        if(!world.isRemote){
            this.growCropsNearby(world, pos, state);
        }
    }

    private void growCropsNearby(World world, BlockPos pos, IBlockState state) {
        Iterable<BlockPos> blocks = BlockPos.getAllInBox(pos.add(0, 1, 0), pos.add(0, 64, 0));
        for(BlockPos aoePos : blocks){
            IBlockState cropState = world.getBlockState(new BlockPos(aoePos));
            Block cropBlock = cropState.getBlock();

            if(cropBlock instanceof IGrowable || cropBlock instanceof IPlantable){
                cropBlock.updateTick(world, new BlockPos(aoePos), cropState, world.rand);
            }
        }
        world.scheduleBlockUpdate(pos, state.getBlock(),  this.delay, 1);
    }

    @Override
    public boolean isEnabled(){
        return ModConfig.confGrowthAccelerator;
    }

    public static void init(ModRegistry registry) {
        for (AcceleratorTier tier: AcceleratorTier.values()) {
            tier.register(registry);
        }
    }

    public enum AcceleratorTier {
        TIER2(125, 2),
        TIER3(150, 3),
        TIER4(175, 4),
        TIER5(200, 5);

        private BlockGrowthAccelerator block;
        private final int tier;

        AcceleratorTier(int accelerate, int tier) {
            this.block = new BlockGrowthAccelerator(accelerate, tier);
            this.tier = tier;
        }

        public void register(ModRegistry registry) {
            registry.register(this.block, "tier" + this.tier + "_growth_accelerator");
        }

    }
}