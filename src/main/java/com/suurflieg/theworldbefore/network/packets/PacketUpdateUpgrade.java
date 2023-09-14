package com.suurflieg.theworldbefore.network.packets;


import com.suurflieg.theworldbefore.gui.screen.CustomArmorScreen;
import com.suurflieg.theworldbefore.gui.screen.CustomToolScreen;
import com.suurflieg.theworldbefore.gui.screen.CustomWeaponScreen;
import com.suurflieg.theworldbefore.item.armor.CustomArmorItem;
import com.suurflieg.theworldbefore.item.tool.*;
import com.suurflieg.theworldbefore.item.upgradecards.Upgrade;
import com.suurflieg.theworldbefore.item.upgradecards.UpgradeTools;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public record PacketUpdateUpgrade(String upgrade) {

    public static void encode(PacketUpdateUpgrade msg, FriendlyByteBuf buffer) {
        buffer.writeUtf(msg.upgrade);
    }

    public static PacketUpdateUpgrade decode(FriendlyByteBuf buffer) {
        return new PacketUpdateUpgrade(buffer.readUtf(100));
    }

    public static class Handler {
        public static void handle(PacketUpdateUpgrade msg, Supplier<NetworkEvent.Context> ctx) {
            ctx.get().enqueueWork(() -> {
                ServerPlayer player = ctx.get().getSender();

                if (player == null)
                    return;

                Upgrade upgrade = UpgradeTools.getUpgradesByName(msg.upgrade);
                if (upgrade == null)
                    return;

                ItemStack stack = CustomPickaxeItem.getPickaxe(player);
                UpgradeTools.updateUpgrade(stack, upgrade);
                CustomToolScreen.updateButtons(upgrade, stack);

                ItemStack stack1 = CustomShovelItem.getShovel(player);
                UpgradeTools.updateUpgrade(stack1, upgrade);
                CustomToolScreen.updateButtons(upgrade, stack1);

                ItemStack stack2 = CustomAxeItem.getAxe(player);
                UpgradeTools.updateUpgrade(stack2, upgrade);
                CustomToolScreen.updateButtons(upgrade, stack2);

                ItemStack stack3 = CustomHoeItem.getHoe(player);
                UpgradeTools.updateUpgrade(stack3, upgrade);
                CustomToolScreen.updateButtons(upgrade, stack3);

                ItemStack stack4 = CustomSwordItem.getSword(player);
                UpgradeTools.updateUpgrade(stack4, upgrade);
                CustomWeaponScreen.updateButtons(upgrade, stack4);

                ItemStack stack5 = CustomArmorItem.getArmor(player);
                UpgradeTools.updateUpgrade(stack5, upgrade);
                CustomArmorScreen.updateButtons(upgrade, stack5);
            });

            ctx.get().setPacketHandled(true);
        }
    }
}
