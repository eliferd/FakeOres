package fr.elias.fakeores.common.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemSpawnShield extends Item
{
    public ItemSpawnShield()
    {
        super();
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player)
    {
        double d = MathHelper.floor_double(world.getSpawnPoint().getX());
        BlockPos d1 = world.getTopSolidOrLiquidBlock(new BlockPos(world.getSpawnPoint().getX(), 0, world.getSpawnPoint().getZ()));
        double d2 = MathHelper.floor_double(world.getSpawnPoint().getZ());
        player.setPositionAndUpdate(d, d1.getY(), d2);
        itemstack.stackSize--;
        return itemstack;
    }
}
