package com.suurflieg.theworldbefore.item.upgradecards;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class UpgradeCardItem extends Item {

    public final Upgrade upgradeCard;

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
        if (pStack.getItem() instanceof UpgradeCardItem) {
            if (upgradeCard == Upgrade.SILK)
                pTooltipComponents.add(Component.translatable("theworldbefore.tooltip.upgrades.silk_touch").withStyle(ChatFormatting.GREEN));
            if (upgradeCard == Upgrade.FORTUNE_1)
                pTooltipComponents.add(Component.translatable("theworldbefore.tooltip.upgrades.fortune_1").withStyle(ChatFormatting.GREEN));
            if (upgradeCard == Upgrade.FORTUNE_2)
                pTooltipComponents.add(Component.translatable("theworldbefore.tooltip.upgrades.fortune_2").withStyle(ChatFormatting.GREEN));
            if (upgradeCard == Upgrade.FORTUNE_3)
                pTooltipComponents.add(Component.translatable("theworldbefore.tooltip.upgrades.fortune_3").withStyle(ChatFormatting.GREEN));

            pTooltipComponents.add(Component.translatable(this.upgradeCard.getToolTip()).withStyle(ChatFormatting.GREEN));
        }
    }



    public UpgradeCardItem(Upgrade upgrade, int maxStack) {
        super(new Properties().stacksTo(maxStack));
        this.upgradeCard = upgrade;
    }

    public UpgradeCardItem(Upgrade upgrade) {
        super(new Properties().stacksTo(1));
        this.upgradeCard = upgrade;
    }

    public Upgrade getCard() {
        return upgradeCard;
    }

}
