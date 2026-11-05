package com.million.client.mofumaru.client.renderer;

import com.million.mofumaru.MofumaruMod;
import com.million.client.mofumaru.client.model.MofumaruModel;
import com.million.client.mofumaru.client.model.ModModelLayers;
import com.million.client.mofumaru.client.state.MofumaruRenderState;
import com.million.mofumaru.entity.MofumaruEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;

public class MofumaruRenderer extends MobRenderer<MofumaruEntity, MofumaruRenderState, MofumaruModel> {
	private static final Identifier TEXTURE = MofumaruMod.id("textures/entity/mofumaru.png");

	public MofumaruRenderer(EntityRendererProvider.Context context) {
		super(context, new MofumaruModel(context.bakeLayer(ModModelLayers.MOFUMARU)), 0.4f);
	}

	@Override
	public MofumaruRenderState createRenderState() {
		return new MofumaruRenderState();
	}

	@Override
	public Identifier getTextureLocation(MofumaruRenderState state) {
		return TEXTURE;
	}
}
