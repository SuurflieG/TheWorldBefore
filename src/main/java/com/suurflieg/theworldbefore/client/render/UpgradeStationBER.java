/*
package com.suurflieg.theworldbefore.client.render;

import com.mojang.math.Axis;
import com.suurflieg.theworldbefore.custom.block.entity.UpgradeStationBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.CapabilityItemHandler;

public class UpgradeStationBER implements BlockEntityRenderer<UpgradeStationBlockEntity> {

    public UpgradeStationBER(BlockEntityRendererProvider.Context context) {

    }

    @Override
    public void render(UpgradeStationBlockEntity tile, float partialTicks, PoseStack matrix, MultiBufferSource buffer, int combinedLights, int combinedOverlay) {
        ItemStack stack = tile.getCapability(ForgeCapabilities.ITEM_HANDLER).map(e -> e.getStackInSlot(0)).orElse(ItemStack.EMPTY);
        if (stack.isEmpty()) {
            return;
        }

        Direction facing = tile.getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING);
        matrix.pushPose();
        matrix.translate(0, .78f, 0);

        if (facing == Direction.SOUTH) {
            matrix.translate(.50f, 0, .68f);
            matrix.mulPose(Axis.YP.rotationDegrees(110));
        } else if (facing == Direction.EAST) {
            matrix.translate(.68f, 0, .50f);
            matrix.mulPose(Axis.YP.rotationDegrees(200));
        } else if (facing == Direction.NORTH) {
            matrix.translate(.50f, 0, .32f);
            matrix.mulPose(Axis.YP.rotationDegrees(290));
        } else if (facing == Direction.WEST) {
            matrix.translate(.32f, 0, .50f);
            matrix.mulPose(Axis.YP.rotationDegrees(20));
        }
        matrix.mulPose(Axis.ZN.rotationDegrees(90));

        matrix.scale(1f, 1f, 1f);

        BakedModel model = Minecraft.getInstance().getItemRenderer().getModel(stack, Minecraft.getInstance().level, null, 0);
        Minecraft.getInstance().getItemRenderer().render(stack, ItemTransforms.TransformType.FIRST_PERSON_LEFT_HAND, false, matrix,buffer, combinedLights, combinedOverlay, model);
        matrix.popPose();
    }
}
*/
