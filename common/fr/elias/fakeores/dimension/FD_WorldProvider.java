package fr.elias.fakeores.dimension;

import fr.elias.fakeores.common.FakeOres;

import net.minecraft.entity.Entity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.Vec3;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.IChunkProvider;

public class FD_WorldProvider extends WorldProvider
{
    @Override
    public void registerWorldChunkManager()
    {
        this.worldChunkMgr = new FD_WorldChunkManager(worldObj.getSeed(), 0.0F);
        this.dimensionId = FakeOres.dimID;
        hasNoSky = true;
    }

    @Override
    public String getDimensionName()
    {
        return "Fake Ores Dimension";
    }

    @Override
    public boolean isSurfaceWorld()
    {
        return false;
    }

    @Override
    public int getHeight()
    {
        return 256;
    }

    @Override
    public boolean canCoordinateBeSpawn(int x, int z)
    {
        return this.worldObj.getGroundAboveSeaLevel(new BlockPos(x, 0, z)) == FakeOres.fd_grass;
    }

    @Override
    public String getSaveFolder()
    {
        return "DIMFakeOres";
    }

    @Override
    public IChunkProvider createChunkGenerator()
    {
        return new FD_ChunkProvider(worldObj, worldObj.getSeed(), false, "");
    }

    @Override
    public Vec3 getSkyColor(Entity cameraEntity, float partialTicks)
    {
        return new Vec3(1.2, 0.2, 0.2);
    }

    @Override
    public boolean isSkyColored()
    {
        return true;
    }

    @Override
    public float calculateCelestialAngle(long par1, float par3)
    {
        return 0.0F;
    }

    @Override
    protected void generateLightBrightnessTable()
    {
        float f = 1F;

        for(int i = 0; i <= 15; ++i)
        {
            float f1 = 1.0F - i / 15.0F;
            this.lightBrightnessTable[i] = (1.0F - f1) / (f1 * 3.0F + 1.0F) * (1.0F - f) + f;
        }
    }

    @Override
    public String getInternalNameSuffix()
    {
        return "_fake_ore";
    }
}