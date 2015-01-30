package fr.elias.fakeores.common.item;

import fr.elias.fakeores.common.FakeOres;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

public class ItemBossStar extends Item
{
    public ItemBossStar()
    {
        super();
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();

        if(!world.isRemote && world.getBlockState(new BlockPos(x, y, z)).getBlock().equals(FakeOres.fd_redobsidian))
        {
            if(world.getBlockState(new BlockPos(x, y, z)).getBlock().equals(FakeOres.fd_redobsidian) && world.getBlockState(new BlockPos(x - 1, y, z)).getBlock().equals(FakeOres.fd_redobsidian) && world.getBlockState(new BlockPos(x - 2, y + 1, z)).getBlock().equals(FakeOres.fd_redobsidian) && world.getBlockState(new BlockPos(x - 2, y + 2, z)).getBlock().equals(FakeOres.fd_redobsidian) && world.getBlockState(new BlockPos(x - 2, y + 3, z)).getBlock().equals(FakeOres.fd_redobsidian) && world.getBlockState(new BlockPos(x + 1, y + 1, z)).getBlock().equals(FakeOres.fd_redobsidian) && world.getBlockState(new BlockPos(x + 1, y + 2, z)).getBlock().equals(FakeOres.fd_redobsidian) && world.getBlockState(new BlockPos(x + 1, y + 3, z)).getBlock().equals(FakeOres.fd_redobsidian) && world.getBlockState(new BlockPos(x - 1, y + 4, z)).getBlock().equals(FakeOres.fd_redobsidian) && world.getBlockState(new BlockPos(x, y + 4, z)).getBlock().equals(FakeOres.fd_redobsidian))
            {
                for(int i = 0; i < 3; i++)
                {
                    world.setBlockState(new BlockPos(x, y + 1 + i, z), FakeOres.fd_portal.getDefaultState());
                    world.setBlockState(new BlockPos(x - 1, y + 1 + i, z), FakeOres.fd_portal.getDefaultState());
                }
                if(!player.capabilities.isCreativeMode)
                {
                    stack.stackSize--;
                }
                return true;
            }

            if(world.getBlockState(new BlockPos(x, y, z)).getBlock().equals(FakeOres.fd_redobsidian) && world.getBlockState(new BlockPos(x + 1, y, z)).getBlock().equals(FakeOres.fd_redobsidian) && world.getBlockState(new BlockPos(x + 2, y + 1, z)).getBlock().equals(FakeOres.fd_redobsidian) && world.getBlockState(new BlockPos(x + 2, y + 2, z)).getBlock().equals(FakeOres.fd_redobsidian) && world.getBlockState(new BlockPos(x + 2, y + 3, z)).getBlock().equals(FakeOres.fd_redobsidian) && world.getBlockState(new BlockPos(x - 1, y + 1, z)).getBlock().equals(FakeOres.fd_redobsidian) && world.getBlockState(new BlockPos(x - 1, y + 2, z)).getBlock().equals(FakeOres.fd_redobsidian) && world.getBlockState(new BlockPos(x - 1, y + 3, z)).getBlock().equals(FakeOres.fd_redobsidian) && world.getBlockState(new BlockPos(x + 1, y + 4, z)).getBlock().equals(FakeOres.fd_redobsidian) && world.getBlockState(new BlockPos(x, y + 4, z)).getBlock().equals(FakeOres.fd_redobsidian))
            {
                for(int i = 0; i < 3; i++)
                {
                    world.setBlockState(new BlockPos(x, y + 1 + i, z), FakeOres.fd_portal.getDefaultState());
                    world.setBlockState(new BlockPos(x + 1, y + 1 + i, z), FakeOres.fd_portal.getDefaultState());
                }
                if(!player.capabilities.isCreativeMode)
                {
                    stack.stackSize--;
                }
                return true;
            }

            if(world.getBlockState(new BlockPos(x, y, z)).getBlock().equals(FakeOres.fd_redobsidian) && world.getBlockState(new BlockPos(x, y, z - 1)).getBlock().equals(FakeOres.fd_redobsidian) && world.getBlockState(new BlockPos(x, y + 1, z - 2)).getBlock().equals(FakeOres.fd_redobsidian) && world.getBlockState(new BlockPos(x, y + 2, z - 2)).getBlock().equals(FakeOres.fd_redobsidian) && world.getBlockState(new BlockPos(x, y + 3, z - 2)).getBlock().equals(FakeOres.fd_redobsidian) && world.getBlockState(new BlockPos(x, y + 1, z + 1)).getBlock().equals(FakeOres.fd_redobsidian) && world.getBlockState(new BlockPos(x, y + 2, z + 1)).getBlock().equals(FakeOres.fd_redobsidian) && world.getBlockState(new BlockPos(x, y + 3, z + 1)).getBlock().equals(FakeOres.fd_redobsidian) && world.getBlockState(new BlockPos(x, y + 4, z - 1)).getBlock().equals(FakeOres.fd_redobsidian) && world.getBlockState(new BlockPos(x, y + 4, z)).getBlock().equals(FakeOres.fd_redobsidian))
            {
                for(int i = 0; i < 3; i++)
                {
                    world.setBlockState(new BlockPos(x, y + 1 + i, z), FakeOres.fd_portal.getDefaultState());
                    world.setBlockState(new BlockPos(x, y + 1 + i, z - 1), FakeOres.fd_portal.getDefaultState());
                }
                if(!player.capabilities.isCreativeMode)
                {
                    stack.stackSize--;
                }
                return true;
            }

            if(world.getBlockState(new BlockPos(x, y, z)).getBlock().equals(FakeOres.fd_redobsidian) && world.getBlockState(new BlockPos(x, y, z + 1)).getBlock().equals(FakeOres.fd_redobsidian) && world.getBlockState(new BlockPos(x, y + 1, z + 2)).getBlock().equals(FakeOres.fd_redobsidian) && world.getBlockState(new BlockPos(x, y + 2, z + 2)).getBlock().equals(FakeOres.fd_redobsidian) && world.getBlockState(new BlockPos(x, y + 3, z + 2)).getBlock().equals(FakeOres.fd_redobsidian) && world.getBlockState(new BlockPos(x, y + 1, z - 1)).getBlock().equals(FakeOres.fd_redobsidian) && world.getBlockState(new BlockPos(x, y + 2, z - 1)).getBlock().equals(FakeOres.fd_redobsidian) && world.getBlockState(new BlockPos(x, y + 3, z - 1)).getBlock().equals(FakeOres.fd_redobsidian) && world.getBlockState(new BlockPos(x, y + 4, z + 1)).getBlock().equals(FakeOres.fd_redobsidian) && world.getBlockState(new BlockPos(x, y + 4, z)).getBlock().equals(FakeOres.fd_redobsidian))
            {
                for(int i = 0; i < 3; i++)
                {
                    world.setBlockState(new BlockPos(x, y + 1 + i, z), FakeOres.fd_portal.getDefaultState());
                    world.setBlockState(new BlockPos(x, y + 1 + i, z + 1), FakeOres.fd_portal.getDefaultState());
                }
                if(!player.capabilities.isCreativeMode)
                {
                    stack.stackSize--;
                }
                return true;
            }
        }
        if(world.isRemote)
        {
            world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, x, y, z, hitX, hitY, hitZ);
        }
        return false;
    }
}