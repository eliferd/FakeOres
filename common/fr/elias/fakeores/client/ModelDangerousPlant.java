package fr.elias.fakeores.client;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelDangerousPlant extends ModelBase
{
	  //fields
	    ModelRenderer mainbranch;
	    ModelRenderer branch1;
	    ModelRenderer branch2;
	    ModelRenderer branch3;
	    ModelRenderer branch4;
	    ModelRenderer mainbranch2;
	    ModelRenderer mainbranch3;
	    ModelRenderer mainbranch4;
	  
	  public ModelDangerousPlant()
	  {
	    textureWidth = 16;
	    textureHeight = 16;
	    
	      mainbranch = new ModelRenderer(this, 0, 0);
	      mainbranch.addBox(-1F, 0F, -1F, 2, 5, 2);
	      mainbranch.setRotationPoint(0F, 20F, 0F);
	      mainbranch.setTextureSize(16, 16);
	      mainbranch.mirror = true;
	      setRotation(mainbranch, -0.2602503F, 0.7435722F, -0.1858931F);
	      branch1 = new ModelRenderer(this, 8, 0);
	      branch1.addBox(-0.5F, -4F, -0.5F, 1, 5, 1);
	      branch1.setRotationPoint(1F, 20F, 0F);
	      branch1.setTextureSize(16, 16);
	      branch1.mirror = true;
	      setRotation(branch1, 0.4089647F, -0.6320364F, 0.9666439F);
	      branch2 = new ModelRenderer(this, 12, 0);
	      branch2.addBox(-0.5F, -1F, -0.5F, 1, 2, 1);
	      branch2.setRotationPoint(0F, 20F, 1F);
	      branch2.setTextureSize(16, 16);
	      branch2.mirror = true;
	      setRotation(branch2, -0.1115358F, -1.561502F, 0.8922867F);
	      branch3 = new ModelRenderer(this, 8, 0);
	      branch3.addBox(-0.5F, -4F, -0.5F, 1, 5, 1);
	      branch3.setRotationPoint(-1F, 20F, 0F);
	      branch3.setTextureSize(16, 16);
	      branch3.mirror = true;
	      setRotation(branch3, 0.6320364F, 2.639681F, 0.7807508F);
	      branch4 = new ModelRenderer(this, 0, 7);
	      branch4.addBox(-0.5F, -4F, -0.5F, 1, 4, 1);
	      branch4.setRotationPoint(4F, 18.4F, 0.7F);
	      branch4.setTextureSize(16, 16);
	      branch4.mirror = true;
	      setRotation(branch4, -0.2602503F, -0.1858931F, -0.3346075F);
	      mainbranch2 = new ModelRenderer(this, 4, 7);
	      mainbranch2.addBox(-0.5F, -7F, -0.5F, 1, 8, 1);
	      mainbranch2.setRotationPoint(-5F, 24F, -6F);
	      mainbranch2.setTextureSize(16, 16);
	      mainbranch2.mirror = true;
	      setRotation(mainbranch2, -0.669215F, 2.714039F, -0.5948578F);
	      mainbranch3 = new ModelRenderer(this, 8, 7);
	      mainbranch3.addBox(-0.5F, -2F, -0.5F, 1, 5, 1);
	      mainbranch3.setRotationPoint(4F, 24F, -3F);
	      mainbranch3.setTextureSize(16, 16);
	      mainbranch3.mirror = true;
	      setRotation(mainbranch3, -1.264073F, 1.115358F, -0.0743572F);
	      mainbranch4 = new ModelRenderer(this, 8, 7);
	      mainbranch4.addBox(-0.5F, -2F, -0.5F, 1, 5, 1);
	      mainbranch4.setRotationPoint(4.5F, 24F, -1F);
	      mainbranch4.setTextureSize(16, 16);
	      mainbranch4.mirror = true;
	      setRotation(mainbranch4, 1.338436F, -0.5205006F, -0.3346075F);
	  }
	  
	  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	  {
	    super.render(entity, f, f1, f2, f3, f4, f5);
	    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	    mainbranch.render(f5);
	    branch1.render(f5);
	    branch2.render(f5);
	    branch3.render(f5);
	    branch4.render(f5);
	    mainbranch2.render(f5);
	    mainbranch3.render(f5);
	    mainbranch4.render(f5);
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
