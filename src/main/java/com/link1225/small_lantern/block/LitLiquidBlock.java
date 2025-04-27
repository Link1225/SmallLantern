package com.link1225.small_lantern.block;

import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class LitLiquidBlock extends LiquidBlock {
    public LitLiquidBlock(LiquidBlock block) {
        super(block.getFluid(), BlockBehaviour.Properties.copy(block).lightLevel(state -> 15));
    }
}
