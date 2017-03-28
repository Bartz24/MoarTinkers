package com.bartz24.moartinkers.traits;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitHealer extends AbstractTrait {

	public TraitHealer() {
		super("healer", 0xFF4F4F);
	}

	@Override
	public float damage(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, float newDamage,
			boolean isCritical) {
		target.heal(newDamage);
		return -newDamage;
	}
}

