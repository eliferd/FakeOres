package fr.elias.fakeores.common;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemSpawnShield extends Item 
{
	public ItemSpawnShield()
	{
		super();
	}
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player)
	{
		double d = MathHelper.floor_double(world.getSpawnPoint().posX);
		double d1 = world.getTopSolidOrLiquidBlock(world.getSpawnPoint().posX, world.getSpawnPoint().posZ);
		double d2 = MathHelper.floor_double(world.getSpawnPoint().posZ);
		player.setPositionAndUpdate(d, d1, d2);
		itemstack.stackSize--;
		return itemstack;
	}
}
