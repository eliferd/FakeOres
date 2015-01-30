package fr.elias.fakeores.common.entity;

import net.minecraft.entity.EntityCreature;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityFlyer_Shield extends EntityCreature
{
    public int lifespan;

    public EntityFlyer_Shield(World par1World)
    {
        super(par1World);
        lifespan = 200;
        setSize(3F, 3.7F);
    }

    @Override
    public void onLivingUpdate()
    {
        super.onLivingUpdate();
        rotationYaw = getRandom(0, 360);
        if(lifespan-- < 0)
        {
            setDead();
        }
    }

    /*
     * @Override public void updateEntityActionState() { List list = worldObj.getEntitiesWithinAABB(EntityFlyer.class, AxisAlignedBB.fromBounds(posX, posY, posZ, posX + 1, posY + 1, posZ + 1).expand(8D, 4D, 8D)); for(int i = 0; i< list.size(); i++) { Entity entity = (Entity)list.get(i); EntityFlyer flyer = (EntityFlyer) entity; if(flyer.getHealth() < 0.5F) { this.setDead(); } } super.updateEntityActionState(); }
     */
    @Override
    public void onDeath(DamageSource damagesource)
    {
        super.onDeath(damagesource);
        worldObj.createExplosion(this, posX, posY, posZ, 0.0F, false);
    }

    public int getRandom(final int min, final int max)
    {
        return min + (int)(Math.random() * ((max - min) + 1));
    }

    @Override
    public boolean attackEntityFrom(DamageSource damagesource, float damageValue)
    {
        return false;
    }

    @Override
    public double getMountedYOffset()
    {
        return this.height - 0.35D;
    }

    @Override
    public void updateRiderPosition()
    {
        if(this.riddenByEntity != null)
        {
            this.riddenByEntity.setPosition(this.posX, this.posY + this.getMountedYOffset() + this.riddenByEntity.getYOffset(), this.posZ);
        }
    }

    @Override
    protected void entityInit()
    {
        super.entityInit();
        this.spawnExplosionParticle();
    }
}