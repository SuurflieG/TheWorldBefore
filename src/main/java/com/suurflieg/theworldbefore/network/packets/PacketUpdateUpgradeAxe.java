package com.suurflieg.theworldbefore.network.packets;


import com.suurflieg.theworldbefore.gui.screen.CustomEquipmentScreen;
import com.suurflieg.theworldbefore.gui.screen.CustomToolScreen;
import com.suurflieg.theworldbefore.item.tool.CustomAxeItem;
import com.suurflieg.theworldbefore.item.upgradecards.Upgrade;
import com.suurflieg.theworldbefore.item.upgradecards.UpgradeTools;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public record PacketUpdateUpgradeAxe(String upgrade) {

    public static void encode(PacketUpdateUpgradeAxe msg, FriendlyByteBuf buffer) {
        buffer.writeUtf(msg.upgrade);
    }

    public static PacketUpdateUpgradeAxe decode(FriendlyByteBuf buffer) {
        return new PacketUpdateUpgradeAxe(buffer.readUtf(100));
    }

    public static class Handler {
        public static void handle(PacketUpdateUpgradeAxe msg, Supplier<NetworkEvent.Context> ctx) {
            ctx.get().enqueueWork(() -> {
                ServerPlayer player = ctx.get().getSender();

                if (player == null)
                    return;

                Upgrade upgrade = UpgradeTools.getUpgradesByName(msg.upgrade);
                if (upgrade == null)
                    return;

                ItemStack axe = CustomAxeItem.findItemStackInInventory(player);
                UpgradeTools.updateUpgrade(axe, upgrade);
                CustomToolScreen.updateButtons(upgrade, axe);
                CustomEquipmentScreen.updateButtons(upgrade, axe);

            });

            ctx.get().setPacketHandled(true);
        }
    }
}
