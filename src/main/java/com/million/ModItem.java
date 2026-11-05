package com.million;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.level.block.Block;


public class ModItem {
    public static final TagKey<Item> REPAIRS_MILLION_ARMOR = TagKey.create(BuiltInRegistries.ITEM.key(), MiliMod.id("repairs_million_armor"));
    public static final TagKey<Block> INCORRECT_FOR_MILLION_TOOL = TagKey.create(Registries.BLOCK, MiliMod.id("incorrect_for_million_tool"));

    public static final ToolMaterial MILLION_TOOL_MATERIAL = new ToolMaterial(INCORRECT_FOR_MILLION_TOOL, 3264, 10.0F, 1.5F, 50, REPAIRS_MILLION_ARMOR);

    public static final Item MILLION_ALLOY = ModItemIds.register(ModItemIds.MILLION_ALLOY, Item::new, new Item.Properties());
    public static final Item NUHU_COLOR_WHEEL = ModItemIds.register(ModItemIds.NUHU_COLOR_WHEEL, Item::new, new Item.Properties());
    public static final Item NUHU_DRAWING_PEN = ModItemIds.register(ModItemIds.NUHU_DRAWING_PEN, Item::new, new Item.Properties().spear(MILLION_TOOL_MATERIAL, 2.8f, 1.5f, 1.4f, 1.1f, 2.0f, 1.1f, 0.15f, 0.25f, 0.45f));
    public static final Item KONOMI_CHOCOLATE_BAR = ModItemIds.register(ModItemIds.KONOMI_CHOCOLATE_BAR, Item::new, new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationModifier(3).build()));

    public static void initialize(){
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register((creativeTab) -> {
            creativeTab.accept(ModItem.MILLION_ALLOY);
            creativeTab.accept(ModItem.NUHU_COLOR_WHEEL);
        });
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register((creativeTab) -> {
            creativeTab.accept(ModItem.NUHU_DRAWING_PEN);
        });
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FOOD_AND_DRINKS).register((creativeTab) -> {
            creativeTab.accept(ModItem.KONOMI_CHOCOLATE_BAR);
        });
    }
}


