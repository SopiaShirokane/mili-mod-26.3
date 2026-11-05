package com.million.mofumaru.registry;

import com.million.mofumaru.MofumaruMod;
import com.million.mofumaru.entity.MofumaruEntity;
import net.minecraft.world.item.CreativeModeTabs;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;

public final class ModEntities {
	public static final ResourceKey<EntityType<?>> MOFUMARU_KEY =
			ResourceKey.create(Registries.ENTITY_TYPE, MofumaruMod.id("mofumaru"));

	public static final EntityType<MofumaruEntity> MOFUMARU = Registry.register(
			BuiltInRegistries.ENTITY_TYPE,
			MOFUMARU_KEY,
			EntityType.Builder.<MofumaruEntity>of(MofumaruEntity::new, MobCategory.CREATURE)
					.sized(0.75f, 0.9f)
					.build(MOFUMARU_KEY)
	);

	public static final ResourceKey<Item> MOFUMARU_SPAWN_EGG_KEY =
			ResourceKey.create(Registries.ITEM, MofumaruMod.id("mofumaru_spawn_egg"));

	public static final Item MOFUMARU_SPAWN_EGG = Registry.register(
			BuiltInRegistries.ITEM,
			MOFUMARU_SPAWN_EGG_KEY,
			new SpawnEggItem(new Item.Properties().setId(MOFUMARU_SPAWN_EGG_KEY).spawnEgg(MOFUMARU))
	);

	private ModEntities() {
	}

	/** Call this once from your main ModInitializer#onInitialize. */
	public static void initialize() {
		FabricDefaultAttributeRegistry.register(MOFUMARU, MofumaruEntity.createMofumaruAttributes());

		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.SPAWN_EGGS)
				.register(tab -> tab.accept(MOFUMARU_SPAWN_EGG));
	}
}
