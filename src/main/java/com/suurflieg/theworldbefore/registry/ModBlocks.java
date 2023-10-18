package com.suurflieg.theworldbefore.registry;

import com.suurflieg.theworldbefore.TheWorldBefore;
import com.suurflieg.theworldbefore.block.block.*;
import com.suurflieg.theworldbefore.world.tree.LarchTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.*;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TheWorldBefore.MOD_ID);

    public static final RegistryObject<Block> ENDERITE_ORE = registerBlock("enderite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(4f).requiresCorrectToolForDrops(), UniformInt.of(2,4)));
    public static final RegistryObject<Block> DEEPSLATE_ENDERITE_ORE = registerBlock("deepslate_enderite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(4f).requiresCorrectToolForDrops(), UniformInt.of(2,4)));

    public static final RegistryObject<Block> AVENTURINE_ORE = registerBlock("aventurine_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(4f).requiresCorrectToolForDrops(), UniformInt.of(2,4)));
    public static final RegistryObject<Block> DEEPSLATE_AVENTURINE_ORE = registerBlock("deepslate_aventurine_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(4f).requiresCorrectToolForDrops(), UniformInt.of(2,4)));

    public static final RegistryObject<Block> PYRITE_ORE = registerBlock("pyrite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(4f).requiresCorrectToolForDrops(), UniformInt.of(2,4)));
    public static final RegistryObject<Block> DEEPSLATE_PYRITE_ORE = registerBlock("deepslate_pyrite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(4f).requiresCorrectToolForDrops(), UniformInt.of(2,4)));

    public static final RegistryObject<Block> RUBY_ORE = registerBlock("ruby_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(4f).requiresCorrectToolForDrops(), UniformInt.of(2,4)));
    public static final RegistryObject<Block> DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(4f).requiresCorrectToolForDrops(), UniformInt.of(2,4)));

    public static final RegistryObject<Block> TOPAZ_ORE = registerBlock("topaz_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(4f).requiresCorrectToolForDrops(), UniformInt.of(2,4)));
    public static final RegistryObject<Block> DEEPSLATE_TOPAZ_ORE = registerBlock("deepslate_topaz_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(4f).requiresCorrectToolForDrops(), UniformInt.of(2,4)));

    public static final RegistryObject<Block> SPECTROLITE_ORE = registerBlock("spectrolite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(4f).requiresCorrectToolForDrops(), UniformInt.of(2,4)));
    public static final RegistryObject<Block> DEEPSLATE_SPECTROLITE_ORE = registerBlock("deepslate_spectrolite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(4f).requiresCorrectToolForDrops(), UniformInt.of(2,4)));

    public static final RegistryObject<Block> UNAKITE_ORE = registerBlock("unakite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(4f).requiresCorrectToolForDrops(), UniformInt.of(2,4)));
    public static final RegistryObject<Block> DEEPSLATE_UNAKITE_ORE = registerBlock("deepslate_unakite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(4f).requiresCorrectToolForDrops(), UniformInt.of(2,4)));


/*    public static final RegistryObject<Block> AVENTURINE_GEM_ORE = registerBlock("aventurine_gem_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.AMETHYST_CLUSTER).strength(4f).requiresCorrectToolForDrops(), UniformInt.of(2,4)));*/


    public static final RegistryObject<Block> ENDERITE_BLOCK = registerBlock("enderite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(5f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> UPGRADE_STATION = registerBlock("upgrade_station",
            () -> new UpgradeStationBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(2f).requiresCorrectToolForDrops().noOcclusion()));

    public static final RegistryObject<Block> AVENTURINE_BLOCK = registerBlock("aventurine_block", () -> new AventurineBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).strength(0.5f).sound(SoundType.BASALT)));
    public static final RegistryObject<Block> PYRITE_BLOCK = registerBlock("pyrite_block", () -> new PyriteBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(0.5f).sound(SoundType.BASALT)));
    public static final RegistryObject<Block> RUBY_BLOCK = registerBlock("ruby_block", () -> new RubyBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(0.5f).sound(SoundType.BASALT)));
    public static final RegistryObject<Block> TOPAZ_BLOCK = registerBlock("topaz_block", () -> new TopazBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(0.5f).sound(SoundType.BASALT)));
    public static final RegistryObject<Block> SPECTROLITE_BLOCK = registerBlock("spectrolite_block", () -> new SpectroliteBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(0.5f).sound(SoundType.BASALT)));
    public static final RegistryObject<Block> UNAKITE_BLOCK = registerBlock("unakite_block", () -> new UnakiteBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(0.5f).sound(SoundType.BASALT)));

    public static final RegistryObject<Block> LARCH_LOG = registerBlock("larch_log", () -> new ModFlammableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> LARCH_WOOD = registerBlock("larch_wood", () -> new ModFlammableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_LARCH_LOG = registerBlock("stripped_larch_log", () -> new ModFlammableBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_LARCH_WOOD = registerBlock("stripped_larch_wood", () -> new ModFlammableBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final RegistryObject<Block> LARCH_PLANKS = registerBlock("larch_planks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
        @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {return true;}
        @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {return 20;}
        @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {return 5;}});

    public static final RegistryObject<Block> LARCH_LEAVES = registerBlock("larch_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)) {
        @Override public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {return true;}
        @Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {return 60;}
        @Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {return 30;}});


    public static final RegistryObject<Block> LARCH_SAPLING = registerBlock("larch_sapling", () -> new SaplingBlock(new LarchTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    //Register Block with tooltip field
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, String tooltipKey) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    ////Register BlockItem with tooltip field
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, String tooltipKey) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()){
            @Override
            public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
                pTooltip.add(Component.translatable(tooltipKey));
            }
        });
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<T> registerBlockNoTab(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    private static <T extends Block> RegistryObject<T> registerBlockWithoutBlockItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItemNoTab(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
