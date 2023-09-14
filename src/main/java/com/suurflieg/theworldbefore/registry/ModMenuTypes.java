package com.suurflieg.theworldbefore.registry;


import com.suurflieg.theworldbefore.TheWorldBefore;
import com.suurflieg.theworldbefore.gui.menu.CustomArmorMenu;
import com.suurflieg.theworldbefore.gui.menu.CustomToolMenu;
import com.suurflieg.theworldbefore.gui.menu.CustomWeaponMenu;
import com.suurflieg.theworldbefore.gui.menu.UpgradeStationMenu;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(ForgeRegistries.MENU_TYPES, TheWorldBefore.MOD_ID);

    public static final RegistryObject<MenuType<CustomToolMenu>> CUSTOM_TOOL_MENU = registerMenuType(CustomToolMenu::new, "custom_tool_menu");
    public static final RegistryObject<MenuType<CustomArmorMenu>> CUSTOM_ARMOR_MENU = registerMenuType(CustomArmorMenu::new, "custom_armor_menu");
    public static final RegistryObject<MenuType<CustomWeaponMenu>> CUSTOM_WEAPON_MENU = registerMenuType(CustomWeaponMenu::new, "custom_weapon_menu");
    public static final RegistryObject<MenuType<UpgradeStationMenu>> UPGRADE_STATION_MENU = registerMenuType(UpgradeStationMenu::new, "upgrade_station_menu");


    private static <T extends AbstractContainerMenu> RegistryObject<MenuType<T>> registerMenuType(IContainerFactory<T> factory, String name) {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}