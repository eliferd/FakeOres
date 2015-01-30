package fr.elias.fakeores.common.item;

import fr.elias.fakeores.common.FakeOres;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemBlurkArmor extends ItemArmor
{

    public ItemBlurkArmor(ArmorMaterial material, int type)
    {
        super(material, 0, type);
        setCreativeTab(FakeOres.fakeOresTab);
    }

    @Override
    public String getArmorTexture(ItemStack itemstack, Entity entity, int slot, String type)
    {
        if(slot == 2)
        {
            return "fakeores:models/armor/blurk_layer_2.png";
        }
        else
        {
            return "fakeores:models/armor/blurk_layer_1.png";
        }
    }

    @Override
    public boolean getIsRepairable(ItemStack p_82789_1_, ItemStack p_82789_2_)
    {
        return false;
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemstack)
    {
        if(player.getCurrentArmor(0) != null && player.getCurrentArmor(1) != null && player.getCurrentArmor(2) != null && player.getCurrentArmor(3) != null)
        {
            player.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 20, 0));
            if(world.rand.nextInt(150) == 0)
            {
                itemstack.damageItem(1, player);
            }
        }
        else
        {
            player.clearActivePotions();
        }
    }
}
