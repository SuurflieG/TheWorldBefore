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
                        pOutput.accept(ModBlocks.ENDERITE_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_ENDERITE_ORE.get());
                        pOutput.accept(ModItems.ENDERITE_RAW_ORE.get());
                        pOutput.accept(ModItems.ENDERITE_NUGGET.get());
                        pOutput.accept(ModItems.ENDERITE_INGOT.get());
                        pOutput.accept(ModBlocks.ENDERITE_BLOCK.get());

                        pOutput.accept(ModItems.ENDERITE_AXE.get());
                        pOutput.accept(ModItems.ENDERITE_PICKAXE.get());
                        pOutput.accept(ModItems.ENDERITE_SHOVEL.get());
                        pOutput.accept(ModItems.ENDERITE_HOE.get());
                        pOutput.accept(ModItems.ENDERITE_SWORD.get());
                        pOutput.accept(ModItems.ENDERITE_BOOTS.get());
                        pOutput.accept(ModItems.ENDERITE_LEGGINGS.get());
                        pOutput.accept(ModItems.ENDERITE_CHESTPLATE.get());
                        pOutput.accept(ModItems.ENDERITE_HELMET.get());

                        pOutput.accept(ModBlocks.UPGRADE_STATION.get());

                        pOutput.accept(ModItems.BLANK.get());
                        pOutput.accept(ModItems.SILK.get());
                        pOutput.accept(ModItems.EXPANDER.get());
                        pOutput.accept(ModItems.DEPTH.get());
                        pOutput.accept(ModItems.MAGNET.get());
                        pOutput.accept(ModItems.MENDING.get());
                        pOutput.accept(ModItems.AQUA_AFFINITY.get());

                        pOutput.accept(ModItems.FIRE_ELEMENT.get());
                        pOutput.accept(ModItems.ICE_ELEMENT.get());
                        pOutput.accept(ModItems.WIND_ELEMENT.get());
                        pOutput.accept(ModItems.ELECTRIC_ELEMENT.get());

                        pOutput.accept(ModItems.BANE_OF_ARTHROPODS_1.get());
                        pOutput.accept(ModItems.BANE_OF_ARTHROPODS_2.get());
                        pOutput.accept(ModItems.BANE_OF_ARTHROPODS_3.get());
                        pOutput.accept(ModItems.BANE_OF_ARTHROPODS_4.get());
                        pOutput.accept(ModItems.BANE_OF_ARTHROPODS_5.get());

                        pOutput.accept(ModItems.BLAST_PROTECTION_1.get());
                        pOutput.accept(ModItems.BLAST_PROTECTION_2.get());
                        pOutput.accept(ModItems.BLAST_PROTECTION_3.get());
                        pOutput.accept(ModItems.BLAST_PROTECTION_4.get());

                        pOutput.accept(ModItems.DEPTH_STRIDER_1.get());
                        pOutput.accept(ModItems.DEPTH_STRIDER_2.get());
                        pOutput.accept(ModItems.DEPTH_STRIDER_3.get());

                        pOutput.accept(ModItems.EFFICIENCY_1.get());
                        pOutput.accept(ModItems.EFFICIENCY_2.get());
                        pOutput.accept(ModItems.EFFICIENCY_3.get());
                        pOutput.accept(ModItems.EFFICIENCY_4.get());
                        pOutput.accept(ModItems.EFFICIENCY_5.get());

                        pOutput.accept(ModItems.FEATHER_FALLING_1.get());
                        pOutput.accept(ModItems.FEATHER_FALLING_2.get());
                        pOutput.accept(ModItems.FEATHER_FALLING_3.get());
                        pOutput.accept(ModItems.FEATHER_FALLING_4.get());

                        pOutput.accept(ModItems.FIRE_ASPECT_1.get());
                        pOutput.accept(ModItems.FIRE_ASPECT_2.get());

                        pOutput.accept(ModItems.FIRE_PROTECTION_1.get());
                        pOutput.accept(ModItems.FIRE_PROTECTION_2.get());
                        pOutput.accept(ModItems.FIRE_PROTECTION_3.get());
                        pOutput.accept(ModItems.FIRE_PROTECTION_4.get());

                        pOutput.accept(ModItems.FORTUNE_1.get());
                        pOutput.accept(ModItems.FORTUNE_2.get());
                        pOutput.accept(ModItems.FORTUNE_3.get());

                        pOutput.accept(ModItems.FROST_WALKER_1.get());
                        pOutput.accept(ModItems.FROST_WALKER_2.get());

                        pOutput.accept(ModItems.KNOCKBACK_1.get());
                        pOutput.accept(ModItems.KNOCKBACK_2.get());

                        pOutput.accept(ModItems.MOB_LOOTING_1.get());
                        pOutput.accept(ModItems.MOB_LOOTING_2.get());
                        pOutput.accept(ModItems.MOB_LOOTING_3.get());

                        pOutput.accept(ModItems.PROJECTILE_PROTECTION_1.get());
                        pOutput.accept(ModItems.PROJECTILE_PROTECTION_2.get());
                        pOutput.accept(ModItems.PROJECTILE_PROTECTION_3.get());
                        pOutput.accept(ModItems.PROJECTILE_PROTECTION_4.get());

                        pOutput.accept(ModItems.PROTECTION_1.get());
                        pOutput.accept(ModItems.PROTECTION_2.get());
                        pOutput.accept(ModItems.PROTECTION_3.get());
                        pOutput.accept(ModItems.PROTECTION_4.get());

                        pOutput.accept(ModItems.RESPIRATION_1.get());
                        pOutput.accept(ModItems.RESPIRATION_2.get());
                        pOutput.accept(ModItems.RESPIRATION_3.get());

                        pOutput.accept(ModItems.SHARPNESS_1.get());
                        pOutput.accept(ModItems.SHARPNESS_2.get());
                        pOutput.accept(ModItems.SHARPNESS_3.get());
                        pOutput.accept(ModItems.SHARPNESS_4.get());
                        pOutput.accept(ModItems.SHARPNESS_5.get());

                        pOutput.accept(ModItems.SMITE_1.get());
                        pOutput.accept(ModItems.SMITE_2.get());
                        pOutput.accept(ModItems.SMITE_3.get());
                        pOutput.accept(ModItems.SMITE_4.get());
                        pOutput.accept(ModItems.SMITE_5.get());

                        pOutput.accept(ModItems.SOUL_SPEED_1.get());
                        pOutput.accept(ModItems.SOUL_SPEED_2.get());
                        pOutput.accept(ModItems.SOUL_SPEED_3.get());

                        pOutput.accept(ModItems.SWEEPING_EDGE_1.get());
                        pOutput.accept(ModItems.SWEEPING_EDGE_2.get());
                        pOutput.accept(ModItems.SWEEPING_EDGE_3.get());

                        pOutput.accept(ModItems.THORNS_1.get());
                        pOutput.accept(ModItems.THORNS_2.get());
                        pOutput.accept(ModItems.THORNS_3.get());

                        pOutput.accept(ModItems.UNBREAKING_1.get());
                        pOutput.accept(ModItems.UNBREAKING_2.get());
                        pOutput.accept(ModItems.UNBREAKING_3.get());

                        pOutput.accept(ModBlocks.AVENTURINE_ORE.get());
                        pOutput.accept(ModBlocks.PYRITE_ORE.get());
                        pOutput.accept(ModBlocks.RUBY_ORE.get());
                        pOutput.accept(ModBlocks.TOPAZ_ORE.get());
                        pOutput.accept(ModBlocks.SPECTROLITE_ORE.get());
                        pOutput.accept(ModBlocks.UNAKITE_ORE.get());

/*                        pOutput.accept(ModBlocks.SMALL_AVENTURINE_BUD.get());
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
                        pOutput.accept(ModBlocks.UNAKITE_CLUSTER.get());*/

                        pOutput.accept(ModBlocks.AVENTURINE_BLOCK.get());
                        pOutput.accept(ModBlocks.RUBY_BLOCK.get());
                        pOutput.accept(ModBlocks.PYRITE_BLOCK.get());
                        pOutput.accept(ModBlocks.TOPAZ_BLOCK.get());
                        pOutput.accept(ModBlocks.SPECTROLITE_BLOCK.get());
                        pOutput.accept(ModBlocks.UNAKITE_BLOCK.get());

/*                        pOutput.accept(ModBlocks.BUDDING_AVENTURINE.get());
                        pOutput.accept(ModBlocks.BUDDING_RUBY.get());
                        pOutput.accept(ModBlocks.BUDDING_PYRITE.get());
                        pOutput.accept(ModBlocks.BUDDING_TOPAZ.get());
                        pOutput.accept(ModBlocks.BUDDING_SPECTROLITE.get());
                        pOutput.accept(ModBlocks.BUDDING_UNAKITE.get());*/

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