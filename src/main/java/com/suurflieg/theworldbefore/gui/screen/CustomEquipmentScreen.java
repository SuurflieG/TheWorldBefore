package com.suurflieg.theworldbefore.gui.screen;

import com.suurflieg.theworldbefore.TheWorldBefore;
import com.suurflieg.theworldbefore.gui.widgets.EquipmentSelectButton;
import com.suurflieg.theworldbefore.gui.widgets.ToggleButton;
import com.suurflieg.theworldbefore.item.armor.CustomArmorItem;
import com.suurflieg.theworldbefore.item.tool.*;
import com.suurflieg.theworldbefore.item.upgradecards.Upgrade;
import com.suurflieg.theworldbefore.item.upgradecards.UpgradeHelper;
import com.suurflieg.theworldbefore.item.upgradecards.UpgradeTools;
import com.suurflieg.theworldbefore.network.PacketHandler;
import com.suurflieg.theworldbefore.network.packets.PacketChangeMiningSize;
import com.suurflieg.theworldbefore.network.packets.PacketUpdateUpgrade;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.tooltip.DefaultTooltipPositioner;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomEquipmentScreen extends Screen {

    private final ItemStack itemStack;
    private static final ResourceLocation TEXTURE = new ResourceLocation(TheWorldBefore.MOD_ID, "textures/gui/equipment_gui.png");

    public List<EquipmentSelectButton> equipmentSelectButton = new ArrayList<>();
    public List<Upgrade> toggleableList = new ArrayList<>();

    public static HashMap<Upgrade, ToggleButton> toggleButton = new HashMap<>();
    public static HashMap<ItemStack, EquipmentSelectButton> equipButton = new HashMap<>();

    public static ToggleButton Btn;
    public static EquipmentSelectButton equipBtn;

    public static CustomToolScreen customToolScreen;

    Button pickaxe;
    EquipmentSelectButton shovel;
    EquipmentSelectButton axe;
    EquipmentSelectButton hoe;
    EquipmentSelectButton helmet;
    EquipmentSelectButton chestplate;
    EquipmentSelectButton leggings;
    EquipmentSelectButton boots;

    int imageHeight = 157;
    int imageWidth = 255;

    public CustomEquipmentScreen(Component pTitle, ItemStack itemStack) {
        super(pTitle);
        this.itemStack = itemStack;
    }



    @Override
    public void init() {

        List<AbstractWidget> rightWidgets = new ArrayList<>();

        int baseX = (width / 2 )  - (imageWidth / 2);/* find center of screen */ /*move image over by half its width */
        int baseY = (height / 2 ) - (imageHeight / 2);

        rightWidgets.add(pickaxe = ImageButton.builder(Component.translatable("theworldbefore.tooltip.screen.size", pickaxe), (button) -> {
            button.setMessage(getTrans("tooltip.screen.size", pickaxe));
            PacketHandler.sendToServer(new PacketChangeMiningSize());
        }).pos(baseX + 12, baseY + 20).size(60, 20).build());

        for (EquipmentSelectButton equipmentSelectButton : equipmentSelectButton) {
            equipmentSelectButton = new EquipmentSelectButton(baseX + 203,baseY + 12, this.getName(itemStack), (new ResourceLocation(TheWorldBefore.MOD_ID,
                    "textures/gui/select_button.png")), send -> this.selectEquipment(itemStack, send));
            addRenderableWidget(equipmentSelectButton);
            equipButton.put(itemStack, equipBtn);
        }

/*        rightWidgets.add(pickaxe = new EquipmentSelectButton(baseX + 203,baseY + 27, this.getName(CustomPickaxeItem.getPickaxe(getMinecraft().player)),
                (new ResourceLocation(TheWorldBefore.MOD_ID, "textures/gui/select_button.png")), send -> this.selectEquipment(itemStack, send)));

        rightWidgets.add(shovel = new EquipmentSelectButton(baseX + 203,baseY + 27, this.getName(itemStack),
                (new ResourceLocation(TheWorldBefore.MOD_ID, "textures/gui/select_button.png")), send -> this.selectEquipment(itemStack, send)));

        rightWidgets.add(axe = new EquipmentSelectButton(baseX + 203,baseY + 42, this.getName(itemStack),
                (new ResourceLocation(TheWorldBefore.MOD_ID, "textures/gui/select_button.png")), send -> this.selectEquipment(itemStack, send)));

        rightWidgets.add(hoe = new EquipmentSelectButton(baseX + 203,baseY + 57, this.getName(itemStack),
                (new ResourceLocation(TheWorldBefore.MOD_ID, "textures/gui/select_button.png")), send -> this.selectEquipment(itemStack, send)));

        rightWidgets.add(helmet = new EquipmentSelectButton(baseX + 203,baseY + 72, this.getName(itemStack),
                (new ResourceLocation(TheWorldBefore.MOD_ID, "textures/gui/select_button.png")), send -> this.selectEquipment(itemStack, send)));

        rightWidgets.add(chestplate = new EquipmentSelectButton(baseX + 203,baseY + 87, this.getName(itemStack),
                (new ResourceLocation(TheWorldBefore.MOD_ID, "textures/gui/select_button.png")), send -> this.selectEquipment(itemStack, send)));

        rightWidgets.add(leggings = new EquipmentSelectButton(baseX + 203,baseY + 102, this.getName(itemStack),
                (new ResourceLocation(TheWorldBefore.MOD_ID, "textures/gui/select_button.png")), send -> this.selectEquipment(itemStack, send)));

        rightWidgets.add(boots = new EquipmentSelectButton(baseX + 203,baseY + 117, this.getName(itemStack),
                (new ResourceLocation(TheWorldBefore.MOD_ID, "textures/gui/select_button.png")), send -> this.selectEquipment(itemStack, send)));*/

        super.init();
    }

    public boolean selectEquipment(ItemStack equipment, boolean select){
        if(select){
            isPickaxe(equipment);
        }
        return select;
    }

    private static boolean isPickaxe(ItemStack tool) {
        return tool.getItem() instanceof CustomPickaxeItem;
    }
    private static boolean isShovel(ItemStack tool) {
        return tool.getItem() instanceof CustomShovelItem;
    }
    private static boolean isAxe(ItemStack tool) {
        return tool.getItem() instanceof CustomAxeItem;
    }
    private static boolean isHoe(ItemStack tool) {
        return tool.getItem() instanceof CustomHoeItem;
    }
    private static boolean isArmor(ItemStack tool) {
        return tool.getItem() instanceof CustomArmorItem;
    }
    private static boolean isSword(ItemStack tool) {
        return tool.getItem() instanceof CustomSwordItem;
    }

    //TODO work on adding the EquipmentSelectButton when equipment is in inventory or when armor is equipped and draw buttons for each

    @Override
    public void renderBackground(GuiGraphics guiGraphics) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);

        int x = (width / 2 )  - (imageWidth / 2);/* find center of screen */ /*move image over by half its width */
        int y = (height / 2 ) - (imageHeight / 2);
        guiGraphics.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight);
    }



    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {

        this.renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, partialTicks);

        this.children().forEach(e -> {
            if (e instanceof EquipmentSelectButton btn){
                if (btn.isMouseOver(mouseX, mouseY))
                    guiGraphics.renderTooltip(font, btn.getOurTooltip(), DefaultTooltipPositioner.INSTANCE,  mouseX, mouseY);
            }
        });
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    public Component getName(ItemStack equipment) {
        return Component.literal("test" + equipment);
    }

    private static MutableComponent getTrans(String key, Object... args) {
        return Component.translatable(TheWorldBefore.MOD_ID + "." + key, args);
    }


}
