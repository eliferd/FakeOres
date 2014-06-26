package fr.elias.fakeores.client;

import fr.elias.fakeores.common.EntityDangerousPlant;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderDangerousPlant extends RenderLiving {

	public static final ResourceLocation texture = new ResourceLocation("fakeores:textures/entity/DangerousPlant.png");
	public RenderDangerousPlant() 
	{
		super(new ModelDangerousPlant(), 0.0F);
	}

	protected ResourceLocation setEntityTexture(EntityDangerousPlant var1) {
		// TODO Auto-generated method stub
		return texture;
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity var1) {
		// TODO Auto-generated method stub
		return setEntityTexture((EntityDangerousPlant) var1);
	}

}
