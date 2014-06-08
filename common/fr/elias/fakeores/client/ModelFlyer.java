package fr.elias.fakeores.client;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelFlyer extends ModelBase 
{
    ModelRenderer tail1;
    ModelRenderer tail2;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer lefttarm;
    ModelRenderer head;
    ModelRenderer leftwing1;
    ModelRenderer leftwing2;
    ModelRenderer leftwing3;
    ModelRenderer rightwing1;
    ModelRenderer rightwing2;
    ModelRenderer rightwing3;
    ModelRenderer MiscCircle;
    ModelRenderer bladeright1;
    ModelRenderer bladeright2;
    ModelRenderer bladeleft1;
    ModelRenderer bladeleft2;
    public ModelFlyer()
    {
        textureWidth = 64;
        textureHeight = 32;
        
          tail1 = new ModelRenderer(this, 0, 0);
          tail1.addBox(-2F, 0F, -2F, 4, 7, 4);
          tail1.setRotationPoint(0F, 6F, 0F);
          tail1.setTextureSize(64, 32);
          tail1.mirror = true;
          setRotation(tail1, 0.3490659F, 0F, 0F);
          tail2 = new ModelRenderer(this, 0, 11);
          tail2.addBox(-1F, 0F, -1F, 2, 4, 2);
          tail2.setRotationPoint(0F, 12.5F, 2.5F);
          tail2.setTextureSize(64, 32);
          tail2.mirror = true;
          setRotation(tail2, 0.5235988F, 0F, 0F);
          body = new ModelRenderer(this, 16, 0);
          body.addBox(-3F, 0F, -1.5F, 6, 9, 3);
          body.setRotationPoint(0F, -2.8F, 0F);
          body.setTextureSize(64, 32);
          body.mirror = true;
          setRotation(body, 0F, 0F, 0F);
          rightarm = new ModelRenderer(this, 8, 11);
          rightarm.addBox(-1F, 0F, -1F, 2, 6, 2);
          rightarm.setRotationPoint(-3.6F, -2F, 0F);
          rightarm.setTextureSize(64, 32);
          rightarm.mirror = true;
          setRotation(rightarm, 0F, 0F, 0.1487144F);
          lefttarm = new ModelRenderer(this, 8, 11);
          lefttarm.addBox(-1F, 0F, -1F, 2, 6, 2);
          lefttarm.setRotationPoint(3.6F, -2F, 0F);
          lefttarm.setTextureSize(64, 32);
          lefttarm.mirror = true;
          setRotation(lefttarm, 0F, 0F, -0.1487144F);
          head = new ModelRenderer(this, 8, 12);
          head.addBox(-4F, -8F, -4F, 8, 8, 8);
          head.setRotationPoint(0F, -2.8F, 0F);
          head.setTextureSize(64, 32);
          head.mirror = true;
          setRotation(head, 0F, 0F, 0F);
          leftwing1 = new ModelRenderer(this, 34, 0);
          leftwing1.addBox(0F, -0.5F, 0F, 5, 1, 1);
          leftwing1.setRotationPoint(1F, 0F, 1.5F);
          leftwing1.setTextureSize(64, 32);
          leftwing1.mirror = true;
          setRotation(leftwing1, 0F, -0.4461433F, 0F);
          leftwing2 = new ModelRenderer(this, 34, 0);
          leftwing2.addBox(0F, -0.5F, 0F, 5, 1, 1);
          leftwing2.setRotationPoint(5.5F, 0F, 3.6F);
          leftwing2.setTextureSize(64, 32);
          leftwing2.mirror = true;
          setRotation(leftwing2, 0F, -0.8922844F, -0.669215F);
          leftwing3 = new ModelRenderer(this, 34, 0);
          leftwing3.addBox(0F, -0.5F, 0F, 5, 1, 1);
          leftwing3.setRotationPoint(8F, -3F, 6.6F);
          leftwing3.setTextureSize(64, 32);
          leftwing3.mirror = true;
          setRotation(leftwing3, 0F, -1.673038F, 0.5205006F);
          rightwing1 = new ModelRenderer(this, 34, 0);
          rightwing1.addBox(-5F, -0.5F, 0F, 5, 1, 1);
          rightwing1.setRotationPoint(-1F, 0F, 1.5F);
          rightwing1.setTextureSize(64, 32);
          rightwing1.mirror = true;
          setRotation(rightwing1, 0F, 0.4461411F, 0F);
          rightwing2 = new ModelRenderer(this, 34, 0);
          rightwing2.addBox(0F, -0.5F, -0.4F, 5, 1, 1);
          rightwing2.setRotationPoint(-4.5F, 0F, 3.6F);
          rightwing2.setTextureSize(64, 32);
          rightwing2.mirror = true;
          setRotation(rightwing2, 0F, -2.342262F, -0.5205006F);
          rightwing3 = new ModelRenderer(this, 34, 0);
          rightwing3.addBox(0F, 0F, 0F, 5, 1, 1);
          rightwing3.setRotationPoint(-7F, -3.2F, 7F);
          rightwing3.setTextureSize(64, 32);
          rightwing3.mirror = true;
          setRotation(rightwing3, 0F, -1.301251F, 0.5205006F);
          MiscCircle = new ModelRenderer(this, 37, 23);
          MiscCircle.addBox(-4.5F, 0F, -4.5F, 9, 0, 9);
          MiscCircle.setRotationPoint(0F, 12.6F, 2.5F);
          MiscCircle.setTextureSize(64, 32);
          MiscCircle.mirror = true;
          setRotation(MiscCircle, 0.3490659F, 0F, 0F);
          bladeright1 = new ModelRenderer(this, 32, 14);
          bladeright1.addBox(0F, 0F, -3F, 1, 1, 5);
          bladeright1.setRotationPoint(-5F, 3F, 0F);
          bladeright1.setTextureSize(64, 32);
          bladeright1.mirror = true;
          setRotation(bladeright1, 0F, 0F, 0F);
          bladeright2 = new ModelRenderer(this, 39, 12);
          bladeright2.addBox(0F, 0F, -5F, 0, 2, 5);
          bladeright2.setRotationPoint(-4.5F, 3F, -3F);
          bladeright2.setTextureSize(64, 32);
          bladeright2.mirror = true;
          setRotation(bladeright2, 0F, 0F, 0F);
          bladeleft1 = new ModelRenderer(this, 32, 14);
          bladeleft1.addBox(0F, 0F, -3F, 1, 1, 5);
          bladeleft1.setRotationPoint(4F, 3F, 0F);
          bladeleft1.setTextureSize(64, 32);
          bladeleft1.mirror = true;
          setRotation(bladeleft1, 0F, 0F, 0F);
          bladeleft2 = new ModelRenderer(this, 39, 12);
          bladeleft2.addBox(0F, 0F, -5F, 0, 2, 5);
          bladeleft2.setRotationPoint(4.5F, 3F, -3F);
          bladeleft2.setTextureSize(64, 32);
          bladeleft2.mirror = true;
          setRotation(bladeleft2, 0F, 0F, 0F);
    }
    
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
      super.render(entity, f, f1, f2, f3, f4, f5);
      setRotationAngles(f, f1, f2, f3, f4, f5, entity);
      tail1.render(f5);
      tail2.render(f5);
      body.render(f5);
      rightarm.render(f5);
      lefttarm.render(f5);
      head.render(f5);
      leftwing1.render(f5);
      leftwing2.render(f5);
      leftwing3.render(f5);
      rightwing1.render(f5);
      rightwing2.render(f5);
      rightwing3.render(f5);
      MiscCircle.render(f5);
      bladeright1.render(f5);
      bladeright2.render(f5);
      bladeleft1.render(f5);
      bladeleft2.render(f5);
    }
    
    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
      model.rotateAngleX = x;
      model.rotateAngleY = y;
      model.rotateAngleZ = z;
    }
    
    public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity)
    {
      super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
      this.head.rotateAngleY = par4 / (180F / (float)Math.PI);
      this.head.rotateAngleX = par5 / (180F / (float)Math.PI);
    }
}
