package fr.elias.fakeores.common.block;

import fr.elias.fakeores.common.FakeOres;
import fr.elias.fakeores.common.entity.EntityOres;

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

public class BlockAntiOreStone extends Block
{
    public BlockAntiOreStone()
    {
        super(Material.rock);
        setCreativeTab(FakeOres.fakeOresTab);
        this.setBlockBounds(0.0015F, 0.0F, 0.0015F, 0.9985F, 1F, 0.9985F);
        this.setTickRandomly(true);
    }

    @Override
    public void onEntityCollidedWithBlock(World par1World, BlockPos pos, Entity par5Entity)
    {
        actionHandler(par5Entity);
    }

    @Override
    public void onBlockAdded(World world, BlockPos pos, IBlockState state)
    {
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        removeNearBlock(world, x + 1, y, z);
        removeNearBlock(world, x, y + 1, z);
        removeNearBlock(world, x, y, z + 1);
        removeNearBlock(world, x - 1, y, z);
        removeNearBlock(world, x, y - 1, z);
        removeNearBlock(world, x, y, z - 1);
    }

    @Override
    public void updateTick(World world, BlockPos pos, IBlockState state, Random rand)
    {
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        removeNearBlock(world, x + 1, y, z);
        removeNearBlock(world, x, y + 1, z);
        removeNearBlock(world, x, y, z + 1);
        removeNearBlock(world, x - 1, y, z);
        removeNearBlock(world, x, y - 1, z);
        removeNearBlock(world, x, y, z - 1);
        AxisAlignedBB aabb = AxisAlignedBB.fromBounds(x, y, z, x + 1, y + 1, z + 1).expand(1, 1, 1);
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

    @Override
    public void onBlockDestroyedByPlayer(World par1World, BlockPos pos, IBlockState state)
    {
        if(par1World.isRemote)
        {
            int x = pos.getX();
            int y = pos.getY();
            int z = pos.getZ();
            FMLClientHandler.instance().getClient().theWorld.spawnParticle(EnumParticleTypes.LAVA, x, y, z, 0.0D, 0.02D, 0.0D);
        }
    }

    public void removeNearBlock(World world, int x, int y, int z)
    {
        if(world.getBlockState(new BlockPos(x, y, z)).getBlock() == FakeOres.fakeOreVanilla)
        {
            world.setBlockToAir(new BlockPos(x, y, z));
        }
    }

    /*
     * @Override public void onEntityWalking(World par1World, int par2, int par3, int par4, Entity par5Entity) { actionHandler(par5Entity); }
     */

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

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }
}
