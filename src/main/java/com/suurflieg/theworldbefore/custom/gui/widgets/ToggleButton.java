package com.suurflieg.theworldbefore.custom.gui.widgets;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.locale.Language;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FormattedCharSequence;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class ToggleButton extends AbstractWidget {
    public final Predicate<Boolean> onPress;
    public boolean enabled;
    public final ResourceLocation texture;

    public ToggleButton(int xIn, int yIn, Component msg, ResourceLocation texture, Predicate<Boolean> onPress) {
        super(xIn, yIn, 16, 16, msg);

        this.texture = texture;
        this.onPress = onPress;

        this.enabled = this.onPress.test(false);
    }

/*    public List<FormattedCharSequence> getTooltip() {
        return Language.getInstance().getVisualOrder(Arrays.asList(this.getMessage(), new TextComponent("Enabled: " + this.enabled).withStyle(this.enabled ? ChatFormatting.GREEN : ChatFormatting.GRAY)));
    }*/

    @Override
    protected void renderWidget(GuiGraphics guiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        Color activeColor = this.enabled ? Color.GREEN : Color.LIGHT_GRAY;

        guiGraphics.fill(this.getX(), this.getY(), this.getX() + this.width, this.getY() + this.height, ((this.enabled ? 0x68000000 : 0x9B000000)) + activeColor.getRGB());

        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
        RenderSystem.setShaderTexture(0, texture);
        guiGraphics.blit(texture, this.getX() + 1, this.getY() + 1, 0, 0, 14, 14, 14, 14);
    }

    @Override
    public void onClick(double pMouseX, double pMouseY) {
        this.enabled = !this.enabled;
        this.onPress.test(true);
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public List<FormattedCharSequence> getOurTooltip() {
        return Language.getInstance().getVisualOrder(Arrays.asList(this.getMessage(), Component.literal("Enabled: " + this.enabled).withStyle(this.enabled ? ChatFormatting.GREEN : ChatFormatting.RED)));
    }

    @Override
    protected void updateWidgetNarration(NarrationElementOutput pNarrationElementOutput) {

    }
}
