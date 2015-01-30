package fr.elias.fakeores.dimension;

import fr.elias.fakeores.common.FakeOres;
import fr.elias.fakeores.common.entity.EntityDangerousPlant;
import fr.elias.fakeores.common.entity.EntityFlyer;
import fr.elias.fakeores.common.entity.EntityNopeGuy;
import fr.elias.fakeores.common.entity.EntityPlayerHunter;
import fr.elias.fakeores.common.entity.EntityRegenEgg;
import fr.elias.fakeores.common.entity.EntitySchaza;
import fr.elias.fakeores.common.entity.EntityStalker;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;

public class BiomeGenOreDimension extends BiomeGenBase
{
    public BiomeGenOreDimension(int par1)
    {
        super(par1);
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
        if(FakeOres.spawn_PlayerHunter)
        {
            this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityPlayerHunter.class, 12, 1, 2));
        }
        if(FakeOres.spawn_Flyer)
        {
            this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityFlyer.class, 12, 2, 5));
        }
        if(FakeOres.spawn_Schaza)
        {
            this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntitySchaza.class, 12, 2, 8));
        }
        if(FakeOres.spawn_RegenEgg)
        {
            this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityRegenEgg.class, 5, 1, 1));
        }
        if(FakeOres.spawn_NopeGuy)
        {
            this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityNopeGuy.class, 12, 1, 3));
        }
        if(FakeOres.spawn_DangerousPlant)
        {
            this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityDangerousPlant.class, 5, 1, 1));
        }
        if(FakeOres.spawn_Stalker)
        {
            this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityStalker.class, 12, 1, 1));
        }
        this.topBlock = FakeOres.fd_grass.getDefaultState();
        this.fillerBlock = FakeOres.fd_dirt.getDefaultState();
        this.setBiomeName("FakeOresBiome");
        this.rainfall = 0.0F;
        this.temperature = 1F;
    }

    @Override
    public void genTerrainBlocks(World world, Random rand, ChunkPrimer primer, int p_180622_4_, int p_180622_5_, double p_180622_6_)
    {
        this.genBiomeTerrain(world, rand, primer, p_180622_4_, p_180622_5_, p_180622_6_);
    }

    public final void genBiomeTerrain(World world, Random rand, ChunkPrimer primer, int p_180628_4_, int p_180628_5_, double p_180628_6_)
    {
        boolean flag = true;
        IBlockState block = this.topBlock;
        IBlockState block1 = this.fillerBlock;
        int k = -1;
        int l = (int)(p_180628_6_ / 3.0D + 3.0D + rand.nextDouble() * 0.25D);
        int i1 = p_180628_4_ & 15;
        int j1 = p_180628_5_ & 15;

        for(int k1 = 255; k1 >= 0; --k1)
        {
            if(k1 <= 0 + rand.nextInt(5))
            {
                primer.setBlockState(j1, k1, i1, Blocks.bedrock.getDefaultState());
            }
            else
            {
                IBlockState block2 = primer.getBlockState(j1, k1, i1);

                if(block2.getBlock().getMaterial() != Material.air)
                {
                    if(block2.getBlock() == FakeOres.fd_stone)
                    {
                        if(k == -1)
                        {
                            if(l <= 0)
                            {
                                block = null;
                                block1 = FakeOres.fd_stone.getDefaultState();
                            }
                            else if(k1 >= 59 && k1 <= 64)
                            {
                                block = this.topBlock;
                                block1 = this.fillerBlock;
                            }

                            if(k1 < 63 && (block == null || block.getBlock().getMaterial() == Material.air))
                            {
                                if(this.getFloatTemperature(new BlockPos(p_180628_4_, k1, p_180628_5_)) < 0.15F)
                                {
                                    block = Blocks.ice.getDefaultState();
                                }
                                else
                                {
                                    block = FakeOres.fd_strangeliquid.getDefaultState();
                                }
                            }

                            k = l;

                            if(k1 >= 62)
                            {
                                primer.setBlockState(j1, k1, i1, block);
                            }
                            else if(k1 < 56 - l)
                            {
                                block = null;
                                block1 = FakeOres.fd_stone.getDefaultState();
                                primer.setBlockState(j1, k1, i1, FakeOres.fd_stone.getDefaultState());
                            }
                            else
                            {
                                primer.setBlockState(j1, k1, i1, block1);
                            }
                        }
                        else if(k > 0)
                        {
                            --k;
                            primer.setBlockState(j1, k1, i1, block1);

                            if(k == 0 && block1 == Blocks.sand)
                            {
                                k = rand.nextInt(4) + Math.max(0, k1 - 63);
                                block1 = Blocks.sandstone.getDefaultState();
                            }
                        }
                    }
                }
                else
                {
                    k = -1;
                }
            }
        }
    }
}