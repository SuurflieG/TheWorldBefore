package com.suurflieg.theworldbefore.item.tool;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.util.FakePlayer;

import java.util.*;

public interface ToolHelper {

    Map<Block, BlockState> HOE_LOOKUP = Maps.newHashMap(ImmutableMap.of(
            Blocks.GRASS_BLOCK, Blocks.FARMLAND.defaultBlockState(),
            Blocks.DIRT_PATH, Blocks.FARMLAND.defaultBlockState(),
            Blocks.DIRT, Blocks.FARMLAND.defaultBlockState(),
            Blocks.COARSE_DIRT, Blocks.DIRT.defaultBlockState()));

    Map<Block, Block> AXE_STRIPPLE = (new ImmutableMap.Builder<Block, Block>())
            .put(Blocks.OAK_WOOD, Blocks.STRIPPED_OAK_WOOD)
            .put(Blocks.OAK_LOG, Blocks.STRIPPED_OAK_LOG)
            .put(Blocks.DARK_OAK_WOOD, Blocks.STRIPPED_DARK_OAK_WOOD)
            .put(Blocks.DARK_OAK_LOG, Blocks.STRIPPED_DARK_OAK_LOG)
            .put(Blocks.ACACIA_WOOD, Blocks.STRIPPED_ACACIA_WOOD)
            .put(Blocks.ACACIA_LOG, Blocks.STRIPPED_ACACIA_LOG)
            .put(Blocks.CHERRY_WOOD, Blocks.STRIPPED_CHERRY_WOOD)
            .put(Blocks.CHERRY_LOG, Blocks.STRIPPED_CHERRY_LOG)
            .put(Blocks.BIRCH_WOOD, Blocks.STRIPPED_BIRCH_WOOD)
            .put(Blocks.BIRCH_LOG, Blocks.STRIPPED_BIRCH_LOG)
            .put(Blocks.JUNGLE_WOOD, Blocks.STRIPPED_JUNGLE_WOOD)
            .put(Blocks.JUNGLE_LOG, Blocks.STRIPPED_JUNGLE_LOG)
            .put(Blocks.SPRUCE_WOOD, Blocks.STRIPPED_SPRUCE_WOOD)
            .put(Blocks.SPRUCE_LOG, Blocks.STRIPPED_SPRUCE_LOG)
            .put(Blocks.WARPED_STEM, Blocks.STRIPPED_WARPED_STEM)
            .put(Blocks.WARPED_HYPHAE, Blocks.STRIPPED_WARPED_HYPHAE)
            .put(Blocks.CRIMSON_STEM, Blocks.STRIPPED_CRIMSON_STEM)
            .put(Blocks.CRIMSON_HYPHAE, Blocks.STRIPPED_CRIMSON_HYPHAE)
            .put(Blocks.MANGROVE_WOOD, Blocks.STRIPPED_MANGROVE_WOOD)
            .put(Blocks.MANGROVE_LOG, Blocks.STRIPPED_MANGROVE_LOG)
            .put(Blocks.BAMBOO_BLOCK, Blocks.STRIPPED_BAMBOO_BLOCK).build();

    List<BlockPos> blocksToOutline = new ArrayList<>();

    /**
     * Function for CustomPickaxe & CustomShovel
     */


/*    default void mineConnectedBlocks(Level level, BlockPos targetPos, ItemStack pStack, LivingEntity player) {
        Player pPlayer = (Player) player;

        if (pPlayer.isShiftKeyDown()) {
            return;
        }

        int miningSize = ToolProperties.getAOE(pStack);

        Set<BlockPos> visited = new HashSet<>();
        Queue<BlockPos> queue = new LinkedList<>();

        queue.offer(targetPos);

        while (!queue.isEmpty()) {
            BlockPos currentPos = queue.poll();

            if (visited.contains(currentPos)) {
                continue;  // Skip if already visited
            }

            BlockState currentBlockState = level.getBlockState(currentPos);
            Block currentBlock = currentBlockState.getBlock();

            // Check if the current block is the same type as the target block
            if (isCorrectToolForDrops(pStack, currentBlockState)) {
                // Break the block and drop resources
                dropResource(pStack, level, currentPos);

                // Explore neighboring positions in all directions
                for (Direction direction : Direction.values()) {
                    BlockPos neighbor = currentPos.relative(direction);

                    if (Math.abs(neighbor.getY() - targetPos.getY()) <= miningSize / 2) {
                        queue.offer(neighbor);
                    }
                }
            }

            visited.add(currentPos);  // Add to visited after processing
        }
    }*/

    default void mineBlockWithPropagation(Level level, BlockPos pos, ItemStack pStack, LivingEntity player) {

        int miningSize = ToolProperties.getAOE(pStack);
        int miningDepth = ToolProperties.getMiningDepth(pStack);
        double playerYaw = Math.floorMod((int) Math.floor(player.yRot), (int) 360.0);

        for (int offsetX = -miningSize / 2; offsetX <= miningSize / 2; offsetX++) {
            for (int offsetY = -miningDepth; offsetY <= 0; offsetY++) {
                for (int offsetZ = -miningSize / 2; offsetZ <= miningSize / 2; offsetZ++) {
                    int x = offsetX, y = offsetY, z = offsetZ;

                    if (playerYaw < 45 || playerYaw >= 315) {
                        // Facing NORTH
                        z = -offsetZ;
                    } else if (playerYaw >= 45 && playerYaw < 135) {
                        // Facing EAST
                        int tempZ = z;
                        z = -offsetX;
                        x = tempZ;
                    } else if (playerYaw >= 135 && playerYaw < 225) {
                        // Facing SOUTH
                    } else if (playerYaw >= 225 && playerYaw < 315) {
                        // Facing WEST
                        int tempX = x;
                        x = offsetZ;
                        z = -tempX;
                    }

                    BlockPos neighborPos = pos.offset(x, y, z);
                    dropResource(pStack, level, neighborPos);
                }
            }
        }
    }











    default void mineConnectedBlocks(Level level, BlockPos targetPos, ItemStack pStack, LivingEntity pEntityLiving) {
        Player pPlayer = (Player) pEntityLiving;

        if (pPlayer.isShiftKeyDown()) {
            return;
        }

        int miningSize = ToolProperties.getAOE(pStack);
        int miningDepth = ToolProperties.getMiningDepth(pStack);

        Set<BlockPos> visited = new HashSet<>();
        Queue<BlockPos> queue = new LinkedList<>();

        queue.offer(targetPos);
        visited.add(targetPos);



        while (!queue.isEmpty()) {
            int queueSize = queue.size();

            for (int i = 0; i < queueSize; i++) {
                BlockPos currentPos = queue.poll();
                dropResource(pStack, level, currentPos);

                for (Direction direction : Direction.values()) {
                    BlockPos neighbor = currentPos.relative(direction);

                    if (!visited.contains(neighbor) && Math.abs(neighbor.getY() - targetPos.getY()) <= miningDepth) {
                        queue.offer(neighbor);
                        visited.add(neighbor);
                    }
                }
            }

            // Add blocks to mine in the horizontal directions
            for (int x = -miningSize / 2; x <= miningSize / 2; x++) {
                for (int z = -miningSize / 2; z <= miningSize / 2; z++) {
                    BlockPos neighbor = targetPos.offset(x, 0, z);

                    if (!visited.contains(neighbor)) {
                        queue.offer(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
        }
    }










    private BlockPos rayTraceBlock(Player player, Level level, ItemStack pStack) {
        Vec3 lookVec = player.getLookAngle();
        Vec3 startVec = player.getEyePosition(1.0f);
        Vec3 endVec = startVec.add(lookVec.scale(ToolProperties.getAOE(pStack)));

        BlockHitResult result = level.clip(new ClipContext(startVec, endVec, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, player));
        return result.getBlockPos();
    }



    default void miningSize(ItemStack pStack, Level pLevel, BlockPos pPos, LivingEntity pEntityLiving) {


        Player pPlayer = (Player) pEntityLiving;
        int miningSize = ToolProperties.getAOE(pStack);
        int miningDepth = ToolProperties.getMiningDepth(pStack);
        int blockX = pPos.getX();
        int blockZ = pPos.getZ();
        int blockY = pPos.getY();

        int start = switch (miningSize) {
            case 5 -> -2;
            case 7 -> -3;
            case 1 -> 0;
            default -> -1;
        };

        int startD = 0;
        int startX = start;
        int startY;
        int startZ = start;
        int startxD;
        int startyD;
        int startzD;

        if(pPlayer.isShiftKeyDown()){
            return;
        }

        blocksToOutline.clear();

        if (pPlayer.isCreative() || !pPlayer.isCreative()) {
            if (!pLevel.isClientSide && !(pEntityLiving instanceof FakePlayer) && ToolProperties.getAOE(pStack) > 2 || ToolProperties.getMiningDepth(pStack) > 2) {

                if (pPlayer.getXRot() > 40) {
                    for (int x = 0; x < miningSize; x++) {
                        startZ = start;
                        for (int z = 0; z < miningSize; z++) {
                            startyD = startD;
                            for (int y = 0; y < miningDepth; y++) {
                                BlockPos blockPos = new BlockPos(blockX + startX, blockY - startyD, blockZ + startZ);
                                blocksToOutline.add(blockPos);
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
                                blocksToOutline.add(blockPos);
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
                                blocksToOutline.add(blockPos);
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
                                blocksToOutline.add(blockPos);
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
                                blocksToOutline.add(blockPos);
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
                                blocksToOutline.add(blockPos);
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

    default void dropResource(ItemStack pStack, Level pLevel, BlockPos blockPos) {
        if (isCorrectToolForDrops(pStack, pLevel.getBlockState(blockPos))) {
            Block.dropResources(pLevel.getBlockState(blockPos), pLevel, blockPos);
            pLevel.destroyBlock(blockPos, false);
        }
    }

    /**
     * Function for CustomHoe
     */
    static InteractionResult getResult(UseOnContext context) {
        var player = context.getPlayer();

        if (player == null){
            return InteractionResult.FAIL;
        }

        var stack = context.getItemInHand();
        var world = context.getLevel();
        var pos = context.getClickedPos();
        var direction = context.getClickedFace();
        var hand = context.getHand();

        int tillSize = ToolProperties.getAOE(stack);
        var playedSound = false;

        if(tillSize == 1){
            if (tryTill(stack, player, world, pos, direction, hand)) {
                world.playSound(player, pos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                playedSound = true;
            }
        }else{
            tillSize = switch (tillSize) {
                case 3 -> 1;
                case 5 -> 2;
                case 7 -> 3;
                default -> ToolProperties.getAOE(stack);
            };
            var positions = BlockPos.betweenClosedStream(pos.offset(-tillSize, 0, -tillSize), pos.offset(tillSize, 0, tillSize)).iterator();

            while (positions.hasNext()) {
                var aoePos = positions.next();

                if (tryTill(stack, player, world, aoePos, direction, hand) && !playedSound) {
                    world.playSound(player, pos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0F, 1.0F);

                    playedSound = true;
                }
            }
        }
        return InteractionResult.SUCCESS;
    }

    private static boolean tryTill(ItemStack stack, Player player, Level world, BlockPos pos, Direction direction, InteractionHand hand) {
        if (direction != Direction.DOWN && world.isEmptyBlock(pos.above())) {
            var state = HOE_LOOKUP.get(world.getBlockState(pos).getBlock());

            if (state != null) {
                if (!world.isClientSide()) {
                    world.setBlock(pos, state, 11);
                }
                return true;
            }
        }
        return false;
    }

    /**
     * Function for CustomAxe
     * */

    static List<BlockPos> getConnectedLogs(BlockPos blockPos) {
        List<BlockPos> connectedLogs = new LinkedList<>();
        connectedLogs.add(blockPos.above());
        connectedLogs.add(blockPos.below());
        connectedLogs.add(blockPos.north());
        connectedLogs.add(blockPos.south());
        connectedLogs.add(blockPos.east());
        connectedLogs.add(blockPos.west());
        connectedLogs.add(blockPos.above().north());
        connectedLogs.add(blockPos.above().south());
        connectedLogs.add(blockPos.above().east());
        connectedLogs.add(blockPos.above().west());
        connectedLogs.add(blockPos.below().north());
        connectedLogs.add(blockPos.below().south());
        connectedLogs.add(blockPos.below().east());
        connectedLogs.add(blockPos.below().west());
        connectedLogs.add(blockPos.north().east());
        connectedLogs.add(blockPos.north().west());
        connectedLogs.add(blockPos.south().east());
        connectedLogs.add(blockPos.south().west());
        return connectedLogs;
    }

    static boolean isLogBlock(Block block) {
        return block == Blocks.OAK_LOG ||
                block == Blocks.SPRUCE_LOG ||
                block == Blocks.BIRCH_LOG ||
                block == Blocks.JUNGLE_LOG ||
                block == Blocks.ACACIA_LOG ||
                block == Blocks.DARK_OAK_LOG;
    }

    static boolean isLeafBlock(Block block) {
        return block == Blocks.OAK_LEAVES ||
                block == Blocks.SPRUCE_LEAVES ||
                block == Blocks.BIRCH_LEAVES ||
                block == Blocks.JUNGLE_LEAVES ||
                block == Blocks.ACACIA_LEAVES ||
                block == Blocks.DARK_OAK_LEAVES;
    }

    default List<BlockPos> mineConnectedLogs(Level level, BlockPos blockPos, List<BlockPos> logs) {

        
        Set<BlockPos> visited = new HashSet<>();
        Queue<BlockPos> queue = new LinkedList<>();

        queue.offer(blockPos);
        visited.add(blockPos);

        while (!queue.isEmpty()) {
            BlockPos currentPos = queue.poll();
            BlockState currentBlockState = level.getBlockState(currentPos);
            Block currentBlock = currentBlockState.getBlock();

            // Check if the current block is a log block or leaf block
            if (isLogBlock(currentBlock) || isLeafBlock(currentBlock)) {

                // Break the log or leaf block
                level.destroyBlock(currentPos, true);

                // Explore all neighboring positions, including diagonals
                for (BlockPos neighbor : getConnectedLogs(currentPos)) {
                    if (!visited.contains(neighbor)) {
                        queue.offer(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
        }
        return logs;
    }

    boolean isCorrectToolForDrops(ItemStack pStack, BlockState blockState);

    static void changeSize(ItemStack tool, int newSize) {
        ToolProperties.setAOE(tool, newSize);
    }

    static void changeDepth(ItemStack tool, int newSize) {
        ToolProperties.setMiningDepth(tool, newSize);
    }


}
