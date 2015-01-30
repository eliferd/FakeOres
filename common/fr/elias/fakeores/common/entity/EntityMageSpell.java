package fr.elias.fakeores.common.entity;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityMageSpell extends EntityCreature
{
    public int lifespan;
    public Entity target;

    public EntityMageSpell(World par1World)
    {
        super(par1World);
        lifespan = 200;
    }

    @Override
    public void onLivingUpdate()
    {
        super.onLivingUpdate();
        if(lifespan-- < 0)
        {
            setDead();
        }
        Object obj = null;
        List list = worldObj.getEntitiesWithinAABBExcludingEntity(this, getEntityBoundingBox().addCoord(motionX, motionY, motionZ).expand(2.0D, 2.0D, 2.0D));
        double d = 0.0D;

        for(int i = 0; i < list.size(); i++)
        {
            Entity entity = (Entity)list.get(i);

            if(entity.canBeCollidedWith() && (entity instanceof EntityLiving) && !(entity instanceof EntityMageSpell) && !(entity instanceof EntityBlackMage))
            {
                entity.motionX = rand.nextFloat() * 0.7F;
                entity.motionY = rand.nextFloat() * 0.4F;
                entity.motionZ = rand.nextFloat() * 0.7F;
            }
            if(entity.canBeCollidedWith() && (entity instanceof EntityBlackMage))
            {
                setDead();
            }
            double d1, d2, d3;
            d1 = entity.posX - this.posX;
            d2 = getEntityBoundingBox().minY + entity.height / 2.0F - (this.posY + this.height / 2.0F);
            d3 = entity.posZ - this.posZ;
            this.moveEntity(d1, d2, d3);
            if(onGround)
            {
                setDead();
                moveEntity(d1, d2, d3);
            }
        }

    }

    @Override
    public boolean attackEntityFrom(DamageSource damagesource, float f)
    {
        return false;
    }

    @Override
    public void onCollideWithPlayer(EntityPlayer player)
    {
        if(rand.nextInt(20) == 0)
        {
            player.attackEntityFrom(DamageSource.causeMobDamage(this), 0.5F);
        }
        player.motionZ = rand.nextFloat() * 2.0F - 1.0F;
        player.motionY = rand.nextFloat() * 2.0F - 1.0F;
        player.motionX = rand.nextFloat() * 2.0F - 1.0F;
        this.setPosition(player.posX, player.posY, player.posZ);
        this.spawnExplosionParticle();
        if(rand.nextInt(120) == 0)
        {
            setDead();
        }
    }
}