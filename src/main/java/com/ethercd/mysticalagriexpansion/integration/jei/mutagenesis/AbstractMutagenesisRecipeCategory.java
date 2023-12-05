package com.ethercd.mysticalagriexpansion.integration.jei.mutagenesis;

import com.ethercd.mysticalagriexpansion.MysticalAgriexpansion;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawableAnimated;
import mezz.jei.api.gui.IDrawableStatic;
import mezz.jei.api.recipe.IRecipeCategory;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.util.ResourceLocation;

public abstract class AbstractMutagenesisRecipeCategory<T extends IRecipeWrapper> implements IRecipeCategory<T> {
    protected static final ResourceLocation TEXTURES = new ResourceLocation(MysticalAgriexpansion.MOD_ID + ":textures/gui/mutagenesis_processor_gui.png");

    protected static final int input1 = 0;
    protected static final int input2 = 1;
    protected static final int output1 = 2;
    protected static final int output2 = 3;
    protected static final int output3 = 4;

    protected final IDrawableAnimated animatedArrow;

    protected AbstractMutagenesisRecipeCategory(IGuiHelper helper) {
        IDrawableStatic staticArrow = helper.createDrawable(TEXTURES, 176, 14, 24, 17);
        animatedArrow = helper.createAnimatedDrawable(staticArrow, 200, IDrawableAnimated.StartDirection.LEFT, false);
    }
}
