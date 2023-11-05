package com.suurflieg.theworldbefore.registry;

import com.suurflieg.theworldbefore.TheWorldBefore;
import com.suurflieg.theworldbefore.recipe.ModSmithingRecipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipeTypes {

    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES =
            DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, TheWorldBefore.MOD_ID);

    public static final RegistryObject<RecipeType<ModSmithingRecipe>> MOD_SMITHING = RECIPE_TYPES.register("mod_smithing", () -> RecipeType.simple(TheWorldBefore.prefix("mod_smithing")));


    public static void register(IEventBus eventBus) {
        RECIPE_TYPES.register(eventBus);
    }
}
