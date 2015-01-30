package fr.elias.fakeores.client.render;

import fr.elias.fakeores.client.model.ModelMazeCreature;
import fr.elias.fakeores.common.entity.EntityMazeCreature;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class RenderMazeCreature extends RenderLiving
{
    public float scale;

    public RenderMazeCreature(RenderManager manager)
    {
        super(manager, new ModelMazeCreature(), 0.2F);
        scale = 0.4F;
    }

    public void preRenderCallback(EntityMazeCreature p_77041_1_, float p_77041_2_)
    {
        GL11.glScalef(scale, scale, scale);
    }

    protected ResourceLocation setEntityTexture(EntityMazeCreature var1)
    {
        return new ResourceLocation("fakeores:textures/entity/" + var1.texture);
    }

    @Override
    public void preRenderCallback(EntityLivingBase base, float f)
    {
        preRenderCallback((EntityMazeCreature)base, f);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity var1)
    {
        return setEntityTexture((EntityMazeCreature)var1);
    }
}