package fr.elias.fakeores.common;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;

public class EntityEmeraldOre extends EntityOres {

	public EntityEmeraldOre(World world) {
		super(world);
		type = 2;
		setSize(1F, 1F);

	}
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(45D);
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(40D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(4.0D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(15D);
    }
}
