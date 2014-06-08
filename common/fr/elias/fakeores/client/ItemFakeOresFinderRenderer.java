package fr.elias.fakeores.client;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

public class ItemFakeOresFinderRenderer implements IItemRenderer
{
	private ModelCubeWorld model3D;
	public ResourceLocation texture = new ResourceLocation("nulled");
	public ItemFakeOresFinderRenderer()
	{
		model3D = new ModelCubeWorld(ModelCubeWorld.class.getResourceAsStream("/assets/fakeores/models/fakeoresfinder.cub"));
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
			GL11.glRotatef(-15F, 50F, -32F, -70F);
			GL11.glRotatef(-75F, 250F, -8F, -30F);
			GL11.glTranslatef(-0.35F, -0.2F, 0.72F);
			model3D.render();
			GL11.glPopMatrix();
		}
		else if (type.equals(ItemRenderType.EQUIPPED_FIRST_PERSON))
		{
			GL11.glPushMatrix();
			GL11.glScalef(size - 0.5F, size - 0.5F, size - 0.5F);
			GL11.glRotatef(-65F, 1F, 5F, 5F);
			GL11.glTranslatef(-0.78F, 0.5F, 0.48F);
			GL11.glRotatef(-50F, 70F, 155F, -80F);
			GL11.glTranslatef(0.1f, 0.08f, -0.56f);
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
			GL11.glTranslatef(1.1F, 0.56F, 0F);
			GL11.glRotatef(45F, 0, 0, 5);
			GL11.glRotatef(195F, 0, 5, 0);
			GL11.glRotatef(100F, 5, 0, 0);
			model3D.render();
			GL11.glPopMatrix();
		}
	}
}
