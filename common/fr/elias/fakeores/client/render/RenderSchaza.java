package fr.elias.fakeores.client.render;

import fr.elias.fakeores.client.model.ModelSchaza;
import fr.elias.fakeores.common.entity.EntitySchaza;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class RenderSchaza extends RenderLiving
{
    public static final ResourceLocation texture = new ResourceLocation("fakeores:textures/entity/schaza.png");
    public float scale;

    public RenderSchaza(RenderManager manager)
    {
        super(manager, new ModelSchaza(), 1F);
        scale = 1.5F;
    }

    protected void preRenderCallback(EntitySchaza par1EntityGiantZombie, float par2)
    {
        GL11.glScalef(this.scale, this.scale, this.scale);
    }

    protected ResourceLocation setEntityTexture(EntitySchaza var1)
    {
        return texture;
    }

    @Override
    protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
    {
        this.preRenderCallback((EntitySchaza)par1EntityLivingBase, par2);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity var1)
    {
        return setEntityTexture((EntitySchaza)var1);
    }
}