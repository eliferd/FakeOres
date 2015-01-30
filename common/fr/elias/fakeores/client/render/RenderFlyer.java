package fr.elias.fakeores.client.render;

import fr.elias.fakeores.client.model.ModelFlyer;
import fr.elias.fakeores.common.entity.EntityFlyer;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderFlyer extends RenderLiving
{
    public static final ResourceLocation texture = new ResourceLocation("fakeores:textures/entity/flyer.png");

    public RenderFlyer(RenderManager manager)
    {
        super(manager, new ModelFlyer(), 1.0F);
    }

    protected ResourceLocation makeEntityTexture(EntityFlyer var1)
    {
        return texture;
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity var1)
    {
        return makeEntityTexture((EntityFlyer)var1);
    }
}