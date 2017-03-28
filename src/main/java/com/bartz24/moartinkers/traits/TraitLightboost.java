package com.bartz24.moartinkers.traits;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.player.PlayerEvent;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitLightboost extends AbstractTrait {

	public TraitLightboost() {
		super("lightboost", 0xFFFF73);
	}

	@Override
	public void miningSpeed(ItemStack tool, PlayerEvent.BreakSpeed event) {

		if (!event.getEntityPlayer().world.isRemote) {
			event.setNewSpeed(event.getNewSpeed() * (0.5f + (float) event.getEntity().world
					.getLightFromNeighbors(new BlockPos((int) event.getEntityPlayer().posX,
							(int) event.getEntityPlayer().posY, (int) event.getEntityPlayer().posZ))
					* 0.3f));
		}
	}

	@Override
	public float damage(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, float newDamage,
			boolean isCritical) {
		if (!player.world.isRemote) {
			return newDamage * (0.5f + (float) player.world
					.getLightFromNeighbors(new BlockPos((int) player.posX, (int) player.posY, (int) player.posZ)) / 15f
					* 2.3f);
		}
		return newDamage;
	}
}
