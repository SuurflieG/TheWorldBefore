package com.suurflieg.theworldbefore.network.packets;


import com.suurflieg.theworldbefore.gui.screen.CustomEquipmentScreen;
import com.suurflieg.theworldbefore.gui.screen.CustomToolScreen;
import com.suurflieg.theworldbefore.item.tool.CustomPickaxeItem;
import com.suurflieg.theworldbefore.item.upgradecards.Upgrade;
import com.suurflieg.theworldbefore.item.upgradecards.UpgradeTools;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public record PacketUpdateUpgradePickaxe(String upgrade) {

    public static void encode(PacketUpdateUpgradePickaxe msg, FriendlyByteBuf buffer) {
        buffer.writeUtf(msg.upgrade);
    }

    public static PacketUpdateUpgradePickaxe decode(FriendlyByteBuf buffer) {
        return new PacketUpdateUpgradePickaxe(buffer.readUtf(100));
    }

    public static class Handler {
        public static void handle(PacketUpdateUpgradePickaxe msg, Supplier<NetworkEvent.Context> ctx) {
            ctx.get().enqueueWork(() -> {
                ServerPlayer player = ctx.get().getSender();

                if (player == null)
                    return;

                Upgrade upgrade = UpgradeTools.getUpgradesByName(msg.upgrade);
                if (upgrade == null)
                    return;

                ItemStack pickaxe = CustomPickaxeItem.findItemStackInInventory(player);
                UpgradeTools.updateUpgrade(pickaxe, upgrade);
                CustomToolScreen.updateButtons(upgrade, pickaxe);
                CustomEquipmentScreen.updateButtons(upgrade, pickaxe);

            });

            ctx.get().setPacketHandled(true);
        }
    }
}
