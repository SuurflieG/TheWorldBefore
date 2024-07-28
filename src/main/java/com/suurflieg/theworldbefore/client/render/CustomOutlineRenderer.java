package com.suurflieg.theworldbefore.client.render;

import com.mojang.blaze3d.platform.InputConstants;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.suurflieg.theworldbefore.TheWorldBefore;
import com.suurflieg.theworldbefore.gui.widgets.ColorPickerButton;
import com.suurflieg.theworldbefore.item.tool.CustomPickaxeItem;
import com.suurflieg.theworldbefore.item.tool.ToolProperties;
import com.suurflieg.theworldbefore.item.upgradecards.Upgrade;
import com.suurflieg.theworldbefore.item.upgradecards.UpgradeTools;
import com.suurflieg.theworldbefore.util.ModKeyBindings;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderHighlightEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;

import java.awt.*;
import java.util.List;


@Mod.EventBusSubscriber(modid = TheWorldBefore.MOD_ID, value = Dist.CLIENT)
public class CustomOutlineRenderer {

    static Color newColor = new Color(255, 255, 255);
    private static final int BASE_SIZE = 1;
    public static RenderType LINES = ModRenderType.LINES_BASIC;
    public static RenderType FULL_FACE = ModRenderType.FULL_BLOCK_OVERLAY;

    private static boolean isCorrectToolAndUpgrade(ItemStack itemStack) {
        return itemStack.getItem() instanceof CustomPickaxeItem &&
                UpgradeTools.containsActiveUpgrade(itemStack, Upgrade.AOE);
    }

    public static void setOutlineColor(Color newColor) {
        CustomOutlineRenderer.newColor = newColor;
    }

    public static int getOutlineColorIndex() {
        for (int i = 0; i < ColorPickerButton.COLORS.length; i++) {
            if (newColor.equals(ColorPickerButton.COLORS[i])) {
                return i;
            }
        }
        return 0;
    }

    private static VoxelShape scaleShape(VoxelShape originalShape, int size) {
        final Minecraft mc = Minecraft.getInstance();
        Direction playerFacing = mc.gameRenderer.getMainCamera().getEntity().getDirection();

        double offset = (size - BASE_SIZE) / 2.0;

        double minX = originalShape.bounds().minX;
        double minY = originalShape.bounds().minY;
        double minZ = originalShape.bounds().minZ;
        double maxX = originalShape.bounds().maxX;
        double maxY = originalShape.bounds().maxY;
        double maxZ = originalShape.bounds().maxZ;

        switch (playerFacing) {
            case EAST, WEST:
                minZ -= offset;
                maxZ += offset;
                minY -= offset;
                maxY += offset;
                break;
            case NORTH, SOUTH:
                minX -= offset;
                maxX += offset;
                minY -= offset;
                maxY += offset;
                break;
            case UP, DOWN:
                minX -= offset;
                maxX += offset;
                minZ -= offset;
                maxZ += offset;
                minY = originalShape.bounds().minY;
                maxY = originalShape.bounds().maxY;
                break;
        }

        return Shapes.box(minX, minY, minZ, maxX, maxY, maxZ);
    }

    public static void render(RenderHighlightEvent.Block event, ItemStack customItem) {
        final Minecraft mc = Minecraft.getInstance();
        MultiBufferSource.BufferSource buffer = Minecraft.getInstance().renderBuffers().bufferSource();

        Vec3 view = mc.gameRenderer.getMainCamera().getPosition();

        PoseStack matrix = event.getPoseStack();
        matrix.pushPose();
        matrix.translate(-view.x(), -view.y(), -view.z());

        boolean isShiftPressed = InputConstants.isKeyDown(mc.getWindow().getWindow(), GLFW.GLFW_KEY_LEFT_SHIFT);
        boolean isToggleKeyPressed = ModKeyBindings.MINING_AOE_RENDER_TOGGLE.consumeClick();

        VertexConsumer builder;

        if (isToggleKeyPressed) {
            LINES = (LINES == ModRenderType.LINES_BASIC) ? ModRenderType.FULL_BLOCK_OVERLAY : ModRenderType.LINES_BASIC;
            builder = buffer.getBuffer(LINES);

        } else builder = buffer.getBuffer(FULL_FACE);


        // Use raycast result to get the block position
        BlockHitResult rayTraceResult = (BlockHitResult) mc.hitResult;
        if (rayTraceResult != null && rayTraceResult.getType() == HitResult.Type.BLOCK) {
            if (isCorrectToolAndUpgrade(customItem)) {
                if (UpgradeTools.containsUpgrade(customItem, Upgrade.AOE)) {
                    int currentAOE = isShiftPressed ? 1 : ToolProperties.getAOE(customItem);
                    BlockPos blockPos = rayTraceResult.getBlockPos();
                    BlockState blockState = mc.level.getBlockState(blockPos);
                    VoxelShape voxelShape = blockState.getShape(mc.level, blockPos);
                    voxelShape = scaleShape(voxelShape, currentAOE);
                    renderShape(matrix, builder, voxelShape, blockPos.getX(), blockPos.getY(), blockPos.getZ(), newColor);
                }
            }
        }

        matrix.popPose();
        RenderSystem.disableDepthTest();

        if (isToggleKeyPressed) {
            buffer.endBatch(LINES);
        } else {
            buffer.endBatch(FULL_FACE);
        }
    }


    private static void renderShape(PoseStack matrix, VertexConsumer builder, VoxelShape shape, double x, double y, double z, Color color) {
        float red = color.getRed() / 255f, green = color.getGreen() / 255f, blue = color.getBlue() / 255f, alpha = 0.3f;

        List<AABB> boxes = shape.toAabbs();
        for (AABB box : boxes) {
            renderBox(matrix, builder, box, x, y, z, red, green, blue, alpha);
        }
    }

    private static void renderBox(PoseStack matrix, VertexConsumer builder, AABB box, double x, double y, double z, float red, float green, float blue, float alpha) {

        renderFaceEast(matrix, builder, box.maxX + x, box.minY + y, box.minZ + z, box.maxX + x, box.maxY + y, box.maxZ + z, red, green, blue, alpha);
        renderFaceWest(matrix, builder, box.minX + x, box.minY + y, box.minZ + z, box.minX + x, box.maxY + y, box.maxZ + z, red, green, blue, alpha);
        renderFaceNorth(matrix, builder, box.minX + x, box.minY + y, box.minZ + z, box.maxX + x, box.maxY + y, box.minZ + z, red, green, blue, alpha);
        renderFaceSouth(matrix, builder, box.minX + x, box.minY + y, box.maxZ + z, box.maxX + x, box.maxY + y, box.maxZ + z, red, green, blue, alpha);
        renderFaceUp(matrix, builder, box.minX + x, box.maxY + y, box.minZ + z, box.maxX + x, box.maxY + y, box.maxZ + z, red, green, blue, alpha);
        renderFaceDown(matrix, builder, box.minX + x, box.minY + y, box.minZ + z, box.maxX + x, box.minY + y, box.maxZ + z, red, green, blue, alpha);
    }


    private static void renderFaceEast(PoseStack matrix, VertexConsumer builder, double x1, double y1, double z1, double x2, double y2, double z2, float red, float green, float blue, float alpha) {
        builder.vertex(matrix.last().pose(), (float) x1, (float) y2, (float) z1).color(red, green, blue, alpha).endVertex();
        builder.vertex(matrix.last().pose(), (float) x2, (float) y2, (float) z2).color(red, green, blue, alpha).endVertex();
        builder.vertex(matrix.last().pose(), (float) x2, (float) y1, (float) z2).color(red, green, blue, alpha).endVertex();
        builder.vertex(matrix.last().pose(), (float) x1, (float) y1, (float) z1).color(red, green, blue, alpha).endVertex();
    }

    private static void renderFaceWest(PoseStack matrix, VertexConsumer builder, double x1, double y1, double z1, double x2, double y2, double z2, float red, float green, float blue, float alpha) {
        builder.vertex(matrix.last().pose(), (float) x2, (float) y2, (float) z2).color(red, green, blue, alpha).endVertex();
        builder.vertex(matrix.last().pose(), (float) x1, (float) y2, (float) z1).color(red, green, blue, alpha).endVertex();
        builder.vertex(matrix.last().pose(), (float) x1, (float) y1, (float) z1).color(red, green, blue, alpha).endVertex();
        builder.vertex(matrix.last().pose(), (float) x2, (float) y1, (float) z2).color(red, green, blue, alpha).endVertex();
    }

    private static void renderFaceNorth(PoseStack matrix, VertexConsumer builder, double x1, double y1, double z1, double x2, double y2, double z2, float red, float green, float blue, float alpha) {
        builder.vertex(matrix.last().pose(), (float) x1, (float) y1, (float) z1).color(red, green, blue, alpha).endVertex();
        builder.vertex(matrix.last().pose(), (float) x1, (float) y2, (float) z1).color(red, green, blue, alpha).endVertex();
        builder.vertex(matrix.last().pose(), (float) x2, (float) y2, (float) z2).color(red, green, blue, alpha).endVertex();
        builder.vertex(matrix.last().pose(), (float) x2, (float) y1, (float) z2).color(red, green, blue, alpha).endVertex();
    }

    private static void renderFaceSouth(PoseStack matrix, VertexConsumer builder, double x1, double y1, double z1, double x2, double y2, double z2, float red, float green, float blue, float alpha) {
        builder.vertex(matrix.last().pose(), (float) x2, (float) y1, (float) z2).color(red, green, blue, alpha).endVertex();
        builder.vertex(matrix.last().pose(), (float) x2, (float) y2, (float) z2).color(red, green, blue, alpha).endVertex();
        builder.vertex(matrix.last().pose(), (float) x1, (float) y2, (float) z1).color(red, green, blue, alpha).endVertex();
        builder.vertex(matrix.last().pose(), (float) x1, (float) y1, (float) z1).color(red, green, blue, alpha).endVertex();
    }

    private static void renderFaceUp(PoseStack matrix, VertexConsumer builder, double x1, double y1, double z1, double x2, double y2, double z2, float red, float green, float blue, float alpha) {
        builder.vertex(matrix.last().pose(), (float) x1, (float) y2, (float) z1).color(red, green, blue, alpha).endVertex();
        builder.vertex(matrix.last().pose(), (float) x1, (float) y2, (float) z2).color(red, green, blue, alpha).endVertex();
        builder.vertex(matrix.last().pose(), (float) x2, (float) y2, (float) z2).color(red, green, blue, alpha).endVertex();
        builder.vertex(matrix.last().pose(), (float) x2, (float) y2, (float) z1).color(red, green, blue, alpha).endVertex();
    }

    private static void renderFaceDown(PoseStack matrix, VertexConsumer builder, double x1, double y1, double z1, double x2, double y2, double z2, float red, float green, float blue, float alpha) {
        builder.vertex(matrix.last().pose(), (float) x1, (float) y1, (float) z1).color(red, green, blue, alpha).endVertex();
        builder.vertex(matrix.last().pose(), (float) x2, (float) y1, (float) z1).color(red, green, blue, alpha).endVertex();
        builder.vertex(matrix.last().pose(), (float) x2, (float) y1, (float) z2).color(red, green, blue, alpha).endVertex();
        builder.vertex(matrix.last().pose(), (float) x1, (float) y1, (float) z2).color(red, green, blue, alpha).endVertex();
    }
}






