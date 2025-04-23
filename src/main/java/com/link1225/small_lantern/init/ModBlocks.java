package com.link1225.small_lantern.init;

import com.link1225.small_lantern.SmallLanternMod;
import com.link1225.small_lantern.block.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;

public final class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SmallLanternMod.MOD_ID);
    public static final HashMap<Block, RegistryObject<? extends ILitBLock>> vanilla2LitBlocksMap = new HashMap<>();
    public static final HashMap<Block, RegistryObject<? extends ILitBLock>> vanilla2LitSimpleBlocksMap = new HashMap<>();
    public static final HashMap<Block, RegistryObject<? extends LitFlowerBlock>> vanilla2LitFlowerBlockMap = new HashMap<>();

    public static final RegistryObject<ILitBLock> LIT_AIR = registerLitBlock(Blocks.AIR, LitAirBlock::new);
    public static final RegistryObject<ILitBLock> LIT_WATER = registerLitBlock(Blocks.WATER, LitWaterBlock::new);
    public static final RegistryObject<ILitBLock> LIT_GRASS = registerLitBlock(Blocks.GRASS, LitTallGrassBlock::new);
    public static final RegistryObject<ILitBLock> LIT_FERN = registerLitBlock(Blocks.FERN, LitTallGrassBlock::new);
    public static final RegistryObject<ILitBLock> LIT_TALL_GRASS = registerLitBlock(Blocks.TALL_GRASS, LitDoublePlantBlock::new, false);
    public static final RegistryObject<ILitBLock> LIT_LARGE_FERN = registerLitBlock(Blocks.LARGE_FERN, LitDoublePlantBlock::new, false);
    public static final RegistryObject<LitFlowerBlock> LIT_DANDELION = registerLitFlowerBlock(Blocks.DANDELION, LitFlowerBlock::new);
    public static final RegistryObject<LitFlowerBlock> LIT_TORCHFLOWER = registerLitFlowerBlock(Blocks.TORCHFLOWER, LitFlowerBlock::new);
    public static final RegistryObject<LitFlowerBlock> LIT_POPPY = registerLitFlowerBlock(Blocks.POPPY, LitFlowerBlock::new);
    public static final RegistryObject<LitFlowerBlock> LIT_BLUE_ORCHID = registerLitFlowerBlock(Blocks.BLUE_ORCHID, LitFlowerBlock::new);
    public static final RegistryObject<LitFlowerBlock> LIT_ALLIUM = registerLitFlowerBlock(Blocks.ALLIUM, LitFlowerBlock::new);
    public static final RegistryObject<LitFlowerBlock> LIT_AZURE_BLUET = registerLitFlowerBlock(Blocks.AZURE_BLUET, LitFlowerBlock::new);
    public static final RegistryObject<LitFlowerBlock> LIT_RED_TULIP = registerLitFlowerBlock(Blocks.RED_TULIP, LitFlowerBlock::new);
    public static final RegistryObject<LitFlowerBlock> LIT_ORANGE_TULIP = registerLitFlowerBlock(Blocks.ORANGE_TULIP, LitFlowerBlock::new);
    public static final RegistryObject<LitFlowerBlock> LIT_WHITE_TULIP = registerLitFlowerBlock(Blocks.WHITE_TULIP, LitFlowerBlock::new);
    public static final RegistryObject<LitFlowerBlock> LIT_PINK_TULIP = registerLitFlowerBlock(Blocks.PINK_TULIP, LitFlowerBlock::new);
    public static final RegistryObject<LitFlowerBlock> LIT_OXEYE_DAISY = registerLitFlowerBlock(Blocks.OXEYE_DAISY, LitFlowerBlock::new);
    public static final RegistryObject<LitFlowerBlock> LIT_CORNFLOWER = registerLitFlowerBlock(Blocks.CORNFLOWER, LitFlowerBlock::new);

    private static <T extends ILitBLock> RegistryObject<T> registerLitBlock(Block vanillaBlock, Supplier<T> litBlockSup) {
        return registerLitBlock(vanillaBlock, litBlockSup, true);
    }

    private static <T extends ILitBLock> RegistryObject<T> registerLitBlock(Block vanillaBlock, Supplier<T> litBlockSup, boolean isSimpleBlock) {
        RegistryObject<T> toReturn = BLOCKS.register("lit_" + Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(vanillaBlock)).getPath(), litBlockSup);
        vanilla2LitBlocksMap.put(vanillaBlock, toReturn);
        if(isSimpleBlock) vanilla2LitSimpleBlocksMap.put(vanillaBlock, toReturn);

        return toReturn;
    }
    
    private static RegistryObject<LitFlowerBlock> registerLitFlowerBlock(Block vanillaBlock, Function<FlowerBlock, LitFlowerBlock> litBlockFunc) {
        RegistryObject<LitFlowerBlock> toReturn = registerLitBlock(vanillaBlock, () -> litBlockFunc.apply((FlowerBlock) vanillaBlock));
        vanilla2LitFlowerBlockMap.put(vanillaBlock, toReturn);

        return toReturn;
    }
}
