package com.million.client;

import com.million.ModItem;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;


public class MiliModModelProvider extends FabricModelProvider{
    public MiliModModelProvider(FabricPackOutput output){
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator){

    }
    
    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator){
        itemModelGenerator.generateFlatItem(ModItem.HAMMER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItem.IRON_DUST, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItem.GOLD_DUST, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItem.COPPER_DUST, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItem.GRAY_WHITE_GOLD_DUST, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItem.GRAY_WHITE_GOLD_INGOT, ModelTemplates.FLAT_ITEM);
        //itemModelGenerator.generateFlatItem(ModItem.IRON_DUST, ModelTemplates.FLAT_ITEM);
        //itemModelGenerator.generateFlatItem(ModItem.IRON_DUST, ModelTemplates.FLAT_ITEM);
    }

    @Override
    public String getName(){
        return "MiliModModelProvider";
    }
}