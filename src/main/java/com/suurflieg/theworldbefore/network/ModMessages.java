package com.suurflieg.theworldbefore.network;

/*public class ModMessages {

    private static SimpleChannel INSTANCE;
    private static int packetId = 0;
    private static int id(){
        return packetId++;
    }

    public static void register(){
        SimpleChannel net = NetworkRegistry.ChannelBuilder
                .named(new ResourceLocation(TheWorldBefore.MOD_ID, "messages"))
                .networkProtocolVersion(()-> "1.0")
                .clientAcceptedVersions(s -> true)
                .serverAcceptedVersions(s -> true)
                .simpleChannel();

        INSTANCE = net;

        net.messageBuilder(PacketUpdateUpgrade.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(PacketUpdateUpgrade::new)
                .encoder(PacketUpdateUpgrade::toBytes)
                .consumerMainThread(PacketUpdateUpgrade::handle)
                .add();
    }
}*/
