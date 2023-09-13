package com.suurflieg.theworldbefore.custom.gui.screen;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

public class AventuriaChronicleScreen extends Screen {

    protected AventuriaChronicleScreen(Component pTitle) {
        super(pTitle);
    }

    @Override
    public @NotNull Component getTitle() {
        return super.getTitle();
    }

    @Override
    public void render(GuiGraphics guiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        super.render(guiGraphics, pMouseX, pMouseY, pPartialTick);
    }

    @Override
    public boolean shouldCloseOnEsc() {
        return super.shouldCloseOnEsc();
    }

    @Override
    public boolean mouseClicked(double pMouseX, double pMouseY, int pButton) {
        return super.mouseClicked(pMouseX, pMouseY, pButton);
    }
}
