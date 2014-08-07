package com.coastroad.mc.armormod;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class Shapes extends ModelBiped { 
	
	ModelRenderer leftarmShape;
	ModelRenderer rightarmShape;
	ModelRenderer bodyShape1;
	ModelRenderer bodyShape2;
	ModelRenderer leftlegShape;
	ModelRenderer rightlegShape;
	ModelRenderer headShape;

	public Shapes(float f) {
		super(f);
		
		textureWidth = 64;
		textureHeight = 64;
		
		leftarmShape = new ModelRenderer(this, 0, 32);
		leftarmShape.addBox(-1F, -3F, -2.5F, 15, 5, 15);
		leftarmShape.setRotationPoint(5F, 2F, 0F);
		leftarmShape.setTextureSize(64, 64);
		leftarmShape.mirror = true;
		setRotation(leftarmShape, 0F, 0F, 0F);
		
		rightarmShape = new ModelRenderer(this, 20, 32);
		rightarmShape.addBox(-4F, -3F, -2.5F, 2, 12, 2);
		rightarmShape.setRotationPoint(-5F, 2F, 0F);
		rightarmShape.setTextureSize(64, 64);
		rightarmShape.mirror = true;
		setRotation(rightarmShape, 0F, 0F, 0F);
		
		bodyShape1 = new ModelRenderer(this, 4, 42);
		bodyShape1.addBox(-2F, 1F, -3F, 4, 9, 1);
		bodyShape1.setRotationPoint(0F, 0F, 0F);
		bodyShape1.setTextureSize(64, 64);
		bodyShape1.mirror = true;
		setRotation(bodyShape1, 0F, 0F, 0F);
		
		bodyShape2 = new ModelRenderer(this, 14, 42);
		bodyShape2.addBox(-4F, 4F, -2.7F, 8, 2, 1);
		bodyShape2.setRotationPoint(0F, 0F, 0F);
		bodyShape2.setTextureSize(64, 64);
		bodyShape2.mirror = true;
		setRotation(bodyShape2, 0F, 0F, 0F);
		
		leftlegShape = new ModelRenderer(this, 47, 32);
		leftlegShape.addBox(-1F, 0F, -3F, 2, 9, 1);
		leftlegShape.setRotationPoint(2F, 12F, 0F);
		leftlegShape.setTextureSize(64, 64);
		leftlegShape.mirror = true;
		setRotation(leftlegShape, 0F, 0F, 0F);
		
		rightlegShape = new ModelRenderer(this, 41, 32);
		rightlegShape.addBox(-1F, 0F, -3F, 2, 9, 1);
		rightlegShape.setRotationPoint(-2F, 12F, 0F);
		rightlegShape.setTextureSize(64, 64);
		rightlegShape.mirror = true;
		setRotation(rightlegShape, 0F, 0F, 0F);
		
		headShape = new ModelRenderer(this, 0, 42);
		headShape.addBox(-5F, -14F, -4F, 10, 2, 5);
		headShape.setRotationPoint(0F, 0F, 0F);
		headShape.setTextureSize(64, 64);
		headShape.mirror = true;
		setRotation(headShape, 0F, 0F, 0F);
		
		this.bipedHead.addChild(headShape);
		
		this.bipedLeftArm.addChild(leftarmShape);
		this.bipedRightArm.addChild(rightarmShape);
		
		this.bipedLeftLeg.addChild(leftlegShape);
		this.bipedLeftLeg.addChild(rightlegShape);
		
		this.bipedBody.addChild(bodyShape1);
		this.bipedBody.addChild(bodyShape2);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		leftarmShape.render(f5);
		rightarmShape.render(f5);
		bodyShape1.render(f5);
		bodyShape2.render(f5);
		leftlegShape.render(f5);
		rightlegShape.render(f5);
		headShape.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
}
