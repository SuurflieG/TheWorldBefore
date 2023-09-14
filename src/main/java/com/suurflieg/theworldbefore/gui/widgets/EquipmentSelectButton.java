package com.suurflieg.theworldbefore.gui.widgets;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.Gui;
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

public class EquipmentSelectButton extends AbstractWidget {

    public final Predicate<Boolean> onPress;
    public boolean enabled;
    public boolean currentlySelected;
    public final ResourceLocation texture;

    public EquipmentSelectButton(int xIn, int yIn, Component pMessage, ResourceLocation texture, Predicate<Boolean> onPress) {
        super(xIn, yIn, 41, 14, pMessage);

        this.texture = texture;
        this.onPress = onPress;
        this.currentlySelected = this.onPress.test(false);
    }

    @Override
    protected void renderWidget(GuiGraphics guiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        Color selectedColor = this.currentlySelected ? Color.orange : Color.gray;

        guiGraphics.fill(this.getX(), this.getY(), this.getX() + this.width, this.getY() + this.height, ((this.currentlySelected ? 0xFFC800 : 0x808080)) + selectedColor.getRGB());

        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
        RenderSystem.setShaderTexture(0, texture);
        guiGraphics.blit(texture, this.getX(), this.getY(), 0, 0, 41, 14, 41, 14);
    }

    @Override
    protected void updateWidgetNarration(NarrationElementOutput pNarrationElementOutput) {

    }

/*    public List<FormattedCharSequence> getTooltip() {
        return Language.getInstance().getVisualOrder(Arrays.asList(this.getMessage(), Component.literal("Currently Selected: " + this.currentlySelected).withStyle(this.currentlySelected ? ChatFormatting.YELLOW : ChatFormatting.GRAY)));
    }*/

    public List<FormattedCharSequence> getOurTooltip() {
        return Language.getInstance().getVisualOrder(Arrays.asList(this.getMessage(), Component.literal("Enabled: " + this.enabled).withStyle(this.enabled ? ChatFormatting.GREEN : ChatFormatting.RED)));
    }

    @Override
    public void onClick(double pMouseX, double pMouseY) {
        this.currentlySelected = !this.currentlySelected;
        this.onPress.test(true);
    }

    public void setCurrentlySelected(boolean currentlySelected) {
        this.currentlySelected = currentlySelected;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public boolean isCurrentlySelected() {
        return currentlySelected;
    }

    @Override
    public void setMessage(Component pMessage) {
        super.setMessage(pMessage);
    }

}
