package com.suurflieg.theworldbefore.gui.widgets;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Consumer;

public class CustomButton extends AbstractWidget {

    private final Consumer<Boolean> onPress;
    public boolean enabled;

    public final ResourceLocation texture;
    public CustomButton(int pX, int pY, int pWidth, int pHeight, Component pMessage, Consumer<Boolean> onPress, ResourceLocation texture) {
        super(pX, pY, pWidth, pHeight, pMessage);

        this.texture = texture;
        this.onPress = onPress;

        this.enabled = true;
    }

    @Override
    protected void renderWidget(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        RenderSystem.setShaderTexture(0, texture);
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);

        int textureX = 1;
        int textureY = 1;

        pGuiGraphics.blit(texture, this.getX(), this.getY(), textureX, textureY, width, height);
    }

    @Override
    protected void updateWidgetNarration(NarrationElementOutput pNarrationElementOutput) {

    }

    @Override
    public void onClick(double pMouseX, double pMouseY) {
        this.enabled = !this.enabled;

        if (this.onPress != null) {
            this.onPress.accept(true);
        }
    }
}

