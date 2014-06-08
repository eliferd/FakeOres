package fr.elias.fakeores.common;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;

public class EntityOres extends EntityMob {
	public int type;
	public EntityOres(World world, int oreType)
	{
		this(world);
		this.type = oreType;
	}
	public EntityOres(World world)
	{
		super(world);
		experienceValue = 50;
	}
	protected Entity findPlayerToAttack()
	{
		EntityPlayer entityplayer = this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0D);
        return entityplayer != null && this.canEntityBeSeen(entityplayer) ? entityplayer : null;
	}
    protected String getHurtSound()
    {
        return "dig.stone";
    }
    protected String getDeathSound()
    {
        return "dig.stone";
    }
	public boolean attackEntityFrom(DamageSource damagesource, float f)
	{
		Entity entity = damagesource.getEntity();
		if(entity != null)
		{
			if(entity instanceof EntityPlayer)
			{
				ItemStack stack = ((EntityPlayer) entity).inventory.getCurrentItem();
				if(stack != null)
				{
					if(stack.getItem() == FakeOres.antiOresBlade)
					{
						f = Float.MAX_VALUE;
					}
				}
			}
		}
		if(damagesource.isFireDamage())
		{
			return false;
		}
		if(damagesource.isExplosion())
		{
			f = Float.MAX_VALUE;
			return true;
		}
		return super.attackEntityFrom(damagesource, f);
	}
	public void onLivingUpdate()
	{
		int x = (int) posX, y = (int) posY, z = (int) posZ;
		deadByAntiOreStone(worldObj, x + 1, y, z);
		deadByAntiOreStone(worldObj, x, y + 1, z);
		deadByAntiOreStone(worldObj, x, y, z + 1);
		deadByAntiOreStone(worldObj, x - 1, y, z);
		deadByAntiOreStone(worldObj, x, y - 1, z);
		deadByAntiOreStone(worldObj, x, y, z - 1);
		super.onLivingUpdate();
	}
    public void deadByAntiOreStone(World world, int x, int y, int z)
    {
    	if(world.getBlock(x, y, z) == FakeOres.antiOreStone)
    	{
    		this.attackEntityFrom(FakeOres.antiorestone, Float.MAX_VALUE);
    	}
    }
    protected void dropFewItems(boolean par1, int par2)
    {
    	if(rand.nextInt(10) == 0)
    	{
    		this.dropItem(FakeOres.fragment_part1, 1);
    	}
    	if(rand.nextInt(8) == 0)
    	{
    		this.dropItem(FakeOres.fragment_part2, 1);
    	}
    	if(rand.nextInt(14) == 0)
    	{
    		this.dropItem(FakeOres.fragment_part3, 1);
    	}
    	if(rand.nextInt(59) == 0)
    	{
    		this.dropItem(FakeOres.fragment_part4, 1);
    	}
    	if(type == 1)
    	{
    		this.dropItem(Items.diamond, 2);
    	}else if(type == 2)
    	{
    		this.dropItem(Items.emerald, 2);
    	}else if(type == 3)
    	{
    		this.dropItem(Item.getItemFromBlock(Blocks.gold_ore), 1);
    	}else if(type == 4)
    	{
    		this.dropItem(Item.getItemFromBlock(Blocks.iron_ore), 1);
    	}else if(type == 5)
    	{
    		this.dropItem(Items.coal, 2);
    	}else if(type == 6)
    	{
    		this.dropItem(Items.redstone, 4);
    	}else if(type == 7)
    	{
    		this.dropItem(Items.quartz, 3);
    	}else
    	if(type == 8)
    	{
            this.entityDropItem(new ItemStack(Items.dye, rand.nextInt(4) + 2, 4), 0.0F);
    	}
    	if(Loader.isModLoaded("IC2"))
    	{
    		if(type == 9)
    		{
    			this.dropItem(GameRegistry.findItem("IC2", "copperOre"), 1);
    		}
    		if(type == 10)
    		{
    			this.dropItem(GameRegistry.findItem("IC2", "tinOre"), 1);
    		}
    		if(type == 11)
    		{
    			this.dropItem(GameRegistry.findItem("IC2", "uraniumOre"), 1);
    		}
    	}
    }
	public int getOreType()
	{
		return type;
	}
}
