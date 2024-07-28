package com.suurflieg.theworldbefore.network.packets;


import com.suurflieg.theworldbefore.gui.screen.CustomEquipmentScreen;
import com.suurflieg.theworldbefore.gui.screen.CustomToolScreen;
import com.suurflieg.theworldbefore.item.tool.CustomShovelItem;
import com.suurflieg.theworldbefore.item.upgradecards.Upgrade;
import com.suurflieg.theworldbefore.item.upgradecards.UpgradeTools;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public record PacketUpdateUpgradeShovel(String upgrade) {

    public static void encode(PacketUpdateUpgradeShovel msg, FriendlyByteBuf buffer) {
        buffer.writeUtf(msg.upgrade);
    }

    public static PacketUpdateUpgradeShovel decode(FriendlyByteBuf buffer) {
        return new PacketUpdateUpgradeShovel(buffer.readUtf(100));
    }

    public static class Handler {
        public static void handle(PacketUpdateUpgradeShovel msg, Supplier<NetworkEvent.Context> ctx) {
            ctx.get().enqueueWork(() -> {
                ServerPlayer player = ctx.get().getSender();

                if (player == null)
                    return;

                Upgrade upgrade = UpgradeTools.getUpgradesByName(msg.upgrade);
                if (upgrade == null)
                    return;

                ItemStack shovel = CustomShovelItem.findItemStackInInventory(player);
                UpgradeTools.updateUpgrade(shovel, upgrade);
                CustomToolScreen.updateButtons(upgrade, shovel);
                CustomEquipmentScreen.updateButtons(upgrade, shovel);

            });

            ctx.get().setPacketHandled(true);
        }
    }
}
