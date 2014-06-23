package fr.elias.fakeores.client;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelNopeGuy extends ModelBase 
{
	// fields
	ModelRenderer head;
	ModelRenderer body;
	ModelRenderer rightarm;
	ModelRenderer leftarm;
	ModelRenderer rightleg;
	ModelRenderer leftleg;
	ModelRenderer hair1;
	ModelRenderer hair2;
	ModelRenderer hair3;

	public ModelNopeGuy() {
		textureWidth = 64;
		textureHeight = 32;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-4F, -8F, -3F, 8, 8, 6);
		head.setRotationPoint(0F, 4F, 0F);
		head.setTextureSize(64, 32);
		head.mirror = true;
		setRotation(head, 0F, 0F, 0F);
		body = new ModelRenderer(this, 8, 16);
		body.addBox(-2F, 0F, -1F, 4, 12, 2);
		body.setRotationPoint(0F, 4F, 0F);
		body.setTextureSize(64, 32);
		body.mirror = true;
		setRotation(body, 0F, 0F, 0F);
		rightarm = new ModelRenderer(this, 20, 16);
		rightarm.addBox(-1F, -2F, -1F, 2, 12, 2);
		rightarm.setRotationPoint(-3F, 6F, 0F);
		rightarm.setTextureSize(64, 32);
		rightarm.mirror = true;
		setRotation(rightarm, 0F, 0F, 0F);
		leftarm = new ModelRenderer(this, 20, 16);
		leftarm.addBox(-1F, -2F, -1F, 2, 12, 2);
		leftarm.setRotationPoint(3F, 6F, 0F);
		leftarm.setTextureSize(64, 32);
		leftarm.mirror = true;
		setRotation(leftarm, 0F, 0F, 0F);
		rightleg = new ModelRenderer(this, 0, 16);
		rightleg.addBox(-1F, 0F, -1F, 2, 8, 2);
		rightleg.setRotationPoint(-1F, 16F, 0F);
		rightleg.setTextureSize(64, 32);
		rightleg.mirror = true;
		setRotation(rightleg, 0F, 0F, 0F);
		leftleg = new ModelRenderer(this, 0, 16);
		leftleg.addBox(-1F, 0F, -1F, 2, 8, 2);
		leftleg.setRotationPoint(1F, 16F, 0F);
		leftleg.setTextureSize(64, 32);
		leftleg.mirror = true;
		setRotation(leftleg, 0F, 0F, 0F);
		hair1 = new ModelRenderer(this, 28, 0);
		hair1.addBox(-4F, -1F, -3F, 8, 1, 6);
		hair1.setRotationPoint(0F, -8F, 0F);
		hair1.setTextureSize(64, 32);
		hair1.mirror = true;
		setRotation(hair1, 0F, 0F, 0F);
		hair2 = new ModelRenderer(this, 38, 5);
		hair2.addBox(-1F, -0.4F, -1F, 3, 1, 1);
		hair2.setRotationPoint(0F, -0F, -3F);
		hair2.setTextureSize(64, 32);
		hair2.mirror = true;
		setRotation(hair2, 0F, 0F, 0F);
		hair3 = new ModelRenderer(this, 39, 5);
		hair3.addBox(0F, -0.5F, -1F, 2, 1, 1);
		hair3.setRotationPoint(1F, -0.8F, 0F);
		hair3.setTextureSize(64, 32);
		hair3.mirror = true;
		setRotation(hair3, 0F, 0F, 0F);
		head.addChild(hair1);
		hair1.addChild(hair2);
		hair2.addChild(hair3);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) 
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		head.render(f5);
		body.render(f5);
		rightarm.render(f5);
		leftarm.render(f5);
		rightleg.render(f5);
		leftleg.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	  public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity)
	  {
		 this.head.rotateAngleY = par4 / (180F / (float)Math.PI);
		 this.head.rotateAngleX = par5 / (180F / (float)Math.PI);
		 this.rightarm.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 2.0F * par2 * 0.5F;
		 this.leftarm.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 2.0F * par2 * 0.5F;
		 this.rightarm.rotateAngleZ = 0.0F;
		 this.leftarm.rotateAngleZ = 0.0F;
		 this.rightleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
		 this.leftleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
		 this.rightleg.rotateAngleY = 0.0F;
		 this.leftleg.rotateAngleY = 0.0F;
		 this.rightarm.rotateAngleY = 0.0F;
		 this.leftarm.rotateAngleY = 0.0F;
		 float f6;
		 float f7;
		 if (this.onGround > -9990.0F)
		 {
			 f6 = this.onGround;
			 this.body.rotateAngleY = MathHelper.sin(MathHelper.sqrt_float(f6) * (float)Math.PI * 2.0F) * 0.2F;
			 this.rightarm.rotateAngleY += this.body.rotateAngleY;
			 this.leftarm.rotateAngleY += this.body.rotateAngleY;
			 this.leftarm.rotateAngleX += this.body.rotateAngleY;
			 f6 = 1.0F - this.onGround;
			 f6 *= f6;
			 f6 *= f6;
			 f6 = 1.0F - f6;
			 f7 = MathHelper.sin(f6 * (float)Math.PI);
			 float f8 = MathHelper.sin(this.onGround * (float)Math.PI) * -(this.head.rotateAngleX - 0.7F) * 0.75F;
			 this.rightarm.rotateAngleX = (float)((double)this.rightarm.rotateAngleX - ((double)f7 * 1.2D + (double)f8));
			 this.rightarm.rotateAngleY += this.body.rotateAngleY * 2.0F;
			 this.rightarm.rotateAngleZ = MathHelper.sin(this.onGround * (float)Math.PI) * -0.4F;
		 }
		 
	        this.rightarm.rotateAngleZ += MathHelper.cos(par3 * 0.09F) * 0.05F + 0.05F;
	        this.leftarm.rotateAngleZ -= MathHelper.cos(par3 * 0.09F) * 0.05F + 0.05F;
	        this.rightarm.rotateAngleX += MathHelper.sin(par3 * 0.067F) * 0.05F;
	        this.leftarm.rotateAngleX -= MathHelper.sin(par3 * 0.067F) * 0.05F;
	        
	     
	}

}