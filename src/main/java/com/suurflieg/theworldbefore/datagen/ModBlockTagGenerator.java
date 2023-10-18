package com.suurflieg.theworldbefore.datagen;

import com.suurflieg.theworldbefore.TheWorldBefore;
import com.suurflieg.theworldbefore.registry.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, TheWorldBefore.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.NEEDS_STONE_TOOL).add(ModBlocks.LARCH_PLANKS.get());
        this.tag(BlockTags.NEEDS_STONE_TOOL).add(ModBlocks.LARCH_LOG.get());
        this.tag(BlockTags.NEEDS_STONE_TOOL).add(ModBlocks.LARCH_WOOD.get());
        this.tag(BlockTags.NEEDS_STONE_TOOL).add(ModBlocks.STRIPPED_LARCH_LOG.get());
        this.tag(BlockTags.NEEDS_STONE_TOOL).add(ModBlocks.STRIPPED_LARCH_WOOD.get());

        
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.AVENTURINE_BLOCK.get(),
                     ModBlocks.PYRITE_BLOCK.get(),
                     ModBlocks.RUBY_BLOCK.get(),
                     ModBlocks.TOPAZ_BLOCK.get(),
                     ModBlocks.SPECTROLITE_BLOCK.get(),
                     ModBlocks.UNAKITE_BLOCK.get(),
                     ModBlocks.UPGRADE_STATION.get(),
                     ModBlocks.ENDERITE_ORE.get(),
                     ModBlocks.DEEPSLATE_ENDERITE_ORE.get(),
                     ModBlocks.ENDERITE_BLOCK.get(),
                     ModBlocks.AVENTURINE_ORE.get(),
                     ModBlocks.PYRITE_ORE.get(),
                     ModBlocks.RUBY_ORE.get(),
                     ModBlocks.TOPAZ_ORE.get(),
                     ModBlocks.SPECTROLITE_ORE.get(),
                     ModBlocks.UNAKITE_ORE.get(),
                     ModBlocks.DEEPSLATE_AVENTURINE_ORE.get(),
                     ModBlocks.DEEPSLATE_PYRITE_ORE.get(),
                     ModBlocks.DEEPSLATE_RUBY_ORE.get(),
                     ModBlocks.DEEPSLATE_TOPAZ_ORE.get(),
                     ModBlocks.DEEPSLATE_SPECTROLITE_ORE.get(),
                     ModBlocks.DEEPSLATE_UNAKITE_ORE.get());

        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.LARCH_WOOD.get(),
                        ModBlocks.LARCH_LOG.get(),
                        ModBlocks.LARCH_PLANKS.get(),
                        ModBlocks.STRIPPED_LARCH_WOOD.get(),
                        ModBlocks.STRIPPED_LARCH_LOG.get());


        this.tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.AVENTURINE_BLOCK.get());
        this.tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.PYRITE_BLOCK.get());
        this.tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.RUBY_BLOCK.get());
        this.tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.TOPAZ_BLOCK.get());
        this.tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.SPECTROLITE_BLOCK.get());
        this.tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.UNAKITE_BLOCK.get());


        this.tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.UPGRADE_STATION.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL).add(ModBlocks.ENDERITE_ORE.get());
        this.tag(BlockTags.NEEDS_DIAMOND_TOOL).add(ModBlocks.AVENTURINE_ORE.get());
        this.tag(BlockTags.NEEDS_DIAMOND_TOOL).add(ModBlocks.PYRITE_ORE.get());
        this.tag(BlockTags.NEEDS_DIAMOND_TOOL).add(ModBlocks.RUBY_ORE.get());
        this.tag(BlockTags.NEEDS_DIAMOND_TOOL).add(ModBlocks.TOPAZ_ORE.get());
        this.tag(BlockTags.NEEDS_DIAMOND_TOOL).add(ModBlocks.SPECTROLITE_ORE.get());
        this.tag(BlockTags.NEEDS_DIAMOND_TOOL).add(ModBlocks.UNAKITE_ORE.get());
        this.tag(BlockTags.NEEDS_DIAMOND_TOOL).add(ModBlocks.DEEPSLATE_ENDERITE_ORE.get());
        this.tag(BlockTags.NEEDS_DIAMOND_TOOL).add(ModBlocks.DEEPSLATE_AVENTURINE_ORE.get());
        this.tag(BlockTags.NEEDS_DIAMOND_TOOL).add(ModBlocks.DEEPSLATE_PYRITE_ORE.get());
        this.tag(BlockTags.NEEDS_DIAMOND_TOOL).add(ModBlocks.DEEPSLATE_RUBY_ORE.get());
        this.tag(BlockTags.NEEDS_DIAMOND_TOOL).add(ModBlocks.DEEPSLATE_TOPAZ_ORE.get());
        this.tag(BlockTags.NEEDS_DIAMOND_TOOL).add(ModBlocks.DEEPSLATE_SPECTROLITE_ORE.get());
        this.tag(BlockTags.NEEDS_DIAMOND_TOOL).add(ModBlocks.DEEPSLATE_UNAKITE_ORE.get());
        this.tag(BlockTags.NEEDS_DIAMOND_TOOL).add(ModBlocks.ENDERITE_BLOCK.get());
    }
}
