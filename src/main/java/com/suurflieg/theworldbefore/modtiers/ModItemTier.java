package com.suurflieg.theworldbefore.modtiers;

import com.suurflieg.theworldbefore.registry.ModItems;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModItemTier {

    public static final ForgeTier ENDERITE = new ForgeTier(4, 3000, 10f, 6f, 0, BlockTags.NEEDS_DIAMOND_TOOL, () -> Ingredient.of(ModItems.ENDERITE_INGOT.get()));

}
