package com.suurflieg.theworldbefore.registry;


import com.suurflieg.theworldbefore.TheWorldBefore;
import com.suurflieg.theworldbefore.custom.item.tool.CustomSwordItem;
import com.suurflieg.theworldbefore.modtiers.ModItemTier;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModWeaponItems {

    public static final DeferredRegister<Item> WEAPON_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TheWorldBefore.MOD_ID);

    private static final Item.Properties STACKS_TO = new Item.Properties().stacksTo(1);

    public static final RegistryObject<Item> TITANIUM_SWORD = WEAPON_ITEMS.register("titanium_sword", () -> new CustomSwordItem(ModItemTier.TITANIUM, 7, 0f, STACKS_TO));


    public static void  register(IEventBus eventBus) {
        WEAPON_ITEMS.register(eventBus);
    }
}
