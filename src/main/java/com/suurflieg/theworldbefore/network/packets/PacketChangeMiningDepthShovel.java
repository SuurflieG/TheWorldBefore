package com.suurflieg.theworldbefore.network.packets;


import com.suurflieg.theworldbefore.item.tool.CustomShovelItem;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

@SuppressWarnings("InstantiationOfUtilityClass")
public class PacketChangeMiningDepthShovel {
    private final int newDepth;

    public PacketChangeMiningDepthShovel(int newDepth) {
        this.newDepth = newDepth;
    }

    public int getNewDepth() {
        return newDepth;
    }

    public static void encode(PacketChangeMiningDepthShovel msg, FriendlyByteBuf buffer) {
        buffer.writeInt(msg.newDepth);
    }

    public static PacketChangeMiningDepthShovel decode(FriendlyByteBuf buffer) {
        int newDepth = buffer.readInt();
        return new PacketChangeMiningDepthShovel(newDepth);
    }

    public static class Handler {
        public static void handle(PacketChangeMiningDepthShovel msg, Supplier<NetworkEvent.Context> ctx) {
            ctx.get().enqueueWork(() -> {
                ServerPlayer player = ctx.get().getSender();
                if (player == null)
                    return;

                ItemStack shovel = CustomShovelItem.findItemStackInInventory(player);
                CustomShovelItem.changeDepth(shovel, msg.getNewDepth());
            });

            ctx.get().setPacketHandled(true);
        }
    }
}

