package com.million.client;

import net.fabricmc.api.ClientModInitializer;

public class MiliModClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		com.million.client.mofumaru.client.ModClientEntities.initialize();
	}
}