package fr.elias.fakeores.client;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import fr.elias.fakeores.common.EntitySchaza;

public class RenderSchaza extends RenderLiving 
{
	public static final ResourceLocation texture = new ResourceLocation("fakeores:textures/entity/schaza.png");
	public float scale;
	public RenderSchaza() 
	{
		super(new ModelSchaza(), 1F);
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
	
    protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
    {
        this.preRenderCallback((EntitySchaza)par1EntityLivingBase, par2);
    }
    
	@Override
	protected ResourceLocation getEntityTexture(Entity var1) 
	{
		return setEntityTexture((EntitySchaza) var1);
	}

}
