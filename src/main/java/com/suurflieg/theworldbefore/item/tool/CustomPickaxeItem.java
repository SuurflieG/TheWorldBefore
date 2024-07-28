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
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.List;


public class CustomPickaxeItem extends PickaxeItem implements ToolHelper {


    public CustomPickaxeItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    public static ItemStack findItemStackInInventory(Player player) {

        ItemStack foundCustomTool = ItemStack.EMPTY;

        // Check the player's main inventory
        for (ItemStack stack : player.getInventory().items) {
            if (stack.getItem() instanceof CustomPickaxeItem) {
                foundCustomTool = stack;
                break;
            }
        }

        // Check the player's offhand
        if (foundCustomTool.isEmpty()) {
            for (ItemStack stack : player.getInventory().offhand) {
                if (stack.getItem() instanceof CustomPickaxeItem) {
                    foundCustomTool = stack;
                    break;
                }
            }
        }

        // Check the player's armor slots
        if (foundCustomTool.isEmpty()) {
            for (ItemStack stack : player.getInventory().armor) {
                if (stack.getItem() instanceof CustomPickaxeItem) {
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
        mineBlockWithPropagation(pLevel, pPos, pStack, pEntityLiving);
        miningSize(pStack, pLevel, pPos, pEntityLiving);
        return true;
    }

    @Override
    public void mineBlockWithPropagation(Level level, BlockPos pos, ItemStack pStack, LivingEntity player) {
        ToolHelper.super.mineBlockWithPropagation(level, pos, pStack, player);
    }

    public static void changeSize(ItemStack pStack, int newSize){
        ToolHelper.changeSize(pStack, newSize);
    }

    public static void changeDepth(ItemStack pStack, int newDepth){
        ToolHelper.changeDepth(pStack, newDepth);
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
        if (UpgradeTools.containsActiveUpgrade(tool, upgradeCardItem.getCard()))
            return;

        UpgradeTools.setUpgrade(tool, upgradeCardItem);
    }



    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pUsedHand);

        // Only perform the shift action
        if(!pLevel.isClientSide){
            return InteractionResultHolder.fail(itemstack);
        }
        if (pPlayer.isShiftKeyDown()) {
            if (ModKeyBindings.GUI_KEY_SHIFT_RIGHT_CLICK.getKey() == InputConstants.UNKNOWN) {
                ModScreens.openToolSettingsScreen(itemstack);
                return InteractionResultHolder.pass(itemstack);
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
                    pTooltip.add(Component.literal(" - " + I18n.get(upgrade.getLocal())).withStyle(ChatFormatting.GREEN));
                }
                if(upgrades.contains(Upgrade.AOE) || upgrades.contains(Upgrade.DEPTH)){
                    pTooltip.add(Component.translatable("theworldbefore.tooltip.item.sneak").withStyle(ChatFormatting.RED));
                }
            }
        }
    }
}
