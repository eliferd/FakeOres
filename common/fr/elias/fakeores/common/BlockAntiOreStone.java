package fr.elias.fakeores.common;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.FMLClientHandler;

public class BlockAntiOreStone extends Block {

	public BlockAntiOreStone()
	{
		super(Material.rock);
		setCreativeTab(FakeOres.fakeOresTab);
		this.setBlockBounds(0.0015F, 0.0F, 0.0015F, 0.9985F, 1F, 0.9985F);
		this.setTickRandomly(true);
		
	}
    public void onEntityCollidedWithBlock(World par1World, BlockPos pos, Entity par5Entity) 
    {
    	actionHandler(par5Entity);
    }
    
    public void onBlockAdded(World world, BlockPos pos, IBlockState state)
    {
    	int x = pos.getX(),
    		y = pos.getY(),
    		z = pos.getZ();
    	removeNearBlock(world, x + 1, y, z);
    	removeNearBlock(world, x, y + 1, z);
    	removeNearBlock(world, x, y, z + 1);
    	removeNearBlock(world, x - 1, y, z);
    	removeNearBlock(world, x, y - 1, z);
    	removeNearBlock(world, x, y, z - 1);
    }
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
    	int x = pos.getX(),
    		y = pos.getY(),
    		z = pos.getZ();
    	removeNearBlock(worldIn, x + 1, y, z);
    	removeNearBlock(worldIn, x, y + 1, z);
    	removeNearBlock(worldIn, x, y, z + 1);
    	removeNearBlock(worldIn, x - 1, y, z);
    	removeNearBlock(worldIn, x, y - 1, z);
    	removeNearBlock(worldIn, x, y, z - 1);
    	AxisAlignedBB aabb = new AxisAlignedBB((double)x, (double)y, (double)z, (double)(x + 1), (double)(y + 1), (double)(z + 1)).expand(1, 1, 1);
    	List list = worldIn.getEntitiesWithinAABB(EntityOres.class, aabb);
    	if(list.size() > 0)
    	{
    		Entity entity = (Entity)list.get(0);
        	if(entity instanceof EntityOres)
        	{
        		entity.attackEntityFrom(FakeOres.antiorestone, Float.MAX_VALUE);
        	}
    	}
    	super.updateTick(worldIn, pos, state, rand);
    }
    
    public void onBlockDestroyedByPlayer(World par1World, BlockPos pos, IBlockState state) 
    {
    	if(par1World.isRemote)
    	{
    		FMLClientHandler.instance().getClient().theWorld.spawnParticle(EnumParticleTypes.LAVA, pos.getX(), pos.getY(), pos.getZ(), 0.0D, 0.02D, 0.0D);
    	}
    }
    public void removeNearBlock(World world, int x, int y, int z)
    {
    	if(world.getBlockState(new BlockPos(x, y, z)) == FakeOres.fakeDiamond)
    	{
    		world.setBlockToAir(new BlockPos(x, y, z));
    	}else
    	if(world.getBlockState(new BlockPos(x, y, z)) == FakeOres.fakeEmerald)
    	{
    		world.setBlockToAir(new BlockPos(x, y, z));
    	}else
    	if(world.getBlockState(new BlockPos(x, y, z)) == FakeOres.fakeGold)
    	{
    		world.setBlockToAir(new BlockPos(x, y, z));
    	}else
    	if(world.getBlockState(new BlockPos(x, y, z)) == FakeOres.fakeIron)
    	{
    		world.setBlockToAir(new BlockPos(x, y, z));
    	}else
    	if(world.getBlockState(new BlockPos(x, y, z)) == FakeOres.fakeCoal)
    	{
    		world.setBlockToAir(new BlockPos(x, y, z));
    	}else
    	if(world.getBlockState(new BlockPos(x, y, z)) == FakeOres.fakeRedstone)
    	{
    		world.setBlockToAir(new BlockPos(x, y, z));
    	}else
    	if(world.getBlockState(new BlockPos(x, y, z)) == FakeOres.fakeQuartz)
    	{
    		world.setBlockToAir(new BlockPos(x, y, z));
    	}else
    	if(world.getBlockState(new BlockPos(x, y, z)) == FakeOres.fakeLapis)
    	{
    		world.setBlockToAir(new BlockPos(x, y, z));
    	}else{
    		System.out.print("error");
    	}
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
