/*
package com.suurflieg.theworldbefore.custom.integration.jei;

import com.suurflieg.theworldbefore.TheWorldBefore;
import com.suurflieg.theworldbefore.custom.recipe.CatalyzerRecipe;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.*;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;
import java.util.Objects;

@JeiPlugin
public class JEIPluginAventuria implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(TheWorldBefore.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new CatalyzerRecipeCategory(registration.getJeiHelpers().getGuiHelper()));

    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();


        List<CatalyzerRecipe> catalyzerRecipes = rm.getAllRecipesFor(CatalyzerRecipe.Type.INSTANCE);
        registration.addRecipes(new RecipeType<>(CatalyzerRecipeCategory.UID, CatalyzerRecipe.class), catalyzerRecipes);
    }

*/
/*    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(CatalyzerScreen.class, 81, 37, 16, 16, JEIRecipeTypes.JEI_INFUSER);
    }
    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.CATALYZER.get()), JEIRecipeTypes.JEI_INFUSER);
    }

    @Override
    public void registerRecipeTransferHandlers(IRecipeTransferRegistration registration) {
        registration.addRecipeTransferHandler(CatalyzerMenu.class, JEIRecipeTypes.JEI_INFUSER, 0, 6, 8, 36);
    }*//*

}
*/
