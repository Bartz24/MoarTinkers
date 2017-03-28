package com.bartz24.moartinkers.traits;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import slimeknights.tconstruct.library.traits.AbstractTraitLeveled;

public class TraitInstantDeath extends AbstractTraitLeveled {

	public TraitInstantDeath(int levels) {
		super("instantdeath", String.valueOf(levels), 0x30FF37, 4, levels);
	}

	@Override
	public void afterHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damageDealt,
			boolean wasCritical, boolean wasHit) {
		if (wasHit && !player.world.isRemote) {
			if (player.world.rand.nextFloat() < 0.03f / levels)
				player.attackEntityFrom(new DamageSource("instantdeathback").setDamageIsAbsolute().setDamageBypassesArmor(),
						Integer.MAX_VALUE);
			if (player.world.rand.nextFloat() < 0.1f * levels && target.isNonBoss())
				target.attackEntityFrom(new DamageSource("instantdeath").setDamageIsAbsolute().setDamageBypassesArmor(),
						Integer.MAX_VALUE);
		}
	}
}
