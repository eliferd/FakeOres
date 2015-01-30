package fr.elias.fakeores.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelFlyer_Shield extends ModelBase
{
    // fields
    ModelRenderer top;
    ModelRenderer right;
    ModelRenderer left;
    ModelRenderer front;
    ModelRenderer back;

    public ModelFlyer_Shield()
    {
        textureWidth = 128;
        textureHeight = 64;

        top = new ModelRenderer(this, 0, 0);
        top.addBox(-6F, 0F, -6F, 12, 1, 12);
        top.setRotationPoint(0F, 0F, 0F);
        top.setTextureSize(128, 64);
        top.mirror = true;
        setRotation(top, 0F, 0F, 0F);
        right = new ModelRenderer(this, 36, 1);
        right.addBox(-1F, 0F, -6F, 1, 18, 12);
        right.setRotationPoint(-6F, 0F, 0F);
        right.setTextureSize(128, 64);
        right.mirror = true;
        setRotation(right, 0F, 0F, 0F);
        left = new ModelRenderer(this, 36, 1);
        left.addBox(0F, 0F, -6F, 1, 18, 12);
        left.setRotationPoint(6F, 0F, 0F);
        left.setTextureSize(128, 64);
        left.mirror = true;
        setRotation(left, 0F, 0F, 0F);
        front = new ModelRenderer(this, 0, 13);
        front.addBox(-7F, 0F, -1F, 14, 18, 1);
        front.setRotationPoint(0F, 0F, -6F);
        front.setTextureSize(128, 64);
        front.mirror = true;
        setRotation(front, 0F, 0F, 0F);
        back = new ModelRenderer(this, 0, 13);
        back.addBox(-7F, 0F, 0F, 14, 18, 1);
        back.setRotationPoint(0F, 0F, 6F);
        back.setTextureSize(128, 64);
        back.mirror = true;
        setRotation(back, 0F, 0F, 0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        top.render(f5);
        right.render(f5);
        left.render(f5);
        front.render(f5);
        back.render(f5);
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
    }

}