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
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.List;


public class CustomHoeItem extends HoeItem {


    public CustomHoeItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    public static ItemStack getHoe(Player player) {
        ItemStack heldItem = player.getMainHandItem();
        if (!(heldItem.getItem() instanceof CustomHoeItem)) {
            heldItem = player.getOffhandItem();
            if (!(heldItem.getItem() instanceof CustomHoeItem)) {
                return ItemStack.EMPTY;
            }
        }

        return heldItem;
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
        if (ToolProperties.getMiningSize(tool) == 1)
            ToolProperties.setMiningSize(tool, 3);
        else
            ToolProperties.setMiningSize(tool, 1);
    }

    public static void applyUpgrade(ItemStack tool, UpgradeCardItem upgradeCardItem) {
        if (UpgradeTools.containsActiveUpgrade(tool, upgradeCardItem.getCard()))
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
