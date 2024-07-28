package com.suurflieg.theworldbefore.util;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModKeyBindings {

    public static final String KEY_CATEGORY_THEWORLDBEFORE = "key.category.theworldbefore.theworldbefore";
    public static final String KEY_OPEN_GUI = "key.theworldbefore.open_gui";
    public static final String KEY_OPEN_B_GUI = "key.theworldbefore.open_b_gui";
    public static final String KEY_TOGGLE_AOE_RENDERTYPE = "key.theworldbefore.toggle_render_type";

    public static final KeyMapping GUI_KEY_G = new KeyMapping(KEY_OPEN_GUI, KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_G, KEY_CATEGORY_THEWORLDBEFORE);
    public static final KeyMapping GUI_KEY_B = new KeyMapping(KEY_OPEN_B_GUI, KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_B, KEY_CATEGORY_THEWORLDBEFORE);
    public static final KeyMapping MINING_AOE_RENDER_TOGGLE = new KeyMapping(KEY_TOGGLE_AOE_RENDERTYPE, KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_APOSTROPHE, KEY_CATEGORY_THEWORLDBEFORE);
    public static final KeyMapping GUI_KEY_SHIFT_RIGHT_CLICK = new KeyMapping("theworldbefore.text.open_gui", InputConstants.UNKNOWN.getValue(), KEY_CATEGORY_THEWORLDBEFORE);

    @SubscribeEvent
    public static void registerKeys(RegisterKeyMappingsEvent event) {
        event.register(GUI_KEY_G);
        event.register(GUI_KEY_B);
        event.register(MINING_AOE_RENDER_TOGGLE);
    }
}
