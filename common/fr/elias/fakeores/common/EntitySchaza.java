package fr.elias.fakeores.common;

import cpw.mods.fml.common.ObfuscationReflectionHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntitySchaza extends EntityDimensionMob 
{
	public double floatcycle;
	public int floatdir;
	public double floatmaxcycle;
	public int blastoff;
	public int blastofftimer;
	
	public EntitySchaza(World par1World) 
	{
		super(par1World);
		isHostile = false;
		setSize(1.5F, 1.5F);
        floatdir = 1;
        floatcycle = 0.0D;
        floatmaxcycle = 0.10499999672174454D;
        blastoff = rand.nextInt(500) + 400;
	}
	public void onUpdate()
	{
        if (isEntityInsideOpaqueBlock())
        {
            posY += 2.5D;
            floatdir = 1;
            floatcycle = 0.0D;
        }

        fallDistance = -100F;
        
        if (riddenByEntity == null && blastoff-- < 0)
        {
            double d = -MathHelper.sin((rotationYaw * (float)Math.PI) / 180F);
            double d1 = MathHelper.cos((rotationYaw * (float)Math.PI) / 180F);
            motionX += d * 0.1D;
            motionZ += d1 * 0.1D;

            if(rand.nextInt(50) == 0)
            {
                this.spawnExplosionParticle();
            }

            if (posY > 100D)
            {
                setDead();
            }
        }

        ignoreFrustumCheck = true;

        if (floatdir > 0)
        {
            floatcycle += 0.017999999225139618D;

            if (floatcycle > floatmaxcycle)
            {
                floatdir = floatdir * -1;
                fallDistance += -1.5F;
            }
        }
        else
        {
            floatcycle -= 0.0094999996945261955D;

            if (floatcycle < -floatmaxcycle)
            {
                floatdir = floatdir * -1;
                fallDistance += -1.5F;
            }
        }
        if (riddenByEntity != null && (riddenByEntity instanceof EntityPlayer))
        {
            blastoff++;

            if (blastoff > 50000)
            {
                blastoff = 50000;
            }
        }

        super.onUpdate();
	}
	public void updateEntityActionState()
	{
        if (riddenByEntity != null && (riddenByEntity instanceof EntityPlayer))
        {
            moveForward = 0.0F;
            moveStrafing = 0.0F;
            riddenByEntity.lastTickPosY = 0.0D;
            prevRotationYaw = rotationYaw = riddenByEntity.rotationYaw;
            prevRotationPitch = rotationPitch = 0.0F;
            stepHeight = 920F;
            EntityPlayer entityplayer = (EntityPlayer)riddenByEntity;
            float f = 1.0F;

            moveStrafing = (entityplayer.moveStrafing / f) * 2.75F;
            moveForward = (entityplayer.moveForward / f) * 2.75F;
            if (moveStrafing == 0.0F && moveForward == 0.0F)
            {
                isJumping = false;
            }

            if (onGround && !isJumping)
            {
            	boolean playerJumping = ObfuscationReflectionHelper.getPrivateValue(EntityLivingBase.class, entityplayer, "isJumping", "field_70703_bu");
                isJumping = playerJumping;

                if (isJumping)
                {
                    motionY += 2.5D;
                }else{
                	motionY = 0;
                }
            }
            return;
        }
        else
        {
        	
            super.updateEntityActionState();
            return;
        }
	}
	
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(30D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(10D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(5.0D);
    }
    public boolean interact(EntityPlayer player)
    {
    	ItemStack itemstack = player.inventory.getCurrentItem();
    	player.rotationYaw = rotationYaw;
    	player.rotationPitch = rotationPitch;
    	if(itemstack != null && itemstack.getItem() == FakeOres.fd_passcard_schaza)
        {
    		if (player.riddenByEntity == null)
    		{
                    if(!worldObj.isRemote)
                    {
                    	player.mountEntity(this);
                    }
            }
            blastoff += rand.nextInt(500) + 200;
        }else if(riddenByEntity != null)
        {
        	return super.interact(player);
        }
    	return true;
    }
    public void moveEntityWithHeading(float par1, float par2)
    {
        if (this.riddenByEntity != null)
        {
            par1 = ((EntityLivingBase)this.riddenByEntity).moveStrafing * 0.7F;
            par2 = ((EntityLivingBase)this.riddenByEntity).moveForward;
            this.jumpMovementFactor = this.getAIMoveSpeed() * 0.1F;
            if (!this.worldObj.isRemote)
            {
                this.setAIMoveSpeed((float)this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getAttributeValue());
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
    public void updateRiderPosition()
    {
        if (riddenByEntity instanceof EntityPlayer)
        {
        	riddenByEntity.setPosition(posX, posY + 1.8D - floatcycle, posZ);
        }
    }
    public int getMaxSpawnedInChunk()
    {
        return 5;
    }
}
