package fr.elias.fakeores.client;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSwimmerAnimal extends ModelBase
{
	//fields
	ModelRenderer body;
	ModelRenderer head;
	ModelRenderer rightleg1;
	ModelRenderer rightleg2;
	ModelRenderer leftleg1;
	ModelRenderer leftleg2;
	ModelRenderer tail1;
	ModelRenderer tail2;
	ModelRenderer tail3;
	ModelRenderer tail4;
	ModelRenderer tail5;
	ModelRenderer tail6;
	ModelRenderer cross;  
	public ModelSwimmerAnimal()
	{
	    textureWidth = 24;
	    textureHeight = 13;
	    
	      body = new ModelRenderer(this, 0, 0);
	      body.addBox(-2F, -1F, -2.5F, 4, 3, 5);
	      body.setRotationPoint(0F, 22F, 0F);
	      body.setTextureSize(24, 13);
	      body.mirror = true;
	      setRotation(body, 0F, 0F, 0F);
	      head = new ModelRenderer(this, 0, 8);
	      head.addBox(-1F, -0.5F, -1F, 2, 1, 1);
	      head.setRotationPoint(0F, 22.5F, -2.5F);
	      head.setTextureSize(24, 13);
	      head.mirror = true;
	      setRotation(head, 0F, 0F, 0F);
	      rightleg1 = new ModelRenderer(this, 6, 8);
	      rightleg1.addBox(-8F, 0F, -1F, 8, 1, 1);
	      rightleg1.setRotationPoint(-2F, 22F, 0F);
	      rightleg1.setTextureSize(24, 13);
	      rightleg1.mirror = true;
	      setRotation(rightleg1, 0F, -0.7435722F, 0F);
	      rightleg2 = new ModelRenderer(this, 6, 8);
	      rightleg2.addBox(-8F, 0F, 0F, 8, 1, 1);
	      rightleg2.setRotationPoint(-2F, 22F, 0F);
	      rightleg2.setTextureSize(24, 13);
	      rightleg2.mirror = true;
	      setRotation(rightleg2, 0F, 0.7435801F, 0F);
	      leftleg1 = new ModelRenderer(this, 6, 8);
	      leftleg1.addBox(0F, 0F, 0F, 8, 1, 1);
	      leftleg1.setRotationPoint(2F, 22F, 0F);
	      leftleg1.setTextureSize(24, 13);
	      leftleg1.mirror = true;
	      setRotation(leftleg1, 0F, -0.7435722F, 0F);
	      leftleg2 = new ModelRenderer(this, 6, 8);
	      leftleg2.addBox(0F, 0F, -1F, 8, 1, 1);
	      leftleg2.setRotationPoint(2F, 22F, 0F);
	      leftleg2.setTextureSize(24, 13);
	      leftleg2.mirror = true;
	      setRotation(leftleg2, 0F, 0.7435801F, 0F);
	      tail1 = new ModelRenderer(this, 18, 0);
	      tail1.addBox(-1F, 0F, 0F, 2, 1, 1);
	      tail1.setRotationPoint(0F, 22F, 2F);
	      tail1.setTextureSize(24, 13);
	      tail1.mirror = true;
	      setRotation(tail1, 0F, 0F, 0F);
	      tail2 = new ModelRenderer(this, 18, 0);
	      tail2.addBox(-1F, 0F, 0F, 2, 1, 1);
	      tail2.setRotationPoint(0F, 22F, 2.7F);
	      tail2.setTextureSize(24, 13);
	      tail2.mirror = true;
	      setRotation(tail2, 0.2974289F, 0F, 0F);
	      tail3 = new ModelRenderer(this, 18, 0);
	      tail3.addBox(-1F, 0F, 0F, 2, 1, 1);
	      tail3.setRotationPoint(0F, 22F, 3F);
	      tail3.setTextureSize(24, 13);
	      tail3.mirror = true;
	      setRotation(tail3, 0.7435722F, 0F, 0F);
	      tail4 = new ModelRenderer(this, 18, 0);
	      tail4.addBox(-1F, 0F, 0F, 2, 1, 1);
	      tail4.setRotationPoint(0F, 21.2F, 3.7F);
	      tail4.setTextureSize(24, 13);
	      tail4.mirror = true;
	      setRotation(tail4, 0.2602503F, 0F, 0F);
	      tail5 = new ModelRenderer(this, 18, 0);
	      tail5.addBox(-1F, 0F, 0F, 2, 1, 1);
	      tail5.setRotationPoint(0F, 21F, 4.7F);
	      tail5.setTextureSize(24, 13);
	      tail5.mirror = true;
	      setRotation(tail5, -0.2974289F, 0F, 0F);
	      tail6 = new ModelRenderer(this, 18, 2);
	      tail6.addBox(-0.5F, -0.5F, 0F, 1, 1, 2);
	      tail6.setRotationPoint(0F, 21.5F, 5F);
	      tail6.setTextureSize(24, 13);
	      tail6.mirror = true;
	      setRotation(tail6, -1.07818F, 0F, 0F);
	      cross = new ModelRenderer(this, 0, 6);
	      cross.addBox(0F, -3F, -2F, 0, 3, 4);
	      cross.setRotationPoint(0F, 21F, 0F);
	      cross.setTextureSize(24, 13);
	      cross.mirror = true;
	      setRotation(cross, 0F, 0F, 0F);
	}
	  
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
	    super.render(entity, f, f1, f2, f3, f4, f5);
	    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	    body.render(f5);
	    head.render(f5);
	    rightleg1.render(f5);
	    rightleg2.render(f5);
	    leftleg1.render(f5);
	    leftleg2.render(f5);
	    tail1.render(f5);
	    tail2.render(f5);
	    tail3.render(f5);
	    tail4.render(f5);
	    tail5.render(f5);
	    tail6.render(f5);
	    cross.render(f5);
	}
	  
	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
	    model.rotateAngleX = x;
	    model.rotateAngleY = y;
	    model.rotateAngleZ = z;
	}
	  
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
	{
	    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}
}