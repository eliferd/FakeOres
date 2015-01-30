package fr.elias.fakeores.client.render;

import fr.elias.fakeores.client.model.ModelMutantMonster;
import fr.elias.fakeores.common.entity.EntityMutantMonster;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class RenderMutantMonster extends RenderLiving
{
    public static final ResourceLocation texture = new ResourceLocation("fakeores:textures/entity/mutantmonster.png");
    public float size;

    public RenderMutantMonster(RenderManager manager)
    {
        super(manager, new ModelMutantMonster(), 0.5F);
        size = 2F;
    }

    protected void preRenderCallback(EntityMutantMonster par1EntityGiantZombie, float par2)
    {
        GL11.glScalef(this.size, this.size, this.size);
    }

    protected ResourceLocation setEntityTexture(EntityMutantMonster var1)
    {
        return texture;
    }

    @Override
    protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
    {
        this.preRenderCallback((EntityMutantMonster)par1EntityLivingBase, par2);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity var1)
    {
        return setEntityTexture((EntityMutantMonster)var1);
    }
}