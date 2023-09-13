package com.suurflieg.theworldbefore.custom.item.armor;


import com.mojang.blaze3d.platform.InputConstants;
import com.suurflieg.theworldbefore.custom.item.upgradecards.UpgradeCardItem;
import com.suurflieg.theworldbefore.custom.item.upgradecards.UpgradeTools;
import com.suurflieg.theworldbefore.custom.util.TheWorldBeforeKeyBinding;
import com.suurflieg.theworldbefore.registry.ModScreens;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

//TODO Figure out how to setup hotkey G to open menu for armor when its equiped, if its held in the hand then shift right click

public class CustomArmorItem extends ArmorItem {


    public CustomArmorItem(ArmorMaterial pMaterial, Type type, Properties pProperties) {
        super(pMaterial, type, pProperties);
    }

    public static ItemStack getArmor(Player player) {
        ItemStack heldItem = player.getMainHandItem();
        if (!(heldItem.getItem() instanceof CustomArmorItem)) {
            heldItem = player.getOffhandItem();
            if (!(heldItem.getItem() instanceof CustomArmorItem)) {
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
                    ModScreens.openArmorSettingsScreen(itemstack);
                    return InteractionResultHolder.pass(itemstack);
                }
            }

            return InteractionResultHolder.pass(itemstack);
        }

        pPlayer.startUsingItem(pUsedHand);
        return new InteractionResultHolder<>(InteractionResult.PASS, itemstack);
    }
}
