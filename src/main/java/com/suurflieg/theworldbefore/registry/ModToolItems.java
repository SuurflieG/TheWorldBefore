package com.suurflieg.theworldbefore.registry;


import com.suurflieg.theworldbefore.TheWorldBefore;
import com.suurflieg.theworldbefore.custom.item.tool.CustomAxeItem;
import com.suurflieg.theworldbefore.custom.item.tool.CustomHoeItem;
import com.suurflieg.theworldbefore.custom.item.tool.CustomPickaxeItem;
import com.suurflieg.theworldbefore.custom.item.tool.CustomShovelItem;
import com.suurflieg.theworldbefore.modtiers.ModItemTier;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModToolItems {

    public static final DeferredRegister<Item> TOOL_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TheWorldBefore.MOD_ID);

    private static final Item.Properties STACKS_TO = new Item.Properties().stacksTo(1);

    public static final RegistryObject<Item> TITANIUM_AXE = TOOL_ITEMS.register("titanium_axe", () -> new CustomAxeItem(ModItemTier.TITANIUM, 5, 0f, STACKS_TO));
    public static final RegistryObject<Item> TITANIUM_PICKAXE = TOOL_ITEMS.register("titanium_pickaxe", () -> new CustomPickaxeItem(ModItemTier.TITANIUM, 5, 0f, STACKS_TO));
    public static final RegistryObject<Item> TITANIUM_SHOVEL = TOOL_ITEMS.register("titanium_shovel", () -> new CustomShovelItem(ModItemTier.TITANIUM, 2, 0f, STACKS_TO));
    public static final RegistryObject<Item> TITANIUM_HOE = TOOL_ITEMS.register("titanium_hoe", () -> new CustomHoeItem(ModItemTier.TITANIUM, 2, 0f, STACKS_TO));

    public static void  register(IEventBus eventBus) {
        TOOL_ITEMS.register(eventBus);
    }
}
