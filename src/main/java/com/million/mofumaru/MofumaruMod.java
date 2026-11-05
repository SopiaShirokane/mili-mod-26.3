package com.million.mofumaru;

import net.minecraft.resources.Identifier;

/** Shared constants for the Mofumaru content. Not a ModInitializer - call ModEntities.initialize() from your own one. */
public final class MofumaruMod {
	public static final String MOD_ID = "mili-mod";

	private MofumaruMod() {
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
