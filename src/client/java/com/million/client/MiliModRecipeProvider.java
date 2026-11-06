package com.million.client;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.million.ModItem;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SmithingTransformRecipeBuilder;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;

public class MiliModRecipeProvider extends FabricRecipeProvider {
    public MiliModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

   @Override
   protected RecipeProvider createRecipeProvider(HolderLookup.Provider registryLookup, BootstrapContext<Recipe<?>> recipes, BootstrapContext<Advancement> advancements) {
        return new RecipeProvider(recipes, advancements) {
        @Override
        public void buildRecipes(){
            shapeless(RecipeCategory.MISC, ModItem.IRON_DUST, 2)
                .requires(ModItem.HAMMER)
                .requires(Items.IRON_INGOT)
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .save(output);
            shapeless(RecipeCategory.MISC, ModItem.GOLD_DUST, 2)
                .requires(ModItem.HAMMER)
                .requires(Items.GOLD_INGOT)
                .unlockedBy(getHasName(Items.GOLD_INGOT), has(Items.GOLD_INGOT))
                .save(output);
            shapeless(RecipeCategory.MISC, ModItem.COPPER_DUST, 2)
                .requires(ModItem.HAMMER)
                .requires(Items.COPPER_INGOT)
                .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                .save(output);
            shaped(RecipeCategory.MISC, ModItem.GRAY_WHITE_GOLD_DUST, 7)
                .pattern("ggg")
                .pattern("gii")
                .pattern("c  ")
                .define('g', ModItem.GOLD_DUST)
                .define('i', ModItem.IRON_DUST)
                .define('c', ModItem.COPPER_DUST)
                .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                .save(output);
            SmithingTransformRecipeBuilder.smithing(
                Ingredient.of(ModItem.MILLION_ALLOY),
                Ingredient.of(Items.NETHERITE_SPEAR),
                Ingredient.of(ModItem.NUHU_DRAWING_PEN),
                RecipeCategory.COMBAT,
                ModItem.NUHU_DRAWING_PEN
            );
            oreSmelting(
    		List.of(ModItem.GRAY_WHITE_GOLD_DUST),
	    	RecipeCategory.MISC,
		    CookingBookCategory.MISC,
		    ModItem.GRAY_WHITE_GOLD_INGOT, 
		    0.1f,
		    300,
            ""
);

        }
    };

    }
    @Override
    public String getName() {
        return "MiliModRecipeProvider";
    }
}