package com.suurflieg.theworldbefore.datagen;

import com.suurflieg.theworldbefore.TheWorldBefore;
import com.suurflieg.theworldbefore.registry.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {


    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TheWorldBefore.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.TITANIUM_BLOCK);

        blockWithItem(ModBlocks.TITANIUM_ORE);

        blockWithItem(ModBlocks.DEEPSLATE_TITANIUM_ORE);

        blockWithItem(ModBlocks.AVENTURINE_BLOCK);
        blockWithItem(ModBlocks.BUDDING_AVENTURINE);
        blockWithItem(ModBlocks.PYRITE_BLOCK);
        blockWithItem(ModBlocks.BUDDING_PYRITE);
        blockWithItem(ModBlocks.RUBY_BLOCK);
        blockWithItem(ModBlocks.BUDDING_RUBY);
        blockWithItem(ModBlocks.TOPAZ_BLOCK);
        blockWithItem(ModBlocks.BUDDING_TOPAZ);
        blockWithItem(ModBlocks.SPECTROLITE_BLOCK);
        blockWithItem(ModBlocks.BUDDING_SPECTROLITE);
        blockWithItem(ModBlocks.UNAKITE_BLOCK);
        blockWithItem(ModBlocks.BUDDING_UNAKITE);

        horizontalBlock(ModBlocks.UPGRADE_STATION.get(), new ModelFile.UncheckedModelFile(modLoc("block/upgrade_station")));

        logBlock((RotatedPillarBlock) ModBlocks.LARCH_LOG.get());
        axisBlock((RotatedPillarBlock) ModBlocks.LARCH_WOOD.get(), blockTexture(ModBlocks.LARCH_LOG.get()), blockTexture(ModBlocks.LARCH_LOG.get()));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_LARCH_LOG.get(), new ResourceLocation(TheWorldBefore.MOD_ID, "block/stripped_larch_log"), new ResourceLocation(TheWorldBefore.MOD_ID, "block/stripped_larch_log_top"));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_LARCH_WOOD.get(), new ResourceLocation(TheWorldBefore.MOD_ID, "block/stripped_larch_log"), new ResourceLocation(TheWorldBefore.MOD_ID, "block/stripped_larch_log_top"));

        simpleBlock(ModBlocks.LARCH_PLANKS.get());
        simpleBlock(ModBlocks.LARCH_LEAVES.get());

        //simpleBlock(ModBlocks.LARCH_SAPLING.get(), models().cross(ModBlocks.LARCH_SAPLING.get().getRegistryName().getPath(), blockTexture(ModBlocks.LARCH_SAPLING.get())));

    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
