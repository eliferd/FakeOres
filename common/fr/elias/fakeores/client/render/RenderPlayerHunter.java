package fr.elias.fakeores.client.render;

import fr.elias.fakeores.client.model.ModelPlayerHunter;
import fr.elias.fakeores.common.entity.EntityPlayerHunter;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderPlayerHunter extends RenderLiving
{
    public static final ResourceLocation texture = new ResourceLocation("fakeores:textures/entity/playerHunter.png");

    public RenderPlayerHunter(RenderManager manager)
    {
        super(manager, new ModelPlayerHunter(), 0.5F);
    }

    protected ResourceLocation bindEntityTexture(EntityPlayerHunter var1)
    {
        return texture;
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity var1)
    {
        return bindEntityTexture((EntityPlayerHunter)var1);
    }
}