package com.link1225.small_lantern.item;

import com.link1225.small_lantern.init.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

public class SmallLanternItem extends Item {
    @Nullable
    private BlockPos previousLightBlockPos = null;

    public SmallLanternItem() {
        super(new Properties());
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        super.inventoryTick(stack, level, entity, slotId, isSelected);

        if (!level.isClientSide && entity instanceof Player player) {
            if(!isSelected || player.isDeadOrDying()) {
                removePreviousLightBlock(level);
                return;
            }

            BlockPos currentPos = player.blockPosition();

            if(previousLightBlockPos == currentPos) return;

            removePreviousLightBlock(level, false);

            if (ModBlocks.vanilla2LitBlocksMap.containsValue(ForgeRegistries.BLOCKS.getHolder(level.getBlockState(currentPos).getBlock()))) level.setBlockAndUpdate(currentPos, Blocks.LIGHT.defaultBlockState());

            previousLightBlockPos = currentPos;
        }
    }

    public void removePreviousLightBlock(Level level) {
        removePreviousLightBlock(level, true);
    }

    public void removePreviousLightBlock(Level level, boolean removePrevious) {
        if(previousLightBlockPos == null) return;
        if (level.getBlockState(previousLightBlockPos).getBlock() == Blocks.LIGHT) level.setBlockAndUpdate(previousLightBlockPos, Blocks.AIR.defaultBlockState());
        if(removePrevious) previousLightBlockPos = null;
    }
}