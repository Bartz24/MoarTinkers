package com.bartz24.moartinkers.traits;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.item.ItemStack;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitShock extends AbstractTrait {
	public TraitShock() {
		super("shock", 0xFFFF4F);
	}

	@Override
	public void afterHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damageDealt,
			boolean wasCritical, boolean wasHit) {
		if (!player.world.isRemote && wasHit && random.nextFloat() <= 0.2f) {
			EntityLightningBolt lightning = new EntityLightningBolt(player.getEntityWorld(), target.getPosition().getX(),
					target.getPosition().getY(), target.getPosition().getZ(), false);
			player.getEntityWorld().addWeatherEffect(lightning);
		}
	}
}
