package com.suurflieg.theworldbefore.datagen;

import com.suurflieg.theworldbefore.TheWorldBefore;
import com.suurflieg.theworldbefore.registry.ModBlocks;
import com.suurflieg.theworldbefore.registry.ModItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    private static final List<ItemLike> TITANIUM_SMELTABLES = List.of(ModItems.TITANIUM_RAW_ORE.get(), ModBlocks.TITANIUM_ORE.get(), ModBlocks.DEEPSLATE_TITANIUM_ORE.get());


    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> writer) {

        oreSmelting(writer, TITANIUM_SMELTABLES, RecipeCategory.MISC, ModItems.TITANIUM_INGOT.get(), 0.75f, 200, "titanium");
        oreBlasting(writer, TITANIUM_SMELTABLES, RecipeCategory.MISC, ModItems.TITANIUM_INGOT.get(), 0.75f, 100, "titanium");

        //region Shaped Ingot to Block Recipes

        nineBlockStorageRecipesWithCustomPacking(writer, RecipeCategory.MISC, ModItems.TITANIUM_NUGGET.get(), RecipeCategory.MISC, ModItems.TITANIUM_INGOT.get(), "titanium_ingot_from_nuggets", "titanium_ingot");
        nineBlockStorageRecipesWithCustomPacking(writer, RecipeCategory.MISC, ModItems.TITANIUM_INGOT.get(), RecipeCategory.MISC, ModBlocks.TITANIUM_BLOCK.get(), "titanium_block_from_ingots", "titanium_block");
        //nineBlockStorageRecipesRecipesWithCustomUnpacking(writer, RecipeCategory.MISC, ModBlocks.TITANIUM_BLOCK.get(), RecipeCategory.BUILDING_BLOCKS, ModItems.TITANIUM_INGOT.get(), "titanium_ingot_from_titanium_block", "gold_ingot");

        //endregion

        //region Block to Ingot Recipes

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC ,ModItems.TITANIUM_INGOT.get(), 9)
                .requires(ModBlocks.TITANIUM_BLOCK.get())
                .unlockedBy("has_titanium_block", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.TITANIUM_BLOCK.get()).build()))
                .save(writer);

        //endregion

        //region Ingot to Nugget Recipes

        /*ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TITANIUM_NUGGET.get(), 9)
                .requires(ModItems.TITANIUM_INGOT.get())
                .unlockedBy("has_titanium_ingot_", inventoryTrigger(ItemPredicate.Builder.item().of(ModItems.TITANIUM_INGOT.get()).build()))
                .save(writer);*/

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
}


        //region Catalyzer Recipes
/*        new CatalyzerRecipeBuilder(ModItems.GEM_RAW_AVENTURINE.get(), ModItems.GEM_RAW_AVENTURINE.get(), ModItems.GEM_RAW_AVENTURINE.get(), ModItems.GEM_RAW_AVENTURINE.get(), ModItems.CATALYST.get(), ModItems.GEM_AVENTURINE.get(), 1,80)
                .unlockedBy("has_gem_raw_aventurine", inventoryTrigger(ItemPredicate.Builder.item().of(ModItems.GEM_RAW_AVENTURINE.get()).build())).save(writer);
        new CatalyzerRecipeBuilder(ModItems.GEM_RAW_CALCITE.get(), ModItems.GEM_RAW_CALCITE.get(), ModItems.GEM_RAW_CALCITE.get(), ModItems.GEM_RAW_CALCITE.get(), ModItems.CATALYST.get(), ModItems.GEM_CALCITE.get(), 1,80)
                .unlockedBy("has_gem_raw_aventurine", inventoryTrigger(ItemPredicate.Builder.item().of(ModItems.GEM_RAW_CALCITE.get()).build())).save(writer);
        new CatalyzerRecipeBuilder(ModItems.GEM_RAW_PYRITE.get(), ModItems.GEM_RAW_PYRITE.get(), ModItems.GEM_RAW_PYRITE.get(), ModItems.GEM_RAW_PYRITE.get(), ModItems.CATALYST.get(), ModItems.GEM_PYRITE.get(), 1,80)
                .unlockedBy("has_gem_raw_aventurine", inventoryTrigger(ItemPredicate.Builder.item().of(ModItems.GEM_RAW_PYRITE.get()).build())).save(writer);
        new CatalyzerRecipeBuilder(ModItems.GEM_RAW_RUBY.get(), ModItems.GEM_RAW_RUBY.get(), ModItems.GEM_RAW_RUBY.get(), ModItems.GEM_RAW_RUBY.get(), ModItems.CATALYST.get(), ModItems.GEM_RUBY.get(), 1,80)
                .unlockedBy("has_gem_raw_aventurine", inventoryTrigger(ItemPredicate.Builder.item().of(ModItems.GEM_RAW_RUBY.get()).build())).save(writer);
        new CatalyzerRecipeBuilder(ModItems.GEM_RAW_TOPAZ.get(), ModItems.GEM_RAW_TOPAZ.get(), ModItems.GEM_RAW_TOPAZ.get(), ModItems.GEM_RAW_TOPAZ.get(), ModItems.CATALYST.get(), ModItems.GEM_TOPAZ.get(), 1,80)
                .unlockedBy("has_gem_raw_aventurine", inventoryTrigger(ItemPredicate.Builder.item().of(ModItems.GEM_RAW_TOPAZ.get()).build())).save(writer);
        new CatalyzerRecipeBuilder(ModItems.GEM_RAW_UNAKITE.get(), ModItems.GEM_RAW_UNAKITE.get(), ModItems.GEM_RAW_UNAKITE.get(), ModItems.GEM_RAW_UNAKITE.get(), ModItems.CATALYST.get(), ModItems.GEM_UNAKITE.get(), 1,80)
                .unlockedBy("has_gem_raw_aventurine", inventoryTrigger(ItemPredicate.Builder.item().of(ModItems.GEM_RAW_UNAKITE.get()).build())).save(writer);*//*

        //endregion


    }
}
*/
