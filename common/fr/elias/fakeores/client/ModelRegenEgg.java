package fr.elias.fakeores.client;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelRegenEgg extends ModelBase
{
	  //fields
	    ModelRenderer eggbase;
	    ModelRenderer eggbottom;
	    ModelRenderer eggface;
	    ModelRenderer eggface2;
	    ModelRenderer eggback;
	    ModelRenderer eggback2;
	    ModelRenderer eggright2;
	    ModelRenderer eggright;
	    ModelRenderer eggleft;
	    ModelRenderer eggleft2;
	    ModelRenderer eggtop;
	    ModelRenderer eggtop2;
	  
	  public ModelRegenEgg()
	  {
	    textureWidth = 26;
	    textureHeight = 14;
	    
	      eggbase = new ModelRenderer(this, 0, 0);
	      eggbase.addBox(-4F, -4F, -3F, 7, 8, 6);
	      eggbase.setRotationPoint(0F, 19F, 0F);
	      eggbase.setTextureSize(26, 14);
	      eggbase.mirror = true;
	      setRotation(eggbase, 0F, 0F, 0F);
	      eggbottom = new ModelRenderer(this, 0, 0);
	      eggbottom.addBox(-3F, 0F, -2F, 5, 1, 4);
	      eggbottom.setRotationPoint(0F, 23F, 0F);
	      eggbottom.setTextureSize(26, 14);
	      eggbottom.mirror = true;
	      setRotation(eggbottom, 0F, 0F, 0F);
	      eggface = new ModelRenderer(this, 0, 0);
	      eggface.addBox(-3F, -3.5F, -1F, 6, 7, 1);
	      eggface.setRotationPoint(-0.5F, 19F, -3F);
	      eggface.setTextureSize(26, 14);
	      eggface.mirror = true;
	      setRotation(eggface, 0F, 0F, 0F);
	      eggface2 = new ModelRenderer(this, 0, 0);
	      eggface2.addBox(-2.5F, -3F, -1F, 5, 6, 1);
	      eggface2.setRotationPoint(-0.5F, 19F, -4F);
	      eggface2.setTextureSize(26, 14);
	      eggface2.mirror = true;
	      setRotation(eggface2, 0F, 0F, 0F);
	      eggback = new ModelRenderer(this, 0, 0);
	      eggback.addBox(-3F, -3.5F, 0F, 6, 7, 1);
	      eggback.setRotationPoint(-0.5F, 19F, 3F);
	      eggback.setTextureSize(26, 14);
	      eggback.mirror = true;
	      setRotation(eggback, 0F, 0F, 0F);
	      eggback2 = new ModelRenderer(this, 0, 0);
	      eggback2.addBox(-2.5F, -3F, 0F, 5, 6, 1);
	      eggback2.setRotationPoint(-0.5F, 19F, 4F);
	      eggback2.setTextureSize(26, 14);
	      eggback2.mirror = true;
	      setRotation(eggback2, 0F, 0F, 0F);
	      eggright2 = new ModelRenderer(this, 0, 0);
	      eggright2.addBox(-2F, -3F, -1F, 4, 6, 1);
	      eggright2.setRotationPoint(-5F, 19F, 0F);
	      eggright2.setTextureSize(26, 14);
	      eggright2.mirror = true;
	      setRotation(eggright2, 0F, 1.570796F, 0F);
	      eggright = new ModelRenderer(this, 0, 0);
	      eggright.addBox(-2.5F, -3.5F, 0F, 5, 7, 1);
	      eggright.setRotationPoint(-4F, 19F, 0F);
	      eggright.setTextureSize(26, 14);
	      eggright.mirror = true;
	      setRotation(eggright, 0F, -1.570796F, 0F);
	      eggleft = new ModelRenderer(this, 0, 0);
	      eggleft.addBox(-2.5F, -3.5F, -1F, 5, 7, 1);
	      eggleft.setRotationPoint(3F, 19F, 0F);
	      eggleft.setTextureSize(26, 14);
	      eggleft.mirror = true;
	      setRotation(eggleft, 0F, -1.570796F, 0F);
	      eggleft2 = new ModelRenderer(this, 0, 0);
	      eggleft2.addBox(-2F, -3F, 0F, 4, 6, 1);
	      eggleft2.setRotationPoint(4F, 19F, 0F);
	      eggleft2.setTextureSize(26, 14);
	      eggleft2.mirror = true;
	      setRotation(eggleft2, 0F, 1.570796F, 0F);
	      eggtop = new ModelRenderer(this, 0, 0);
	      eggtop.addBox(-3F, -1F, -2.5F, 6, 1, 5);
	      eggtop.setRotationPoint(-0.5F, 15F, 0F);
	      eggtop.setTextureSize(26, 14);
	      eggtop.mirror = true;
	      setRotation(eggtop, 0F, 0F, 0F);
	      eggtop2 = new ModelRenderer(this, 0, 0);
	      eggtop2.addBox(-3F, -1F, -2.5F, 5, 1, 4);
	      eggtop2.setRotationPoint(0F, 14F, 0.5F);
	      eggtop2.setTextureSize(26, 14);
	      eggtop2.mirror = true;
	      setRotation(eggtop2, 0F, 0F, 0F);
	  }
	  
	  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	  {
	    super.render(entity, f, f1, f2, f3, f4, f5);
	    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	    eggbase.render(f5);
	    eggbottom.render(f5);
	    eggface.render(f5);
	    eggface2.render(f5);
	    eggback.render(f5);
	    eggback2.render(f5);
	    eggright2.render(f5);
	    eggright.render(f5);
	    eggleft.render(f5);
	    eggleft2.render(f5);
	    eggtop.render(f5);
	    eggtop2.render(f5);
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