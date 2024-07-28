package com.suurflieg.theworldbefore.gui.widgets;

import com.suurflieg.theworldbefore.client.render.CustomOutlineRenderer;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.network.chat.Component;

import java.awt.*;

public class ColorPickerButton extends AbstractWidget {

    public static final Color[] COLORS = {
            Color.WHITE,
            Color.RED,
            Color.PINK,
            Color.ORANGE,
            Color.YELLOW,
            Color.GREEN,
            Color.MAGENTA,
            Color.CYAN,
            Color.BLUE
    };

    private int colorIndex = 0;

    public ColorPickerButton(int pX, int pY, int pWidth, int pHeight, Component pMessage) {
        super(pX, pY, pWidth, pHeight, pMessage);

        this.colorIndex = CustomOutlineRenderer.getOutlineColorIndex();
    }

    @Override
    public void onClick(double pMouseX, double pMouseY) {
        super.onClick(pMouseX, pMouseY);
        cycleColor();
        CustomOutlineRenderer.setOutlineColor(COLORS[colorIndex]);
    }

    private void cycleColor() {
        // Get the next color from the predefined array
        Color newColor = COLORS[colorIndex];

        // Increment the color index for the next click
        colorIndex = (colorIndex + 1) % COLORS.length;

        // Set the new color in the CustomOutlineRender class
        CustomOutlineRenderer.setOutlineColor(newColor);
    }

    @Override
    protected void renderWidget(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        pGuiGraphics.fill(this.getX(), this.getY(), this.getX() + this.width, this.getY() + this.height, COLORS[colorIndex].getRGB());
    }

    @Override
    protected void updateWidgetNarration(NarrationElementOutput pNarrationElementOutput) {

    }


}
