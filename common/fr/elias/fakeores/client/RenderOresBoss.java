package fr.elias.fakeores.client;

import java.util.Random;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import fr.elias.fakeores.common.EntityOresBoss;

public class RenderOresBoss extends RenderLiving
{

	public static final ResourceLocation texture = new ResourceLocation("fakeores:textures/entity/OresBoss.png");
	public RenderOresBoss(ModelBase par1ModelBase, float par2)
	{
		super(par1ModelBase, par2);
	}
	public ResourceLocation forceBindEntityTexture(EntityOresBoss boss)
	{
		return texture;
	}
	private Random rand;
	public void renderHealtBar(EntityOresBoss mob, double x, double y, double z, float par8, float par9)
	{
		BossStatus.setBossStatus(mob, true);
		if(mob.getPhase() == 2)
		{
			GL11.glColor3f(0.0F, 2.0F, 1.0F);
		}		
		if(mob.getPhase() == 3)
		{
			GL11.glColor3f(2.0F, 1.0F, 2.0F);
		}
		super.doRender(mob, x, y, z, par8, par9);
	}
	public void doRender(Entity entity, double x, double y, double z, float par8, float par9)
	{
		this.renderHealtBar((EntityOresBoss)entity, x, y, z, par8, par9);
	}
	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		// TODO Auto-generated method stub
		return forceBindEntityTexture((EntityOresBoss)entity);
	}
}
