package com.suurflieg.theworldbefore.item.upgradecards;

import com.suurflieg.theworldbefore.TheWorldBefore;

/**
 * Credit goes to Direwolf20 and mining gadgets
 * https://github.com/Direwolf20-MC/MiningGadgets
 * With some changes from me.
 */

public enum Upgrade {

    //Blank

    BLANK("blank", false),

    SILK("silk", true),
    EXPANDER("expander", false),
    DEPTH("depth", false),
    MAGNET("magnet", true),
    MENDING("mending",true),
    AQUA_AFFINITY("aqua_affinity",true),
    FIRE_ELEMENT("fire_element", true),
    ICE_ELEMENT("ice_element", true),
    WIND_ELEMENT("wind_element", true),
    ELECTRIC_ELEMENT("electric_element", true),

    // Tiered

    BANE_OF_ARTHROPODS_1("bane_of_arthropods_1",1,true),
    BANE_OF_ARTHROPODS_2("bane_of_arthropods_2",2,true),
    BANE_OF_ARTHROPODS_3("bane_of_arthropods_3",3,true),
    BANE_OF_ARTHROPODS_4("bane_of_arthropods_4",4,true),
    BANE_OF_ARTHROPODS_5("bane_of_arthropods_5",5,true),

    BLAST_PROTECTION_1("blast_protection_1", 1, true),
    BLAST_PROTECTION_2("blast_protection_2", 2, true),
    BLAST_PROTECTION_3("blast_protection_3", 3, true),
    BLAST_PROTECTION_4("blast_protection_4", 4, true),

    DEPTH_STRIDER_1("depth_strider_1",1,true),
    DEPTH_STRIDER_2("depth_strider_2",2,true),
    DEPTH_STRIDER_3("depth_strider_3",3,true),

    EFFICIENCY_1("efficiency_1", 1, true),
    EFFICIENCY_2("efficiency_2", 2, true),
    EFFICIENCY_3("efficiency_3", 3, true),
    EFFICIENCY_4("efficiency_4", 4, true),
    EFFICIENCY_5("efficiency_5", 5, true),

    FEATHER_FALLING_1("feather_falling_1", 1, true),
    FEATHER_FALLING_2("feather_falling_2", 2, true),
    FEATHER_FALLING_3("feather_falling_3", 3, true),
    FEATHER_FALLING_4("feather_falling_4", 4, true),

    FIRE_ASPECT_1("fire_aspect_1",1,true),
    FIRE_ASPECT_2("fire_aspect_2",2,true),

    FIRE_PROTECTION_1("fire_protection_1", 1, true),
    FIRE_PROTECTION_2("fire_protection_2", 2, true),
    FIRE_PROTECTION_3("fire_protection_3", 3, true),
    FIRE_PROTECTION_4("fire_protection_4", 4, true),

    FORTUNE_1("fortune_1", 1, true),
    FORTUNE_2("fortune_2", 2, true),
    FORTUNE_3("fortune_3", 3, true),

    FROST_WALKER_1("frost_walker_1",1,true),
    FROST_WALKER_2("frost_walker_2",2,true),

    KNOCKBACK_1("knockback_1",1,true),
    KNOCKBACK_2("knockback_2",2,true),

    MOB_LOOTING_1("mob_looting_1",1,true),
    MOB_LOOTING_2("mob_looting_2",2,true),
    MOB_LOOTING_3("mob_looting_3",3,true),

    PROJECTILE_PROTECTION_1("projectile_protection_1", 1, true),
    PROJECTILE_PROTECTION_2("projectile_protection_2", 2, true),
    PROJECTILE_PROTECTION_3("projectile_protection_3", 3, true),
    PROJECTILE_PROTECTION_4("projectile_protection_4", 4, true),

    PROTECTION_1("protection_1", 1, true),
    PROTECTION_2("protection_2", 2, true),
    PROTECTION_3("protection_3", 3, true),
    PROTECTION_4("protection_4", 4, true),

    RESPIRATION_1("respiration_1",1,true),
    RESPIRATION_2("respiration_2",2,true),
    RESPIRATION_3("respiration_3",3,true),

    SHARPNESS_1("sharpness_1",1,true),
    SHARPNESS_2("sharpness_2",2,true),
    SHARPNESS_3("sharpness_3",3,true),
    SHARPNESS_4("sharpness_4",4,true),
    SHARPNESS_5("sharpness_5",5,true),

    SMITE_1("smite_1",1,true),
    SMITE_2("smite_2",2,true),
    SMITE_3("smite_3",3,true),
    SMITE_4("smite_4",4,true),
    SMITE_5("smite_5",5,true),

    SOUL_SPEED_1("soul_speed_1",1,true),
    SOUL_SPEED_2("soul_speed_2",2,true),
    SOUL_SPEED_3("soul_speed_1",3,true),

    SWEEPING_EDGE_1("sweeping_edge_1",1,true),
    SWEEPING_EDGE_2("sweeping_edge_2",2,true),
    SWEEPING_EDGE_3("sweeping_edge_3",3,true),

    THORNS_1("thorns_1",1,true),
    THORNS_2("thorns_2",2,true),
    THORNS_3("thorns_3",3,true),

    UNBREAKING_1("unbreaking_1",1,true),
    UNBREAKING_2("unbreaking_2",2,true),
    UNBREAKING_3("unbreaking_3",3,true);

    private final String name;
    private final String baseName;
    private final UpgradeCardItem upgradeCardItem;
    private final int tier;
    private boolean active = true;
    private boolean inactive = false;

    private final boolean isToggleable;
    //private final ItemStack upgradeStack;

    Upgrade(String name, int tier, boolean isToggleable) {
        this.name = name;
        this.tier = tier;
        this.upgradeCardItem = new UpgradeCardItem(this);
        //this.upgradeStack = new ItemStack(this.upgradeCardItem);
        this.baseName = tier == -1 ? name : name.substring(0, name.lastIndexOf('_'));
        this.isToggleable = isToggleable;
        String toolTip = "tooltip.theworldbefore." + this.baseName;
    }

    Upgrade(String name, boolean isToggleable) {
        this(name, -1, isToggleable);
    }

    public String getName() {
        return name;
    }

    public UpgradeCardItem getCard() {
        return upgradeCardItem;
    }

//    public ItemStack getStack() {
//        return upgradeStack;
//    }

    public int getTier() {
        return tier;
    }

    // Try and always use base name eval
    public String getBaseName() {
        return baseName;
    }

    public String getLocal() {
        return String.format("item.theworldbefore.upgrade_%s", this.getName());
    }

    // Returns the translated string we can use to actively replace.
    public String getLocalReplacement() {
        return TheWorldBefore.MOD_ID + ".upgrade.replacement";
    }

    public boolean hasTier() {
        return tier != -1;
    }

    public boolean isEnabled() {
        return active;
    }

    public boolean isDisabled() {
        return inactive;
    }

    public void setEnabled(boolean active) {
        this.active = active;
    }

    public void setDisabled(boolean inactive) {
        this.inactive = inactive;
    }

    public boolean isToggleable() {
        return isToggleable;
    }

/*    public String getToolTip() {
        return toolTip;
    }*/

    /**
     * Compares only the base name of the upgrade
     *
     * @param upgrade upgrade to compare against
     */
    public boolean lazyIs(Upgrade upgrade) {
        return this.getBaseName().equals(upgrade.getBaseName());
    }

/*    BLANK("blank", ModUpgradeCards.BLANK, false),

    SILK("silk", ModUpgradeCards.SILK, true),
    EXPANDER("expander", ModUpgradeCards.EXPANDER, false),
    DEPTH("depth", ModUpgradeCards.DEPTH, false),
    MAGNET("magnet", ModUpgradeCards.MAGNET, true),
    MENDING("mending", ModUpgradeCards.MENDING,true),
    AQUA_AFFINITY("aqua_affinity", ModUpgradeCards.AQUA_AFFINITY,true),

    // Tiered

    BANE_OF_ARTHROPODS_1("bane_of_arthropods_1", ModUpgradeCards.BANE_OF_ARTHROPODS_1,1,true),
    BANE_OF_ARTHROPODS_2("bane_of_arthropods_2", ModUpgradeCards.BANE_OF_ARTHROPODS_2,2,true),
    BANE_OF_ARTHROPODS_3("bane_of_arthropods_3", ModUpgradeCards.BANE_OF_ARTHROPODS_3,3,true),
    BANE_OF_ARTHROPODS_4("bane_of_arthropods_4", ModUpgradeCards.BANE_OF_ARTHROPODS_4,4,true),
    BANE_OF_ARTHROPODS_5("bane_of_arthropods_5", ModUpgradeCards.BANE_OF_ARTHROPODS_5,5,true),

    BLAST_PROTECTION_1("blast_protection_1", ModUpgradeCards.BLAST_PROTECTION_1, 1, true),
    BLAST_PROTECTION_2("blast_protection_2", ModUpgradeCards.BLAST_PROTECTION_2, 2, true),
    BLAST_PROTECTION_3("blast_protection_3", ModUpgradeCards.BLAST_PROTECTION_3, 3, true),
    BLAST_PROTECTION_4("blast_protection_4", ModUpgradeCards.BLAST_PROTECTION_4, 4, true),

    DEPTH_STRIDER_1("depth_strider_1", ModUpgradeCards.DEPTH_STRIDER_1,1,true),
    DEPTH_STRIDER_2("depth_strider_2", ModUpgradeCards.DEPTH_STRIDER_2,2,true),
    DEPTH_STRIDER_3("depth_strider_3", ModUpgradeCards.DEPTH_STRIDER_3,3,true),

    EFFICIENCY_1("efficiency_1", ModUpgradeCards.EFFICIENCY_1, 1, true),
    EFFICIENCY_2("efficiency_2", ModUpgradeCards.EFFICIENCY_2, 2, true),
    EFFICIENCY_3("efficiency_3", ModUpgradeCards.EFFICIENCY_3, 3, true),
    EFFICIENCY_4("efficiency_4", ModUpgradeCards.EFFICIENCY_4, 4, true),
    EFFICIENCY_5("efficiency_5", ModUpgradeCards.EFFICIENCY_5, 5, true),

    FEATHER_FALLING_1("feather_falling_1", ModUpgradeCards.FEATHER_FALLING_1, 1, true),
    FEATHER_FALLING_2("feather_falling_2", ModUpgradeCards.FEATHER_FALLING_2, 2, true),
    FEATHER_FALLING_3("feather_falling_3", ModUpgradeCards.FEATHER_FALLING_3, 3, true),
    FEATHER_FALLING_4("feather_falling_4", ModUpgradeCards.FEATHER_FALLING_4, 4, true),

    FIRE_ASPECT_1("fire_aspect_1", ModUpgradeCards.FIRE_ASPECT_1,1,true),
    FIRE_ASPECT_2("fire_aspect_2", ModUpgradeCards.FIRE_ASPECT_2,2,true),

    FIRE_PROTECTION_1("fire_protection_1", ModUpgradeCards.FIRE_PROTECTION_1, 1, true),
    FIRE_PROTECTION_2("fire_protection_2", ModUpgradeCards.FIRE_PROTECTION_2, 2, true),
    FIRE_PROTECTION_3("fire_protection_3", ModUpgradeCards.FIRE_PROTECTION_3, 3, true),
    FIRE_PROTECTION_4("fire_protection_4", ModUpgradeCards.FIRE_PROTECTION_4, 4, true),

    FORTUNE_1("fortune_1", ModUpgradeCards.FORTUNE_1, 1, true),
    FORTUNE_2("fortune_2", ModUpgradeCards.FORTUNE_2, 2, true),
    FORTUNE_3("fortune_3", ModUpgradeCards.FORTUNE_3, 3, true),

    FROST_WALKER_1("frost_walker_1", ModUpgradeCards.FROST_WALKER_1,1,true),
    FROST_WALKER_2("frost_walker_2", ModUpgradeCards.FROST_WALKER_2,2,true),

    KNOCKBACK_1("knockback_1", ModUpgradeCards.KNOCKBACK_1,1,true),
    KNOCKBACK_2("knockback_2", ModUpgradeCards.KNOCKBACK_2,2,true),

    MOB_LOOTING_1("mob_looting_1", ModUpgradeCards.MOB_LOOTING_1,1,true),
    MOB_LOOTING_2("mob_looting_2", ModUpgradeCards.MOB_LOOTING_2,2,true),
    MOB_LOOTING_3("mob_looting_3", ModUpgradeCards.MOB_LOOTING_3,3,true),

    PROJECTILE_PROTECTION_1("projectile_protection_1", ModUpgradeCards.PROJECTILE_PROTECTION_1, 1, true),
    PROJECTILE_PROTECTION_2("projectile_protection_2", ModUpgradeCards.PROJECTILE_PROTECTION_2, 2, true),
    PROJECTILE_PROTECTION_3("projectile_protection_3", ModUpgradeCards.PROJECTILE_PROTECTION_3, 3, true),
    PROJECTILE_PROTECTION_4("projectile_protection_4", ModUpgradeCards.PROJECTILE_PROTECTION_4, 4, true),

    PROTECTION_1("protection_1", ModUpgradeCards.PROTECTION_1, 1, true),
    PROTECTION_2("protection_2", ModUpgradeCards.PROTECTION_2, 2, true),
    PROTECTION_3("protection_3", ModUpgradeCards.PROTECTION_3, 3, true),
    PROTECTION_4("protection_4", ModUpgradeCards.PROTECTION_4, 4, true),

    RESPIRATION_1("respiration_1", ModUpgradeCards.RESPIRATION_1,1,true),
    RESPIRATION_2("respiration_2", ModUpgradeCards.RESPIRATION_2,2,true),
    RESPIRATION_3("respiration_3", ModUpgradeCards.RESPIRATION_3,3,true),

    SHARPNESS_1("sharpness_1", ModUpgradeCards.SHARPNESS_1,1,true),
    SHARPNESS_2("sharpness_2", ModUpgradeCards.SHARPNESS_2,2,true),
    SHARPNESS_3("sharpness_3", ModUpgradeCards.SHARPNESS_3,3,true),
    SHARPNESS_4("sharpness_4", ModUpgradeCards.SHARPNESS_4,4,true),
    SHARPNESS_5("sharpness_5", ModUpgradeCards.SHARPNESS_5,5,true),

    SMITE_1("smite_1", ModUpgradeCards.SMITE_1,1,true),
    SMITE_2("smite_2", ModUpgradeCards.SMITE_2,2,true),
    SMITE_3("smite_3", ModUpgradeCards.SMITE_3,3,true),
    SMITE_4("smite_4", ModUpgradeCards.SMITE_4,4,true),
    SMITE_5("smite_5", ModUpgradeCards.SMITE_5,5,true),

    SOUL_SPEED_1("soul_speed_1", ModUpgradeCards.SOUL_SPEED_1,1,true),
    SOUL_SPEED_2("soul_speed_2", ModUpgradeCards.SOUL_SPEED_2,2,true),
    SOUL_SPEED_3("soul_speed_1", ModUpgradeCards.SOUL_SPEED_3,3,true),

    SWEEPING_EDGE_1("sweeping_edge_1", ModUpgradeCards.SWEEPING_EDGE_1,1,true),
    SWEEPING_EDGE_2("sweeping_edge_2", ModUpgradeCards.SWEEPING_EDGE_2,2,true),
    SWEEPING_EDGE_3("sweeping_edge_3", ModUpgradeCards.SWEEPING_EDGE_3,3,true),

    THORNS_1("thorns_1", ModUpgradeCards.THORNS_1,1,true),
    THORNS_2("thorns_2", ModUpgradeCards.THORNS_2,2,true),
    THORNS_3("thorns_3", ModUpgradeCards.THORNS_3,3,true),

    UNBREAKING_1("unbreaking_1", ModUpgradeCards.UNBREAKING_1,1,true),
    UNBREAKING_2("unbreaking_2", ModUpgradeCards.UNBREAKING_2,2,true),
    UNBREAKING_3("unbreaking_3", ModUpgradeCards.UNBREAKING_3 , 3, true);

    private final String name;
    private final String baseName;
    private final RegistryObject<Item> upgradeCardItem;
    private final int tier;
    private boolean active = true;
    private boolean inactive = false;

    private final boolean isToggleable;
    private final String toolTip;
    private final ItemStack upgradeStack;


    Upgrade(String name, RegistryObject<Item> itemCard, int tier,  boolean isToggleable) {
        this.name = name;
        this.tier = tier;
        this.upgradeCardItem = itemCard;
        this.upgradeStack = new ItemStack(upgradeCardItem.get());
        this.baseName = tier == -1 ? name : name.substring(0, name.lastIndexOf('_'));
        this.isToggleable = isToggleable;
        this.toolTip = "tooltip.theworldbefore." + this.baseName;
    }

    Upgrade(String name, RegistryObject<Item> itemCard, int tier) {
        this(name, itemCard, tier, false);
    }

    Upgrade(String name, RegistryObject<Item> itemCard) {
        this(name, itemCard, -1, true);
    }

    Upgrade(String name, RegistryObject<Item> itemCard, boolean isToggleable) {
        this(name, itemCard, -1, isToggleable);
    }

    public String getName() {
        return name;
    }

    public RegistryObject<Item> getCardItem() {
        return upgradeCardItem;
    }

    public int getTier() {
        return tier;
    }


    // Try and always use base name eval
    public String getBaseName() {
        return baseName;
    }

    public String getLocal() {
        return String.format("item.theworldbefore.upgrade_%s", this.getName());
    }

    // Returns the translated string we can use to actively replace.
    public String getLocalReplacement() {
        return TheWorldBefore.MOD_ID + ".upgrade.replacement";
    }

    public boolean hasTier() {
        return tier != -1;
    }

    public boolean isEnabled() {
        return active;
    }

    public void setEnabled(boolean active) {
        this.active = active;
    }

    public boolean isToggleable() {
        return isToggleable;
    }

    public String getToolTip() {
        return toolTip;
    }

    public RegistryObject<Item> getCard() {
        return upgradeCardItem;
    }

    public ItemStack getStack() {
        return upgradeStack;
    }

    *//**
     * Compares only the base name of the upgrade
     *
     * @param upgrade upgrade to compare against
     *//*
    public boolean lazyIs(Upgrade upgrade) {
        return this.getBaseName().equals(upgrade.getBaseName());
    }*/

}
