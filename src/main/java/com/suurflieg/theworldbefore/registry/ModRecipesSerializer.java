package com.suurflieg.theworldbefore.registry;


import com.suurflieg.theworldbefore.TheWorldBefore;
import com.suurflieg.theworldbefore.recipe.CatalyzerRecipe;
import com.suurflieg.theworldbefore.recipe.ModSmithingRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipesSerializer {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, TheWorldBefore.MOD_ID);

    public static final RegistryObject<RecipeSerializer<CatalyzerRecipe>> CATALYZER_SERIALIZER = SERIALIZERS.register("catalyzing", () -> CatalyzerRecipe.Serializer.INSTANCE);
    public static final RegistryObject<RecipeSerializer<ModSmithingRecipe>> SMITHING_SERIALIZER = SERIALIZERS.register("smithing", () -> ModSmithingRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}