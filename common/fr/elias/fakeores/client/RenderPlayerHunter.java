package fr.elias.fakeores.client;

import fr.elias.fakeores.common.EntityPlayerHunter;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderPlayerHunter extends RenderLiving
{
	public static final ResourceLocation texture = new ResourceLocation("fakeores:textures/entity/playerHunter.png");
	
	public RenderPlayerHunter()
	{
		super(new ModelPlayerHunter(), 0.5F);
	}

	protected ResourceLocation bindEntityTexture(EntityPlayerHunter var1)
	{
		// TODO Auto-generated method stub
		return texture;
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity var1)
	{
		// TODO Auto-generated method stub
		return bindEntityTexture((EntityPlayerHunter) var1);
	}

}
