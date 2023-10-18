package com.suurflieg.theworldbefore.world;


import com.suurflieg.theworldbefore.TheWorldBefore;
import com.suurflieg.theworldbefore.registry.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
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



    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {

        register(context, LARCH_TREE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(ModBlocks.LARCH_LOG.get()),
                new StraightTrunkPlacer(5,4,3),
                BlockStateProvider.simple(ModBlocks.LARCH_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(3), ConstantInt.of(2), 3),
                new TwoLayersFeatureSize(1, 0, 2)).build());

        RuleTest stoneReplaceabeles = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceabeles = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> overworldTitaniumOres =
                List.of(OreConfiguration.target(stoneReplaceabeles, ModBlocks.ENDERITE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceabeles, ModBlocks.DEEPSLATE_ENDERITE_ORE.get().defaultBlockState()));

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

        register(context, OVERWORLD_TITANIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldTitaniumOres, 9));

        register(context, OVERWORLD_AVENTURINE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldAventurineOres, 9));
        register(context, OVERWORLD_PYRITE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldPyriteOres, 9));
        register(context, OVERWORLD_RUBY_ORE_KEY, Feature.ORE, new OreConfiguration(overworldRubyOres, 9));
        register(context, OVERWORLD_TOPAZ_ORE_KEY, Feature.ORE, new OreConfiguration(overworldTopazOres, 9));
        register(context, OVERWORLD_SPECTROLITE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldSpectroliteOres, 9));
        register(context, OVERWORLD_UNAKITE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldUnakiteOres, 9));

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
