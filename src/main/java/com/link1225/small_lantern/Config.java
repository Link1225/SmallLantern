package com.link1225.small_lantern;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mod.EventBusSubscriber(modid = SmallLanternMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config
{
    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {

    }
}
