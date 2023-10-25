package com.suurflieg.theworldbefore.datagen;

import com.suurflieg.theworldbefore.TheWorldBefore;
import com.suurflieg.theworldbefore.registry.*;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedHashMap;

public class ModItemModelProvider extends ItemModelProvider {

    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }


    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TheWorldBefore.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        withExistingParent("enderite_block", modLoc("block/enderite_block"));
        withExistingParent("enderite_ore", modLoc("block/enderite_ore"));
        withExistingParent("deepslate_enderite_ore", modLoc("block/deepslate_enderite_ore"));

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

        withExistingParent("larch_log", modLoc("block/larch_log"));
        withExistingParent("larch_wood", modLoc("block/larch_wood"));
        withExistingParent("larch_leaves", modLoc("block/larch_leaves"));
        withExistingParent("larch_planks", modLoc("block/larch_planks"));
        withExistingParent("larch_sapling", modLoc("block/larch_sapling"));

        simpleItem(ModItems.ENDERITE_NUGGET);
        simpleItem(ModItems.ENDERITE_INGOT);
        simpleItem(ModItems.ENDERITE_RAW);

        trimmedArmorItem(ModItems.ENDERITE_HELMET);
        trimmedArmorItem(ModItems.ENDERITE_CHESTPLATE);
        trimmedArmorItem(ModItems.ENDERITE_LEGGINGS);
        trimmedArmorItem(ModItems.ENDERITE_BOOTS);

        handheldItem(ModItems.ENDERITE_AXE);
        handheldItem(ModItems.ENDERITE_SHOVEL);
        handheldItem(ModItems.ENDERITE_PICKAXE);
        handheldItem(ModItems.ENDERITE_HOE);

        handheldItem(ModItems.ENDERITE_SWORD);

        simpleItem(ModItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE);

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

    // Shoutout to El_Redstoniano for making this
    private void trimmedArmorItem(RegistryObject<Item> itemRegistryObject) {
        final String MOD_ID = TheWorldBefore.MOD_ID;

        if(itemRegistryObject.get() instanceof ArmorItem armorItem) {
            trimMaterials.entrySet().forEach(entry -> {

                ResourceKey<TrimMaterial> trimMaterial = entry.getKey();
                float trimValue = entry.getValue();

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = "item/" + armorItem;
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = new ResourceLocation(MOD_ID, armorItemPath);
                ResourceLocation trimResLoc = new ResourceLocation(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = new ResourceLocation(MOD_ID, currentTrimName);

                // This is used for making the ExistingFileHelper acknowledge that this texture exist, so this will
                // avoid an IllegalArgumentException
                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                // Trimmed armorItem files
                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc)
                        .texture("layer1", trimResLoc);

                // Non-trimmed armorItem file (normal variant)
                this.withExistingParent(itemRegistryObject.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                new ResourceLocation(MOD_ID,
                                        "item/" + itemRegistryObject.getId().getPath()));
            });
        }
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
