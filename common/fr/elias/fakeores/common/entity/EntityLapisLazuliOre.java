package fr.elias.fakeores.common.entity;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;

public class EntityLapisLazuliOre extends EntityOres
{

    public EntityLapisLazuliOre(World world)
    {
        super(world);
        type = 8;
        setSize(1F, 1F);

    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(15D);
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(40D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(4.0D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(18.0D);
    }

}
