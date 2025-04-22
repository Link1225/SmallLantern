package com.link1225.small_lantern.init;

import com.link1225.small_lantern.SmallLanternMod;
import com.link1225.small_lantern.datagen.ModBlockModelProvider;
import com.link1225.small_lantern.datagen.ModBlockStateProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SmallLanternMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class ModDatagens {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        generator.addProvider(event.includeClient(), new ModBlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new ModBlockModelProvider(packOutput, existingFileHelper));
    }
}
