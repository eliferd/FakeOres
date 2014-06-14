package fr.elias.fakeores.client;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelCreeper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import fr.elias.fakeores.common.EntityOres;

public class RenderOre extends RenderLiving {

	public static final ResourceLocation diamond = new ResourceLocation("fakeores:textures/entity/diamondOre.png");
	public static final ResourceLocation emerald = new ResourceLocation("fakeores:textures/entity/emeraldOre.png");
	public static final ResourceLocation gold = new ResourceLocation("fakeores:textures/entity/goldOre.png");
	public static final ResourceLocation iron = new ResourceLocation("fakeores:textures/entity/ironOre.png");
	public static final ResourceLocation coal = new ResourceLocation("fakeores:textures/entity/coalOre.png");
	public static final ResourceLocation redstone = new ResourceLocation("fakeores:textures/entity/redstoneOre.png");
	public static final ResourceLocation netherQuartz = new ResourceLocation("fakeores:textures/entity/netherquartzOre.png");
	public static final ResourceLocation lapislazuli = new ResourceLocation("fakeores:textures/entity/lapisOre.png");
	public static final ResourceLocation copper = new ResourceLocation("fakeores:textures/entity/copperOre.png");
	public static final ResourceLocation tin = new ResourceLocation("fakeores:textures/entity/tinOre.png");
	public static final ResourceLocation uranium = new ResourceLocation("fakeores:textures/entity/uraniumOre.png");
	public static final ResourceLocation noTexture = new ResourceLocation("fakeores:textures/entity/Ore.png");
	public RenderOre(ModelBase par1ModelBase) {
		super(par1ModelBase, 0F);
	}

    protected float setSpiderDeathMaxRotation(EntityOres par1EntitySpider)
    {
        return 0.0F;
    }
	public void renderHurted(EntityOres mob, double x, double y, double z, float par8, float par9)
	{
		if(mob.hurtTime > 0 || mob.deathTime > 0) // is hurted by another entity
		{
			GL11.glColor4f(0.0F, 1F, 0.0F, 1F);
		}
		super.doRender((EntityLiving)mob, x, y, z, par8, par9);
	}
    protected float getDeathMaxRotation(EntityLivingBase par1EntityLivingBase)
    {
        return this.setSpiderDeathMaxRotation((EntityOres)par1EntityLivingBase);
    }
	public ResourceLocation bindTexture(EntityOres ore)
	{
		return ore.getOreType() == 1 ? diamond : (ore.getOreType() == 2 ? emerald : (ore.getOreType() == 3 ? gold : (ore.getOreType() == 4 ? iron : (ore.getOreType() == 5 ? coal : (ore.getOreType() == 6 ? redstone : (ore.getOreType() == 7 ? netherQuartz : (ore.getOreType() == 8 ? lapislazuli : (ore.getOreType() == 9 ? copper : (ore.getOreType() == 10 ? tin : (ore.getOreType() == 11 ? uranium : noTexture))))))))));
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) 
	{
		return bindTexture((EntityOres)entity);
	}
    public void doRender(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderHurted((EntityOres)par1EntityLiving, par2, par4, par6, par8, par9);
    }
}
