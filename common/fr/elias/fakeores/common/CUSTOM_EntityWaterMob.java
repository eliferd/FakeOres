package fr.elias.fakeores.common;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class CUSTOM_EntityWaterMob extends EntityCreature implements IAnimals
{
	public CUSTOM_EntityWaterMob(World par1World) 
	{
		super(par1World);
	}

	public boolean canBreatheUnderwater() {
		return true;
	}

	/**
	 * Checks if the entity's current position is a valid location to spawn this
	 * entity.
	 */
	public boolean getCanSpawnHere() {
		return this.worldObj.checkNoEntityCollision(this.boundingBox);
	}

	/**
	 * Get number of ticks, at least during which the living entity will be
	 * silent.
	 */
	public int getTalkInterval() {
		return 120;
	}

	/**
	 * Determines if an entity can be despawned, used on idle far away entities
	 */
	protected boolean canDespawn() {
		return true;
	}

	/**
	 * Get the experience points the entity currently has.
	 */
	protected int getExperiencePoints(EntityPlayer par1EntityPlayer) {
		return 1 + this.worldObj.rand.nextInt(6);
	}

	/**
	 * Gets called every tick from main Entity class
	 */
	public void onEntityUpdate()
	{
		int i = this.getAir();
		super.onEntityUpdate();
		if (!this.isInWater() && this.isEntityAlive()) {
			--i;
			this.setAir(i);
			if (this.getAir() == -20)
			{
				this.setAir(0);
			}
		} else {
			this.setAir(Integer.MAX_VALUE);
		}
	}
}