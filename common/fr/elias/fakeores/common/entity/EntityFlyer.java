package fr.elias.fakeores.common.entity;

import java.util.List;

import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityFlyer extends EntityDimensionMob
{
    public EntityFlyer(World par1World)
    {
        super(par1World);
        this.isHostile = worldObj.getDifficulty() == EnumDifficulty.PEACEFUL ? false : true;
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(40D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(7.5D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(3.0D);
    }

    /*
     * @Override protected Entity findPlayerToAttack() { return isHostile ? super.findPlayerToAttack() : null; }
     */

    @Override
    public boolean getCanSpawnHere()
    {
        return !worldObj.isDaytime();
    }

    @Override
    public void onLivingUpdate()
    {
        super.onLivingUpdate();
        int x = (int)posX, y = (int)posY, z = (int)posZ;
        if(worldObj.getBlockState(new BlockPos(x, y - 1, z)) == Blocks.water)
        {
            this.spawnExplosionParticle();
            worldObj.setBlockState(new BlockPos(x, y - 1, z), Blocks.ice.getDefaultState());
            worldObj.setBlockState(new BlockPos(x - 1, y - 1, z), Blocks.ice.getDefaultState());
            worldObj.setBlockState(new BlockPos(x, y - 1, z - 1), Blocks.ice.getDefaultState());
            worldObj.setBlockState(new BlockPos(x + 1, y - 1, z), Blocks.ice.getDefaultState());
            worldObj.setBlockState(new BlockPos(x, y - 1, z + 1), Blocks.ice.getDefaultState());

            worldObj.setBlockState(new BlockPos(x + 1, y - 1, z + 1), Blocks.ice.getDefaultState());
            worldObj.setBlockState(new BlockPos(x - 1, y - 1, z - 1), Blocks.ice.getDefaultState());
        }

        if(worldObj.getBlockState(new BlockPos(x, y - 1, z)) == Blocks.lava)
        {
            worldObj.setBlockState(new BlockPos(x, y - 1, z), Blocks.obsidian.getDefaultState());
            worldObj.setBlockState(new BlockPos(x - 1, y - 1, z), Blocks.obsidian.getDefaultState());
            worldObj.setBlockState(new BlockPos(x, y - 1, z - 1), Blocks.obsidian.getDefaultState());
            worldObj.setBlockState(new BlockPos(x + 1, y - 1, z), Blocks.obsidian.getDefaultState());
            worldObj.setBlockState(new BlockPos(x, y - 1, z + 1), Blocks.obsidian.getDefaultState());

            worldObj.setBlockState(new BlockPos(x + 1, y - 1, z + 1), Blocks.obsidian.getDefaultState());
            worldObj.setBlockState(new BlockPos(x - 1, y - 1, z - 1), Blocks.obsidian.getDefaultState());
        }
        if(this.isInWater())
        {
            this.motionY += 0.25D;
        }
    }

    @Override
    public boolean attackEntityFrom(DamageSource damagesource, float damageValue)
    {
        if(damagesource.getEntity() != null)
        {
            if(damagesource.getEntity() instanceof EntityPlayer)
            {
                if(rand.nextInt(15) == 0)
                {
                    if(!worldObj.isRemote)
                    {
                        EntityFlyer_Shield shield = new EntityFlyer_Shield(worldObj);
                        shield.setPosition(posX, posY, posZ);
                        List list = worldObj.getEntitiesWithinAABB(EntityFlyer_Shield.class, AxisAlignedBB.fromBounds(posX, posY, posZ, posX + 1, posY + 1, posZ + 1).expand(16D, 4D, 16D));
                        if(getHealth() > 5.0F)
                        {
                            if(list.isEmpty())
                            {
                                worldObj.spawnEntityInWorld(shield);
                                shield.spawnExplosionParticle();
                                shield.mountEntity(this);
                                if(this.getHealth() < 5.0F)
                                {
                                    shield.setDead();
                                }
                                return false;
                            }
                        }
                    }
                }

            }
        }
        return super.attackEntityFrom(damagesource, damageValue);
    }

    @Override
    public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.UNDEAD;
    }
}