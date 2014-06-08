package fr.elias.fakeores.client;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import fr.elias.fakeores.common.EntityFlyer;

public class RenderFlyer extends RenderLiving 
{
	public static final ResourceLocation texture = new ResourceLocation("fakeores:textures/entity/flyer.png");
	public RenderFlyer() 
	{
		super(new ModelFlyer(), 1.0F);
	}

	protected ResourceLocation makeEntityTexture(EntityFlyer var1) 
	{
		// TODO Auto-generated method stub
		return texture;
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity var1) 
	{
		// TODO Auto-generated method stub
		return makeEntityTexture((EntityFlyer) var1);
	}

}
