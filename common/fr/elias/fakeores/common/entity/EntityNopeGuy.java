package fr.elias.fakeores.common.entity;

import fr.elias.fakeores.common.FakeOres;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;

public class EntityNopeGuy extends EntityDimensionMob
{

    public EntityNopeGuy(World par1World)
    {
        super(par1World);
        isHostile = false;
    }

    @Override
    public void onLivingUpdate()
    {
        super.onLivingUpdate();
        for(int i = 0; i < 1; i++)
        {
            if(worldObj.isRemote)
            {
                if(this.hurtTime > 0)
                {
                    FakeOres.proxy.spawnParticle(worldObj, "nope", posX, posY - 0.5D, posZ);
                }
            }
        }
    }

    @Override
    protected String getHurtSound()
    {
        return "fakeores:mob.nopeguy.hurt";
    }

    @Override
    protected String getDeathSound()
    {
        return "fakeores:mob.nopeguy.dead";
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(40D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(2.0D);
    }

    @Override
    protected void dropFewItems(boolean par1, int par2)
    {
        if(rand.nextInt(8) == 0)
        {
            dropItem(FakeOres.letter_n, 1);
        }
        if(rand.nextInt(6) == 0)
        {
            dropItem(FakeOres.letter_o, 1);
        }
        if(rand.nextInt(4) == 0)
        {
            dropItem(FakeOres.letter_p, 1);
        }
        if(rand.nextInt(4) == 0)
        {
            dropItem(FakeOres.letter_e, 1);
        }
    }
}
