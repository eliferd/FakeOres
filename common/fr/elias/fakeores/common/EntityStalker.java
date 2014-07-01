package fr.elias.fakeores.common;

import java.util.List;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityStalker extends EntityCreature
{
	public boolean hasPath;
	public EntityStalker(World world) 
	{
		super(world);
		hasPath = false;
	}
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(2.0D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(3.0D);
    }
	public void onLivingUpdate()
	{
		List list = worldObj.getEntitiesWithinAABB(EntityPlayer.class, AxisAlignedBB.getAABBPool().getAABB(posX, posY, posZ, posX + 1, posY + 1, posZ + 1).expand(16D, 4D, 16D));
		PathEntity pathentity;
		for(int i = 0; i< list.size(); i++)
		{
			Entity entity = (Entity)list.get(i);
			if(!list.isEmpty())
			{
				float f = entity.getDistanceToEntity(this);
				if(f > 2.0F && f < 20.0F)
				{
					pathentity = worldObj.getPathEntityToEntity(this, entity, 16F, true, false, false, true);
					hasPath = true;
				}
				else
				{
					hasPath = false;
					pathentity = null;
				}
				this.setPathToEntity(pathentity);
			}
		}
		super.onLivingUpdate();
	}
	public void readEntityFromNBT(NBTTagCompound nbt)
	{
		super.readEntityFromNBT(nbt);
		hasPath = nbt.getBoolean("HasPath");
	}
	public void writeEntityToNBT(NBTTagCompound nbt)
	{
		super.writeEntityToNBT(nbt);
		nbt.setBoolean("HasPath", hasPath);
	}
    protected void attackEntity(Entity par1Entity, float par2)
    {
        if (this.attackTime <= 0 && par2 < 2.0F && par1Entity.boundingBox.maxY > this.boundingBox.minY && par1Entity.boundingBox.minY < this.boundingBox.maxY)
        {
            this.attackTime = 10;
            this.attackEntityAsMob(par1Entity);
        }
    }

    public boolean attackEntityAsMob(Entity par1Entity)
    {
        float f = (float)this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
        int i = 0;

        if (par1Entity instanceof EntityLivingBase)
        {
            f += EnchantmentHelper.getEnchantmentModifierLiving(this, (EntityLivingBase)par1Entity);
            i += EnchantmentHelper.getKnockbackModifier(this, (EntityLivingBase)par1Entity);
        }

        boolean flag = par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), f);

        if (flag)
        {
            if (i > 0)
            {
                par1Entity.addVelocity((double)(-MathHelper.sin(this.rotationYaw * (float)Math.PI / 180.0F) * (float)i * 0.5F), 0.1D, (double)(MathHelper.cos(this.rotationYaw * (float)Math.PI / 180.0F) * (float)i * 0.5F));
                this.motionX *= 0.6D;
                this.motionZ *= 0.6D;
            }

            int j = EnchantmentHelper.getFireAspectModifier(this);

            if (j > 0)
            {
                par1Entity.setFire(j * 4);
            }

            if (par1Entity instanceof EntityLivingBase)
            {
                EnchantmentHelper.func_151384_a((EntityLivingBase)par1Entity, this);
            }

            EnchantmentHelper.func_151385_b(this, par1Entity);
        }

        return flag;
    }

	public void updateEntityActionState()
	{
		List list = worldObj.getEntitiesWithinAABB(EntityCreature.class, AxisAlignedBB.getAABBPool().getAABB(posX, posY, posZ, posX + 1, posY + 1, posZ + 1).expand(16D, 4D, 16D));
		for(int i = 0; i< list.size(); i++)
		{
			Entity entity = (Entity)list.get(i);
			if(!list.isEmpty())
			{
				if(!hasPath && !(entity instanceof EntityPlayer)&& !(entity instanceof EntityStalker) && !(entity instanceof EntityDangerousPlant) && !(entity instanceof EntityRegenEgg))
				{
					if(entity.getDistanceToEntity(this) < 8F)
					{
						this.setTarget(entity);
					}
				}
			}
		}
		super.updateEntityActionState();
	}
}
