package com.link1225.small_lantern.init;

import com.link1225.small_lantern.SmallLanternMod;
import com.link1225.small_lantern.block.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.rmi.registry.Registry;
import java.util.HashMap;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;

public final class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SmallLanternMod.MOD_ID);
    public static final HashMap<Block, RegistryObject<? extends Block>> vanilla2LitBlocksMap = new HashMap<>();
    public static final HashMap<Block, RegistryObject<? extends Block>> vanilla2LitSimpleBlocksMap = new HashMap<>();
    public static final HashMap<Block, RegistryObject<LitFlowerBlock>> vanilla2LitFlowerBlockMap = new HashMap<>();

    public static final RegistryObject<Block> LIT_AIR = register(Blocks.AIR, LitAirBlock::new);
    public static final RegistryObject<Block> LIT_WATER = register(Blocks.WATER, LitWaterBlock::new);
    public static final RegistryObject<Block> LIT_GRASS = register(Blocks.GRASS, LitTallGrassBlock::new);
    public static final RegistryObject<Block> LIT_FERN = register(Blocks.FERN, LitTallGrassBlock::new);
    public static final RegistryObject<Block> LIT_TALL_GRASS = register(Blocks.TALL_GRASS, LitDoublePlantBlock::new, false);
    public static final RegistryObject<Block> LIT_LARGE_FERN = register(Blocks.LARGE_FERN, LitDoublePlantBlock::new, false);
    public static final RegistryObject<LitFlowerBlock> LIT_DANDELION = registerFlower(Blocks.DANDELION, LitFlowerBlock::new);
    public static final RegistryObject<LitFlowerBlock> LIT_TORCHFLOWER = registerFlower(Blocks.TORCHFLOWER, LitFlowerBlock::new);
    public static final RegistryObject<LitFlowerBlock> LIT_POPPY = registerFlower(Blocks.POPPY, LitFlowerBlock::new);
    public static final RegistryObject<LitFlowerBlock> LIT_BLUE_ORCHID = registerFlower(Blocks.BLUE_ORCHID, LitFlowerBlock::new);
    public static final RegistryObject<LitFlowerBlock> LIT_ALLIUM = registerFlower(Blocks.ALLIUM, LitFlowerBlock::new);
    public static final RegistryObject<LitFlowerBlock> LIT_AZURE_BLUET = registerFlower(Blocks.AZURE_BLUET, LitFlowerBlock::new);
    public static final RegistryObject<LitFlowerBlock> LIT_RED_TULIP = registerFlower(Blocks.RED_TULIP, LitFlowerBlock::new);
    public static final RegistryObject<LitFlowerBlock> LIT_ORANGE_TULIP = registerFlower(Blocks.ORANGE_TULIP, LitFlowerBlock::new);
    public static final RegistryObject<LitFlowerBlock> LIT_WHITE_TULIP = registerFlower(Blocks.WHITE_TULIP, LitFlowerBlock::new);
    public static final RegistryObject<LitFlowerBlock> LIT_PINK_TULIP = registerFlower(Blocks.PINK_TULIP, LitFlowerBlock::new);
    public static final RegistryObject<LitFlowerBlock> LIT_OXEYE_DAISY = registerFlower(Blocks.OXEYE_DAISY, LitFlowerBlock::new);
    public static final RegistryObject<LitFlowerBlock> LIT_CORNFLOWER = registerFlower(Blocks.CORNFLOWER, LitFlowerBlock::new);

    public static final RegistryObject<LitFlowerBlock> LIT_LILY_OF_THE_VALLEY = registerFlower(Blocks.LILY_OF_THE_VALLEY, LitFlowerBlock::new);

    private static <T extends Block> RegistryObject<T> register(Block vanillaBlock, Supplier<T> litBlockSup) {
        return register(vanillaBlock, litBlockSup, true);
    }

    private static <T extends Block> RegistryObject<T> register(Block vanillaBlock, Supplier<T> litBlockSup, boolean isSimpleBlock) {
        RegistryObject<T> toReturn = BLOCKS.register("lit_" + Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(vanillaBlock)).getPath(), litBlockSup);
        vanilla2LitBlocksMap.put(vanillaBlock, toReturn);
        if(isSimpleBlock) vanilla2LitSimpleBlocksMap.put(vanillaBlock, toReturn);

        return toReturn;
    }
    
    private static RegistryObject<LitFlowerBlock> registerFlower(Block vanillaBlock, Function<FlowerBlock, LitFlowerBlock> litBlockFunc) {
        RegistryObject<LitFlowerBlock> toReturn = register(vanillaBlock, () -> litBlockFunc.apply((FlowerBlock) vanillaBlock));
        vanilla2LitFlowerBlockMap.put(vanillaBlock, toReturn);

        return toReturn;
    }
}
