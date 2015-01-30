package fr.elias.fakeores.client.render;

import fr.elias.fakeores.client.model.ModelRegenEgg;
import fr.elias.fakeores.common.entity.EntityRegenEgg;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderRegenEgg extends RenderLiving
{
    public static final ResourceLocation texture = new ResourceLocation("fakeores:textures/entity/egg.png");

    public RenderRegenEgg(RenderManager manager)
    {
        super(manager, new ModelRegenEgg(), 0.0F);
    }

    protected ResourceLocation setEntityTexture(EntityRegenEgg var1)
    {
        return texture;
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity var1)
    {
        return setEntityTexture((EntityRegenEgg)var1);
    }
}