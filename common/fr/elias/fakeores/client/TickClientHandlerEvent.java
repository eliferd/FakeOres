package fr.elias.fakeores.client;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
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
  		FontRenderer fontrenderer = mc.fontRendererObj;
	  	if(event.isCancelable() || event.type != ElementType.EXPERIENCE)
	  	{
	   		return;
	  	}
	  	ItemStack itemstack = mc.thePlayer.getCurrentEquippedItem();
		if(itemstack != null && itemstack.getItem() == FakeOres.fakeOres_finder)
		{
		  	if(mc.thePlayer.dimension == 1)
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
