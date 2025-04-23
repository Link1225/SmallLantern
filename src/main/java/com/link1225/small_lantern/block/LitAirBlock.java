package com.link1225.small_lantern.block;

import net.minecraft.world.level.block.AirBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class LitAirBlock extends AirBlock implements ILitBLock {
    public LitAirBlock() {
        super(BlockBehaviour.Properties.copy(Blocks.AIR).lightLevel(state -> 15));
    }
}