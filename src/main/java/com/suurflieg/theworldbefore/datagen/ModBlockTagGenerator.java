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
                     ModBlocks.SMALL_AVENTURINE_BUD.get(),
                     ModBlocks.MEDIUM_AVENTURINE_BUD.get(),
                     ModBlocks.LARGE_AVENTURINE_BUD.get(),
                     ModBlocks.AVENTURINE_CLUSTER.get(),
                     ModBlocks.BUDDING_AVENTURINE.get(),
                     ModBlocks.PYRITE_BLOCK.get(),
                     ModBlocks.SMALL_PYRITE_BUD.get(),
                     ModBlocks.MEDIUM_PYRITE_BUD.get(),
                     ModBlocks.LARGE_PYRITE_BUD.get(),
                     ModBlocks.PYRITE_CLUSTER.get(),
                     ModBlocks.BUDDING_PYRITE.get(),
                     ModBlocks.RUBY_BLOCK.get(),
                     ModBlocks.SMALL_RUBY_BUD.get(),
                     ModBlocks.MEDIUM_RUBY_BUD.get(),
                     ModBlocks.LARGE_RUBY_BUD.get(),
                     ModBlocks.RUBY_CLUSTER.get(),
                     ModBlocks.BUDDING_RUBY.get(),
                     ModBlocks.TOPAZ_BLOCK.get(),
                     ModBlocks.SMALL_TOPAZ_BUD.get(),
                     ModBlocks.MEDIUM_TOPAZ_BUD.get(),
                     ModBlocks.LARGE_TOPAZ_BUD.get(),
                     ModBlocks.TOPAZ_CLUSTER.get(),
                     ModBlocks.BUDDING_TOPAZ.get(),
                     ModBlocks.SPECTROLITE_BLOCK.get(),
                     ModBlocks.SMALL_SPECTROLITE_BUD.get(),
                     ModBlocks.MEDIUM_SPECTROLITE_BUD.get(),
                     ModBlocks.LARGE_SPECTROLITE_BUD.get(),
                     ModBlocks.SPECTROLITE_CLUSTER.get(),
                     ModBlocks.BUDDING_SPECTROLITE.get(),
                     ModBlocks.UNAKITE_BLOCK.get(),
                     ModBlocks.SMALL_UNAKITE_BUD.get(),
                     ModBlocks.MEDIUM_UNAKITE_BUD.get(),
                     ModBlocks.LARGE_UNAKITE_BUD.get(),
                     ModBlocks.UNAKITE_CLUSTER.get(),
                     ModBlocks.BUDDING_UNAKITE.get(),
                     ModBlocks.UPGRADE_STATION.get(),
                     ModBlocks.TITANIUM_ORE.get(),
                     ModBlocks.DEEPSLATE_TITANIUM_ORE.get(),
                     ModBlocks.TITANIUM_BLOCK.get());

        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.LARCH_WOOD.get(),
                        ModBlocks.LARCH_LOG.get(),
                        ModBlocks.LARCH_PLANKS.get(),
                        ModBlocks.STRIPPED_LARCH_WOOD.get(),
                        ModBlocks.STRIPPED_LARCH_LOG.get());


        this.tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.AVENTURINE_BLOCK.get());
        this.tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.SMALL_AVENTURINE_BUD.get());
        this.tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.MEDIUM_AVENTURINE_BUD.get());
        this.tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.LARGE_AVENTURINE_BUD.get());
        this.tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.AVENTURINE_CLUSTER.get());
        this.tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.BUDDING_AVENTURINE.get());
        
        this.tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.PYRITE_BLOCK.get());
        this.tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.SMALL_PYRITE_BUD.get());
        this.tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.MEDIUM_PYRITE_BUD.get());
        this.tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.LARGE_PYRITE_BUD.get());
        this.tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.PYRITE_CLUSTER.get());
        this.tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.BUDDING_PYRITE.get());
        
        this.tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.RUBY_BLOCK.get());
        this.tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.SMALL_RUBY_BUD.get());
        this.tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.MEDIUM_RUBY_BUD.get());
        this.tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.LARGE_RUBY_BUD.get());
        this.tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.RUBY_CLUSTER.get());
        this.tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.BUDDING_RUBY.get());
        
        this.tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.TOPAZ_BLOCK.get());
        this.tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.SMALL_TOPAZ_BUD.get());
        this.tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.MEDIUM_TOPAZ_BUD.get());
        this.tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.LARGE_TOPAZ_BUD.get());
        this.tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.TOPAZ_CLUSTER.get());
        this.tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.BUDDING_TOPAZ.get());
        
        this.tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.SPECTROLITE_BLOCK.get());
        this.tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.SMALL_SPECTROLITE_BUD.get());
        this.tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.MEDIUM_SPECTROLITE_BUD.get());
        this.tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.LARGE_SPECTROLITE_BUD.get());
        this.tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.SPECTROLITE_CLUSTER.get());
        this.tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.BUDDING_SPECTROLITE.get());
        
        this.tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.UNAKITE_BLOCK.get());
        this.tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.SMALL_UNAKITE_BUD.get());
        this.tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.MEDIUM_UNAKITE_BUD.get());
        this.tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.LARGE_UNAKITE_BUD.get());
        this.tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.UNAKITE_CLUSTER.get());
        this.tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.BUDDING_UNAKITE.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.UPGRADE_STATION.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL).add(ModBlocks.TITANIUM_ORE.get());
        this.tag(BlockTags.NEEDS_DIAMOND_TOOL).add(ModBlocks.DEEPSLATE_TITANIUM_ORE.get());
        this.tag(BlockTags.NEEDS_DIAMOND_TOOL).add(ModBlocks.TITANIUM_BLOCK.get());
    }
}
