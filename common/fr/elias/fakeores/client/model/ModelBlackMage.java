package fr.elias.fakeores.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelBlackMage extends ModelBase
{
    // fields
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer wand;
    ModelRenderer wand2;
    ModelRenderer chapeau1;
    ModelRenderer chapeau2;
    ModelRenderer chapeau3;
    ModelRenderer chapeau4;

    public ModelBlackMage()
    {
        textureWidth = 128;
        textureHeight = 64;

        head = new ModelRenderer(this, 0, 0);
        head.addBox(-4F, -8F, -4F, 8, 8, 8);
        head.setRotationPoint(0F, 0F, 0F);
        head.setTextureSize(128, 64);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
        body = new ModelRenderer(this, 16, 16);
        body.addBox(-4F, 0F, -2F, 8, 12, 4);
        body.setRotationPoint(0F, 0F, 0F);
        body.setTextureSize(128, 64);
        body.mirror = true;
        setRotation(body, 0F, 0F, 0F);
        rightarm = new ModelRenderer(this, 40, 16);
        rightarm.addBox(-3F, -2F, -2F, 4, 12, 4);
        rightarm.setRotationPoint(-5F, 2F, 0F);
        rightarm.setTextureSize(128, 64);
        rightarm.mirror = true;
        setRotation(rightarm, 0F, 0F, 0F);
        leftarm = new ModelRenderer(this, 40, 16);
        leftarm.addBox(-1F, -2F, -2F, 4, 12, 4);
        leftarm.setRotationPoint(5F, 2F, 0F);
        leftarm.setTextureSize(128, 64);
        leftarm.mirror = true;
        setRotation(leftarm, 0F, 0F, 0F);
        rightleg = new ModelRenderer(this, 0, 16);
        rightleg.addBox(-2F, 0F, -2F, 4, 12, 4);
        rightleg.setRotationPoint(-2F, 12F, 0F);
        rightleg.setTextureSize(128, 64);
        rightleg.mirror = true;
        setRotation(rightleg, 0F, 0F, 0F);
        leftleg = new ModelRenderer(this, 0, 16);
        leftleg.addBox(-2F, 0F, -2F, 4, 12, 4);
        leftleg.setRotationPoint(2F, 12F, 0F);
        leftleg.setTextureSize(128, 64);
        leftleg.mirror = true;
        setRotation(leftleg, 0F, 0F, 0F);
        wand = new ModelRenderer(this, 0, 32);
        wand.addBox(-0.5F, -0.5F, -15F, 1, 1, 23);
        wand.setRotationPoint(-6F, 11F, -1F);
        wand.setTextureSize(128, 64);
        wand.mirror = true;
        setRotation(wand, -0.5205006F, 0F, 0F);
        wand2 = new ModelRenderer(this, 0, 45);
        wand2.addBox(-2.5F, -4.5F, -2.5F, 5, 5, 5);
        wand2.setRotationPoint(-6F, 3F, -14F);
        wand2.setTextureSize(128, 64);
        wand2.mirror = true;
        setRotation(wand2, 1.041001F, 0F, 0F);
        chapeau1 = new ModelRenderer(this, 32, 5);
        chapeau1.addBox(-4.5F, -1F, -4.5F, 9, 2, 9);
        chapeau1.setRotationPoint(0F, -9F, 0F);
        chapeau1.setTextureSize(128, 64);
        chapeau1.mirror = true;
        setRotation(chapeau1, 0F, 0F, 0F);
        chapeau2 = new ModelRenderer(this, 38, 8);
        chapeau2.addBox(-5F, -1F, -5F, 6, 2, 6);
        chapeau2.setRotationPoint(2F, -9.8F, 2F);
        chapeau2.setTextureSize(128, 64);
        chapeau2.mirror = true;
        setRotation(chapeau2, -0.2230717F, 0F, 0F);
        chapeau3 = new ModelRenderer(this, 42, 10);
        chapeau3.addBox(-2F, -1F, -2F, 4, 2, 4);
        chapeau3.setRotationPoint(0F, -11.2F, 0F);
        chapeau3.setTextureSize(128, 64);
        chapeau3.mirror = true;
        setRotation(chapeau3, -0.4833219F, 0F, 0F);
        chapeau4 = new ModelRenderer(this, 46, 12);
        chapeau4.addBox(-1F, -1F, -1F, 2, 2, 2);
        chapeau4.setRotationPoint(0F, -12.5F, 1F);
        chapeau4.setTextureSize(128, 64);
        chapeau4.mirror = true;
        setRotation(chapeau4, -0.8179294F, 0F, 0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        head.render(f5);
        body.render(f5);
        rightarm.render(f5);
        leftarm.render(f5);
        rightleg.render(f5);
        leftleg.render(f5);
        wand.render(f5);
        wand2.render(f5);
        chapeau1.render(f5);
        chapeau2.render(f5);
        chapeau3.render(f5);
        chapeau4.render(f5);
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
        this.rightarm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 2.0F * f1 * 0.5F;
        this.leftarm.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F;
        this.rightarm.rotateAngleZ = 0.0F;
        this.leftarm.rotateAngleZ = 0.0F;
        this.rightleg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
        this.leftleg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
        this.rightleg.rotateAngleY = 0.0F;
        this.leftleg.rotateAngleY = 0.0F;
        this.wand2.rotateAngleY = this.wand.rotateAngleY;
        this.wand.rotateAngleY = this.leftarm.rotateAngleY;
        if(this.isRiding)
        {
            this.rightarm.rotateAngleX += -((float)Math.PI / 5F);
            this.leftarm.rotateAngleX += -((float)Math.PI / 5F);
            this.rightleg.rotateAngleX = -((float)Math.PI * 2F / 5F);
            this.leftleg.rotateAngleX = -((float)Math.PI * 2F / 5F);
            this.rightleg.rotateAngleY = ((float)Math.PI / 10F);
            this.leftleg.rotateAngleY = -((float)Math.PI / 10F);
        }

        this.rightarm.rotateAngleY = 0.0F;
        this.leftarm.rotateAngleY = 0.0F;
        float f6;
        float f7;

        if(this.swingProgress > -9990.0F)
        {
            f6 = this.swingProgress;
            this.body.rotateAngleY = MathHelper.sin(MathHelper.sqrt_float(f6) * (float)Math.PI * 2.0F) * 0.2F;
            this.rightarm.rotationPointZ = MathHelper.sin(this.body.rotateAngleY) * 5.0F;
            this.rightarm.rotationPointX = -MathHelper.cos(this.body.rotateAngleY) * 5.0F;
            this.leftarm.rotationPointZ = -MathHelper.sin(this.body.rotateAngleY) * 5.0F;
            this.leftarm.rotationPointX = MathHelper.cos(this.body.rotateAngleY) * 5.0F;
            this.rightarm.rotateAngleY += this.body.rotateAngleY;
            this.leftarm.rotateAngleY += this.body.rotateAngleY;
            this.leftarm.rotateAngleX += this.body.rotateAngleY;
            f6 = 1.0F - this.swingProgress;
            f6 *= f6;
            f6 *= f6;
            f6 = 1.0F - f6;
            f7 = MathHelper.sin(f6 * (float)Math.PI);
            float f8 = MathHelper.sin(this.swingProgress * (float)Math.PI) * -(this.head.rotateAngleX - 0.7F) * 0.75F;
            this.rightarm.rotateAngleX = (float)(this.rightarm.rotateAngleX - (f7 * 1.2D + f8));
            this.rightarm.rotateAngleY += this.body.rotateAngleY * 2.0F;
            this.rightarm.rotateAngleZ = MathHelper.sin(this.swingProgress * (float)Math.PI) * -0.4F;
        }
    }
}