package com.suurflieg.theworldbefore.event;


import com.suurflieg.theworldbefore.TheWorldBefore;
import com.suurflieg.theworldbefore.client.render.CustomOutlineRenderer;
import com.suurflieg.theworldbefore.gui.screen.CustomEquipmentScreen;
import com.suurflieg.theworldbefore.gui.screen.TestScreen;
import com.suurflieg.theworldbefore.item.tool.CustomHoeItem;
import com.suurflieg.theworldbefore.item.tool.CustomPickaxeItem;
import com.suurflieg.theworldbefore.item.tool.CustomShovelItem;
import com.suurflieg.theworldbefore.util.ModKeyBindings;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderHighlightEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TheWorldBefore.MOD_ID, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void handleEventInput(TickEvent.ClientTickEvent event) {
        Minecraft mc = Minecraft.getInstance();

        // Check if the GUI key is pressed
        if (ModKeyBindings.GUI_KEY_G.consumeClick() && mc.screen == null) {
            openCustomEquipmentScreen();
        }

        if (ModKeyBindings.GUI_KEY_B.consumeClick() && mc.screen == null) {
            openBScreen();
        }
    }

    private static void openCustomEquipmentScreen() {
        Minecraft.getInstance().setScreen(new CustomEquipmentScreen());
    }

    private static void openBScreen() {
        Minecraft.getInstance().setScreen(new TestScreen());
    }

    @SubscribeEvent
    public static void onBlockHighlight(RenderHighlightEvent.Block event) {
            Player player = Minecraft.getInstance().player;
            ItemStack heldItem = player.getMainHandItem();
            if(heldItem == CustomPickaxeItem.findItemStackInInventory(player)
            || heldItem == CustomShovelItem.findItemStackInInventory(player)
            || heldItem == CustomHoeItem.findItemStackInInventory(player)){
                event.setCanceled(true);
                CustomOutlineRenderer.render(event, heldItem);
            }
            else event.setCanceled(false);

    }
}
