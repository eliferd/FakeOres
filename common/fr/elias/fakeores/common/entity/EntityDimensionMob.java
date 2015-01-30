package fr.elias.fakeores.common.entity;

import fr.elias.fakeores.common.FakeOres;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityDimensionMob extends EntityCreature
{
    public boolean isHostile;
    public static Item droppedItems[];
    public boolean isBloodable;

    public EntityDimensionMob(World par1World)
    {
        super(par1World);
        this.experienceValue = 5;
        isHostile = false;
        isBloodable = true;
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons use this to react to sunlight and start to burn.
     */
    @Override
    public void onLivingUpdate()
    {
        this.updateArmSwingProgress();
        super.onLivingUpdate();
    }

    @Override
    public void onUpdate()
    {
        if(hurtTime > 0 && worldObj.isRemote || getHealth() < 8.5F && worldObj.isRemote)
        {
            blood();
        }
        super.onUpdate();
    }

    public void blood()
    {
        if(isBloodable)
        {
            if(rand.nextInt(4) == 0)
            {
                FakeOres.proxy.spawnParticle(worldObj, "blood", posX, posY + 1, posZ);
            }
        }
    }

    @Override
    protected String getSwimSound()
    {
        return "game.hostile.swim";
    }

    @Override
    protected String getSplashSound()
    {
        return "game.hostile.swim.splash";
    }

    /**
     * Finds the closest player within 16 blocks to attack, or null if this Entity isn't interested in attacking (Animals, Spiders at day, peaceful PigZombies).
     */
    /*
     * @Override protected Entity findPlayerToAttack() { EntityPlayer entityplayer = this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0D); return entityplayer != null && this.canEntityBeSeen(entityplayer) && isHostile ? entityplayer : null; }
     */

    /**
     * Called when the entity is attacked.
     */
    @Override
    public boolean attackEntityFrom(DamageSource par1DamageSource, float par2)
    {
        if(this.isEntityInvulnerable(par1DamageSource))
        {
            return false;
        }
        else if(super.attackEntityFrom(par1DamageSource, par2))
        {
            Entity entity = par1DamageSource.getEntity();

            if(this.riddenByEntity != entity && this.ridingEntity != entity)
            {
                if(entity != this)
                {
                    // this.entityToAttack = entity;
                }

                return true;
            }
            else
            {
                return true;
            }
        }
        else
        {
            return false;
        }
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    @Override
    protected String getHurtSound()
    {
        return "game.hostile.hurt";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    @Override
    protected String getDeathSound()
    {
        return "game.hostile.die";
    }

    /*
     * @Override protected String func_146067_o(int p_146067_1_) { return p_146067_1_ > 4 ? "game.hostile.hurt.fall.big" : "game.hostile.hurt.fall.small"; }
     */

    @Override
    public boolean attackEntityAsMob(Entity par1Entity)
    {
        float f = (float)this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
        int i = 0;

        if(par1Entity instanceof EntityLivingBase)
        {
            // f += EnchantmentHelper.getEnchantmentModifierLiving(this, (EntityLivingBase)par1Entity);
            // i += EnchantmentHelper.getKnockbackModifier(this, (EntityLivingBase)par1Entity);
        }

        boolean flag = par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), f);

        if(flag)
        {
            if(i > 0)
            {
                par1Entity.addVelocity(-MathHelper.sin(this.rotationYaw * (float)Math.PI / 180.0F) * i * 0.5F, 0.1D, MathHelper.cos(this.rotationYaw * (float)Math.PI / 180.0F) * i * 0.5F);
                this.motionX *= 0.6D;
                this.motionZ *= 0.6D;
            }

            int j = EnchantmentHelper.getFireAspectModifier(this);

            if(j > 0)
            {
                par1Entity.setFire(j * 4);
            }

            if(par1Entity instanceof EntityLivingBase)
            {
                EnchantmentHelper.func_151384_a((EntityLivingBase)par1Entity, this);
            }

            EnchantmentHelper.func_151385_b(this, par1Entity);
        }

        return flag;
    }

    /**
     * Basic mob attack. Default to touch of death in EntityCreature. Overridden by each mob to define their attack.
     */
    /*
     * protected void attackEntity(Entity par1Entity, float par2) { if(isHostile) { if(this.attackTime <= 0 && par2 < 2.0F && par1Entity.boundingBox.maxY > this.boundingBox.minY && par1Entity.boundingBox.minY < this.boundingBox.maxY) { this.attackTime = 20; this.attackEntityAsMob(par1Entity); } } }
     */

    /**
     * Checks if the entity's current position is a valid location to spawn this entity.
     */
    @Override
    public boolean getCanSpawnHere()
    {
        return super.getCanSpawnHere();
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
    }

    @Override
    public Item getDropItem()
    {
        return droppedItems[rand.nextInt(droppedItems.length)];
    }

    static
    {
        droppedItems = (new Item[] {Items.stick, Items.apple, Items.bone, Items.feather, Item.getItemFromBlock(FakeOres.fd_dirt), Item.getItemFromBlock(FakeOres.fd_grass)});
    }
}
