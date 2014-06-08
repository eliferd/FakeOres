package fr.elias.fakeores.common;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityBlackMage extends EntityDimensionMob 
{
	public EntityBlackMage(World par1World) 
	{
		super(par1World);
		isHostile = true;
	}
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(4.0D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(2D);
    }
    protected void attackEntity(Entity entity, float f)
    {
    	super.attackEntity(entity, f);
    	if(attackTime == 0)
    	{
            double d5 = entity.posX - this.posX;
            double d6 = entity.boundingBox.minY + (double)(entity.height / 2.0F) - (this.posY + (double)(this.height / 2.0F));
            double d7 = entity.posZ - this.posZ;
    		EntityMageSpell spell = new EntityMageSpell(worldObj);
    		spell.setLocationAndAngles(posX, posY + height, posZ, rotationYaw, 0.0F);
    		spell.motionX = rand.nextFloat() * 2.0F - 1.0F;
    		spell.motionZ = rand.nextFloat() * 2.0F - 1.0F;
    		spell.moveEntity(d5, d6, d7);
    		worldObj.spawnEntityInWorld(spell);
    		
    		EntityLargeFireball largefireball = new EntityLargeFireball(worldObj, this, d5, d6, d7);
            double d8 = 4.0D;
            Vec3 vec3 = this.getLook(1.0F);
            largefireball.posX = this.posX + vec3.xCoord * d8;
            largefireball.posY = this.posY + (double)(this.height / 2.0F) + 0.5D;
            largefireball.posZ = this.posZ + vec3.zCoord * d8;
            if(rand.nextInt(50) == 0)
            {
                this.worldObj.spawnEntityInWorld(largefireball);
            }
    		attackTime = 80;
    	}
        
    }
    
    protected String getDeathSound()
    {
        return "mob.blaze.death";
    }
}
