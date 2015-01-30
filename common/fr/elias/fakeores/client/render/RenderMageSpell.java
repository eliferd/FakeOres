package fr.elias.fakeores.client.render;

import fr.elias.fakeores.client.model.ModelMageSpell;
import fr.elias.fakeores.common.entity.EntityMageSpell;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderMageSpell extends RenderLiving
{
    public static final ResourceLocation texture = new ResourceLocation("fakeores:textures/entity/magespell.png");

    public RenderMageSpell(RenderManager manager)
    {
        super(manager, new ModelMageSpell(), 0.0F);
    }

    protected ResourceLocation setEntityTexture(EntityMageSpell var1)
    {
        return texture;
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity var1)
    {
        return setEntityTexture((EntityMageSpell)var1);
    }
}