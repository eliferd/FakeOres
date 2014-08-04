package fr.elias.fakeores.dimension;

import static net.minecraftforge.common.ChestGenHooks.DUNGEON_CHEST;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.ChestGenHooks;
import fr.elias.fakeores.common.FakeOres;

public class WorldGenMaze extends WorldGenerator 
{

	public boolean generate(World world, Random rand, int x, int y, int z) 
	{
		if(world.getBlock(x, y, z) != FakeOres.fd_stone || world.getBlock(x + 14, y + 4, z + 12) != FakeOres.fd_stone || world.getBlock(x, y + 4, z + 12) != FakeOres.fd_stone|| world.getBlock(x + 14, y, z) != FakeOres.fd_stone)
		{
			System.out.println("[Fake Ores] MAZE NOT GENERATED AT " + x + "  " + y + "   " + z);
			return false;
		}
		System.out.println("[Fake Ores] MAZE GENERATION SUCCESS " + x + "  " + y + "   " + z);
		world.setBlock(x + 0, y + 0, z + 0, Blocks.bedrock);
		world.setBlock(x + 0, y + 0, z + 1, Blocks.bedrock);
		world.setBlock(x + 0, y + 0, z + 2, Blocks.bedrock);
		world.setBlock(x + 0, y + 0, z + 3, Blocks.bedrock);
		world.setBlock(x + 0, y + 0, z + 4, Blocks.bedrock);
		world.setBlock(x + 0, y + 1, z + 0, Blocks.bedrock);
		world.setBlock(x + 0, y + 1, z + 1, Blocks.bedrock);
		world.setBlock(x + 0, y + 1, z + 2, Blocks.bedrock);
		world.setBlock(x + 0, y + 1, z + 3, Blocks.bedrock);
		world.setBlock(x + 0, y + 1, z + 4, Blocks.bedrock);
		world.setBlock(x + 0, y + 2, z + 0, Blocks.bedrock);
		world.setBlock(x + 0, y + 2, z + 1, Blocks.bedrock);
		world.setBlock(x + 0, y + 2, z + 2, Blocks.bedrock);
		world.setBlock(x + 0, y + 2, z + 3, Blocks.bedrock);
		world.setBlock(x + 0, y + 2, z + 4, Blocks.bedrock);
		world.setBlock(x + 0, y + 3, z + 0, Blocks.bedrock);
		world.setBlock(x + 0, y + 3, z + 1, Blocks.bedrock);
		world.setBlock(x + 0, y + 3, z + 2, Blocks.bedrock);
		world.setBlock(x + 0, y + 3, z + 3, Blocks.bedrock);
		world.setBlock(x + 0, y + 3, z + 4, Blocks.bedrock);
		world.setBlock(x + 1, y + 0, z + 0, Blocks.bedrock);
		world.setBlock(x + 1, y + 0, z + 1, Blocks.bedrock);
		world.setBlock(x + 1, y + 0, z + 2, Blocks.bedrock);
		world.setBlock(x + 1, y + 0, z + 3, Blocks.bedrock);
		world.setBlock(x + 1, y + 0, z + 4, Blocks.bedrock);
		world.setBlock(x + 1, y + 1, z + 0, Blocks.bedrock);
		world.setBlock(x + 1, y + 1, z + 1, Blocks.chest);
		TileEntityChest bigchest1 = (TileEntityChest)world.getTileEntity(x + 1, y + 1, z + 1);
		if(bigchest1 != null)
		{
			for(int i = 0; i< rand.nextInt(bigchest1.getSizeInventory()); i++)
			{
				bigchest1.setInventorySlotContents(rand.nextInt(bigchest1.getSizeInventory()), pickRandomItemMaxiChest(rand));
			}
		}
		world.setBlock(x + 1, y + 1, z + 2, Blocks.air);
		world.setBlock(x + 1, y + 1, z + 3, Blocks.chest);
		TileEntityChest bigchest11 = (TileEntityChest)world.getTileEntity(x + 1, y + 1, z + 3);
		if(bigchest11 != null)
		{
			for(int i = 0; i< rand.nextInt(bigchest11.getSizeInventory()); i++)
			{
				bigchest11.setInventorySlotContents(rand.nextInt(bigchest11.getSizeInventory()), pickRandomItemMaxiChest(rand));
			}
		}
		world.setBlock(x + 1, y + 1, z + 4, Blocks.bedrock);
		world.setBlock(x + 1, y + 2, z + 0, Blocks.bedrock);
		world.setBlock(x + 1, y + 2, z + 2, Blocks.air);
		world.setBlock(x + 1, y + 2, z + 4, Blocks.bedrock);
		world.setBlock(x + 1, y + 3, z + 0, Blocks.bedrock);
		world.setBlock(x + 1, y + 3, z + 1, Blocks.bedrock);
		world.setBlock(x + 1, y + 3, z + 2, Blocks.bedrock);
		world.setBlock(x + 1, y + 3, z + 3, Blocks.bedrock);
		world.setBlock(x + 1, y + 3, z + 4, Blocks.bedrock);
		world.setBlock(x + 2, y + 0, z + 0, Blocks.bedrock);
		world.setBlock(x + 2, y + 0, z + 1, Blocks.bedrock);
		world.setBlock(x + 2, y + 0, z + 2, Blocks.bedrock);
		world.setBlock(x + 2, y + 0, z + 3, Blocks.bedrock);
		world.setBlock(x + 2, y + 0, z + 4, Blocks.bedrock);
		world.setBlock(x + 2, y + 1, z + 0, Blocks.bedrock);
		world.setBlock(x + 2, y + 1, z + 1, Blocks.chest);
		TileEntityChest bigchest111 = (TileEntityChest)world.getTileEntity(x + 2, y + 1, z + 1);
		if(bigchest111 != null)
		{
			for(int i = 0; i< rand.nextInt(bigchest111.getSizeInventory()); i++)
			{
				bigchest111.setInventorySlotContents(rand.nextInt(bigchest111.getSizeInventory()), pickRandomItemMaxiChest(rand));
			}
		}
		world.setBlock(x + 2, y + 1, z + 2, Blocks.air);
		world.setBlock(x + 2, y + 1, z + 3, Blocks.chest);
		TileEntityChest bigchest1111 = (TileEntityChest)world.getTileEntity(x + 2, y + 1, z + 3);
		if(bigchest1111 != null)
		{
			for(int i = 0; i< rand.nextInt(bigchest1111.getSizeInventory()); i++)
			{
				bigchest1111.setInventorySlotContents(rand.nextInt(bigchest1111.getSizeInventory()), pickRandomItemMaxiChest(rand));
			}
		}
		world.setBlock(x + 2, y + 1, z + 4, Blocks.bedrock);
		world.setBlock(x + 2, y + 2, z + 0, Blocks.bedrock);
		world.setBlock(x + 2, y + 2, z + 2, Blocks.air);
		world.setBlock(x + 2, y + 2, z + 4, Blocks.bedrock);
		world.setBlock(x + 2, y + 3, z + 0, Blocks.bedrock);
		world.setBlock(x + 2, y + 3, z + 1, Blocks.bedrock);
		world.setBlock(x + 2, y + 3, z + 2, Blocks.bedrock);
		world.setBlock(x + 2, y + 3, z + 3, Blocks.bedrock);
		world.setBlock(x + 2, y + 3, z + 4, Blocks.bedrock);
		world.setBlock(x + 3, y + 0, z + 0, Blocks.bedrock);
		world.setBlock(x + 3, y + 0, z + 1, Blocks.bedrock);
		world.setBlock(x + 3, y + 0, z + 2, Blocks.bedrock);
		world.setBlock(x + 3, y + 0, z + 3, Blocks.bedrock);
		world.setBlock(x + 3, y + 0, z + 4, Blocks.bedrock);
		world.setBlock(x + 3, y + 1, z + 0, Blocks.bedrock);
		world.setBlock(x + 3, y + 1, z + 1, Blocks.bedrock);
		world.setBlock(x + 3, y + 1, z + 2, Blocks.air);
		world.setBlock(x + 3, y + 1, z + 3, Blocks.bedrock);
		world.setBlock(x + 3, y + 1, z + 4, Blocks.bedrock);
		world.setBlock(x + 3, y + 2, z + 0, Blocks.bedrock);
		world.setBlock(x + 3, y + 2, z + 1, Blocks.bedrock);
		world.setBlock(x + 3, y + 2, z + 2, Blocks.air);
		world.setBlock(x + 3, y + 2, z + 3, Blocks.bedrock);
		world.setBlock(x + 3, y + 2, z + 4, Blocks.bedrock);
		world.setBlock(x + 3, y + 3, z + 0, Blocks.bedrock);
		world.setBlock(x + 3, y + 3, z + 1, Blocks.bedrock);
		world.setBlock(x + 3, y + 3, z + 2, Blocks.bedrock);
		world.setBlock(x + 3, y + 3, z + 3, Blocks.bedrock);
		world.setBlock(x + 3, y + 3, z + 4, Blocks.bedrock);
		world.setBlock(x + 4, y + 0, z + 0, Blocks.bedrock);
		world.setBlock(x + 4, y + 0, z + 1, Blocks.bedrock);
		world.setBlock(x + 4, y + 0, z + 2, Blocks.bedrock);
		world.setBlock(x + 4, y + 0, z + 3, Blocks.bedrock);
		world.setBlock(x + 4, y + 0, z + 4, Blocks.bedrock);
		world.setBlock(x + 4, y + 1, z + 0, Blocks.bedrock);
		world.setBlock(x + 4, y + 1, z + 1, Blocks.bedrock);
		world.setBlock(x + 4, y + 1, z + 2, Blocks.air);
		world.setBlock(x + 4, y + 1, z + 3, Blocks.bedrock);
		world.setBlock(x + 4, y + 1, z + 4, Blocks.bedrock);
		world.setBlock(x + 4, y + 2, z + 0, Blocks.bedrock);
		world.setBlock(x + 4, y + 2, z + 1, Blocks.bedrock);
		world.setBlock(x + 4, y + 2, z + 2, Blocks.air);
		world.setBlock(x + 4, y + 2, z + 3, Blocks.bedrock);
		world.setBlock(x + 4, y + 2, z + 4, Blocks.bedrock);
		world.setBlock(x + 4, y + 3, z + 0, Blocks.bedrock);
		world.setBlock(x + 4, y + 3, z + 1, Blocks.bedrock);
		world.setBlock(x + 4, y + 3, z + 2, Blocks.bedrock);
		world.setBlock(x + 4, y + 3, z + 3, Blocks.bedrock);
		world.setBlock(x + 4, y + 3, z + 4, Blocks.bedrock);
		world.setBlock(x + 5, y + 0, z + 0, Blocks.bedrock);
		world.setBlock(x + 5, y + 0, z + 1, Blocks.bedrock);
		world.setBlock(x + 5, y + 0, z + 2, Blocks.bedrock);
		world.setBlock(x + 5, y + 0, z + 3, Blocks.bedrock);
		world.setBlock(x + 5, y + 0, z + 4, Blocks.bedrock);
		world.setBlock(x + 5, y + 0, z + 5, Blocks.bedrock);
		world.setBlock(x + 5, y + 0, z + 6, Blocks.bedrock);
		world.setBlock(x + 5, y + 0, z + 7, Blocks.bedrock);
		world.setBlock(x + 5, y + 0, z + 8, Blocks.bedrock);
		world.setBlock(x + 5, y + 0, z + 9, Blocks.bedrock);
		world.setBlock(x + 5, y + 0, z + 10, Blocks.bedrock);
		world.setBlock(x + 5, y + 0, z + 11, Blocks.bedrock);
		world.setBlock(x + 5, y + 0, z + 12, Blocks.bedrock);
		world.setBlock(x + 5, y + 1, z + 0, Blocks.bedrock);
		world.setBlock(x + 5, y + 1, z + 1, Blocks.bedrock);
		world.setBlock(x + 5, y + 1, z + 2, Blocks.air);
		world.setBlock(x + 5, y + 1, z + 3, Blocks.bedrock);
		world.setBlock(x + 5, y + 1, z + 4, Blocks.bedrock);
		world.setBlock(x + 5, y + 1, z + 5, Blocks.bedrock);
		world.setBlock(x + 5, y + 1, z + 6, Blocks.bedrock);
		world.setBlock(x + 5, y + 1, z + 7, Blocks.bedrock);
		world.setBlock(x + 5, y + 1, z + 8, Blocks.bedrock);
		world.setBlock(x + 5, y + 1, z + 9, Blocks.bedrock);
		world.setBlock(x + 5, y + 1, z + 10, Blocks.bedrock);
		world.setBlock(x + 5, y + 1, z + 11, Blocks.bedrock);
		world.setBlock(x + 5, y + 1, z + 12, Blocks.bedrock);
		world.setBlock(x + 5, y + 2, z + 0, Blocks.bedrock);
		world.setBlock(x + 5, y + 2, z + 1, Blocks.bedrock);
		world.setBlock(x + 5, y + 2, z + 2, Blocks.air);
		world.setBlock(x + 5, y + 2, z + 3, Blocks.bedrock);
		world.setBlock(x + 5, y + 2, z + 4, Blocks.bedrock);
		world.setBlock(x + 5, y + 2, z + 5, Blocks.bedrock);
		world.setBlock(x + 5, y + 2, z + 6, Blocks.bedrock);
		world.setBlock(x + 5, y + 2, z + 7, Blocks.bedrock);
		world.setBlock(x + 5, y + 2, z + 8, Blocks.bedrock);
		world.setBlock(x + 5, y + 2, z + 9, Blocks.bedrock);
		world.setBlock(x + 5, y + 2, z + 10, Blocks.bedrock);
		world.setBlock(x + 5, y + 2, z + 11, Blocks.bedrock);
		world.setBlock(x + 5, y + 2, z + 12, Blocks.bedrock);
		world.setBlock(x + 5, y + 3, z + 0, Blocks.bedrock);
		world.setBlock(x + 5, y + 3, z + 1, Blocks.bedrock);
		world.setBlock(x + 5, y + 3, z + 2, Blocks.bedrock);
		world.setBlock(x + 5, y + 3, z + 3, Blocks.bedrock);
		world.setBlock(x + 5, y + 3, z + 4, Blocks.bedrock);
		world.setBlock(x + 5, y + 3, z + 5, Blocks.bedrock);
		world.setBlock(x + 5, y + 3, z + 6, Blocks.bedrock);
		world.setBlock(x + 5, y + 3, z + 7, Blocks.bedrock);
		world.setBlock(x + 5, y + 3, z + 8, Blocks.bedrock);
		world.setBlock(x + 5, y + 3, z + 9, Blocks.bedrock);
		world.setBlock(x + 5, y + 3, z + 10, Blocks.bedrock);
		world.setBlock(x + 5, y + 3, z + 11, Blocks.bedrock);
		world.setBlock(x + 5, y + 3, z + 12, Blocks.bedrock);
		world.setBlock(x + 6, y + 0, z + 0, Blocks.bedrock);
		world.setBlock(x + 6, y + 0, z + 1, Blocks.bedrock);
		world.setBlock(x + 6, y + 0, z + 2, Blocks.bedrock);
		world.setBlock(x + 6, y + 0, z + 3, Blocks.bedrock);
		world.setBlock(x + 6, y + 0, z + 4, Blocks.bedrock);
		world.setBlock(x + 6, y + 0, z + 5, Blocks.bedrock);
		world.setBlock(x + 6, y + 0, z + 6, Blocks.bedrock);
		world.setBlock(x + 6, y + 0, z + 7, Blocks.bedrock);
		world.setBlock(x + 6, y + 0, z + 8, Blocks.bedrock);
		world.setBlock(x + 6, y + 0, z + 9, Blocks.bedrock);
		world.setBlock(x + 6, y + 0, z + 10, Blocks.bedrock);
		world.setBlock(x + 6, y + 0, z + 11, Blocks.bedrock);
		world.setBlock(x + 6, y + 0, z + 12, Blocks.bedrock);
		world.setBlock(x + 6, y + 1, z + 0, Blocks.bedrock);
		world.setBlock(x + 6, y + 1, z + 1, Blocks.air);
		world.setBlock(x + 6, y + 1, z + 2, Blocks.air);
		world.setBlock(x + 6, y + 1, z + 3, Blocks.bedrock);
		world.setBlock(x + 6, y + 1, z + 4, Blocks.air);
		world.setBlock(x + 6, y + 1, z + 5, Blocks.air);
		world.setBlock(x + 6, y + 1, z + 6, Blocks.air);
		world.setBlock(x + 6, y + 1, z + 7, Blocks.air);
		world.setBlock(x + 6, y + 1, z + 8, Blocks.air);
		world.setBlock(x + 6, y + 1, z + 9, Blocks.air);
		world.setBlock(x + 6, y + 1, z + 10, Blocks.air);
		world.setBlock(x + 6, y + 1, z + 11, Blocks.air);
		world.setBlock(x + 6, y + 1, z + 12, Blocks.bedrock);
		world.setBlock(x + 6, y + 2, z + 0, Blocks.bedrock);
		world.setBlock(x + 6, y + 2, z + 1, Blocks.air);
		world.setBlock(x + 6, y + 2, z + 2, Blocks.air);
		world.setBlock(x + 6, y + 2, z + 3, Blocks.bedrock);
		world.setBlock(x + 6, y + 2, z + 5, Blocks.air);
		world.setBlock(x + 6, y + 2, z + 6, Blocks.air);
		world.setBlock(x + 6, y + 2, z + 7, Blocks.air);
		world.setBlock(x + 6, y + 2, z + 8, Blocks.air);
		world.setBlock(x + 6, y + 2, z + 9, Blocks.air);
		world.setBlock(x + 6, y + 2, z + 10, Blocks.air);
		world.setBlock(x + 6, y + 2, z + 11, Blocks.air);
		world.setBlock(x + 6, y + 2, z + 12, Blocks.bedrock);
		world.setBlock(x + 6, y + 3, z + 0, Blocks.bedrock);
		world.setBlock(x + 6, y + 3, z + 1, Blocks.bedrock);
		world.setBlock(x + 6, y + 3, z + 2, Blocks.bedrock);
		world.setBlock(x + 6, y + 3, z + 3, Blocks.bedrock);
		world.setBlock(x + 6, y + 3, z + 4, Blocks.bedrock);
		world.setBlock(x + 6, y + 3, z + 5, Blocks.bedrock);
		world.setBlock(x + 6, y + 3, z + 6, Blocks.bedrock);
		world.setBlock(x + 6, y + 3, z + 7, Blocks.bedrock);
		world.setBlock(x + 6, y + 3, z + 8, Blocks.bedrock);
		world.setBlock(x + 6, y + 3, z + 9, Blocks.bedrock);
		world.setBlock(x + 6, y + 3, z + 10, Blocks.bedrock);
		world.setBlock(x + 6, y + 3, z + 11, Blocks.bedrock);
		world.setBlock(x + 6, y + 3, z + 12, Blocks.bedrock);
		world.setBlock(x + 7, y + 0, z + 0, Blocks.bedrock);
		world.setBlock(x + 7, y + 0, z + 1, Blocks.bedrock);
		world.setBlock(x + 7, y + 0, z + 2, Blocks.bedrock);
		world.setBlock(x + 7, y + 0, z + 3, Blocks.bedrock);
		world.setBlock(x + 7, y + 0, z + 4, Blocks.bedrock);
		world.setBlock(x + 7, y + 0, z + 5, Blocks.bedrock);
		world.setBlock(x + 7, y + 0, z + 6, Blocks.bedrock);
		world.setBlock(x + 7, y + 0, z + 7, Blocks.bedrock);
		world.setBlock(x + 7, y + 0, z + 8, Blocks.bedrock);
		world.setBlock(x + 7, y + 0, z + 9, Blocks.bedrock);
		world.setBlock(x + 7, y + 0, z + 10, Blocks.bedrock);
		world.setBlock(x + 7, y + 0, z + 11, Blocks.bedrock);
		world.setBlock(x + 7, y + 0, z + 12, Blocks.bedrock);
		world.setBlock(x + 7, y + 1, z + 0, Blocks.bedrock);
		world.setBlock(x + 7, y + 1, z + 1, Blocks.air);
		world.setBlock(x + 7, y + 1, z + 2, Blocks.bedrock);
		world.setBlock(x + 7, y + 1, z + 3, Blocks.bedrock);
		world.setBlock(x + 7, y + 1, z + 4, Blocks.iron_bars);
		world.setBlock(x + 7, y + 1, z + 5, Blocks.bedrock);
		world.setBlock(x + 7, y + 1, z + 6, Blocks.air);
		world.setBlock(x + 7, y + 1, z + 7, Blocks.bedrock);
		world.setBlock(x + 7, y + 1, z + 8, Blocks.bedrock);
		world.setBlock(x + 7, y + 1, z + 9, Blocks.bedrock);
		world.setBlock(x + 7, y + 1, z + 10, Blocks.bedrock);
		world.setBlock(x + 7, y + 1, z + 11, Blocks.air);
		world.setBlock(x + 7, y + 1, z + 12, Blocks.bedrock);
		world.setBlock(x + 7, y + 2, z + 0, Blocks.bedrock);
		world.setBlock(x + 7, y + 2, z + 1, Blocks.air);
		world.setBlock(x + 7, y + 2, z + 2, Blocks.bedrock);
		world.setBlock(x + 7, y + 2, z + 3, Blocks.bedrock);
		world.setBlock(x + 7, y + 2, z + 4, Blocks.iron_bars);
		world.setBlock(x + 7, y + 2, z + 5, Blocks.bedrock);
		world.setBlock(x + 7, y + 2, z + 6, Blocks.air);
		world.setBlock(x + 7, y + 2, z + 7, Blocks.bedrock);
		world.setBlock(x + 7, y + 2, z + 8, Blocks.bedrock);
		world.setBlock(x + 7, y + 2, z + 9, Blocks.bedrock);
		world.setBlock(x + 7, y + 2, z + 10, Blocks.bedrock);
		world.setBlock(x + 7, y + 2, z + 11, Blocks.air);
		world.setBlock(x + 7, y + 2, z + 12, Blocks.bedrock);
		world.setBlock(x + 7, y + 3, z + 0, Blocks.bedrock);
		world.setBlock(x + 7, y + 3, z + 1, Blocks.bedrock);
		world.setBlock(x + 7, y + 3, z + 2, Blocks.bedrock);
		world.setBlock(x + 7, y + 3, z + 3, Blocks.bedrock);
		world.setBlock(x + 7, y + 3, z + 4, Blocks.bedrock);
		world.setBlock(x + 7, y + 3, z + 5, Blocks.bedrock);
		world.setBlock(x + 7, y + 3, z + 6, Blocks.bedrock);
		world.setBlock(x + 7, y + 3, z + 7, Blocks.bedrock);
		world.setBlock(x + 7, y + 3, z + 8, Blocks.bedrock);
		world.setBlock(x + 7, y + 3, z + 9, Blocks.bedrock);
		world.setBlock(x + 7, y + 3, z + 10, Blocks.bedrock);
		world.setBlock(x + 7, y + 3, z + 11, Blocks.bedrock);
		world.setBlock(x + 7, y + 3, z + 12, Blocks.bedrock);
		world.setBlock(x + 8, y + 0, z + 0, Blocks.bedrock);
		world.setBlock(x + 8, y + 0, z + 1, Blocks.bedrock);
		world.setBlock(x + 8, y + 0, z + 2, Blocks.bedrock);
		world.setBlock(x + 8, y + 0, z + 3, Blocks.bedrock);
		world.setBlock(x + 8, y + 0, z + 4, Blocks.bedrock);
		world.setBlock(x + 8, y + 0, z + 5, Blocks.bedrock);
		world.setBlock(x + 8, y + 0, z + 6, Blocks.bedrock);
		world.setBlock(x + 8, y + 0, z + 7, Blocks.bedrock);
		world.setBlock(x + 8, y + 0, z + 8, Blocks.bedrock);
		world.setBlock(x + 8, y + 0, z + 9, Blocks.bedrock);
		world.setBlock(x + 8, y + 0, z + 10, Blocks.bedrock);
		world.setBlock(x + 8, y + 0, z + 11, Blocks.bedrock);
		world.setBlock(x + 8, y + 0, z + 12, Blocks.bedrock);
		world.setBlock(x + 8, y + 1, z + 0, Blocks.bedrock);
		world.setBlock(x + 8, y + 1, z + 1, Blocks.air);
		world.setBlock(x + 8, y + 1, z + 2, Blocks.air);
		world.setBlock(x + 8, y + 1, z + 3, Blocks.bedrock);
		world.setBlock(x + 8, y + 1, z + 4, Blocks.chest, 4, 3);
		TileEntityChest chest1 = (TileEntityChest)world.getTileEntity(x + 8, y + 1, z + 4);
		if(chest1 != null)
		{//TODO
			ItemStack itemstack = pickRandomItemMiniChest(rand);
			chest1.setInventorySlotContents(rand.nextInt(chest1.getSizeInventory()), itemstack);
			chest1.setInventorySlotContents(rand.nextInt(chest1.getSizeInventory()), itemstack);
			chest1.setInventorySlotContents(rand.nextInt(chest1.getSizeInventory()), itemstack);
			chest1.setInventorySlotContents(rand.nextInt(chest1.getSizeInventory()), itemstack);
			chest1.setInventorySlotContents(rand.nextInt(chest1.getSizeInventory()), itemstack);
			chest1.setInventorySlotContents(rand.nextInt(chest1.getSizeInventory()), itemstack);
		}
		world.setBlock(x + 8, y + 1, z + 5, Blocks.mob_spawner);
		TileEntityMobSpawner firstSpawner = (TileEntityMobSpawner)world.getTileEntity(x + 8, y + 1, z + 5);
		if(firstSpawner != null)
		{
			firstSpawner.func_145881_a().setEntityName("Skeleton");
		}else
		{
			System.out.println("[FakeOres] Failed to load entity in the monster spawner... (IN A MAZE !)");
		}
		world.setBlock(x + 8, y + 1, z + 6, Blocks.bedrock);
		world.setBlock(x + 8, y + 1, z + 7, Blocks.bedrock);
		world.setBlock(x + 8, y + 1, z + 8, Blocks.air);
		world.setBlock(x + 8, y + 1, z + 9, Blocks.air);
		world.setBlock(x + 8, y + 1, z + 10, Blocks.air);
		world.setBlock(x + 8, y + 1, z + 11, Blocks.air);
		world.setBlock(x + 8, y + 1, z + 12, Blocks.bedrock);
		world.setBlock(x + 8, y + 2, z + 0, Blocks.bedrock);
		world.setBlock(x + 8, y + 2, z + 1, Blocks.air);
		world.setBlock(x + 8, y + 2, z + 2, Blocks.air);
		world.setBlock(x + 8, y + 2, z + 3, Blocks.bedrock);
		world.setBlock(x + 8, y + 2, z + 4, Blocks.air);
		world.setBlock(x + 8, y + 2, z + 5, Blocks.bedrock);
		world.setBlock(x + 8, y + 2, z + 6, Blocks.bedrock);
		world.setBlock(x + 8, y + 2, z + 7, Blocks.bedrock);
		world.setBlock(x + 8, y + 2, z + 8, Blocks.air);
		world.setBlock(x + 8, y + 2, z + 9, Blocks.air);
		world.setBlock(x + 8, y + 2, z + 10, Blocks.air);
		world.setBlock(x + 8, y + 2, z + 11, Blocks.air);
		world.setBlock(x + 8, y + 2, z + 12, Blocks.bedrock);
		world.setBlock(x + 8, y + 3, z + 0, Blocks.bedrock);
		world.setBlock(x + 8, y + 3, z + 1, Blocks.bedrock);
		world.setBlock(x + 8, y + 3, z + 2, Blocks.bedrock);
		world.setBlock(x + 8, y + 3, z + 3, Blocks.bedrock);
		world.setBlock(x + 8, y + 3, z + 4, Blocks.bedrock);
		world.setBlock(x + 8, y + 3, z + 5, Blocks.bedrock);
		world.setBlock(x + 8, y + 3, z + 6, Blocks.bedrock);
		world.setBlock(x + 8, y + 3, z + 7, Blocks.bedrock);
		world.setBlock(x + 8, y + 3, z + 8, Blocks.bedrock);
		world.setBlock(x + 8, y + 3, z + 9, Blocks.bedrock);
		world.setBlock(x + 8, y + 3, z + 10, Blocks.bedrock);
		world.setBlock(x + 8, y + 3, z + 11, Blocks.bedrock);
		world.setBlock(x + 8, y + 3, z + 12, Blocks.bedrock);
		world.setBlock(x + 9, y + 0, z + 0, Blocks.bedrock);
		world.setBlock(x + 9, y + 0, z + 1, Blocks.bedrock);
		world.setBlock(x + 9, y + 0, z + 2, Blocks.bedrock);
		world.setBlock(x + 9, y + 0, z + 3, Blocks.bedrock);
		world.setBlock(x + 9, y + 0, z + 4, Blocks.bedrock);
		world.setBlock(x + 9, y + 0, z + 5, Blocks.bedrock);
		world.setBlock(x + 9, y + 0, z + 6, Blocks.bedrock);
		world.setBlock(x + 9, y + 0, z + 7, Blocks.bedrock);
		world.setBlock(x + 9, y + 0, z + 8, Blocks.bedrock);
		world.setBlock(x + 9, y + 0, z + 9, Blocks.bedrock);
		world.setBlock(x + 9, y + 0, z + 10, Blocks.bedrock);
		world.setBlock(x + 9, y + 0, z + 11, Blocks.bedrock);
		world.setBlock(x + 9, y + 0, z + 12, Blocks.bedrock);
		world.setBlock(x + 9, y + 1, z + 0, Blocks.bedrock);
		world.setBlock(x + 9, y + 1, z + 1, Blocks.bedrock);
		world.setBlock(x + 9, y + 1, z + 2, Blocks.iron_bars);
		world.setBlock(x + 9, y + 1, z + 3, Blocks.bedrock);
		world.setBlock(x + 9, y + 1, z + 4, Blocks.bedrock);
		world.setBlock(x + 9, y + 1, z + 5, Blocks.bedrock);
		world.setBlock(x + 9, y + 1, z + 6, Blocks.air);
		world.setBlock(x + 9, y + 1, z + 7, Blocks.air);
		world.setBlock(x + 9, y + 1, z + 8, Blocks.air);
		world.setBlock(x + 9, y + 1, z + 9, Blocks.bedrock);
		world.setBlock(x + 9, y + 1, z + 10, Blocks.bedrock);
		world.setBlock(x + 9, y + 1, z + 11, Blocks.bedrock);
		world.setBlock(x + 9, y + 1, z + 12, Blocks.bedrock);
		world.setBlock(x + 9, y + 2, z + 0, Blocks.bedrock);
		world.setBlock(x + 9, y + 2, z + 1, Blocks.bedrock);
		world.setBlock(x + 9, y + 2, z + 2, Blocks.iron_bars);
		world.setBlock(x + 9, y + 2, z + 3, Blocks.bedrock);
		world.setBlock(x + 9, y + 2, z + 4, Blocks.bedrock);
		world.setBlock(x + 9, y + 2, z + 5, Blocks.bedrock);
		world.setBlock(x + 9, y + 2, z + 6, Blocks.air);
		world.setBlock(x + 9, y + 2, z + 7, Blocks.air);
		world.setBlock(x + 9, y + 2, z + 8, Blocks.air);
		world.setBlock(x + 9, y + 2, z + 9, Blocks.bedrock);
		world.setBlock(x + 9, y + 2, z + 10, Blocks.bedrock);
		world.setBlock(x + 9, y + 2, z + 11, Blocks.bedrock);
		world.setBlock(x + 9, y + 2, z + 12, Blocks.bedrock);
		world.setBlock(x + 9, y + 3, z + 0, Blocks.bedrock);
		world.setBlock(x + 9, y + 3, z + 1, Blocks.bedrock);
		world.setBlock(x + 9, y + 3, z + 2, Blocks.bedrock);
		world.setBlock(x + 9, y + 3, z + 3, Blocks.bedrock);
		world.setBlock(x + 9, y + 3, z + 4, Blocks.bedrock);
		world.setBlock(x + 9, y + 3, z + 5, Blocks.bedrock);
		world.setBlock(x + 9, y + 3, z + 6, Blocks.bedrock);
		world.setBlock(x + 9, y + 3, z + 7, Blocks.bedrock);
		world.setBlock(x + 9, y + 3, z + 8, Blocks.bedrock);
		world.setBlock(x + 9, y + 3, z + 9, Blocks.bedrock);
		world.setBlock(x + 9, y + 3, z + 10, Blocks.bedrock);
		world.setBlock(x + 9, y + 3, z + 11, Blocks.bedrock);
		world.setBlock(x + 9, y + 3, z + 12, Blocks.bedrock);
		world.setBlock(x + 10, y + 0, z + 0, Blocks.bedrock);
		world.setBlock(x + 10, y + 0, z + 1, Blocks.bedrock);
		world.setBlock(x + 10, y + 0, z + 2, Blocks.bedrock);
		world.setBlock(x + 10, y + 0, z + 3, Blocks.bedrock);
		world.setBlock(x + 10, y + 0, z + 4, Blocks.bedrock);
		world.setBlock(x + 10, y + 0, z + 5, Blocks.bedrock);
		world.setBlock(x + 10, y + 0, z + 6, Blocks.bedrock);
		world.setBlock(x + 10, y + 0, z + 7, Blocks.bedrock);
		world.setBlock(x + 10, y + 0, z + 8, Blocks.bedrock);
		world.setBlock(x + 10, y + 0, z + 9, Blocks.bedrock);
		world.setBlock(x + 10, y + 0, z + 10, Blocks.bedrock);
		world.setBlock(x + 10, y + 0, z + 11, Blocks.bedrock);
		world.setBlock(x + 10, y + 0, z + 12, Blocks.bedrock);
		world.setBlock(x + 10, y + 1, z + 0, Blocks.bedrock);
		world.setBlock(x + 10, y + 1, z + 1, Blocks.bedrock);
		world.setBlock(x + 10, y + 1, z + 2, Blocks.air);
		world.setBlock(x + 10, y + 1, z + 3, Blocks.air);
		world.setBlock(x + 10, y + 1, z + 4, Blocks.air);
		world.setBlock(x + 10, y + 1, z + 5, Blocks.air);
		world.setBlock(x + 10, y + 1, z + 6, Blocks.air);
		world.setBlock(x + 10, y + 1, z + 7, Blocks.bedrock);
		world.setBlock(x + 10, y + 1, z + 8, Blocks.air);
		world.setBlock(x + 10, y + 1, z + 9, Blocks.air);
		world.setBlock(x + 10, y + 1, z + 10, Blocks.air);
		world.setBlock(x + 10, y + 1, z + 11, Blocks.mob_spawner);
		TileEntityMobSpawner secondSpawner = (TileEntityMobSpawner)world.getTileEntity(x + 10, y + 1, z + 11);
		if(secondSpawner != null)
		{
			secondSpawner.func_145881_a().setEntityName("MazeCreature");
		}else
		{
			System.out.println("[FakeOres] Failed to load entity in the monster spawner... (IN A MAZE !)");
		}
		world.setBlock(x + 10, y + 1, z + 12, Blocks.bedrock);
		world.setBlock(x + 10, y + 2, z + 0, Blocks.bedrock);
		world.setBlock(x + 10, y + 2, z + 1, Blocks.bedrock);
		world.setBlock(x + 10, y + 2, z + 2, Blocks.air);
		world.setBlock(x + 10, y + 2, z + 3, Blocks.air);
		world.setBlock(x + 10, y + 2, z + 4, Blocks.air);
		world.setBlock(x + 10, y + 2, z + 5, Blocks.air);
		world.setBlock(x + 10, y + 2, z + 6, Blocks.air);
		world.setBlock(x + 10, y + 2, z + 7, Blocks.bedrock);
		world.setBlock(x + 10, y + 2, z + 8, Blocks.air);
		world.setBlock(x + 10, y + 2, z + 9, Blocks.air);
		world.setBlock(x + 10, y + 2, z + 10, Blocks.air);
		world.setBlock(x + 10, y + 2, z + 11, Blocks.air);
		world.setBlock(x + 10, y + 2, z + 12, Blocks.bedrock);
		world.setBlock(x + 10, y + 3, z + 0, Blocks.bedrock);
		world.setBlock(x + 10, y + 3, z + 1, Blocks.bedrock);
		world.setBlock(x + 10, y + 3, z + 2, Blocks.bedrock);
		world.setBlock(x + 10, y + 3, z + 3, Blocks.bedrock);
		world.setBlock(x + 10, y + 3, z + 4, Blocks.bedrock);
		world.setBlock(x + 10, y + 3, z + 5, Blocks.bedrock);
		world.setBlock(x + 10, y + 3, z + 6, Blocks.bedrock);
		world.setBlock(x + 10, y + 3, z + 7, Blocks.bedrock);
		world.setBlock(x + 10, y + 3, z + 8, Blocks.bedrock);
		world.setBlock(x + 10, y + 3, z + 9, Blocks.bedrock);
		world.setBlock(x + 10, y + 3, z + 10, Blocks.bedrock);
		world.setBlock(x + 10, y + 3, z + 11, Blocks.bedrock);
		world.setBlock(x + 10, y + 3, z + 12, Blocks.bedrock);
		world.setBlock(x + 11, y + 0, z + 0, Blocks.bedrock);
		world.setBlock(x + 11, y + 0, z + 1, Blocks.bedrock);
		world.setBlock(x + 11, y + 0, z + 2, Blocks.bedrock);
		world.setBlock(x + 11, y + 0, z + 3, Blocks.bedrock);
		world.setBlock(x + 11, y + 0, z + 4, Blocks.bedrock);
		world.setBlock(x + 11, y + 0, z + 5, Blocks.bedrock);
		world.setBlock(x + 11, y + 0, z + 6, Blocks.bedrock);
		world.setBlock(x + 11, y + 0, z + 7, Blocks.bedrock);
		world.setBlock(x + 11, y + 0, z + 8, Blocks.bedrock);
		world.setBlock(x + 11, y + 0, z + 9, Blocks.bedrock);
		world.setBlock(x + 11, y + 0, z + 10, Blocks.bedrock);
		world.setBlock(x + 11, y + 0, z + 11, Blocks.bedrock);
		world.setBlock(x + 11, y + 0, z + 12, Blocks.bedrock);
		world.setBlock(x + 11, y + 1, z + 0, Blocks.bedrock);
		world.setBlock(x + 11, y + 1, z + 1, Blocks.chest, 5, 3);
		TileEntityChest chest11 = (TileEntityChest)world.getTileEntity(x + 11, y + 1, z + 1);
		if(chest11 != null)
		{//TODO
			ItemStack itemstack = pickRandomItemMiniChest(rand);
			chest11.setInventorySlotContents(rand.nextInt(chest1.getSizeInventory()), itemstack);
			chest11.setInventorySlotContents(rand.nextInt(chest1.getSizeInventory()), itemstack);
			chest11.setInventorySlotContents(rand.nextInt(chest1.getSizeInventory()), itemstack);
			chest11.setInventorySlotContents(rand.nextInt(chest1.getSizeInventory()), itemstack);
			chest11.setInventorySlotContents(rand.nextInt(chest1.getSizeInventory()), itemstack);
			chest11.setInventorySlotContents(rand.nextInt(chest1.getSizeInventory()), itemstack);
		}
		world.setBlock(x + 11, y + 1, z + 2, Blocks.bedrock);
		world.setBlock(x + 11, y + 1, z + 3, Blocks.iron_bars);
		world.setBlock(x + 11, y + 1, z + 4, Blocks.bedrock);
		world.setBlock(x + 11, y + 1, z + 5, Blocks.bedrock);
		world.setBlock(x + 11, y + 1, z + 6, Blocks.bedrock);
		world.setBlock(x + 11, y + 1, z + 7, Blocks.bedrock);
		world.setBlock(x + 11, y + 1, z + 8, Blocks.air);
		world.setBlock(x + 11, y + 1, z + 9, Blocks.bedrock);
		world.setBlock(x + 11, y + 1, z + 10, Blocks.bedrock);
		world.setBlock(x + 11, y + 1, z + 11, Blocks.bedrock);
		world.setBlock(x + 11, y + 1, z + 12, Blocks.bedrock);
		world.setBlock(x + 11, y + 2, z + 0, Blocks.bedrock);
		world.setBlock(x + 11, y + 2, z + 1, Blocks.air);
		world.setBlock(x + 11, y + 2, z + 2, Blocks.bedrock);
		world.setBlock(x + 11, y + 2, z + 3, Blocks.iron_bars);
		world.setBlock(x + 11, y + 2, z + 4, Blocks.bedrock);
		world.setBlock(x + 11, y + 2, z + 5, Blocks.bedrock);
		world.setBlock(x + 11, y + 2, z + 6, Blocks.bedrock);
		world.setBlock(x + 11, y + 2, z + 7, Blocks.bedrock);
		world.setBlock(x + 11, y + 2, z + 8, Blocks.air);
		world.setBlock(x + 11, y + 2, z + 9, Blocks.bedrock);
		world.setBlock(x + 11, y + 2, z + 10, Blocks.bedrock);
		world.setBlock(x + 11, y + 2, z + 11, Blocks.bedrock);
		world.setBlock(x + 11, y + 2, z + 12, Blocks.bedrock);
		world.setBlock(x + 11, y + 3, z + 0, Blocks.bedrock);
		world.setBlock(x + 11, y + 3, z + 1, Blocks.bedrock);
		world.setBlock(x + 11, y + 3, z + 2, Blocks.bedrock);
		world.setBlock(x + 11, y + 3, z + 3, Blocks.bedrock);
		world.setBlock(x + 11, y + 3, z + 4, Blocks.bedrock);
		world.setBlock(x + 11, y + 3, z + 5, Blocks.bedrock);
		world.setBlock(x + 11, y + 3, z + 6, Blocks.bedrock);
		world.setBlock(x + 11, y + 3, z + 7, Blocks.bedrock);
		world.setBlock(x + 11, y + 3, z + 8, Blocks.bedrock);
		world.setBlock(x + 11, y + 3, z + 9, Blocks.bedrock);
		world.setBlock(x + 11, y + 3, z + 10, Blocks.bedrock);
		world.setBlock(x + 11, y + 3, z + 11, Blocks.bedrock);
		world.setBlock(x + 11, y + 3, z + 12, Blocks.bedrock);
		world.setBlock(x + 12, y + 0, z + 0, Blocks.bedrock);
		world.setBlock(x + 12, y + 0, z + 1, Blocks.bedrock);
		world.setBlock(x + 12, y + 0, z + 2, Blocks.bedrock);
		world.setBlock(x + 12, y + 0, z + 3, Blocks.bedrock);
		world.setBlock(x + 12, y + 0, z + 4, Blocks.bedrock);
		world.setBlock(x + 12, y + 0, z + 5, Blocks.bedrock);
		world.setBlock(x + 12, y + 0, z + 6, Blocks.bedrock);
		world.setBlock(x + 12, y + 0, z + 7, Blocks.bedrock);
		world.setBlock(x + 12, y + 0, z + 8, Blocks.bedrock);
		world.setBlock(x + 12, y + 0, z + 9, Blocks.bedrock);
		world.setBlock(x + 12, y + 0, z + 10, Blocks.bedrock);
		world.setBlock(x + 12, y + 0, z + 11, Blocks.bedrock);
		world.setBlock(x + 12, y + 0, z + 12, Blocks.bedrock);
		world.setBlock(x + 12, y + 1, z + 0, Blocks.bedrock);
		world.setBlock(x + 12, y + 1, z + 1, Blocks.air);
		world.setBlock(x + 12, y + 1, z + 2, Blocks.air);
		world.setBlock(x + 12, y + 1, z + 3, Blocks.air);
		world.setBlock(x + 12, y + 1, z + 4, Blocks.mob_spawner);
		TileEntityMobSpawner thirdSpawner = (TileEntityMobSpawner)world.getTileEntity(x + 12, y + 1, z + 4);
		if(thirdSpawner != null)
		{
			thirdSpawner.func_145881_a().setEntityName("Creeper");
		}else
		{
			System.out.println("[FakeOres] Failed to load entity in the monster spawner... (IN A MAZE !)");
		}
		world.setBlock(x + 12, y + 1, z + 5, Blocks.bedrock);
		world.setBlock(x + 12, y + 1, z + 6, Blocks.air);
		world.setBlock(x + 12, y + 1, z + 7, Blocks.air);
		world.setBlock(x + 12, y + 1, z + 8, Blocks.air);
		world.setBlock(x + 12, y + 1, z + 9, Blocks.air);
		world.setBlock(x + 12, y + 1, z + 10, Blocks.air);
		world.setBlock(x + 12, y + 1, z + 11, Blocks.air);
		world.setBlock(x + 12, y + 1, z + 12, Blocks.bedrock);
		world.setBlock(x + 12, y + 2, z + 0, Blocks.bedrock);
		world.setBlock(x + 12, y + 2, z + 1, Blocks.air);
		world.setBlock(x + 12, y + 2, z + 2, Blocks.air);
		world.setBlock(x + 12, y + 2, z + 3, Blocks.air);
		world.setBlock(x + 12, y + 2, z + 4, Blocks.air);
		world.setBlock(x + 12, y + 2, z + 5, Blocks.bedrock);
		world.setBlock(x + 12, y + 2, z + 6, Blocks.air);
		world.setBlock(x + 12, y + 2, z + 7, Blocks.air);
		world.setBlock(x + 12, y + 2, z + 8, Blocks.air);
		world.setBlock(x + 12, y + 2, z + 9, Blocks.air);
		world.setBlock(x + 12, y + 2, z + 10, Blocks.air);
		world.setBlock(x + 12, y + 2, z + 12, Blocks.bedrock);
		world.setBlock(x + 12, y + 3, z + 0, Blocks.bedrock);
		world.setBlock(x + 12, y + 3, z + 1, Blocks.bedrock);
		world.setBlock(x + 12, y + 3, z + 2, Blocks.bedrock);
		world.setBlock(x + 12, y + 3, z + 3, Blocks.bedrock);
		world.setBlock(x + 12, y + 3, z + 4, Blocks.bedrock);
		world.setBlock(x + 12, y + 3, z + 5, Blocks.bedrock);
		world.setBlock(x + 12, y + 3, z + 6, Blocks.bedrock);
		world.setBlock(x + 12, y + 3, z + 7, Blocks.bedrock);
		world.setBlock(x + 12, y + 3, z + 8, Blocks.bedrock);
		world.setBlock(x + 12, y + 3, z + 9, Blocks.bedrock);
		world.setBlock(x + 12, y + 3, z + 10, Blocks.bedrock);
		world.setBlock(x + 12, y + 3, z + 11, Blocks.bedrock);
		world.setBlock(x + 12, y + 3, z + 12, Blocks.bedrock);
		world.setBlock(x + 13, y + 0, z + 0, Blocks.bedrock);
		world.setBlock(x + 13, y + 0, z + 1, Blocks.bedrock);
		world.setBlock(x + 13, y + 0, z + 2, Blocks.bedrock);
		world.setBlock(x + 13, y + 0, z + 3, Blocks.bedrock);
		world.setBlock(x + 13, y + 0, z + 4, Blocks.bedrock);
		world.setBlock(x + 13, y + 0, z + 5, Blocks.bedrock);
		world.setBlock(x + 13, y + 0, z + 6, Blocks.bedrock);
		world.setBlock(x + 13, y + 0, z + 7, Blocks.bedrock);
		world.setBlock(x + 13, y + 0, z + 8, Blocks.bedrock);
		world.setBlock(x + 13, y + 0, z + 9, Blocks.bedrock);
		world.setBlock(x + 13, y + 0, z + 10, Blocks.bedrock);
		world.setBlock(x + 13, y + 0, z + 11, Blocks.bedrock);
		world.setBlock(x + 13, y + 0, z + 12, Blocks.bedrock);
		world.setBlock(x + 13, y + 1, z + 0, Blocks.bedrock);
		world.setBlock(x + 13, y + 1, z + 1, Blocks.iron_bars);
		world.setBlock(x + 13, y + 1, z + 2, Blocks.bedrock);
		world.setBlock(x + 13, y + 1, z + 3, Blocks.bedrock);
		world.setBlock(x + 13, y + 1, z + 4, Blocks.bedrock);
		world.setBlock(x + 13, y + 1, z + 5, Blocks.bedrock);
		world.setBlock(x + 13, y + 1, z + 6, Blocks.air);
		world.setBlock(x + 13, y + 1, z + 7, Blocks.bedrock);
		world.setBlock(x + 13, y + 1, z + 8, Blocks.bedrock);
		world.setBlock(x + 13, y + 1, z + 9, Blocks.bedrock);
		world.setBlock(x + 13, y + 1, z + 10, Blocks.bedrock);
		world.setBlock(x + 13, y + 1, z + 11, Blocks.air);
		world.setBlock(x + 13, y + 1, z + 12, Blocks.bedrock);
		world.setBlock(x + 13, y + 2, z + 0, Blocks.bedrock);
		world.setBlock(x + 13, y + 2, z + 1, Blocks.air);
		world.setBlock(x + 13, y + 2, z + 2, Blocks.bedrock);
		world.setBlock(x + 13, y + 2, z + 3, Blocks.bedrock);
		world.setBlock(x + 13, y + 2, z + 4, Blocks.bedrock);
		world.setBlock(x + 13, y + 2, z + 5, Blocks.bedrock);
		world.setBlock(x + 13, y + 2, z + 6, Blocks.air);
		world.setBlock(x + 13, y + 2, z + 7, Blocks.bedrock);
		world.setBlock(x + 13, y + 2, z + 8, Blocks.bedrock);
		world.setBlock(x + 13, y + 2, z + 9, Blocks.bedrock);
		world.setBlock(x + 13, y + 2, z + 10, Blocks.bedrock);
		world.setBlock(x + 13, y + 2, z + 11, Blocks.air);
		world.setBlock(x + 13, y + 2, z + 12, Blocks.bedrock);
		world.setBlock(x + 13, y + 3, z + 0, Blocks.bedrock);
		world.setBlock(x + 13, y + 3, z + 1, Blocks.bedrock);
		world.setBlock(x + 13, y + 3, z + 2, Blocks.bedrock);
		world.setBlock(x + 13, y + 3, z + 3, Blocks.bedrock);
		world.setBlock(x + 13, y + 3, z + 4, Blocks.bedrock);
		world.setBlock(x + 13, y + 3, z + 5, Blocks.bedrock);
		world.setBlock(x + 13, y + 3, z + 6, Blocks.bedrock);
		world.setBlock(x + 13, y + 3, z + 7, Blocks.bedrock);
		world.setBlock(x + 13, y + 3, z + 8, Blocks.bedrock);
		world.setBlock(x + 13, y + 3, z + 9, Blocks.bedrock);
		world.setBlock(x + 13, y + 3, z + 10, Blocks.bedrock);
		world.setBlock(x + 13, y + 3, z + 11, Blocks.bedrock);
		world.setBlock(x + 13, y + 3, z + 12, Blocks.bedrock);
		world.setBlock(x + 14, y + 0, z + 0, Blocks.bedrock);
		world.setBlock(x + 14, y + 0, z + 1, Blocks.bedrock);
		world.setBlock(x + 14, y + 0, z + 2, Blocks.bedrock);
		world.setBlock(x + 14, y + 0, z + 3, Blocks.bedrock);
		world.setBlock(x + 14, y + 0, z + 4, Blocks.bedrock);
		world.setBlock(x + 14, y + 0, z + 5, Blocks.bedrock);
		world.setBlock(x + 14, y + 0, z + 6, Blocks.bedrock);
		world.setBlock(x + 14, y + 0, z + 7, Blocks.bedrock);
		world.setBlock(x + 14, y + 0, z + 8, Blocks.bedrock);
		world.setBlock(x + 14, y + 0, z + 9, Blocks.bedrock);
		world.setBlock(x + 14, y + 0, z + 10, Blocks.bedrock);
		world.setBlock(x + 14, y + 0, z + 11, Blocks.bedrock);
		world.setBlock(x + 14, y + 0, z + 12, Blocks.bedrock);
		world.setBlock(x + 14, y + 1, z + 0, Blocks.bedrock);
		world.setBlock(x + 14, y + 1, z + 1, Blocks.air);
		world.setBlock(x + 14, y + 1, z + 2, Blocks.air);
		world.setBlock(x + 14, y + 1, z + 3, Blocks.air);
		world.setBlock(x + 14, y + 1, z + 4, Blocks.air);
		world.setBlock(x + 14, y + 1, z + 5, Blocks.bedrock);
		world.setBlock(x + 14, y + 1, z + 6, Blocks.air);
		world.setBlock(x + 14, y + 1, z + 7, Blocks.air);
		world.setBlock(x + 14, y + 1, z + 8, Blocks.iron_bars);
		world.setBlock(x + 14, y + 1, z + 9, Blocks.mob_spawner);
		TileEntityMobSpawner fourthSpawner = (TileEntityMobSpawner)world.getTileEntity(x + 14, y + 1, z + 9);
		if(fourthSpawner != null)
		{
			fourthSpawner.func_145881_a().setEntityName("Zombie");
		}else
		{
			System.out.println("[FakeOres] Failed to load entity in the monster spawner... (IN A MAZE !)");
		}
		world.setBlock(x + 14, y + 1, z + 10, Blocks.bedrock);
		world.setBlock(x + 14, y + 1, z + 11, Blocks.air);
		world.setBlock(x + 14, y + 1, z + 12, Blocks.bedrock);
		world.setBlock(x + 14, y + 2, z + 0, Blocks.bedrock);
		world.setBlock(x + 14, y + 2, z + 2, Blocks.air);
		world.setBlock(x + 14, y + 2, z + 3, Blocks.air);
		world.setBlock(x + 14, y + 2, z + 4, Blocks.air);
		world.setBlock(x + 14, y + 2, z + 5, Blocks.bedrock);
		world.setBlock(x + 14, y + 2, z + 6, Blocks.air);
		world.setBlock(x + 14, y + 2, z + 7, Blocks.air);
		world.setBlock(x + 14, y + 2, z + 8, Blocks.iron_bars);
		world.setBlock(x + 14, y + 2, z + 9, Blocks.air);
		world.setBlock(x + 14, y + 2, z + 10, Blocks.bedrock);
		world.setBlock(x + 14, y + 2, z + 11, Blocks.air);
		world.setBlock(x + 14, y + 2, z + 12, Blocks.bedrock);
		world.setBlock(x + 14, y + 3, z + 0, Blocks.bedrock);
		world.setBlock(x + 14, y + 3, z + 1, Blocks.bedrock);
		world.setBlock(x + 14, y + 3, z + 2, Blocks.bedrock);
		world.setBlock(x + 14, y + 3, z + 3, Blocks.bedrock);
		world.setBlock(x + 14, y + 3, z + 4, Blocks.bedrock);
		world.setBlock(x + 14, y + 3, z + 5, Blocks.bedrock);
		world.setBlock(x + 14, y + 3, z + 6, Blocks.bedrock);
		world.setBlock(x + 14, y + 3, z + 7, Blocks.bedrock);
		world.setBlock(x + 14, y + 3, z + 8, Blocks.bedrock);
		world.setBlock(x + 14, y + 3, z + 9, Blocks.bedrock);
		world.setBlock(x + 14, y + 3, z + 10, Blocks.bedrock);
		world.setBlock(x + 14, y + 3, z + 11, Blocks.bedrock);
		world.setBlock(x + 14, y + 3, z + 12, Blocks.bedrock);
		world.setBlock(x + 15, y + 0, z + 0, Blocks.bedrock);
		world.setBlock(x + 15, y + 0, z + 1, Blocks.bedrock);
		world.setBlock(x + 15, y + 0, z + 2, Blocks.bedrock);
		world.setBlock(x + 15, y + 0, z + 3, Blocks.bedrock);
		world.setBlock(x + 15, y + 0, z + 4, Blocks.bedrock);
		world.setBlock(x + 15, y + 0, z + 5, Blocks.bedrock);
		world.setBlock(x + 15, y + 0, z + 6, Blocks.bedrock);
		world.setBlock(x + 15, y + 0, z + 7, Blocks.bedrock);
		world.setBlock(x + 15, y + 0, z + 8, Blocks.bedrock);
		world.setBlock(x + 15, y + 0, z + 9, Blocks.bedrock);
		world.setBlock(x + 15, y + 0, z + 10, Blocks.bedrock);
		world.setBlock(x + 15, y + 0, z + 11, Blocks.bedrock);
		world.setBlock(x + 15, y + 0, z + 12, Blocks.bedrock);
		world.setBlock(x + 15, y + 1, z + 0, Blocks.bedrock);
		world.setBlock(x + 15, y + 1, z + 1, Blocks.bedrock);
		world.setBlock(x + 15, y + 1, z + 2, Blocks.iron_bars);
		world.setBlock(x + 15, y + 1, z + 3, Blocks.bedrock);
		world.setBlock(x + 15, y + 1, z + 4, Blocks.iron_bars);
		world.setBlock(x + 15, y + 1, z + 5, Blocks.bedrock);
		world.setBlock(x + 15, y + 1, z + 6, Blocks.air);
		world.setBlock(x + 15, y + 1, z + 7, Blocks.bedrock);
		world.setBlock(x + 15, y + 1, z + 8, Blocks.bedrock);
		world.setBlock(x + 15, y + 1, z + 9, Blocks.bedrock);
		world.setBlock(x + 15, y + 1, z + 10, Blocks.bedrock);
		world.setBlock(x + 15, y + 1, z + 11, Blocks.air);
		world.setBlock(x + 15, y + 1, z + 12, Blocks.bedrock);
		world.setBlock(x + 15, y + 2, z + 0, Blocks.bedrock);
		world.setBlock(x + 15, y + 2, z + 1, Blocks.bedrock);
		world.setBlock(x + 15, y + 2, z + 2, Blocks.iron_bars);
		world.setBlock(x + 15, y + 2, z + 3, Blocks.bedrock);
		world.setBlock(x + 15, y + 2, z + 4, Blocks.iron_bars);
		world.setBlock(x + 15, y + 2, z + 5, Blocks.bedrock);
		world.setBlock(x + 15, y + 2, z + 6, Blocks.air);
		world.setBlock(x + 15, y + 2, z + 7, Blocks.bedrock);
		world.setBlock(x + 15, y + 2, z + 8, Blocks.bedrock);
		world.setBlock(x + 15, y + 2, z + 9, Blocks.bedrock);
		world.setBlock(x + 15, y + 2, z + 10, Blocks.bedrock);
		world.setBlock(x + 15, y + 2, z + 11, Blocks.air);
		world.setBlock(x + 15, y + 2, z + 12, Blocks.bedrock);
		world.setBlock(x + 15, y + 3, z + 0, Blocks.bedrock);
		world.setBlock(x + 15, y + 3, z + 1, Blocks.bedrock);
		world.setBlock(x + 15, y + 3, z + 2, Blocks.bedrock);
		world.setBlock(x + 15, y + 3, z + 3, Blocks.bedrock);
		world.setBlock(x + 15, y + 3, z + 4, Blocks.bedrock);
		world.setBlock(x + 15, y + 3, z + 5, Blocks.bedrock);
		world.setBlock(x + 15, y + 3, z + 6, Blocks.bedrock);
		world.setBlock(x + 15, y + 3, z + 7, Blocks.bedrock);
		world.setBlock(x + 15, y + 3, z + 8, Blocks.bedrock);
		world.setBlock(x + 15, y + 3, z + 9, Blocks.bedrock);
		world.setBlock(x + 15, y + 3, z + 10, Blocks.bedrock);
		world.setBlock(x + 15, y + 3, z + 11, Blocks.bedrock);
		world.setBlock(x + 15, y + 3, z + 12, Blocks.bedrock);
		world.setBlock(x + 16, y + 0, z + 0, Blocks.bedrock);
		world.setBlock(x + 16, y + 0, z + 1, Blocks.bedrock);
		world.setBlock(x + 16, y + 0, z + 2, Blocks.bedrock);
		world.setBlock(x + 16, y + 0, z + 3, Blocks.bedrock);
		world.setBlock(x + 16, y + 0, z + 4, Blocks.bedrock);
		world.setBlock(x + 16, y + 0, z + 5, Blocks.bedrock);
		world.setBlock(x + 16, y + 0, z + 6, Blocks.bedrock);
		world.setBlock(x + 16, y + 0, z + 7, Blocks.bedrock);
		world.setBlock(x + 16, y + 0, z + 8, Blocks.bedrock);
		world.setBlock(x + 16, y + 0, z + 9, Blocks.bedrock);
		world.setBlock(x + 16, y + 0, z + 10, Blocks.bedrock);
		world.setBlock(x + 16, y + 0, z + 11, Blocks.bedrock);
		world.setBlock(x + 16, y + 0, z + 12, Blocks.bedrock);
		world.setBlock(x + 16, y + 1, z + 0, Blocks.bedrock);
		world.setBlock(x + 16, y + 1, z + 1, Blocks.chest, 3, 3);
		TileEntityChest chest111 = (TileEntityChest)world.getTileEntity(x + 16, y + 1, z + 1);
		if(chest111 != null)
		{//TODO
			ItemStack itemstack = pickRandomItemMiniChest(rand);
			chest111.setInventorySlotContents(rand.nextInt(chest1.getSizeInventory()), itemstack);
			chest111.setInventorySlotContents(rand.nextInt(chest1.getSizeInventory()), itemstack);
			chest111.setInventorySlotContents(rand.nextInt(chest1.getSizeInventory()), itemstack);
			chest111.setInventorySlotContents(rand.nextInt(chest1.getSizeInventory()), itemstack);
			chest111.setInventorySlotContents(rand.nextInt(chest1.getSizeInventory()), itemstack);
			chest111.setInventorySlotContents(rand.nextInt(chest1.getSizeInventory()), itemstack);
		}
		world.setBlock(x + 16, y + 1, z + 2, Blocks.air);
		world.setBlock(x + 16, y + 1, z + 3, Blocks.bedrock);
		world.setBlock(x + 16, y + 1, z + 4, Blocks.air);
		world.setBlock(x + 16, y + 1, z + 5, Blocks.air);
		world.setBlock(x + 16, y + 1, z + 6, Blocks.air);
		world.setBlock(x + 16, y + 1, z + 7, Blocks.iron_bars);
		world.setBlock(x + 16, y + 1, z + 8, Blocks.air);
		world.setBlock(x + 16, y + 1, z + 9, Blocks.mob_spawner);
		TileEntityMobSpawner fifthSpawner = (TileEntityMobSpawner)world.getTileEntity(x + 16, y + 1, z + 9);
		if(fifthSpawner != null)
		{
			fifthSpawner.func_145881_a().setEntityName("MazeCreature");
		}else
		{
			System.out.println("[FakeOres] Failed to load entity in the monster spawner... (IN A MAZE !)");
		}
		world.setBlock(x + 16, y + 1, z + 10, Blocks.bedrock);
		world.setBlock(x + 16, y + 1, z + 11, Blocks.air);
		world.setBlock(x + 16, y + 1, z + 12, Blocks.bedrock);
		world.setBlock(x + 16, y + 2, z + 0, Blocks.bedrock);
		world.setBlock(x + 16, y + 2, z + 1, Blocks.air);
		world.setBlock(x + 16, y + 2, z + 2, Blocks.air);
		world.setBlock(x + 16, y + 2, z + 3, Blocks.bedrock);
		world.setBlock(x + 16, y + 2, z + 4, Blocks.air);
		world.setBlock(x + 16, y + 2, z + 5, Blocks.air);
		world.setBlock(x + 16, y + 2, z + 6, Blocks.air);
		world.setBlock(x + 16, y + 2, z + 7, Blocks.air);
		world.setBlock(x + 16, y + 2, z + 8, Blocks.air);
		world.setBlock(x + 16, y + 2, z + 9, Blocks.air);
		world.setBlock(x + 16, y + 2, z + 10, Blocks.bedrock);
		world.setBlock(x + 16, y + 2, z + 11, Blocks.air);
		world.setBlock(x + 16, y + 2, z + 12, Blocks.bedrock);
		world.setBlock(x + 16, y + 3, z + 0, Blocks.bedrock);
		world.setBlock(x + 16, y + 3, z + 1, Blocks.bedrock);
		world.setBlock(x + 16, y + 3, z + 2, Blocks.bedrock);
		world.setBlock(x + 16, y + 3, z + 3, Blocks.bedrock);
		world.setBlock(x + 16, y + 3, z + 4, Blocks.bedrock);
		world.setBlock(x + 16, y + 3, z + 5, Blocks.bedrock);
		world.setBlock(x + 16, y + 3, z + 6, Blocks.bedrock);
		world.setBlock(x + 16, y + 3, z + 7, Blocks.bedrock);
		world.setBlock(x + 16, y + 3, z + 8, Blocks.bedrock);
		world.setBlock(x + 16, y + 3, z + 9, Blocks.bedrock);
		world.setBlock(x + 16, y + 3, z + 10, Blocks.bedrock);
		world.setBlock(x + 16, y + 3, z + 11, Blocks.bedrock);
		world.setBlock(x + 16, y + 3, z + 12, Blocks.bedrock);
		world.setBlock(x + 17, y + 0, z + 0, Blocks.bedrock);
		world.setBlock(x + 17, y + 0, z + 1, Blocks.bedrock);
		world.setBlock(x + 17, y + 0, z + 2, Blocks.bedrock);
		world.setBlock(x + 17, y + 0, z + 3, Blocks.bedrock);
		world.setBlock(x + 17, y + 0, z + 4, Blocks.bedrock);
		world.setBlock(x + 17, y + 0, z + 5, Blocks.bedrock);
		world.setBlock(x + 17, y + 0, z + 6, Blocks.bedrock);
		world.setBlock(x + 17, y + 0, z + 7, Blocks.bedrock);
		world.setBlock(x + 17, y + 0, z + 8, Blocks.bedrock);
		world.setBlock(x + 17, y + 0, z + 9, Blocks.bedrock);
		world.setBlock(x + 17, y + 0, z + 10, Blocks.bedrock);
		world.setBlock(x + 17, y + 0, z + 11, Blocks.bedrock);
		world.setBlock(x + 17, y + 0, z + 12, Blocks.bedrock);
		world.setBlock(x + 17, y + 1, z + 0, Blocks.bedrock);
		world.setBlock(x + 17, y + 1, z + 1, Blocks.bedrock);
		world.setBlock(x + 17, y + 1, z + 2, Blocks.bedrock);
		world.setBlock(x + 17, y + 1, z + 3, Blocks.bedrock);
		world.setBlock(x + 17, y + 1, z + 4, Blocks.bedrock);
		world.setBlock(x + 17, y + 1, z + 5, Blocks.bedrock);
		world.setBlock(x + 17, y + 1, z + 6, Blocks.bedrock);
		world.setBlock(x + 17, y + 1, z + 7, Blocks.bedrock);
		world.setBlock(x + 17, y + 1, z + 8, Blocks.bedrock);
		world.setBlock(x + 17, y + 1, z + 9, Blocks.bedrock);
		world.setBlock(x + 17, y + 1, z + 10, Blocks.bedrock);
		world.setBlock(x + 17, y + 1, z + 11, Blocks.air);
		world.setBlock(x + 17, y + 1, z + 12, Blocks.bedrock);
		world.setBlock(x + 17, y + 2, z + 0, Blocks.bedrock);
		world.setBlock(x + 17, y + 2, z + 1, Blocks.bedrock);
		world.setBlock(x + 17, y + 2, z + 2, Blocks.bedrock);
		world.setBlock(x + 17, y + 2, z + 3, Blocks.bedrock);
		world.setBlock(x + 17, y + 2, z + 4, Blocks.bedrock);
		world.setBlock(x + 17, y + 2, z + 5, Blocks.bedrock);
		world.setBlock(x + 17, y + 2, z + 6, Blocks.bedrock);
		world.setBlock(x + 17, y + 2, z + 7, Blocks.bedrock);
		world.setBlock(x + 17, y + 2, z + 8, Blocks.bedrock);
		world.setBlock(x + 17, y + 2, z + 9, Blocks.bedrock);
		world.setBlock(x + 17, y + 2, z + 10, Blocks.bedrock);
		world.setBlock(x + 17, y + 2, z + 11, Blocks.air);
		world.setBlock(x + 17, y + 2, z + 12, Blocks.bedrock);
		world.setBlock(x + 17, y + 3, z + 0, Blocks.bedrock);
		world.setBlock(x + 17, y + 3, z + 1, Blocks.bedrock);
		world.setBlock(x + 17, y + 3, z + 2, Blocks.bedrock);
		world.setBlock(x + 17, y + 3, z + 3, Blocks.bedrock);
		world.setBlock(x + 17, y + 3, z + 4, Blocks.bedrock);
		world.setBlock(x + 17, y + 3, z + 5, Blocks.bedrock);
		world.setBlock(x + 17, y + 3, z + 6, Blocks.bedrock);
		world.setBlock(x + 17, y + 3, z + 7, Blocks.bedrock);
		world.setBlock(x + 17, y + 3, z + 8, Blocks.bedrock);
		world.setBlock(x + 17, y + 3, z + 9, Blocks.bedrock);
		world.setBlock(x + 17, y + 3, z + 10, Blocks.bedrock);
		world.setBlock(x + 17, y + 3, z + 11, Blocks.bedrock);
		world.setBlock(x + 17, y + 3, z + 12, Blocks.bedrock);
		world.setBlock(x + 18, y + 0, z + 10, Blocks.air);
		world.setBlock(x + 18, y + 0, z + 11, Blocks.air);
		world.setBlock(x + 18, y + 0, z + 12, Blocks.air);
		world.setBlock(x + 18, y + 1, z + 10, Blocks.air);
		world.setBlock(x + 18, y + 1, z + 12, Blocks.air);
		world.setBlock(x + 18, y + 2, z + 10, Blocks.air);
		world.setBlock(x + 18, y + 2, z + 12, Blocks.air);
		world.setBlock(x + 18, y + 3, z + 10, Blocks.air);
		world.setBlock(x + 18, y + 3, z + 11, Blocks.air);
		world.setBlock(x + 18, y + 3, z + 12, Blocks.air);
		world.setBlock(x + 19, y + 0, z + 10, Blocks.air);
		world.setBlock(x + 19, y + 0, z + 11, Blocks.air);
		world.setBlock(x + 19, y + 1, z + 10, Blocks.air);
		world.setBlock(x + 19, y + 1, z + 12, Blocks.air);
		world.setBlock(x + 19, y + 2, z + 10, Blocks.air);
		world.setBlock(x + 19, y + 2, z + 12, Blocks.air);
		world.setBlock(x + 19, y + 3, z + 10, Blocks.air);
		world.setBlock(x + 19, y + 3, z + 11, Blocks.air);
		world.setBlock(x + 19, y + 3, z + 12, Blocks.air);
		world.setBlock(x + 20, y + 0, z + 10, Blocks.air);
		world.setBlock(x + 20, y + 0, z + 11, Blocks.air);
		world.setBlock(x + 20, y + 1, z + 10, Blocks.air);
		world.setBlock(x + 20, y + 1, z + 12, Blocks.air);
		world.setBlock(x + 20, y + 2, z + 10, Blocks.air);
		world.setBlock(x + 20, y + 2, z + 12, Blocks.air);
		world.setBlock(x + 20, y + 3, z + 10, Blocks.air);
		world.setBlock(x + 20, y + 3, z + 11, Blocks.air);
		world.setBlock(x + 20, y + 3, z + 12, Blocks.air);
		world.setBlock(x + 1, y + 2, z + 1, Blocks.torch, 3, 3);
		world.setBlock(x + 1, y + 2, z + 3, Blocks.torch, 4, 3);
		world.setBlock(x + 2, y + 2, z + 1, Blocks.torch, 3, 3);
		world.setBlock(x + 2, y + 2, z + 3, Blocks.torch, 4, 3);
		world.setBlock(x + 6, y + 2, z + 4, Blocks.torch, 3, 3);
		world.setBlock(x + 12, y + 2, z + 11, Blocks.torch, 1, 3);
		world.setBlock(x + 14, y + 2, z + 1, Blocks.torch, 3, 3);
		return true;
	}
	private ItemStack pickRandomItemMiniChest(Random rand) {
		int i = rand.nextInt(12);
		if(i == 0)
		{
			return new ItemStack(FakeOres.nopeGrenade, rand.nextInt(10));
		}
		if(i == 1)
		{
			return new ItemStack(FakeOres.fd_stone_pickaxe, 1);
		}
		if(i == 2)
		{
			return new ItemStack(FakeOres.fd_strangeliquid_bucket, rand.nextInt(5));
		}
		if(i == 3)
		{
			return new ItemStack(FakeOres.fd_daren_ingot, rand.nextInt(3));
		}
		if(i == 4)
		{
			return new ItemStack(FakeOres.fd_blurk_ingot, rand.nextInt(4));
		}
		if(i == 5)
		{
			return new ItemStack(FakeOres.fd_rainbow_ingot, rand.nextInt(2));
		}
		if(i == 9)
		{
			return new ItemStack(Items.diamond, rand.nextInt(8));
		}
		if(i == 10)
		{
			return new ItemStack(Items.golden_apple, rand.nextInt(10));
		}else{
			return null;
		}
	}
	private ItemStack pickRandomItemMaxiChest(Random rand) {
		int i = rand.nextInt(10);
		if(i == 0)
		{
			return new ItemStack(FakeOres.nopeGrenade, rand.nextInt(64));
		}
		if(i == 1)
		{
			return new ItemStack(FakeOres.mazeCreature_leather, rand.nextInt(50));
		}
		if(i == 2)
		{
			return new ItemStack(FakeOres.fire_orb, 1);
		}
		if(i == 3)
		{
			return new ItemStack(FakeOres.water_orb, 1);
		}
		if(i == 4)
		{
			return new ItemStack(FakeOres.neutral_orb, rand.nextInt(16));
		}
		if(i == 5)
		{
			return new ItemStack(FakeOres.air_orb, 1);
		}
		if(i == 9)
		{
			return new ItemStack(Items.diamond, rand.nextInt(8));
		}
		if(i == 10)
		{
			return new ItemStack(Items.golden_apple, rand.nextInt(10));
		}
		return new ItemStack(FakeOres.spawnShield, 1);
	}
}
