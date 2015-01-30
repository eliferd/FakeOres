package fr.elias.fakeores.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelMutantMonster extends ModelBase
{
    // fields
    ModelRenderer body;
    ModelRenderer rightleg1;
    ModelRenderer leftleg1;
    ModelRenderer rightleg2;
    ModelRenderer leftleg2;
    ModelRenderer rightfoot;
    ModelRenderer leftfoot;
    ModelRenderer rightfoot2;
    ModelRenderer leftfoot2;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer spikeStick;
    ModelRenderer spike;
    ModelRenderer head1;
    ModelRenderer head2;

    public ModelMutantMonster()
    {
        textureWidth = 64;
        textureHeight = 32;

        body = new ModelRenderer(this, 0, 0);
        body.addBox(-4F, -5F, -1.5F, 8, 10, 3);
        body.setRotationPoint(0F, 10F, 0F);
        body.setTextureSize(64, 32);
        body.mirror = true;
        setRotation(body, 0F, 0F, 0F);
        rightleg1 = new ModelRenderer(this, 0, 13);
        rightleg1.addBox(-1F, 0F, -1F, 2, 3, 2);
        rightleg1.setRotationPoint(-2F, 15F, 0F);
        rightleg1.setTextureSize(64, 32);
        rightleg1.mirror = true;
        setRotation(rightleg1, 0F, 0F, 0F);
        leftleg1 = new ModelRenderer(this, 0, 13);
        leftleg1.addBox(-1F, 0F, -1F, 2, 3, 2);
        leftleg1.setRotationPoint(2F, 15F, 0F);
        leftleg1.setTextureSize(64, 32);
        leftleg1.mirror = true;
        setRotation(leftleg1, 0F, 0F, 0F);
        rightleg2 = new ModelRenderer(this, 8, 13);
        rightleg2.addBox(-0.5F, 0F, -0.5F, 1, 4, 1);
        rightleg2.setRotationPoint(0F, 3F, 0F);
        rightleg2.setTextureSize(64, 32);
        rightleg2.mirror = true;
        setRotation(rightleg2, 0F, 0F, 0F);
        leftleg2 = new ModelRenderer(this, 8, 13);
        leftleg2.addBox(-0.5F, 0F, -0.5F, 1, 4, 1);
        leftleg2.setRotationPoint(0F, 3F, 0F);
        leftleg2.setTextureSize(64, 32);
        leftleg2.mirror = true;
        setRotation(leftleg2, 0F, 0F, 0F);
        rightfoot = new ModelRenderer(this, 8, 13);
        rightfoot.addBox(-1F, 0F, -3.5F, 2, 2, 5);
        rightfoot.setRotationPoint(0F, 4F, 0F);
        rightfoot.setTextureSize(64, 32);
        rightfoot.mirror = true;
        setRotation(rightfoot, 0F, 0F, 0F);
        leftfoot = new ModelRenderer(this, 8, 13);
        leftfoot.addBox(-1F, 0F, -3.5F, 2, 2, 5);
        leftfoot.setRotationPoint(0F, 4F, 0F);
        leftfoot.setTextureSize(64, 32);
        leftfoot.mirror = true;
        setRotation(leftfoot, 0F, 0F, 0F);
        rightfoot2 = new ModelRenderer(this, 17, 13);
        rightfoot2.addBox(-1F, 0F, -0.5F, 2, 1, 1);
        rightfoot2.setRotationPoint(0F, 1F, -4F);
        rightfoot2.setTextureSize(64, 32);
        rightfoot2.mirror = true;
        setRotation(rightfoot2, 0F, 0F, 0F);
        leftfoot2 = new ModelRenderer(this, 17, 13);
        leftfoot2.addBox(-1F, 0F, -0.5F, 2, 1, 1);
        leftfoot2.setRotationPoint(0F, 1F, -4F);
        leftfoot2.setTextureSize(64, 32);
        leftfoot2.mirror = true;
        setRotation(leftfoot2, 0F, 0F, 0F);
        rightarm = new ModelRenderer(this, 0, 18);
        rightarm.addBox(-2F, -1F, -1F, 2, 7, 2);
        rightarm.setRotationPoint(-4F, 7F, 0F);
        rightarm.setTextureSize(64, 32);
        rightarm.mirror = true;
        setRotation(rightarm, 0F, 0F, 0F);
        leftarm = new ModelRenderer(this, 0, 18);
        leftarm.addBox(0F, -1F, -1F, 2, 7, 2);
        leftarm.setRotationPoint(4F, 7F, 0F);
        leftarm.setTextureSize(64, 32);
        leftarm.mirror = true;
        setRotation(leftarm, 0F, 0F, 0F);
        spikeStick = new ModelRenderer(this, 0, 20);
        spikeStick.addBox(-0.5F, -0.5F, -6.5F, 1, 1, 8);
        spikeStick.setRotationPoint(-5F, 12F, 0F);
        spikeStick.setTextureSize(64, 32);
        spikeStick.mirror = true;
        setRotation(spikeStick, 0F, 0F, 0F);
        spike = new ModelRenderer(this, 10, 20);
        spike.addBox(-2F, -2F, -4F, 4, 4, 4);
        spike.setRotationPoint(0F, 0F, -6.5F);
        spike.setTextureSize(64, 32);
        spike.mirror = true;
        setRotation(spike, 0F, 0F, 0F);
        head1 = new ModelRenderer(this, 22, 0);
        head1.addBox(-3F, -2F, -1F, 6, 8, 1);
        head1.setRotationPoint(0F, 3F, -1.5F);
        head1.setTextureSize(64, 32);
        head1.mirror = true;
        setRotation(head1, 0F, 0F, 0F);
        head2 = new ModelRenderer(this, 36, 0);
        head2.addBox(-3F, -2F, -1F, 6, 4, 5);
        head2.setRotationPoint(0F, 3F, -0.5F);
        head2.setTextureSize(64, 32);
        head2.mirror = true;
        setRotation(head2, 0F, 0F, 0F);
        this.spikeStick.addChild(spike);
        this.rightleg1.addChild(rightleg2);
        this.leftleg1.addChild(leftleg2);
        this.rightleg2.addChild(rightfoot);
        this.leftleg2.addChild(leftfoot);
        this.rightfoot.addChild(rightfoot2);
        this.leftfoot.addChild(leftfoot2);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        body.render(f5);
        rightleg1.render(f5);
        leftleg1.render(f5);
        rightarm.render(f5);
        leftarm.render(f5);
        spikeStick.render(f5);
        head1.render(f5);
        head2.render(f5);
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
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.rightarm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 2.0F * f1 * 0.5F;
        this.spikeStick.rotateAngleY = this.rightarm.rotateAngleY;
        this.spikeStick.rotateAngleX = this.rightarm.rotateAngleX;
        this.leftarm.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F;
        this.rightarm.rotateAngleZ = 0.0F;
        this.leftarm.rotateAngleZ = 0.0F;
        this.rightleg1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
        this.leftleg1.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
        this.rightleg1.rotateAngleY = 0.0F;
        this.leftleg1.rotateAngleY = 0.0F;
    }

}
