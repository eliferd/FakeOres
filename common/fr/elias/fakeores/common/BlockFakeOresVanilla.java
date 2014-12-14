package fr.elias.fakeores.common;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockFakeOresVanilla extends Block
{
	public int type;
	
	public BlockFakeOresVanilla(int type)
	{
		super(Material.rock);
		setCreativeTab(FakeOres.fakeOresTab);
		this.type = type;
	}

	public void onBlockDestroyedByPlayer(World world, BlockPos pos, IBlockState state)
	{
		if(FMLCommonHandler.instance().getEffectiveSide().isClient() && world.rand.nextInt(20) == 0)
		{
			FMLClientHandler.instance().getClient().thePlayer.addChatMessage(new ChatComponentText("If your Minecraft is in peaceful mode, All fake ores is disabled. Just change your difficulty setting."));
		}
		if(!world.isRemote)
		{
			if(type == 0)
			{
				EntityDiamondOre diamondEntity = new EntityDiamondOre(world);
				diamondEntity.setLocationAndAngles(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, 0.0F, 0.0F);
				world.spawnEntityInWorld(diamondEntity);
			}
			if(type == 1)
			{
				EntityGoldOre goldEntity = new EntityGoldOre(world);
				goldEntity.setLocationAndAngles(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, 0.0F, 0.0F);
				world.spawnEntityInWorld(goldEntity);
			}
			if(type == 2)
			{
				EntityEmeraldOre emeraldEntity = new EntityEmeraldOre(world);
				emeraldEntity.setLocationAndAngles(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, 0.0F, 0.0F);
				world.spawnEntityInWorld(emeraldEntity);
			}
			if(type == 3)
			{
				EntityIronOre ironEntity = new EntityIronOre(world);
				ironEntity.setLocationAndAngles(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, 0.0F, 0.0F);
				world.spawnEntityInWorld(ironEntity);
			}
			if(type == 4)
			{
				EntityCoalOre coalEntity = new EntityCoalOre(world);
				coalEntity.setLocationAndAngles(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, 0.0F, 0.0F);
				world.spawnEntityInWorld(coalEntity);
			}
			if(type == 5)
			{
				EntityRedstoneOre redstoneEntity = new EntityRedstoneOre(world);
				redstoneEntity.setLocationAndAngles(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, 0.0F, 0.0F);
				world.spawnEntityInWorld(redstoneEntity);
			}
			if(type == 6)
			{
				EntityNetherQuartzOre nquartzEntity = new EntityNetherQuartzOre(world);
				nquartzEntity.setLocationAndAngles(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, 0.0F, 0.0F);
				world.spawnEntityInWorld(nquartzEntity);
			}
			if(type == 7)
			{
				EntityLapisLazuliOre lapisEntity = new EntityLapisLazuliOre(world);
				lapisEntity.setLocationAndAngles(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, 0.0F, 0.0F);
				world.spawnEntityInWorld(lapisEntity);
			}
			super.onBlockDestroyedByPlayer(world, pos, state);
		}
	}

	private Random rand = new Random();

	@Override
	public int getExpDrop(IBlockAccess world, BlockPos pos, int fortune)
	{
		if(this.getItemDropped(world.getBlockState(pos), rand, fortune) != Item.getItemFromBlock(this))
		{
			int j1 = 0;

			if(type == 4)
			{
				j1 = MathHelper.getRandomIntegerInRange(rand, 0, 2);
			}
			else if(type == 0)
			{
				j1 = MathHelper.getRandomIntegerInRange(rand, 3, 7);
			}
			else if(type == 2)
			{
				j1 = MathHelper.getRandomIntegerInRange(rand, 3, 7);
			}
			else if(type == 7)
			{
				j1 = MathHelper.getRandomIntegerInRange(rand, 2, 5);
			}
			else if(type == 6)
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
	}

	public int idPicked(World world, int par2, int par3, int par4)
	{
		return 0;
	}
	
    public boolean canSilkHarvest(World world, EntityPlayer player, int x, int y, int z, int metadata)
    {
    	return false;
    }
}
