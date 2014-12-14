package fr.elias.fakeores.common;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.util.DamageSource;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import fr.elias.fakeores.client.TickClientHandlerEvent;

@Mod(modid = "fakeores", name = "Fake Ores", version = "@VERSION@")
public class FakeOres
{
	@SidedProxy(clientSide = "fr.elias.fakeores.client.ClientProxy", serverSide = "fr.elias.fakeores.common.StaticProxy")
	public static StaticProxy proxy;

	@Instance("fakeores")
	public static FakeOres instance;

	public static DamageSource antiorestone;
	public static final CreativeTabs fakeOresTab = new CreativeTabs("fakeorestab")
	{
	    public Item getTabIconItem()
	    {
	        return FakeOres.antiOresBlade;
	    }
	};
	protected static final BiomeGenBase.Height height_fd_Biome = new BiomeGenBase.Height(0.0F, 0.5F);
	
	public static Block fakeDiamond,
						fakeEmerald,
						fakeGold,
						fakeIron,
						fakeCoal,
						fakeRedstone,
						fakeQuartz,
						fakeLapis,
						
	 					fakeCopper, 
	 					fakeTin, 
						fakeUranium,
						antiOreStone;
	public static Item antiOresBlade, 
					   fragment_part1, 
					   fragment_part2,
					   fragment_part3,
					   fragment_part4,
					   fragment_boss, 
					   oreBoss_Star,
					   fakeOres_finder;
	
	public int mob_diamondOreID,
			   mob_emeraldOreID,
			   mob_goldOreID,
			   mob_ironOreID,
			   mob_coalOreID,
			   mob_redstoneOreID,
			   mob_quartzOreID,
			   mob_lapisOreID,
			   /** IC2 ID ORES **/
			   mob_copperOreID,
			   mob_tinOreID,
			   mob_uraniumOreID,
			   /** ORES BOSS UTILS ID **/
			   mob_OreBOSSID,
			   mob_BOSS_TELEPORTER_ID;
	
	public static boolean enableFakeOres;
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		try {
			config.load();
			mob_diamondOreID =  config.get("Entity", "Fake Diamond Ore ID", 360).getInt();
			mob_emeraldOreID =  config.get("Entity", "Fake Emerald Ore ID", 361).getInt();
			mob_goldOreID =  config.get("Entity", "Fake Gold Ore ID", 362).getInt();
			mob_ironOreID =  config.get("Entity", "Fake Iron Ore ID", 363).getInt();
			mob_coalOreID =  config.get("Entity", "Fake Coal Ore ID", 364).getInt();
			mob_redstoneOreID =  config.get("Entity", "Fake Redstone Ore ID", 365).getInt();
			mob_quartzOreID =  config.get("Entity", "Fake Nether Quartz Ore ID", 366).getInt();
			mob_lapisOreID =  config.get("Entity", "Fake Lapis Lazuli Ore ID", 367).getInt();

			mob_copperOreID =  config.get("Entity", "Fake Copper Ore ID", 368).getInt();
			mob_tinOreID =  config.get("Entity", "Fake Tin Ore ID", 369).getInt();
			mob_uraniumOreID =  config.get("Entity", "Fake Uranium Ore ID", 370).getInt();

			mob_OreBOSSID =  config.get("Entity", "Ore BOSS Mob ID", 371).getInt();
			mob_BOSS_TELEPORTER_ID =  config.get("Entity", "Entity Teleporter Boss ID", 372).getInt();
			
			enableFakeOres = config.get("Spawn", "Enable Fake Ores", true).getBoolean(true);
			
			config.save();
		} finally {
			if(config.hasChanged())
			{
				config.save();
			}
		}
		if(Loader.isModLoaded("IC2"))
		{
			System.out.print("[FAKE ORES] INDUSTRIAL CRAFT 2 DETECTED ! LOADING FAKE IC2 ORES");
		}

		/** INIT PART [ITEMS] **/
		antiOresBlade = new ItemSword(Item.ToolMaterial.WOOD).setCreativeTab(FakeOres.fakeOresTab).setUnlocalizedName("antiOresBlade");
		fragment_part1 = new Item().setCreativeTab(FakeOres.fakeOresTab).setUnlocalizedName("bossframe_part1");
		fragment_part2 = new Item().setCreativeTab(FakeOres.fakeOresTab).setUnlocalizedName("bossframe_part2");
		fragment_part3 = new Item().setCreativeTab(FakeOres.fakeOresTab).setUnlocalizedName("bossframe_part3");
		fragment_part4 = new Item().setCreativeTab(FakeOres.fakeOresTab).setUnlocalizedName("bossframe_part4");
		fragment_boss = new ItemFragmentBoss().setCreativeTab(FakeOres.fakeOresTab).setUnlocalizedName("boss_frame").setFull3D();
		oreBoss_Star = new Item().setCreativeTab(FakeOres.fakeOresTab).setUnlocalizedName("oreBoss_Star");
		fakeOres_finder = new ItemFakeOresFinder().setCreativeTab(fakeOresTab).setUnlocalizedName("fakeOres_finder");
		/** INIT PART [BLOCKS] **/
		fakeDiamond = new BlockFakeOresVanilla(0).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypeStone).setUnlocalizedName("fakeDiamond");
		fakeEmerald = new BlockFakeOresVanilla(2).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypeStone).setUnlocalizedName("fakeEmerald");
		fakeGold = new BlockFakeOresVanilla(1).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypeStone).setUnlocalizedName("fakeGold");
		fakeIron = new BlockFakeOresVanilla(3).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypeStone).setUnlocalizedName("fakeIron");
		fakeCoal = new BlockFakeOresVanilla(4).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypeStone).setUnlocalizedName("fakeCoal");
		fakeRedstone = new BlockFakeOresVanilla(5).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypeStone).setUnlocalizedName("fakeRedstone");
		fakeQuartz = new BlockFakeOresVanilla(6).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypeStone).setUnlocalizedName("fakeQuartz");
		fakeLapis = new BlockFakeOresVanilla(7).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypeStone).setUnlocalizedName("fakeLapis");
		antiOreStone = new BlockAntiOreStone().setHardness(4.0F).setResistance(6F).setStepSound(Block.soundTypeStone).setUnlocalizedName("antiOreStone");
		if(Loader.isModLoaded("IC2"))
		{
			fakeCopper = new BlockFakeOres().setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypeStone).setUnlocalizedName("fakeCopper");
			fakeTin = new BlockFakeOres().setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypeStone).setUnlocalizedName("fakeTin");
			fakeUranium = new BlockFakeOres().setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypeStone).setUnlocalizedName("fakeUranium");
		}
		/** REGISTRY PART **/
		// REGISTRY [BLOCKS]
		GameRegistry.registerBlock(fakeDiamond, "fakeDiamond");
		GameRegistry.registerBlock(fakeEmerald, "fakeEmerald");
		GameRegistry.registerBlock(fakeGold, "fakeGold");
		GameRegistry.registerBlock(fakeIron, "fakeIron");
		GameRegistry.registerBlock(fakeCoal, "fakeCoal");
		GameRegistry.registerBlock(fakeRedstone, "fakeRedstone");
		GameRegistry.registerBlock(fakeQuartz, "fakeQuartz");
		GameRegistry.registerBlock(fakeLapis, "fakeLapis");
		
		GameRegistry.registerBlock(antiOreStone, "antiOreStone");
		if(Loader.isModLoaded("IC2"))
		{
			GameRegistry.registerBlock(fakeCopper, "fakeCopper");
			GameRegistry.registerBlock(fakeTin, "fakeTin");
			GameRegistry.registerBlock(fakeUranium, "fakeUranium");
		}
		// REGISTRY [ITEMS]
		GameRegistry.registerItem(antiOresBlade, "antiOresBlade", "fakeores");
		GameRegistry.registerItem(fragment_part1, "bossframe_part1", "fakeores");
		GameRegistry.registerItem(fragment_part2, "bossframe_part2", "fakeores");
		GameRegistry.registerItem(fragment_part3, "bossframe_part3", "fakeores");
		GameRegistry.registerItem(fragment_part4, "bossframe_part4", "fakeores");
		GameRegistry.registerItem(fragment_boss, "boss_frame", "fakeores");
		GameRegistry.registerItem(oreBoss_Star, "oreBoss_Star", "fakeores");
		GameRegistry.registerItem(fakeOres_finder, "fakeOres_finder", "fakeores");

		if(event.getSide().isClient())
		{
			FMLCommonHandler.instance().bus().register(new TickClientHandlerEvent());
			MinecraftForge.EVENT_BUS.register(new TickClientHandlerEvent());
		}
		
		antiorestone = new AntiOreStoneDamageSource("destroyedby");
		GameRegistry.registerWorldGenerator(new WorldGenFakeOres(), 0);
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		addEntity(EntityDiamondOre.class, "DiamondOre", mob_diamondOreID);
		addEntity(EntityEmeraldOre.class, "EmeraldOre", mob_emeraldOreID);
		addEntity(EntityGoldOre.class, "GoldOre", mob_goldOreID);
		addEntity(EntityIronOre.class, "IronOre", mob_ironOreID);
		addEntity(EntityCoalOre.class, "CoalOre", mob_coalOreID);
		addEntity(EntityRedstoneOre.class, "RedstoneOre", mob_redstoneOreID);
		addEntity(EntityNetherQuartzOre.class, "NetherQuartzOre", mob_quartzOreID);
		addEntity(EntityLapisLazuliOre.class, "LapisLazuliOre", mob_lapisOreID);
		if(Loader.isModLoaded("IC2"))
		{
			addEntity(EntityCopperOre.class, "CopperOre", mob_copperOreID);
			addEntity(EntityTinOre.class, "TinOre", mob_tinOreID);
			addEntity(EntityUraniumOre.class, "UraniumOre", mob_uraniumOreID);
		}
		addEntity(EntityOresBoss.class, "OresBoss", mob_OreBOSSID);
		EntityRegistry.registerModEntity(EntityBossTeleporter.class, "BossTeleporter", mob_BOSS_TELEPORTER_ID, this, 40, 1, true);
		proxy.loadRender();
		GameRegistry.addRecipe(new ItemStack(this.antiOresBlade, 1), new Object[] {"X", "X", "B", 'X', this.antiOreStone, 'B', Items.stick});
		GameRegistry.addRecipe(new ItemStack(this.fragment_boss, 1), new Object[] {"XSB", "SFS", "CSD", 'X', this.fragment_part1, 'B', this.fragment_part2, 'F', Blocks.iron_block, 'C', this.fragment_part4, 'D', this.fragment_part3, 'S', Items.gold_ingot});
		GameRegistry.addRecipe(new ItemStack(this.fakeOres_finder, 1), new Object[] {"XBX", "XSX", "XBX", 'X', Blocks.planks, 'B', Items.diamond, 'S', this.antiOresBlade});
	}

	public void addEntity(Class<? extends Entity> entityClass, String entityName, int id)
	{
		EntityRegistry.registerGlobalEntityID(entityClass, entityName, EntityRegistry.findGlobalUniqueEntityId(), 0, 0);
		EntityRegistry.registerModEntity(entityClass, entityName, id, this, 40, 1, true);
	}
}