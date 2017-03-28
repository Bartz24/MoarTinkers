package com.bartz24.moartinkers.traits;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitDarkness extends AbstractTrait {

	public TraitDarkness() {
		super("darkness", 0x3B3B3B);
	}

	@Override
	public void afterHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damageDealt,
			boolean wasCritical, boolean wasHit) {
		if (!player.world.isRemote && wasHit && random.nextFloat() <= 0.3f) {
			target.addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, 200));
			target.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 200));
		}
	}
}
