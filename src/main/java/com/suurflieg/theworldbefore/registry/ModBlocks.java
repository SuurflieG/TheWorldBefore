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

    public static final RegistryObject<Block> TITANIUM_ORE = registerBlock("titanium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(4f).requiresCorrectToolForDrops(), UniformInt.of(2,4)));
    public static final RegistryObject<Block> DEEPSLATE_TITANIUM_ORE = registerBlock("deepslate_titanium_ore",
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


    public static final RegistryObject<Block> TITANIUM_BLOCK = registerBlock("titanium_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(5f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> UPGRADE_STATION = registerBlock("upgrade_station",
            () -> new UpgradeStationBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(2f).requiresCorrectToolForDrops().noOcclusion()));

    public static final RegistryObject<Block> AVENTURINE_BLOCK = registerBlock("aventurine_block", () -> new AventurineBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).strength(0.5f).sound(SoundType.BASALT)));
    public static final RegistryObject<Block> PYRITE_BLOCK = registerBlock("pyrite_block", () -> new PyriteBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(0.5f).sound(SoundType.BASALT)));
    public static final RegistryObject<Block> RUBY_BLOCK = registerBlock("ruby_block", () -> new RubyBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(0.5f).sound(SoundType.BASALT)));
    public static final RegistryObject<Block> TOPAZ_BLOCK = registerBlock("topaz_block", () -> new TopazBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(0.5f).sound(SoundType.BASALT)));
    public static final RegistryObject<Block> SPECTROLITE_BLOCK = registerBlock("spectrolite_block", () -> new SpectroliteBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(0.5f).sound(SoundType.BASALT)));
    public static final RegistryObject<Block> UNAKITE_BLOCK = registerBlock("unakite_block", () -> new UnakiteBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(0.5f).sound(SoundType.BASALT)));

  /*  public static final RegistryObject<Block> BUDDING_AVENTURINE = registerBlock("budding_aventurine",
            () -> new BuddingAventurineBlock(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK).randomTicks().strength(1.5F).sound(SoundType.AMETHYST).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> AVENTURINE_CLUSTER = registerBlock("aventurine_cluster",
            () -> new AventurineClusterBlock(7, 3, BlockBehaviour.Properties.copy(Blocks.AMETHYST_CLUSTER).noOcclusion().randomTicks().sound(SoundType.AMETHYST_CLUSTER).strength(1.5F).lightLevel( (pLightEmission) -> 8)));
    public static final RegistryObject<Block> LARGE_AVENTURINE_BUD = registerBlock("large_aventurine_bud",
            () -> new AventurineClusterBlock(5, 3, BlockBehaviour.Properties.copy(Blocks.LARGE_AMETHYST_BUD).sound(SoundType.LARGE_AMETHYST_BUD).lightLevel((pLightEmission) -> 6)));
    public static final RegistryObject<Block> MEDIUM_AVENTURINE_BUD = registerBlock("medium_aventurine_bud",
            () -> new AventurineClusterBlock(4, 3, BlockBehaviour.Properties.copy(Blocks.MEDIUM_AMETHYST_BUD).sound(SoundType.MEDIUM_AMETHYST_BUD).lightLevel((pLightEmission) -> 3)));
    public static final RegistryObject<Block> SMALL_AVENTURINE_BUD = registerBlock("small_aventurine_bud",
            () -> new AventurineClusterBlock(3, 4, BlockBehaviour.Properties.copy(Blocks.SMALL_AMETHYST_BUD).sound(SoundType.SMALL_AMETHYST_BUD).lightLevel((pLightEmission) -> 2)));


    public static final RegistryObject<Block> BUDDING_PYRITE = registerBlock("budding_pyrite",
            () -> new BuddingPyriteBlock(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK).randomTicks().strength(1.5F).sound(SoundType.AMETHYST).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> PYRITE_CLUSTER = registerBlock("pyrite_cluster",
            () -> new PyriteClusterBlock(7, 3, BlockBehaviour.Properties.copy(Blocks.AMETHYST_CLUSTER).noOcclusion().randomTicks().sound(SoundType.AMETHYST_CLUSTER).strength(1.5F).lightLevel( (pLightEmission) -> 8)));
    public static final RegistryObject<Block> LARGE_PYRITE_BUD = registerBlock("large_pyrite_bud",
            () -> new PyriteClusterBlock(5, 3, BlockBehaviour.Properties.copy(Blocks.LARGE_AMETHYST_BUD).sound(SoundType.LARGE_AMETHYST_BUD).lightLevel((pLightEmission) -> 6)));
    public static final RegistryObject<Block> MEDIUM_PYRITE_BUD = registerBlock("medium_pyrite_bud",
            () -> new PyriteClusterBlock(4, 3, BlockBehaviour.Properties.copy(Blocks.MEDIUM_AMETHYST_BUD).sound(SoundType.MEDIUM_AMETHYST_BUD).lightLevel((pLightEmission) -> 3)));
    public static final RegistryObject<Block> SMALL_PYRITE_BUD = registerBlock("small_pyrite_bud",
            () -> new PyriteClusterBlock(3, 4, BlockBehaviour.Properties.copy(Blocks.SMALL_AMETHYST_BUD).sound(SoundType.SMALL_AMETHYST_BUD).lightLevel((pLightEmission) -> 2)));


    public static final RegistryObject<Block> BUDDING_RUBY = registerBlock("budding_ruby",
            () -> new BuddingRubyBlock(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK).randomTicks().strength(1.5F).sound(SoundType.AMETHYST).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> RUBY_CLUSTER = registerBlock("ruby_cluster",
            () -> new RubyClusterBlock(7, 3, BlockBehaviour.Properties.copy(Blocks.AMETHYST_CLUSTER).noOcclusion().randomTicks().sound(SoundType.AMETHYST_CLUSTER).strength(1.5F).lightLevel( (pLightEmission) -> 8)));
    public static final RegistryObject<Block> LARGE_RUBY_BUD = registerBlock("large_ruby_bud",
            () -> new RubyClusterBlock(5, 3, BlockBehaviour.Properties.copy(Blocks.LARGE_AMETHYST_BUD).sound(SoundType.LARGE_AMETHYST_BUD).lightLevel((pLightEmission) -> 6)));
    public static final RegistryObject<Block> MEDIUM_RUBY_BUD = registerBlock("medium_ruby_bud",
            () -> new RubyClusterBlock(4, 3, BlockBehaviour.Properties.copy(Blocks.MEDIUM_AMETHYST_BUD).sound(SoundType.MEDIUM_AMETHYST_BUD).lightLevel((pLightEmission) -> 3)));
    public static final RegistryObject<Block> SMALL_RUBY_BUD = registerBlock("small_ruby_bud",
            () -> new RubyClusterBlock(3, 4, BlockBehaviour.Properties.copy(Blocks.SMALL_AMETHYST_BUD).sound(SoundType.SMALL_AMETHYST_BUD).lightLevel((pLightEmission) -> 2)));


    public static final RegistryObject<Block> BUDDING_TOPAZ = registerBlock("budding_topaz",
            () -> new BuddingTopazBlock(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK).randomTicks().strength(1.5F).sound(SoundType.AMETHYST).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> TOPAZ_CLUSTER = registerBlock("topaz_cluster",
            () -> new TopazClusterBlock(7, 3, BlockBehaviour.Properties.copy(Blocks.AMETHYST_CLUSTER).noOcclusion().randomTicks().sound(SoundType.AMETHYST_CLUSTER).strength(1.5F).lightLevel( (pLightEmission) -> 8)));
    public static final RegistryObject<Block> LARGE_TOPAZ_BUD = registerBlock("large_topaz_bud",
            () -> new TopazClusterBlock(5, 3, BlockBehaviour.Properties.copy(Blocks.LARGE_AMETHYST_BUD).sound(SoundType.LARGE_AMETHYST_BUD).lightLevel((pLightEmission) -> 6)));
    public static final RegistryObject<Block> MEDIUM_TOPAZ_BUD = registerBlock("medium_topaz_bud",
            () -> new TopazClusterBlock(4, 3, BlockBehaviour.Properties.copy(Blocks.MEDIUM_AMETHYST_BUD).sound(SoundType.MEDIUM_AMETHYST_BUD).lightLevel((pLightEmission) -> 3)));
    public static final RegistryObject<Block> SMALL_TOPAZ_BUD = registerBlock("small_topaz_bud",
            () -> new TopazClusterBlock(3, 4, BlockBehaviour.Properties.copy(Blocks.SMALL_AMETHYST_BUD).sound(SoundType.SMALL_AMETHYST_BUD).lightLevel((pLightEmission) -> 2)));


    public static final RegistryObject<Block> BUDDING_SPECTROLITE = registerBlock("budding_spectrolite",
            () -> new BuddingSpectroliteBlock(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK).randomTicks().strength(1.5F).sound(SoundType.AMETHYST).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SPECTROLITE_CLUSTER = registerBlock("spectrolite_cluster",
            () -> new SpectroliteClusterBlock(7, 3, BlockBehaviour.Properties.copy(Blocks.AMETHYST_CLUSTER).noOcclusion().randomTicks().sound(SoundType.AMETHYST_CLUSTER).strength(1.5F).lightLevel( (pLightEmission) -> 8)));
    public static final RegistryObject<Block> LARGE_SPECTROLITE_BUD = registerBlock("large_spectrolite_bud",
            () -> new SpectroliteClusterBlock(5, 3, BlockBehaviour.Properties.copy(Blocks.LARGE_AMETHYST_BUD).sound(SoundType.LARGE_AMETHYST_BUD).lightLevel((pLightEmission) -> 6)));
    public static final RegistryObject<Block> MEDIUM_SPECTROLITE_BUD = registerBlock("medium_spectrolite_bud",
            () -> new SpectroliteClusterBlock(4, 3, BlockBehaviour.Properties.copy(Blocks.MEDIUM_AMETHYST_BUD).sound(SoundType.MEDIUM_AMETHYST_BUD).lightLevel((pLightEmission) -> 3)));
    public static final RegistryObject<Block> SMALL_SPECTROLITE_BUD = registerBlock("small_spectrolite_bud",
            () -> new SpectroliteClusterBlock(3, 4, BlockBehaviour.Properties.copy(Blocks.SMALL_AMETHYST_BUD).sound(SoundType.SMALL_AMETHYST_BUD).lightLevel((pLightEmission) -> 2)));


    public static final RegistryObject<Block> BUDDING_UNAKITE = registerBlock("budding_unakite",
            () -> new BuddingUnakiteBlock(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK).randomTicks().strength(1.5F).sound(SoundType.AMETHYST).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> UNAKITE_CLUSTER = registerBlock("unakite_cluster",
            () -> new UnakiteClusterBlock(7, 3, BlockBehaviour.Properties.copy(Blocks.AMETHYST_CLUSTER).noOcclusion().randomTicks().sound(SoundType.AMETHYST_CLUSTER).strength(1.5F).lightLevel( (pLightEmission) -> 8)));
    public static final RegistryObject<Block> LARGE_UNAKITE_BUD = registerBlock("large_unakite_bud",
            () -> new UnakiteClusterBlock(5, 3, BlockBehaviour.Properties.copy(Blocks.LARGE_AMETHYST_BUD).sound(SoundType.LARGE_AMETHYST_BUD).lightLevel((pLightEmission) -> 6)));
    public static final RegistryObject<Block> MEDIUM_UNAKITE_BUD = registerBlock("medium_unakite_bud",
            () -> new UnakiteClusterBlock(4, 3, BlockBehaviour.Properties.copy(Blocks.MEDIUM_AMETHYST_BUD).sound(SoundType.MEDIUM_AMETHYST_BUD).lightLevel((pLightEmission) -> 3)));
    public static final RegistryObject<Block> SMALL_UNAKITE_BUD = registerBlock("small_unakite_bud",
            () -> new UnakiteClusterBlock(3, 4, BlockBehaviour.Properties.copy(Blocks.SMALL_AMETHYST_BUD).sound(SoundType.SMALL_AMETHYST_BUD).lightLevel((pLightEmission) -> 2)));*/

    //public static final RegistryObject<Block> AVENTURIA_PORTAL = registerBlockWithoutBlockItem("aventurine_portal", AventuriaPortalBlock::new);

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
