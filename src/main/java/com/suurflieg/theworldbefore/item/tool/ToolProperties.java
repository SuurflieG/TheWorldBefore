package com.suurflieg.theworldbefore.item.tool;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;

/**
 * Credit goes to Direwolf20 and mining gadgets
 * https://github.com/Direwolf20-MC/MiningGadgets
 * With some changes from me.
 */

public class ToolProperties {
    private ToolProperties() {}

    private static final String KEY_AOE_SIZE = "aoe";
    private static final String KEY_MINING_DEPTH = "depth";

    public static int setAOE(ItemStack tool, int size) {
        tool.getOrCreateTag().putInt(KEY_AOE_SIZE, size);
        return size;
    }

    public static int getAOE(ItemStack tool) {
        CompoundTag compound = tool.getOrCreateTag();
        return !compound.contains(KEY_AOE_SIZE) ? setAOE(tool, 1) : compound.getInt(KEY_AOE_SIZE);
    }

    public static int setMiningDepth(ItemStack tool, int depth) {
        tool.getOrCreateTag().putInt(KEY_MINING_DEPTH, depth);
        return depth;
    }

    public static int getMiningDepth(ItemStack tool) {
        CompoundTag compound = tool.getOrCreateTag();
        return !compound.contains(KEY_MINING_DEPTH) ? setMiningDepth(tool, 1) : compound.getInt(KEY_MINING_DEPTH);
    }

}