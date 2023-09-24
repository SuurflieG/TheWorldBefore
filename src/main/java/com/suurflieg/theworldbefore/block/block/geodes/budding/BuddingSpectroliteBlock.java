/*
package com.suurflieg.theworldbefore.block.block.geodes.budding;


import com.suurflieg.theworldbefore.block.block.SpectroliteBlock;
import com.suurflieg.theworldbefore.block.block.geodes.cluster.SpectroliteClusterBlock;
import com.suurflieg.theworldbefore.registry.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.PushReaction;

import java.util.Random;

public class BuddingSpectroliteBlock extends SpectroliteBlock {

    public static final int GROWTH_CHANCE = 5;
    private static final Direction[] DIRECTIONS = Direction.values();

    public BuddingSpectroliteBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public PushReaction getPistonPushReaction(BlockState pState) {
        return PushReaction.DESTROY;
    }

    */
/**
     * Performs a random tick on a block.
     *//*


    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, Random pRandom) {
        if (pRandom.nextInt(5) == 0) {
            Direction direction = DIRECTIONS[pRandom.nextInt(DIRECTIONS.length)];
            BlockPos blockpos = pPos.relative(direction);
            BlockState blockstate = pLevel.getBlockState(blockpos);
            Block block = null;
            if (canClusterGrowAtState(blockstate)) {
                block = ModBlocks.SMALL_SPECTROLITE_BUD.get();
            } else if (blockstate.is(ModBlocks.SMALL_SPECTROLITE_BUD.get()) && blockstate.getValue(SpectroliteClusterBlock.FACING) == direction) {
                block = ModBlocks.MEDIUM_SPECTROLITE_BUD.get();
            } else if (blockstate.is(ModBlocks.MEDIUM_SPECTROLITE_BUD.get()) && blockstate.getValue(SpectroliteClusterBlock.FACING) == direction) {
                block = ModBlocks.LARGE_SPECTROLITE_BUD.get();
            } else if (blockstate.is(ModBlocks.LARGE_SPECTROLITE_BUD.get()) && blockstate.getValue(SpectroliteClusterBlock.FACING) == direction) {
                block = ModBlocks.SPECTROLITE_CLUSTER.get();
            }

            if (block != null) {
                BlockState blockstate1 = block.defaultBlockState().setValue(SpectroliteClusterBlock.FACING, direction).setValue(SpectroliteClusterBlock.WATERLOGGED, blockstate.getFluidState().getType() == Fluids.WATER);
                pLevel.setBlockAndUpdate(blockpos, blockstate1);
            }

        }
    }


    public static boolean canClusterGrowAtState(BlockState pState) {
        return pState.isAir() || pState.is(Blocks.WATER) && pState.getFluidState().getAmount() == 8;
    }

}
*/
