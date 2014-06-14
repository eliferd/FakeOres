package fr.elias.fakeores.common;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityPlayerHunter extends EntityDimensionMob
{

	public EntityPlayerHunter(World par1World)
	{
		super(par1World);
		this.isHostile = worldObj.difficultySetting == EnumDifficulty.PEACEFUL ? false : true;
		setSize(0.5F, 1.3F);
	}
	
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(4.9D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(7.0D);
    }
    
    protected void attackEntity(Entity target, float burnInToTheGround)
    {
        if (this.attackTime <= 0 && burnInToTheGround < 2.0F && target.boundingBox.maxY > this.boundingBox.minY && target.boundingBox.minY < this.boundingBox.maxY)
        {
            this.attackTime = 20;
            this.attackEntityAsMob(target);
        }
        if (onGround)
        {
            double d = target.posX - posX;
            double d2 = target.posZ - posZ;
            float f1 = MathHelper.sqrt_double(d * d + d2 * d2);
            motionX = (d / (double)f1) * 0.40000000000000002D * 0.50000000192092897D + motionX * 0.18000000098023225D;
            motionZ = (d2 / (double)f1) * 0.40000000000000002D * 0.37000000192092897D + motionZ * 0.18000000098023225D;
            motionY = 0.15000000019604645D;
        }

        if ((double)burnInToTheGround < 6D)
        {
            double d1 = target.posX - posX;
            double d3 = target.posZ - posZ;
            float f2 = MathHelper.sqrt_double(d1 * d1 + d3 * d3);
            motionX = (d1 / (double)f2) * 0.40000000000000002D * 0.40000000192092894D + motionX * 0.18000000098023225D;
            motionZ = (d3 / (double)f2) * 0.40000000000000002D * 0.27000000192092893D + motionZ * 0.18000000098023225D;
            rotationPitch = 90F;
        }
    }
    public boolean attackEntityFrom(DamageSource damagesource, float f)
    {
        Entity entity = damagesource.getEntity();

        if (entity != null)
        {
            double d = -MathHelper.sin((entity.rotationYaw * (float)Math.PI) / 180F);
            double d1 = MathHelper.cos((entity.rotationYaw * (float)Math.PI) / 180F);
            motionX = d * 4D;
            motionZ = d1 * 4D;
        }
        return super.attackEntityFrom(DamageSource.causeMobDamage(this), f);
    }
}
