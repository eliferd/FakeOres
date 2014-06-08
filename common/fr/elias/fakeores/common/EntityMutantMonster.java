package fr.elias.fakeores.common;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;

public class EntityMutantMonster extends EntityDimensionMob 
{
	public EntityMutantMonster(World par1World) 
	{
		super(par1World);
		isHostile = true;
		setSize(1.5F, 2.5F);
	}
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(60D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(10D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(7.0D);
    }
}
