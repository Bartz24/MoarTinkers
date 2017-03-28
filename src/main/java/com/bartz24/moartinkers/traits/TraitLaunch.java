package com.bartz24.moartinkers.traits;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitLaunch extends AbstractTrait {
	public TraitLaunch() {
		super("launch", 0x7AFF85);
	}

	@Override
	public void afterHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damageDealt,
			boolean wasCritical, boolean wasHit) {
		if (!player.world.isRemote && wasHit && random.nextFloat() <= 0.3f) {
			target.motionY += 2f;
		}
	}
}
