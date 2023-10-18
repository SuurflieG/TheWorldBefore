package com.suurflieg.theworldbefore.item.tool;

import com.suurflieg.theworldbefore.item.upgradecards.Upgrade;
import com.suurflieg.theworldbefore.item.upgradecards.UpgradeCardItem;
import com.suurflieg.theworldbefore.item.upgradecards.UpgradeTools;
import com.suurflieg.theworldbefore.util.TheWorldBeforeKeyBinding;
import com.suurflieg.theworldbefore.registry.ModScreens;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.util.FakePlayer;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CustomShovelItem extends ShovelItem {

    public CustomShovelItem(Tier pTier, float pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    public static ItemStack getShovel(Player player) {
        ItemStack heldItem = player.getMainHandItem();
        if (!(heldItem.getItem() instanceof CustomShovelItem)) {
            heldItem = player.getOffhandItem();
            if (!(heldItem.getItem() instanceof CustomShovelItem)) {
                return ItemStack.EMPTY;
            }
        }

        return heldItem;
    }

    @Override
    public boolean mineBlock(ItemStack pStack, Level pLevel, BlockState pState, BlockPos pPos, LivingEntity pEntityLiving) {
        super.mineBlock(pStack, pLevel, pState, pPos, pEntityLiving);
        miningSize(pStack, pLevel, pPos, pEntityLiving);
        return true;
    }

    private void miningSize(ItemStack pStack, Level pLevel, BlockPos pPos, LivingEntity pEntityLiving) {
        Player pPlayer = (Player) pEntityLiving;

        int miningSize = ToolProperties.getMiningSize(pStack);
        int miningDepth = ToolProperties.getMiningDepth(pStack);
        int blockX = pPos.getX();
        int blockZ = pPos.getZ();
        int blockY = pPos.getY();

        int start = -1;
        if(miningSize == 5){
            start = -2;
        }else if (miningSize == 7){
            start = -3;
        }else if(miningSize == 1){
            start = 0;
        }

        int startD = 0;

        int startX = start;
        int startY = start;
        int startZ = start;

        int startxD = startD;
        int startyD = startD;
        int startzD = startD;

        if(pPlayer.isCreative() || !pPlayer.isCreative()){
            if (!pLevel.isClientSide && !(pEntityLiving instanceof FakePlayer) && ToolProperties.getMiningSize(pStack) > 2 || ToolProperties.getMiningDepth(pStack) > 2) {

                if (pPlayer.getXRot() > 40) {
                    for (int x = 0; x < miningSize; x++) {
                        startZ = start;
                        for (int z = 0; z < miningSize; z++) {
                            startyD = startD;
                            for (int y = 0; y < miningDepth; y++) {
                                BlockPos blockPos = new BlockPos(blockX + startX, blockY - startyD, blockZ + startZ);
                                if (isCorrectToolForDrops(pStack ,pLevel.getBlockState(blockPos))) {
                                    Block.dropResources(pLevel.getBlockState(blockPos), pLevel, blockPos);
                                    pLevel.destroyBlock(blockPos, false);
                                }
                                startyD++;
                            }
                            startZ++;
                        }
                        startX++;
                    }
                }

                else if (pPlayer.getXRot() < -40) {
                    for (int x = 0; x < miningSize; x++) {
                        startZ = start;
                        for (int z = 0; z < miningSize; z++) {
                            startyD = startD;
                            for (int y = 0; y < miningDepth; y++) {
                                BlockPos blockPos = new BlockPos(blockX + startX, blockY + startyD, blockZ + startZ);
                                if (isCorrectToolForDrops(pStack ,pLevel.getBlockState(blockPos))) {
                                    Block.dropResources(pLevel.getBlockState(blockPos), pLevel, blockPos);
                                    pLevel.destroyBlock(blockPos, false);
                                }
                                startyD++;
                            }
                            startZ++;
                        }
                        startX++;
                    }
                }

                else if (pPlayer.getDirection() == Direction.NORTH) {
                    for (int x = 0; x < miningSize; x++) {
                        startY = start;
                        for (int y = 0; y < miningSize; y++){
                            startzD = startD;
                            for(int z = 0; z < miningDepth; z++) {
                                BlockPos blockPos = new BlockPos(blockX + startX, blockY + startY, blockZ - startzD);
                                if (isCorrectToolForDrops(pStack, pLevel.getBlockState(blockPos))) {
                                    Block.dropResources(pLevel.getBlockState(blockPos), pLevel, blockPos);
                                    pLevel.destroyBlock(blockPos, false);
                                }
                                startzD++;
                            }
                            startY++;
                        }
                        startX++;
                    }
                }

                else if (pPlayer.getDirection() == Direction.SOUTH) {
                    for (int x = 0; x < miningSize; x++) {
                        startY = start;
                        for (int y = 0; y < miningSize; y++){
                            startzD = startD;
                            for(int z = 0; z < miningDepth; z++) {
                                BlockPos blockPos = new BlockPos(blockX + startX, blockY + startY, blockZ + startzD);
                                if (isCorrectToolForDrops(pStack, pLevel.getBlockState(blockPos))) {
                                    Block.dropResources(pLevel.getBlockState(blockPos), pLevel, blockPos);
                                    pLevel.destroyBlock(blockPos, false);
                                }
                                startzD++;
                            }
                            startY++;
                        }
                        startX++;
                    }
                }

                else if (pPlayer.getDirection() == Direction.WEST) {
                    for (int z = 0; z < miningSize; z++) {
                        startY = start;
                        for (int y = 0; y < miningSize; y++) {
                            startxD = startD;
                            for (int x = 0;x < miningDepth; x++) {
                                BlockPos blockPos = new BlockPos(blockX - startxD, blockY + startY, blockZ + startZ);
                                if (isCorrectToolForDrops(pStack, pLevel.getBlockState(blockPos))) {
                                    Block.dropResources(pLevel.getBlockState(blockPos), pLevel, blockPos);
                                    pLevel.destroyBlock(blockPos, false);
                                }
                                startxD++;
                            }
                            startY++;
                        }
                        startZ++;
                    }
                }

                else if (pPlayer.getDirection() == Direction.EAST) {
                    for (int z = 0; z < miningSize; z++) {
                        startY = start;
                        for (int y = 0; y < miningSize; y++) {
                            startxD = startD;
                            for (int x = 0;x < miningDepth; x++) {
                                BlockPos blockPos = new BlockPos(blockX + startxD, blockY + startY, blockZ + startZ);
                                if (isCorrectToolForDrops(pStack, pLevel.getBlockState(blockPos))) {
                                    Block.dropResources(pLevel.getBlockState(blockPos), pLevel, blockPos);
                                    pLevel.destroyBlock(blockPos, false);
                                }
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

    @Override
    public boolean isEnchantable(ItemStack pStack) {
        return false;
    }

    @Override
    public boolean isBookEnchantable(ItemStack pStack, ItemStack pBook) {
        return false;
    }

    @Override
    public boolean canBeDepleted() {
        return false;
    }

    public static void changeRange(ItemStack tool) {
        int currentMiningSize = ToolProperties.getMiningSize(tool);
        if (currentMiningSize <= 5) {
            ToolProperties.setMiningSize(tool, currentMiningSize + 2);
        }
        else {
            ToolProperties.setMiningSize(tool, 1);
        }
    }

    public static void changeDepth(ItemStack tool) {
        int currentMiningDepth = ToolProperties.getMiningDepth(tool);
        if (currentMiningDepth <= 5) {
            ToolProperties.setMiningDepth(tool, currentMiningDepth + 2);
        }
        else {
            ToolProperties.setMiningDepth(tool, 1);
        }
    }
    public static void applyUpgrade(ItemStack tool, UpgradeCardItem upgradeCardItem) {
        if (UpgradeTools.containsUpgrade(tool, upgradeCardItem.getCard()))
            return;

        UpgradeTools.setUpgrade(tool, upgradeCardItem);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pUsedHand);

        // Only perform the shift action
        if (pPlayer.isShiftKeyDown()) {
            if (pLevel.isClientSide) {
                if (TheWorldBeforeKeyBinding.GUI_KEY_SHIFT_RIGHT_CLICK.getKey() == InputConstants.UNKNOWN) {
                    ModScreens.openToolSettingsScreen(itemstack);
                    return InteractionResultHolder.pass(itemstack);
                }
            }

            return InteractionResultHolder.pass(itemstack);
        }

        pPlayer.startUsingItem(pUsedHand);
        return new InteractionResultHolder<>(InteractionResult.PASS, itemstack);
    }

    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pIsAdvanced) {
        super.appendHoverText(pStack, pLevel, pTooltip, pIsAdvanced);
        List<Upgrade> upgrades = UpgradeTools.getUpgrades(pStack);
        Minecraft mc = Minecraft.getInstance();

        if (pLevel == null || mc.player == null) {
            return;
        }

        boolean sneakPressed = Screen.hasShiftDown();

        if (!sneakPressed) {
            pTooltip.add(Component.translatable("theworldbefore.tooltip.item.show_upgrades", "shift").withStyle(ChatFormatting.YELLOW));
        } else {
            if (!(upgrades.isEmpty())) {
                pTooltip.add(Component.translatable("theworldbefore.tooltip.item.upgrades").withStyle(ChatFormatting.AQUA));
                for (Upgrade upgrade : upgrades) {
                    pTooltip.add(Component.literal(" - " +
                            I18n.get(upgrade.getLocal())
                    ).withStyle(ChatFormatting.GREEN));
                }
            }
        }
    }
}
