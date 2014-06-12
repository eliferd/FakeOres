package fr.elias.fakeores.client;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Loader;
import fr.elias.fakeores.common.EntityBlackMage;
import fr.elias.fakeores.common.EntityBossTeleporter;
import fr.elias.fakeores.common.EntityCoalOre;
import fr.elias.fakeores.common.EntityCopperOre;
import fr.elias.fakeores.common.EntityDiamondOre;
import fr.elias.fakeores.common.EntityEmeraldOre;
import fr.elias.fakeores.common.EntityFlyer;
import fr.elias.fakeores.common.EntityFlyer_Shield;
import fr.elias.fakeores.common.EntityGoldOre;
import fr.elias.fakeores.common.EntityIronOre;
import fr.elias.fakeores.common.EntityLapisLazuliOre;
import fr.elias.fakeores.common.EntityMageSpell;
import fr.elias.fakeores.common.EntityMutantMonster;
import fr.elias.fakeores.common.EntityNetherQuartzOre;
import fr.elias.fakeores.common.EntityOresBoss;
import fr.elias.fakeores.common.EntityPlayerHunter;
import fr.elias.fakeores.common.EntityRedstoneOre;
import fr.elias.fakeores.common.EntityRegenEgg;
import fr.elias.fakeores.common.EntitySchaza;
import fr.elias.fakeores.common.EntitySwimmerAnimal;
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
		RenderingRegistry.registerEntityRenderingHandler(EntityBossTeleporter.class, new RenderSnowball(FakeOres.fragment_boss));
		RenderingRegistry.registerEntityRenderingHandler(EntityPlayerHunter.class, new RenderPlayerHunter());
		RenderingRegistry.registerEntityRenderingHandler(EntityFlyer.class, new RenderFlyer());
		RenderingRegistry.registerEntityRenderingHandler(EntityFlyer_Shield.class, new RenderFlyer_Shield());
		RenderingRegistry.registerEntityRenderingHandler(EntitySchaza.class, new RenderSchaza());
		RenderingRegistry.registerEntityRenderingHandler(EntityBlackMage.class, new RenderBlackMage());
		RenderingRegistry.registerEntityRenderingHandler(EntityMageSpell.class, new RenderMageSpell());
		RenderingRegistry.registerEntityRenderingHandler(EntityRegenEgg.class, new RenderRegenEgg());
		RenderingRegistry.registerEntityRenderingHandler(EntityMutantMonster.class, new RenderMutantMonster());
		RenderingRegistry.registerEntityRenderingHandler(EntitySwimmerAnimal.class, new RenderSwimmerAnimal());
		
		MinecraftForgeClient.registerItemRenderer(FakeOres.antiOresBlade, new ItemAntiOresBladeModelRenderer());
		MinecraftForgeClient.registerItemRenderer(FakeOres.fakeOres_finder, new ItemFakeOresFinderRenderer());
		if(Loader.isModLoaded("IC2"))
		{
			RenderingRegistry.registerEntityRenderingHandler(EntityCopperOre.class, new RenderOre(new ModelOre()));
			RenderingRegistry.registerEntityRenderingHandler(EntityTinOre.class, new RenderOre(new ModelOre()));
			RenderingRegistry.registerEntityRenderingHandler(EntityUraniumOre.class, new RenderOre(new ModelOre()));
		}
	}
	public void spawnParticle(World world, String name, double x, double y, double z)
	{
		EntityFX fx = null;
		if(name == "smoke")
		{
			fx = new EntityCustomSmokeFX(world, x, y, z, 0.0D, 0.0D, 0.0D, 1F, FakeOres.texture_CustomSmokeFX_particle.getIconFromDamage(0));
		}else if(name == "blood")
		{
			fx = new EntityBloodFX(world, x, y, z, 1F, FakeOres.texture_BloodFX_particle.getIconFromDamage(0));
		}
		Minecraft.getMinecraft().effectRenderer.addEffect(fx);
	}
}
