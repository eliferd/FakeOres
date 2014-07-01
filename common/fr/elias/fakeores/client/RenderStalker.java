package fr.elias.fakeores.client;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import fr.elias.fakeores.common.EntityStalker;

public class RenderStalker extends RenderBiped
{
	public static final ResourceLocation texture = new ResourceLocation("fakeores:textures/entity/stalker.png");
	
	public RenderStalker(ModelBiped par1ModelBiped, float par2) 
	{
		super(par1ModelBiped, par2);
		// TODO Auto-generated constructor stub
	}

	protected ResourceLocation getEntityTexture(EntityStalker var1)
	{
		// TODO Auto-generated method stub
		return texture;
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity var1) {
		// TODO Auto-generated method stub
		return getEntityTexture((EntityStalker)var1);
	}

}
