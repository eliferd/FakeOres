package fr.elias.fakeores.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelSchaza extends ModelBase
{
    // fields
    ModelRenderer body;
    ModelRenderer leg1;
    ModelRenderer leg2;
    ModelRenderer leg3;
    ModelRenderer leg4;
    ModelRenderer neck;
    ModelRenderer head;
    ModelRenderer tail1;

    public ModelSchaza()
    {
        textureWidth = 26;
        textureHeight = 21;

        body = new ModelRenderer(this, 0, 0);
        body.addBox(-2.5F, -1.5F, -4F, 5, 3, 8);
        body.setRotationPoint(0F, 18F, 0F);
        body.setTextureSize(26, 21);
        body.mirror = true;
        setRotation(body, 0F, 0F, 0F);
        leg1 = new ModelRenderer(this, 0, 11);
        leg1.addBox(-8F, 0F, -1F, 8, 1, 1);
        leg1.setRotationPoint(-2.5F, 18F, -1F);
        leg1.setTextureSize(26, 21);
        leg1.mirror = true;
        setRotation(leg1, 0F, 0F, -0.7435722F);
        leg2 = new ModelRenderer(this, 0, 11);
        leg2.addBox(-8F, 0F, 0F, 8, 1, 1);
        leg2.setRotationPoint(-2.5F, 18F, 2F);
        leg2.setTextureSize(26, 21);
        leg2.mirror = true;
        setRotation(leg2, 0F, 0F, -0.7435722F);
        leg3 = new ModelRenderer(this, 0, 11);
        leg3.addBox(-8F, -1F, -1F, 8, 1, 1);
        leg3.setRotationPoint(2.5F, 18F, -1F);
        leg3.setTextureSize(26, 21);
        leg3.mirror = true;
        setRotation(leg3, 0F, 0F, -2.454003F);
        leg4 = new ModelRenderer(this, 0, 11);
        leg4.addBox(-8F, -1F, 0F, 8, 1, 1);
        leg4.setRotationPoint(2.5F, 18F, 2F);
        leg4.setTextureSize(26, 21);
        leg4.mirror = true;
        setRotation(leg4, 0F, 0F, -2.454003F);
        neck = new ModelRenderer(this, 18, 0);
        neck.addBox(-1F, -6F, 0F, 2, 6, 1);
        neck.setRotationPoint(0F, 17F, -4F);
        neck.setTextureSize(26, 21);
        neck.mirror = true;
        setRotation(neck, -0.3346114F, 0F, 0F);
        head = new ModelRenderer(this, 0, 13);
        head.addBox(-2F, -4F, -2F, 4, 4, 4);
        head.setRotationPoint(0F, 11.7F, -1F);
        head.setTextureSize(26, 21);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
        tail1 = new ModelRenderer(this, 0, 0);
        tail1.addBox(-0.5F, -6F, 0F, 1, 7, 1);
        tail1.setRotationPoint(0F, 15.8F, 4.2F);
        tail1.setTextureSize(26, 21);
        tail1.mirror = true;
        setRotation(tail1, -0.848292F, 0F, 0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        body.render(f5);
        leg1.render(f5);
        leg2.render(f5);
        leg3.render(f5);
        leg4.render(f5);
        neck.render(f5);
        head.render(f5);
        tail1.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    @Override
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
        this.head.rotateAngleY = f3 / (180F / (float)Math.PI);
        this.head.rotateAngleX = f4 / (180F / (float)Math.PI);
        this.leg1.rotateAngleY = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
        this.leg1.rotateAngleX = 0.0F;
        this.leg2.rotateAngleY = -MathHelper.cos(f * 0.6662F) * 1.4F * f1;
        this.leg2.rotateAngleX = 0.0F;

        this.leg3.rotateAngleY = -MathHelper.cos(f * 0.6662F) * 1.4F * f1;
        this.leg3.rotateAngleX = 0.0F;
        this.leg4.rotateAngleY = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
        this.leg4.rotateAngleX = 0.0F;
    }
}