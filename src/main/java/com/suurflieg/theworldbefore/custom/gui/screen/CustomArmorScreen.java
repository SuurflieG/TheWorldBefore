package com.suurflieg.theworldbefore.custom.gui.screen;

import com.suurflieg.theworldbefore.TheWorldBefore;
import com.suurflieg.theworldbefore.custom.gui.widgets.ToggleButton;
import com.suurflieg.theworldbefore.custom.item.tool.CustomPickaxeItem;
import com.suurflieg.theworldbefore.custom.item.tool.CustomShovelItem;
import com.suurflieg.theworldbefore.custom.item.tool.ToolProperties;
import com.suurflieg.theworldbefore.custom.item.upgradecards.Upgrade;
import com.suurflieg.theworldbefore.custom.item.upgradecards.UpgradeHelper;
import com.suurflieg.theworldbefore.custom.item.upgradecards.UpgradeTools;
import com.suurflieg.theworldbefore.network.PacketHandler;
import com.suurflieg.theworldbefore.network.packets.PacketChangeMiningSize;
import com.suurflieg.theworldbefore.network.packets.PacketUpdateUpgrade;
import com.mojang.blaze3d.platform.InputConstants;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.Button;
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
public class CustomArmorScreen extends Screen {
    private final ItemStack customToolItem;

    private int currentSize = 1;
    public List<Upgrade> toggleableList = new ArrayList<>();
    public static HashMap<Upgrade, ToggleButton> toggleButton = new HashMap<>();
    public static ToggleButton Btn;

    public CustomArmorScreen(ItemStack customToolItem) {
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
            Btn = new ToggleButton(x + (index * 18), y, UpgradeTools.getName(upgrade),
                    new ResourceLocation(TheWorldBefore.MOD_ID, "textures/item/upgrade_" + upgrade.getName() + ".png"), send -> this.toggleUpgrade(upgrade, send));
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

        Button sizeButton;

        leftWidgets.add(sizeButton = Button.builder(Component.translatable("theworldbefore.tooltip.screen.size", currentSize), (button) -> {
            currentSize = currentSize == 1 ? 3 : 1;
            button.setMessage(getTrans("tooltip.screen.size", currentSize));
            PacketHandler.sendToServer(new PacketChangeMiningSize());
        }).pos(baseX + 12, baseY + 20).size(60, 20).build());

        // Button logic
        if(!UpgradeTools.containsActiveUpgrade(customToolItem, Upgrade.EXPANDER))
            sizeButton.active = false;

        // Lay the buttons out, too lazy to figure out the math every damn time.
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

            if((btnUpgrade.lazyIs(Upgrade.BLAST_PROTECTION_1) && btn.getValue().isEnabled() && upgrade.lazyIs(Upgrade.FIRE_PROTECTION_1))
                || ((btnUpgrade.lazyIs(Upgrade.BLAST_PROTECTION_1) && btn.getValue().isEnabled() && upgrade.lazyIs(Upgrade.PROJECTILE_PROTECTION_1)))
                || ((btnUpgrade.lazyIs(Upgrade.BLAST_PROTECTION_1) && btn.getValue().isEnabled() && upgrade.lazyIs(Upgrade.PROTECTION_1)))
                || ((btnUpgrade.lazyIs(Upgrade.FIRE_PROTECTION_1) && btn.getValue().isEnabled() && upgrade.lazyIs(Upgrade.BLAST_PROTECTION_1)))
                || ((btnUpgrade.lazyIs(Upgrade.FIRE_PROTECTION_1) && btn.getValue().isEnabled() && upgrade.lazyIs(Upgrade.PROJECTILE_PROTECTION_1)))
                || ((btnUpgrade.lazyIs(Upgrade.FIRE_PROTECTION_1) && btn.getValue().isEnabled() && upgrade.lazyIs(Upgrade.PROTECTION_1)))
                || ((btnUpgrade.lazyIs(Upgrade.PROJECTILE_PROTECTION_1) && btn.getValue().isEnabled() && upgrade.lazyIs(Upgrade.BLAST_PROTECTION_1)))
                || ((btnUpgrade.lazyIs(Upgrade.PROJECTILE_PROTECTION_1) && btn.getValue().isEnabled() && upgrade.lazyIs(Upgrade.FIRE_PROTECTION_1)))
                || ((btnUpgrade.lazyIs(Upgrade.PROJECTILE_PROTECTION_1) && btn.getValue().isEnabled() && upgrade.lazyIs(Upgrade.PROTECTION_1)))
                || ((btnUpgrade.lazyIs(Upgrade.PROTECTION_1) && btn.getValue().isEnabled() && upgrade.lazyIs(Upgrade.BLAST_PROTECTION_1)))
                || ((btnUpgrade.lazyIs(Upgrade.PROTECTION_1) && btn.getValue().isEnabled() && upgrade.lazyIs(Upgrade.FIRE_PROTECTION_1)))
                || ((btnUpgrade.lazyIs(Upgrade.PROTECTION_1) && btn.getValue().isEnabled() && upgrade.lazyIs(Upgrade.PROJECTILE_PROTECTION_1)))) {
                toggleButton.get(btn.getKey()).setEnabled(false);
            }

            toggleUpgradeEnchants(tool, btn, btnUpgrade);
        }
    }

    private static void toggleUpgradeEnchants(ItemStack tool, Map.Entry<Upgrade, ToggleButton> btn, Upgrade btnUpgrade) {
        if((btnUpgrade.lazyIs(Upgrade.AQUA_AFFINITY) && btn.getValue().isEnabled())){
            UpgradeHelper.applyAquaAffinity(tool);
        }
        if((btnUpgrade.lazyIs(Upgrade.AQUA_AFFINITY) && !btn.getValue().isEnabled())){
            UpgradeHelper.removeAquaAffinity(tool);
        }
        if((btnUpgrade.lazyIs(Upgrade.BLAST_PROTECTION_1) && btn.getValue().isEnabled())){
            UpgradeHelper.applyBlastProtection(tool);
        }
        if((btnUpgrade.lazyIs(Upgrade.BLAST_PROTECTION_1) && !btn.getValue().isEnabled())){
            UpgradeHelper.removeBlastProtection(tool);
        }
        if((btnUpgrade.lazyIs(Upgrade.FIRE_PROTECTION_1) && btn.getValue().isEnabled())){
            UpgradeHelper.applyFireProtection(tool);
        }
        if((btnUpgrade.lazyIs(Upgrade.FIRE_PROTECTION_1) && !btn.getValue().isEnabled())){
            UpgradeHelper.removeFireProtection(tool);
        }
        if((btnUpgrade.lazyIs(Upgrade.MENDING) && btn.getValue().isEnabled())){
            UpgradeHelper.applyMending(tool);
        }
        if((btnUpgrade.lazyIs(Upgrade.MENDING) && !btn.getValue().isEnabled())){
            UpgradeHelper.removeMending(tool);
        }
        if((btnUpgrade.lazyIs(Upgrade.PROJECTILE_PROTECTION_1) && btn.getValue().isEnabled())){
            UpgradeHelper.applyProjectileProtection(tool);
        }
        if((btnUpgrade.lazyIs(Upgrade.PROJECTILE_PROTECTION_1) && !btn.getValue().isEnabled())){
            UpgradeHelper.removeProjectileProtection(tool);
        }
        if((btnUpgrade.lazyIs(Upgrade.PROTECTION_1) && btn.getValue().isEnabled())){
            UpgradeHelper.applyProtection(tool);
        }
        if((btnUpgrade.lazyIs(Upgrade.PROTECTION_1) && !btn.getValue().isEnabled())){
            UpgradeHelper.removeProtection(tool);
        }
        if((btnUpgrade.lazyIs(Upgrade.RESPIRATION_1) && btn.getValue().isEnabled())){
            UpgradeHelper.applyRespiration(tool);
        }
        if((btnUpgrade.lazyIs(Upgrade.RESPIRATION_1) && !btn.getValue().isEnabled())){
            UpgradeHelper.removeRespiration(tool);
        }
        if((btnUpgrade.lazyIs(Upgrade.THORNS_1) && btn.getValue().isEnabled())){
            UpgradeHelper.applyThorns(tool);
        }
        if((btnUpgrade.lazyIs(Upgrade.THORNS_1) && !btn.getValue().isEnabled())){
            UpgradeHelper.removeThorns(tool);
        }
        if((btnUpgrade.lazyIs(Upgrade.UNBREAKING_1) && btn.getValue().isEnabled())){
            UpgradeHelper.applyUnbreaking(tool);
        }
        if((btnUpgrade.lazyIs(Upgrade.UNBREAKING_1) && !btn.getValue().isEnabled())){
            UpgradeHelper.removeUnbreaking(tool);
        }

    }

    private static final ResourceLocation TEXTURE = new ResourceLocation(TheWorldBefore.MOD_ID, "textures/gui/tool_pickaxe_screen.png");

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
            pGuiGraphics.drawString(getMinecraft().font, "tooltip.screen.pickaxe_settings", x + 12, y + 10, Color.ORANGE.getRGB());
            pGuiGraphics.drawString(getMinecraft().font, "tooltip.screen.toggle_upgrades", x + 12, y + 75, Color.ORANGE.getRGB());
        }

        if(isShovel(customToolItem)){
            pGuiGraphics.drawString(getMinecraft().font, "tooltip.screen.shovel_settings", x + 12, y + 10, Color.ORANGE.getRGB());
            pGuiGraphics.drawString(getMinecraft().font, "tooltip.screen.toggle_upgrades", x + 12, y + 75, Color.ORANGE.getRGB());
        }

        if(toggleableList.isEmpty())
            pGuiGraphics.drawString(getMinecraft().font, "tooltip.screen.no_upgrades", x + 12, y + 85, Color.RED.brighter().getRGB());

    }

    private static boolean isPickaxe(ItemStack tool) {
        return tool.getItem() instanceof CustomPickaxeItem;
    }

    private static boolean isShovel(ItemStack tool) {
        return tool.getItem() instanceof CustomShovelItem;
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