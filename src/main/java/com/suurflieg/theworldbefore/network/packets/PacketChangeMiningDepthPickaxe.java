package com.suurflieg.theworldbefore.network.packets;


import com.suurflieg.theworldbefore.item.tool.CustomPickaxeItem;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

@SuppressWarnings("InstantiationOfUtilityClass")
public class PacketChangeMiningDepthPickaxe {
    private final int newDepth;

    public PacketChangeMiningDepthPickaxe(int newDepth) {
        this.newDepth = newDepth;
    }

    public int getNewDepth() {
        return newDepth;
    }

    public static void encode(PacketChangeMiningDepthPickaxe msg, FriendlyByteBuf buffer) {
        buffer.writeInt(msg.newDepth);
    }

    public static PacketChangeMiningDepthPickaxe decode(FriendlyByteBuf buffer) {
        int newDepth = buffer.readInt();
        return new PacketChangeMiningDepthPickaxe(newDepth);
    }

    public static class Handler {
        public static void handle(PacketChangeMiningDepthPickaxe msg, Supplier<NetworkEvent.Context> ctx) {
            ctx.get().enqueueWork(() -> {
                ServerPlayer player = ctx.get().getSender();
                if (player == null)
                    return;

                ItemStack pickaxe = CustomPickaxeItem.findItemStackInInventory(player);
                CustomPickaxeItem.changeDepth(pickaxe, msg.getNewDepth());
            });

            ctx.get().setPacketHandled(true);
        }
    }
}

