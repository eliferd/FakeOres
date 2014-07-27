package fr.elias.fakeores.common;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityMazeCreature extends EntityMob 
{
	public String texture;
	public final String[] texturesIndex = {"0.png", "1.png", "2.png", "3.png"};
	public EntityMazeCreature(World world) 
	{
		super(world);
		texture = "mazeCreature" + rand.nextInt(texturesIndex.length) + ".png";
		setSize(0.6F, 0.8F);
	}
	public void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(25D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(6D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(4D);
	}
	public void readEntityFromNBT(NBTTagCompound tag)
	{
		super.readEntityFromNBT(tag);
		texture = tag.getString("Texture");
	}
	public void writeEntityToNBT(NBTTagCompound tag)
	{
		super.writeEntityToNBT(tag);
		tag.setString("Texture", texture);
	}
	public void onDeath(DamageSource damagesource)
	{
		super.onDeath(damagesource);
		if(!worldObj.isRemote)
		{
			dropItem(FakeOres.mazeCreature_leather, rand.nextInt(2) + 3);
		}
	}
}
