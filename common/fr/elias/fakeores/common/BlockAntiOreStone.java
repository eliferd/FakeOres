package fr.elias.fakeores.common;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.client.FMLClientHandler;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class BlockAntiOreStone extends Block {

	public BlockAntiOreStone()
	{
		super(Material.rock);
		setCreativeTab(FakeOres.fakeOresTab);
		this.setBlockBounds(0.0015F, 0.0F, 0.0015F, 0.9985F, 1F, 0.9985F);
		this.setTickRandomly(true);
	}
    public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity) 
    {    	
    	actionHandler(par5Entity);
    }
    
    public void onBlockAdded(World world, int x, int y, int z)
    {
    	removeNearBlock(world, x + 1, y, z);
    	removeNearBlock(world, x, y + 1, z);
    	removeNearBlock(world, x, y, z + 1);
    	removeNearBlock(world, x - 1, y, z);
    	removeNearBlock(world, x, y - 1, z);
    	removeNearBlock(world, x, y, z - 1);
    }
    public void updateTick(World world, int x, int y, int z, Random rand)
    {
    	removeNearBlock(world, x + 1, y, z);
    	removeNearBlock(world, x, y + 1, z);
    	removeNearBlock(world, x, y, z + 1);
    	removeNearBlock(world, x - 1, y, z);
    	removeNearBlock(world, x, y - 1, z);
    	removeNearBlock(world, x, y, z - 1);
    	AxisAlignedBB aabb = AxisAlignedBB.getAABBPool().getAABB((double)x, (double)y, (double)z, (double)(x + 1), (double)(y + 1), (double)(z + 1)).expand(1, 1, 1);
    	List list = world.getEntitiesWithinAABB(EntityOres.class, aabb);
    	if(list.size() > 0)
    	{
    		Entity entity = (Entity)list.get(0);
        	if(entity instanceof EntityOres)
        	{
        		entity.attackEntityFrom(FakeOres.antiorestone, Float.MAX_VALUE);
        	}
    	}
    }
    
    public void onBlockDestroyedByPlayer(World par1World, int x, int y, int z, int metaData) 
    {
    	if(par1World.isRemote)
    	{
    		FMLClientHandler.instance().getClient().theWorld.spawnParticle("lava", x, y, z, 0.0D, 0.02D, 0.0D);
    	}
    }
    public void removeNearBlock(World world, int x, int y, int z)
    {
    	if(world.getBlock(x, y, z) == FakeOres.fakeOreVanilla)
    	{
    		world.setBlockToAir(x, y, z);
    	}
    }
    
    public void onEntityWalking(World par1World, int par2, int par3, int par4, Entity par5Entity) 
    {
    	actionHandler(par5Entity);
    }
    public void actionHandler(Entity entity)
    {
    	if(!(entity instanceof EntityItem))
    	{
    		entity.attackEntityFrom(FakeOres.antiorestone, 18F);
    	}
    	if(entity instanceof EntityOres)
    	{
    		entity.attackEntityFrom(FakeOres.antiorestone, Float.MAX_VALUE);
    	}
    }
    public boolean isOpaqueCube()
    {
    	return false;
    }
}
