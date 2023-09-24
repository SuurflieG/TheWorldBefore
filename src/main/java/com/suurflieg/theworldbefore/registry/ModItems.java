package com.suurflieg.theworldbefore.registry;

import com.suurflieg.theworldbefore.TheWorldBefore;
import com.suurflieg.theworldbefore.item.armor.CustomArmorItem;
import com.suurflieg.theworldbefore.item.tool.*;
import com.suurflieg.theworldbefore.item.upgradecards.Upgrade;
import com.suurflieg.theworldbefore.modtiers.ModArmorMaterial;
import com.suurflieg.theworldbefore.modtiers.ModItemTier;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TheWorldBefore.MOD_ID);

    private static final Item.Properties STACKS_TO = new Item.Properties().stacksTo(1);

    public static final RegistryObject<Item> TITANIUM_RAW_ORE = ITEMS.register("titanium_raw_ore", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TITANIUM_NUGGET = ITEMS.register("titanium_nugget", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TITANIUM_INGOT = ITEMS.register("titanium_ingot", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> TITANIUM_SWORD = ITEMS.register("titanium_sword", () -> new CustomSwordItem(ModItemTier.TITANIUM, 7, 0f, STACKS_TO));
    public static final RegistryObject<Item> TITANIUM_AXE = ITEMS.register("titanium_axe", () -> new CustomAxeItem(ModItemTier.TITANIUM, 5, 0f, STACKS_TO));
    public static final RegistryObject<Item> TITANIUM_PICKAXE = ITEMS.register("titanium_pickaxe", () -> new CustomPickaxeItem(ModItemTier.TITANIUM, 5, 0f, STACKS_TO));
    public static final RegistryObject<Item> TITANIUM_SHOVEL = ITEMS.register("titanium_shovel", () -> new CustomShovelItem(ModItemTier.TITANIUM, 2, 0f, STACKS_TO));
    public static final RegistryObject<Item> TITANIUM_HOE = ITEMS.register("titanium_hoe", () -> new CustomHoeItem(ModItemTier.TITANIUM, 2, 0f, STACKS_TO));

    public static final RegistryObject<Item> TITANIUM_HELMET = ITEMS.register("titanium_helmet", () -> new CustomArmorItem(ModArmorMaterial.TITANIUM, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> TITANIUM_CHESTPLATE = ITEMS.register("titanium_chestplate", () -> new CustomArmorItem(ModArmorMaterial.TITANIUM, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> TITANIUM_LEGGINGS = ITEMS.register("titanium_leggings", () -> new CustomArmorItem(ModArmorMaterial.TITANIUM, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> TITANIUM_BOOTS = ITEMS.register("titanium_boots", () -> new CustomArmorItem(ModArmorMaterial.TITANIUM, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> AVENTURINE_SHARD = ITEMS.register("aventurine_shard", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PYRITE_SHARD = ITEMS.register("pyrite_shard", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RUBY_SHARD = ITEMS.register("ruby_shard", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TOPAZ_SHARD = ITEMS.register("topaz_shard", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SPECTROLITE_SHARD = ITEMS.register("spectrolite_shard", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> UNAKITE_SHARD = ITEMS.register("unakite_shard", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> BLANK = ITEMS.register("upgrade_blank",() -> Upgrade.BLANK.getCard());
    public static final RegistryObject<Item> SILK = ITEMS.register("upgrade_silk", () -> Upgrade.SILK.getCard());
    public static final RegistryObject<Item> MAGNET = ITEMS.register("upgrade_magnet", () -> Upgrade.MAGNET.getCard());
    public static final RegistryObject<Item> EXPANDER = ITEMS.register("upgrade_expander", () -> Upgrade.EXPANDER.getCard());
    public static final RegistryObject<Item> DEPTH = ITEMS.register("upgrade_depth", () -> Upgrade.DEPTH.getCard());
    public static final RegistryObject<Item> AQUA_AFFINITY = ITEMS.register("upgrade_aqua_affinity", () -> Upgrade.AQUA_AFFINITY.getCard());

    public static final RegistryObject<Item> FIRE_ELEMENT = ITEMS.register("upgrade_fire_element", () -> Upgrade.FIRE_ELEMENT.getCard());
    public static final RegistryObject<Item> ICE_ELEMENT = ITEMS.register("upgrade_ice_element", () -> Upgrade.ICE_ELEMENT.getCard());
    public static final RegistryObject<Item> WIND_ELEMENT = ITEMS.register("upgrade_wind_element", () -> Upgrade.WIND_ELEMENT.getCard());
    public static final RegistryObject<Item> ELECTRIC_ELEMENT = ITEMS.register("upgrade_electric_element", () -> Upgrade.ELECTRIC_ELEMENT.getCard());

    public static final RegistryObject<Item> BANE_OF_ARTHROPODS_1 = ITEMS.register("upgrade_bane_of_arthropods_1", () -> Upgrade.BANE_OF_ARTHROPODS_1.getCard());
    public static final RegistryObject<Item> BANE_OF_ARTHROPODS_2 = ITEMS.register("upgrade_bane_of_arthropods_2", () -> Upgrade.BANE_OF_ARTHROPODS_2.getCard());
    public static final RegistryObject<Item> BANE_OF_ARTHROPODS_3 = ITEMS.register("upgrade_bane_of_arthropods_3", () -> Upgrade.BANE_OF_ARTHROPODS_3.getCard());
    public static final RegistryObject<Item> BANE_OF_ARTHROPODS_4 = ITEMS.register("upgrade_bane_of_arthropods_4", () -> Upgrade.BANE_OF_ARTHROPODS_4.getCard());
    public static final RegistryObject<Item> BANE_OF_ARTHROPODS_5 = ITEMS.register("upgrade_bane_of_arthropods_5", () -> Upgrade.BANE_OF_ARTHROPODS_5.getCard());

    public static final RegistryObject<Item> BLAST_PROTECTION_1 = ITEMS.register("upgrade_blast_protection_1", () -> Upgrade.BLAST_PROTECTION_1.getCard());
    public static final RegistryObject<Item> BLAST_PROTECTION_2 = ITEMS.register("upgrade_blast_protection_2", () -> Upgrade.BLAST_PROTECTION_2.getCard());
    public static final RegistryObject<Item> BLAST_PROTECTION_3 = ITEMS.register("upgrade_blast_protection_3", () -> Upgrade.BLAST_PROTECTION_3.getCard());
    public static final RegistryObject<Item> BLAST_PROTECTION_4 = ITEMS.register("upgrade_blast_protection_4", () -> Upgrade.BLAST_PROTECTION_4.getCard());

    public static final RegistryObject<Item> DEPTH_STRIDER_1 = ITEMS.register("upgrade_depth_strider_1", () -> Upgrade.DEPTH_STRIDER_1.getCard());
    public static final RegistryObject<Item> DEPTH_STRIDER_2 = ITEMS.register("upgrade_depth_strider_2", () -> Upgrade.DEPTH_STRIDER_2.getCard());
    public static final RegistryObject<Item> DEPTH_STRIDER_3 = ITEMS.register("upgrade_depth_strider_3", () -> Upgrade.DEPTH_STRIDER_3.getCard());

    public static final RegistryObject<Item> EFFICIENCY_1 = ITEMS.register("upgrade_efficiency_1", () -> Upgrade.EFFICIENCY_1.getCard());
    public static final RegistryObject<Item> EFFICIENCY_2 = ITEMS.register("upgrade_efficiency_2", () -> Upgrade.EFFICIENCY_2.getCard());
    public static final RegistryObject<Item> EFFICIENCY_3 = ITEMS.register("upgrade_efficiency_3", () -> Upgrade.EFFICIENCY_3.getCard());
    public static final RegistryObject<Item> EFFICIENCY_4 = ITEMS.register("upgrade_efficiency_4", () -> Upgrade.EFFICIENCY_4.getCard());
    public static final RegistryObject<Item> EFFICIENCY_5 = ITEMS.register("upgrade_efficiency_5", () -> Upgrade.EFFICIENCY_5.getCard());

    public static final RegistryObject<Item> FEATHER_FALLING_1 = ITEMS.register("upgrade_feather_falling_1", () -> Upgrade.FEATHER_FALLING_1.getCard());
    public static final RegistryObject<Item> FEATHER_FALLING_2 = ITEMS.register("upgrade_feather_falling_2", () -> Upgrade.FEATHER_FALLING_2.getCard());
    public static final RegistryObject<Item> FEATHER_FALLING_3 = ITEMS.register("upgrade_feather_falling_3", () -> Upgrade.FEATHER_FALLING_3.getCard());
    public static final RegistryObject<Item> FEATHER_FALLING_4 = ITEMS.register("upgrade_feather_falling_4", () -> Upgrade.FEATHER_FALLING_4.getCard());

    public static final RegistryObject<Item> FIRE_ASPECT_1 = ITEMS.register("upgrade_fire_aspect_1", () -> Upgrade.FIRE_ASPECT_1.getCard());
    public static final RegistryObject<Item> FIRE_ASPECT_2 = ITEMS.register("upgrade_fire_aspect_2", () -> Upgrade.FIRE_ASPECT_2.getCard());

    public static final RegistryObject<Item> FIRE_PROTECTION_1 = ITEMS.register("upgrade_fire_protection_1", () -> Upgrade.FIRE_PROTECTION_1.getCard());
    public static final RegistryObject<Item> FIRE_PROTECTION_2 = ITEMS.register("upgrade_fire_protection_2", () -> Upgrade.FIRE_PROTECTION_2.getCard());
    public static final RegistryObject<Item> FIRE_PROTECTION_3 = ITEMS.register("upgrade_fire_protection_3", () -> Upgrade.FIRE_PROTECTION_3.getCard());
    public static final RegistryObject<Item> FIRE_PROTECTION_4 = ITEMS.register("upgrade_fire_protection_4", () -> Upgrade.FIRE_PROTECTION_4.getCard());

    public static final RegistryObject<Item> FORTUNE_1 = ITEMS.register("upgrade_fortune_1", () -> Upgrade.FORTUNE_1.getCard());
    public static final RegistryObject<Item> FORTUNE_2 = ITEMS.register("upgrade_fortune_2", () -> Upgrade.FORTUNE_2.getCard());
    public static final RegistryObject<Item> FORTUNE_3 = ITEMS.register("upgrade_fortune_3", () -> Upgrade.FORTUNE_3.getCard());

    public static final RegistryObject<Item> FROST_WALKER_1 = ITEMS.register("upgrade_frost_walker_1", () -> Upgrade.FROST_WALKER_1.getCard());
    public static final RegistryObject<Item> FROST_WALKER_2 = ITEMS.register("upgrade_frost_walker_2", () -> Upgrade.FROST_WALKER_2.getCard());

    public static final RegistryObject<Item> KNOCKBACK_1 = ITEMS.register("upgrade_knockback_1", () -> Upgrade.KNOCKBACK_1.getCard());
    public static final RegistryObject<Item> KNOCKBACK_2 = ITEMS.register("upgrade_knockback_2", () -> Upgrade.KNOCKBACK_2.getCard());

    public static final RegistryObject<Item> MOB_LOOTING_1 = ITEMS.register("upgrade_mob_looting_1", () -> Upgrade.MOB_LOOTING_1.getCard());
    public static final RegistryObject<Item> MOB_LOOTING_2 = ITEMS.register("upgrade_mob_looting_2", () -> Upgrade.MOB_LOOTING_2.getCard());
    public static final RegistryObject<Item> MOB_LOOTING_3 = ITEMS.register("upgrade_mob_looting_3", () -> Upgrade.MOB_LOOTING_3.getCard());

    public static final RegistryObject<Item> MENDING = ITEMS.register("upgrade_mending", () -> Upgrade.MENDING.getCard());

    public static final RegistryObject<Item> PROJECTILE_PROTECTION_1 = ITEMS.register("upgrade_projectile_protection_1", () -> Upgrade.PROJECTILE_PROTECTION_1.getCard());
    public static final RegistryObject<Item> PROJECTILE_PROTECTION_2 = ITEMS.register("upgrade_projectile_protection_2", () -> Upgrade.PROJECTILE_PROTECTION_2.getCard());
    public static final RegistryObject<Item> PROJECTILE_PROTECTION_3 = ITEMS.register("upgrade_projectile_protection_3", () -> Upgrade.PROJECTILE_PROTECTION_3.getCard());
    public static final RegistryObject<Item> PROJECTILE_PROTECTION_4 = ITEMS.register("upgrade_projectile_protection_4", () -> Upgrade.PROJECTILE_PROTECTION_4.getCard());

    public static final RegistryObject<Item> PROTECTION_1 = ITEMS.register("upgrade_protection_1", () -> Upgrade.PROTECTION_1.getCard());
    public static final RegistryObject<Item> PROTECTION_2 = ITEMS.register("upgrade_protection_2", () -> Upgrade.PROTECTION_2.getCard());
    public static final RegistryObject<Item> PROTECTION_3 = ITEMS.register("upgrade_protection_3", () -> Upgrade.PROTECTION_3.getCard());
    public static final RegistryObject<Item> PROTECTION_4 = ITEMS.register("upgrade_protection_4", () -> Upgrade.PROTECTION_4.getCard());

    public static final RegistryObject<Item> RESPIRATION_1 = ITEMS.register("upgrade_respiration_1", () -> Upgrade.RESPIRATION_1.getCard());
    public static final RegistryObject<Item> RESPIRATION_2 = ITEMS.register("upgrade_respiration_2", () -> Upgrade.RESPIRATION_2.getCard());
    public static final RegistryObject<Item> RESPIRATION_3 = ITEMS.register("upgrade_respiration_3", () -> Upgrade.RESPIRATION_3.getCard());

    public static final RegistryObject<Item> SHARPNESS_1 = ITEMS.register("upgrade_sharpness_1", () -> Upgrade.SHARPNESS_1.getCard());
    public static final RegistryObject<Item> SHARPNESS_2 = ITEMS.register("upgrade_sharpness_2", () -> Upgrade.SHARPNESS_2.getCard());
    public static final RegistryObject<Item> SHARPNESS_3 = ITEMS.register("upgrade_sharpness_3", () -> Upgrade.SHARPNESS_3.getCard());
    public static final RegistryObject<Item> SHARPNESS_4 = ITEMS.register("upgrade_sharpness_4", () -> Upgrade.SHARPNESS_4.getCard());
    public static final RegistryObject<Item> SHARPNESS_5 = ITEMS.register("upgrade_sharpness_5", () -> Upgrade.SHARPNESS_5.getCard());

    public static final RegistryObject<Item> SMITE_1 = ITEMS.register("upgrade_smite_1", () -> Upgrade.SMITE_1.getCard());
    public static final RegistryObject<Item> SMITE_2 = ITEMS.register("upgrade_smite_2", () -> Upgrade.SMITE_2.getCard());
    public static final RegistryObject<Item> SMITE_3 = ITEMS.register("upgrade_smite_3", () -> Upgrade.SMITE_3.getCard());
    public static final RegistryObject<Item> SMITE_4 = ITEMS.register("upgrade_smite_4", () -> Upgrade.SMITE_4.getCard());
    public static final RegistryObject<Item> SMITE_5 = ITEMS.register("upgrade_smite_5", () -> Upgrade.SMITE_5.getCard());

    public static final RegistryObject<Item> SOUL_SPEED_1 = ITEMS.register("upgrade_soul_speed_1", () -> Upgrade.SOUL_SPEED_1.getCard());
    public static final RegistryObject<Item> SOUL_SPEED_2 = ITEMS.register("upgrade_soul_speed_2", () -> Upgrade.SOUL_SPEED_2.getCard());
    public static final RegistryObject<Item> SOUL_SPEED_3 = ITEMS.register("upgrade_soul_speed_3", () -> Upgrade.SOUL_SPEED_3.getCard());

    public static final RegistryObject<Item> SWEEPING_EDGE_1 = ITEMS.register("upgrade_sweeping_edge_1", () -> Upgrade.SWEEPING_EDGE_1.getCard());
    public static final RegistryObject<Item> SWEEPING_EDGE_2 = ITEMS.register("upgrade_sweeping_edge_2", () -> Upgrade.SWEEPING_EDGE_2.getCard());
    public static final RegistryObject<Item> SWEEPING_EDGE_3 = ITEMS.register("upgrade_sweeping_edge_3", () -> Upgrade.SWEEPING_EDGE_3.getCard());

    public static final RegistryObject<Item> THORNS_1 = ITEMS.register("upgrade_thorns_1", () -> Upgrade.THORNS_1.getCard());
    public static final RegistryObject<Item> THORNS_2 = ITEMS.register("upgrade_thorns_2", () -> Upgrade.THORNS_2.getCard());
    public static final RegistryObject<Item> THORNS_3 = ITEMS.register("upgrade_thorns_3", () -> Upgrade.THORNS_3.getCard());

    public static final RegistryObject<Item> UNBREAKING_1 = ITEMS.register("upgrade_unbreaking_1", () -> Upgrade.UNBREAKING_1.getCard());
    public static final RegistryObject<Item> UNBREAKING_2 = ITEMS.register("upgrade_unbreaking_2", () -> Upgrade.UNBREAKING_2.getCard());
    public static final RegistryObject<Item> UNBREAKING_3 = ITEMS.register("upgrade_unbreaking_3", () -> Upgrade.UNBREAKING_3.getCard());

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}