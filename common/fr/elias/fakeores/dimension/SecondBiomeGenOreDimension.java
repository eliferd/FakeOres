package fr.elias.fakeores.dimension;

import net.minecraft.world.biome.BiomeGenBase;
import fr.elias.fakeores.common.EntityBlackMage;
import fr.elias.fakeores.common.EntityDangerousPlant;
import fr.elias.fakeores.common.EntityMutantMonster;
import fr.elias.fakeores.common.EntityNopeGuy;
import fr.elias.fakeores.common.FakeOres;

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
		this.topBlock = FakeOres.fd_second_grass;
		this.fillerBlock = FakeOres.fd_dirt;
		this.rainfall = 0.0F;
		this.temperature = 1F;
		this.waterColorMultiplier = 0x280ED0;
	}

}
