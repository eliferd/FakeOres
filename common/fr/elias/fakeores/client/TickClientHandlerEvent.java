package fr.elias.fakeores.client;

import java.util.Random;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.client.event.TextureStitchEvent;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.common.gameevent.TickEvent.Type;
import fr.elias.fakeores.common.FakeOres;

public class TickClientHandlerEvent
{
	public Random random = new Random();
	public Minecraft mc;
	private static TickClientHandlerEvent INSTANCE = new TickClientHandlerEvent();
	public TickClientHandlerEvent()
	{
		mc = Minecraft.getMinecraft();
	}
	@SubscribeEvent
	public void onClientTick(TickEvent.ClientTickEvent clientTick)
	{
			if(clientTick.phase == Phase.START)
			{
				this.onTickStart(mc);
			}
			else
			{
				this.onTickEnd(mc);
			}
	}

	private void onTickEnd(Minecraft mc)
	{

	}

	private void onTickStart(Minecraft mc)
	{
		
	}
	
	@SubscribeEvent
	 public void onRenderExperienceBar(RenderGameOverlayEvent event)
	 {
		final Minecraft mc = FMLClientHandler.instance().getClient();
  		FontRenderer fontrenderer = mc.fontRenderer;
	  	if(event.isCancelable() || event.type != ElementType.EXPERIENCE)
	  	{
	   		return;
	  	}
	  	ItemStack itemstack = mc.thePlayer.getCurrentEquippedItem();
		if(itemstack != null && itemstack.getItem() == FakeOres.fakeOres_finder)
		{
		  	if(mc.thePlayer.dimension == FakeOres.dimID || mc.thePlayer.dimension == 1)
			{
		  		if(mc.gameSettings.showDebugInfo)
		  		{
			  		fontrenderer.drawStringWithShadow("Fake Ores Finder doesn't work in this dimension !", 2, 125, 0xEC0101);
			  		fontrenderer.drawStringWithShadow("But this item is working in these ones : Overworld / Nether", 2, 135, 0xEC8601);
		  		}else{
			  		fontrenderer.drawStringWithShadow("Fake Ores Finder doesn't work in this dimension !", 2, 5, 0xEC0101);
			  		fontrenderer.drawStringWithShadow("But this item is working in these ones : Overworld / Nether", 2, 15, 0xEC8601);
		  		}
			}
		}
	 }
	public static TickClientHandlerEvent instance()
	{
		return INSTANCE;
	}
}
