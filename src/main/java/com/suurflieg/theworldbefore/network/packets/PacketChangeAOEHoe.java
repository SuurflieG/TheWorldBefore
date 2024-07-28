package com.suurflieg.theworldbefore.network.packets;


import com.suurflieg.theworldbefore.item.tool.CustomHoeItem;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

@SuppressWarnings("InstantiationOfUtilityClass")
public class PacketChangeAOEHoe {
    private final int newSize;

    public PacketChangeAOEHoe(int newSize) {
        this.newSize = newSize;
    }

    public int getNewSize() {
        return newSize;
    }

    public static void encode(PacketChangeAOEHoe msg, FriendlyByteBuf buffer) {
        buffer.writeInt(msg.newSize);
    }

    public static PacketChangeAOEHoe decode(FriendlyByteBuf buffer) {
        int newSize = buffer.readInt();
        return new PacketChangeAOEHoe(newSize);
    }

    public static class Handler {
        public static void handle(PacketChangeAOEHoe msg, Supplier<NetworkEvent.Context> ctx) {
            ctx.get().enqueueWork(() -> {
                ServerPlayer player = ctx.get().getSender();
                if (player == null)
                    return;

                ItemStack hoe = CustomHoeItem.findItemStackInInventory(player);
                CustomHoeItem.changeTillSize(hoe, msg.getNewSize());

            });

            ctx.get().setPacketHandled(true);
        }
    }
}