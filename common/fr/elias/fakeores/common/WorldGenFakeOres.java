package fr.elias.fakeores.common;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.Loader;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class WorldGenFakeOres implements IWorldGenerator {

	public void generateSurface(World world, int x, int z, Random rand)
	{
		for(int i = 0; i < 2; i++)
		{
			(new WorldGenMinable(FakeOres.fakeOreVanilla, 0, 3, Blocks.stone)).generate(world, rand, x + rand.nextInt(16), rand.nextInt(16), z + rand.nextInt(16));
		}
		for(int i = 0; i < 2; i++)
		{
			(new WorldGenMinable(FakeOres.fakeOreVanilla, 1, 5, Blocks.stone)).generate(world, rand, x + rand.nextInt(16), rand.nextInt(32), z + rand.nextInt(16));
		}
		for(int i = 0; i < 2; i++)
		{
			(new WorldGenMinable(FakeOres.fakeOreVanilla, 2, 4, Blocks.stone)).generate(world, rand, x + rand.nextInt(16), rand.nextInt(32), z + rand.nextInt(16));
		}
		for(int i = 0; i < 20; i++)
		{
			(new WorldGenMinable(FakeOres.fakeOreVanilla, 3, 5, Blocks.stone)).generate(world, rand, x + rand.nextInt(16), rand.nextInt(64), z + rand.nextInt(16));
			(new WorldGenMinable(FakeOres.fakeOreVanilla, 4, 14, Blocks.stone)).generate(world, rand, x + rand.nextInt(16), rand.nextInt(128), z + rand.nextInt(16));
		}
		for(int i = 0; i < 2; i++)
		{
			(new WorldGenMinable(FakeOres.fakeOreVanilla, 5, 14, Blocks.stone)).generate(world, rand, x + rand.nextInt(16), rand.nextInt(24), z + rand.nextInt(16));
			(new WorldGenMinable(FakeOres.fakeOreVanilla, 7, 7, Blocks.stone)).generate(world, rand, x + rand.nextInt(16), rand.nextInt(24), z + rand.nextInt(16));
		}
		if(Loader.isModLoaded("IC2"))
		{
			for(int i = 0; i < 20; i++)
			{
				(new WorldGenMinable(FakeOres.fakeTin, 0, 3, Blocks.stone)).generate(world, rand, x + rand.nextInt(16), rand.nextInt(64), z + rand.nextInt(16));
				(new WorldGenMinable(FakeOres.fakeCopper, 0, 3, Blocks.stone)).generate(world, rand, x + rand.nextInt(16), rand.nextInt(64), z + rand.nextInt(16));
			}
			for(int i = 0; i < 2; i++)
			{
				(new WorldGenMinable(FakeOres.fakeUranium, 0, 2, Blocks.stone)).generate(world, rand, x + rand.nextInt(16), rand.nextInt(70), z + rand.nextInt(16));
			}
		}
		for(int i = 0; i < 2; i++)
		{
			(new WorldGenMinable(FakeOres.antiOreStone, 0, 6, Blocks.stone)).generate(world, rand, x + rand.nextInt(16), rand.nextInt(128), z + rand.nextInt(16));
		}
	}
	public void generateCustom(World world, int x, int z, Random rand)
	{
		for(int i = 0; i < 6; i++)
		{
			(new WorldGenMinable(FakeOres.fd_blurk_ore, 0, 17, FakeOres.fd_stone)).generate(world, rand, x + rand.nextInt(16), rand.nextInt(64), z + rand.nextInt(16));
			(new WorldGenMinable(FakeOres.fd_daren_ore, 0, 12, FakeOres.fd_stone)).generate(world, rand, x + rand.nextInt(16), rand.nextInt(128), z + rand.nextInt(16));
			(new WorldGenMinable(FakeOres.fd_purlight_ore, 0, 14, FakeOres.fd_stone)).generate(world, rand, x + rand.nextInt(16), rand.nextInt(256), z + rand.nextInt(16));
		}
		for(int i = 0; i < 4; i++)
		{
			(new WorldGenMinable(FakeOres.fd_rainbow_ore, 0, 4, FakeOres.fd_stone)).generate(world, rand, x + rand.nextInt(16), rand.nextInt(128), z + rand.nextInt(16));
		}
	}
	public void generateNether(World world, int x, int z, Random rand)
	{
		for(int i = 0; i < 16; i++)
		{
			(new WorldGenMinable(FakeOres.fakeOreVanilla, 6, 13, Blocks.netherrack)).generate(world, rand, x + rand.nextInt(16), rand.nextInt(108) + 10, z + rand.nextInt(16));
		}
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		
		switch(world.provider.dimensionId)
		{
		case 0:
			this.generateSurface(world, chunkX * 16, chunkZ * 16, random);
		case -1:
			this.generateNether(world, chunkX * 16, chunkZ * 16, random);
		}
		if(world.provider.dimensionId == FakeOres.dimID)
		{
			this.generateCustom(world, chunkX * 16, chunkZ * 16, random);
		}
	}

}
