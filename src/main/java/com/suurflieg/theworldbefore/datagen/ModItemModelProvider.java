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

        withExistingParent("aventurine_ore", modLoc("block/aventurine_ore"));
        withExistingParent("pyrite_ore", modLoc("block/pyrite_ore"));
        withExistingParent("ruby_ore", modLoc("block/ruby_ore"));
        withExistingParent("topaz_ore", modLoc("block/topaz_ore"));
        withExistingParent("spectrolite_ore", modLoc("block/spectrolite_ore"));
        withExistingParent("unakite_ore", modLoc("block/unakite_ore"));

        withExistingParent("deepslate_aventurine_ore", modLoc("block/deepslate_aventurine_ore"));
        withExistingParent("deepslate_pyrite_ore", modLoc("block/deepslate_pyrite_ore"));
        withExistingParent("deepslate_ruby_ore", modLoc("block/deepslate_ruby_ore"));
        withExistingParent("deepslate_topaz_ore", modLoc("block/deepslate_topaz_ore"));
        withExistingParent("deepslate_spectrolite_ore", modLoc("block/deepslate_spectrolite_ore"));
        withExistingParent("deepslate_unakite_ore", modLoc("block/deepslate_unakite_ore"));

        withExistingParent("upgrade_station", modLoc("block/upgrade_station"));
        withExistingParent("catalyzer", modLoc("block/catalyzer"));

        withExistingParent("aventurine_block", modLoc("block/aventurine_block"));
        withExistingParent("pyrite_block", modLoc("block/pyrite_block"));
        withExistingParent("ruby_block", modLoc("block/ruby_block"));
        withExistingParent("topaz_block", modLoc("block/topaz_block"));
        withExistingParent("spectrolite_block", modLoc("block/spectrolite_block"));
        withExistingParent("unakite_block", modLoc("block/unakite_block"));

        simpleItem(ModItems.TITANIUM_NUGGET);
        simpleItem(ModItems.TITANIUM_INGOT);
        simpleItem(ModItems.TITANIUM_RAW_ORE);

        simpleItem(ModItems.TITANIUM_HELMET);
        simpleItem(ModItems.TITANIUM_CHESTPLATE);
        simpleItem(ModItems.TITANIUM_LEGGINGS);
        simpleItem(ModItems.TITANIUM_BOOTS);

        handheldItem(ModItems.TITANIUM_AXE);
        handheldItem(ModItems.TITANIUM_SHOVEL);
        handheldItem(ModItems.TITANIUM_PICKAXE);
        handheldItem(ModItems.TITANIUM_HOE);

        handheldItem(ModItems.TITANIUM_SWORD);

        simpleItem(ModItems.BLANK);
        simpleItem(ModItems.MAGNET);
        simpleItem(ModItems.SILK);
        simpleItem(ModItems.EXPANDER);
        simpleItem(ModItems.DEPTH);

        simpleItem(ModItems.AQUA_AFFINITY);

        simpleItem(ModItems.FIRE_ELEMENT);
        simpleItem(ModItems.ICE_ELEMENT);
        simpleItem(ModItems.WIND_ELEMENT);
        simpleItem(ModItems.ELECTRIC_ELEMENT);

        simpleItem(ModItems.BANE_OF_ARTHROPODS_1);
        simpleItem(ModItems.BANE_OF_ARTHROPODS_2);
        simpleItem(ModItems.BANE_OF_ARTHROPODS_3);
        simpleItem(ModItems.BANE_OF_ARTHROPODS_4);
        simpleItem(ModItems.BANE_OF_ARTHROPODS_5);

        simpleItem(ModItems.BLAST_PROTECTION_1);
        simpleItem(ModItems.BLAST_PROTECTION_2);
        simpleItem(ModItems.BLAST_PROTECTION_3);
        simpleItem(ModItems.BLAST_PROTECTION_4);

        simpleItem(ModItems.DEPTH_STRIDER_1);
        simpleItem(ModItems.DEPTH_STRIDER_2);
        simpleItem(ModItems.DEPTH_STRIDER_3);

        simpleItem(ModItems.EFFICIENCY_1);
        simpleItem(ModItems.EFFICIENCY_2);
        simpleItem(ModItems.EFFICIENCY_3);
        simpleItem(ModItems.EFFICIENCY_4);
        simpleItem(ModItems.EFFICIENCY_5);

        simpleItem(ModItems.FEATHER_FALLING_1);
        simpleItem(ModItems.FEATHER_FALLING_2);
        simpleItem(ModItems.FEATHER_FALLING_3);
        simpleItem(ModItems.FEATHER_FALLING_4);

        simpleItem(ModItems.FIRE_ASPECT_1);
        simpleItem(ModItems.FIRE_ASPECT_2);

        simpleItem(ModItems.FIRE_PROTECTION_1);
        simpleItem(ModItems.FIRE_PROTECTION_2);
        simpleItem(ModItems.FIRE_PROTECTION_3);
        simpleItem(ModItems.FIRE_PROTECTION_4);

        simpleItem(ModItems.FORTUNE_1);
        simpleItem(ModItems.FORTUNE_2);
        simpleItem(ModItems.FORTUNE_3);

        simpleItem(ModItems.FROST_WALKER_1);
        simpleItem(ModItems.FROST_WALKER_2);

        simpleItem(ModItems.KNOCKBACK_1);
        simpleItem(ModItems.KNOCKBACK_2);

        simpleItem(ModItems.MOB_LOOTING_1);
        simpleItem(ModItems.MOB_LOOTING_2);
        simpleItem(ModItems.MOB_LOOTING_3);

        simpleItem(ModItems.MENDING);

        simpleItem(ModItems.PROJECTILE_PROTECTION_1);
        simpleItem(ModItems.PROJECTILE_PROTECTION_2);
        simpleItem(ModItems.PROJECTILE_PROTECTION_3);
        simpleItem(ModItems.PROJECTILE_PROTECTION_4);

        simpleItem(ModItems.PROTECTION_1);
        simpleItem(ModItems.PROTECTION_2);
        simpleItem(ModItems.PROTECTION_3);
        simpleItem(ModItems.PROTECTION_4);

        simpleItem(ModItems.RESPIRATION_1);
        simpleItem(ModItems.RESPIRATION_2);
        simpleItem(ModItems.RESPIRATION_3);

        simpleItem(ModItems.SHARPNESS_1);
        simpleItem(ModItems.SHARPNESS_2);
        simpleItem(ModItems.SHARPNESS_3);
        simpleItem(ModItems.SHARPNESS_4);
        simpleItem(ModItems.SHARPNESS_5);

        simpleItem(ModItems.SMITE_1);
        simpleItem(ModItems.SMITE_2);
        simpleItem(ModItems.SMITE_3);
        simpleItem(ModItems.SMITE_4);
        simpleItem(ModItems.SMITE_5);

        simpleItem(ModItems.SOUL_SPEED_1);
        simpleItem(ModItems.SOUL_SPEED_2);
        simpleItem(ModItems.SOUL_SPEED_3);

        simpleItem(ModItems.SWEEPING_EDGE_1);
        simpleItem(ModItems.SWEEPING_EDGE_2);
        simpleItem(ModItems.SWEEPING_EDGE_3);

        simpleItem(ModItems.THORNS_1);
        simpleItem(ModItems.THORNS_2);
        simpleItem(ModItems.THORNS_3);

        simpleItem(ModItems.UNBREAKING_1);
        simpleItem(ModItems.UNBREAKING_2);
        simpleItem(ModItems.UNBREAKING_3);

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
