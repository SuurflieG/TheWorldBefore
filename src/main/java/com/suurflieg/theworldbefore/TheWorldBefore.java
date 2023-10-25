package com.suurflieg.theworldbefore;

import com.mojang.logging.LogUtils;
import com.suurflieg.theworldbefore.config.ClientConfigs;
import com.suurflieg.theworldbefore.config.CommonConfigs;
import com.suurflieg.theworldbefore.gui.screen.SmithingTablePlusScreen;
import com.suurflieg.theworldbefore.gui.screen.UpgradeStationScreen;
import com.suurflieg.theworldbefore.network.PacketHandler;
import com.suurflieg.theworldbefore.registry.*;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import java.util.Locale;

@Mod(TheWorldBefore.MOD_ID)
public class TheWorldBefore {
    public static final String MOD_ID = "theworldbefore";
    private static final Logger LOGGER = LogUtils.getLogger();
    public TheWorldBefore() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModeTab.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModBlockEntities.register(modEventBus);
        ModRecipesSerializer.register(modEventBus);
        ModRecipeTypes.register(modEventBus);
        ModMenuTypes.register(modEventBus);

        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, ClientConfigs.SPEC, "theworldbefore-client.toml");
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CommonConfigs.SPEC, "theworldbefore-common.toml");

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

        PacketHandler.register();
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        // Use this to add items etc to vanilla creative tabs
        /*if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS){
            event.accept(ModItems.TITANIUM_INGOT);
        }*/

    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            MenuScreens.register(ModMenuTypes.UPGRADE_STATION_MENU.get(), UpgradeStationScreen::new);
            MenuScreens.register(ModMenuTypes.SMITHING_TABLE_PLUS_MENU.get(), SmithingTablePlusScreen::new);


        }
    }

    public static ResourceLocation prefix(String name) {
        return new ResourceLocation(MOD_ID, name.toLowerCase(Locale.ROOT));
    }
}
