package fr.elias.fakeores.dimension;

import net.minecraft.world.biome.BiomeGenBase;
import fr.elias.fakeores.common.EntityBlackMage;
import fr.elias.fakeores.common.EntityFlyer;
import fr.elias.fakeores.common.EntityMutantMonster;
import fr.elias.fakeores.common.EntityPlayerHunter;
import fr.elias.fakeores.common.EntityRegenEgg;
import fr.elias.fakeores.common.EntitySchaza;
import fr.elias.fakeores.common.FakeOres;

public class SecondBiomeGenOreDimension extends BiomeGenOreDimension 
{

	public SecondBiomeGenOreDimension(int par1) 
	{
		super(par1);
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		if(FakeOres.spawn_BlackMage){
			this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityBlackMage.class, 6, 1, 1));
		}
		if(FakeOres.spawn_MutantMonster){
			this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityMutantMonster.class, 12, 1, 3));
		}
		this.topBlock = FakeOres.fd_second_grass;
		this.fillerBlock = FakeOres.fd_dirt;
		this.rainfall = 0.0F;
		this.temperature = 1F;
		this.waterColorMultiplier = 0x280ED0;
	}

}
