package com.link1225.small_lantern.item;

import com.link1225.small_lantern.init.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
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
                extinguishPreviousBlock(level);
                return;
            }

            BlockPos currentPos = player.blockPosition();

            if(currentPos.equals(previousLightBlockPos)) return;

            extinguishPreviousBlock(level);
            lightBLock(level, currentPos);
        }
    }

    public void lightBLock(Level level, BlockPos pos) {
        Block currentBLock = level.getBlockState(pos).getBlock();

        if (!ModBlocks.vanilla2LitBlocksMap.containsKey(currentBLock)) return;

        level.setBlockAndUpdate(pos, ModBlocks.vanilla2LitBlocksMap.get(currentBLock).get().defaultBlockState());
        previousLightBlockPos = pos;
    }

    public void extinguishPreviousBlock(Level level) {
        if(previousLightBlockPos == null) return;

        RegistryObject<Block> previousBlock = RegistryObject.create(ForgeRegistries.BLOCKS.getKey(level.getBlockState(previousLightBlockPos).getBlock()), ForgeRegistries.BLOCKS);

        if (!ModBlocks.lit2VanillaBlocksMap.containsKey(previousBlock)) return;

        level.setBlockAndUpdate(previousLightBlockPos, ModBlocks.lit2VanillaBlocksMap.get(previousBlock).defaultBlockState());
        previousLightBlockPos = null;
    }
}