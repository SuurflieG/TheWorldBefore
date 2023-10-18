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
            switch (upgradeCard){
                case SILK: pTooltipComponents.add(Component.translatable("theworldbefore.tooltip.upgrades.silk_touch").withStyle(ChatFormatting.GREEN));break;
                case FORTUNE_1: pTooltipComponents.add(Component.translatable("theworldbefore.tooltip.upgrades.fortune_1").withStyle(ChatFormatting.GREEN));break;
                case FORTUNE_2: pTooltipComponents.add(Component.translatable("theworldbefore.tooltip.upgrades.fortune_2").withStyle(ChatFormatting.BLUE));break;
                case FORTUNE_3: pTooltipComponents.add(Component.translatable("theworldbefore.tooltip.upgrades.fortune_3").withStyle(ChatFormatting.GOLD));break;
                case EXPANDER: pTooltipComponents.add(Component.translatable("theworldbefore.tooltip.upgrades.expander").withStyle(ChatFormatting.GREEN));break;
                case DEPTH: pTooltipComponents.add(Component.translatable("theworldbefore.tooltip.upgrades.depth").withStyle(ChatFormatting.GREEN));break;
                case MENDING:pTooltipComponents.add(Component.translatable("theworldbefore.tooltip.upgrades.mending").withStyle(ChatFormatting.GREEN));break;
                case AQUA_AFFINITY: pTooltipComponents.add(Component.translatable("theworldbefore.tooltip.upgrades.aqua_affinity").withStyle(ChatFormatting.GREEN));break;
                case FIRE_ELEMENT:pTooltipComponents.add(Component.translatable("theworldbefore.tooltip.upgrades.fire_element").withStyle(ChatFormatting.GREEN));break;
                case ICE_ELEMENT:pTooltipComponents.add(Component.translatable("theworldbefore.tooltip.upgrades.ice_element").withStyle(ChatFormatting.GREEN));break;
                case WIND_ELEMENT:pTooltipComponents.add(Component.translatable("theworldbefore.tooltip.upgrades.wind_element").withStyle(ChatFormatting.GREEN));break;
                case ELECTRIC_ELEMENT:pTooltipComponents.add(Component.translatable("theworldbefore.tooltip.upgrades.electric_element").withStyle(ChatFormatting.GREEN));break;
                case BANE_OF_ARTHROPODS_1: pTooltipComponents.add(Component.translatable("theworldbefore.tooltip.upgrades.bane_of_arthropods_1").withStyle(ChatFormatting.GREEN));break;
                case BANE_OF_ARTHROPODS_2:pTooltipComponents.add(Component.translatable("theworldbefore.tooltip.upgrades.bane_of_arthropods_2").withStyle(ChatFormatting.BLUE));break;
                case BANE_OF_ARTHROPODS_3:pTooltipComponents.add(Component.translatable("theworldbefore.tooltip.upgrades.bane_of_arthropods_3").withStyle(ChatFormatting.GOLD));break;
                case BANE_OF_ARTHROPODS_4:pTooltipComponents.add(Component.translatable("theworldbefore.tooltip.upgrades.bane_of_arthropods_4").withStyle(ChatFormatting.DARK_PURPLE));break;
                case BANE_OF_ARTHROPODS_5:pTooltipComponents.add(Component.translatable("theworldbefore.tooltip.upgrades.bane_of_arthropods_5").withStyle(ChatFormatting.DARK_RED));break;
                case BLAST_PROTECTION_1:pTooltipComponents.add(Component.translatable("theworldbefore.tooltip.upgrades.blast_protection_1").withStyle(ChatFormatting.GREEN));break;
                case BLAST_PROTECTION_2:pTooltipComponents.add(Component.translatable("theworldbefore.tooltip.upgrades.blast_protection_2").withStyle(ChatFormatting.BLUE));break;
                case BLAST_PROTECTION_3:pTooltipComponents.add(Component.translatable("theworldbefore.tooltip.upgrades.blast_protection_3").withStyle(ChatFormatting.GOLD));break;
                case BLAST_PROTECTION_4:pTooltipComponents.add(Component.translatable("theworldbefore.tooltip.upgrades.blast_protection_4").withStyle(ChatFormatting.DARK_PURPLE));break;
                case DEPTH_STRIDER_1:break;
                case DEPTH_STRIDER_2:break;
                case DEPTH_STRIDER_3:break;
                case EFFICIENCY_1:break;
                case EFFICIENCY_2:break;
                case EFFICIENCY_3:break;
                case EFFICIENCY_4:break;
                case EFFICIENCY_5:break;
                case FEATHER_FALLING_1:break;
                case FEATHER_FALLING_2:break;
                case FEATHER_FALLING_3:break;
                case FEATHER_FALLING_4:break;
                case FIRE_ASPECT_1:break;
                case FIRE_ASPECT_2:break;
                case FIRE_PROTECTION_1:break;
                case FIRE_PROTECTION_2:break;
                case FIRE_PROTECTION_3:break;
                case FIRE_PROTECTION_4:break;
                case FROST_WALKER_1:break;
                case FROST_WALKER_2:break;
                case KNOCKBACK_1:break;
                case KNOCKBACK_2:break;
                case MOB_LOOTING_1:break;
                case MOB_LOOTING_2:break;
                case MOB_LOOTING_3:break;
                case PROJECTILE_PROTECTION_1:break;
                case PROJECTILE_PROTECTION_2:break;
                case PROJECTILE_PROTECTION_3:break;
                case PROJECTILE_PROTECTION_4:break;
                case PROTECTION_1:break;
                case PROTECTION_2:break;
                case PROTECTION_3:break;
                case PROTECTION_4:break;
                case RESPIRATION_1:break;
                case RESPIRATION_2:break;
                case RESPIRATION_3:break;
                case SHARPNESS_1:break;
                case SHARPNESS_2:break;
                case SHARPNESS_3:break;
                case SHARPNESS_4:break;
                case SHARPNESS_5:break;
                case SMITE_1:break;
                case SMITE_2:break;
                case SMITE_3:break;
                case SMITE_4:break;
                case SMITE_5:break;
                case SOUL_SPEED_1:break;
                case SOUL_SPEED_2:break;
                case SOUL_SPEED_3:break;
                case SWEEPING_EDGE_1:break;
                case SWEEPING_EDGE_2:break;
                case SWEEPING_EDGE_3:break;
                case THORNS_1:break;
                case THORNS_2:break;
                case THORNS_3:break;
                case UNBREAKING_1:break;
                case UNBREAKING_2:break;
                case UNBREAKING_3:break;

                default:
                     pTooltipComponents.add(Component.translatable("theworldbefore.tooltip.upgrades.unknown").withStyle(ChatFormatting.WHITE)); break;
            }
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
