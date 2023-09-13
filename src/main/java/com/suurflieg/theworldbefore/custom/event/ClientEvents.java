package com.suurflieg.theworldbefore.custom.event;


import com.suurflieg.theworldbefore.TheWorldBefore;
import com.suurflieg.theworldbefore.custom.gui.screen.CustomEquipmentScreen;
import com.suurflieg.theworldbefore.custom.util.TheWorldBeforeKeyBinding;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.settings.KeyModifier;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TheWorldBefore.MOD_ID, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void handleEventInput(TickEvent.ClientTickEvent event) {

        Minecraft mc = Minecraft.getInstance();
        if (mc.player == null || event.phase == TickEvent.Phase.START)
            return;

        KeyMapping mode = TheWorldBeforeKeyBinding.GUI_KEY_G;
        if (!(mc.screen instanceof CustomEquipmentScreen) && mode.consumeClick() && ((mode.getKeyModifier() == KeyModifier.NONE
                && KeyModifier.getActiveModifier() == KeyModifier.NONE) || mode.getKeyModifier() != KeyModifier.NONE)) {
            mc.setScreen(new CustomEquipmentScreen(Component.empty(), ItemStack.EMPTY));
        }
    }


}
