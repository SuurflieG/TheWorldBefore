package com.suurflieg.theworldbefore.recipe;

import com.google.gson.JsonObject;
import com.suurflieg.theworldbefore.registry.ModRecipesSerializer;
import net.minecraft.core.RegistryAccess;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.item.crafting.SmithingRecipe;
import net.minecraft.world.level.Level;

import java.util.stream.Stream;

public class ModSmithingRecipe implements SmithingRecipe {
    private final ResourceLocation id;
    final Ingredient template;
    final Ingredient base;
    final Ingredient addition;
    final ItemStack result;
    final ItemStack result2;

    public ModSmithingRecipe(ResourceLocation pId, Ingredient pTemplate, Ingredient pBase, Ingredient pAddition, ItemStack pResult, ItemStack result2) {
        this.id = pId;
        this.template = pTemplate;
        this.base = pBase;
        this.addition = pAddition;
        this.result = pResult;
        this.result2 = result2;
    }

    /**
     * Used to check if a recipe matches current crafting inventory
     */
    public boolean matches(Container pContainer, Level pLevel) {
        return this.template.test(pContainer.getItem(0)) && this.base.test(pContainer.getItem(1)) && this.addition.test(pContainer.getItem(2));
    }

    public ItemStack assemble(Container pContainer, RegistryAccess pRegistryAccess) {
        ItemStack itemstack = this.result.copy();
        CompoundTag compoundtag = pContainer.getItem(1).getTag();
        if (compoundtag != null) {
            itemstack.setTag(compoundtag.copy());
        }

        return itemstack;
    }

    public ItemStack getResultItem(RegistryAccess pRegistryAccess) {
        return this.result;
    }

    public boolean isTemplateIngredient(ItemStack pStack) {
        return this.template.test(pStack);
    }

    public boolean isBaseIngredient(ItemStack pStack) {
        return this.base.test(pStack);
    }

    public boolean isAdditionIngredient(ItemStack pStack) {
        return this.addition.test(pStack);
    }

    public ResourceLocation getId() {
        return this.id;
    }

    public RecipeSerializer<?> getSerializer() {
        return ModRecipesSerializer.SMITHING_SERIALIZER.get();
    }

    public boolean isIncomplete() {
        return Stream.of(this.template, this.base, this.addition).anyMatch(net.minecraftforge.common.ForgeHooks::hasNoElements);
    }

    public static class Serializer implements RecipeSerializer<ModSmithingRecipe> {

        public static final ModSmithingRecipe.Serializer INSTANCE = new ModSmithingRecipe.Serializer();

        public ModSmithingRecipe fromJson(ResourceLocation resourceLocation, JsonObject jsonObject) {
            Ingredient ingredient = Ingredient.fromJson(GsonHelper.getNonNull(jsonObject, "template"));
            Ingredient ingredient1 = Ingredient.fromJson(GsonHelper.getNonNull(jsonObject, "base"));
            Ingredient ingredient2 = Ingredient.fromJson(GsonHelper.getNonNull(jsonObject, "addition"));
            ItemStack itemstack = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(jsonObject, "result"));
            ItemStack itemstack2 = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(jsonObject, "result2"));
            return new ModSmithingRecipe(resourceLocation, ingredient, ingredient1, ingredient2, itemstack, itemstack2);
        }

        public ModSmithingRecipe fromNetwork(ResourceLocation resourceLocation, FriendlyByteBuf friendlyByteBuf ) {
            Ingredient ingredient = Ingredient.fromNetwork(friendlyByteBuf);
            Ingredient ingredient1 = Ingredient.fromNetwork(friendlyByteBuf);
            Ingredient ingredient2 = Ingredient.fromNetwork(friendlyByteBuf);
            ItemStack itemstack = friendlyByteBuf.readItem();
            ItemStack itemstack2 = friendlyByteBuf.readItem();
            return new ModSmithingRecipe(resourceLocation, ingredient, ingredient1, ingredient2, itemstack, itemstack2);
        }

        @Override
        public void toNetwork(FriendlyByteBuf pBuffer, ModSmithingRecipe pRecipe) {
            pRecipe.template.toNetwork(pBuffer);
            pRecipe.base.toNetwork(pBuffer);
            pRecipe.addition.toNetwork(pBuffer);
            pBuffer.writeItem(pRecipe.result);
        }
    }
}
