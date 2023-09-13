package com.suurflieg.theworldbefore.registry;


import com.suurflieg.theworldbefore.TheWorldBefore;
import com.suurflieg.theworldbefore.custom.recipe.CatalyzerRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, TheWorldBefore.MOD_ID);

    public static final RegistryObject<RecipeSerializer<CatalyzerRecipe>> CATALYZER_SERIALIZER = SERIALIZERS.register("catalyzing", () -> CatalyzerRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}