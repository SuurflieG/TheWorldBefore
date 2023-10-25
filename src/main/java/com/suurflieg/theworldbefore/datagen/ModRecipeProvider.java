package com.suurflieg.theworldbefore.datagen;

import com.suurflieg.theworldbefore.TheWorldBefore;
import com.suurflieg.theworldbefore.recipe.ModSmithingTransformRecipeBuilder;
import com.suurflieg.theworldbefore.registry.ModBlocks;
import com.suurflieg.theworldbefore.registry.ModItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    private static final List<ItemLike> ENDERITE_SMELTABLES = List.of(ModItems.ENDERITE_RAW.get(), ModBlocks.ENDERITE_ORE.get(), ModBlocks.DEEPSLATE_ENDERITE_ORE.get());


    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> writer) {

        oreSmelting(writer, ENDERITE_SMELTABLES, RecipeCategory.MISC, ModItems.ENDERITE_INGOT.get(), 0.75f, 200, "enderite");
        oreBlasting(writer, ENDERITE_SMELTABLES, RecipeCategory.MISC, ModItems.ENDERITE_INGOT.get(), 0.75f, 100, "enderite");

        //region Shaped Ingot to Block Recipes

        nineBlockStorageRecipesWithCustomPacking(writer, RecipeCategory.MISC, ModItems.ENDERITE_NUGGET.get(), RecipeCategory.MISC, ModItems.ENDERITE_INGOT.get(), "enderite_ingot_from_nuggets", "enderite_ingot");
        nineBlockStorageRecipesWithCustomPacking(writer, RecipeCategory.MISC, ModItems.ENDERITE_INGOT.get(), RecipeCategory.MISC, ModBlocks.ENDERITE_BLOCK.get(), "enderite_block_from_ingots", "enderite_block");

        enderiteSmithing(writer, Items.NETHERITE_AXE, RecipeCategory.TOOLS, ModItems.ENDERITE_AXE.get(), ModItems.ENDERITE_NUGGET.get());
        //endregion

        //region Block to Ingot Recipes

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC ,ModItems.ENDERITE_INGOT.get(), 9)
                .requires(ModBlocks.ENDERITE_BLOCK.get())
                .unlockedBy("has_enderite_block", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.ENDERITE_BLOCK.get()).build()))
                .save(writer);


        //endregion


        //region shards to blocks
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.AVENTURINE_BLOCK.get())
                .define('S', ModItems.AVENTURINE_SHARD.get())
                .pattern("SS ")
                .pattern("SS ")
                .pattern("   ")
                .unlockedBy("has_aventurine_block", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.AVENTURINE_BLOCK.get()).build()))
                .save(writer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PYRITE_BLOCK.get())
                .define('S', ModItems.PYRITE_SHARD.get())
                .pattern("SS ")
                .pattern("SS ")
                .pattern("   ")
                .unlockedBy("has_pyrite_block", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.PYRITE_BLOCK.get()).build()))
                .save(writer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RUBY_BLOCK.get())
                .define('S', ModItems.RUBY_SHARD.get())
                .pattern("SS ")
                .pattern("SS ")
                .pattern("   ")
                .unlockedBy("has_ruby_block", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.RUBY_BLOCK.get()).build()))
                .save(writer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SPECTROLITE_BLOCK.get())
                .define('S', ModItems.SPECTROLITE_SHARD.get())
                .pattern("SS ")
                .pattern("SS ")
                .pattern("   ")
                .unlockedBy("has_spectrolite_block", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.SPECTROLITE_BLOCK.get()).build()))
                .save(writer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TOPAZ_BLOCK.get())
                .define('S', ModItems.TOPAZ_SHARD.get())
                .pattern("SS ")
                .pattern("SS ")
                .pattern("   ")
                .unlockedBy("has_topaz_block", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.TOPAZ_BLOCK.get()).build()))
                .save(writer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.UNAKITE_BLOCK.get())
                .define('S', ModItems.UNAKITE_SHARD.get())
                .pattern("SS ")
                .pattern("SS ")
                .pattern("   ")
                .unlockedBy("has_unakite_block", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.UNAKITE_BLOCK.get()).build()))
                .save(writer);

    }


    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                    pExperience, pCookingTime, pCookingSerializer).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, TheWorldBefore.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }

    protected static void enderiteSmithing(Consumer<FinishedRecipe> pFinishedRecipeConsumer, Item pIngredientItem, RecipeCategory pCategory, Item pResultItem, Item pResultItemXP) {

        ModSmithingTransformRecipeBuilder
                .smithing(Ingredient.of(ModItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE.get()),
                        Ingredient.of(pIngredientItem),
                        Ingredient.of(ModItems.ENDERITE_INGOT.get()),
                        pCategory, pResultItem, pResultItemXP)
                .unlocks("has_enderite_ingot",
                        has(ModItems.ENDERITE_INGOT.get())).save(pFinishedRecipeConsumer,
                        TheWorldBefore.MOD_ID + ":" + getItemName(pResultItem) + "_smithing");
    }
}


