package fr.elias.fakeores.common.item;

import fr.elias.fakeores.common.entity.EntityOres;
import fr.elias.fakeores.common.entity.EntityOresBoss;

import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.lwjgl.input.Keyboard;

public class ItemNeutralOrb extends Item
{
    public ItemNeutralOrb()
    {
        super();
        maxStackSize = 1;
        setMaxDamage(30);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List list, boolean p_77624_4_)
    {
        if(Keyboard.isKeyDown(Keyboard.KEY_RSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_LSHIFT))
        {
            list.add("Just hold item in your hand");
            list.add("and any entity you want to kill.");
            list.add("\247cDoesn't work with fake ores and Ore Boss.");
        }
        else
        {
            list.add("Press 'SHIFT' for more information.");
        }
    }

    @Override
    public boolean hitEntity(ItemStack itemstack, EntityLivingBase entityTarget, EntityLivingBase playerEntity)
    {
        itemstack.damageItem(2, playerEntity);
        EntityPlayer player = (EntityPlayer)playerEntity;
        if(!(entityTarget instanceof EntityOres) && !(entityTarget instanceof EntityOresBoss))
        {
            entityTarget.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer)playerEntity), Float.MAX_VALUE);
        }
        return true;
    }
}
