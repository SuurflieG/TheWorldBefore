package com.suurflieg.theworldbefore.client.render;

import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.VertexFormat;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.RenderType;

import java.util.OptionalDouble;

public class ModRenderType extends RenderType {


    public ModRenderType(String pName, VertexFormat pFormat, VertexFormat.Mode pMode, int pBufferSize, boolean pAffectsCrumbling, boolean pSortOnUpload, Runnable pSetupState, Runnable pClearState) {
        super(pName, pFormat, pMode, pBufferSize, pAffectsCrumbling, pSortOnUpload, pSetupState, pClearState);
    }


    public static final RenderType FULL_BLOCK_OVERLAY = create("BlockLineOverlay",
            DefaultVertexFormat.POSITION_COLOR, VertexFormat.Mode.QUADS, 256,false, false,
            RenderType.CompositeState.builder()
                    .setShaderState(ShaderStateShard.POSITION_COLOR_LIGHTMAP_SHADER)
                    .setLayeringState(VIEW_OFFSET_Z_LAYERING)
                    .setTransparencyState(TRANSLUCENT_TRANSPARENCY)
                    .setTextureState(NO_TEXTURE)
                    .setDepthTestState(LEQUAL_DEPTH_TEST)
                    .setCullState(CULL)
                    .setLightmapState(NO_LIGHTMAP)
                    .setWriteMaskState(COLOR_DEPTH_WRITE)
                    .createCompositeState(false));

    public static final RenderType LINES_BASIC = RenderType.create("twb_lines", DefaultVertexFormat.POSITION_COLOR, VertexFormat.Mode.DEBUG_LINES, 256, false, false, RenderType.CompositeState.builder()
            .setShaderState(new ShaderStateShard(GameRenderer::getPositionColorShader))
            .setLineState(new LineStateShard(OptionalDouble.empty()))
            .setLayeringState(NO_LAYERING)
            .setTransparencyState(TRANSLUCENT_TRANSPARENCY)
            .setWriteMaskState(COLOR_WRITE)
            .setCullState(CULL)
            .createCompositeState(false));
}
