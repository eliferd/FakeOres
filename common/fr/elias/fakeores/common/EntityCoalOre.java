package fr.elias.fakeores.common;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;

public class EntityCoalOre extends EntityOres {

	public EntityCoalOre(World world) {
		super(world);
		type = 5;
		setSize(1F, 1F);
	}
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10D);
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(40D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(2.0D);
    }
}
