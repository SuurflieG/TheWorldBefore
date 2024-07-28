package com.suurflieg.theworldbefore.network.packets;


import com.suurflieg.theworldbefore.gui.screen.CustomEquipmentScreen;
import com.suurflieg.theworldbefore.gui.screen.CustomToolScreen;
import com.suurflieg.theworldbefore.item.tool.CustomHoeItem;
import com.suurflieg.theworldbefore.item.upgradecards.Upgrade;
import com.suurflieg.theworldbefore.item.upgradecards.UpgradeTools;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public record PacketUpdateUpgradeHoe(String upgrade) {

    public static void encode(PacketUpdateUpgradeHoe msg, FriendlyByteBuf buffer) {
        buffer.writeUtf(msg.upgrade);
    }

    public static PacketUpdateUpgradeHoe decode(FriendlyByteBuf buffer) {
        return new PacketUpdateUpgradeHoe(buffer.readUtf(100));
    }

    public static class Handler {
        public static void handle(PacketUpdateUpgradeHoe msg, Supplier<NetworkEvent.Context> ctx) {
            ctx.get().enqueueWork(() -> {
                ServerPlayer player = ctx.get().getSender();

                if (player == null)
                    return;

                Upgrade upgrade = UpgradeTools.getUpgradesByName(msg.upgrade);
                if (upgrade == null)
                    return;

                ItemStack hoe = CustomHoeItem.findItemStackInInventory(player);
                UpgradeTools.updateUpgrade(hoe, upgrade);
                CustomToolScreen.updateButtons(upgrade, hoe);
                CustomEquipmentScreen.updateButtons(upgrade, hoe);

            });

            ctx.get().setPacketHandled(true);
        }
    }
}
