package com.suurflieg.theworldbefore.world.tree;

import com.suurflieg.theworldbefore.world.ModConfiguredFeature;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

public class LarchTreeGrower extends AbstractTreeGrower {


    @Nullable
    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource pRandom, boolean pHasFlowers) {
        return ModConfiguredFeature.LARCH_TREE_KEY;
    }
}
