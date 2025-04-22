package com.link1225.small_lantern.datagen;

import com.link1225.small_lantern.SmallLanternMod;
import com.link1225.small_lantern.init.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Map;
import java.util.Objects;

public final class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, SmallLanternMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        for(Map.Entry<Block, RegistryObject<? extends Block>> vanilla2LitBlockEntry : ModBlocks.vanilla2LitSimpleBlocksMap.entrySet()) {
            simpleBlock(vanilla2LitBlockEntry.getValue().get(), models().getExistingFile(ResourceLocation.tryParse("block/" + Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(vanilla2LitBlockEntry.getKey())).getPath())));
        }
    }
}
