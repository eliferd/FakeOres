package fr.elias.fakeores.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Loader;
import fr.elias.fakeores.common.EntityBossTeleporter;
import fr.elias.fakeores.common.EntityCoalOre;
import fr.elias.fakeores.common.EntityCopperOre;
import fr.elias.fakeores.common.EntityDiamondOre;
import fr.elias.fakeores.common.EntityEmeraldOre;
import fr.elias.fakeores.common.EntityGoldOre;
import fr.elias.fakeores.common.EntityIronOre;
import fr.elias.fakeores.common.EntityLapisLazuliOre;
import fr.elias.fakeores.common.EntityNetherQuartzOre;
import fr.elias.fakeores.common.EntityOresBoss;
import fr.elias.fakeores.common.EntityRedstoneOre;
import fr.elias.fakeores.common.EntityTinOre;
import fr.elias.fakeores.common.EntityUraniumOre;
import fr.elias.fakeores.common.FakeOres;
import fr.elias.fakeores.common.StaticProxy;

public class ClientProxy extends StaticProxy {

	public void loadRender()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityDiamondOre.class, new RenderOre(new ModelOre()));
		RenderingRegistry.registerEntityRenderingHandler(EntityEmeraldOre.class, new RenderOre(new ModelOre()));
		RenderingRegistry.registerEntityRenderingHandler(EntityGoldOre.class, new RenderOre(new ModelOre()));
		RenderingRegistry.registerEntityRenderingHandler(EntityIronOre.class, new RenderOre(new ModelOre()));
		RenderingRegistry.registerEntityRenderingHandler(EntityCoalOre.class, new RenderOre(new ModelOre()));
		RenderingRegistry.registerEntityRenderingHandler(EntityRedstoneOre.class, new RenderOre(new ModelOre()));
		RenderingRegistry.registerEntityRenderingHandler(EntityNetherQuartzOre.class, new RenderOre(new ModelOre()));
		RenderingRegistry.registerEntityRenderingHandler(EntityLapisLazuliOre.class, new RenderOre(new ModelOre()));
		RenderingRegistry.registerEntityRenderingHandler(EntityOresBoss.class, new RenderOresBoss(new ModelOreBoss(), 1.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityBossTeleporter.class, new RenderSnowball(Minecraft.getMinecraft().getRenderManager(), FakeOres.fragment_boss, Minecraft.getMinecraft().getRenderItem()));
		if(Loader.isModLoaded("IC2"))
		{
			RenderingRegistry.registerEntityRenderingHandler(EntityCopperOre.class, new RenderOre(new ModelOre()));
			RenderingRegistry.registerEntityRenderingHandler(EntityTinOre.class, new RenderOre(new ModelOre()));
			RenderingRegistry.registerEntityRenderingHandler(EntityUraniumOre.class, new RenderOre(new ModelOre()));
		}

		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(FakeOres.fakeDiamond), 0, new ModelResourceLocation("fakeores:fakeDiamond", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(FakeOres.fakeEmerald), 0, new ModelResourceLocation("fakeores:fakeEmerald", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(FakeOres.fakeGold), 0, new ModelResourceLocation("fakeores:fakeGold", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(FakeOres.fakeIron), 0, new ModelResourceLocation("fakeores:fakeIron", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(FakeOres.fakeCoal), 0, new ModelResourceLocation("fakeores:fakeCoal", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(FakeOres.fakeRedstone), 0, new ModelResourceLocation("fakeores:fakeRedstone", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(FakeOres.fakeQuartz), 0, new ModelResourceLocation("fakeores:fakeQuartz", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(FakeOres.fakeLapis), 0, new ModelResourceLocation("fakeores:fakeLapis", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(FakeOres.antiOreStone), 0, new ModelResourceLocation("fakeores:antiOreStone", "inventory"));

	}
}
