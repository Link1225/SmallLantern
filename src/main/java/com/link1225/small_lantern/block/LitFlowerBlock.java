package com.link1225.small_lantern.block;

import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class LitFlowerBlock extends FlowerBlock {
    public LitFlowerBlock(FlowerBlock flowerBlock) {
        super(flowerBlock.m_53521_(), flowerBlock.m_53522_(), BlockBehaviour.Properties.copy(flowerBlock).lightLevel(state -> 15));
    }
}
