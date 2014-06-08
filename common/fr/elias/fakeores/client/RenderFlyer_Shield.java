package fr.elias.fakeores.client;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import fr.elias.fakeores.common.EntityFlyer_Shield;

public class RenderFlyer_Shield extends RenderLiving {

	public static final ResourceLocation texture = new ResourceLocation("fakeores:textures/entity/flyer_shield.png");
	public float scale;
	public RenderFlyer_Shield() 
	{
		super(new ModelFlyer_Shield(), 0F);
		scale = 2F;
	}
	
    protected void preRenderCallback(EntityFlyer_Shield par1EntityGiantZombie, float par2)
    {
        GL11.glScalef(this.scale, this.scale, this.scale);
        GL11.glTranslatef(0.0F, 0.6F, 0.0F);
    }
	
	protected ResourceLocation setEntityTexture(EntityFlyer_Shield var1) {
		// TODO Auto-generated method stub
		return texture;
	}
	
    protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
    {
        this.preRenderCallback((EntityFlyer_Shield)par1EntityLivingBase, par2);
    }
	
	@Override
	protected ResourceLocation getEntityTexture(Entity var1) {
		// TODO Auto-generated method stub
		return setEntityTexture((EntityFlyer_Shield) var1);
	}

}
