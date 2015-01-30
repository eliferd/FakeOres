package fr.elias.fakeores.common;

import java.util.Random;

import net.minecraft.block.state.pattern.BlockHelper;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.Loader;

public class WorldGenFakeOres implements IWorldGenerator
{
    public void generateSurface(World world, int x, int z, Random rand)
    {
        if(FakeOres.enableFakeOres)
        {
            for(int i = 0; i < 2; i++)
            {
                (new WorldGenMinable(FakeOres.fakeOreVanilla.getDefaultState(), 3)).generate(world, rand, new BlockPos(x + rand.nextInt(16), rand.nextInt(16), z + rand.nextInt(16)));
            }
            for(int i = 0; i < 2; i++)
            {
                (new WorldGenMinable(FakeOres.fakeOreVanilla.getDefaultState(), 5)).generate(world, rand, new BlockPos(x + rand.nextInt(16), rand.nextInt(32), z + rand.nextInt(16)));
            }
            for(int i = 0; i < 2; i++)
            {
                (new WorldGenMinable(FakeOres.fakeOreVanilla.getDefaultState(), 4)).generate(world, rand, new BlockPos(x + rand.nextInt(16), rand.nextInt(32), z + rand.nextInt(16)));
            }
            for(int i = 0; i < 20; i++)
            {
                (new WorldGenMinable(FakeOres.fakeOreVanilla.getDefaultState(), 5)).generate(world, rand, new BlockPos(x + rand.nextInt(16), rand.nextInt(64), z + rand.nextInt(16)));
                (new WorldGenMinable(FakeOres.fakeOreVanilla.getDefaultState(), 14)).generate(world, rand, new BlockPos(x + rand.nextInt(16), rand.nextInt(128), z + rand.nextInt(16)));
            }
            for(int i = 0; i < 2; i++)
            {
                (new WorldGenMinable(FakeOres.fakeOreVanilla.getDefaultState(), 14)).generate(world, rand, new BlockPos(x + rand.nextInt(16), rand.nextInt(24), z + rand.nextInt(16)));
                (new WorldGenMinable(FakeOres.fakeOreVanilla.getDefaultState(), 7)).generate(world, rand, new BlockPos(x + rand.nextInt(16), rand.nextInt(24), z + rand.nextInt(16)));
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

    public void generateCustom(World world, int x, int z, Random rand)
    {
        for(int i = 0; i < 6; i++)
        {
            (new WorldGenMinable(FakeOres.fd_blurk_ore.getDefaultState(), 17, BlockHelper.forBlock(FakeOres.fd_stone))).generate(world, rand, new BlockPos(x + rand.nextInt(16), rand.nextInt(64), z + rand.nextInt(16)));
            (new WorldGenMinable(FakeOres.fd_daren_ore.getDefaultState(), 12, BlockHelper.forBlock(FakeOres.fd_stone))).generate(world, rand, new BlockPos(x + rand.nextInt(16), rand.nextInt(128), z + rand.nextInt(16)));
            (new WorldGenMinable(FakeOres.fd_purlight_ore.getDefaultState(), 14, BlockHelper.forBlock(FakeOres.fd_stone))).generate(world, rand, new BlockPos(x + rand.nextInt(16), rand.nextInt(256), z + rand.nextInt(16)));
        }
        for(int i = 0; i < 4; i++)
        {
            (new WorldGenMinable(FakeOres.fd_rainbow_ore.getDefaultState(), 4, BlockHelper.forBlock(FakeOres.fd_stone))).generate(world, rand, new BlockPos(x + rand.nextInt(16), rand.nextInt(128), z + rand.nextInt(16)));
        }
    }

    public void generateNether(World world, int x, int z, Random rand)
    {
        if(FakeOres.enableFakeOres)
        {
            for(int i = 0; i < 16; i++)
            {
                (new WorldGenMinable(FakeOres.fakeOreVanilla.getDefaultState(), 13, BlockHelper.forBlock(Blocks.netherrack))).generate(world, rand, new BlockPos(x + rand.nextInt(16), rand.nextInt(108) + 10, z + rand.nextInt(16)));
            }
        }
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
    {
        switch(world.provider.getDimensionId())
        {
        case 0:
            this.generateSurface(world, chunkX * 16, chunkZ * 16, random);
        case -1:
            this.generateNether(world, chunkX * 16, chunkZ * 16, random);
        }
        if(world.provider.getDimensionId() == FakeOres.dimID)
        {
            this.generateCustom(world, chunkX * 16, chunkZ * 16, random);
        }
    }
}