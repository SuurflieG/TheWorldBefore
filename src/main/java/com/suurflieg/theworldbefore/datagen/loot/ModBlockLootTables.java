package com.suurflieg.theworldbefore.datagen.loot;

import com.suurflieg.theworldbefore.registry.ModBlocks;
import com.suurflieg.theworldbefore.registry.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {

    private static final float[] NORMAL_LEAVES_SAPLING_CHANCES = new float[]{0.05F, 0.0625F, 0.083333336F, 0.1F};

    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {

        //region Blocks that drop them self
        this.dropSelf(ModBlocks.ENDERITE_BLOCK.get());
        this.dropSelf(ModBlocks.UPGRADE_STATION.get());
        this.dropSelf(ModBlocks.LARCH_LOG.get());
        this.dropSelf(ModBlocks.LARCH_PLANKS.get());
        this.dropSelf(ModBlocks.LARCH_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_LARCH_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_LARCH_WOOD.get());
        this.dropSelf(ModBlocks.LARCH_SAPLING.get());

        //endregion

        //region Ore Blocks that drop raw ores
        this.add(ModBlocks.ENDERITE_ORE.get(), (Block) -> createOreDrop(ModBlocks.ENDERITE_ORE.get(), ModItems.ENDERITE_RAW_ORE.get()));
        this.add(ModBlocks.DEEPSLATE_ENDERITE_ORE.get(), (Block) -> createOreDrop(ModBlocks.DEEPSLATE_ENDERITE_ORE.get(), ModItems.ENDERITE_RAW_ORE.get()));

        this.add(ModBlocks.AVENTURINE_ORE.get(), (Block) -> createOreDrop(ModBlocks.AVENTURINE_ORE.get(), ModItems.AVENTURINE_SHARD.get()));
        this.add(ModBlocks.PYRITE_ORE.get(), (Block) -> createOreDrop(ModBlocks.PYRITE_ORE.get(), ModItems.PYRITE_SHARD.get()));
        this.add(ModBlocks.RUBY_ORE.get(), (Block) -> createOreDrop(ModBlocks.RUBY_ORE.get(), ModItems.RUBY_SHARD.get()));
        this.add(ModBlocks.TOPAZ_ORE.get(), (Block) -> createOreDrop(ModBlocks.TOPAZ_ORE.get(), ModItems.TOPAZ_SHARD.get()));
        this.add(ModBlocks.SPECTROLITE_ORE.get(), (Block) -> createOreDrop(ModBlocks.SPECTROLITE_ORE.get(), ModItems.SPECTROLITE_SHARD.get()));
        this.add(ModBlocks.UNAKITE_ORE.get(), (Block) -> createOreDrop(ModBlocks.UNAKITE_ORE.get(), ModItems.UNAKITE_SHARD.get()));

        this.add(ModBlocks.DEEPSLATE_AVENTURINE_ORE.get(), (Block) -> createOreDrop(ModBlocks.DEEPSLATE_AVENTURINE_ORE.get(), ModItems.AVENTURINE_SHARD.get()));
        this.add(ModBlocks.DEEPSLATE_PYRITE_ORE.get(), (Block) -> createOreDrop(ModBlocks.DEEPSLATE_PYRITE_ORE.get(), ModItems.PYRITE_SHARD.get()));
        this.add(ModBlocks.DEEPSLATE_RUBY_ORE.get(), (Block) -> createOreDrop(ModBlocks.DEEPSLATE_RUBY_ORE.get(), ModItems.RUBY_SHARD.get()));
        this.add(ModBlocks.DEEPSLATE_TOPAZ_ORE.get(), (Block) -> createOreDrop(ModBlocks.DEEPSLATE_TOPAZ_ORE.get(), ModItems.TOPAZ_SHARD.get()));
        this.add(ModBlocks.DEEPSLATE_SPECTROLITE_ORE.get(), (Block) -> createOreDrop(ModBlocks.DEEPSLATE_SPECTROLITE_ORE.get(), ModItems.SPECTROLITE_SHARD.get()));
        this.add(ModBlocks.DEEPSLATE_UNAKITE_ORE.get(), (Block) -> createOreDrop(ModBlocks.DEEPSLATE_UNAKITE_ORE.get(), ModItems.UNAKITE_SHARD.get()));
        //endregion

        this.add(ModBlocks.LARCH_LEAVES.get(), (Block) -> createLeavesDrops(Block, ModBlocks.LARCH_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        this.dropSelf(ModBlocks.AVENTURINE_BLOCK.get());
        this.dropSelf(ModBlocks.PYRITE_BLOCK.get());
        this.dropSelf(ModBlocks.RUBY_BLOCK.get());
        this.dropSelf(ModBlocks.TOPAZ_BLOCK.get());
        this.dropSelf(ModBlocks.SPECTROLITE_BLOCK.get());
        this.dropSelf(ModBlocks.UNAKITE_BLOCK.get());

/*        this.add(ModBlocks.AVENTURINE_CLUSTER.get(), (p_176063_) -> createSilkTouchDispatchTable(p_176063_, LootItem.lootTableItem(ModItems.AVENTURINE_SHARD.get())
                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(4.0F)))
                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE)).when(MatchTool.toolMatches(ItemPredicate.Builder.item().of(ItemTags.CLUSTER_MAX_HARVESTABLES)))
                .otherwise(applyExplosionDecay(p_176063_, LootItem.lootTableItem(ModItems.AVENTURINE_SHARD.get()).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F)))))));
        this.dropWhenSilkTouch(ModBlocks.SMALL_AVENTURINE_BUD.get());
        this.dropWhenSilkTouch(ModBlocks.MEDIUM_AVENTURINE_BUD.get());
        this.dropWhenSilkTouch(ModBlocks.LARGE_AVENTURINE_BUD.get());
        this.add(ModBlocks.BUDDING_AVENTURINE.get(), noDrop());


        this.add(ModBlocks.PYRITE_CLUSTER.get(), (p_176063_) -> createSilkTouchDispatchTable(p_176063_, LootItem.lootTableItem(ModItems.PYRITE_SHARD.get())
                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(4.0F)))
                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE)).when(MatchTool.toolMatches(ItemPredicate.Builder.item().of(ItemTags.CLUSTER_MAX_HARVESTABLES)))
                .otherwise(applyExplosionDecay(p_176063_, LootItem.lootTableItem(ModItems.PYRITE_SHARD.get()).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F)))))));
        this.dropWhenSilkTouch(ModBlocks.SMALL_PYRITE_BUD.get());
        this.dropWhenSilkTouch(ModBlocks.MEDIUM_PYRITE_BUD.get());
        this.dropWhenSilkTouch(ModBlocks.LARGE_PYRITE_BUD.get());
        this.add(ModBlocks.BUDDING_PYRITE.get(), noDrop());


        this.add(ModBlocks.RUBY_CLUSTER.get(), (p_176063_) -> createSilkTouchDispatchTable(p_176063_, LootItem.lootTableItem(ModItems.RUBY_SHARD.get())
                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(4.0F)))
                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE)).when(MatchTool.toolMatches(ItemPredicate.Builder.item().of(ItemTags.CLUSTER_MAX_HARVESTABLES)))
                .otherwise(applyExplosionDecay(p_176063_, LootItem.lootTableItem(ModItems.RUBY_SHARD.get()).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F)))))));
        this.dropWhenSilkTouch(ModBlocks.SMALL_RUBY_BUD.get());
        this.dropWhenSilkTouch(ModBlocks.MEDIUM_RUBY_BUD.get());
        this.dropWhenSilkTouch(ModBlocks.LARGE_RUBY_BUD.get());
        this.add(ModBlocks.BUDDING_RUBY.get(), noDrop());


        this.add(ModBlocks.TOPAZ_CLUSTER.get(), (p_176063_) -> createSilkTouchDispatchTable(p_176063_, LootItem.lootTableItem(ModItems.TOPAZ_SHARD.get())
                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(4.0F)))
                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE)).when(MatchTool.toolMatches(ItemPredicate.Builder.item().of(ItemTags.CLUSTER_MAX_HARVESTABLES)))
                .otherwise(applyExplosionDecay(p_176063_, LootItem.lootTableItem(ModItems.TOPAZ_SHARD.get()).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F)))))));
        this.dropWhenSilkTouch(ModBlocks.SMALL_TOPAZ_BUD.get());
        this.dropWhenSilkTouch(ModBlocks.MEDIUM_TOPAZ_BUD.get());
        this.dropWhenSilkTouch(ModBlocks.LARGE_TOPAZ_BUD.get());
        this.add(ModBlocks.BUDDING_TOPAZ.get(), noDrop());


        this.add(ModBlocks.SPECTROLITE_CLUSTER.get(), (p_176063_) -> createSilkTouchDispatchTable(p_176063_, LootItem.lootTableItem(ModItems.SPECTROLITE_SHARD.get())
                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(4.0F)))
                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE)).when(MatchTool.toolMatches(ItemPredicate.Builder.item().of(ItemTags.CLUSTER_MAX_HARVESTABLES)))
                .otherwise(applyExplosionDecay(p_176063_, LootItem.lootTableItem(ModItems.SPECTROLITE_SHARD.get()).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F)))))));
        this.dropWhenSilkTouch(ModBlocks.SMALL_SPECTROLITE_BUD.get());
        this.dropWhenSilkTouch(ModBlocks.MEDIUM_SPECTROLITE_BUD.get());
        this.dropWhenSilkTouch(ModBlocks.LARGE_SPECTROLITE_BUD.get());
        this.add(ModBlocks.BUDDING_SPECTROLITE.get(), noDrop());


        this.add(ModBlocks.UNAKITE_CLUSTER.get(), (p_176063_) -> createSilkTouchDispatchTable(p_176063_, LootItem.lootTableItem(ModItems.UNAKITE_SHARD.get())
                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(4.0F)))
                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE)).when(MatchTool.toolMatches(ItemPredicate.Builder.item().of(ItemTags.CLUSTER_MAX_HARVESTABLES)))
                .otherwise(applyExplosionDecay(p_176063_, LootItem.lootTableItem(ModItems.UNAKITE_SHARD.get()).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F)))))));
        this.dropWhenSilkTouch(ModBlocks.SMALL_UNAKITE_BUD.get());
        this.dropWhenSilkTouch(ModBlocks.MEDIUM_UNAKITE_BUD.get());
        this.dropWhenSilkTouch(ModBlocks.LARGE_UNAKITE_BUD.get());
        this.add(ModBlocks.BUDDING_UNAKITE.get(), noDrop());*/

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }


}
