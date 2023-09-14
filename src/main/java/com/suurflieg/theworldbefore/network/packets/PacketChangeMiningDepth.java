package com.suurflieg.theworldbefore.network.packets;



import com.suurflieg.theworldbefore.item.tool.CustomPickaxeItem;
import com.suurflieg.theworldbefore.item.tool.CustomShovelItem;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

@SuppressWarnings("InstantiationOfUtilityClass")
public class PacketChangeMiningDepth {
    public PacketChangeMiningDepth() {}

    public static void encode(PacketChangeMiningDepth msg, FriendlyByteBuf buffer) {}
    public static PacketChangeMiningDepth decode(FriendlyByteBuf buffer) { return new PacketChangeMiningDepth(); }

    public static class Handler {
        public static void handle(PacketChangeMiningDepth msg, Supplier<NetworkEvent.Context> ctx) {
            ctx.get().enqueueWork(() -> {
                ServerPlayer player = ctx.get().getSender();
                if (player == null)
                    return;

                ItemStack pickaxe = CustomPickaxeItem.getPickaxe(player);
                CustomPickaxeItem.changeDepth(pickaxe);

                ItemStack shovel = CustomShovelItem.getShovel(player);
                CustomShovelItem.changeDepth(shovel);

 /*               ItemStack axe = CustomAxeItem.getAxe(player);
                CustomAxeItem.changeDepth(axe);

                ItemStack hoe = CustomHoeItem.getHoe(player);
                CustomHoeItem.changeDepth(hoe);*/
            });

            ctx.get().setPacketHandled(true);
        }
    }
}
