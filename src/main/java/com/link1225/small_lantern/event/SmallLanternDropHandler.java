package com.link1225.small_lantern.event;

import com.link1225.small_lantern.item.SmallLanternItem;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.EntityLeaveLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Mod.EventBusSubscriber
public class SmallLanternDropHandler {
    private static final Map<UUID, BlockPos> litPositions = new HashMap<>();

    @SubscribeEvent
    public static void onEntityJoinWorld(EntityJoinLevelEvent event) {
        if (!event.getLevel().isClientSide() && event.getEntity() instanceof ItemEntity itemEntity) {
            if (itemEntity.getItem().getItem() instanceof SmallLanternItem) {
                BlockPos pos = itemEntity.blockPosition();
                Level level = event.getLevel();
                BlockState state = level.getBlockState(pos);

                if (state.isAir()) {
                    level.setBlockAndUpdate(pos, Blocks.LIGHT.defaultBlockState());
                    litPositions.put(itemEntity.getUUID(), pos);
                }
            }
        }
    }

    @SubscribeEvent
    public static void onEntityLeaveWorld(EntityLeaveLevelEvent event) {
        if (!event.getLevel().isClientSide() && event.getEntity() instanceof ItemEntity itemEntity) {
            UUID entityUUID = itemEntity.getUUID();
            if (litPositions.containsKey(entityUUID)) {
                BlockPos pos = litPositions.get(entityUUID);
                Level level = event.getLevel();
                if (level.getBlockState(pos).getBlock() == Blocks.LIGHT) {
                    level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
                }
                litPositions.remove(entityUUID);
            }
        }
    }
}