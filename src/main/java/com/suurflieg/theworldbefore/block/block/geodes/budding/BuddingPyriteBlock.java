/*
package com.suurflieg.theworldbefore.block.block.geodes.budding;


import com.suurflieg.theworldbefore.block.block.PyriteBlock;
import com.suurflieg.theworldbefore.block.block.geodes.cluster.PyriteClusterBlock;
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

public class BuddingPyriteBlock extends PyriteBlock {

    public static final int GROWTH_CHANCE = 5;
    private static final Direction[] DIRECTIONS = Direction.values();

    public BuddingPyriteBlock(Properties pProperties) {
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
                block = ModBlocks.SMALL_PYRITE_BUD.get();
            } else if (blockstate.is(ModBlocks.SMALL_PYRITE_BUD.get()) && blockstate.getValue(PyriteClusterBlock.FACING) == direction) {
                block = ModBlocks.MEDIUM_PYRITE_BUD.get();
            } else if (blockstate.is(ModBlocks.MEDIUM_PYRITE_BUD.get()) && blockstate.getValue(PyriteClusterBlock.FACING) == direction) {
                block = ModBlocks.LARGE_PYRITE_BUD.get();
            } else if (blockstate.is(ModBlocks.LARGE_PYRITE_BUD.get()) && blockstate.getValue(PyriteClusterBlock.FACING) == direction) {
                block = ModBlocks.PYRITE_CLUSTER.get();
            }

            if (block != null) {
                BlockState blockstate1 = block.defaultBlockState().setValue(PyriteClusterBlock.FACING, direction).setValue(PyriteClusterBlock.WATERLOGGED, blockstate.getFluidState().getType() == Fluids.WATER);
                pLevel.setBlockAndUpdate(blockpos, blockstate1);
            }

        }
    }


    public static boolean canClusterGrowAtState(BlockState pState) {
        return pState.isAir() || pState.is(Blocks.WATER) && pState.getFluidState().getAmount() == 8;
    }

}
*/
