package com.suurflieg.theworldbefore.gui.menu;

import com.suurflieg.theworldbefore.recipe.ModSmithingRecipe;
import com.suurflieg.theworldbefore.registry.ModBlocks;
import com.suurflieg.theworldbefore.registry.ModMenuTypes;
import com.suurflieg.theworldbefore.registry.ModRecipeTypes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.ItemCombinerMenu;
import net.minecraft.world.inventory.ItemCombinerMenuSlotDefinition;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;

public class SmithingTablePlusMenu extends ItemCombinerMenu {
    public static final int TEMPLATE_SLOT = 0;
    public static final int BASE_SLOT = 1;
    public static final int ADDITIONAL_SLOT = 2;
    public static final int RESULT_SLOT = 3;
    public static final int TEMPLATE_SLOT_X_PLACEMENT = 8;
    public static final int BASE_SLOT_X_PLACEMENT = 26;
    public static final int ADDITIONAL_SLOT_X_PLACEMENT = 44;
    private static final int RESULT_SLOT_X_PLACEMENT = 98;
    public static final int SLOT_Y_PLACEMENT = 48;
    private Level level;
    @Nullable
    private ModSmithingRecipe selectedRecipe;
    private List<ModSmithingRecipe> recipes;

    public SmithingTablePlusMenu(int pContainerId, Inventory pPlayerInventory) {
        super(ModMenuTypes.SMITHING_TABLE_PLUS_MENU.get(), pContainerId, pPlayerInventory, ContainerLevelAccess.NULL);
    }

    public SmithingTablePlusMenu(int pContainerId, Inventory pPlayerInventory, ContainerLevelAccess pAccess) {
        super(ModMenuTypes.SMITHING_TABLE_PLUS_MENU.get(), pContainerId, pPlayerInventory, pAccess);
        this.level = pPlayerInventory.player.level();
        this.recipes = this.level.getRecipeManager().getAllRecipesFor(ModRecipeTypes.MOD_SMITHING.get());
    }

    public SmithingTablePlusMenu(int pContainerId, Inventory pPlayerInventory, FriendlyByteBuf friendlyByteBuf) {
        super(ModMenuTypes.SMITHING_TABLE_PLUS_MENU.get(), pContainerId, pPlayerInventory, ContainerLevelAccess.NULL);

    }

    public ItemCombinerMenuSlotDefinition createInputSlotDefinitions() {
        return ItemCombinerMenuSlotDefinition.create().withSlot(TEMPLATE_SLOT, 8, 48, (itemStack) ->
                        this.recipes.stream().anyMatch((modSmithingRecipe) ->
                modSmithingRecipe.isTemplateIngredient(itemStack))).withSlot(BASE_SLOT, 26, 48, (itemStack) ->
                this.recipes.stream().anyMatch((modSmithingRecipe) ->
                        modSmithingRecipe.isBaseIngredient(itemStack)))
                .withSlot(ADDITIONAL_SLOT, 44, 48, (itemStack) ->
                this.recipes.stream().anyMatch((modSmithingRecipe) ->
                        modSmithingRecipe.isAdditionIngredient(itemStack))).withResultSlot(RESULT_SLOT, 98, 48).build();
    }

    public boolean isValidBlock(BlockState pState) {
        return pState.is(ModBlocks.SMITHING_TABLE_PLUS.get());
    }

    public boolean mayPickup(Player pPlayer, boolean pHasStack) {
        return this.selectedRecipe != null && this.selectedRecipe.matches(this.inputSlots, this.level);
    }

    public void onTake(Player pPlayer, ItemStack pStack) {
        pStack.onCraftedBy(pPlayer.level(), pPlayer, pStack.getCount());
        this.resultSlots.awardUsedRecipes(pPlayer, this.getRelevantItems());
        this.shrinkStackInSlot(TEMPLATE_SLOT);
        this.shrinkStackInSlot(1);
        this.shrinkStackInSlot(2);
        this.access.execute((p_40263_, p_40264_) -> {
            p_40263_.levelEvent(1044, p_40264_, 0);
        });
    }

    private List<ItemStack> getRelevantItems() {
        return List.of(this.inputSlots.getItem(0), this.inputSlots.getItem(1), this.inputSlots.getItem(2));
    }

    private void shrinkStackInSlot(int pIndex) {
        ItemStack itemstack = this.inputSlots.getItem(pIndex);
        if (!itemstack.isEmpty()) {
            itemstack.shrink(1);
            this.inputSlots.setItem(pIndex, itemstack);
        }

    }

    public void createResult() {
        List<ModSmithingRecipe> list;
        list = this.level.getRecipeManager().getRecipesFor(ModRecipeTypes.MOD_SMITHING.get(), this.inputSlots, this.level);
        if (list.isEmpty()) {
            this.resultSlots.setItem(0, ItemStack.EMPTY);
        } else {
            ModSmithingRecipe smithingrecipe = list.get(0);
            ItemStack itemstack = smithingrecipe.assemble(this.inputSlots, this.level.registryAccess());
            if (itemstack.isItemEnabled(this.level.enabledFeatures())) {
                this.selectedRecipe = smithingrecipe;
                this.resultSlots.setRecipeUsed(smithingrecipe);
                this.resultSlots.setItem(0, itemstack);
            }
        }

    }

    public int getSlotToQuickMoveTo(ItemStack pStack) {
        return this.recipes.stream().map((modSmithingRecipe) ->
                findSlotMatchingIngredient(modSmithingRecipe, pStack)).filter(Optional::isPresent).findFirst().orElse(Optional.of(0)).get();
    }

    private static Optional<Integer> findSlotMatchingIngredient(ModSmithingRecipe pRecipe, ItemStack pStack) {
        if (pRecipe.isTemplateIngredient(pStack)) {
            return Optional.of(0);
        } else if (pRecipe.isBaseIngredient(pStack)) {
            return Optional.of(1);
        } else {
            return pRecipe.isAdditionIngredient(pStack) ? Optional.of(2) : Optional.empty();
        }
    }

    public boolean canTakeItemForPickAll(ItemStack pStack, Slot pSlot) {
        return pSlot.container != this.resultSlots && super.canTakeItemForPickAll(pStack, pSlot);
    }

    public boolean canMoveIntoInputSlots(ItemStack pStack) {
        return this.recipes.stream().map((smithingRecipe) -> findSlotMatchingIngredient(smithingRecipe, pStack)).anyMatch(Optional::isPresent);
    }
}
