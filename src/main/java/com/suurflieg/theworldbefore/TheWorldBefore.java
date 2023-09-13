package com.suurflieg.theworldbefore;

import com.mojang.logging.LogUtils;
import com.suurflieg.theworldbefore.config.ClientConfigs;
import com.suurflieg.theworldbefore.config.CommonConfigs;
import com.suurflieg.theworldbefore.custom.gui.menu.UpgradeStationMenu;
import com.suurflieg.theworldbefore.custom.gui.screen.UpgradeStationScreen;
import com.suurflieg.theworldbefore.custom.util.TheWorldBeforeKeyBinding;
import com.suurflieg.theworldbefore.registry.*;
import net.minecraft.client.gui.screens.MenuScreens;
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

@Mod(TheWorldBefore.MOD_ID)
public class TheWorldBefore {
    public static final String MOD_ID = "theworldbefore";
    private static final Logger LOGGER = LogUtils.getLogger();
    public TheWorldBefore() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModeTab.register(modEventBus);
        ModItems.register(modEventBus);
        ModUpgradeCards.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModArmorItems.register(modEventBus);
        ModToolItems.register(modEventBus);
        ModWeaponItems.register(modEventBus);

        ModBlockEntities.register(modEventBus);
        ModRecipes.register(modEventBus);
        ModMenuTypes.register(modEventBus);

        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, ClientConfigs.SPEC, "theworldbefore-client.toml");
        //ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CommonConfigs.SPEC, "theworldbefore-common.toml");

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

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


        }
    }
}
