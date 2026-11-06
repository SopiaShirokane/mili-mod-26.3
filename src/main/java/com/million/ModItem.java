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

    public static final ToolMaterial MILLION_TOOL_MATERIAL = new ToolMaterial(INCORRECT_FOR_MILLION_TOOL, 3264, 10.0F, 5F, 50, REPAIRS_MILLION_ARMOR);

    public static final Item MILLION_ALLOY = ModItemIds.register(ModItemIds.MILLION_ALLOY, Item::new, new Item.Properties());
    public static final Item NUHU_COLOR_WHEEL = ModItemIds.register(ModItemIds.NUHU_COLOR_WHEEL, Item::new, new Item.Properties());
    public static final Item NUHU_DRAWING_PEN = ModItemIds.register(ModItemIds.NUHU_DRAWING_PEN, Item::new, new Item.Properties().spear(MILLION_TOOL_MATERIAL, 1.5f, 2.9f, 0.4f, 0.4f, 0.5f, 0.5f, 5f, 5f, 5f));
    public static final Item KONOMI_CHOCOLATE_BAR = ModItemIds.register(ModItemIds.KONOMI_CHOCOLATE_BAR, Item::new, new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationModifier(3).build()));
    public static final Item HAMMER = ModItemIds.register(ModItemIds.HAMMER, Item::new, new Item.Properties());
    public static final Item IRON_DUST = ModItemIds.register(ModItemIds.IRON_DUST, Item::new, new Item.Properties());
    public static final Item GOLD_DUST = ModItemIds.register(ModItemIds.GOLD_DUST, Item::new, new Item.Properties());
    public static final Item COPPER_DUST = ModItemIds.register(ModItemIds.COPPER_DUST, Item::new, new Item.Properties());
    public static final Item GRAY_WHITE_GOLD_DUST = ModItemIds.register(ModItemIds.GRAY_WHITE_GOLD_DUST, Item::new, new Item.Properties());
    public static final Item GRAY_WHITE_GOLD_INGOT = ModItemIds.register(ModItemIds.GRAY_WHITE_GOLD_INGOT, Item::new, new Item.Properties());

    public static void initialize(){
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register((creativeTab) -> {
            creativeTab.accept(ModItem.MILLION_ALLOY);
            creativeTab.accept(ModItem.NUHU_COLOR_WHEEL);
            creativeTab.accept(ModItem.IRON_DUST);
            creativeTab.accept(ModItem.GOLD_DUST);
            creativeTab.accept(ModItem.COPPER_DUST);
            creativeTab.accept(ModItem.GRAY_WHITE_GOLD_DUST);
        });
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register((creativeTab) -> {
            creativeTab.accept(ModItem.NUHU_DRAWING_PEN);
        });
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FOOD_AND_DRINKS).register((creativeTab) -> {
            creativeTab.accept(ModItem.KONOMI_CHOCOLATE_BAR);
        });
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register((creativeTab) -> {
            creativeTab.accept(ModItem.HAMMER);
        });
    }
}


