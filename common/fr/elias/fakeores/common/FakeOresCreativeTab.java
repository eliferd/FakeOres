package fr.elias.fakeores.common;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class FakeOresCreativeTab extends CreativeTabs {

	public FakeOresCreativeTab(String label) {
		super(label);
		// TODO Auto-generated constructor stub
	}
    @SideOnly(Side.CLIENT)
    public Item getTabIconItem()
    {
        return FakeOres.antiOresBlade;
    }
}
