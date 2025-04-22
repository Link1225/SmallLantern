package com.link1225.small_lantern.block;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class LitDoublePlantBlock extends DoublePlantBlock {
    public LitDoublePlantBlock() {
        super(BlockBehaviour.Properties.copy(Blocks.TALL_GRASS));
    }
}
