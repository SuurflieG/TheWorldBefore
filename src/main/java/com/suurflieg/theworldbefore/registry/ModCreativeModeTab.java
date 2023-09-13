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

                        pOutput.accept(ModBlocks.LARCH_LEAVES.get());
                        pOutput.accept(ModBlocks.LARCH_LOG.get());
                        pOutput.accept(ModBlocks.LARCH_PLANKS.get());
                        pOutput.accept(ModBlocks.LARCH_WOOD.get());
                        pOutput.accept(ModBlocks.STRIPPED_LARCH_LOG.get());
                        pOutput.accept(ModBlocks.STRIPPED_LARCH_WOOD.get());
                        pOutput.accept(ModBlocks.LARCH_SAPLING.get());


                        pOutput.accept(ModItems.AVENTURINE_SHARD.get());
                        pOutput.accept(ModItems.PYRITE_SHARD.get());
                        pOutput.accept(ModItems.RUBY_SHARD.get());
                        pOutput.accept(ModItems.TOPAZ_SHARD.get());
                        pOutput.accept(ModItems.SPECTROLITE_SHARD.get());
                        pOutput.accept(ModItems.UNAKITE_SHARD.get());

                        pOutput.accept(ModToolItems.TITANIUM_AXE.get());
                        pOutput.accept(ModToolItems.TITANIUM_PICKAXE.get());
                        pOutput.accept(ModToolItems.TITANIUM_SHOVEL.get());
                        pOutput.accept(ModToolItems.TITANIUM_HOE.get());


                    })).build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }
}