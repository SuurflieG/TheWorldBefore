package com.suurflieg.theworldbefore.recipe;

import com.suurflieg.theworldbefore.registry.ModBlocks;
import com.suurflieg.theworldbefore.registry.ModRecipeTypes;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;

public interface IModSmithingRecipe extends Recipe<Container> {
    default RecipeType<?> getType() {
        return ModRecipeTypes.MOD_SMITHING.get();
    }

    /**
     * Used to determine if this recipe can fit in a grid of the given width/height
     */
    default boolean canCraftInDimensions(int pWidth, int pHeight) {
        return pWidth >= 3 && pHeight >= 1;
    }

    default ItemStack getToastSymbol() {
        return new ItemStack(ModBlocks.SMITHING_TABLE_PLUS.get());
    }

    boolean isTemplateIngredient(ItemStack pStack);

    boolean isBaseIngredient(ItemStack pStack);

    boolean isAdditionIngredient(ItemStack pStack);
}