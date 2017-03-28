package com.bartz24.moartinkers.traits;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitPayback extends AbstractTrait {

	public TraitPayback() {
		super("payback", 0xFF4545);
	}

	@Override
	public float damage(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, float newDamage,
			boolean isCritical) {
		return (player.getHealth() / player.getMaxHealth() <= 0.2f ? 3f : 1f) * newDamage;
	}
}
