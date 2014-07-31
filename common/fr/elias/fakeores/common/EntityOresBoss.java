package fr.elias.fakeores.common;

import java.util.EnumSet;

import cpw.mods.fml.client.registry.RenderingRegistry;
import fr.elias.fakeores.client.ModelOre;
import fr.elias.fakeores.client.RenderOre;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityOresBoss extends EntityMob implements IBossDisplayData {

	public int phase;
	public EntityOresBoss(World par1World) 
	{
		super(par1World);
		phase = 1;
        this.isImmuneToFire = true;
        this.experienceValue = 4750;
        setSize(3F, 5F);
	}
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(800D);
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(Double.MAX_VALUE);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(2.0D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(18D);
    }
    public void onLivingUpdate()
    {
    	if(phase == 1)
    	{
    		if(this.getHealth() < 500)
    		{
    			phase = 2;
    		}
    	}
    	if(phase == 2)
    	{
    		if(this.getHealth() < 200)
    		{
    			phase = 3;
    		}
    		teleport(1520);
    	}
    	if(phase == 3)
    	{
    		teleport(775);
    	}
    	super.onLivingUpdate();
    }
    
    public void attackEntityWithRangedAttack(EntityLivingBase par1EntityLivingBase, float par2)
    {
        EntitySnowball entitysnowball = new EntitySnowball(this.worldObj, this);
        EntityArrow entityarrow = new EntityArrow(this.worldObj, this, par2);
        double d0 = par1EntityLivingBase.posX - this.posX;
        double d1 = par1EntityLivingBase.posY + (double)par1EntityLivingBase.getEyeHeight() - 1.100000023841858D - entitysnowball.posY;
        double d2 = par1EntityLivingBase.posZ - this.posZ;
        float f1 = MathHelper.sqrt_double(d0 * d0 + d2 * d2) * 0.2F;
        entitysnowball.setThrowableHeading(d0, d1 + (double)f1, d2, 1.6F, 12.0F);
        entityarrow.setThrowableHeading(d0, d1 + (double)f1, d2, 1.6F, 12.0F);
        this.playSound("random.bow", 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
        this.worldObj.spawnEntityInWorld(entityarrow);
        this.worldObj.spawnEntityInWorld(entitysnowball);
    }
    
    public void attackEntity(Entity entity, float f)
    {
    	if(phase == 1)
    	{
            double d0 = entity.posX - this.posX;
            double d1 = entity.boundingBox.minY + (double)(entity.height / 2.0F) - (this.posY + (double)(this.height / 2.0F));
            double d2 = entity.posZ - this.posZ;
            if(rand.nextInt(24) == 0)
            {
                float f1 = MathHelper.sqrt_float(f) * 0.5F;
                this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1009, (int)this.posX, (int)this.posY, (int)this.posZ, 0);

                for (int i = 0; i < 1; ++i)
                {
                    EntityLargeFireball entitysmallfireball = new EntityLargeFireball(this.worldObj, this, d0 + this.rand.nextGaussian() * (double)f1, d1, d2 + this.rand.nextGaussian() * (double)f1);
                    entitysmallfireball.posY = this.posY + (double)(this.height / 2.0F) + 0.5D;
                    this.worldObj.spawnEntityInWorld(entitysmallfireball);
                }
            }
    	}
    	if(phase == 2)
    	{
    		if(rand.nextInt(50) == 0)
    		{
        		attackEntityWithRangedAttack((EntityLivingBase)entity, f);
    		}
    		if(rand.nextInt(220) == 0)
    		{
    			this.spawnSomeSbires("all", posX + rand.nextInt(5), posY + 3, posZ + rand.nextInt(5));
    		}
    	}
    	if(phase == 3)
    	{
    		if(rand.nextInt(80) == 0)
    		{
        		worldObj.addWeatherEffect(new EntityLightningBolt(worldObj, rand.nextInt(2) == 0 ? posX : entity.posX, rand.nextInt(2) == 0 ? posY : entity.posY, rand.nextInt(2) == 0 ? posZ : entity.posZ));
    		}
    		if(rand.nextInt(8) == 0)
    		{
        		attackEntityWithRangedAttack((EntityLivingBase)entity, f);
    		}
    	}
    	super.attackEntity(entity, f);
    }
    public void spawnSomeSbires(String entityToSpawn, double x, double y, double z)
    {
		EntityDiamondOre diamondOre = new EntityDiamondOre(worldObj);
		EntityEmeraldOre emeraldOre = new EntityEmeraldOre(worldObj);
		EntityGoldOre goldOre = new EntityGoldOre(worldObj);
		EntityIronOre ironOre = new EntityIronOre(worldObj);
		EntityCoalOre coalOre = new EntityCoalOre(worldObj);
		EntityRedstoneOre redstoneOre = new EntityRedstoneOre(worldObj);
		EntityNetherQuartzOre quartzOre = new EntityNetherQuartzOre(worldObj);
		EntityLapisLazuliOre lapisOre = new EntityLapisLazuliOre(worldObj);
		
		diamondOre.setPosition(x, y, z);
		emeraldOre.setPosition(x, y, z);
		goldOre.setPosition(x, y, z);
		ironOre.setPosition(x, y, z);
		coalOre.setPosition(x, y, z);
		redstoneOre.setPosition(x, y, z);
		quartzOre.setPosition(x, y, z);
		lapisOre.setPosition(x, y, z);
    	if(entityToSpawn.equals("diamond"))
    	{
    		worldObj.spawnEntityInWorld(diamondOre);
    	}
    	if(entityToSpawn.equals("emerald"))
    	{
    		worldObj.spawnEntityInWorld(emeraldOre);
    	}
    	if(entityToSpawn.equals("gold"))
    	{
    		worldObj.spawnEntityInWorld(goldOre);
    	}
    	if(entityToSpawn.equals("iron"))
    	{
    		worldObj.spawnEntityInWorld(ironOre);
    	}
    	if(entityToSpawn.equals("coal"))
    	{
    		worldObj.spawnEntityInWorld(coalOre);
    	}
    	if(entityToSpawn.equals("redstone"))
    	{
    		worldObj.spawnEntityInWorld(redstoneOre);
    	}
    	if(entityToSpawn.equals("quartz"))
    	{
    		worldObj.spawnEntityInWorld(quartzOre);
    	}
    	if(entityToSpawn.equals("lapis"))
    	{
    		worldObj.spawnEntityInWorld(lapisOre);
    	}
    	if(entityToSpawn.equals("all"))
    	{
    		worldObj.spawnEntityInWorld(diamondOre);
    		worldObj.spawnEntityInWorld(emeraldOre);
    		worldObj.spawnEntityInWorld(goldOre);
    		worldObj.spawnEntityInWorld(ironOre);
    		worldObj.spawnEntityInWorld(coalOre);
    		worldObj.spawnEntityInWorld(redstoneOre);
    		worldObj.spawnEntityInWorld(quartzOre);
    		worldObj.spawnEntityInWorld(lapisOre);
    	}
    }
    public Entity findPlayerToAttack()
    {
        EntityPlayer entityplayer = this.worldObj.getClosestVulnerablePlayerToEntity(this, 32.0D);
        if(entityplayer != null && this.canEntityBeSeen(entityplayer))
        {
        	return entityplayer;
        }else {
        	return null;
        }
    }
    public void teleport(int cooldownBeforeTeleport)
    {
		if(rand.nextInt(cooldownBeforeTeleport) == 0)
		{
			worldObj.spawnEntityInWorld(new EntityBossTeleporter(worldObj, this));
		}
    }
    public void onDeath(DamageSource sourceOfDamage)
    {
    	worldObj.createExplosion(this, posX, posY + 2, posZ, 0.0F, false);
    	this.dropItem(FakeOres.oreBoss_Star, rand.nextInt(2) == 0 ? 2 : 1);
    }
    public int getPhase()
    {
    	return phase;
    }
    public boolean attackEntityFrom(DamageSource damagesource, float f)
    {
    	Entity entity = damagesource.getEntity();
    	if(entity != null && entity instanceof EntityPlayer)
    	{    	
    		/*ItemStack itemstack = ((EntityPlayer)entity).getCurrentEquippedItem();
    		if(itemstack != null)
    		{
    			if(itemstack.getItem() == Items.magma_cream)
    			{
    				f = 150f;
    			}
    		}*/
    		
        	if(entity instanceof EntityLightningBolt)
        	{
        		f = 0f;
        	}
        	
        	if(entity instanceof EntityLargeFireball)
        	{
        		f = 75f;
        	}
        	if(this.phase == 2)
        	{
        		f = 50f;
        	}
    	}
    	return super.attackEntityFrom(damagesource, f);
    }
}
