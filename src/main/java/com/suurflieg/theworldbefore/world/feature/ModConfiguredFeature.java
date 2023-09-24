package com.suurflieg.theworldbefore.world.feature;


import com.suurflieg.theworldbefore.TheWorldBefore;
import com.suurflieg.theworldbefore.registry.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GeodeBlockSettings;
import net.minecraft.world.level.levelgen.GeodeCrackSettings;
import net.minecraft.world.level.levelgen.GeodeLayerSettings;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.SpruceFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeature {

    public static final ResourceKey<ConfiguredFeature<?, ?>> LARCH_TREE_KEY = registerKey("larch_tree");

    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_TITANIUM_ORE_KEY = registerKey("titanium_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_AVENTURINE_ORE_KEY = registerKey("aventurine_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_PYRITE_ORE_KEY = registerKey("pyrite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_RUBY_ORE_KEY = registerKey("ruby_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_TOPAZ_ORE_KEY = registerKey("topaz_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_SPECTROLITE_ORE_KEY = registerKey("spectrolite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_UNAKITE_ORE_KEY = registerKey("unakite_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> AVENTURINE_GEODE_KEY = registerKey("aventurine_geode");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PYRITE_GEODE_KEY = registerKey("pyrite_geode");
    public static final ResourceKey<ConfiguredFeature<?, ?>> RUBY_GEODE_KEY = registerKey("ruby_geode");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TOPAZ_GEODE_KEY = registerKey("topaz_geode");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SPECTROLITE_GEODE_KEY = registerKey("spectrolite_geode");
    public static final ResourceKey<ConfiguredFeature<?, ?>> UNAKITE_GEODE_KEY = registerKey("unakite_geode");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceabeles = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceabeles = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> overworldTitaniumOres =
                List.of(OreConfiguration.target(stoneReplaceabeles, ModBlocks.TITANIUM_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceabeles, ModBlocks.DEEPSLATE_TITANIUM_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> overworldAventurineOres =
                List.of(OreConfiguration.target(stoneReplaceabeles, ModBlocks.AVENTURINE_ORE.get().defaultBlockState()),
                        OreConfiguration.target(deepslateReplaceabeles, ModBlocks.DEEPSLATE_AVENTURINE_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> overworldPyriteOres =
                List.of(OreConfiguration.target(stoneReplaceabeles, ModBlocks.PYRITE_ORE.get().defaultBlockState()),
                        OreConfiguration.target(deepslateReplaceabeles, ModBlocks.DEEPSLATE_PYRITE_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> overworldRubyOres =
                List.of(OreConfiguration.target(stoneReplaceabeles, ModBlocks.RUBY_ORE.get().defaultBlockState()),
                        OreConfiguration.target(deepslateReplaceabeles, ModBlocks.DEEPSLATE_RUBY_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> overworldTopazOres =
                List.of(OreConfiguration.target(stoneReplaceabeles, ModBlocks.TOPAZ_ORE.get().defaultBlockState()),
                        OreConfiguration.target(deepslateReplaceabeles, ModBlocks.DEEPSLATE_TOPAZ_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> overworldSpectroliteOres =
                List.of(OreConfiguration.target(stoneReplaceabeles, ModBlocks.SPECTROLITE_ORE.get().defaultBlockState()),
                        OreConfiguration.target(deepslateReplaceabeles, ModBlocks.DEEPSLATE_SPECTROLITE_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> overworldUnakiteOres =
                List.of(OreConfiguration.target(stoneReplaceabeles, ModBlocks.UNAKITE_ORE.get().defaultBlockState()),
                        OreConfiguration.target(deepslateReplaceabeles, ModBlocks.DEEPSLATE_UNAKITE_ORE.get().defaultBlockState()));

        register(context, LARCH_TREE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.LARCH_LOG.get()),
                new StraightTrunkPlacer(20,8,4),
                BlockStateProvider.simple(ModBlocks.LARCH_LEAVES.get()),
                new SpruceFoliagePlacer(UniformInt.of(8, 12), UniformInt.of(2, 4), UniformInt.of(5, 8)),
                new TwoLayersFeatureSize(10,2,8)).build());

        register(context, OVERWORLD_TITANIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldTitaniumOres, 9));

        register(context, OVERWORLD_AVENTURINE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldAventurineOres, 9));
        register(context, OVERWORLD_PYRITE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldPyriteOres, 9));
        register(context, OVERWORLD_RUBY_ORE_KEY, Feature.ORE, new OreConfiguration(overworldRubyOres, 9));
        register(context, OVERWORLD_TOPAZ_ORE_KEY, Feature.ORE, new OreConfiguration(overworldTopazOres, 9));
        register(context, OVERWORLD_SPECTROLITE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldSpectroliteOres, 9));
        register(context, OVERWORLD_UNAKITE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldUnakiteOres, 9));






/*        register(context, AVENTURINE_GEODE_KEY, Feature.GEODE,
                new GeodeConfiguration(new GeodeBlockSettings(BlockStateProvider.simple(Blocks.AIR),
                        BlockStateProvider.simple(ModBlocks.AVENTURINE_BLOCK.get()),
                        BlockStateProvider.simple(ModBlocks.BUDDING_AVENTURINE.get()),
                        BlockStateProvider.simple(Blocks.CALCITE),
                        BlockStateProvider.simple(Blocks.SMOOTH_BASALT),
                        List.of(ModBlocks.SMALL_AVENTURINE_BUD.get().defaultBlockState(),
                                ModBlocks.MEDIUM_AVENTURINE_BUD.get().defaultBlockState(),
                                ModBlocks.LARGE_AVENTURINE_BUD.get().defaultBlockState(),
                                ModBlocks.AVENTURINE_CLUSTER.get().defaultBlockState()),
                        BlockTags.FEATURES_CANNOT_REPLACE , BlockTags.GEODE_INVALID_BLOCKS),
                        new GeodeLayerSettings(1.7D, 2.2D, 3.2D, 4.2D),
                        new GeodeCrackSettings(0.95D, 2.0D, 2), 0.35D,
                        0.083D, true, UniformInt.of(4, 6),
                        UniformInt.of(3, 4),
                        UniformInt.of(1, 2), -16, 16, 0.05D, 1));

        register(context, PYRITE_GEODE_KEY, Feature.GEODE,
                new GeodeConfiguration(new GeodeBlockSettings(BlockStateProvider.simple(Blocks.AIR),
                        BlockStateProvider.simple(ModBlocks.PYRITE_BLOCK.get()),
                        BlockStateProvider.simple(ModBlocks.BUDDING_PYRITE.get()),
                        BlockStateProvider.simple(Blocks.CALCITE),
                        BlockStateProvider.simple(Blocks.SMOOTH_BASALT),
                        List.of(ModBlocks.SMALL_PYRITE_BUD.get().defaultBlockState(),
                                ModBlocks.MEDIUM_PYRITE_BUD.get().defaultBlockState(),
                                ModBlocks.LARGE_PYRITE_BUD.get().defaultBlockState(),
                                ModBlocks.PYRITE_CLUSTER.get().defaultBlockState()),
                        BlockTags.FEATURES_CANNOT_REPLACE , BlockTags.GEODE_INVALID_BLOCKS),
                        new GeodeLayerSettings(1.7D, 2.2D, 3.2D, 4.2D),
                        new GeodeCrackSettings(0.95D, 2.0D, 2), 0.35D,
                        0.083D, true, UniformInt.of(4, 6),
                        UniformInt.of(3, 4),
                        UniformInt.of(1, 2), -16, 16, 0.05D, 1));

        register(context, RUBY_GEODE_KEY, Feature.GEODE,
                new GeodeConfiguration(new GeodeBlockSettings(BlockStateProvider.simple(Blocks.AIR),
                        BlockStateProvider.simple(ModBlocks.RUBY_BLOCK.get()),
                        BlockStateProvider.simple(ModBlocks.BUDDING_RUBY.get()),
                        BlockStateProvider.simple(Blocks.CALCITE),
                        BlockStateProvider.simple(Blocks.SMOOTH_BASALT),
                        List.of(ModBlocks.SMALL_RUBY_BUD.get().defaultBlockState(),
                                ModBlocks.MEDIUM_RUBY_BUD.get().defaultBlockState(),
                                ModBlocks.LARGE_RUBY_BUD.get().defaultBlockState(),
                                ModBlocks.RUBY_CLUSTER.get().defaultBlockState()),
                        BlockTags.FEATURES_CANNOT_REPLACE , BlockTags.GEODE_INVALID_BLOCKS),
                        new GeodeLayerSettings(1.7D, 2.2D, 3.2D, 4.2D),
                        new GeodeCrackSettings(0.95D, 2.0D, 2), 0.35D,
                        0.083D, true, UniformInt.of(4, 6),
                        UniformInt.of(3, 4),
                        UniformInt.of(1, 2), -16, 16, 0.05D, 1));

        register(context, TOPAZ_GEODE_KEY, Feature.GEODE,
                new GeodeConfiguration(new GeodeBlockSettings(BlockStateProvider.simple(Blocks.AIR),
                        BlockStateProvider.simple(ModBlocks.TOPAZ_BLOCK.get()),
                        BlockStateProvider.simple(ModBlocks.BUDDING_TOPAZ.get()),
                        BlockStateProvider.simple(Blocks.CALCITE),
                        BlockStateProvider.simple(Blocks.SMOOTH_BASALT),
                        List.of(ModBlocks.SMALL_TOPAZ_BUD.get().defaultBlockState(),
                                ModBlocks.MEDIUM_TOPAZ_BUD.get().defaultBlockState(),
                                ModBlocks.LARGE_TOPAZ_BUD.get().defaultBlockState(),
                                ModBlocks.TOPAZ_CLUSTER.get().defaultBlockState()),
                        BlockTags.FEATURES_CANNOT_REPLACE , BlockTags.GEODE_INVALID_BLOCKS),
                        new GeodeLayerSettings(1.7D, 2.2D, 3.2D, 4.2D),
                        new GeodeCrackSettings(0.95D, 2.0D, 2), 0.35D,
                        0.083D, true, UniformInt.of(4, 6),
                        UniformInt.of(3, 4),
                        UniformInt.of(1, 2), -16, 16, 0.05D, 1));

        register(context, SPECTROLITE_GEODE_KEY, Feature.GEODE,
                new GeodeConfiguration(new GeodeBlockSettings(BlockStateProvider.simple(Blocks.AIR),
                        BlockStateProvider.simple(ModBlocks.SPECTROLITE_BLOCK.get()),
                        BlockStateProvider.simple(ModBlocks.BUDDING_SPECTROLITE.get()),
                        BlockStateProvider.simple(Blocks.CALCITE),
                        BlockStateProvider.simple(Blocks.SMOOTH_BASALT),
                        List.of(ModBlocks.SMALL_SPECTROLITE_BUD.get().defaultBlockState(),
                                ModBlocks.MEDIUM_SPECTROLITE_BUD.get().defaultBlockState(),
                                ModBlocks.LARGE_SPECTROLITE_BUD.get().defaultBlockState(),
                                ModBlocks.SPECTROLITE_CLUSTER.get().defaultBlockState()),
                        BlockTags.FEATURES_CANNOT_REPLACE , BlockTags.GEODE_INVALID_BLOCKS),
                        new GeodeLayerSettings(1.7D, 2.2D, 3.2D, 4.2D),
                        new GeodeCrackSettings(0.95D, 2.0D, 2), 0.35D,
                        0.083D, true, UniformInt.of(4, 6),
                        UniformInt.of(3, 4),
                        UniformInt.of(1, 2), -16, 16, 0.05D, 1));

        register(context, UNAKITE_GEODE_KEY, Feature.GEODE,
                new GeodeConfiguration(new GeodeBlockSettings(BlockStateProvider.simple(Blocks.AIR),
                        BlockStateProvider.simple(ModBlocks.UNAKITE_BLOCK.get()),
                        BlockStateProvider.simple(ModBlocks.BUDDING_UNAKITE.get()),
                        BlockStateProvider.simple(Blocks.CALCITE),
                        BlockStateProvider.simple(Blocks.SMOOTH_BASALT),
                        List.of(ModBlocks.SMALL_UNAKITE_BUD.get().defaultBlockState(),
                                ModBlocks.MEDIUM_UNAKITE_BUD.get().defaultBlockState(),
                                ModBlocks.LARGE_UNAKITE_BUD.get().defaultBlockState(),
                                ModBlocks.UNAKITE_CLUSTER.get().defaultBlockState()),
                        BlockTags.FEATURES_CANNOT_REPLACE , BlockTags.GEODE_INVALID_BLOCKS),
                        new GeodeLayerSettings(1.7D, 2.2D, 3.2D, 4.2D),
                        new GeodeCrackSettings(0.95D, 2.0D, 2), 0.35D,
                        0.083D, true, UniformInt.of(4, 6),
                        UniformInt.of(3, 4),
                        UniformInt.of(1, 2), -16, 16, 0.05D, 1));*/
    }


/*    public static final RegistryObject<ConfiguredFeature<?, ?>> LARCH_SPAWN = CONFIGURED_FEATURES.register("larch_spawn", () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(ModPlacedFeatures.LARCH_CHECKED.getHolder().get(),
                            0.9F)), ModPlacedFeatures.LARCH_CHECKED.getHolder().get())));*/

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(TheWorldBefore.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
