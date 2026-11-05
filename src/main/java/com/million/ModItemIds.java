package com.million;

import java.util.function.Function;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

public class ModItemIds {
    public static final ResourceKey<Item> MILLION_ALLOY = create("million_alloy");
    public static final ResourceKey<Item> NUHU_COLOR_WHEEL = create("nuhu_color_wheel");
    public static final ResourceKey<Item> NUHU_DRAWING_PEN = create("nuhu_drawing_pen");
    public static final ResourceKey<Item> KONOMI_CHOCOLATE_BAR = create("konomi_chocolate_bar");

    public static ResourceKey<Item> create(String name){
        return ResourceKey.create(Registries.ITEM, MiliMod.id(name));
    }

    public static Item register(ResourceKey<Item> itemKey, Function<Item.Properties, Item> itemFactory, Item.Properties settings){
        Item item = itemFactory.apply(settings.setId(itemKey));
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);
        return item;
    }
}
