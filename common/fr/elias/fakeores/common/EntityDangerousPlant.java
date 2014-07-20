package fr.elias.fakeores.common;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
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
	public void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(1000D);
		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(Double.MAX_VALUE);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.0F);
	}
	public void readEntityFromNBT(NBTTagCompound tag)
	{
		super.readEntityFromNBT(tag);
		isPoisonous = tag.getBoolean("IsPoisonous");
	}
	public void writeEntityToNBT(NBTTagCompound tag)
	{
		super.writeEntityToNBT(tag);
		tag.setBoolean("IsPoisonous", isPoisonous);
	}
	public boolean attackEntityFrom(DamageSource damagesource, float damageValue)
	{
		return false;
	}
	public boolean isMovementCeased()
	{
		return true;
	}
    public AxisAlignedBB getCollisionBox(Entity p_70114_1_)
    {
        return p_70114_1_.boundingBox;
    }
    
    public AxisAlignedBB getBoundingBox()
    {
        return this.boundingBox;
    }
    public boolean canBeCollidedWith()
    {
        return !this.isDead;
    }
    public boolean canBePushed()
    {
    	return false;
    }
	public void onUpdate()
	{
		super.onUpdate();
        if (!this.worldObj.isRemote)
        {
            List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(0.8D, 0.1D, 0.8D));

            if (list != null && !list.isEmpty())
            {
                for (int k1 = 0; k1 < list.size(); ++k1)
                {
                    Entity entity = (Entity)list.get(k1);

                    if (entity.canBePushed() && entity instanceof EntityDangerousPlant)
                    {
                        entity.applyEntityCollision(this);
                    }
                }
            }
        }
	}
	public boolean isMovementBlocked()
	{
		return true;
	}
	public void onCollideWithPlayer(EntityPlayer player)
	{
		float f = this.getHealth();

		if(player.attackEntityFrom(DamageSource.causeMobDamage(this), 5F));
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
	public boolean getCanSpawnHere()
	{
		int i = MathHelper.floor_double(posX);
		int j = MathHelper.floor_double(posY);
		int k = MathHelper.floor_double(posZ);
		return worldObj.getBlock(i, j - 1, k) == FakeOres.fd_grass || worldObj.getBlock(i, j - 1, k) == FakeOres.fd_second_grass;
	}
	public int getMaxSpawnedInChunk()
	{
		return 1;
	}
}
