package fr.elias.fakeores.client;

import fr.elias.fakeores.common.EntityRegenEgg;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderRegenEgg extends RenderLiving {

	public static final ResourceLocation texture = new ResourceLocation("fakeores:textures/entity/egg.png");
	
	public RenderRegenEgg() 
	{
		super(new ModelRegenEgg(), 0.0F);
		// TODO Auto-generated constructor stub
	}

	protected ResourceLocation setEntityTexture(EntityRegenEgg var1)
	{
		// TODO Auto-generated method stub
		return texture;
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity var1)
	{
		// TODO Auto-generated method stub
		return setEntityTexture((EntityRegenEgg) var1);
	}

}
