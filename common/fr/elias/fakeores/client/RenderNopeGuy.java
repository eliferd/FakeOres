package fr.elias.fakeores.client;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import fr.elias.fakeores.common.EntityNopeGuy;

public class RenderNopeGuy extends RenderLiving 
{
	public static final ResourceLocation texture = new ResourceLocation("fakeores:textures/entity/nopeguy.png");
	public RenderNopeGuy() 
	{
		super(new ModelNopeGuy(), 0.2F);
	}

	protected ResourceLocation setEntityTexture(EntityNopeGuy var1) {
		// TODO Auto-generated method stub
		return texture;
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity var1) {
		// TODO Auto-generated method stub
		return setEntityTexture((EntityNopeGuy) var1);
	}

}
