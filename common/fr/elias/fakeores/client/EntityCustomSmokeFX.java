package fr.elias.fakeores.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class EntityCustomSmokeFX extends EntityFX 
{
    float smokeParticleScale;

    public EntityCustomSmokeFX(World par1World, double par2, double par4, double par6, double par8, double par10, double par12, float f, IIcon icon)
    {
        super(par1World, par2, par4, par6, par8, par10, par12);
        setSize(0.7F, 0.7F);
        setParticleIcon(icon);
        particleRed = 1.0F;
        particleBlue = 1.0F;
        particleGreen = 1.0F;
        particleGravity = -0.12F;
        particleScale = 2.0F;
        particleMaxAge = 20;
    }
	public int getFXLayer()
	{
		return 2;
	}
	public void renderParticle(Tessellator tessellator, float f, float f1, float f2, float f3, float f4, float f5)
    {
        float f6 = ((float)(this.particleTextureIndexX / 16.0F) + particleTextureJitterX / 14F) / 16F;
        float f7 = f6 + 0.01560938F;
        float f8 = ((float)(particleTextureIndexY / 16) + particleTextureJitterY / 14F) / 16F;
        float f9 = f8 + 0.01560938F;
        float f10 = 0.1F * particleScale;
        
        if (this.particleIcon != null)
        {
            f6 = this.particleIcon.getMinU();
            f7 = this.particleIcon.getMaxU();
            f8 = this.particleIcon.getMinV();
            f9 = this.particleIcon.getMaxV();
        }
        
        float f11 = (float)((prevPosX + (posX - prevPosX) * (double)f) - interpPosX);
        float f12 = (float)((prevPosY + (posY - prevPosY) * (double)f) - interpPosY);
        float f13 = (float)((prevPosZ + (posZ - prevPosZ) * (double)f) - interpPosZ);
        float f14 = getBrightness(f);
        tessellator.setColorOpaque_F(f14 * particleRed, f14 * particleGreen, f14 * particleBlue);
        tessellator.addVertexWithUV(f11 - f1 * f10 - f4 * f10, f12 - f2 * f10, f13 - f3 * f10 - f5 * f10, f6, f9);
        tessellator.addVertexWithUV((f11 - f1 * f10) + f4 * f10, f12 + f2 * f10, (f13 - f3 * f10) + f5 * f10, f6, f8);
        tessellator.addVertexWithUV(f11 + f1 * f10 + f4 * f10, f12 + f2 * f10, f13 + f3 * f10 + f5 * f10, f7, f8);
        tessellator.addVertexWithUV((f11 + f1 * f10) - f4 * f10, f12 - f2 * f10, (f13 + f3 * f10) - f5 * f10, f7, f9);
        super.renderParticle(tessellator, f, f1, f2, f3, f4, f5);
    }
}
