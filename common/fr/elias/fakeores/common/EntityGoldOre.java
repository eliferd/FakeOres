package fr.elias.fakeores.common;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;

public class EntityGoldOre extends EntityOres {

	public EntityGoldOre(World world) {
		super(world);
		type = 3;
		setSize(1F, 1F);

	}
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(25D);
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(40D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(4.9D);
    }
}
