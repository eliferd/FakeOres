package fr.elias.fakeores.common;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.StatCollector;

public class AntiOreStoneDamageSource extends DamageSource {

	protected AntiOreStoneDamageSource(String par1Str) {
		super(par1Str);
		this.setDamageBypassesArmor();
	}
    public IChatComponent getDeathMessage(EntityLivingBase p_151519_1_)
    {
        EntityLivingBase entitylivingbase1 = p_151519_1_.func_94060_bK();
        String s = "deathMessage." + this.damageType;
        String s1 = s + ".player";
        return entitylivingbase1 != null && StatCollector.canTranslate(s1) ? new ChatComponentTranslation(s1, new Object[] {p_151519_1_.getDisplayName(), entitylivingbase1.getDisplayName()}): new ChatComponentTranslation(s, new Object[] {p_151519_1_.getDisplayName()});
    }
}
