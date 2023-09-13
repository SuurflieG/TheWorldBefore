package com.suurflieg.theworldbefore.registry;


import com.suurflieg.theworldbefore.TheWorldBefore;
import com.suurflieg.theworldbefore.custom.item.upgradecards.Upgrade;
import com.suurflieg.theworldbefore.custom.item.upgradecards.UpgradeCardItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModUpgradeCards {
    public static final DeferredRegister<Item> UPGRADECARD_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TheWorldBefore.MOD_ID);

    public static final RegistryObject<Item> BLANK = UPGRADECARD_ITEMS.register("upgrade_blank", () -> new UpgradeCardItem(Upgrade.BLANK, 64));

    public static final RegistryObject<Item> SILK = UPGRADECARD_ITEMS.register("upgrade_silk", () -> new UpgradeCardItem(Upgrade.SILK));

    public static final RegistryObject<Item> MAGNET = UPGRADECARD_ITEMS.register("upgrade_magnet", () -> new UpgradeCardItem(Upgrade.MAGNET));

    public static final RegistryObject<Item> EXPANDER = UPGRADECARD_ITEMS.register("upgrade_expander", () -> new UpgradeCardItem(Upgrade.EXPANDER));

    public static final RegistryObject<Item> DEPTH = UPGRADECARD_ITEMS.register("upgrade_depth", () -> new UpgradeCardItem(Upgrade.DEPTH));

    public static final RegistryObject<Item> AQUA_AFFINITY = UPGRADECARD_ITEMS.register("upgrade_aqua_affinity", () -> new UpgradeCardItem(Upgrade.AQUA_AFFINITY));

    public static final RegistryObject<Item> BANE_OF_ARTHROPODS_1 = UPGRADECARD_ITEMS.register("upgrade_bane_of_arthropods_1", () -> new UpgradeCardItem(Upgrade.BANE_OF_ARTHROPODS_1));
    public static final RegistryObject<Item> BANE_OF_ARTHROPODS_2 = UPGRADECARD_ITEMS.register("upgrade_bane_of_arthropods_2", () -> new UpgradeCardItem(Upgrade.BANE_OF_ARTHROPODS_2));
    public static final RegistryObject<Item> BANE_OF_ARTHROPODS_3 = UPGRADECARD_ITEMS.register("upgrade_bane_of_arthropods_3", () -> new UpgradeCardItem(Upgrade.BANE_OF_ARTHROPODS_3));
    public static final RegistryObject<Item> BANE_OF_ARTHROPODS_4 = UPGRADECARD_ITEMS.register("upgrade_bane_of_arthropods_4", () -> new UpgradeCardItem(Upgrade.BANE_OF_ARTHROPODS_4));
    public static final RegistryObject<Item> BANE_OF_ARTHROPODS_5 = UPGRADECARD_ITEMS.register("upgrade_bane_of_arthropods_5", () -> new UpgradeCardItem(Upgrade.BANE_OF_ARTHROPODS_5));

    public static final RegistryObject<Item> BLAST_PROTECTION_1 = UPGRADECARD_ITEMS.register("upgrade_blast_protection_1", () -> new UpgradeCardItem(Upgrade.BLAST_PROTECTION_1));
    public static final RegistryObject<Item> BLAST_PROTECTION_2 = UPGRADECARD_ITEMS.register("upgrade_blast_protection_2", () -> new UpgradeCardItem(Upgrade.BLAST_PROTECTION_2));
    public static final RegistryObject<Item> BLAST_PROTECTION_3 = UPGRADECARD_ITEMS.register("upgrade_blast_protection_3", () -> new UpgradeCardItem(Upgrade.BLAST_PROTECTION_3));
    public static final RegistryObject<Item> BLAST_PROTECTION_4 = UPGRADECARD_ITEMS.register("upgrade_blast_protection_4", () -> new UpgradeCardItem(Upgrade.BLAST_PROTECTION_4));

    public static final RegistryObject<Item> DEPTH_STRIDER_1 = UPGRADECARD_ITEMS.register("upgrade_depth_strider_1", () -> new UpgradeCardItem(Upgrade.DEPTH_STRIDER_1));
    public static final RegistryObject<Item> DEPTH_STRIDER_2 = UPGRADECARD_ITEMS.register("upgrade_depth_strider_2", () -> new UpgradeCardItem(Upgrade.DEPTH_STRIDER_2));
    public static final RegistryObject<Item> DEPTH_STRIDER_3 = UPGRADECARD_ITEMS.register("upgrade_depth_strider_3", () -> new UpgradeCardItem(Upgrade.DEPTH_STRIDER_3));

    public static final RegistryObject<Item> EFFICIENCY_1 = UPGRADECARD_ITEMS.register("upgrade_efficiency_1", () -> new UpgradeCardItem(Upgrade.EFFICIENCY_1));
    public static final RegistryObject<Item> EFFICIENCY_2 = UPGRADECARD_ITEMS.register("upgrade_efficiency_2", () -> new UpgradeCardItem(Upgrade.EFFICIENCY_2));
    public static final RegistryObject<Item> EFFICIENCY_3 = UPGRADECARD_ITEMS.register("upgrade_efficiency_3", () -> new UpgradeCardItem(Upgrade.EFFICIENCY_3));
    public static final RegistryObject<Item> EFFICIENCY_4 = UPGRADECARD_ITEMS.register("upgrade_efficiency_4", () -> new UpgradeCardItem(Upgrade.EFFICIENCY_4));
    public static final RegistryObject<Item> EFFICIENCY_5 = UPGRADECARD_ITEMS.register("upgrade_efficiency_5", () -> new UpgradeCardItem(Upgrade.EFFICIENCY_5));

    public static final RegistryObject<Item> FEATHER_FALLING_1 = UPGRADECARD_ITEMS.register("upgrade_feather_falling_1", () -> new UpgradeCardItem(Upgrade.FEATHER_FALLING_1));
    public static final RegistryObject<Item> FEATHER_FALLING_2 = UPGRADECARD_ITEMS.register("upgrade_feather_falling_2", () -> new UpgradeCardItem(Upgrade.FEATHER_FALLING_2));
    public static final RegistryObject<Item> FEATHER_FALLING_3 = UPGRADECARD_ITEMS.register("upgrade_feather_falling_3", () -> new UpgradeCardItem(Upgrade.FEATHER_FALLING_3));
    public static final RegistryObject<Item> FEATHER_FALLING_4 = UPGRADECARD_ITEMS.register("upgrade_feather_falling_4", () -> new UpgradeCardItem(Upgrade.FEATHER_FALLING_4));

    public static final RegistryObject<Item> FIRE_ASPECT_1 = UPGRADECARD_ITEMS.register("upgrade_fire_aspect_1", () -> new UpgradeCardItem(Upgrade.FIRE_ASPECT_1));
    public static final RegistryObject<Item> FIRE_ASPECT_2 = UPGRADECARD_ITEMS.register("upgrade_fire_aspect_2", () -> new UpgradeCardItem(Upgrade.FIRE_ASPECT_2));

    public static final RegistryObject<Item> FIRE_PROTECTION_1 = UPGRADECARD_ITEMS.register("upgrade_fire_protection_1", () -> new UpgradeCardItem(Upgrade.FIRE_PROTECTION_1));
    public static final RegistryObject<Item> FIRE_PROTECTION_2 = UPGRADECARD_ITEMS.register("upgrade_fire_protection_2", () -> new UpgradeCardItem(Upgrade.FIRE_PROTECTION_2));
    public static final RegistryObject<Item> FIRE_PROTECTION_3 = UPGRADECARD_ITEMS.register("upgrade_fire_protection_3", () -> new UpgradeCardItem(Upgrade.FIRE_PROTECTION_3));
    public static final RegistryObject<Item> FIRE_PROTECTION_4 = UPGRADECARD_ITEMS.register("upgrade_fire_protection_4", () -> new UpgradeCardItem(Upgrade.FIRE_PROTECTION_4));

    public static final RegistryObject<Item> FORTUNE_1 = UPGRADECARD_ITEMS.register("upgrade_fortune_1", () -> new UpgradeCardItem(Upgrade.FORTUNE_1));
    public static final RegistryObject<Item> FORTUNE_2 = UPGRADECARD_ITEMS.register("upgrade_fortune_2", () -> new UpgradeCardItem(Upgrade.FORTUNE_2));
    public static final RegistryObject<Item> FORTUNE_3 = UPGRADECARD_ITEMS.register("upgrade_fortune_3", () -> new UpgradeCardItem(Upgrade.FORTUNE_3));

    public static final RegistryObject<Item> FROST_WALKER_1 = UPGRADECARD_ITEMS.register("upgrade_frost_walker_1", () -> new UpgradeCardItem(Upgrade.FROST_WALKER_1));
    public static final RegistryObject<Item> FROST_WALKER_2 = UPGRADECARD_ITEMS.register("upgrade_frost_walker_2", () -> new UpgradeCardItem(Upgrade.FROST_WALKER_2));

    public static final RegistryObject<Item> KNOCKBACK_1 = UPGRADECARD_ITEMS.register("upgrade_knockback_1", () -> new UpgradeCardItem(Upgrade.KNOCKBACK_1));
    public static final RegistryObject<Item> KNOCKBACK_2 = UPGRADECARD_ITEMS.register("upgrade_knockback_2", () -> new UpgradeCardItem(Upgrade.KNOCKBACK_2));

    public static final RegistryObject<Item> MOB_LOOTING_1 = UPGRADECARD_ITEMS.register("upgrade_mob_looting_1", () -> new UpgradeCardItem(Upgrade.MOB_LOOTING_1));
    public static final RegistryObject<Item> MOB_LOOTING_2 = UPGRADECARD_ITEMS.register("upgrade_mob_looting_2", () -> new UpgradeCardItem(Upgrade.MOB_LOOTING_2));
    public static final RegistryObject<Item> MOB_LOOTING_3 = UPGRADECARD_ITEMS.register("upgrade_mob_looting_3", () -> new UpgradeCardItem(Upgrade.MOB_LOOTING_3));

    public static final RegistryObject<Item> MENDING = UPGRADECARD_ITEMS.register("upgrade_mending", () -> new UpgradeCardItem(Upgrade.MENDING));

    public static final RegistryObject<Item> PROJECTILE_PROTECTION_1 = UPGRADECARD_ITEMS.register("upgrade_projectile_protection_1", () -> new UpgradeCardItem(Upgrade.PROJECTILE_PROTECTION_1));
    public static final RegistryObject<Item> PROJECTILE_PROTECTION_2 = UPGRADECARD_ITEMS.register("upgrade_projectile_protection_2", () -> new UpgradeCardItem(Upgrade.PROJECTILE_PROTECTION_2));
    public static final RegistryObject<Item> PROJECTILE_PROTECTION_3 = UPGRADECARD_ITEMS.register("upgrade_projectile_protection_3", () -> new UpgradeCardItem(Upgrade.PROJECTILE_PROTECTION_3));
    public static final RegistryObject<Item> PROJECTILE_PROTECTION_4 = UPGRADECARD_ITEMS.register("upgrade_projectile_protection_4", () -> new UpgradeCardItem(Upgrade.PROJECTILE_PROTECTION_4));

    public static final RegistryObject<Item> PROTECTION_1 = UPGRADECARD_ITEMS.register("upgrade_protection_1", () -> new UpgradeCardItem(Upgrade.PROTECTION_1));
    public static final RegistryObject<Item> PROTECTION_2 = UPGRADECARD_ITEMS.register("upgrade_protection_2", () -> new UpgradeCardItem(Upgrade.PROTECTION_2));
    public static final RegistryObject<Item> PROTECTION_3 = UPGRADECARD_ITEMS.register("upgrade_protection_3", () -> new UpgradeCardItem(Upgrade.PROTECTION_3));
    public static final RegistryObject<Item> PROTECTION_4 = UPGRADECARD_ITEMS.register("upgrade_protection_4", () -> new UpgradeCardItem(Upgrade.PROTECTION_4));

    public static final RegistryObject<Item> RESPIRATION_1 = UPGRADECARD_ITEMS.register("upgrade_respiration_1", () -> new UpgradeCardItem(Upgrade.RESPIRATION_1));
    public static final RegistryObject<Item> RESPIRATION_2 = UPGRADECARD_ITEMS.register("upgrade_respiration_2", () -> new UpgradeCardItem(Upgrade.RESPIRATION_2));
    public static final RegistryObject<Item> RESPIRATION_3 = UPGRADECARD_ITEMS.register("upgrade_respiration_3", () -> new UpgradeCardItem(Upgrade.RESPIRATION_3));

    public static final RegistryObject<Item> SHARPNESS_1 = UPGRADECARD_ITEMS.register("upgrade_sharpness_1", () -> new UpgradeCardItem(Upgrade.SHARPNESS_1));
    public static final RegistryObject<Item> SHARPNESS_2 = UPGRADECARD_ITEMS.register("upgrade_sharpness_2", () -> new UpgradeCardItem(Upgrade.SHARPNESS_2));
    public static final RegistryObject<Item> SHARPNESS_3 = UPGRADECARD_ITEMS.register("upgrade_sharpness_3", () -> new UpgradeCardItem(Upgrade.SHARPNESS_3));
    public static final RegistryObject<Item> SHARPNESS_4 = UPGRADECARD_ITEMS.register("upgrade_sharpness_4", () -> new UpgradeCardItem(Upgrade.SHARPNESS_4));
    public static final RegistryObject<Item> SHARPNESS_5 = UPGRADECARD_ITEMS.register("upgrade_sharpness_5", () -> new UpgradeCardItem(Upgrade.SHARPNESS_5));

    public static final RegistryObject<Item> SMITE_1 = UPGRADECARD_ITEMS.register("upgrade_smite_1", () -> new UpgradeCardItem(Upgrade.SMITE_1));
    public static final RegistryObject<Item> SMITE_2 = UPGRADECARD_ITEMS.register("upgrade_smite_2", () -> new UpgradeCardItem(Upgrade.SMITE_2));
    public static final RegistryObject<Item> SMITE_3 = UPGRADECARD_ITEMS.register("upgrade_smite_3", () -> new UpgradeCardItem(Upgrade.SMITE_3));
    public static final RegistryObject<Item> SMITE_4 = UPGRADECARD_ITEMS.register("upgrade_smite_4", () -> new UpgradeCardItem(Upgrade.SMITE_4));
    public static final RegistryObject<Item> SMITE_5 = UPGRADECARD_ITEMS.register("upgrade_smite_5", () -> new UpgradeCardItem(Upgrade.SMITE_5));

    public static final RegistryObject<Item> SOUL_SPEED_1 = UPGRADECARD_ITEMS.register("upgrade_soul_speed_1", () -> new UpgradeCardItem(Upgrade.SOUL_SPEED_1));
    public static final RegistryObject<Item> SOUL_SPEED_2 = UPGRADECARD_ITEMS.register("upgrade_soul_speed_2", () -> new UpgradeCardItem(Upgrade.SOUL_SPEED_2));
    public static final RegistryObject<Item> SOUL_SPEED_3 = UPGRADECARD_ITEMS.register("upgrade_soul_speed_3", () -> new UpgradeCardItem(Upgrade.SOUL_SPEED_3));

    public static final RegistryObject<Item> SWEEPING_EDGE_1 = UPGRADECARD_ITEMS.register("upgrade_sweeping_edge_1", () -> new UpgradeCardItem(Upgrade.SWEEPING_EDGE_1));
    public static final RegistryObject<Item> SWEEPING_EDGE_2 = UPGRADECARD_ITEMS.register("upgrade_sweeping_edge_2", () -> new UpgradeCardItem(Upgrade.SWEEPING_EDGE_2));
    public static final RegistryObject<Item> SWEEPING_EDGE_3 = UPGRADECARD_ITEMS.register("upgrade_sweeping_edge_3", () -> new UpgradeCardItem(Upgrade.SWEEPING_EDGE_3));

    public static final RegistryObject<Item> THORNS_1 = UPGRADECARD_ITEMS.register("upgrade_thorns_1", () -> new UpgradeCardItem(Upgrade.THORNS_1));
    public static final RegistryObject<Item> THORNS_2 = UPGRADECARD_ITEMS.register("upgrade_thorns_2", () -> new UpgradeCardItem(Upgrade.THORNS_2));
    public static final RegistryObject<Item> THORNS_3 = UPGRADECARD_ITEMS.register("upgrade_thorns_3", () -> new UpgradeCardItem(Upgrade.THORNS_3));

    public static final RegistryObject<Item> UNBREAKING_1 = UPGRADECARD_ITEMS.register("upgrade_unbreaking_1", () -> new UpgradeCardItem(Upgrade.UNBREAKING_1));
    public static final RegistryObject<Item> UNBREAKING_2 = UPGRADECARD_ITEMS.register("upgrade_unbreaking_2", () -> new UpgradeCardItem(Upgrade.UNBREAKING_2));
    public static final RegistryObject<Item> UNBREAKING_3 = UPGRADECARD_ITEMS.register("upgrade_unbreaking_3", () -> new UpgradeCardItem(Upgrade.UNBREAKING_3));




    public static void register(IEventBus eventBus) {
        UPGRADECARD_ITEMS.register(eventBus);
    }
}
