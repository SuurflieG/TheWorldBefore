package com.suurflieg.theworldbefore.gui.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.suurflieg.theworldbefore.gui.widgets.TabButton;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.phys.Vec3;

import java.util.ArrayList;
import java.util.List;

public class TestScreen extends Screen {

    private static final int TAB_ONE = 0;
    private static final int TAB_TWO = 1;
    private static final int TAB_THREE = 2;

    private int currentTab;
    private Sheep sheep;
    private final List<AbstractWidget> tabButtons = new ArrayList<>();

    public TestScreen() {
        super(Component.literal("gui.test.title"));
    }

    @Override
    protected void init() {


        tabButtons.add(new TabButton(
                width / 2 - 50,
                height / 2 - 30,
                100, 20,
                Component.literal("Tab 1"),
                TAB_ONE,
                button -> switchTab(TAB_ONE)));

        tabButtons.add(new TabButton(
                width / 2 - 50,
                height / 2, 100,
                20,
                Component.literal("Tab 2"),
                TAB_TWO,
                button -> switchTab(TAB_TWO)));


        tabButtons.add(new TabButton(
                width / 2 - 50,
                height / 2 + 30,
                100,
                20,
                Component.literal("Tab 3"),
                TAB_THREE,
                button -> switchTab(TAB_THREE)));

        switchTab(TAB_ONE); // Display the first tab by default
    }

    private void switchTab(int tab) {
        currentTab = tab;

        // Remove existing buttons
        tabButtons.clear();

        // Add buttons/content for the current tab
        switch (tab) {
            case TAB_ONE:
                // Create a sheep entity for Tab 1
                Sheep sheep = EntityType.SHEEP.create(Minecraft.getInstance().level);
                sheep.setPos(new Vec3(width / 2, height / 2 + 50, 0)); // Adjust the position as needed
                // Set sheep's stats
                sheep.setHealth(20.0F); // Set the health
                sheep.setCustomName(Component.literal("Sheep"));
                // Render the sheep
                drawEntity(sheep, width / 2 - 20, height / 2 + 100, 30, 0, 0);
                break;
            // Add cases for other tabs

        }
    }

    @Override
    public void render(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);

        renderBackground(pGuiGraphics);

        // Display sheep's stats in Tab 1
        if (currentTab == TAB_ONE && sheep != null) {
            String healthText = "Health: " + sheep.getHealth();

            // Use the FontRenderer from Minecraft instance
            Font font = Minecraft.getInstance().font;
            int textWidth = font.width(healthText);

            // Draw the text
            pGuiGraphics.drawString(font ,healthText, width / 2 - textWidth / 2, height / 2 + 150, 0xFFFFFF);

            // You can add more information as needed
        }
    }

    public void drawEntity(Entity entity, int x, int y, int scale, float mouseX, float mouseY) {
        RenderSystem.enableDepthTest();


        RenderSystem.getModelViewStack().pushPose();
        RenderSystem.getModelViewStack().translate((float) x, (float) y, 50.0F);
        RenderSystem.getModelViewStack().scale((float) (-scale), (float) scale, (float) scale);

        RenderSystem.getModelViewStack().translate(0.0D, 0.0D, 100.0D);
        RenderSystem.getModelViewStack().scale(1.0F, 1.0F, -1.0F);

        // Use the RenderType to render the entity
        RenderType renderType = RenderType.entitySolid(TextureAtlas.LOCATION_BLOCKS);

        entity.level.getProfiler().push(renderType.toString());

        MultiBufferSource.BufferSource bufferSource = Minecraft.getInstance().renderBuffers().bufferSource();

        renderEntity(entity, 0.0F, 0.0F, new PoseStack(), bufferSource, 15728880);

        bufferSource.endBatch(renderType);
        entity.level.getProfiler().pop();

        RenderSystem.getModelViewStack().popPose();
        RenderSystem.disableDepthTest();
    }


    private void renderEntity(Entity entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource.BufferSource bufferSource, int packedLight) {
        RenderType renderType = RenderType.entitySolid(TextureAtlas.LOCATION_BLOCKS);
        RenderSystem.runAsFancy(() -> {
            RenderSystem.setShaderTexture(0, TextureAtlas.LOCATION_BLOCKS);

            VertexConsumerProvider.Immediate vertexConsumerProvider = Minecraft.getInstance().renderBuffers().bufferSource();
            VertexConsumer vertexConsumer = vertexConsumerProvider.getBuffer(renderType);
            Minecraft.getInstance().getEntityRenderDispatcher().getRenderer(entity)
                    .render(entity, entityYaw, partialTick, poseStack, vertexConsumer, packedLight);
            vertexConsumerProvider.endBatch();
        });
    }



}
