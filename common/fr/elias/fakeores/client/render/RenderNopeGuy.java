package fr.elias.fakeores.client.render;

import fr.elias.fakeores.client.model.ModelNopeGuy;
import fr.elias.fakeores.common.entity.EntityNopeGuy;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderNopeGuy extends RenderLiving
{
    public static final ResourceLocation texture = new ResourceLocation("fakeores:textures/entity/nopeguy.png");

    public RenderNopeGuy(RenderManager manager)
    {
        super(manager, new ModelNopeGuy(), 0.2F);
    }

    protected ResourceLocation setEntityTexture(EntityNopeGuy var1)
    {
        return texture;
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity var1)
    {
        return setEntityTexture((EntityNopeGuy)var1);
    }
}