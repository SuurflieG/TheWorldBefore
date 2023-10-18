package com.suurflieg.theworldbefore.gui.screen;

import com.suurflieg.theworldbefore.TheWorldBefore;
import com.suurflieg.theworldbefore.gui.widgets.ToggleButton;
import com.suurflieg.theworldbefore.item.tool.*;
import com.suurflieg.theworldbefore.item.upgradecards.Upgrade;
import com.suurflieg.theworldbefore.item.upgradecards.UpgradeHelper;
import com.suurflieg.theworldbefore.item.upgradecards.UpgradeTools;
import com.suurflieg.theworldbefore.network.PacketHandler;
import com.suurflieg.theworldbefore.network.packets.*;
import com.mojang.blaze3d.platform.InputConstants;
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

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SuppressWarnings("InstantiationOfUtilityClass")
public class CustomToolScreen extends Screen {
    private static final ResourceLocation SIZE_BUTTON = new ResourceLocation("textures/gui/recipe_button.png");
    private final ItemStack customToolItem;
    
    private int currentSize = 1;
    private int currentDepth = 1;
    public List<Upgrade> toggleableList = new ArrayList<>();
    public static HashMap<Upgrade, ToggleButton> toggleButton = new HashMap<>();
    public static ToggleButton Btn;

    public CustomToolScreen(ItemStack customToolItem) {
        super(Component.literal("title"));

        this.customToolItem = customToolItem;
    }

    @Override
    public void init() {
        List<AbstractWidget> leftWidgets = new ArrayList<>();

        int baseX = (width / 2 )  - (imageWidth / 2);/* find center of screen */ /*move image over by half its width */
        int baseY = (height / 2 ) - (imageHeight / 2);

        // Filters out the non-toggleable options
        toggleableList.clear();
        toggleableList = UpgradeTools.getUpgrades(this.customToolItem).stream().filter(Upgrade::isToggleable).collect(Collectors.toList());

        // Bottom Row
        // Remove 6 from x to center it as the padding on the right pushes off center
        int index = 0, x = baseX + 13, y = baseY + 98;
        for (Upgrade upgrade : toggleableList) {
            Btn = new ToggleButton(x + (index * 18), y, UpgradeTools.getName(upgrade), new ResourceLocation(TheWorldBefore.MOD_ID, "textures/item/upgrade_" + upgrade.getName() + ".png"), send -> this.toggleUpgrade(upgrade, send));
            addRenderableWidget(Btn);
            toggleButton.put(upgrade, Btn);

            // Spaces the upgrades
            index ++;
            if( index % 9 == 0 ) {
                index = 0;
                y += 20;
            }
        }

        // Top Row
        currentSize = ToolProperties.getMiningSize(customToolItem);
        currentDepth = ToolProperties.getMiningDepth(customToolItem);

        Button sizeButton;
        Button depthButton;

        leftWidgets.add(sizeButton = ImageButton.builder(Component.translatable("theworldbefore.tooltip.screen.size", currentSize), (button) -> {
            switch (currentSize) {
                case 1 -> currentSize = 3;
                case 3 -> currentSize = 5;
                case 5 -> currentSize = 7;
                default -> currentSize = 1;
            }
            button.setMessage(getTrans("tooltip.screen.size", currentSize));
            PacketHandler.sendToServer(new PacketChangeMiningSize());
        }).pos(baseX + 12, baseY + 20).size(60, 20).build());

        leftWidgets.add(depthButton = ImageButton.builder(Component.translatable("theworldbefore.tooltip.screen.depth", currentDepth), (button) -> {
            switch (currentDepth) {
                case 1 -> currentDepth = 3;
                case 3 -> currentDepth = 5;
                case 5 -> currentDepth = 7;
                default -> currentDepth = 1;
            }
            button.setMessage(getTrans("tooltip.screen.depth", currentDepth));
            PacketHandler.sendToServer(new PacketChangeMiningDepth());
        }).pos(baseX + 12, baseY + 20).size(60, 20).build());

        // Button logic
        if(!UpgradeTools.containsActiveUpgrade(customToolItem, Upgrade.EXPANDER))
            sizeButton.active = false;
        if(!UpgradeTools.containsActiveUpgrade(customToolItem, Upgrade.DEPTH))
            depthButton.active = false;

        // Lay the buttons out
        // Ordered by where you add them.
        for(int i = 0; i < leftWidgets.size(); i ++) {
            leftWidgets.get(i).setY((baseY + 20) + (i * 25));
            addRenderableWidget(leftWidgets.get(i));
        }
    }

    public boolean toggleUpgrade(Upgrade upgrade, boolean update) {
        // When the button is clicked we toggle
        if(update){
            updateButtons(upgrade, customToolItem);
            PacketHandler.sendToServer(new PacketUpdateUpgrade(upgrade.getName()));
        }
        // When we're just init the gui, we check if it's on or off.
        return upgrade.isEnabled();
    }

    public static void updateButtons(Upgrade upgrade, ItemStack tool) {
        for(Map.Entry<Upgrade, ToggleButton> btn : toggleButton.entrySet()) {
            Upgrade btnUpgrade = btn.getKey();

            if((btnUpgrade.lazyIs(Upgrade.FORTUNE_1) && btn.getValue().isEnabled() && upgrade.lazyIs(Upgrade.SILK)) || ((btnUpgrade.lazyIs(Upgrade.SILK)) && btn.getValue().isEnabled() && upgrade.lazyIs(Upgrade.FORTUNE_1))) {
                toggleButton.get(btn.getKey()).setEnabled(false);
            }
            toggleUpgradeEnchants(tool, btn, btnUpgrade);
        }
    }

    private static void toggleUpgradeEnchants(ItemStack tool, Map.Entry<Upgrade, ToggleButton> btn, Upgrade btnUpgrade) {
        if((btnUpgrade.lazyIs(Upgrade.BANE_OF_ARTHROPODS_1) && btn.getValue().isEnabled())){
            UpgradeHelper.applyBaneOfArthropods(tool);
        }
        if((btnUpgrade.lazyIs(Upgrade.BANE_OF_ARTHROPODS_1) && !btn.getValue().isEnabled())){
            UpgradeHelper.removeBaneOfArthropods(tool);
        }
        if((btnUpgrade.lazyIs(Upgrade.EFFICIENCY_1) && btn.getValue().isEnabled())){
            UpgradeHelper.applyEfficiency(tool);
        }
        if((btnUpgrade.lazyIs(Upgrade.EFFICIENCY_3) && !btn.getValue().isEnabled())){
            UpgradeHelper.removeEfficiency(tool);
        }
        if((btnUpgrade.lazyIs(Upgrade.FORTUNE_1) && btn.getValue().isEnabled())){
            UpgradeHelper.applyFortune(tool);
        }
        if((btnUpgrade.lazyIs(Upgrade.FORTUNE_1) && !btn.getValue().isEnabled())){
            UpgradeHelper.removeFortune(tool);
        }
        if((btnUpgrade.lazyIs(Upgrade.MENDING) && btn.getValue().isEnabled())){
            UpgradeHelper.applyMending(tool);
        }
        if((btnUpgrade.lazyIs(Upgrade.MENDING) && !btn.getValue().isEnabled())){
            UpgradeHelper.removeMending(tool);
        }
        if((btnUpgrade.lazyIs(Upgrade.SHARPNESS_1) && btn.getValue().isEnabled())){
            UpgradeHelper.applySharpness(tool);
        }
        if((btnUpgrade.lazyIs(Upgrade.SHARPNESS_1) && !btn.getValue().isEnabled())){
            UpgradeHelper.removeSharpness(tool);
        }
        if((btnUpgrade.lazyIs(Upgrade.SMITE_1) && btn.getValue().isEnabled())){
            UpgradeHelper.applySmite(tool);
        }
        if((btnUpgrade.lazyIs(Upgrade.SMITE_1) && !btn.getValue().isEnabled())){
            UpgradeHelper.removeSmite(tool);
        }
        if((btnUpgrade.lazyIs(Upgrade.SILK) && btn.getValue().isEnabled())){
            UpgradeHelper.applySilkTouch(tool);
        }
        if((btnUpgrade.lazyIs(Upgrade.SILK) && !btn.getValue().isEnabled())){
            UpgradeHelper.removeSilkTouch(tool);
        }
        if((btnUpgrade.lazyIs(Upgrade.UNBREAKING_1) && btn.getValue().isEnabled())){
            UpgradeHelper.applyUnbreaking(tool);
        }
        if((btnUpgrade.lazyIs(Upgrade.UNBREAKING_1) && !btn.getValue().isEnabled())){
            UpgradeHelper.removeUnbreaking(tool);
        }
    }

    private static final ResourceLocation TEXTURE = new ResourceLocation(TheWorldBefore.MOD_ID, "textures/gui/tool_pickaxe_screen_new.png");

    int imageHeight = 121;
    int imageWidth = 186;

    @Override
    public void renderBackground(GuiGraphics pGuiGraphics) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);

        int x = (width / 2 )  - (imageWidth / 2);/* find center of screen */ /*move image over by half its width */
        int y = (height / 2 ) - (imageHeight / 2);

        pGuiGraphics.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight);
        if(isPickaxe(customToolItem)){
            pGuiGraphics.drawString(font, getTrans("tooltip.screen.pickaxe_settings"), x + 12, y + 10, Color.ORANGE.getRGB());
            pGuiGraphics.drawString(font, getTrans("tooltip.screen.toggle_upgrades"), x + 12, y + 75, Color.ORANGE.getRGB());
        }

        if(isShovel(customToolItem)){
            pGuiGraphics.drawString(font, getTrans("tooltip.screen.shovel_settings"), x + 12, y + 10, Color.ORANGE.getRGB());
            pGuiGraphics.drawString(font, getTrans("tooltip.screen.toggle_upgrades"), x + 12, y + 75, Color.ORANGE.getRGB());
        }

        if(isAxe(customToolItem)){
            pGuiGraphics.drawString(font, getTrans("tooltip.screen.axe_settings"), x + 12, y + 10, Color.ORANGE.getRGB());
            pGuiGraphics.drawString(font, getTrans("tooltip.screen.toggle_upgrades"), x + 12, y + 75, Color.ORANGE.getRGB());
        }

        if(isHoe(customToolItem)){
            pGuiGraphics.drawString(font, getTrans("tooltip.screen.hoe_settings"), x + 12, y + 10, Color.ORANGE.getRGB());
            pGuiGraphics.drawString(font, getTrans("tooltip.screen.toggle_upgrades"), x + 12, y + 75, Color.ORANGE.getRGB());
        }

        if(toggleableList.size() == 0)
            pGuiGraphics.drawString(font, getTrans("tooltip.screen.no_upgrades"), x + 12, y + 85, Color.RED.brighter().getRGB());

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

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {

        this.renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, partialTicks);

        this.children().forEach(e -> {
            if (e instanceof ToggleButton){
                ToggleButton btn = ((ToggleButton) e);
                if (btn.isMouseOver(mouseX, mouseY))
                    guiGraphics.renderTooltip(font, btn.getOurTooltip(), DefaultTooltipPositioner.INSTANCE,  mouseX, mouseY);
            }
        });
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    @Override
    public boolean keyPressed(int p_keyPressed_1_, int p_keyPressed_2_, int p_keyPressed_3_) {
        InputConstants.Key mouseKey = InputConstants.getKey(p_keyPressed_1_, p_keyPressed_2_);
        if (p_keyPressed_1_ == 256 || minecraft.options.keyInventory.isActiveAndMatches(mouseKey)) {
            onClose();

            return true;
        }

        return super.keyPressed(p_keyPressed_1_, p_keyPressed_2_, p_keyPressed_3_);
    }

    private static MutableComponent getTrans(String key, Object... args) {
        return Component.translatable(TheWorldBefore.MOD_ID + "." + key, args);
    }
}