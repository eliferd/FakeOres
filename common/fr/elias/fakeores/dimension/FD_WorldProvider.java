package fr.elias.fakeores.dimension;

import cpw.mods.fml.common.ObfuscationReflectionHelper;
import cpw.mods.fml.relauncher.ReflectionHelper;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.storage.WorldInfo;
import net.minecraftforge.common.DimensionManager;
import fr.elias.fakeores.common.FakeOres;

public class FD_WorldProvider extends WorldProvider
{
	public void registerWorldChunkManager()
	{
		this.worldChunkMgr = new FD_WorldChunkManager(worldObj.getSeed(), terrainType);
		this.dimensionId = FakeOres.dimID;
		hasNoSky = true;
	}
	@Override
	public String getDimensionName()
	{
		// TODO Auto-generated method stub
		return "Fake Ores Dimension";
	}
    public boolean isSurfaceWorld()
    {
        return false;
    }
    public boolean getWorldHasVoidParticles()
    {
        return false;
    }
    public int getHeight()
    {
        return 256;
    }
	public boolean canCoordinateBeSpawn(int par1, int par2)
	{
		return this.worldObj.getTopBlock(par1, par2) == FakeOres.fd_grass;
	}
	public String getSaveFolder()
	{
		return "DIMFakeOres";
	}
	@Override
	public IChunkProvider createChunkGenerator()
	{
		return new FD_ChunkProvider(worldObj, worldObj.getSeed(), false);
	}

	@Override
	public Vec3 getSkyColor(Entity cameraEntity, float partialTicks)
	{
		return this.worldObj.getWorldVec3Pool().getVecFromPool(1.2, 0.2, 0.2);
	}

	@Override
	public boolean isSkyColored()
	{
		return true;
	}
    public float calculateCelestialAngle(long par1, float par3)
    {
        return 0.0F;
    }
    protected void generateLightBrightnessTable()
    {
        float f = 1F;

        for (int i = 0; i <= 15; ++i)
        {
            float f1 = 1.0F - (float)i / 15.0F;
            this.lightBrightnessTable[i] = (1.0F - f1) / (f1 * 3.0F + 1.0F) * (1.0F - f) + f;
        }
    }
}
