package com.link1225.small_lantern.block;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Fluids;

public class LitWaterBlock extends LiquidBlock {
    public LitWaterBlock() {
        super(Fluids.WATER, BlockBehaviour.Properties.copy(Blocks.WATER).lightLevel(state -> 15));
    }
}
