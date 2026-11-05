package com.million.client.mofumaru.client.model;

import com.million.client.mofumaru.client.state.MofumaruRenderState;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;

/** Generated from mofumaru.bbmodel (64x64 texture, Mojang mappings). */
public class MofumaruModel extends EntityModel<MofumaruRenderState> {
	private static final float EAR_TILT = 12.0f * Mth.DEG_TO_RAD;

	private final ModelPart earLeft;
	private final ModelPart earRight;
	private final ModelPart legFrontLeft;
	private final ModelPart legFrontRight;
	private final ModelPart legBackLeft;
	private final ModelPart legBackRight;

	public MofumaruModel(ModelPart root) {
		super(root);
		this.earLeft = root.getChild("ear_left");
		this.earRight = root.getChild("ear_right");
		this.legFrontLeft = root.getChild("leg_front_left");
		this.legFrontRight = root.getChild("leg_front_right");
		this.legBackLeft = root.getChild("leg_back_left");
		this.legBackRight = root.getChild("leg_back_right");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition mesh = new MeshDefinition();
		PartDefinition root = mesh.getRoot();

		// Fluffy body: three overlapping boxes give a rounded silhouette. The face is painted on the front plate.
		root.addOrReplaceChild("body",
				CubeListBuilder.create()
						.texOffs(0, 0).addBox(-6.0f, -11.5f, -5.0f, 12.0f, 8.0f, 10.0f)
						.texOffs(0, 18).addBox(-5.0f, -12.5f, -4.5f, 10.0f, 10.0f, 9.0f)
						.texOffs(0, 37).addBox(-4.5f, -11.0f, -6.0f, 9.0f, 7.0f, 12.0f),
				PartPose.offset(0.0f, 24.0f, 0.0f));

		root.addOrReplaceChild("tail",
				CubeListBuilder.create().texOffs(44, 37).addBox(-1.5f, -7.0f, 6.0f, 3.0f, 3.0f, 2.0f),
				PartPose.offset(0.0f, 24.0f, 0.0f));

		// Ears (left = +X). The right ear has the brown tip.
		root.addOrReplaceChild("ear_left",
				CubeListBuilder.create()
						.texOffs(44, 0).addBox(-1.5f, -2.0f, -1.0f, 3.0f, 2.0f, 2.0f)
						.texOffs(44, 4).addBox(-0.6f, -4.0f, -0.5f, 2.0f, 2.0f, 1.0f),
				PartPose.offsetAndRotation(4.0f, 12.0f, -1.0f, 0.0f, 0.0f, EAR_TILT));
		root.addOrReplaceChild("ear_right",
				CubeListBuilder.create()
						.texOffs(54, 0).addBox(-1.5f, -2.0f, -1.0f, 3.0f, 2.0f, 2.0f)
						.texOffs(50, 4).addBox(-1.4f, -4.0f, -0.5f, 2.0f, 2.0f, 1.0f),
				PartPose.offsetAndRotation(-4.0f, 12.0f, -1.0f, 0.0f, 0.0f, -EAR_TILT));

		// Stubby feet, pivoting at the top.
		root.addOrReplaceChild("leg_front_left",
				CubeListBuilder.create().texOffs(44, 8).addBox(-1.0f, 0.0f, -1.0f, 2.0f, 3.0f, 2.0f),
				PartPose.offset(3.5f, 21.0f, -3.5f));
		root.addOrReplaceChild("leg_front_right",
				CubeListBuilder.create().texOffs(52, 8).addBox(-1.0f, 0.0f, -1.0f, 2.0f, 3.0f, 2.0f),
				PartPose.offset(-3.5f, 21.0f, -3.5f));
		root.addOrReplaceChild("leg_back_left",
				CubeListBuilder.create().texOffs(44, 13).addBox(-1.0f, 0.0f, -1.0f, 2.0f, 3.0f, 2.0f),
				PartPose.offset(3.5f, 21.0f, 3.5f));
		root.addOrReplaceChild("leg_back_right",
				CubeListBuilder.create().texOffs(52, 13).addBox(-1.0f, 0.0f, -1.0f, 2.0f, 3.0f, 2.0f),
				PartPose.offset(-3.5f, 21.0f, 3.5f));

		return LayerDefinition.create(mesh, 64, 64);
	}

	@Override
	public void setupAnim(MofumaruRenderState state) {
		super.setupAnim(state);

		// Walk cycle: diagonal pairs swing together.
		float pos = state.walkAnimationPos * 0.6662f;
		float amp = 1.4f * state.walkAnimationSpeed;
		this.legFrontLeft.xRot = Mth.cos(pos) * amp;
		this.legBackRight.xRot = Mth.cos(pos) * amp;
		this.legFrontRight.xRot = Mth.cos(pos + Mth.PI) * amp;
		this.legBackLeft.xRot = Mth.cos(pos + Mth.PI) * amp;

		// Gentle idle ear flop.
		float flop = Mth.sin(state.ageInTicks * 0.1f) * 0.05f;
		this.earLeft.zRot = EAR_TILT + flop;
		this.earRight.zRot = -EAR_TILT - flop;
	}
}
