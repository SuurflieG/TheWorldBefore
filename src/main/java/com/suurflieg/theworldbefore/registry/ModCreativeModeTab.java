package com.suurflieg.theworldbefore.registry;

import com.suurflieg.theworldbefore.TheWorldBefore;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTab {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TheWorldBefore.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TWB_TAB = CREATIVE_MODE_TAB.register("theworldbefore_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SPECTROLITE_SHARD.get())).
                    title(Component.translatable("creativetab.theworldbefore_tab"))
                    .displayItems(((pParameters, pOutput) ->{
                        pOutput.accept(ModBlocks.TITANIUM_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_TITANIUM_ORE.get());
                        pOutput.accept(ModItems.TITANIUM_RAW_ORE.get());
                        pOutput.accept(ModItems.TITANIUM_NUGGET.get());
                        pOutput.accept(ModItems.TITANIUM_INGOT.get());
                        pOutput.accept(ModBlocks.TITANIUM_BLOCK.get());

                        pOutput.accept(ModToolItems.TITANIUM_AXE.get());
                        pOutput.accept(ModToolItems.TITANIUM_PICKAXE.get());
                        pOutput.accept(ModToolItems.TITANIUM_SHOVEL.get());
                        pOutput.accept(ModToolItems.TITANIUM_HOE.get());
                        pOutput.accept(ModWeaponItems.TITANIUM_SWORD.get());
                        pOutput.accept(ModArmorItems.TITANIUM_BOOTS.get());
                        pOutput.accept(ModArmorItems.TITANIUM_LEGGINGS.get());
                        pOutput.accept(ModArmorItems.TITANIUM_CHESTPLATE.get());
                        pOutput.accept(ModArmorItems.TITANIUM_HELMET.get());

                        pOutput.accept(ModBlocks.UPGRADE_STATION.get());

                        pOutput.accept(ModUpgradeCards.BLANK.get());
                        pOutput.accept(ModUpgradeCards.SILK.get());
                        pOutput.accept(ModUpgradeCards.EXPANDER.get());
                        pOutput.accept(ModUpgradeCards.DEPTH.get());
                        pOutput.accept(ModUpgradeCards.MAGNET.get());
                        pOutput.accept(ModUpgradeCards.MENDING.get());
                        pOutput.accept(ModUpgradeCards.AQUA_AFFINITY.get());

                        pOutput.accept(ModUpgradeCards.BANE_OF_ARTHROPODS_1.get());
                        pOutput.accept(ModUpgradeCards.BANE_OF_ARTHROPODS_2.get());
                        pOutput.accept(ModUpgradeCards.BANE_OF_ARTHROPODS_3.get());
                        pOutput.accept(ModUpgradeCards.BANE_OF_ARTHROPODS_4.get());
                        pOutput.accept(ModUpgradeCards.BANE_OF_ARTHROPODS_5.get());

                        pOutput.accept(ModUpgradeCards.BLAST_PROTECTION_1.get());
                        pOutput.accept(ModUpgradeCards.BLAST_PROTECTION_2.get());
                        pOutput.accept(ModUpgradeCards.BLAST_PROTECTION_3.get());
                        pOutput.accept(ModUpgradeCards.BLAST_PROTECTION_4.get());

                        pOutput.accept(ModUpgradeCards.DEPTH_STRIDER_1.get());
                        pOutput.accept(ModUpgradeCards.DEPTH_STRIDER_2.get());
                        pOutput.accept(ModUpgradeCards.DEPTH_STRIDER_3.get());

                        pOutput.accept(ModUpgradeCards.EFFICIENCY_1.get());
                        pOutput.accept(ModUpgradeCards.EFFICIENCY_2.get());
                        pOutput.accept(ModUpgradeCards.EFFICIENCY_3.get());
                        pOutput.accept(ModUpgradeCards.EFFICIENCY_4.get());
                        pOutput.accept(ModUpgradeCards.EFFICIENCY_5.get());

                        pOutput.accept(ModUpgradeCards.FEATHER_FALLING_1.get());
                        pOutput.accept(ModUpgradeCards.FEATHER_FALLING_2.get());
                        pOutput.accept(ModUpgradeCards.FEATHER_FALLING_3.get());
                        pOutput.accept(ModUpgradeCards.FEATHER_FALLING_4.get());

                        pOutput.accept(ModUpgradeCards.FIRE_ASPECT_1.get());
                        pOutput.accept(ModUpgradeCards.FIRE_ASPECT_2.get());

                        pOutput.accept(ModUpgradeCards.FIRE_PROTECTION_1.get());
                        pOutput.accept(ModUpgradeCards.FIRE_PROTECTION_2.get());
                        pOutput.accept(ModUpgradeCards.FIRE_PROTECTION_3.get());
                        pOutput.accept(ModUpgradeCards.FIRE_PROTECTION_4.get());

                        pOutput.accept(ModUpgradeCards.FORTUNE_1.get());
                        pOutput.accept(ModUpgradeCards.FORTUNE_2.get());
                        pOutput.accept(ModUpgradeCards.FORTUNE_3.get());

                        pOutput.accept(ModUpgradeCards.FROST_WALKER_1.get());
                        pOutput.accept(ModUpgradeCards.FROST_WALKER_2.get());

                        pOutput.accept(ModUpgradeCards.KNOCKBACK_1.get());
                        pOutput.accept(ModUpgradeCards.KNOCKBACK_2.get());

                        pOutput.accept(ModUpgradeCards.MOB_LOOTING_1.get());
                        pOutput.accept(ModUpgradeCards.MOB_LOOTING_2.get());
                        pOutput.accept(ModUpgradeCards.MOB_LOOTING_3.get());

                        pOutput.accept(ModUpgradeCards.PROJECTILE_PROTECTION_1.get());
                        pOutput.accept(ModUpgradeCards.PROJECTILE_PROTECTION_2.get());
                        pOutput.accept(ModUpgradeCards.PROJECTILE_PROTECTION_3.get());
                        pOutput.accept(ModUpgradeCards.PROJECTILE_PROTECTION_4.get());

                        pOutput.accept(ModUpgradeCards.PROTECTION_1.get());
                        pOutput.accept(ModUpgradeCards.PROTECTION_2.get());
                        pOutput.accept(ModUpgradeCards.PROTECTION_3.get());
                        pOutput.accept(ModUpgradeCards.PROTECTION_4.get());

                        pOutput.accept(ModUpgradeCards.RESPIRATION_1.get());
                        pOutput.accept(ModUpgradeCards.RESPIRATION_2.get());
                        pOutput.accept(ModUpgradeCards.RESPIRATION_3.get());

                        pOutput.accept(ModUpgradeCards.SHARPNESS_1.get());
                        pOutput.accept(ModUpgradeCards.SHARPNESS_2.get());
                        pOutput.accept(ModUpgradeCards.SHARPNESS_3.get());
                        pOutput.accept(ModUpgradeCards.SHARPNESS_4.get());
                        pOutput.accept(ModUpgradeCards.SHARPNESS_5.get());

                        pOutput.accept(ModUpgradeCards.SMITE_1.get());
                        pOutput.accept(ModUpgradeCards.SMITE_2.get());
                        pOutput.accept(ModUpgradeCards.SMITE_3.get());
                        pOutput.accept(ModUpgradeCards.SMITE_4.get());
                        pOutput.accept(ModUpgradeCards.SMITE_5.get());

                        pOutput.accept(ModUpgradeCards.SOUL_SPEED_1.get());
                        pOutput.accept(ModUpgradeCards.SOUL_SPEED_2.get());
                        pOutput.accept(ModUpgradeCards.SOUL_SPEED_3.get());

                        pOutput.accept(ModUpgradeCards.SWEEPING_EDGE_1.get());
                        pOutput.accept(ModUpgradeCards.SWEEPING_EDGE_2.get());
                        pOutput.accept(ModUpgradeCards.SWEEPING_EDGE_3.get());

                        pOutput.accept(ModUpgradeCards.THORNS_1.get());
                        pOutput.accept(ModUpgradeCards.THORNS_2.get());
                        pOutput.accept(ModUpgradeCards.THORNS_3.get());

                        pOutput.accept(ModUpgradeCards.UNBREAKING_1.get());
                        pOutput.accept(ModUpgradeCards.UNBREAKING_2.get());
                        pOutput.accept(ModUpgradeCards.UNBREAKING_3.get());

                        pOutput.accept(ModBlocks.SMALL_AVENTURINE_BUD.get());
                        pOutput.accept(ModBlocks.SMALL_RUBY_BUD.get());
                        pOutput.accept(ModBlocks.SMALL_PYRITE_BUD.get());
                        pOutput.accept(ModBlocks.SMALL_TOPAZ_BUD.get());
                        pOutput.accept(ModBlocks.SMALL_SPECTROLITE_BUD.get());
                        pOutput.accept(ModBlocks.SMALL_UNAKITE_BUD.get());

                        pOutput.accept(ModBlocks.MEDIUM_AVENTURINE_BUD.get());
                        pOutput.accept(ModBlocks.MEDIUM_RUBY_BUD.get());
                        pOutput.accept(ModBlocks.MEDIUM_PYRITE_BUD.get());
                        pOutput.accept(ModBlocks.MEDIUM_TOPAZ_BUD.get());
                        pOutput.accept(ModBlocks.MEDIUM_SPECTROLITE_BUD.get());
                        pOutput.accept(ModBlocks.MEDIUM_UNAKITE_BUD.get());

                        pOutput.accept(ModBlocks.LARGE_AVENTURINE_BUD.get());
                        pOutput.accept(ModBlocks.LARGE_RUBY_BUD.get());
                        pOutput.accept(ModBlocks.LARGE_PYRITE_BUD.get());
                        pOutput.accept(ModBlocks.LARGE_TOPAZ_BUD.get());
                        pOutput.accept(ModBlocks.LARGE_SPECTROLITE_BUD.get());
                        pOutput.accept(ModBlocks.LARGE_UNAKITE_BUD.get());

                        pOutput.accept(ModBlocks.AVENTURINE_CLUSTER.get());
                        pOutput.accept(ModBlocks.RUBY_CLUSTER.get());
                        pOutput.accept(ModBlocks.PYRITE_CLUSTER.get());
                        pOutput.accept(ModBlocks.TOPAZ_CLUSTER.get());
                        pOutput.accept(ModBlocks.SPECTROLITE_CLUSTER.get());
                        pOutput.accept(ModBlocks.UNAKITE_CLUSTER.get());

                        pOutput.accept(ModBlocks.AVENTURINE_BLOCK.get());
                        pOutput.accept(ModBlocks.RUBY_BLOCK.get());
                        pOutput.accept(ModBlocks.PYRITE_BLOCK.get());
                        pOutput.accept(ModBlocks.TOPAZ_BLOCK.get());
                        pOutput.accept(ModBlocks.SPECTROLITE_BLOCK.get());
                        pOutput.accept(ModBlocks.UNAKITE_BLOCK.get());

                        pOutput.accept(ModBlocks.BUDDING_AVENTURINE.get());
                        pOutput.accept(ModBlocks.BUDDING_RUBY.get());
                        pOutput.accept(ModBlocks.BUDDING_PYRITE.get());
                        pOutput.accept(ModBlocks.BUDDING_TOPAZ.get());
                        pOutput.accept(ModBlocks.BUDDING_SPECTROLITE.get());
                        pOutput.accept(ModBlocks.BUDDING_UNAKITE.get());

                        pOutput.accept(ModItems.AVENTURINE_SHARD.get());
                        pOutput.accept(ModItems.PYRITE_SHARD.get());
                        pOutput.accept(ModItems.RUBY_SHARD.get());
                        pOutput.accept(ModItems.TOPAZ_SHARD.get());
                        pOutput.accept(ModItems.SPECTROLITE_SHARD.get());
                        pOutput.accept(ModItems.UNAKITE_SHARD.get());

                        pOutput.accept(ModBlocks.LARCH_LEAVES.get());
                        pOutput.accept(ModBlocks.LARCH_LOG.get());
                        pOutput.accept(ModBlocks.LARCH_PLANKS.get());
                        pOutput.accept(ModBlocks.LARCH_WOOD.get());
                        pOutput.accept(ModBlocks.STRIPPED_LARCH_LOG.get());
                        pOutput.accept(ModBlocks.STRIPPED_LARCH_WOOD.get());
                        pOutput.accept(ModBlocks.LARCH_SAPLING.get());




                    })).build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }
}