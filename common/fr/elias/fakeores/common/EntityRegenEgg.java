package fr.elias.fakeores.common;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityRegenEgg extends EntityCreature 
{

	public EntityRegenEgg(World par1World) 
	{
		super(par1World);
		setSize(0.5F, 0.5F);
		isImmuneToFire = true;
	}
	public boolean isMovementBlocked()
	{
		return true;
	}
	public boolean isMovementCeased()
	{
		return true;
	}
	public boolean attackEntityFrom(DamageSource damagesource, float f)
	{
		return false;
	}
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10D);
    }
	public void onCollideWithPlayer(EntityPlayer player)
	{
		player.addPotionEffect(new PotionEffect(Potion.heal.id, 200, 1));
		player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 200, 1));
		player.addPotionEffect(new PotionEffect(Potion.jump.id, 200, 1));
		setDead();
		this.spawnExplosionParticle();
	}
	public boolean getCanSpawnHere()
	{
		int i = MathHelper.floor_double(posX);
		int j = MathHelper.floor_double(posY);
		int k = MathHelper.floor_double(posZ);
		return worldObj.getBlock(i, j - 1, k) == FakeOres.fd_grass || worldObj.getBlock(i, j - 1, k) == Blocks.water;
	}
	public int getMaxSpawnedInChunk()
	{
		return 1;
	}
}
