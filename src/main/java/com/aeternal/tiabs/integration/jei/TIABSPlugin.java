package com.aeternal.tiabs.integration.jei;

import com.aeternal.tiabs.handler.integration.DescriptionHandler;
import mezz.jei.api.*;
import mezz.jei.api.ingredients.IModIngredientRegistration;
import mezz.jei.api.recipe.IStackHelper;
import mezz.jei.api.recipe.transfer.IRecipeTransferRegistry;

@JEIPlugin
public class TIABSPlugin implements IModPlugin
{
    private IJeiHelpers jeiHelpers;
    public static IStackHelper stackHelper;

    @Override
    public void register(IModRegistry registry)
    {
        this.jeiHelpers = registry.getJeiHelpers();
        TIABSPlugin.stackHelper = jeiHelpers.getStackHelper();

        IGuiHelper guiHelper = jeiHelpers.getGuiHelper();

        IRecipeTransferRegistry recipeTransferRegistry = registry.getRecipeTransferRegistry();
        DescriptionHandler.addDescriptions(registry);
    }

    @Override
    public void onRuntimeAvailable(IJeiRuntime jeiRuntime)
    {

    }
    @Override
    public void registerItemSubtypes(ISubtypeRegistry subtypeRegistry)
    {
    }

    @Override
    public void registerIngredients(IModIngredientRegistration registry)
    {
    }
}
