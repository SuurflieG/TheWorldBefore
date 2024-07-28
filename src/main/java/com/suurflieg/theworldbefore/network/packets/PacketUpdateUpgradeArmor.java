package com.suurflieg.theworldbefore.network.packets;


import com.suurflieg.theworldbefore.gui.screen.CustomArmorScreen;
import com.suurflieg.theworldbefore.gui.screen.CustomEquipmentScreen;
import com.suurflieg.theworldbefore.item.armor.CustomArmorItem;
import com.suurflieg.theworldbefore.item.upgradecards.Upgrade;
import com.suurflieg.theworldbefore.item.upgradecards.UpgradeTools;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public record PacketUpdateUpgradeArmor(String upgrade) {

    public static void encode(PacketUpdateUpgradeArmor msg, FriendlyByteBuf buffer) {
        buffer.writeUtf(msg.upgrade);
    }

    public static PacketUpdateUpgradeArmor decode(FriendlyByteBuf buffer) {
        return new PacketUpdateUpgradeArmor(buffer.readUtf(100));
    }

    public static class Handler {
        public static void handle(PacketUpdateUpgradeArmor msg, Supplier<NetworkEvent.Context> ctx) {
            ctx.get().enqueueWork(() -> {
                ServerPlayer player = ctx.get().getSender();

                if (player == null)
                    return;

                Upgrade upgrade = UpgradeTools.getUpgradesByName(msg.upgrade);
                if (upgrade == null)
                    return;

                ItemStack armor = CustomArmorItem.findItemStackInInventory(player);
                UpgradeTools.updateUpgrade(armor, upgrade);
                CustomArmorScreen.updateButtons(upgrade, armor);
                CustomEquipmentScreen.updateButtons(upgrade, armor);

            });

            ctx.get().setPacketHandled(true);
        }
    }
}
