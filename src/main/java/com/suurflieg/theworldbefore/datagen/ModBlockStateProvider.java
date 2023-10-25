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
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {


    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TheWorldBefore.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.ENDERITE_BLOCK);
        blockWithItem(ModBlocks.TEST);
        blockWithItem(ModBlocks.SMITHING_TABLE_PLUS);

        blockWithItem(ModBlocks.ENDERITE_ORE);
        blockWithItem(ModBlocks.AVENTURINE_ORE);
        blockWithItem(ModBlocks.PYRITE_ORE);
        blockWithItem(ModBlocks.RUBY_ORE);
        blockWithItem(ModBlocks.TOPAZ_ORE);
        blockWithItem(ModBlocks.SPECTROLITE_ORE);
        blockWithItem(ModBlocks.UNAKITE_ORE);

        blockWithItem(ModBlocks.DEEPSLATE_ENDERITE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_AVENTURINE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_PYRITE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_RUBY_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_TOPAZ_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_SPECTROLITE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_UNAKITE_ORE);

        blockWithItem(ModBlocks.AVENTURINE_BLOCK);
        blockWithItem(ModBlocks.PYRITE_BLOCK);
        blockWithItem(ModBlocks.RUBY_BLOCK);
        blockWithItem(ModBlocks.TOPAZ_BLOCK);
        blockWithItem(ModBlocks.SPECTROLITE_BLOCK);
        blockWithItem(ModBlocks.UNAKITE_BLOCK);

        horizontalBlock(ModBlocks.UPGRADE_STATION.get(), new ModelFile.UncheckedModelFile(modLoc("block/upgrade_station")));

        logBlock((RotatedPillarBlock) ModBlocks.LARCH_LOG.get());
        axisBlock((RotatedPillarBlock) ModBlocks.LARCH_WOOD.get(), blockTexture(ModBlocks.LARCH_LOG.get()), blockTexture(ModBlocks.LARCH_LOG.get()));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_LARCH_LOG.get(), new ResourceLocation(TheWorldBefore.MOD_ID, "block/stripped_larch_log"), new ResourceLocation(TheWorldBefore.MOD_ID, "block/stripped_larch_log_top"));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_LARCH_WOOD.get(), new ResourceLocation(TheWorldBefore.MOD_ID, "block/stripped_larch_log"), new ResourceLocation(TheWorldBefore.MOD_ID, "block/stripped_larch_log_top"));

        simpleBlock(ModBlocks.LARCH_PLANKS.get());
        simpleBlock(ModBlocks.LARCH_LEAVES.get());

        saplingBlock(ModBlocks.LARCH_SAPLING);

    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }
}
