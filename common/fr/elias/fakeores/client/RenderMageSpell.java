package fr.elias.fakeores.client;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import fr.elias.fakeores.common.EntityMageSpell;

public class RenderMageSpell extends RenderLiving {

	public static final ResourceLocation texture = new ResourceLocation("fakeores:textures/entity/magespell.png");
	public RenderMageSpell() 
	{
		super(new ModelMageSpell(), 0.0F);
	}
	
	
	protected ResourceLocation setEntityTexture(EntityMageSpell var1) 
	{
		return texture;
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity var1) 
	{
		return setEntityTexture((EntityMageSpell) var1);
	}

}
