package com.million.client.mofumaru.client;

import com.million.client.mofumaru.client.model.ModModelLayers;
import com.million.client.mofumaru.client.renderer.MofumaruRenderer;
import com.million.mofumaru.registry.ModEntities;
import net.minecraft.client.renderer.entity.EntityRenderers;

public final class ModClientEntities {
	private ModClientEntities() {
	}

	/** Call this once from your ClientModInitializer#onInitializeClient. */
	public static void initialize() {
		ModModelLayers.registerModelLayers();
		EntityRenderers.register(ModEntities.MOFUMARU, MofumaruRenderer::new);
	}
}
