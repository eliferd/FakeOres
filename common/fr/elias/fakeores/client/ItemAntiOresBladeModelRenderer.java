package fr.elias.fakeores.client;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

public class ItemAntiOresBladeModelRenderer implements IItemRenderer
{
	private ModelCubeWorld model3D;
	public ResourceLocation texture = new ResourceLocation("nulled");
	public ItemAntiOresBladeModelRenderer()
	{
		model3D = new ModelCubeWorld(ModelCubeWorld.class.getResourceAsStream("/assets/fakeores/models/antioresblade.cub"));
	}
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type)
	{
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
	{
		return false;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data)
	{
		float size = 2F;
		if(type.equals(ItemRenderType.EQUIPPED))
		{
			GL11.glPushMatrix();
			GL11.glScalef(size, size, size);
			GL11.glRotatef(-35F, 2F, 5F, 30F);
			GL11.glTranslatef(-0.58F, 0.2F, 0.48F);
			model3D.render();
			GL11.glPopMatrix();
		}
		else if (type.equals(ItemRenderType.EQUIPPED_FIRST_PERSON) )
		{
			GL11.glPushMatrix();
			GL11.glScalef(size - 0.5F, size - 0.5F, size - 0.5F);
			GL11.glRotatef(-65F, 1F, 5F, 20F);
			GL11.glTranslatef(-0.78F, 0.5F, 0.48F);
			GL11.glRotatef(-5F, -33F, 55F, 80F);
			GL11.glTranslatef(0.1f, 0.1f, 0.1f);
			model3D.render();
			GL11.glPopMatrix();

		}
		else if (type.equals(ItemRenderType.ENTITY) )
		{
			GL11.glPushMatrix();
			GL11.glScalef(size - 0F, size - 0F, size - 0F);
			GL11.glRotatef(0F, 2F, 5F, 30F);
			GL11.glTranslatef(-0.58F, 0.03F, 0.48F);
			model3D.render();
			GL11.glPopMatrix();
		}
		else
		{
			GL11.glPushMatrix();
			GL11.glScalef(size + 17F, size + 17F, size + 17F);
			GL11.glTranslatef(1.145F, 0.39F, 1F);
			GL11.glRotatef(-45F, 0, 0, 1);
			GL11.glRotatef(-200F, 0, 1, 0);
			GL11.glRotatef(-100F, 5, 0, 0);
			model3D.render();
			GL11.glPopMatrix();
		}
	}
}
