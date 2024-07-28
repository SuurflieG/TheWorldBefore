package com.suurflieg.theworldbefore.item.tool;

import com.mojang.blaze3d.platform.InputConstants;
import com.suurflieg.theworldbefore.item.upgradecards.Upgrade;
import com.suurflieg.theworldbefore.item.upgradecards.UpgradeCardItem;
import com.suurflieg.theworldbefore.item.upgradecards.UpgradeTools;
import com.suurflieg.theworldbefore.registry.ModScreens;
import com.suurflieg.theworldbefore.util.ModKeyBindings;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
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
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CustomShovelItem extends ShovelItem implements ToolHelper{

    public CustomShovelItem(Tier pTier, float pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    public static ItemStack findItemStackInInventory(Player player) {

        ItemStack foundCustomTool = ItemStack.EMPTY;

        // Check the player's main inventory
        for (ItemStack stack : player.getInventory().items) {
            if (stack.getItem() instanceof CustomShovelItem) {
                foundCustomTool = stack;
                break;
            }
        }

        // Check the player's offhand
        if (foundCustomTool.isEmpty()) {
            for (ItemStack stack : player.getInventory().offhand) {
                if (stack.getItem() instanceof CustomShovelItem) {
                    foundCustomTool = stack;
                    break;
                }
            }
        }

        // Check the player's armor slots
        if (foundCustomTool.isEmpty()) {
            for (ItemStack stack : player.getInventory().armor) {
                if (stack.getItem() instanceof CustomShovelItem) {
                    foundCustomTool = stack;
                    break;
                }
            }
        }
        return foundCustomTool;
    }

    @Override
    public boolean mineBlock(ItemStack pStack, Level pLevel, BlockState pState, BlockPos pPos, LivingEntity pEntityLiving) {
        super.mineBlock(pStack, pLevel, pState, pPos, pEntityLiving);
        miningSize(pStack, pLevel, pPos, pEntityLiving);
        return true;
    }

    @Override
    public void miningSize(ItemStack pStack, Level pLevel, BlockPos pPos, LivingEntity pEntityLiving) {
        ToolHelper.super.miningSize(pStack, pLevel, pPos, pEntityLiving);
    }

    public static void changeSize(ItemStack pStack, int newSize){
        ToolHelper.changeSize(pStack, newSize);
    }

    public static void changeDepth(ItemStack pStack, int newSize){
        ToolHelper.changeDepth(pStack, newSize);
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
                if (ModKeyBindings.GUI_KEY_SHIFT_RIGHT_CLICK.getKey() == InputConstants.UNKNOWN) {
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
                for (Upgrade upgrade : upgrades) {pTooltip.add(Component.literal(" - " + I18n.get(upgrade.getLocal())).withStyle(ChatFormatting.GREEN));
                }
                if(upgrades.contains(Upgrade.AOE) || upgrades.contains(Upgrade.DEPTH)){
                    pTooltip.add(Component.translatable("theworldbefore.tooltip.item.sneak").withStyle(ChatFormatting.RED));
                }
            }
        }
    }
}
