package com.suurflieg.theworldbefore.gui.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.suurflieg.theworldbefore.TheWorldBefore;
import com.suurflieg.theworldbefore.gui.widgets.ColorPickerButton;
import com.suurflieg.theworldbefore.gui.widgets.EquipmentSelectButton;
import com.suurflieg.theworldbefore.gui.widgets.ToggleButton;
import com.suurflieg.theworldbefore.item.armor.CustomArmorItem;
import com.suurflieg.theworldbefore.item.tool.*;
import com.suurflieg.theworldbefore.item.upgradecards.Upgrade;
import com.suurflieg.theworldbefore.item.upgradecards.UpgradeHelper;
import com.suurflieg.theworldbefore.item.upgradecards.UpgradeTools;
import com.suurflieg.theworldbefore.network.PacketHandler;
import com.suurflieg.theworldbefore.network.packets.*;
import com.suurflieg.theworldbefore.registry.ModItems;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.tooltip.DefaultTooltipPositioner;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CustomEquipmentScreen extends Screen {

    private static final ResourceLocation BACKGROUND_TEXTURE = new ResourceLocation(TheWorldBefore.MOD_ID, "textures/gui/custom_equipment_gui.png");

    int buttonWidth = 16;
    int buttonHeight = 16;
    int colorButtonWidth = 10;
    int colorButtonHeight = 10;
    int imageHeight = 144;
    int imageWidth = 230;

    private int currentAOE = 1;
    private int currentDepth = 1;

    private String selectedTool;

    private static ItemStack itemStack = ItemStack.EMPTY;

    private List<Upgrade> toggleableList = new ArrayList<>();
    private final List<AbstractWidget> leftButtons = new ArrayList<>();
    private final List<AbstractWidget> rightButtons = new ArrayList<>();

    public static HashMap<Upgrade, ToggleButton> toggleButton = new HashMap<>();
    public static ToggleButton Btn;
    private ColorPickerButton colorPickerButton;

    public CustomEquipmentScreen() {
        super(Component.literal("gui.custom_equipment.title"));
    }


    @Override
    protected void init() {

        Player player = minecraft.player;

        // Find center of the screen and move the image over by half its width
        var baseX = (width - imageWidth) / 2;
        var baseY = (height - imageHeight) / 2;

        rightButtons.clear();

        // Get all custom tools, armor, and weapons items
        List<Item> customItems = ModItems.ITEMS.getEntries().stream()
                .map(RegistryObject::get)
                .filter(item -> item instanceof CustomPickaxeItem ||
                        item instanceof CustomShovelItem ||
                        item instanceof CustomAxeItem ||
                        item instanceof CustomHoeItem ||
                        item instanceof CustomArmorItem ||
                        item instanceof CustomSwordItem)
                .toList();

        int padding = 3; // Set padding between buttons

        for (int buttonNumber = 0; buttonNumber < 9; buttonNumber++) {

            if (buttonNumber < customItems.size()) {
                Item item = customItems.get(buttonNumber);

                ResourceLocation registryName = ForgeRegistries.ITEMS.getKey(item);
                String toolName = registryName != null ? registryName.getPath() : "";

                EquipmentSelectButton equipmentSelectButton = new EquipmentSelectButton(
                        baseX + 35  + buttonNumber * (buttonWidth + padding),
                        baseY + 119,
                        toolName,
                        item,
                        (equipmentButton) -> {
                            this.selectedTool = toolName;
                            Item clickedItem = getItemFromClickedButton(selectedTool);
                            itemStack = findItemStackInInventory(player, clickedItem);

                                if (clickedItem instanceof CustomPickaxeItem && "enderite_pickaxe".equals(selectedTool)) {
                                    drawGuiItems(baseX, baseY);
                                }
                                if (clickedItem instanceof CustomAxeItem && "enderite_axe".equals(selectedTool)) {
                                    drawGuiItems(baseX, baseY);
                                }
                                if (clickedItem instanceof CustomHoeItem && "enderite_hoe".equals(selectedTool)) {
                                    drawGuiItems(baseX, baseY);
                                }
                                if (clickedItem instanceof CustomShovelItem && "enderite_shovel".equals(selectedTool)) {
                                    drawGuiItems(baseX, baseY);
                                }
                                if (clickedItem instanceof CustomArmorItem && "enderite_helmet".equals(selectedTool)) {
                                    drawGuiItems(baseX, baseY);
                                }
                                if (clickedItem instanceof CustomArmorItem && "enderite_chestplate".equals(selectedTool)) {
                                    drawGuiItems(baseX, baseY);
                                }
                                if (clickedItem instanceof CustomArmorItem && "enderite_leggings".equals(selectedTool)) {
                                    drawGuiItems(baseX, baseY);
                                }
                                if (clickedItem instanceof CustomArmorItem && "enderite_boots".equals(selectedTool)) {
                                    drawGuiItems(baseX, baseY);
                                }
                                if (clickedItem instanceof CustomSwordItem && "enderite_sword".equals(selectedTool)) {
                                    drawGuiItems(baseX, baseY);
                                }
                        });

                rightButtons.add(equipmentSelectButton);
            }

        }
        rightButtons.forEach(this::addRenderableWidget);
        super.init();
    }





    private void drawGuiItems(int baseX, int baseY) {

        leftButtons.clear();
        toggleableList.clear();
        repositionElements();

        toggleableList = UpgradeTools.getUpgrades(itemStack).stream().filter(Upgrade::isToggleable).collect(Collectors.toList());


        int index = 0, buttonX = baseX + 35, buttonY = baseY + 80;
        for (Upgrade upgrade : toggleableList) {
            Btn = new ToggleButton(
                    buttonX + (index * 18),
                    buttonY,
                    UpgradeTools.getName(upgrade),
                    new ResourceLocation(TheWorldBefore.MOD_ID, "textures/item/upgrade_" + upgrade.getName() + ".png"),
                    send -> this.toggleUpgrade(upgrade, send)); // button click action
            addRenderableWidget(Btn);
            toggleButton.put(upgrade, Btn);
            index ++;
            if( index % 9 == 0 ) {
                index = 0;
                buttonY += 20;
            }
        }

        if (UpgradeTools.containsUpgrade(itemStack, Upgrade.AOE) || UpgradeTools.containsUpgrade(itemStack, Upgrade.DEPTH)){

            int colorPickerButtonX = baseX + 50; // Adjust X position as needed
            int colorPickerButtonY = baseY + 100; // Adjust Y position as needed
            colorPickerButton = new ColorPickerButton(colorPickerButtonX, colorPickerButtonY, colorButtonWidth, colorButtonHeight, Component.translatable("Color Picker"));
            this.addRenderableWidget(colorPickerButton);
        }


        if (UpgradeTools.containsUpgrade(itemStack, Upgrade.AOE)) {
            currentAOE = ToolProperties.getAOE(itemStack);


            int buttonWidth = 20;
            int buttonHeight = 20;

            for (int aoe : List.of(1, 3, 5, 7)) {
                Button aoeButton;
                leftButtons.add(aoeButton = ImageButton.builder(
                                Component.translatable("theworldbefore.tooltip.screen.aoe", aoe),
                                (button) -> {
                                    currentAOE = aoe;
                                    button.setMessage(getTranslation("tooltip.screen.aoe", currentAOE));
                                    if("enderite_pickaxe".equals(selectedTool)){
                                        PacketHandler.sendToServer(new PacketChangeAOEPickaxe(aoe));
                                    }
                                    if("enderite_shovel".equals(selectedTool)){
                                        PacketHandler.sendToServer(new PacketChangeAOEShovel(aoe));
                                    }
                                    if("enderite_hoe".equals(selectedTool)){
                                        PacketHandler.sendToServer(new PacketChangeAOEHoe(aoe));
                                    }
                                })
                        .pos(baseX, baseY + 25)
                        .size(buttonWidth, buttonHeight)
                        .build());

                if (!UpgradeTools.containsActiveUpgrade(itemStack, Upgrade.AOE))
                    aoeButton.active = false;

                baseX += buttonWidth + 5;
            }
        }

        if (UpgradeTools.containsUpgrade(itemStack, Upgrade.DEPTH)) {
            currentDepth = ToolProperties.getMiningDepth(itemStack);

            int buttonWidth = 20;
            int buttonHeight = 20;

            for (int depth : List.of(1, 3, 5, 7)) {
                Button depthButton;
                leftButtons.add(depthButton = ImageButton.builder(
                                Component.translatable("theworldbefore.tooltip.screen.depth", depth),
                                (button) -> {
                                    currentDepth = depth;
                                    button.setMessage(getTranslation("tooltip.screen.depth", currentDepth));
                                    if("enderite_pickaxe".equals(selectedTool)){
                                        PacketHandler.sendToServer(new PacketChangeMiningDepthPickaxe(depth));
                                    }
                                    if("enderite_shovel".equals(selectedTool)){
                                        PacketHandler.sendToServer(new PacketChangeMiningDepthShovel(depth));
                                    }
                                })
                        .pos(baseX, baseY + 25)
                        .size(buttonWidth, buttonHeight)
                        .build());

                if (!UpgradeTools.containsActiveUpgrade(itemStack, Upgrade.DEPTH))
                    depthButton.active = false;

                baseX += buttonWidth + 5;
            }
        }

        int buttonWidth = 16;
        int buttonGapX = 8;
        int secondRowOffset = 10; // Adjust this value as needed

        int totalButtons = leftButtons.size();
        for (int leftWidgetsIndex = 0; leftWidgetsIndex < totalButtons; leftWidgetsIndex++) {
            AbstractWidget widget = leftButtons.get(leftWidgetsIndex);

            // Calculate position based on the index and total number of buttons
            int columnIndex = leftWidgetsIndex % totalButtons;
            int xOffset = columnIndex * (buttonWidth + buttonGapX);

            // Add a gap after the first 4 buttons
            if (columnIndex >= 4) {
                xOffset += buttonGapX + secondRowOffset; // Add gap after the first 4 buttons and the second row offset
            }

            // Set position for the widget
            widget.setX(baseX - 189 + xOffset);
            widget.setY(baseY + 40);

            // Add the widget to the screen
            addRenderableWidget(widget);
        }
    }



    public static Item getItemFromClickedButton(String selectedTool) {
        return switch (selectedTool) {
            case "enderite_pickaxe" -> ModItems.ENDERITE_PICKAXE.get();
            case "enderite_axe" -> ModItems.ENDERITE_AXE.get();
            case "enderite_hoe" -> ModItems.ENDERITE_HOE.get();
            case "enderite_shovel" -> ModItems.ENDERITE_SHOVEL.get();
            case "enderite_sword" -> ModItems.ENDERITE_SWORD.get();
            case "enderite_helmet" -> ModItems.ENDERITE_HELMET.get();
            case "enderite_chestplate" -> ModItems.ENDERITE_CHESTPLATE.get();
            case "enderite_leggings" -> ModItems.ENDERITE_LEGGINGS.get();
            case "enderite_boots" -> ModItems.ENDERITE_BOOTS.get();
            default -> Items.AIR;
        };
    }

    private ItemStack findItemStackInInventory(Player player, Item item) {
        ItemStack foundCustomTool = ItemStack.EMPTY;

        for (ItemStack stack : player.getInventory().items) {
            if (stack.getItem() == item) {
                foundCustomTool = stack;
                break;
            }
        }

        if (foundCustomTool.isEmpty()) {
            for (ItemStack stack : player.getInventory().offhand) {
                if (stack.getItem() == item) {
                    foundCustomTool = stack;
                    break;
                }
            }
        }

        if (foundCustomTool.isEmpty()) {
            for (ItemStack stack : player.getInventory().armor) {
                if (stack.getItem() == item) {
                    foundCustomTool = stack;
                    break;
                }
            }
        }

        return foundCustomTool;
    }

    public boolean toggleUpgrade(Upgrade upgrade, boolean update) {
        // When the button is clicked we toggle
        if(update){
            updateButtons(upgrade, itemStack);

            if("enderite_pickaxe".equals(selectedTool)){
                PacketHandler.sendToServer(new PacketUpdateUpgradePickaxe(upgrade.getName()));
            }
            if("enderite_shovel".equals(selectedTool)){
                PacketHandler.sendToServer(new PacketUpdateUpgradeShovel(upgrade.getName()));
            }
            if("enderite_axe".equals(selectedTool)){
                PacketHandler.sendToServer(new PacketUpdateUpgradeAxe(upgrade.getName()));
            }
            if("enderite_hoe".equals(selectedTool)){
                PacketHandler.sendToServer(new PacketUpdateUpgradeHoe(upgrade.getName()));
            }
            if("enderite_sword".equals(selectedTool)){
                PacketHandler.sendToServer(new PacketUpdateUpgradeSword(upgrade.getName()));
            }
            if("enderite_helmet".equals(selectedTool) || "enderite_chestplate".equals(selectedTool) || "enderite_leggings".equals(selectedTool) || "enderite_boots".equals(selectedTool)){
                PacketHandler.sendToServer(new PacketUpdateUpgradeArmor(upgrade.getName()));
            }
        }
        // When we're just init the gui, we check if it's on or off.
        return upgrade.isEnabled();
    }

    public static void updateButtons(Upgrade upgrade, ItemStack tool) {
        for(Map.Entry<Upgrade, ToggleButton> btn : toggleButton.entrySet()) {
            Upgrade btnUpgrade = btn.getKey();

            if((btnUpgrade.lazyIs(Upgrade.FORTUNE_1) && btn.getValue().isEnabled() && upgrade.lazyIs(Upgrade.SILK))
                    || ((btnUpgrade.lazyIs(Upgrade.SILK)) && btn.getValue().isEnabled() && upgrade.lazyIs(Upgrade.FORTUNE_1))

                    || (btnUpgrade.lazyIs(Upgrade.BANE_OF_ARTHROPODS_1) && btn.getValue().isEnabled() && upgrade.lazyIs(Upgrade.SHARPNESS_1))
                    || ((btnUpgrade.lazyIs(Upgrade.BANE_OF_ARTHROPODS_1) && btn.getValue().isEnabled() && upgrade.lazyIs(Upgrade.SMITE_1)))
                    || ((btnUpgrade.lazyIs(Upgrade.SHARPNESS_1) && btn.getValue().isEnabled() && upgrade.lazyIs(Upgrade.BANE_OF_ARTHROPODS_1)))
                    || ((btnUpgrade.lazyIs(Upgrade.SHARPNESS_1) && btn.getValue().isEnabled() && upgrade.lazyIs(Upgrade.SMITE_1)))
                    || ((btnUpgrade.lazyIs(Upgrade.SMITE_1) && btn.getValue().isEnabled() && upgrade.lazyIs(Upgrade.BANE_OF_ARTHROPODS_1)))
                    || ((btnUpgrade.lazyIs(Upgrade.SMITE_1) && btn.getValue().isEnabled() && upgrade.lazyIs(Upgrade.SHARPNESS_1)))

                    || (btnUpgrade.lazyIs(Upgrade.BLAST_PROTECTION_1) && btn.getValue().isEnabled() && upgrade.lazyIs(Upgrade.FIRE_PROTECTION_1))
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
        // Armor Upgrades Start
        if((btnUpgrade.lazyIs(Upgrade.AQUA_AFFINITY) && btn.getValue().isEnabled())){
            UpgradeHelper.applyAquaAffinity(itemStack);
        }
        if((btnUpgrade.lazyIs(Upgrade.AQUA_AFFINITY) && !btn.getValue().isEnabled())){
            UpgradeHelper.removeAquaAffinity(itemStack);
        }
        if((btnUpgrade.lazyIs(Upgrade.BLAST_PROTECTION_1) && btn.getValue().isEnabled())){
            UpgradeHelper.applyBlastProtection(itemStack);
        }
        if((btnUpgrade.lazyIs(Upgrade.BLAST_PROTECTION_1) && !btn.getValue().isEnabled())){
            UpgradeHelper.removeBlastProtection(itemStack);
        }
        if((btnUpgrade.lazyIs(Upgrade.FIRE_PROTECTION_1) && btn.getValue().isEnabled())){
            UpgradeHelper.applyFireProtection(itemStack);
        }
        if((btnUpgrade.lazyIs(Upgrade.FIRE_PROTECTION_1) && !btn.getValue().isEnabled())){
            UpgradeHelper.removeFireProtection(itemStack);
        }
        if((btnUpgrade.lazyIs(Upgrade.PROJECTILE_PROTECTION_1) && btn.getValue().isEnabled())){
            UpgradeHelper.applyProjectileProtection(itemStack);
        }
        if((btnUpgrade.lazyIs(Upgrade.PROJECTILE_PROTECTION_1) && !btn.getValue().isEnabled())){
            UpgradeHelper.removeProjectileProtection(itemStack);
        }
        if((btnUpgrade.lazyIs(Upgrade.PROTECTION_1) && btn.getValue().isEnabled())){
            UpgradeHelper.applyProtection(itemStack);
        }
        if((btnUpgrade.lazyIs(Upgrade.PROTECTION_1) && !btn.getValue().isEnabled())){
            UpgradeHelper.removeProtection(itemStack);
        }
        if((btnUpgrade.lazyIs(Upgrade.RESPIRATION_1) && btn.getValue().isEnabled())){
            UpgradeHelper.applyRespiration(itemStack);
        }
        if((btnUpgrade.lazyIs(Upgrade.RESPIRATION_1) && !btn.getValue().isEnabled())){
            UpgradeHelper.removeRespiration(itemStack);
        }
        if((btnUpgrade.lazyIs(Upgrade.THORNS_1) && btn.getValue().isEnabled())){
            UpgradeHelper.applyThorns(itemStack);
        }
        if((btnUpgrade.lazyIs(Upgrade.THORNS_1) && !btn.getValue().isEnabled())){
            UpgradeHelper.removeThorns(itemStack);
        }
        //Armor Upgrades End

        //Tool Upgrades Start
        if((btnUpgrade.lazyIs(Upgrade.EFFICIENCY_1) && btn.getValue().isEnabled())){
            UpgradeHelper.applyEfficiency(tool);
        }
        if((btnUpgrade.lazyIs(Upgrade.EFFICIENCY_3) && !btn.getValue().isEnabled())){
            UpgradeHelper.removeEfficiency(tool);
        }
        if((btnUpgrade.lazyIs(Upgrade.FORTUNE_1) && btn.getValue().isEnabled())){
            UpgradeHelper.applyFortune(itemStack);
        }
        if((btnUpgrade.lazyIs(Upgrade.FORTUNE_1) && !btn.getValue().isEnabled())){
            UpgradeHelper.removeFortune(itemStack);
        }
        if((btnUpgrade.lazyIs(Upgrade.SHARPNESS_1) && btn.getValue().isEnabled())){
            UpgradeHelper.applySharpness(itemStack);
        }
        if((btnUpgrade.lazyIs(Upgrade.SHARPNESS_1) && !btn.getValue().isEnabled())){
            UpgradeHelper.removeSharpness(itemStack);
        }
        if((btnUpgrade.lazyIs(Upgrade.SMITE_1) && btn.getValue().isEnabled())){
            UpgradeHelper.applySmite(itemStack);
        }
        if((btnUpgrade.lazyIs(Upgrade.SMITE_1) && !btn.getValue().isEnabled())){
            UpgradeHelper.removeSmite(itemStack);
        }
        if((btnUpgrade.lazyIs(Upgrade.SILK) && btn.getValue().isEnabled())){
            UpgradeHelper.applySilkTouch(itemStack);
        }
        if((btnUpgrade.lazyIs(Upgrade.SILK) && !btn.getValue().isEnabled())){
            UpgradeHelper.removeSilkTouch(itemStack);
        }
        if((btnUpgrade.lazyIs(Upgrade.UNBREAKING_1) && btn.getValue().isEnabled())){
            UpgradeHelper.applyUnbreaking(itemStack);
        }
        if((btnUpgrade.lazyIs(Upgrade.UNBREAKING_1) && !btn.getValue().isEnabled())){
            UpgradeHelper.removeUnbreaking(itemStack);
        }
        //Tool Upgrades End

        //Weapon Upgrades Start
        if((btnUpgrade.lazyIs(Upgrade.BANE_OF_ARTHROPODS_1) && btn.getValue().isEnabled())){
            UpgradeHelper.applyBaneOfArthropods(itemStack);
        }
        if((btnUpgrade.lazyIs(Upgrade.BANE_OF_ARTHROPODS_1) && !btn.getValue().isEnabled())){
            UpgradeHelper.removeBaneOfArthropods(itemStack);
        }
        if((btnUpgrade.lazyIs(Upgrade.FIRE_ASPECT_1) && btn.getValue().isEnabled())){
            UpgradeHelper.applyFireAspect(itemStack);
        }
        if((btnUpgrade.lazyIs(Upgrade.FIRE_ASPECT_1) && !btn.getValue().isEnabled())){
            UpgradeHelper.removeFireAspect(itemStack);
        }
        if((btnUpgrade.lazyIs(Upgrade.KNOCKBACK_1) && btn.getValue().isEnabled())){
            UpgradeHelper.applyKnockback(itemStack);
        }
        if((btnUpgrade.lazyIs(Upgrade.KNOCKBACK_1) && !btn.getValue().isEnabled())){
            UpgradeHelper.removeKnockback(itemStack);
        }
        if((btnUpgrade.lazyIs(Upgrade.MOB_LOOTING_1) && btn.getValue().isEnabled())){
            UpgradeHelper.applyMobLooting(itemStack);
        }
        if((btnUpgrade.lazyIs(Upgrade.MOB_LOOTING_1) && !btn.getValue().isEnabled())){
            UpgradeHelper.removeMobLooting(itemStack);
        }
        if((btnUpgrade.lazyIs(Upgrade.MENDING) && btn.getValue().isEnabled())){
            UpgradeHelper.applyMending(itemStack);
        }
        if((btnUpgrade.lazyIs(Upgrade.MENDING) && !btn.getValue().isEnabled())){
            UpgradeHelper.removeMending(itemStack);
        }
        if((btnUpgrade.lazyIs(Upgrade.SHARPNESS_1) && btn.getValue().isEnabled())){
            UpgradeHelper.applySharpness(itemStack);
        }
        if((btnUpgrade.lazyIs(Upgrade.SHARPNESS_1) && !btn.getValue().isEnabled())){
            UpgradeHelper.removeSharpness(itemStack);
        }
        if((btnUpgrade.lazyIs(Upgrade.SMITE_1) && btn.getValue().isEnabled())){
            UpgradeHelper.applySmite(itemStack);
        }
        if((btnUpgrade.lazyIs(Upgrade.SMITE_1) && !btn.getValue().isEnabled())){
            UpgradeHelper.removeSmite(itemStack);
        }
        if((btnUpgrade.lazyIs(Upgrade.SWEEPING_EDGE_1) && btn.getValue().isEnabled())){
            UpgradeHelper.applySweepingEdge(itemStack);
        }
        if((btnUpgrade.lazyIs(Upgrade.SWEEPING_EDGE_1) && !btn.getValue().isEnabled())){
            UpgradeHelper.removeSweepingEdge(itemStack);
        }
        if((btnUpgrade.lazyIs(Upgrade.UNBREAKING_1) && btn.getValue().isEnabled())){
            UpgradeHelper.applyUnbreaking(itemStack);
        }
        if((btnUpgrade.lazyIs(Upgrade.UNBREAKING_1) && !btn.getValue().isEnabled())){
            UpgradeHelper.removeUnbreaking(itemStack);
        }
        //Weapon Upgrades End
    }

    @Override
    public void renderBackground(GuiGraphics guiGraphics) {
        RenderSystem.setShaderTexture(0, BACKGROUND_TEXTURE);
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);

        var baseX = (width - imageWidth) / 2;
        var baseY = (height - imageHeight) / 2;

        var baseXTooltip1 = 12;

        var baseYTooltip1 = 15;
        var baseYTooltip2 = 65;

        guiGraphics.blit(BACKGROUND_TEXTURE, baseX, baseY, 0, 0, imageWidth, imageHeight);

        //guiGraphics.drawString(font, getTranslation("tooltip.screen.tool_row"), baseX + 180, baseY + 5, Color.ORANGE.getRGB());



        if (selectedTool == "enderite_pickaxe") {
            //guiGraphics.blit(BACKGROUND_TEXTURE,baseX + 35, baseY + 110, 0, 109, 22, 22);
            guiGraphics.drawString(font, getTranslation("tooltip.screen.pickaxe_settings"), baseX + baseXTooltip1, baseY + baseYTooltip1, Color.ORANGE.getRGB());
            guiGraphics.drawString(font, getTranslation("tooltip.screen.pickaxe_aoe_settings"), baseX + baseXTooltip1, baseY + 25, Color.WHITE.getRGB());
            guiGraphics.drawString(font, getTranslation("tooltip.screen.pickaxe_depth_settings"), baseX + baseXTooltip1 + 108, baseY + 25, Color.WHITE.getRGB());
            guiGraphics.drawString(font, getTranslation("tooltip.screen.toggle_upgrades"), baseX + baseXTooltip1, baseY + baseYTooltip2, Color.ORANGE.getRGB());
        }

        if (selectedTool == "enderite_shovel") {
            guiGraphics.drawString(font, getTranslation("tooltip.screen.shovel_settings"), baseX + baseXTooltip1, baseY + baseYTooltip1, Color.ORANGE.getRGB());
            guiGraphics.drawString(font, getTranslation("tooltip.screen.toggle_upgrades"), baseX + baseXTooltip1, baseY + baseYTooltip2, Color.ORANGE.getRGB());
        }

        if (selectedTool == "enderite_axe") {
            guiGraphics.drawString(font, getTranslation("tooltip.screen.axe_settings"), baseX + baseXTooltip1, baseY + baseYTooltip1, Color.ORANGE.getRGB());
            guiGraphics.drawString(font, getTranslation("tooltip.screen.toggle_upgrades"), baseX + baseXTooltip1, baseY + baseYTooltip2, Color.ORANGE.getRGB());
        }

        if (selectedTool == "enderite_hoe") {
            guiGraphics.drawString(font, getTranslation("tooltip.screen.hoe_settings"), baseX + baseXTooltip1, baseY + baseYTooltip1, Color.ORANGE.getRGB());
            guiGraphics.drawString(font, getTranslation("tooltip.screen.toggle_upgrades"), baseX + baseXTooltip1, baseY + baseYTooltip2, Color.ORANGE.getRGB());
        }

        if (selectedTool == "enderite_sword") {
            guiGraphics.drawString(font, getTranslation("tooltip.screen.sword_settings"), baseX + baseXTooltip1, baseY + baseYTooltip1, Color.ORANGE.getRGB());
            guiGraphics.drawString(font, getTranslation("tooltip.screen.toggle_upgrades"), baseX + baseXTooltip1, baseY + baseYTooltip2, Color.ORANGE.getRGB());
        }

        if (selectedTool == "enderite_helmet" || selectedTool == "enderite_chestplate" || selectedTool == "enderite_leggings" || selectedTool == "enderite_boots") {
            guiGraphics.drawString(font, getTranslation("tooltip.screen.armor_settings"), baseX + baseXTooltip1, baseY + baseYTooltip1, Color.ORANGE.getRGB());
            guiGraphics.drawString(font, getTranslation("tooltip.screen.toggle_upgrades"), baseX + baseXTooltip1, baseY + baseYTooltip2, Color.ORANGE.getRGB());
        }
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, partialTicks);

        for (GuiEventListener element : this.children()) {
            if (element instanceof ToggleButton) {
                ToggleButton button = (ToggleButton) element;
                if (button.isMouseOver(mouseX, mouseY)) {
                    guiGraphics.renderTooltip(font, button.getOurTooltip(), DefaultTooltipPositioner.INSTANCE, mouseX, mouseY);
                }
            }
        }

    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    private static MutableComponent getTranslation(String key, Object... args) {
        return Component.translatable(TheWorldBefore.MOD_ID + "." + key, args);
    }
}