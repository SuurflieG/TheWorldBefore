package com.suurflieg.theworldbefore.gui.widgets;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.network.chat.Component;

import java.util.function.Consumer;


public class TabButton extends AbstractWidget {

    private final int tabIndex;
    public final Consumer<Boolean> onPress;

    public TabButton(int x, int y, int widthIn, int heightIn, Component buttonText, int index, Consumer<Boolean> onPress) {
        super(x, y, widthIn, heightIn, buttonText);
        this.tabIndex = index;
        this.onPress = onPress;
        this.setTabOrderGroup(0); // You can adjust the tab order group as needed
    }

    @Override
    public void render(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
    }

    @Override
    public void onClick(double mouseX, double mouseY) {
        super.onClick(mouseX, mouseY);
        this.onClick(mouseX, mouseY);
    }

    @Override
    protected void renderWidget(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        // Add any additional rendering code if needed
        // You can use pGuiGraphics to draw custom elements
    }

    @Override
    protected void updateWidgetNarration(NarrationElementOutput pNarrationElementOutput) {
        // Add narration text if needed
    }

    public int getTabIndex() {
        return tabIndex;
    }
}
