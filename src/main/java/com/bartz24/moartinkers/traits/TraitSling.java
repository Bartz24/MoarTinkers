package com.bartz24.moartinkers.traits;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitSling extends AbstractTrait {

	public TraitSling() {
		super("sling", 0x292929);
	}

	@Override
	public float damage(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, float newDamage,
			boolean isCritical) {
		return 0;
	}

	@Override
	public float knockBack(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage,
			float knockback, float newKnockback, boolean isCritical) {
		return 10f;
	}
}
