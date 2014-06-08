package fr.elias.fakeores.common;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;

public class EntityCopperOre extends EntityOres {

	public EntityCopperOre(World world) {
		super(world);
		type = 9;
		setSize(1F, 1F);
	}
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20D);
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(40D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(2.0D);
    }
}
