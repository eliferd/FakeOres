package fr.elias.fakeores.common;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityNopeGrenade extends EntityItem
{
    protected double bounceFactor;
    protected double bounceSlowFactor;
    protected int fuse;
    protected boolean exploded;
    protected double initialVelocity;
    protected static final int FUSE_LENGTH = 50;
    protected static final double MIN_BOUNCE_SOUND_VELOCITY = 0.1D;
    private static final int MAX_DIAMETER_TIME = 250;
    private static final double MAX_DIAMETER = 8D;
    
    public int smokedTime;
    
	public ItemStack item;
	
    public EntityNopeGrenade(World world)
    {
        super(world);
        bounceFactor = 0.15D;
        bounceSlowFactor = 0.8D;
        initialVelocity = 1.0D;
        setSize(0.1F, 0.1F);
        exploded = false;
        fuse = 80;
        yOffset = 0.0F;
        smokedTime = 500;
        item = new ItemStack(FakeOres.nopeGrenade);
    }
    
    @Override
    public ItemStack getEntityItem()
    {
    	return item;
    }
    
    public EntityNopeGrenade(World world, double d, double d1, double d2)
    {
        this(world);
        setPosition(d, d1, d2);
    }
    
    public EntityNopeGrenade(World world, EntityLivingBase entityliving)
    {
        this(world);
        setAngles(entityliving.rotationYaw, 0.0F);
        double d = -MathHelper.sin((entityliving.rotationYaw * (float)Math.PI) / 180F);
        double d1 = MathHelper.cos((entityliving.rotationYaw * (float)Math.PI) / 180F);
        motionX = initialVelocity * d * (double)MathHelper.cos((entityliving.rotationPitch / 180F) * (float)Math.PI);
        motionY = -initialVelocity * (double)MathHelper.sin((entityliving.rotationPitch / 180F) * (float)Math.PI);
        motionZ = initialVelocity * d1 * (double)MathHelper.cos((entityliving.rotationPitch / 180F) * (float)Math.PI);

        if (entityliving.ridingEntity != null && (entityliving.ridingEntity instanceof EntityLiving))
        {
            entityliving = (EntityLiving)entityliving.ridingEntity;
        }

        motionX += entityliving.motionX;
        motionY += entityliving.onGround ? 0.0D : entityliving.motionY;
        motionZ += entityliving.motionZ;
        setPosition(entityliving.posX + d * 0.8D, entityliving.posY + (double)entityliving.getEyeHeight(), entityliving.posZ + d1 * 0.8D);
        prevPosX = posX;
        prevPosY = posY;
        prevPosZ = posZ;
    }
    
    public boolean isInRangeToRenderDist(double d)
    {
        return true;
    }
    
    public void onUpdate()
    {
        double d = motionX;
        double d1 = motionY;
        double d2 = motionZ;
        prevPosX = posX;
        prevPosY = posY;
        prevPosZ = posZ;
        moveEntity(motionX, motionY, motionZ);
        boolean flag = false;
        List list = worldObj.getEntitiesWithinAABB(EntityCreature.class, AxisAlignedBB.getBoundingBox(posX, posY, posZ, posX + 1, posY + 1, posZ + 1).expand(1D, 1D, 1D));
        for(int i = 0; i< list.size(); i++)
        {
        	Entity entity = (Entity)list.get(i);
        	if(!list.isEmpty()) 
        	{
        		if(!(entity instanceof EntityPlayer) && !(entity instanceof EntityDangerousPlant) && !(entity instanceof EntityRegenEgg))
        		{
        			entity.mountEntity(this);
        			entity.setPosition(posX, posY, posZ);
        			entity.rotationYaw = getRandom(0, 360);
        			entity.rotationPitch = getRandom(0, 180);
        		}
        	}
        	worldObj.spawnParticle("largesmoke", posX + rand.nextInt(2), posY + rand.nextInt(2), posZ + rand.nextInt(2), 0.0D, 0.0D, 0.0D);
        }
        if (motionX == 0.0D && d != 0.0D)
        {
            motionX = -bounceFactor * d;
            motionY = bounceSlowFactor * d1;
            motionZ = bounceSlowFactor * d2;

            if (Math.abs(d) > 0.1D)
            {
                flag = true;
            }
        }

        if (motionY == 0.0D && d1 != 0.0D)
        {
            motionX = bounceSlowFactor * d;
            motionY = -bounceFactor * d1;
            motionZ = bounceSlowFactor * d2;

            if (Math.abs(d1) > 0.1D)
            {
                flag = true;
            }
        }

        if (motionZ == 0.0D && d2 != 0.0D)
        {
            motionX = bounceSlowFactor * d;
            motionY = bounceSlowFactor * d1;
            motionZ = -bounceFactor * d2;

            if (Math.abs(d2) > 0.1D)
            {
                flag = true;
            }
        }

        if (flag)
        {
            handleBounce();
        }

        motionY -= 0.04D;
        motionX *= 0.99D;
        motionY *= 0.99D;
        motionZ *= 0.99D;
        if(smokedTime > 0)
        {
	        smokedTime--;
        }
        part(worldObj, this);
        handleExplode();
    }
    
	public int getRandom(final int min, final int max)
	{
		return min + (int) (Math.random() * ((max - min) + 1));
	}
    
	protected void handleBounce()
    {
        worldObj.playSoundAtEntity(this, "mob.villager.hit", 0.25F, 1.0F / (rand.nextFloat() * 0.1F + 0.95F));
    }

    protected void handleExplode()
    {
        if (fuse-- <= 0)
        {
            explode();
        }
    }
    
    protected void part(World worldObj, EntityNopeGrenade entity)
    {
        for (int i = 0; i < 20; i++)
        {
            double d = rand.nextGaussian() * 0.02D;
            double d1 = rand.nextGaussian() * 0.02D;
            double d2 = rand.nextGaussian() * 0.02D;
            double d3 = 10D;
            if(smokedTime > 0)
            {
            	if(worldObj.isRemote && rand.nextInt(10) == 0)
            	{
                	FakeOres.proxy.spawnParticle(worldObj, "nope", (entity.posX + (double)(rand.nextFloat() * entity.width * 2.0F)) - (double) entity.width - d * d3, (entity.posY + (double)(rand.nextFloat() * entity.height)) - d1 * d3, (entity.posZ + (double)(rand.nextFloat() * entity.width * 2.0F)) - (double) entity.width - d2 * d3);
            	}
            }
            
        }
    }
    
    protected void explode()
    {
        if (!exploded)
        {
            exploded = true;
            if(!worldObj.isRemote)
            {
                worldObj.createExplosion(null, posX, posY, posZ, 3.85F, true);
            }
            setDead();
        }
    }
    
    protected boolean canTriggerWalking()
    {
        return false;
    }
    public boolean canBeCollidedWith()
    {
        return true;
    }
    public void writeEntityToNBT(NBTTagCompound nbttagcompound)
    {
        super.writeEntityToNBT(nbttagcompound);
        nbttagcompound.setByte("Fuse", (byte)fuse);
    }

    public void readEntityFromNBT(NBTTagCompound nbttagcompound)
    {
        super.readEntityFromNBT(nbttagcompound);
        fuse = nbttagcompound.getByte("Fuse");
    }
    
    public void onCollideWithPlayer(EntityPlayer entityplayer)
    {
    	entityplayer.motionY+= 0.1D;
    }

    public float getEyeHeight()
    {
        return height;
    }
}
