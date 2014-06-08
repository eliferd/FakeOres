package fr.elias.fakeores.common;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockFakeOresVanilla extends Block
{
	public static String[] type = new String[] {"fakeDiamondOre", "fakeGoldOre", "fakeEmeraldOre", "fakeIronOre", "fakeCoalOre", "fakeRedstoneOre", "fakeNetherQuartz", "fakeLapisLazuli"};

	// diam = 0 : gold = 1 : emerald = 2 : iron = 3 : coal = 4 : red = 5 : quartz = 6 : lapis = 7

	public BlockFakeOresVanilla()
	{
		super(Material.rock);
		setCreativeTab(FakeOres.fakeOresTab);
	}

	public IIcon getIcon(int side, int metadata)
	{
		switch(metadata)
		{
		case 0:
			return Blocks.diamond_ore.getIcon(side, metadata);
		case 1:
			return Blocks.gold_ore.getIcon(side, metadata);
		case 2:
			return Blocks.emerald_ore.getIcon(side, metadata);
		case 3:
			return Blocks.iron_ore.getIcon(side, metadata);
		case 4:
			return Blocks.coal_ore.getIcon(side, metadata);
		case 5:
			return Blocks.redstone_ore.getIcon(side, metadata);
		case 6:
			return Blocks.quartz_ore.getIcon(side, metadata);
		case 7:
			return Blocks.lapis_ore.getIcon(side, metadata);
		default:
			return Blocks.stone.getIcon(side, metadata); // Unknown icon, bug !
		}
	}

	public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int metadata)
	{
		if(FMLCommonHandler.instance().getEffectiveSide().isClient() && world.difficultySetting == EnumDifficulty.PEACEFUL)
		{
			FMLClientHandler.instance().getClient().thePlayer.addChatMessage(new ChatComponentText("Your Minecraft is in peaceful mode. All fake ores are now disabled. Please change your difficulty setting."));
		}
		if(!world.isRemote)
		{
			if(metadata == 0)
			{
				EntityDiamondOre diamondEntity = new EntityDiamondOre(world);
				diamondEntity.setLocationAndAngles(x + 0.5, y, z + 0.5, 0.0F, 0.0F);
				world.spawnEntityInWorld(diamondEntity);
			}
			if(metadata == 1)
			{
				EntityGoldOre goldEntity = new EntityGoldOre(world);
				goldEntity.setLocationAndAngles(x + 0.5, y, z + 0.5, 0.0F, 0.0F);
				world.spawnEntityInWorld(goldEntity);
			}
			if(metadata == 2)
			{
				EntityEmeraldOre emeraldEntity = new EntityEmeraldOre(world);
				emeraldEntity.setLocationAndAngles(x + 0.5, y, z + 0.5, 0.0F, 0.0F);
				world.spawnEntityInWorld(emeraldEntity);
			}
			if(metadata == 3)
			{
				EntityIronOre ironEntity = new EntityIronOre(world);
				ironEntity.setLocationAndAngles(x + 0.5, y, z + 0.5, 0.0F, 0.0F);
				world.spawnEntityInWorld(ironEntity);
			}
			if(metadata == 4)
			{
				EntityCoalOre coalEntity = new EntityCoalOre(world);
				coalEntity.setLocationAndAngles(x + 0.5, y, z + 0.5, 0.0F, 0.0F);
				world.spawnEntityInWorld(coalEntity);
			}
			if(metadata == 5)
			{
				EntityRedstoneOre redstoneEntity = new EntityRedstoneOre(world);
				redstoneEntity.setLocationAndAngles(x + 0.5, y, z + 0.5, 0.0F, 0.0F);
				world.spawnEntityInWorld(redstoneEntity);
			}
			if(metadata == 6)
			{
				EntityNetherQuartzOre nquartzEntity = new EntityNetherQuartzOre(world);
				nquartzEntity.setLocationAndAngles(x + 0.5, y, z + 0.5, 0.0F, 0.0F);
				world.spawnEntityInWorld(nquartzEntity);
			}
			if(metadata == 7)
			{
				EntityLapisLazuliOre lapisEntity = new EntityLapisLazuliOre(world);
				lapisEntity.setLocationAndAngles(x + 0.5, y, z + 0.5, 0.0F, 0.0F);
				world.spawnEntityInWorld(lapisEntity);
			}
			super.onBlockDestroyedByPlayer(world, x, y, z, metadata);
		}
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs tab, List list)
	{
		for(int i = 0; i < type.length; i++)
			list.add(new ItemStack(item, 1, i));
	}

	private Random rand = new Random();

	@Override
	public int getExpDrop(IBlockAccess world, int metadata, int fortune)
	{
		if(this.getItemDropped(metadata, rand, fortune) != Item.getItemFromBlock(this))
		{
			int j1 = 0;

			if(metadata == 4)
			{
				j1 = MathHelper.getRandomIntegerInRange(rand, 0, 2);
			}
			else if(metadata == 0)
			{
				j1 = MathHelper.getRandomIntegerInRange(rand, 3, 7);
			}
			else if(metadata == 2)
			{
				j1 = MathHelper.getRandomIntegerInRange(rand, 3, 7);
			}
			else if(metadata == 7)
			{
				j1 = MathHelper.getRandomIntegerInRange(rand, 2, 5);
			}
			else if(metadata == 6)
			{
				j1 = MathHelper.getRandomIntegerInRange(rand, 2, 5);
			}
			return j1;
		}
		return 0;
	}

	public Item getItemDropped(int metadata, Random random, int fortune)
	{
		return null;
	}

	public int quantityDropped(Random par1Random)
	{
		return 0;
	} // BugFix 2

	public int idPicked(World world, int par2, int par3, int par4)
	{
		return 0;
	} // BugFix 3
	
    public boolean canSilkHarvest(World world, EntityPlayer player, int x, int y, int z, int metadata)
    {
    	return false;
    } // BugFix 4
	
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iiconRegister)
    {
    	//Empty, only using vanilla icon
    }
}
