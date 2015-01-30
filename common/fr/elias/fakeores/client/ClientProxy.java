package fr.elias.fakeores.client;

import fr.elias.fakeores.client.model.ModelOre;
import fr.elias.fakeores.client.model.ModelOreBoss;
import fr.elias.fakeores.client.render.RenderBlackMage;
import fr.elias.fakeores.client.render.RenderDangerousPlant;
import fr.elias.fakeores.client.render.RenderFlyer;
import fr.elias.fakeores.client.render.RenderFlyer_Shield;
import fr.elias.fakeores.client.render.RenderMageSpell;
import fr.elias.fakeores.client.render.RenderMazeCreature;
import fr.elias.fakeores.client.render.RenderMutantMonster;
import fr.elias.fakeores.client.render.RenderNopeGrenade;
import fr.elias.fakeores.client.render.RenderNopeGuy;
import fr.elias.fakeores.client.render.RenderOre;
import fr.elias.fakeores.client.render.RenderOresBoss;
import fr.elias.fakeores.client.render.RenderPlayerHunter;
import fr.elias.fakeores.client.render.RenderRegenEgg;
import fr.elias.fakeores.client.render.RenderSchaza;
import fr.elias.fakeores.client.render.RenderStalker;
import fr.elias.fakeores.common.FakeOres;
import fr.elias.fakeores.common.StaticProxy;
import fr.elias.fakeores.common.entity.EntityBlackMage;
import fr.elias.fakeores.common.entity.EntityBossTeleporter;
import fr.elias.fakeores.common.entity.EntityCoalOre;
import fr.elias.fakeores.common.entity.EntityCopperOre;
import fr.elias.fakeores.common.entity.EntityDangerousPlant;
import fr.elias.fakeores.common.entity.EntityDiamondOre;
import fr.elias.fakeores.common.entity.EntityEmeraldOre;
import fr.elias.fakeores.common.entity.EntityFlyer;
import fr.elias.fakeores.common.entity.EntityFlyer_Shield;
import fr.elias.fakeores.common.entity.EntityGoldOre;
import fr.elias.fakeores.common.entity.EntityIronOre;
import fr.elias.fakeores.common.entity.EntityLapisLazuliOre;
import fr.elias.fakeores.common.entity.EntityMageSpell;
import fr.elias.fakeores.common.entity.EntityMazeCreature;
import fr.elias.fakeores.common.entity.EntityMutantMonster;
import fr.elias.fakeores.common.entity.EntityNetherQuartzOre;
import fr.elias.fakeores.common.entity.EntityNopeGrenade;
import fr.elias.fakeores.common.entity.EntityNopeGuy;
import fr.elias.fakeores.common.entity.EntityOresBoss;
import fr.elias.fakeores.common.entity.EntityPlayerHunter;
import fr.elias.fakeores.common.entity.EntityRedstoneOre;
import fr.elias.fakeores.common.entity.EntityRegenEgg;
import fr.elias.fakeores.common.entity.EntitySchaza;
import fr.elias.fakeores.common.entity.EntityStalker;
import fr.elias.fakeores.common.entity.EntityTinOre;
import fr.elias.fakeores.common.entity.EntityUraniumOre;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Loader;

public class ClientProxy extends StaticProxy
{
    @Override
    public void loadRender()
    {
        RenderManager manager = Minecraft.getMinecraft().getRenderManager();
        RenderingRegistry.registerEntityRenderingHandler(EntityDiamondOre.class, new RenderOre(manager, new ModelOre()));
        RenderingRegistry.registerEntityRenderingHandler(EntityEmeraldOre.class, new RenderOre(manager, new ModelOre()));
        RenderingRegistry.registerEntityRenderingHandler(EntityGoldOre.class, new RenderOre(manager, new ModelOre()));
        RenderingRegistry.registerEntityRenderingHandler(EntityIronOre.class, new RenderOre(manager, new ModelOre()));
        RenderingRegistry.registerEntityRenderingHandler(EntityCoalOre.class, new RenderOre(manager, new ModelOre()));
        RenderingRegistry.registerEntityRenderingHandler(EntityRedstoneOre.class, new RenderOre(manager, new ModelOre()));
        RenderingRegistry.registerEntityRenderingHandler(EntityNetherQuartzOre.class, new RenderOre(manager, new ModelOre()));
        RenderingRegistry.registerEntityRenderingHandler(EntityLapisLazuliOre.class, new RenderOre(manager, new ModelOre()));
        RenderingRegistry.registerEntityRenderingHandler(EntityOresBoss.class, new RenderOresBoss(manager, new ModelOreBoss(), 1.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityBossTeleporter.class, new RenderSnowball(manager, FakeOres.fragment_boss, Minecraft.getMinecraft().getRenderItem()));
        RenderingRegistry.registerEntityRenderingHandler(EntityPlayerHunter.class, new RenderPlayerHunter(manager));
        RenderingRegistry.registerEntityRenderingHandler(EntityFlyer.class, new RenderFlyer(manager));
        RenderingRegistry.registerEntityRenderingHandler(EntityFlyer_Shield.class, new RenderFlyer_Shield(manager));
        RenderingRegistry.registerEntityRenderingHandler(EntitySchaza.class, new RenderSchaza(manager));
        RenderingRegistry.registerEntityRenderingHandler(EntityBlackMage.class, new RenderBlackMage(manager));
        RenderingRegistry.registerEntityRenderingHandler(EntityMageSpell.class, new RenderMageSpell(manager));
        RenderingRegistry.registerEntityRenderingHandler(EntityRegenEgg.class, new RenderRegenEgg(manager));
        RenderingRegistry.registerEntityRenderingHandler(EntityMutantMonster.class, new RenderMutantMonster(manager));
        RenderingRegistry.registerEntityRenderingHandler(EntityNopeGuy.class, new RenderNopeGuy(manager));
        RenderingRegistry.registerEntityRenderingHandler(EntityDangerousPlant.class, new RenderDangerousPlant(manager));
        RenderingRegistry.registerEntityRenderingHandler(EntityNopeGrenade.class, new RenderNopeGrenade(manager, FakeOres.nopeGrenade));
        // MinecraftForgeClient.registerItemRenderer(FakeOres.antiOresBlade, new ItemAntiOresBladeModelRenderer());
        // MinecraftForgeClient.registerItemRenderer(FakeOres.fakeOres_finder, new ItemFakeOresFinderRenderer());
        if(Loader.isModLoaded("IC2"))
        {
            RenderingRegistry.registerEntityRenderingHandler(EntityCopperOre.class, new RenderOre(manager, new ModelOre()));
            RenderingRegistry.registerEntityRenderingHandler(EntityTinOre.class, new RenderOre(manager, new ModelOre()));
            RenderingRegistry.registerEntityRenderingHandler(EntityUraniumOre.class, new RenderOre(manager, new ModelOre()));
        }
        RenderingRegistry.registerEntityRenderingHandler(EntityStalker.class, new RenderStalker(manager, new ModelBiped(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityMazeCreature.class, new RenderMazeCreature(manager));
    }

    @Override
    public void spawnParticle(World world, String name, double x, double y, double z)
    {
        /*
         * EntityFX fx = null; if(name == "smoke") { fx = new EntityCustomSmokeFX(world, x, y, z, 0.0D, 0.0D, 0.0D, 1F, FakeOres.texture_CustomSmokeFX_particle.getIconFromDamage(0)); } else if(name == "blood") { fx = new EntityBloodFX(world, x, y, z, 1F); } else if(name == "nope") { fx = new EntityNopeFX(world, x, y, z, 0.0D, 0.0D, 0.0D, 1F, world.rand.nextInt(1) == 0 ? 2F : 0, world.rand.nextInt(1) == 0 ? 2F : 0F, world.rand.nextInt(1) == 0 ? 2F : 0F); } Minecraft.getMinecraft().effectRenderer.addEffect(fx);
         */
    }
}