package fr.elias.fakeores.client;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import fr.elias.fakeores.common.EntitySwimmerAnimal;

public class RenderSwimmerAnimal extends RenderLiving{

	public static final ResourceLocation texture = new ResourceLocation("fakeores:textures/entity/swimmeranimal.png");
	
	public RenderSwimmerAnimal() 
	{
		super(new ModelSwimmerAnimal(), 0.0F);
	}

    protected void preRenderCallback(EntitySwimmerAnimal par1EntitySwimmerAnimal, float par2)
    {
		float f = par1EntitySwimmerAnimal.size;
        GL11.glScalef(f, f, f);
    }
	
	protected ResourceLocation setEntityTexture(EntitySwimmerAnimal var1) 
	{
		return texture;
	}
	
    protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
    {
        this.preRenderCallback((EntitySwimmerAnimal)par1EntityLivingBase, par2);
    }
    
	@Override
	protected ResourceLocation getEntityTexture(Entity var1) 
	{
		return setEntityTexture((EntitySwimmerAnimal) var1);
	}

}
