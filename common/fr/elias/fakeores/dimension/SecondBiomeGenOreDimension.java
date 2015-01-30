package fr.elias.fakeores.dimension;

import fr.elias.fakeores.common.FakeOres;
import fr.elias.fakeores.common.entity.EntityBlackMage;
import fr.elias.fakeores.common.entity.EntityDangerousPlant;
import fr.elias.fakeores.common.entity.EntityMutantMonster;
import fr.elias.fakeores.common.entity.EntityNopeGuy;

import net.minecraft.world.biome.BiomeGenBase;

public class SecondBiomeGenOreDimension extends BiomeGenOreDimension
{
    public SecondBiomeGenOreDimension(int par1)
    {
        super(par1);
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
        if(FakeOres.spawn_BlackMage)
        {
            this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityBlackMage.class, 6, 1, 1));
        }
        if(FakeOres.spawn_MutantMonster)
        {
            this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityMutantMonster.class, 12, 1, 3));
        }
        if(FakeOres.spawn_NopeGuy)
        {
            this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityNopeGuy.class, 12, 1, 3));
        }
        if(FakeOres.spawn_DangerousPlant)
        {
            this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityDangerousPlant.class, 5, 1, 1));
        }
        this.topBlock = FakeOres.fd_second_grass.getDefaultState();
        this.fillerBlock = FakeOres.fd_dirt.getDefaultState();
        this.rainfall = 0.0F;
        this.temperature = 1F;
        this.waterColorMultiplier = 0x280ED0;
    }
}