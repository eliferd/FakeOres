package fr.elias.fakeores.client.render;

import fr.elias.fakeores.common.entity.EntityStalker;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderStalker extends RenderBiped
{
    public static final ResourceLocation texture = new ResourceLocation("fakeores:textures/entity/stalker.png");

    public RenderStalker(RenderManager manager, ModelBiped par1ModelBiped, float par2)
    {
        super(manager, par1ModelBiped, par2);
    }

    protected ResourceLocation getEntityTexture(EntityStalker var1)
    {
        return texture;
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity var1)
    {
        return getEntityTexture((EntityStalker)var1);
    }
}