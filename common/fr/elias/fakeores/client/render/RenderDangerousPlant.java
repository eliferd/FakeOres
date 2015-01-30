package fr.elias.fakeores.client.render;

import fr.elias.fakeores.client.model.ModelDangerousPlant;
import fr.elias.fakeores.common.entity.EntityDangerousPlant;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderDangerousPlant extends RenderLiving
{
    public static final ResourceLocation texture = new ResourceLocation("fakeores:textures/entity/DangerousPlant.png");

    public RenderDangerousPlant(RenderManager manager)
    {
        super(manager, new ModelDangerousPlant(), 0.0F);
    }

    protected ResourceLocation setEntityTexture(EntityDangerousPlant var1)
    {
        return texture;
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity var1)
    {
        return setEntityTexture((EntityDangerousPlant)var1);
    }
}