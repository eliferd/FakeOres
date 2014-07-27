package fr.elias.fakeores.client;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import fr.elias.fakeores.common.EntityMazeCreature;

public class RenderMazeCreature extends RenderLiving {

	public float scale;
	public RenderMazeCreature() 
	{
		super(new ModelMazeCreature(), 0.2F);
		scale = 0.4F;
	}
    public void preRenderCallback(EntityMazeCreature p_77041_1_, float p_77041_2_)
    {
        GL11.glScalef(scale, scale, scale);
    }
	protected ResourceLocation setEntityTexture(EntityMazeCreature var1)
	{
		return new ResourceLocation("fakeores:textures/entity/"+var1.texture);
	}
	
	public void preRenderCallback(EntityLivingBase base, float f)
	{
		preRenderCallback((EntityMazeCreature) base, f);
	}
	@Override
	protected ResourceLocation getEntityTexture(Entity var1) {
		// TODO Auto-generated method stub
		return setEntityTexture((EntityMazeCreature) var1);
	}

}
