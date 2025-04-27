package com.link1225.small_lantern.datagen;

import com.link1225.small_lantern.SmallLanternMod;
import com.link1225.small_lantern.block.LitFlowerBlock;
import com.link1225.small_lantern.init.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Map;
import java.util.Objects;

public final class ModBlockModelProvider extends BlockModelProvider {
    public ModBlockModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, SmallLanternMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        for(Map.Entry<Block, RegistryObject<Block>> vanilla2LitFlowerBlockEntry : ModBlocks.vanilla2LitFlowerBlockMap.entrySet()) {
            cross(vanilla2LitFlowerBlockEntry.getValue().getId().getPath(), ResourceLocation.parse("block/" + Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(vanilla2LitFlowerBlockEntry.getKey())).getPath()));
        }
    }
}
