package com.suurflieg.theworldbefore.registry;


import com.suurflieg.theworldbefore.TheWorldBefore;
import com.suurflieg.theworldbefore.custom.gui.screen.CustomArmorScreen;
import com.suurflieg.theworldbefore.custom.gui.screen.CustomToolScreen;
import com.suurflieg.theworldbefore.custom.gui.screen.CustomWeaponScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TheWorldBefore.MOD_ID, value = Dist.CLIENT)
public class ModScreens {

    public static void openToolSettingsScreen(ItemStack itemstack) {
            Minecraft.getInstance().setScreen(new CustomToolScreen(itemstack));
    }

    public static void openArmorSettingsScreen(ItemStack itemstack) {
            Minecraft.getInstance().setScreen(new CustomArmorScreen(itemstack));
    }

    public static void openWeaponSettingsScreen(ItemStack itemstack) {
            Minecraft.getInstance().setScreen(new CustomWeaponScreen(itemstack));
    }

}
