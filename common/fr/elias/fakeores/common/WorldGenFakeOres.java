package fr.elias.fakeores.common;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.Loader;

public class WorldGenFakeOres implements IWorldGenerator {

	public void generateSurface(World world, int x, int z, Random rand)
	{
		if(FakeOres.enableFakeOres)
		{
			for(int i = 0; i < 2; i++)
			{
				(new WorldGenMinable(FakeOres.fakeDiamond.getDefaultState(), 3)).generate(world, rand, new BlockPos(x + rand.nextInt(16), rand.nextInt(16), z + rand.nextInt(16)));
			}
			for(int i = 0; i < 2; i++)
			{
				(new WorldGenMinable(FakeOres.fakeGold.getDefaultState(), 5)).generate(world, rand, new BlockPos(x + rand.nextInt(16), rand.nextInt(32), z + rand.nextInt(16)));
			}
			for(int i = 0; i < 2; i++)
			{
				(new WorldGenMinable(FakeOres.fakeEmerald.getDefaultState(), 4)).generate(world, rand, new BlockPos(x + rand.nextInt(16), rand.nextInt(32), z + rand.nextInt(16)));
			}
			for(int i = 0; i < 20; i++)
			{
				(new WorldGenMinable(FakeOres.fakeIron.getDefaultState(), 5)).generate(world, rand, new BlockPos(x + rand.nextInt(16), rand.nextInt(64), z + rand.nextInt(16)));
				(new WorldGenMinable(FakeOres.fakeCoal.getDefaultState(), 14)).generate(world, rand, new BlockPos(x + rand.nextInt(16), rand.nextInt(128), z + rand.nextInt(16)));
			}
			for(int i = 0; i < 2; i++)
			{
				(new WorldGenMinable(FakeOres.fakeRedstone.getDefaultState(), 14)).generate(world, rand, new BlockPos(x + rand.nextInt(16), rand.nextInt(24), z + rand.nextInt(16)));
				(new WorldGenMinable(FakeOres.fakeLapis.getDefaultState(), 7)).generate(world, rand, new BlockPos(x + rand.nextInt(16), rand.nextInt(24), z + rand.nextInt(16)));
			}
			if(Loader.isModLoaded("IC2"))
			{
				for(int i = 0; i < 20; i++)
				{
					(new WorldGenMinable(FakeOres.fakeTin.getDefaultState(), 3)).generate(world, rand, new BlockPos(x + rand.nextInt(16), rand.nextInt(64), z + rand.nextInt(16)));
					(new WorldGenMinable(FakeOres.fakeCopper.getDefaultState(), 3)).generate(world, rand, new BlockPos(x + rand.nextInt(16), rand.nextInt(64), z + rand.nextInt(16)));
				}
				for(int i = 0; i < 2; i++)
				{
					(new WorldGenMinable(FakeOres.fakeUranium.getDefaultState(), 2)).generate(world, rand, new BlockPos(x + rand.nextInt(16), rand.nextInt(70), z + rand.nextInt(16)));
				}
			}
			for(int i = 0; i < 2; i++)
			{
				(new WorldGenMinable(FakeOres.antiOreStone.getDefaultState(), 6)).generate(world, rand, new BlockPos(x + rand.nextInt(16), rand.nextInt(128), z + rand.nextInt(16)));
			}
		}
	}
	public void generateNether(World world, int x, int z, Random rand)
	{
		if(FakeOres.enableFakeOres)
		{
			for(int i = 0; i < 16; i++)
			{
				(new WorldGenMinable(FakeOres.fakeQuartz.getDefaultState(), 13)).generate(world, rand, new BlockPos(x + rand.nextInt(16), rand.nextInt(108) + 10, z + rand.nextInt(16)));
			}
		}
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		
		switch(world.provider.getDimensionId())
		{
		case 0:
			this.generateSurface(world, chunkX * 16, chunkZ * 16, random);
		case -1:
			this.generateNether(world, chunkX * 16, chunkZ * 16, random);
		}
	}

}
