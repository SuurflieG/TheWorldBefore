package com.suurflieg.theworldbefore.item.tool;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.util.FakePlayer;

public interface ToolHelper {


    default void miningSize(ItemStack pStack, Level pLevel, BlockPos pPos, LivingEntity pEntityLiving) {

        Player pPlayer = (Player) pEntityLiving;
        int miningSize = ToolProperties.getMiningSize(pStack);
        int miningDepth = ToolProperties.getMiningDepth(pStack);
        int blockX = pPos.getX();
        int blockZ = pPos.getZ();
        int blockY = pPos.getY();

        int start = -1;
        if (miningSize == 5) {
            start = -2;
        } else if (miningSize == 7) {
            start = -3;
        } else if (miningSize == 1) {
            start = 0;
        }

        int startD = 0;
        int startX = start;
        int startY = start;
        int startZ = start;
        int startxD = startD;
        int startyD = startD;
        int startzD = startD;

        if (pPlayer.isCreative() || !pPlayer.isCreative()) {
            if (!pLevel.isClientSide && !(pEntityLiving instanceof FakePlayer) && ToolProperties.getMiningSize(pStack) > 2 || ToolProperties.getMiningDepth(pStack) > 2) {

                if (pPlayer.getXRot() > 40) {
                    for (int x = 0; x < miningSize; x++) {
                        startZ = start;
                        for (int z = 0; z < miningSize; z++) {
                            startyD = startD;
                            for (int y = 0; y < miningDepth; y++) {
                                BlockPos blockPos = new BlockPos(blockX + startX, blockY - startyD, blockZ + startZ);
                                dropResource(pStack, pLevel, blockPos);
                                startyD++;
                            }
                            startZ++;
                        }
                        startX++;
                    }
                } else if (pPlayer.getXRot() < -40) {
                    for (int x = 0; x < miningSize; x++) {
                        startZ = start;
                        for (int z = 0; z < miningSize; z++) {
                            startyD = startD;
                            for (int y = 0; y < miningDepth; y++) {
                                BlockPos blockPos = new BlockPos(blockX + startX, blockY + startyD, blockZ + startZ);
                                dropResource(pStack, pLevel, blockPos);
                                startyD++;
                            }
                            startZ++;
                        }
                        startX++;
                    }
                } else if (pPlayer.getDirection() == Direction.NORTH) {
                    for (int x = 0; x < miningSize; x++) {
                        startY = start;
                        for (int y = 0; y < miningSize; y++) {
                            startzD = startD;
                            for (int z = 0; z < miningDepth; z++) {
                                BlockPos blockPos = new BlockPos(blockX + startX, blockY + startY, blockZ - startzD);
                                dropResource(pStack, pLevel, blockPos);
                                startzD++;
                            }
                            startY++;
                        }
                        startX++;
                    }
                } else if (pPlayer.getDirection() == Direction.SOUTH) {
                    for (int x = 0; x < miningSize; x++) {
                        startY = start;
                        for (int y = 0; y < miningSize; y++) {
                            startzD = startD;
                            for (int z = 0; z < miningDepth; z++) {
                                BlockPos blockPos = new BlockPos(blockX + startX, blockY + startY, blockZ + startzD);
                                dropResource(pStack, pLevel, blockPos);
                                startzD++;
                            }
                            startY++;
                        }
                        startX++;
                    }
                } else if (pPlayer.getDirection() == Direction.WEST) {
                    for (int z = 0; z < miningSize; z++) {
                        startY = start;
                        for (int y = 0; y < miningSize; y++) {
                            startxD = startD;
                            for (int x = 0; x < miningDepth; x++) {
                                BlockPos blockPos = new BlockPos(blockX - startxD, blockY + startY, blockZ + startZ);
                                dropResource(pStack, pLevel, blockPos);
                                startxD++;
                            }
                            startY++;
                        }
                        startZ++;
                    }
                } else if (pPlayer.getDirection() == Direction.EAST) {
                    for (int z = 0; z < miningSize; z++) {
                        startY = start;
                        for (int y = 0; y < miningSize; y++) {
                            startxD = startD;
                            for (int x = 0; x < miningDepth; x++) {
                                BlockPos blockPos = new BlockPos(blockX + startxD, blockY + startY, blockZ + startZ);
                                dropResource(pStack, pLevel, blockPos);
                                startxD++;
                            }
                            startY++;
                        }
                        startZ++;
                    }
                }
            }
        }
    }

    private void dropResource(ItemStack pStack, Level pLevel, BlockPos blockPos) {
        if (isCorrectToolForDrops(pStack, pLevel.getBlockState(blockPos))) {
            Block.dropResources(pLevel.getBlockState(blockPos), pLevel, blockPos);
            pLevel.destroyBlock(blockPos, false);
        }
    }

    boolean isCorrectToolForDrops(ItemStack pStack, BlockState blockState);
}
