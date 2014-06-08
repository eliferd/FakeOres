package fr.elias.fakeores.common;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;

public class EntityDiamondOre extends EntityOres {

	public EntityDiamondOre(World world) {
		super(world);
		type = 1;
		setSize(1F, 1F);
	}
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(40D);
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(40D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(4.0D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(8D);
    }
}
