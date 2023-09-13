package com.suurflieg.theworldbefore.datagen;

import com.suurflieg.theworldbefore.TheWorldBefore;
import com.suurflieg.theworldbefore.registry.*;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

public class ModItemModelProvider extends ItemModelProvider {


    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TheWorldBefore.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        withExistingParent("titanium_block", modLoc("block/titanium_block"));
        withExistingParent("titanium_ore", modLoc("block/titanium_ore"));
        withExistingParent("deepslate_titanium_ore", modLoc("block/deepslate_titanium_ore"));

        withExistingParent("upgrade_station", modLoc("block/upgrade_station"));
        withExistingParent("catalyzer", modLoc("block/catalyzer"));

        withExistingParent("aventurine_block", modLoc("block/aventurine_block"));
        withExistingParent("aventurine_cluster", modLoc("block/aventurine_cluster"));
        withExistingParent("budding_aventurine", modLoc("block/budding_aventurine"));
        withExistingParent("large_aventurine_bud", modLoc("block/large_aventurine_bud"));
        withExistingParent("medium_aventurine_bud", modLoc("block/medium_aventurine_bud"));
        withExistingParent("small_aventurine_bud", modLoc("block/small_aventurine_bud"));

        withExistingParent("pyrite_block", modLoc("block/pyrite_block"));
        withExistingParent("pyrite_cluster", modLoc("block/pyrite_cluster"));
        withExistingParent("budding_pyrite", modLoc("block/budding_pyrite"));
        withExistingParent("large_pyrite_bud", modLoc("block/large_pyrite_bud"));
        withExistingParent("medium_pyrite_bud", modLoc("block/medium_pyrite_bud"));
        withExistingParent("small_pyrite_bud", modLoc("block/small_pyrite_bud"));

        withExistingParent("ruby_block", modLoc("block/ruby_block"));
        withExistingParent("ruby_cluster", modLoc("block/ruby_cluster"));
        withExistingParent("budding_ruby", modLoc("block/budding_ruby"));
        withExistingParent("large_ruby_bud", modLoc("block/large_ruby_bud"));
        withExistingParent("medium_ruby_bud", modLoc("block/medium_ruby_bud"));
        withExistingParent("small_ruby_bud", modLoc("block/small_ruby_bud"));
        
        withExistingParent("topaz_block", modLoc("block/topaz_block"));
        withExistingParent("topaz_cluster", modLoc("block/topaz_cluster"));
        withExistingParent("budding_topaz", modLoc("block/budding_topaz"));
        withExistingParent("large_topaz_bud", modLoc("block/large_topaz_bud"));
        withExistingParent("medium_topaz_bud", modLoc("block/medium_topaz_bud"));
        withExistingParent("small_topaz_bud", modLoc("block/small_topaz_bud"));

        withExistingParent("spectrolite_block", modLoc("block/spectrolite_block"));
        withExistingParent("spectrolite_cluster", modLoc("block/spectrolite_cluster"));
        withExistingParent("budding_spectrolite", modLoc("block/budding_spectrolite"));
        withExistingParent("large_spectrolite_bud", modLoc("block/large_spectrolite_bud"));
        withExistingParent("medium_spectrolite_bud", modLoc("block/medium_spectrolite_bud"));
        withExistingParent("small_spectrolite_bud", modLoc("block/small_spectrolite_bud"));

        withExistingParent("unakite_block", modLoc("block/unakite_block"));
        withExistingParent("unakite_cluster", modLoc("block/unakite_cluster"));
        withExistingParent("budding_unakite", modLoc("block/budding_unakite"));
        withExistingParent("large_unakite_bud", modLoc("block/large_unakite_bud"));
        withExistingParent("medium_unakite_bud", modLoc("block/medium_unakite_bud"));
        withExistingParent("small_unakite_bud", modLoc("block/small_unakite_bud"));

        simpleItem(ModItems.TITANIUM_NUGGET);
        simpleItem(ModItems.TITANIUM_INGOT);
        simpleItem(ModItems.TITANIUM_RAW_ORE);

        simpleItem(ModArmorItems.TITANIUM_HELMET);
        simpleItem(ModArmorItems.TITANIUM_CHESTPLATE);
        simpleItem(ModArmorItems.TITANIUM_LEGGINGS);
        simpleItem(ModArmorItems.TITANIUM_BOOTS);

        handheldItem(ModToolItems.TITANIUM_AXE);
        handheldItem(ModToolItems.TITANIUM_SHOVEL);
        handheldItem(ModToolItems.TITANIUM_PICKAXE);
        handheldItem(ModToolItems.TITANIUM_HOE);

        handheldItem(ModWeaponItems.TITANIUM_SWORD);

        simpleItem(ModUpgradeCards.BLANK);
        simpleItem(ModUpgradeCards.MAGNET);
        simpleItem(ModUpgradeCards.SILK);
        simpleItem(ModUpgradeCards.EXPANDER);
        simpleItem(ModUpgradeCards.DEPTH);

        simpleItem(ModUpgradeCards.AQUA_AFFINITY);

        simpleItem(ModUpgradeCards.BANE_OF_ARTHROPODS_1);
        simpleItem(ModUpgradeCards.BANE_OF_ARTHROPODS_2);
        simpleItem(ModUpgradeCards.BANE_OF_ARTHROPODS_3);
        simpleItem(ModUpgradeCards.BANE_OF_ARTHROPODS_4);
        simpleItem(ModUpgradeCards.BANE_OF_ARTHROPODS_5);

        simpleItem(ModUpgradeCards.BLAST_PROTECTION_1);
        simpleItem(ModUpgradeCards.BLAST_PROTECTION_2);
        simpleItem(ModUpgradeCards.BLAST_PROTECTION_3);
        simpleItem(ModUpgradeCards.BLAST_PROTECTION_4);

        simpleItem(ModUpgradeCards.DEPTH_STRIDER_1);
        simpleItem(ModUpgradeCards.DEPTH_STRIDER_2);
        simpleItem(ModUpgradeCards.DEPTH_STRIDER_3);

        simpleItem(ModUpgradeCards.EFFICIENCY_1);
        simpleItem(ModUpgradeCards.EFFICIENCY_2);
        simpleItem(ModUpgradeCards.EFFICIENCY_3);
        simpleItem(ModUpgradeCards.EFFICIENCY_4);
        simpleItem(ModUpgradeCards.EFFICIENCY_5);

        simpleItem(ModUpgradeCards.FEATHER_FALLING_1);
        simpleItem(ModUpgradeCards.FEATHER_FALLING_2);
        simpleItem(ModUpgradeCards.FEATHER_FALLING_3);
        simpleItem(ModUpgradeCards.FEATHER_FALLING_4);

        simpleItem(ModUpgradeCards.FIRE_ASPECT_1);
        simpleItem(ModUpgradeCards.FIRE_ASPECT_2);

        simpleItem(ModUpgradeCards.FIRE_PROTECTION_1);
        simpleItem(ModUpgradeCards.FIRE_PROTECTION_2);
        simpleItem(ModUpgradeCards.FIRE_PROTECTION_3);
        simpleItem(ModUpgradeCards.FIRE_PROTECTION_4);

        simpleItem(ModUpgradeCards.FORTUNE_1);
        simpleItem(ModUpgradeCards.FORTUNE_2);
        simpleItem(ModUpgradeCards.FORTUNE_3);

        simpleItem(ModUpgradeCards.FROST_WALKER_1);
        simpleItem(ModUpgradeCards.FROST_WALKER_2);

        simpleItem(ModUpgradeCards.KNOCKBACK_1);
        simpleItem(ModUpgradeCards.KNOCKBACK_2);

        simpleItem(ModUpgradeCards.MOB_LOOTING_1);
        simpleItem(ModUpgradeCards.MOB_LOOTING_2);
        simpleItem(ModUpgradeCards.MOB_LOOTING_3);

        simpleItem(ModUpgradeCards.MENDING);

        simpleItem(ModUpgradeCards.PROJECTILE_PROTECTION_1);
        simpleItem(ModUpgradeCards.PROJECTILE_PROTECTION_2);
        simpleItem(ModUpgradeCards.PROJECTILE_PROTECTION_3);
        simpleItem(ModUpgradeCards.PROJECTILE_PROTECTION_4);

        simpleItem(ModUpgradeCards.PROTECTION_1);
        simpleItem(ModUpgradeCards.PROTECTION_2);
        simpleItem(ModUpgradeCards.PROTECTION_3);
        simpleItem(ModUpgradeCards.PROTECTION_4);

        simpleItem(ModUpgradeCards.RESPIRATION_1);
        simpleItem(ModUpgradeCards.RESPIRATION_2);
        simpleItem(ModUpgradeCards.RESPIRATION_3);

        simpleItem(ModUpgradeCards.SHARPNESS_1);
        simpleItem(ModUpgradeCards.SHARPNESS_2);
        simpleItem(ModUpgradeCards.SHARPNESS_3);
        simpleItem(ModUpgradeCards.SHARPNESS_4);
        simpleItem(ModUpgradeCards.SHARPNESS_5);

        simpleItem(ModUpgradeCards.SMITE_1);
        simpleItem(ModUpgradeCards.SMITE_2);
        simpleItem(ModUpgradeCards.SMITE_3);
        simpleItem(ModUpgradeCards.SMITE_4);
        simpleItem(ModUpgradeCards.SMITE_5);

        simpleItem(ModUpgradeCards.SOUL_SPEED_1);
        simpleItem(ModUpgradeCards.SOUL_SPEED_2);
        simpleItem(ModUpgradeCards.SOUL_SPEED_3);

        simpleItem(ModUpgradeCards.SWEEPING_EDGE_1);
        simpleItem(ModUpgradeCards.SWEEPING_EDGE_2);
        simpleItem(ModUpgradeCards.SWEEPING_EDGE_3);

        simpleItem(ModUpgradeCards.THORNS_1);
        simpleItem(ModUpgradeCards.THORNS_2);
        simpleItem(ModUpgradeCards.THORNS_3);

        simpleItem(ModUpgradeCards.UNBREAKING_1);
        simpleItem(ModUpgradeCards.UNBREAKING_2);
        simpleItem(ModUpgradeCards.UNBREAKING_3);

        simpleItem(ModItems.AVENTURINE_SHARD);
        simpleItem(ModItems.PYRITE_SHARD);
        simpleItem(ModItems.RUBY_SHARD);
        simpleItem(ModItems.TOPAZ_SHARD);
        simpleItem(ModItems.SPECTROLITE_SHARD);
        simpleItem(ModItems.UNAKITE_SHARD);




    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(TheWorldBefore.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleItemEnchant(@NotNull RegistryObject<Enchantment> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(TheWorldBefore.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(TheWorldBefore.MOD_ID,"item/" + item.getId().getPath()));
    }


}
