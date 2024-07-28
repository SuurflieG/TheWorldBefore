package com.suurflieg.theworldbefore.network.packets;


import com.suurflieg.theworldbefore.item.tool.CustomShovelItem;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

@SuppressWarnings("InstantiationOfUtilityClass")
public class PacketChangeAOEShovel {
    private final int newSize;

    public PacketChangeAOEShovel(int newSize) {
        this.newSize = newSize;
    }

    public int getNewSize() {
        return newSize;
    }

    public static void encode(PacketChangeAOEShovel msg, FriendlyByteBuf buffer) {
        buffer.writeInt(msg.newSize);
    }

    public static PacketChangeAOEShovel decode(FriendlyByteBuf buffer) {
        int newSize = buffer.readInt();
        return new PacketChangeAOEShovel(newSize);
    }

    public static class Handler {
        public static void handle(PacketChangeAOEShovel msg, Supplier<NetworkEvent.Context> ctx) {
            ctx.get().enqueueWork(() -> {
                ServerPlayer player = ctx.get().getSender();
                if (player == null)
                    return;

                ItemStack shovel = CustomShovelItem.findItemStackInInventory(player);
                CustomShovelItem.changeSize(shovel, msg.getNewSize());

            });

            ctx.get().setPacketHandled(true);
        }
    }
}