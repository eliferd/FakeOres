package fr.elias.fakeores.dimension;

import fr.elias.fakeores.common.FakeOres;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeCache;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class FD_WorldChunkManager extends WorldChunkManager
{
    private GenLayer myGenBiomes;
    private GenLayer myBiomeIndexLayer;
    private BiomeCache myBiomeCache;
    private List<BiomeGenBase> myBiomesToSpawnIn;

    public FD_WorldChunkManager()
    {
        this.myBiomeCache = new BiomeCache(this);
        this.myBiomesToSpawnIn = new ArrayList<BiomeGenBase>();
        this.myBiomesToSpawnIn.add(FakeOres.mainODBiome);
    }

    public FD_WorldChunkManager(long seed, float rainfall)
    {
        this();
        GenLayer[] agenlayer = FD_GenLayer.makeTheWorld(seed);
        this.myGenBiomes = agenlayer[0];
        this.myBiomeIndexLayer = agenlayer[1];
    }

    public FD_WorldChunkManager(World world)
    {
        this(world.getSeed(), 0.0F);
    }

    @Override
    public List<BiomeGenBase> getBiomesToSpawnIn()
    {
        return this.myBiomesToSpawnIn;
    }

    public BiomeGenBase getBiomeGenAt(int x, int z)
    {
        BiomeGenBase biome = this.myBiomeCache.getBiomeCacheBlock(x, z).getBiomeGenAt(x, z);
        if(biome == null)
        {
            return FakeOres.mainODBiome;
        }
        return biome;
    }

    @Override
    public float[] getRainfall(float[] par1ArrayOfFloat, int par2, int par3, int par4, int par5)
    {
        if(par1ArrayOfFloat == null || par1ArrayOfFloat.length < par4 * par5)
        {
            par1ArrayOfFloat = new float[par4 * par5];
        }

        Arrays.fill(par1ArrayOfFloat, 0, par4 * par5, 0.0F);
        return par1ArrayOfFloat;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public float getTemperatureAtHeight(float par1, int par2)
    {
        return par1;
    }

    @Override
    public BiomeGenBase[] getBiomesForGeneration(BiomeGenBase[] par1ArrayOfBiomeGenBase, int par2, int par3, int par4, int par5)
    {
        IntCache.resetIntCache();

        if(par1ArrayOfBiomeGenBase == null || par1ArrayOfBiomeGenBase.length < par4 * par5)
        {
            par1ArrayOfBiomeGenBase = new BiomeGenBase[par4 * par5];
        }

        int[] aint = this.myGenBiomes.getInts(par2, par3, par4, par5);

        for(int i = 0; i < par4 * par5; ++i)
        {
            if(aint[i] >= 0)
            {
                par1ArrayOfBiomeGenBase[i] = BiomeGenBase.getBiome(aint[i]);
            }
            else
            {
                par1ArrayOfBiomeGenBase[i] = FakeOres.mainODBiome;
            }
        }

        return par1ArrayOfBiomeGenBase;
    }

    @Override
    public BiomeGenBase[] loadBlockGeneratorData(BiomeGenBase[] par1ArrayOfBiomeGenBase, int par2, int par3, int par4, int par5)
    {
        return this.getBiomeGenAt(par1ArrayOfBiomeGenBase, par2, par3, par4, par5, true);
    }

    @Override
    public BiomeGenBase[] getBiomeGenAt(BiomeGenBase[] par1ArrayOfBiomeGenBase, int x, int y, int width, int length, boolean cacheFlag)
    {
        IntCache.resetIntCache();

        if(par1ArrayOfBiomeGenBase == null || par1ArrayOfBiomeGenBase.length < width * length)
        {
            par1ArrayOfBiomeGenBase = new BiomeGenBase[width * length];
        }

        if(cacheFlag && width == 16 && length == 16 && (x & 15) == 0 && (y & 15) == 0)
        {
            BiomeGenBase[] abiomegenbase1 = this.myBiomeCache.getCachedBiomes(x, y);
            System.arraycopy(abiomegenbase1, 0, par1ArrayOfBiomeGenBase, 0, width * length);
            return par1ArrayOfBiomeGenBase;
        }
        else
        {
            int[] aint = this.myBiomeIndexLayer.getInts(x, y, width, length);

            for(int i = 0; i < width * length; ++i)
            {
                if(aint[i] >= 0)
                {
                    par1ArrayOfBiomeGenBase[i] = BiomeGenBase.getBiome(aint[i]);
                }
                else
                {
                    par1ArrayOfBiomeGenBase[i] = FakeOres.mainODBiome;
                }
            }

            return par1ArrayOfBiomeGenBase;
        }
    }

    @Override
    public boolean areBiomesViable(int par1, int par2, int par3, List par4List)
    {
        IntCache.resetIntCache();
        int l = par1 - par3 >> 2;
        int i1 = par2 - par3 >> 2;
        int j1 = par1 + par3 >> 2;
        int k1 = par2 + par3 >> 2;
        int l1 = j1 - l + 1;
        int i2 = k1 - i1 + 1;
        int[] aint = this.myGenBiomes.getInts(l, i1, l1, i2);

        for(int j2 = 0; j2 < l1 * i2; ++j2)
        {
            BiomeGenBase biomegenbase = BiomeGenBase.getBiome(aint[j2]);

            if(!par4List.contains(biomegenbase))
            {
                return false;
            }
        }

        return true;
    }

    @Override
    public BlockPos findBiomePosition(int par1, int par2, int par3, List par4List, Random par5Random)
    {
        IntCache.resetIntCache();
        int l = par1 - par3 >> 2;
        int i1 = par2 - par3 >> 2;
        int j1 = par1 + par3 >> 2;
        int k1 = par2 + par3 >> 2;
        int l1 = j1 - l + 1;
        int i2 = k1 - i1 + 1;
        int[] aint = this.myGenBiomes.getInts(l, i1, l1, i2);
        BlockPos chunkposition = null;
        int j2 = 0;

        for(int k2 = 0; k2 < l1 * i2; ++k2)
        {
            int l2 = l + k2 % l1 << 2;
            int i3 = i1 + k2 / l1 << 2;
            BiomeGenBase biomegenbase = BiomeGenBase.getBiome(aint[k2]);

            if(par4List.contains(biomegenbase) && (chunkposition == null || par5Random.nextInt(j2 + 1) == 0))
            {
                chunkposition = new BlockPos(l2, 0, i3);
                ++j2;
            }
        }

        return chunkposition;
    }

    @Override
    public void cleanupCache()
    {
        this.myBiomeCache.cleanupCache();
    }
}