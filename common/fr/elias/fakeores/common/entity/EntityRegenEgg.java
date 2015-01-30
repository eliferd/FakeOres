package fr.elias.fakeores.common.entity;

import fr.elias.fakeores.common.FakeOres;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityRegenEgg extends EntityCreature
{
    public EntityRegenEgg(World par1World)
    {
        super(par1World);
        setSize(0.5F, 0.5F);
        isImmuneToFire = true;
    }

    @Override
    public boolean isMovementBlocked()
    {
        return true;
    }

    public boolean isMovementCeased()
    {
        return true;
    }

    @Override
    public boolean attackEntityFrom(DamageSource damagesource, float f)
    {
        return false;
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10D);
    }

    @Override
    public void onCollideWithPlayer(EntityPlayer player)
    {
        player.addPotionEffect(new PotionEffect(Potion.heal.id, 200, 1));
        player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 200, 1));
        player.addPotionEffect(new PotionEffect(Potion.jump.id, 200, 1));
        setDead();
        this.spawnExplosionParticle();
    }

    @Override
    public boolean getCanSpawnHere()
    {
        int i = MathHelper.floor_double(posX);
        int j = MathHelper.floor_double(posY);
        int k = MathHelper.floor_double(posZ);
        return worldObj.getBlockState(new BlockPos(i, j - 1, k)).getBlock() == FakeOres.fd_grass || worldObj.getBlockState(new BlockPos(i, j - 1, k)).getBlock() == Blocks.water;
    }

    @Override
    public int getMaxSpawnedInChunk()
    {
        return 1;
    }
}