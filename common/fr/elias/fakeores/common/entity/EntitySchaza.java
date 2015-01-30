package fr.elias.fakeores.common.entity;

import fr.elias.fakeores.common.FakeOres;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

public class EntitySchaza extends EntityDimensionMob
{
    // public double floatcycle;
    public int floatdir;
    public int blastoff;
    public int blastofftimer;

    public EntitySchaza(World par1World)
    {
        super(par1World);
        isHostile = false;
        setSize(1.5F, 1.5F);
        floatdir = 1;
        blastoff = rand.nextInt(500) + 400;
    }

    @Override
    public void onUpdate()
    {
        if(isEntityInsideOpaqueBlock())
        {
            posY += 2.5D;
            floatdir = 1;
        }

        fallDistance = -100F;

        if(riddenByEntity == null && blastoff-- < 0)
        {
            double d = -MathHelper.sin((rotationYaw * (float)Math.PI) / 180F);
            double d1 = MathHelper.cos((rotationYaw * (float)Math.PI) / 180F);
            motionX += d * 0.1D;
            motionZ += d1 * 0.1D;

            if(rand.nextInt(50) == 0)
            {
                this.spawnExplosionParticle();
            }

            if(posY > 100D)
            {
                setDead();
            }
        }

        ignoreFrustumCheck = true;

        if(floatdir > 0)
        {
            floatdir = floatdir * -1;
            fallDistance += -1.5F;
        }
        else
        {
            floatdir = floatdir * -1;
            fallDistance += -1.5F;
        }
        if(riddenByEntity != null && (riddenByEntity instanceof EntityPlayer))
        {
            blastoff++;

            if(blastoff > 50000)
            {
                blastoff = 50000;
            }
        }

        super.onUpdate();
    }

    /*
     * @Override public void updateEntityActionState() { if (riddenByEntity != null && (riddenByEntity instanceof EntityPlayer)) { moveForward = 0.0F; moveStrafing = 0.0F; riddenByEntity.lastTickPosY = 0.0D; prevRotationYaw = rotationYaw = riddenByEntity.rotationYaw; prevRotationPitch = rotationPitch = 0.0F; stepHeight = 920F; EntityPlayer entityplayer = (EntityPlayer)riddenByEntity; float f = 1.0F; if(this.isInsideOfMaterial(Material.water)) // fixed dismount on collide water { motionY += 1D; } moveStrafing = (entityplayer.moveStrafing / f) * 2.75F; moveForward = (entityplayer.moveForward / f) * 2.75F; if (moveStrafing == 0.0F && moveForward == 0.0F) { isJumping = false; } if (onGround && !isJumping) { boolean playerJumping = ObfuscationReflectionHelper.getPrivateValue(EntityLivingBase.class, entityplayer, "isJumping", "field_70703_bu"); isJumping = playerJumping; if (isJumping) { motionY += 2.5D; }else{ motionY = 0; } } return; } else { super.updateEntityActionState(); return; } }
     */

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(30D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(2D);
    }

    @Override
    public boolean interact(EntityPlayer player)
    {
        ItemStack itemstack = player.inventory.getCurrentItem();
        player.rotationYaw = rotationYaw;
        player.rotationPitch = rotationPitch;
        if(itemstack != null && itemstack.getItem() == FakeOres.fd_passcard_schaza)
        {
            if(player.riddenByEntity == null)
            {
                if(!worldObj.isRemote)
                {
                    player.mountEntity(this);
                }
            }
            blastoff += rand.nextInt(500) + 200;
        }
        else if(riddenByEntity != null)
        {
            return super.interact(player);
        }
        return true;
    }

    @Override
    public void moveEntityWithHeading(float par1, float par2)
    {
        if(this.riddenByEntity != null)
        {
            par1 = ((EntityLivingBase)this.riddenByEntity).moveStrafing * 1.7F;
            par2 = ((EntityLivingBase)this.riddenByEntity).moveForward;
            float groundMovementFactor = ObfuscationReflectionHelper.getPrivateValue(EntityLivingBase.class, this, "landMovementFactor", "field_70746_aG");
            if(!this.worldObj.isRemote)
            {
                this.jumpMovementFactor = 0.5F;
                groundMovementFactor = (float)this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getAttributeValue();
                super.moveEntityWithHeading(par1, par2);
            }
        }
        else
        {
            this.stepHeight = 0.5F;
            this.jumpMovementFactor = 0.02F;
            super.moveEntityWithHeading(par1, par2);
        }
    }

    @Override
    public void updateRiderPosition()
    {
        super.updateRiderPosition();
        if(riddenByEntity instanceof EntityPlayer)
        {
            riddenByEntity.setPosition(posX, posY + this.getMountedYOffset() + this.riddenByEntity.getYOffset() - 0.5D, posZ);
        }
        if(this.riddenByEntity instanceof EntityLivingBase)
        {
            ((EntityLivingBase)this.riddenByEntity).renderYawOffset = this.renderYawOffset;
        }
    }

    @Override
    public int getMaxSpawnedInChunk()
    {
        return 5;
    }
}