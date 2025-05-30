package com.link1225.small_lantern.event;

import com.link1225.small_lantern.item.SmallLanternItem; // SmallLanternItemをインポート
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public final class ForgeEvent {
    @SubscribeEvent
    public static void onPlayerLoggedOut(PlayerEvent.PlayerLoggedOutEvent event) {
        Player player = event.getEntity();

        if(player.getItemInHand(InteractionHand.MAIN_HAND).getItem() instanceof SmallLanternItem smallLanternItem) {
            smallLanternItem.extinguishPreviousBlock(player.level());
        }
    }
}