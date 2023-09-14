package com.suurflieg.theworldbefore.network;


import com.suurflieg.theworldbefore.TheWorldBefore;
import com.suurflieg.theworldbefore.network.packets.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

public class PacketHandler {

    private static final String PROTOCOL_VERSION = Integer.toString(2);
    private static final short index = 0;

    public static final SimpleChannel HANDLER = NetworkRegistry.ChannelBuilder
            .named(new ResourceLocation(TheWorldBefore.MOD_ID, "main_network_channel"))
            .clientAcceptedVersions(PROTOCOL_VERSION::equals)
            .serverAcceptedVersions(PROTOCOL_VERSION::equals)
            .networkProtocolVersion(() -> PROTOCOL_VERSION)
            .simpleChannel();


    public static void register() {
        int id = 0;

        HANDLER.registerMessage(id++, PacketExtractUpgrade.class,     PacketExtractUpgrade::encode,       PacketExtractUpgrade::decode,       PacketExtractUpgrade.Handler::handle);
        HANDLER.registerMessage(id++, PacketUpdateUpgrade.class,      PacketUpdateUpgrade::encode,        PacketUpdateUpgrade::decode,        PacketUpdateUpgrade.Handler::handle);
        HANDLER.registerMessage(id++, PacketChangeMiningSize.class,   PacketChangeMiningSize::encode,     PacketChangeMiningSize::decode,     PacketChangeMiningSize.Handler::handle);
        HANDLER.registerMessage(id++, PacketChangeMiningDepth.class,   PacketChangeMiningDepth::encode,     PacketChangeMiningDepth::decode,     PacketChangeMiningDepth.Handler::handle);
        HANDLER.registerMessage(id++, PacketGhostSlot.class,          PacketGhostSlot::encode,            PacketGhostSlot::decode,            PacketGhostSlot.Handler::handle);

        HANDLER.registerMessage(id++, PacketInsertUpgrade.class,      PacketInsertUpgrade::encode,        PacketInsertUpgrade::decode,        PacketInsertUpgrade::handler);
    }

    public static void sendTo(Object msg, ServerPlayer player) {
        if (!(player instanceof FakePlayer))
            HANDLER.sendTo(msg, player.connection.connection, NetworkDirection.PLAY_TO_CLIENT);
    }

    public static void sendToAll(Object msg, Level world) {
        for (Player player : world.players()) {
            if (!(player instanceof FakePlayer))
                HANDLER.sendTo(msg, ((ServerPlayer) player).connection.connection, NetworkDirection.PLAY_TO_CLIENT);
        }
    }

    public static void sendToServer(Object msg) {
        HANDLER.sendToServer(msg);
    }

}
