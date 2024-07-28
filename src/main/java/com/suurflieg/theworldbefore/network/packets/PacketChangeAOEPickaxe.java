package com.suurflieg.theworldbefore.network.packets;


import com.suurflieg.theworldbefore.item.tool.CustomPickaxeItem;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

@SuppressWarnings("InstantiationOfUtilityClass")
public class PacketChangeAOEPickaxe {
    private final int newSize;

    public PacketChangeAOEPickaxe(int newSize) {
        this.newSize = newSize;
    }

    public int getNewSize() {
        return newSize;
    }

    public static void encode(PacketChangeAOEPickaxe msg, FriendlyByteBuf buffer) {
        buffer.writeInt(msg.newSize);
    }

    public static PacketChangeAOEPickaxe decode(FriendlyByteBuf buffer) {
        int newSize = buffer.readInt();
        return new PacketChangeAOEPickaxe(newSize);
    }

    public static class Handler {
        public static void handle(PacketChangeAOEPickaxe msg, Supplier<NetworkEvent.Context> ctx) {
            ctx.get().enqueueWork(() -> {
                ServerPlayer player = ctx.get().getSender();
                if (player == null)
                    return;

                ItemStack pickaxe = CustomPickaxeItem.findItemStackInInventory(player);
                CustomPickaxeItem.changeSize(pickaxe, msg.getNewSize());

            });

            ctx.get().setPacketHandled(true);
        }
    }
}