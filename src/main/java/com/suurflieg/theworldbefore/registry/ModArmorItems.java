package com.suurflieg.theworldbefore.registry;


import com.suurflieg.theworldbefore.TheWorldBefore;
import com.suurflieg.theworldbefore.custom.item.armor.CustomArmorItem;
import com.suurflieg.theworldbefore.modtiers.ModArmorMaterial;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModArmorItems {

    public static final DeferredRegister<Item> ARMOR_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TheWorldBefore.MOD_ID);

    public static final RegistryObject<Item> TITANIUM_HELMET = ARMOR_ITEMS.register("titanium_helmet", () -> new CustomArmorItem(ModArmorMaterial.TITANIUM, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> TITANIUM_CHESTPLATE = ARMOR_ITEMS.register("titanium_chestplate", () -> new CustomArmorItem(ModArmorMaterial.TITANIUM, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> TITANIUM_LEGGINGS = ARMOR_ITEMS.register("titanium_leggings", () -> new CustomArmorItem(ModArmorMaterial.TITANIUM, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> TITANIUM_BOOTS = ARMOR_ITEMS.register("titanium_boots", () -> new CustomArmorItem(ModArmorMaterial.TITANIUM, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static void  register(IEventBus eventBus) {ARMOR_ITEMS.register(eventBus);}
}
