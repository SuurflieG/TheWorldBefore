package com.suurflieg.theworldbefore.gui.widgets;

import com.mojang.blaze3d.systems.RenderSystem;
import com.suurflieg.theworldbefore.TheWorldBefore;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.locale.Language;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class EquipmentSelectButton extends AbstractWidget {

    public final String toolName;
    public final Consumer<Boolean> onPress;
    public boolean enabled;
    public boolean currentlySelected;
    public final ResourceLocation texture;

    private final Item item;

    public EquipmentSelectButton(int xIn, int yIn, String toolName, Item item, Consumer<Boolean> onPress) {
        super(xIn, yIn, 16, 16, Component.literal(toolName)); // Using toolName as the button label
        this.toolName = toolName;
        this.item = item;
        this.texture = new ResourceLocation(TheWorldBefore.MOD_ID, "textures/item/" + toolName + ".png");
        this.onPress = onPress;
        this.enabled = isItemInInventory(); // Check if the item is in the player's inventory
    }

    @Override
    public void onClick(double pMouseX, double pMouseY) {
        if (isItemInInventory()) {
            this.currentlySelected = !this.currentlySelected;
            this.onPress.accept(this.currentlySelected);
        }
    }

    private boolean isItemInInventory() {
        Player player = Minecraft.getInstance().player;
        if (player != null) {
            for (ItemStack stack : player.inventory.items) {
                if (stack.getItem() == item) {
                    return true;
                }
            }
        }
        return false;
    }


    @Override
    protected void renderWidget(GuiGraphics guiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        Color selectedColor = this.currentlySelected ? Color.orange : Color.gray;

        guiGraphics.fill(this.getX(), this.getY(), this.getX() + this.width, this.getY() + this.height, ((this.currentlySelected ? 0xFFC800 : 0x808080)) + selectedColor.getRGB());

        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
        RenderSystem.setShaderTexture(0, texture);
        guiGraphics.blit(texture, this.getX(), this.getY(), 0, 0, 16, 16, 16, 16);
    }

    @Override
    protected void updateWidgetNarration(NarrationElementOutput pNarrationElementOutput) {

    }


    public List<FormattedCharSequence> getOurTooltip() {
        return Language.getInstance().getVisualOrder(Arrays.asList(this.getMessage(), Component.literal("Enabled: " + this.enabled).withStyle(this.enabled ? ChatFormatting.GREEN : ChatFormatting.RED)));
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
