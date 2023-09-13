package com.suurflieg.theworldbefore.world.feature;

import com.suurflieg.theworldbefore.TheWorldBefore;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModPlacedFeatures {

    public static final ResourceKey<PlacedFeature> LARCH_PLACED_KEY = registerKey("larch_placed");

    public static final ResourceKey<PlacedFeature> TITANIUM_ORE_PLACED_KEY = registerKey("titanium_ore_placed");

    public static final ResourceKey<PlacedFeature> AVENTURINE_GEODE_PLACED_KEY = registerKey("aventurine_geode_placed");
    public static final ResourceKey<PlacedFeature> PYRITE_GEODE_PLACED_KEY = registerKey("pyrite_geode_placed");
    public static final ResourceKey<PlacedFeature> RUBY_GEODE_PLACED_KEY = registerKey("ruby_geode_placed");
    public static final ResourceKey<PlacedFeature> TOPAZ_GEODE_PLACED_KEY = registerKey("topaz_geode_placed");
    public static final ResourceKey<PlacedFeature> SPECTROLITE_GEODE_PLACED_KEY = registerKey("spectrolite_geode_placed");
    public static final ResourceKey<PlacedFeature> UNAKITE_GEODE_PLACED_KEY = registerKey("unakite_geode_placed");


    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

/*        register(context, LARCH_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeature.LARCH_TREE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1f, 2),
                        ModTreeBlocks.LARCH_SAPLING.get()));*/

        register(context, TITANIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeature.OVERWORLD_TITANIUM_ORE_KEY),
                ModOrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));

        register(context, AVENTURINE_GEODE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeature.AVENTURINE_GEODE_KEY),
                List.of(RarityFilter.onAverageOnceEvery(50), InSquarePlacement.spread(),
                        HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-64), VerticalAnchor.absolute(24)),
                        BiomeFilter.biome()));

        register(context, PYRITE_GEODE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeature.PYRITE_GEODE_KEY),
                List.of(RarityFilter.onAverageOnceEvery(50), InSquarePlacement.spread(),
                        HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-64), VerticalAnchor.absolute(24)),
                        BiomeFilter.biome()));

        register(context, RUBY_GEODE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeature.RUBY_GEODE_KEY),
                List.of(RarityFilter.onAverageOnceEvery(50), InSquarePlacement.spread(),
                        HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-64), VerticalAnchor.absolute(24)),
                        BiomeFilter.biome()));

        register(context, TOPAZ_GEODE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeature.TOPAZ_GEODE_KEY),
                List.of(RarityFilter.onAverageOnceEvery(50), InSquarePlacement.spread(),
                        HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-64), VerticalAnchor.absolute(24)),
                        BiomeFilter.biome()));

        register(context, SPECTROLITE_GEODE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeature.SPECTROLITE_GEODE_KEY),
                List.of(RarityFilter.onAverageOnceEvery(50), InSquarePlacement.spread(),
                        HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-64), VerticalAnchor.absolute(24)),
                        BiomeFilter.biome()));

        register(context, UNAKITE_GEODE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeature.UNAKITE_GEODE_KEY),
                List.of(RarityFilter.onAverageOnceEvery(50), InSquarePlacement.spread(),
                        HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-64), VerticalAnchor.absolute(24)),
                        BiomeFilter.biome()));

    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(TheWorldBefore.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }


}
