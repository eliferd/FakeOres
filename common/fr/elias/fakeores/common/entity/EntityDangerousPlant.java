package fr.elias.fakeores.common.entity;

import fr.elias.fakeores.common.FakeOres;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityDangerousPlant extends EntityCreature
{
    public boolean isPoisonous;

    public EntityDangerousPlant(World par1World)
    {
        super(par1World);
        isPoisonous = rand.nextInt(10) == 0 ? true : false;
        setSize(0.8F, 0.1F);
    }

    @Override
    public void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(1000D);
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(Double.MAX_VALUE);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.0F);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound tag)
    {
        super.readEntityFromNBT(tag);
        isPoisonous = tag.getBoolean("IsPoisonous");
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound tag)
    {
        super.writeEntityToNBT(tag);
        tag.setBoolean("IsPoisonous", isPoisonous);
    }

    @Override
    public boolean attackEntityFrom(DamageSource damagesource, float damageValue)
    {
        return false;
    }

    @Override
    public boolean canBeCollidedWith()
    {
        return !this.isDead;
    }

    @Override
    public boolean canBePushed()
    {
        return false;
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();
        if(!this.worldObj.isRemote)
        {
            List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.getEntityBoundingBox().expand(0.8D, 0.1D, 0.8D));

            if(list != null && !list.isEmpty())
            {
                for(int k1 = 0; k1 < list.size(); ++k1)
                {
                    Entity entity = (Entity)list.get(k1);

                    if(entity.canBePushed() && entity instanceof EntityDangerousPlant)
                    {
                        entity.applyEntityCollision(this);
                    }
                }
            }
        }
    }

    @Override
    public boolean isMovementBlocked()
    {
        return true;
    }

    @Override
    public void onCollideWithPlayer(EntityPlayer player)
    {
        float f = this.getHealth();

        if(player.attackEntityFrom(DamageSource.causeMobDamage(this), 5F))
            ;
        {
            f--;
        }
        if(isPoisonous)
        {
            player.addPotionEffect(new PotionEffect(Potion.poison.id, 100, 1));
            f--;
        }
        if(rand.nextInt(70) == 0)
        {
            if(!worldObj.isRemote)
            {
                player.mountEntity(this);
            }
        }
        if(f < 1.0F)
        {
            setDead();
        }
    }

    @Override
    public boolean getCanSpawnHere()
    {
        int i = MathHelper.floor_double(posX);
        int j = MathHelper.floor_double(posY);
        int k = MathHelper.floor_double(posZ);
        return worldObj.getBlockState(new BlockPos(i, j - 1, k)) == FakeOres.fd_grass || worldObj.getBlockState(new BlockPos(i, j - 1, k)) == FakeOres.fd_second_grass;
    }

    @Override
    public int getMaxSpawnedInChunk()
    {
        return 1;
    }
}