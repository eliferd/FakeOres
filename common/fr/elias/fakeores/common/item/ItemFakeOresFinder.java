package fr.elias.fakeores.common.item;

import fr.elias.fakeores.common.FakeOres;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemFakeOresFinder extends Item
{
    public ItemFakeOresFinder()
    {
        super();
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player)
    {
        for(int x = MathHelper.floor_double(player.posX) - 6; x < MathHelper.floor_double(player.posX) + 6; x++)
        {
            for(int y = MathHelper.floor_double(player.posY) - 6; y < MathHelper.floor_double(player.posY) + 6; y++)
            {
                for(int z = MathHelper.floor_double(player.posZ) - 6; z < MathHelper.floor_double(player.posZ) + 6; z++)
                {
                    if(world.getBlockState(new BlockPos(x, y, z)).getBlock() == FakeOres.fakeOreVanilla)
                    {
                        player.addChatMessage(new ChatComponentText("[Fake Ores Finder] \247cFound fake ore here : \247fx:\247b" + x + "\247f, y:\247b" + y + "\247f, z:\247b" + z));
                    }
                }
            }
        }
        return itemstack;
    }
}