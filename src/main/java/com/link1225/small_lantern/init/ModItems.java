package com.link1225.small_lantern.init;

import com.link1225.small_lantern.SmallLanternMod;
import com.link1225.small_lantern.item.SmallLanternItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SmallLanternMod.MOD_ID);

    public static final RegistryObject<Item> SMALL_LANTERN = ITEMS.register("small_lantern", SmallLanternItem::new);
}