package fr.elias.fakeores.common.item;

import fr.elias.fakeores.common.entity.EntityOresBoss;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemFragmentBoss extends Item
{
    public ItemFragmentBoss()
    {
        super();
    }

    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
    {
        par3List.add("MAKE SURE YOU'RE IN A SAFE AREA TO SPAWN ORE BOSS !");
        super.addInformation(par1ItemStack, par2EntityPlayer, par3List, par4);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack par1ItemStack)
    {
        return true;
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        stack.stackSize--;
        if(world.isRemote)
        {
            return true;
        }
        else
        {
            EntityOresBoss boss = new EntityOresBoss(world);
            boss.setLocationAndAngles(x + 0.5D, y + 0.5D, z + 0.5D, MathHelper.wrapAngleTo180_float(world.rand.nextFloat() * 360.0F), 0.0F);
            world.spawnEntityInWorld(boss);
            return true;
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack par1ItemStack)
    {
        return EnumRarity.EPIC;
    }
}