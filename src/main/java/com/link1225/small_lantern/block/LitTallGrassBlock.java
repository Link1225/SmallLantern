package com.link1225.small_lantern.block;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.TallGrassBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class LitTallGrassBlock extends TallGrassBlock implements ILitBLock {
    public LitTallGrassBlock() {
        super(BlockBehaviour.Properties.copy(Blocks.GRASS).lightLevel(state -> 15));
    }
}
