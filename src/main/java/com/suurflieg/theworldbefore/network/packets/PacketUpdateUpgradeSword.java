package com.suurflieg.theworldbefore.network.packets;


import com.suurflieg.theworldbefore.gui.screen.CustomEquipmentScreen;
import com.suurflieg.theworldbefore.gui.screen.CustomWeaponScreen;
import com.suurflieg.theworldbefore.item.tool.CustomSwordItem;
import com.suurflieg.theworldbefore.item.upgradecards.Upgrade;
import com.suurflieg.theworldbefore.item.upgradecards.UpgradeTools;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public record PacketUpdateUpgradeSword(String upgrade) {

    public static void encode(PacketUpdateUpgradeSword msg, FriendlyByteBuf buffer) {
        buffer.writeUtf(msg.upgrade);
    }

    public static PacketUpdateUpgradeSword decode(FriendlyByteBuf buffer) {
        return new PacketUpdateUpgradeSword(buffer.readUtf(100));
    }

    public static class Handler {
        public static void handle(PacketUpdateUpgradeSword msg, Supplier<NetworkEvent.Context> ctx) {
            ctx.get().enqueueWork(() -> {
                ServerPlayer player = ctx.get().getSender();

                if (player == null)
                    return;

                Upgrade upgrade = UpgradeTools.getUpgradesByName(msg.upgrade);
                if (upgrade == null)
                    return;

                ItemStack sword = CustomSwordItem.findItemStackInInventory(player);
                UpgradeTools.updateUpgrade(sword, upgrade);
                CustomWeaponScreen.updateButtons(upgrade, sword);
                CustomEquipmentScreen.updateButtons(upgrade, sword);

            });

            ctx.get().setPacketHandled(true);
        }
    }
}
