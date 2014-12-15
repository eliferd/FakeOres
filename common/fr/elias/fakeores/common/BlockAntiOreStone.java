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
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockAntiOreStone extends Block
{

    public BlockAntiOreStone()
    {
        super(Material.rock);
        setCreativeTab(FakeOres.fakeOresTab);
    }
    
    public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state)
    {
        float f = 0.025F;
        return new AxisAlignedBB((double)((float)pos.getX() + f), (double)pos.getY(), (double)((float)pos.getZ() + f), (double)((float)(pos.getX() + 1) - f), (double)((float)(pos.getY() + 1) - f), (double)((float)(pos.getZ() + 1) - f));
    }

    public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity entity)
    {
        System.out.println("ON_ENTITY_COLLIDED_WITh_BLOCK");
        actionHandler(entity);
        System.out.println("ON_ENTITY_COLLIDED_WITh_BLOCK_AFTER");
    }

    public void onBlockAdded(World world, BlockPos pos, IBlockState state)
    {
        System.out.println("ON_BLOCK_ADDED");
        removeNearBlock(world, pos.add(1, 0, 0));
        removeNearBlock(world, pos.add(0, 1, 0));
        removeNearBlock(world, pos.add(0, 0, 1));
        removeNearBlock(world, pos.add(-1, 0, 0));
        removeNearBlock(world, pos.add(0, -1, 0));
        removeNearBlock(world, pos.add(0, 0, -1));
        System.out.println("ON_BLOCK_ADDED_AFTER");
    }
    
    public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock) 
    {
        removeNearBlock(worldIn, new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ()));
        removeNearBlock(worldIn, new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()));
        removeNearBlock(worldIn, new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1));
        removeNearBlock(worldIn, new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ()));
        removeNearBlock(worldIn, new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ()));
        removeNearBlock(worldIn, new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1));
    }


    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        System.out.println("UPDATE_TICK");
        AxisAlignedBB aabb = new AxisAlignedBB(pos, pos.add(1, 1, 1)).expand(1, 1, 1);

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
        System.out.println("UPDATE_TICK_AFTER");
    }

    public void onBlockDestroyedByPlayer(World world, BlockPos pos, IBlockState state)
    {
        if(world.isRemote)
        {
            world.spawnParticle(EnumParticleTypes.LAVA, pos.getX(), pos.getY(), pos.getZ(), 0.0D, 0.02D, 0.0D);
        }
    }

    public void removeNearBlock(World world, BlockPos pos)
    {
        if(world.getBlockState(pos).getBlock() == FakeOres.fakeDiamond)
        {
            world.setBlockToAir(pos);
        }
        if(world.getBlockState(pos).getBlock() == FakeOres.fakeEmerald)
        {
            world.setBlockToAir(pos);
        }
        if(world.getBlockState(pos).getBlock() == FakeOres.fakeGold)
        {
            world.setBlockToAir(pos);
        }
        if(world.getBlockState(pos).getBlock() == FakeOres.fakeIron)
        {
            world.setBlockToAir(pos);
        }
        if(world.getBlockState(pos).getBlock() == FakeOres.fakeCoal)
        {
            world.setBlockToAir(pos);
        }
        if(world.getBlockState(pos).getBlock() == FakeOres.fakeRedstone)
        {
            world.setBlockToAir(pos);
        }
        if(world.getBlockState(pos).getBlock() == FakeOres.fakeQuartz)
        {
            world.setBlockToAir(pos);
        }
        if(world.getBlockState(pos).getBlock() == FakeOres.fakeLapis)
        {
            world.setBlockToAir(pos);
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
