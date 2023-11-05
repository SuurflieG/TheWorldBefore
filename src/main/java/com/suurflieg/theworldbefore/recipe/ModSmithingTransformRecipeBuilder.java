package com.suurflieg.theworldbefore.recipe;

import com.google.gson.JsonObject;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

import javax.annotation.Nullable;
import java.util.function.Consumer;

public class ModSmithingTransformRecipeBuilder {
    private final Ingredient template;
    private final Ingredient base;
    private final Ingredient addition;
    private final RecipeCategory category;
    private final Item result;
    private final Item result2;
    private final Advancement.Builder advancement = Advancement.Builder.recipeAdvancement();
    private final RecipeSerializer<?> type;

    public ModSmithingTransformRecipeBuilder(RecipeSerializer<?> pType, Ingredient pTemplate, Ingredient pBase, Ingredient pAddition, RecipeCategory pCategory, Item pResult, Item pResult2) {
        this.category = pCategory;
        this.type = pType;
        this.template = pTemplate;
        this.base = pBase;
        this.addition = pAddition;
        this.result = pResult;
        this.result2 = pResult2;
    }

    public static ModSmithingTransformRecipeBuilder smithing(Ingredient pTemplate, Ingredient pBase, Ingredient pAddition, RecipeCategory pCategory, Item pResult, Item pResult2) {
        return new ModSmithingTransformRecipeBuilder(ModSmithingRecipe.Serializer.INSTANCE, pTemplate, pBase, pAddition, pCategory, pResult, pResult2);
    }

    public ModSmithingTransformRecipeBuilder unlocks(String pKey, CriterionTriggerInstance pCriterion) {
        this.advancement.addCriterion(pKey, pCriterion);
        return this;
    }

    public void save(Consumer<FinishedRecipe> pRecipeConsumer, String pLocation) {
        this.save(pRecipeConsumer, new ResourceLocation(pLocation));
    }

    public void save(Consumer<FinishedRecipe> pRecipeConsumer, ResourceLocation pLocation) {
        this.ensureValid(pLocation);
        this.advancement.parent(RecipeBuilder.ROOT_RECIPE_ADVANCEMENT).addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(pLocation)).rewards(AdvancementRewards.Builder.recipe(pLocation)).requirements(RequirementsStrategy.OR);
        pRecipeConsumer.accept(new ModSmithingTransformRecipeBuilder.Result(pLocation, this.type, this.template, this.base, this.addition, this.result, this.result2, this.advancement, pLocation.withPrefix("recipes/" + this.category.getFolderName() + "/")));
    }

    private void ensureValid(ResourceLocation pLocation) {
        if (this.advancement.getCriteria().isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + pLocation);
        }
    }

    public static record Result(ResourceLocation id, RecipeSerializer<?> type, Ingredient template, Ingredient base, Ingredient addition, Item result, Item pResult2, Advancement.Builder advancement, ResourceLocation advancementId) implements FinishedRecipe {
        public void serializeRecipeData(JsonObject pJson) {
            pJson.add("template", this.template.toJson());
            pJson.add("base", this.base.toJson());
            pJson.add("addition", this.addition.toJson());
            JsonObject jsonobject = new JsonObject();
            jsonobject.addProperty("item", BuiltInRegistries.ITEM.getKey(this.result).toString());
            pJson.add("result", jsonobject);
            JsonObject jsonobject2 = new JsonObject();
            jsonobject2.addProperty("item", BuiltInRegistries.ITEM.getKey(this.pResult2).toString());
            pJson.add("resultxp", jsonobject2);
        }

        public ResourceLocation getId() {
            return this.id;
        }

        public RecipeSerializer<?> getType() {
            return this.type;
        }

        @Nullable
        public JsonObject serializeAdvancement() {
            return this.advancement.serializeToJson();
        }

        @Nullable
        public ResourceLocation getAdvancementId() {
            return this.advancementId;
        }
    }
}
