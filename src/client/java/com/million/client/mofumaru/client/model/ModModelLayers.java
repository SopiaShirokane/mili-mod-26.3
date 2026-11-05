package com.million.client.mofumaru.client.model;

import com.million.mofumaru.MofumaruMod;
import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.minecraft.client.model.geom.ModelLayerLocation;

public final class ModModelLayers {
	public static final ModelLayerLocation MOFUMARU = new ModelLayerLocation(MofumaruMod.id("mofumaru"), "main");

	private ModModelLayers() {
	}

	public static void registerModelLayers() {
		ModelLayerRegistry.registerModelLayer(MOFUMARU, MofumaruModel::createBodyLayer);
	}
}
